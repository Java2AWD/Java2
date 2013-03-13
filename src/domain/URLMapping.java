package domain;

import interfaces.IController;
import interfaces.ModelCreator;

public class URLMapping {
	
	private String url;
	private ModelCreator modelCreator;
	private IController controller;
	private String jsp;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public ModelCreator getModelCreator() {
		return modelCreator;
	}
	public void setModelCreator(ModelCreator modelCreator) {
		this.modelCreator = modelCreator;
	}
	public IController getController() {
		return controller;
	}
	public void setController(IController controller) {
		this.controller = controller;
	}
	public String getJsp() {
		return jsp;
	}
	public void setJsp(String jsp) {
		this.jsp = jsp;
	}
	
}
