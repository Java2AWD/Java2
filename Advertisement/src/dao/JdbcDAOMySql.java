package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcDAOMySql {

	protected Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your MySQL JDBC Driver?");
			e.printStackTrace();
		}

		try {

			Connection con = DriverManager.getConnection(
					
					// Sjuda piwem Login i parolj na BD Mysql
					// Mozet bytj jest smysl vsem sdelatj polzovatelja s takimize username i parolem.
					"jdbc:mysql://localhost:3306/Ad","root", "siemens");
			return con;
		} catch(SQLException e) {
			throw new RuntimeException("Can not get DB connection", e);
		}
			
	}
	
}
