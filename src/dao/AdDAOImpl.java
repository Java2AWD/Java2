package dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.management.RuntimeErrorException;

import com.sun.corba.se.spi.presentation.rmi.PresentationDefaults;



import domain.Ad;

public class AdDAOImpl extends JdbcDAO implements  AdvertismentDAO {

	@Override
	public Ad getById(Long id) {
		Ad ad = new Ad();
		try {
		Connection con = getConnection();
		
		PreparedStatement prepState = con.prepareStatement("select Advertisement_id, message, date, users_id, category_id from Advertisment" + "where advertisement_id ?");
		prepState.setLong(1, id);
		ResultSet rs = prepState.executeQuery();
		rs.next();
		ad.setAdId(rs.getLong(1));
		ad.setMessage(rs.getString(2));
		ad.setDate(rs.getDate(3));
		ad.setUsers_id(rs.getLong(4));
		ad.setCategory_id(rs.getLong(5));
	
		con.close();
		prepState.close();
		rs.close();
		return ad;
		} catch (SQLException e){
			throw new RuntimeException (" Can`t get data from DB ", e);}
		
	}

	@Override
	public void save(Ad ad) {
		
		try{
		Connection con = getConnection();
		PreparedStatement prepState = con.prepareStatement
				("inset into Advertisment (advertisement_id, message, date, users_id, category_id )"
						+ "values (?,?,?,?,?)" );
		prepState.setLong(1, ad.getAdId());
		prepState.setString(2, ad.getMessage());
		prepState.setDate(3, (Date) ad.getDate());
		prepState.setLong(4, ad.getUsers_id());
		prepState.setLong(5, ad.getCategory_id());
		prepState.executeQuery();
		
		ResultSet rs = prepState.getGeneratedKeys();
		rs.next();
		long id =rs.getLong(1);
		ad.setAdId(rs.getLong((int) id));
		
		con.close();
		prepState.close();
		rs.close();
		
		}catch (SQLException e) {
			throw new RuntimeException ("Cant save data in DB",e);
		}
		
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
	public void deleteById(Long id) {
		try
		{
		Connection con = getConnection();
		PreparedStatement prepState = con.prepareStatement("delete from users where pk = ?");
		prepState.setLong(1, id);
		con.close();
		prepState.close();
			
		}catch (SQLException e) {
			throw new RuntimeException("Can`t delete data from DB", e);}
		
	}

}
