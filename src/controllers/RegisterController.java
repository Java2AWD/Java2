package controllers;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import models.IModel;
import models.UserModel;
import dao.UserDAO;
import dao.UserDAOHibernateImpl;


public class RegisterController implements IController {

	@Override
	public void execute(IModel model, HttpServletRequest request) {

		UserModel registerModel = (UserModel) model;
		String requestMethod = request.getMethod();

		if (requestMethod.equals("POST")) {
			
			if (validateModel(registerModel)) {

				UserDAO userDao = new UserDAOHibernateImpl();
					try {
						userDao.createUser(registerModel.user);
					} catch (SQLException e) {
						e.printStackTrace();
					}	
			}
		} else {
			// Get request
		}
	}

	public boolean validateModel(UserModel model) {

		boolean isValid = true;

		String username = model.user.getName();
		String password = model.user.getPassword();
		
		if (username == null || username.isEmpty()) {
			model.setErrorMessages("username", "Username is empty");
			isValid = false;
		} else {
			if (password == null || password.isEmpty()) {
				model.setErrorMessages("password", "Password is empty");
				isValid = false;
			} else if (password.length() < 4) {
				model.setErrorMessages("password", "Password is too short");
				isValid = false;
			}
		}
		
		return isValid;
	}

	@Override
	public String getRedirectUrl() {
		// TODO Auto-generated method stub
		return null;
	}

}
