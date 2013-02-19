package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcDAO {

	protected Connection getConnection() {
		try {
			Class.forName("org.hsqldb.jdbcDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {

			Connection con = DriverManager.getConnection(
				"jdbc:hsqldb:hsql://localhost", "SA", "");
			return con;
		} catch(SQLException e) {
			throw new RuntimeException("Can not get DB connection", e);
		}
			
	}
	
}
