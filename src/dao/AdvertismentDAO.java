package dao;


import java.util.List;

import domain.Ad;

public interface AdvertismentDAO {

	Ad getById(int id);

	int create(Ad ad);

	void update(Ad ad);

	void deleteById(int id);

	List<Ad> getAllMessagesByUserId(int user_id);

	List<Ad> getAllMessagesByCategoryId(int category_id);

}
