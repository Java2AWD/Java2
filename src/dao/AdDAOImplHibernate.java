package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import domain.Ad;

public class AdDAOImplHibernate extends HibernateUtil implements
		AdvertismentDAO {

	@Override
	public Ad getById(int id) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Ad ad = (Ad) session.get(Ad.class, id);
		session.close();
		return ad;
	}

	@Override
	public void save(Ad ad) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		Transaction trans = null;
		try {
			trans = session.beginTransaction();
			session.save(ad);
			trans.commit();
		} catch (HibernateException e) {
			trans.rollback();
			e.printStackTrace();
		}
		session.close();
	}

	@Override
	public void update(Ad ad) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trans = null;
		try {
			trans = session.beginTransaction();
			session.update(ad);
			trans.commit();
		} catch (HibernateException e) {
			trans.rollback();
			e.printStackTrace();
		}
		session.close();
	}

	@Override
	public void deleteById(int id) {
		Ad ad = new Ad();
		ad.setAdId(id);
		Session session = getSessionFactory().openSession();
		Transaction trans = null;
		try {
			trans = session.beginTransaction();
			session.delete(ad);
			trans.commit();
		} catch (HibernateException e) {
			trans.rollback();
			e.printStackTrace();
		}
		session.close();
	}

}