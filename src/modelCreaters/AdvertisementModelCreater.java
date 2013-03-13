package modelCreaters;

import javax.servlet.http.HttpServletRequest;

import models.AdvertismentModel;
import models.IModel;

public class AdvertisementModelCreater extends ModelCreater {

	public IModel createModel(HttpServletRequest request) {
		String user_id = request.getParameter("user_id");
		String category_id = request.getParameter("category_id");
		AdvertismentModel model = new AdvertismentModel();
		Integer.parseInt(user_id);
		Integer.parseInt(category_id);
		return model;
	}

}
