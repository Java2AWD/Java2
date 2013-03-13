package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import domain.User;

public class UserDAOJDBCImpl extends JdbcDAOMySql implements UserDAO{

	@Override
	public void createUser(User user) {
		Connection connection = getConnection();
		PreparedStatement statement = null;
		
		try {
			statement = connection.prepareStatement(
					"INSERT INTO users (id, name, password, email, user_description)" +
					"VALUES (0, ?, ?, ?, ?)");
			statement.setString(1, user.getName());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getEmail());
			statement.setString(4, user.getUserDescription());
			
			statement.executeUpdate();
			
			connection.close();
		} catch (SQLException e){
			System.out.println(e);
		} 
	}

	

	@Override
	public void updateUser(User user) {
		Connection connection = getConnection();
		PreparedStatement statement = null;
		try {  
			statement = connection.prepareStatement(
					"UPDATE users SET name = ?, password = ?, email = ?, user_description = ? "+
					"WHERE id = ? LIMIT 1;");
			statement.setString(1, user.getName());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getEmail());
			statement.setString(4, user.getUserDescription());
			statement.setInt(5, user.getUserId());
			
			statement.executeUpdate();
			
			connection.close();
			
		} catch (SQLException e){
			System.out.println(e);
		}
	}

	@Override
	public User getUserById(int id) {
		Connection connection = getConnection();
		PreparedStatement statement = null;
		
		try {
			statement = connection.prepareStatement("SELECT * FROM users WHERE id = " + id);
			ResultSet resultSet = statement.executeQuery();
			resultSet.next();
			
			User user = new User();
			user.setUserId(resultSet.getInt("id"));
			user.setName(resultSet.getString("name"));
			user.setPassword(resultSet.getString("password"));
			user.setEmail(resultSet.getString("email"));
			user.setUserDescription(resultSet.getString("user_description"));
			
			return user;
		} catch (SQLException e){
			System.out.println(e);
		}
		return null;
	}

	@Override
	public User getUserByEmail(String email) {
		Connection connection = getConnection();
		PreparedStatement statement = null;
		
		try {
			statement = connection.prepareStatement("SELECT * FROM users WHERE email = ?");
			statement.setString(1, email);
			ResultSet resultSet = statement.executeQuery();
			resultSet.next();
			User user = new User();
			user.setUserId(resultSet.getInt("id"));
			user.setName(resultSet.getString("name"));
			user.setPassword(resultSet.getString("password"));
			user.setEmail(resultSet.getString("email"));
			user.setUserDescription(resultSet.getString("user_description"));
			
			return user;
		} catch (SQLException e){
			System.out.println(e);
		}
		return null;
	}

	@Override
	public boolean removeUser(int id) {
		Connection connection = getConnection();
		PreparedStatement statement = null;
		
		try {
			statement = connection.prepareStatement("DELETE FROM users WHERE id = " + id);
			statement.executeUpdate();
			return true;
		} catch (SQLException e){
			System.out.println(e);
		}
		return false;
	}



	@Override
	public boolean authorized(String username, String password) {
		// TODO Auto-generated method stub
		return false;
	}
}
