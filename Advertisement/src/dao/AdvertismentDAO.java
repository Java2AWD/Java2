package dao;
import java.util.Collection;

import domain.Ad;
public interface AdvertismentDAO {

	Ad getById(int id);
	
	void save(Ad ad);
	
	void update(Ad ad);
	
	void deleteById(int id);
	
	Collection getAllAds();
}
