package dao;

import java.util.Date;

import junit.framework.Assert;

import org.junit.Test;

import domain.User;

public class UserDAOJDBCImplTest {
	@Test
	public void createUserTest(){
		User testUser = new User();
		testUser.setName("volk");
		testUser.setPassword("les");
		testUser.setEmail("volk@begilesbegi.com");
		testUser.setUserDescription("Run! Forest! Run!");
		
		UserDAOJDBCImpl dao = new UserDAOJDBCImpl();
		dao.createUser(testUser);
		Assert.assertNotNull(dao.getUserByEmail("volk@begilesbegi.com"));
	}
	@Test
	public void getUserByIdTest(){
		UserDAOJDBCImpl dao = new UserDAOJDBCImpl();
		Assert.assertNotNull(dao.getUserById(1));
	}
	@Test
	public void getUserByEmailTest(){
		UserDAOJDBCImpl dao = new UserDAOJDBCImpl();
		Assert.assertNotNull(dao.getUserByEmail("volk@begilesbegi.com"));
	}
	@Test
	public void removeUserTest(){
		UserDAOJDBCImpl dao = new UserDAOJDBCImpl();
		
		User user = new User();
		user.setName("Vasilij");
		user.setPassword("Pupkin");
		user.setEmail("user@to.remove");
		user.setUserDescription("As big as kilimanjaro...");
		dao.createUser(user);
		Assert.assertTrue(dao.removeUser(dao.getUserByEmail("user@to.remove").getUserId()));
	}
	@Test
	public void updateUserTest(){
		UserDAOJDBCImpl dao = new UserDAOJDBCImpl();
		User user = dao.getUserById(1);
		// Update record with current time to make sure there is a difference.
		String user_description = new Date().toString();
		user.setUserDescription(user_description);
		dao.updateUser(user);
		User newUser = dao.getUserById(1);
		Assert.assertTrue(newUser.getUserDescription().equals(user_description.toString()));
	}
}
