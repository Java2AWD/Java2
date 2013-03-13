package mvc.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import dao.UserDAOHibernateImpl;
import domain.User;

import mvc.models.IModel;
import mvc.models.LoginModel;

public class LoginController implements Controller {

	@Override
	public void execute(IModel model, HttpServletRequest request) {

		LoginModel loginModel = (LoginModel) model;
		String username = loginModel.getUsername();
		String password = loginModel.getPassword();

		if (username != null || password != null) {
			
			if (username == "" || password == "") {
				loginModel.setErrorMessages("error", "Please fill in all fields");
			} else {
				UserDAO userDB = new UserDAOHibernateImpl();
				
				if (userDB.authorized(username, password))
				{
					loginModel.setErrorMessages("logged", "Logged");
					HttpSession userSession = request.getSession();
					userSession.setAttribute("username", username);
				} else {
					loginModel.addWarning("error", "Invalid username or password");
				}
				
			}
		}
	}

}