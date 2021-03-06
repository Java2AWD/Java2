package dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import javax.management.RuntimeErrorException;




import domain.Ad;

public class AdDAOImpl extends JdbcDAOMySql implements  AdvertismentDAO {

	@Override
	public Ad getById(int id) {
		Ad ad = new Ad();
		try {
		Connection con = getConnection();
		PreparedStatement prepState = con.prepareStatement("select Advertisement_id, message, date, users_id, category_id from Advertisment" + "where advertisement_id ?");
		prepState.setLong(1, id);
		ResultSet rs = prepState.executeQuery();
		rs.next();
		ad.setAdId(rs.getInt(1));
		ad.setMessage(rs.getString(2));
		ad.setDate(rs.getDate(3));
		ad.setUsers_id(rs.getInt(4));
		ad.setCategory_id(rs.getInt(5));
	
		con.close();
		prepState.close();
		rs.close();
		return ad;
		} catch (SQLException e){
			throw new RuntimeException (" Can`t get data from DB ", e);}
		
	}

	@Override
	public int create(Ad ad) {
		
		try{
		Connection con = getConnection();
		PreparedStatement prepState = con.prepareStatement
				("inset into Advertisment (advertisement_id, message, date, users_id, category_id )"
						+ "values (?,?,curdate(),?,?)" );
		prepState.setLong(1, ad.getAdId());
		prepState.setString(2, ad.getMessage());
		//prepState.setDate(3, (Date) ad.getDate());
		prepState.setLong(4, ad.getUsers_id());
		prepState.setLong(5, ad.getCategory_id());
		prepState.executeQuery();
		
		ResultSet rs = prepState.getGeneratedKeys();
		rs.next();
		int id =rs.getInt(1);
		ad.setAdId(rs.getInt(id));
		
		con.close();
		prepState.close();
		rs.close();
		
		}catch (SQLException e) {
			throw new RuntimeException ("Cant save data in DB",e);
		}
		return 0;
		
	}

	@Override
	public void update(Ad ad) {
		try{
		Connection con = getConnection();
			PreparedStatement prepState = 	con.prepareStatement("update Advertisement set advertisement_id =?, set message= ?, set date= ?, set users_id =?, set category_id= ? where pk = ? ");
		
			prepState.setLong(1, ad.getAdId());
			prepState.setString(2, ad.getMessage());
			prepState.setDate(3, (Date) ad.getDate());
			prepState.setLong(4, ad.getUsers_id());
			prepState.setLong(5, ad.getCategory_id());
			
			prepState.executeQuery();
		
		
		}catch(SQLException e) { throw new RuntimeException (" ", e );}
	}

	@Override
	public void deleteById(int id) {
		try
		{
		Connection con = getConnection();
		PreparedStatement prepState = con.prepareStatement("delete from users where pk = ?");
		prepState.setInt(1, id);
		con.close();
		prepState.close();
			
		}catch (SQLException e) {
			throw new RuntimeException("Can`t delete data from DB", e);}
		
	}

	

	@Override
	public List<Ad> getAllMessagesByUserId(int user_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ad> getAllMessagesByCategoryId(int category_id) {
		// TODO Auto-generated method stub
		return null;
	}

}
