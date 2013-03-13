package dao;

import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import domain.User;

public class UserDAOHibernateImpl extends HibernateUtil implements UserDAO {

	@Override
	public void createUser(User user) throws SQLException {
		Session session = getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(user);
			transaction.commit();
			
		} catch (HibernateException e) {
			System.out.println(e);
		}
		session.close();
	}

	@Override
	public void updateUser(User user) {
		Session session = getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.update(user);
			transaction.commit();
		} catch (HibernateException e) {
			System.out.println(e);
		}
		session.close();
	}

	@Override
	public User getUserById(int id) {
		Session session = getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			User user = (User) session.get(User.class, id);
			transaction.commit();
			session.close();
			System.out.println(user);
			return user;
		} catch (HibernateException e) {
			System.out.println(e);
		}
		session.close();
		return null;
	}

	@Override
	public User getUserByEmail(String email) {
		Session session = getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			User user = (User) session.createCriteria(User.class)
					.add(Restrictions.eq("email", email))
					.list()
					.get(0);
			transaction.commit();
			session.close();
			System.out.println(user);
			return user;
		} catch (HibernateException e) {
			System.out.println(e);
		}
		session.close();
		return null;
	}

	@Override
	public boolean removeUser(int id) {
		Session session = getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			User user = (User) session.get(User.class, id);
			session.delete(user);
			transaction.commit();
			session.close();
			return true;
		} catch (HibernateException e) {
			System.out.println(e);
		}
		session.close();
		return false;
	}


	@Override
	public boolean authorized(String username, String password) {
		Session session = getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			User user = (User) session.createCriteria(User.class)
					.add(Restrictions.eq("name", username)).list().get(0);	
			
				if(user.getPassword().equals(password)){
					transaction.commit();
					session.close();
					return true;
				}
			session.close();
			return false;		
		} catch (HibernateException e) {
			throw new RuntimeException(" Incorrect password or username ", e);
		}
	}

}
