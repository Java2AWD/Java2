package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;



import domain.Ad;

public class AdDAOImpl extends JdbcDAO implements  AdvertismentDAO {

	@Override
	public Ad getById(Long id) {
		Ad ad = new Ad();
		Connection con = getConnection();
		
		
		
		return ad;
	}

	@Override
	public void save(Ad ad) {
		
		
	}

	@Override
	public void update(Ad ad) {
		
		
	}

	@Override
	public void deleteById(Ad ad) {
		
		
	}

}
