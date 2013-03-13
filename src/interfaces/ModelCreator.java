package interfaces;

import javax.servlet.http.HttpServletRequest;

public abstract class ModelCreator {
	public abstract IModel createModel(HttpServletRequest req);
}
