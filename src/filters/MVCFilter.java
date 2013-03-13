package filters;

import interfaces.IController;
import interfaces.IModel;
import interfaces.ModelCreator;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.LoginModelCreator;
import controllers.LoginController;
import domain.URLMapping;

/**
 * Servlet Filter implementation class MVCFilter
 */
@WebFilter("/MVCFilter")
public class MVCFilter implements Filter {

	private Map<String, URLMapping> mapping;

	public MVCFilter() {

		mapping = new HashMap<String, URLMapping>();

		URLMapping paymentOrder = new URLMapping();
		paymentOrder.setUrl("/board/login");
		paymentOrder.setModelCreator(new LoginModelCreator());
		paymentOrder.setController(new LoginController());
		paymentOrder.setJsp("jsp/login.jsp");

		mapping.put(paymentOrder.getUrl(), paymentOrder);
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest httpReq = (HttpServletRequest) request;
		String url = httpReq.getRequestURI().toString();
		URLMapping urlMapping = mapping.get(url);

		if (urlMapping == null) {
			chain.doFilter(request, response);
		} else if (urlMapping.getModelCreator() == null) {
			((HttpServletResponse) response)
					.sendError(HttpServletResponse.SC_NOT_FOUND);
		} else {
			
			ModelCreator modelCreator = urlMapping.getModelCreator();
			IModel model = modelCreator.createModel(httpReq);
			IController controller = urlMapping.getController();
			httpReq.setAttribute("model", model);
			httpReq.setAttribute("error_messages", model.getErrorMessages());
			
			RequestDispatcher view = request.getRequestDispatcher(urlMapping.getJsp());
			
			if (model.getErrorMessages().isEmpty()){
				model = controller.execute(model);
				request.setAttribute("info", "Payment processed. Confirmation email has been sent.");
				view.forward(request, response);
			} else {
				request.setAttribute("info", "Check your input for errors!");
				view.forward(request, response);
			}
			
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}
}
