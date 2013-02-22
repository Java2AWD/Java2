package dao;

import domain.User;

public interface UserDAO {
	/**
	 * Create user in database.
	 * @param username - username for user
	 * @param password - password for user (should be hashed with MD5)
	 * @param userDescription - description of a user.
	 * @return user id number from database, null if creation failed.
	 */
	public int createUser(String username, String password, String userDescription);
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
	 * Gets user from database by user name.
	 * @param name - user name.
	 * @return - User object on success or null on fail.
	 */
	public User getUserByName(String name);
	/**
	 * Remove user from database by it`s user id.
	 * @param id - id number of user.
	 * @return - true if success, false if deletion failed.
	 */
	public boolean removeUser(int id);
}
