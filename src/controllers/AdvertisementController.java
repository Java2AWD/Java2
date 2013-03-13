package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import models.AdvertismentModel;
import models.IModel;
import dao.AdDAOImplHibernate;
import dao.AdvertismentDAO;

public class AdvertisementController extends ControllerBase {

	// print all messages by user ID
	@Override
	public void execute(IModel model, HttpServletRequest request) {
		String requestMethod = request.getMethod();
		AdvertismentModel adsModel = (AdvertismentModel) model;
		HttpSession userSession = request.getSession();
		if(requestMethod.equals("POST"))
		{
			AdvertismentDAO dao = new AdDAOImplHibernate();
			adsModel.setAdsList(dao.getAllMessagesByUserId(adsModel.getUser_id()));
			userSession.setAttribute("model", adsModel);
		}
	}
	

}
