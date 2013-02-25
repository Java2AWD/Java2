package dao;

import java.sql.SQLException;
import java.util.Date;

import junit.framework.Assert;

import org.junit.Test;

import domain.User;

public class UserDAOHibernateImplTest {
	@Test
	public void createUserTest(){
		User testUser = new User();
		testUser.setName("volk");
		testUser.setPassword("les");
		testUser.setEmail("volk@begilesbegi.com");
		testUser.setUserDescription("Run! Forest! Run!");
		
		UserDAOHibernateImpl dao = new UserDAOHibernateImpl();
		try {
			dao.createUser(testUser);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertNotNull(dao.getUserByEmail("volk@begilesbegi.com"));
	}
	@Test
	public void getUserByIdTest(){
		UserDAOHibernateImpl dao = new UserDAOHibernateImpl();
		Assert.assertNotNull(dao.getUserById(1));
	}
	@Test
	public void getUserByEmailTest(){
		UserDAOHibernateImpl dao = new UserDAOHibernateImpl();
		Assert.assertNotNull(dao.getUserByEmail("volk@begilesbegi.com"));
	}
	@Test
	public void removeUserTest(){
		UserDAOHibernateImpl dao = new UserDAOHibernateImpl();
		
		User user = new User();
		user.setName("Vasilij");
		user.setPassword("Pupkin");
		user.setEmail("user@to.remove");
		String user_description = new Date().toString();
		user.setUserDescription(user_description);
		try {
			dao.createUser(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertTrue(dao.removeUser(dao.getUserByEmail("user@to.remove").getUserId()));
	}
	@Test
	public void updateUserTest(){
		UserDAOHibernateImpl dao = new UserDAOHibernateImpl();
		User user = dao.getUserById(1);
		// Update record with current time to make sure there is a difference.
		String user_description = new Date().toString();
		user.setUserDescription(user_description);
		dao.updateUser(user);
		User newUser = dao.getUserById(1);
		Assert.assertTrue(newUser.getUserDescription().equals(user_description.toString()));
	}
}
