package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import domain.Ad;


public class AdDAOImplHibernate extends HibernateUtil implements AdvertismentDAO {

	@Override
	public Ad getById(int id) {
	
		Session session = getSessionFactory().openSession();
		Ad ad = (Ad) session.get(Ad.class, id);
		session.close();
		return ad;
	}

	@Override
	public void save(Ad ad) {
		Session session = getSessionFactory().openSession();
		Transaction transaction = null;
		try{ 
	    transaction = session.beginTransaction();
	    session.save(ad);
	    transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		}
	    session.close();	}

	@Override
	public void update(Ad ad) {
		Session session = getSessionFactory().openSession();
		Transaction trans = null;
		try{
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
		
		Session session = getSessionFactory().openSession();
		Transaction trans = null;
		try{
		trans = session.beginTransaction();
		session.delete(id);
		trans.commit();
		} catch (HibernateException e) {
			trans.rollback();
			e.printStackTrace();
		}
		session.close();
		}
		
	
	}

