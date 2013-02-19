package dao;
import domain.Ad;
public interface AdvertismentDAO {

	Ad getById(Long id);
	
	void save(Ad ad);
	
	void update(Ad ad);
	
	void deleteById(Ad ad);
}
