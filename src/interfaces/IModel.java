package interfaces;

import java.util.Map;

public interface IModel {
	
	public void setErrorMessages(Map<String, String> errorMessages);
	
	public Map<String, String> getErrorMessages();
}
