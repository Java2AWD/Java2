package filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utils.TaskExecute;
import utils.TransactExecute;


@WebFilter("/HibernateInitFilter")
public class HibernateInitFilter implements Filter {

	TransactExecute te = new TransactExecute();
	
	public void doFilter( final ServletRequest request,  final ServletResponse response,
			final FilterChain chain) throws IOException, ServletException {
		TaskExecute task = new TaskExecute() {
			
			@Override
			public void execute() {
			try {
				chain.doFilter(request, response);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			}
			
			
		}; 	
	
		te.executeTransact(task);
		
		
		/*
			if (!((HttpServletRequest) request).getRequestURI().matches(".*css|.*font.*|.*js|.*images.*")) {
				 
					((HttpServletResponse) response).sendRedirect("/");
				} else {
					te.executeTransact(task);
					
				}	*/
	
	}
	
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
	
	 public HibernateInitFilter() {
	        // TODO Auto-generated constructor stub
	    }

		/**
		 * @see Filter#destroy()
		 */
		public void destroy() {
			// TODO Auto-generated method stub
		}

}
