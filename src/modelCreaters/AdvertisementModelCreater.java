package modelCreaters;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import models.AdvertismentModel;
import models.IModel;

public class AdvertisementModelCreater extends ModelCreater {

	public IModel createModel(HttpServletRequest request) {
		AdvertismentModel model = new AdvertismentModel();
		model.setUser_id(Integer.parseInt(request.getParameter("user_id")));
		model.setCategory_id(Integer.parseInt(request.getParameter("category_id")));
		model.setMessage(request.getParameter("message"));
		model.setDate(new Date());
		
		return model;
	}

}
