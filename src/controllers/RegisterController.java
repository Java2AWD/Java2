package mvc.controllers;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import dao.UserDAO;
import dao.UserDAOHibernateImpl;

import mvc.models.IModel;
import mvc.models.RegisterModel;

public class RegisterController  implements Controller {

	@Override
	public void execute(IModel model, HttpServletRequest request) {

		RegisterModel registerModel = (RegisterModel) model;
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

	public boolean validateModel(RegisterModel model) {

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
}
