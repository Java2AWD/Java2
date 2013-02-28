package domain;

import java.util.Date;

public class Ad {
	private int adId;
	private String message;
	private Date date;
	private int user_id;
	private int category_id;

	public int getAdId() {
		return adId;
	}
	public void setAdId(int adId) {
		this.adId = adId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String info) {
		this.message = info;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getUsers_id() {
		return user_id;
	}
	public void setUsers_id(int users_id) {
		this.user_id = users_id;
	}
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	

}
