package domain;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Ad {

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
	private User user;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
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
	private int adId;
	private String message;
	private Date date;
	private int user_id;
	private int category_id;
	private Set<Ad> ads = new HashSet<Ad>();
	
	public Set<Ad> getAds() {
		return ads;
	}
	public void setAds(Set<Ad> ads) {
		this.ads = ads;
	}

}
