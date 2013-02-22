package dao;

import java.sql.SQLException;

import domain.User;

public interface UserDAO {
	/**
	 * Create user in database.
	 * @param user User object to insert into database.
	 * @return user id number from database, null if creation failed.
	 */
	public void createUser(User user) throws SQLException;
	/**
	 * Updates user entry in database.
	 * @param user modified User object to save. 
	 * WARNING: user id should not be modified.
	 */
	public void updateUser(User user);
	/**
	 * Gets user from database by user id number.
	 * @param id - id number of user.
	 * @return - User object on success or null on fail.
	 */
	public User getUserById(int id);
	/**
	 * Gets user from database by user email.
	 * @param email - user name.
	 * @return - User object on success or null on fail.
	 */
	public User getUserByEmail(String email);
	/**
	 * Remove user from database by it`s user id.
	 * @param id - id number of user.
	 * @return - true if success, false if deletion failed.
	 */
	public boolean removeUser(int id);
}
