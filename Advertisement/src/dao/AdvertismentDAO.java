package dao;
import domain.Ad;
public interface AdvertismentDAO {

	Ad getById(int id);
	
	void save(Ad ad);
	
	void update(Ad ad);
	
	void deleteById(int id);
}
