package modelCreaters;

import javax.servlet.http.HttpServletRequest;

import models.IModel;

public abstract class ModelCreater {
public abstract IModel createModel(HttpServletRequest request);
}
