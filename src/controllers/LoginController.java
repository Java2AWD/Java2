package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import dao.UserDAOHibernateImpl;
import domain.User;

import models.IModel;
import models.UserModel;

public class LoginController implements IController {

	@Override
	public void execute(IModel model, HttpServletRequest request) {

		UserModel loginModel = (UserModel) model;
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

	@Override
	public String getRedirectUrl() {
		// TODO Auto-generated method stub
		return null;
	}



}