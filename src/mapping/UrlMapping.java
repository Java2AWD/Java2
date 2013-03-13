package mapping;

import controllers.IController;
import modelCreaters.ModelCreater;

public class UrlMapping {
public ModelCreater getModelCreater() {
		return modelCreater;
	}
	public void setModelCreater(ModelCreater modelCreater) {
		this.modelCreater = modelCreater;
	}
	public IController getController() {
		return controller;
	}
	public void setController(IController controller) {
		this.controller = controller;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getJsp() {
		return jsp;
	}
	public void setJsp(String jsp) {
		this.jsp = jsp;
	}
private ModelCreater modelCreater;
private IController controller;
private String url;
private String jsp;
}
