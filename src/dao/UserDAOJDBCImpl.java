package dao;

import domain.User;

public class UserDAOJDBCImpl extends JdbcDAOMySql implements UserDAO{

	@Override
	public int createUser(String username, String password,
			String userDescription) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeUser(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
