package domain;

import java.util.Date;

public class Ad {

	public long getAdId() {
		return adId;
	}
	public void setAdId(long adId) {
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
	public long getUsers_id() {
		return user_id;
	}
	public void setUsers_id(long users_id) {
		this.user_id = users_id;
	}
	public long getCategory_id() {
		return category_id;
	}
	public void setCategory_id(long category_id) {
		this.category_id = category_id;
	}
	private long adId;
	private String message;
	private Date date;
	private long user_id;
	private long category_id;
	

}
