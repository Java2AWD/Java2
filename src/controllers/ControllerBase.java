package controllers;

import models.IModel;

public abstract class ControllerBase implements IController {

	protected String redirectUrl = null;
	@Override
	public String getRedirectUrl() {
		// TODO Auto-generated method stub
		return redirectUrl;
	}

	

}
