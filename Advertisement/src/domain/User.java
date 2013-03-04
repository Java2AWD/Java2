package domain;

public class User {
	private int userId;
	private String name;
	private String password;
	private String email;
	private String userDescription;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserDescription() {
		return userDescription;
	}
	public void setUserDescription(String userDescription) {
		this.userDescription = userDescription;
	}
	@Override
	public String toString(){
		return ">> ID - " + this.userId
				+ " Name - " + this.name
				+ " Password - " + this.password
				+ " Email - " + this.email
				+ " Desc. - " + this.userDescription;
	}
	
}