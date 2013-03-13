package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import domain.Category;

public class CategoryDAOHibernateImpl extends HibernateUtil implements CategoryDAO {

	@Override
	public Category getById(Long id) {
		Session session = getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Category category = (Category) session.get(Category.class, id);
			transaction.commit();
			session.close();
			return category;
		} catch (HibernateException e) {
			System.out.println(e);
		}
		session.close();
		return null;
	}

	@Override
	public void save(Category category) {
		Session session = getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(category);
			transaction.commit();

		} catch (HibernateException e) {
			System.out.println(e);
		}
		session.close();
	}

	@Override
	public void update(Category category) {
		Session session = getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.update(category);
			transaction.commit();
		} catch (HibernateException e) {
			System.out.println(e);
		}
		session.close();
	}

	@Override
	public void deleteById(Long id) {
		Session session = getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Category category = (Category) session.get(Category.class, id);
			session.delete(category);
			transaction.commit();
		} catch (HibernateException e) {
			System.out.println(e);
		}
		session.close();
	}

}
