package controllers;

import javax.servlet.http.HttpServletRequest;

import models.IModel;

public interface IController {
	String getRedirectUrl();
	public void execute(IModel model, HttpServletRequest request);
}
