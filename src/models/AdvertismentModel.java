package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import domain.Ad;

public class AdvertismentModel implements IModel {

	private int  id;
	private String message;
	private Date date;
	private int user_id;
	private int category_id;
	private List <Ad> adsList = new ArrayList<Ad>();
	
	public List<Ad> getAdsList() {
		return adsList;
	}
	public void setAdsList(List<Ad> adsList) {
		this.adsList = adsList;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	
	
}
