package modelCreaters;

import javax.servlet.http.HttpServletRequest;

import models.IModel;
import models.UserModel;

public class UserModelCreater extends ModelCreater {

	@Override
	public IModel createModel(HttpServletRequest request) {
		UserModel model = new UserModel();
		model.setEmail(request.getParameter("mail"));
		model.setName(request.getParameter("username"));
		model.setPassword(request.getParameter("password"));
		model.setUserDescription(request.getParameter("description"));
		
		return (IModel) model;
	}

}
