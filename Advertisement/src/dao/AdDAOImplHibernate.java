package dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import utils.HibernateUtil;
import utils.TaskExecute;
import utils.TransactExecute;

import domain.Ad;

public class AdDAOImplHibernate extends HibernateUtil implements
		AdvertismentDAO {

	TaskExecute task = new  TaskExecute() {
		
		@Override
		public void execute() {
			
			
		}
	};
	@Override
	public Ad getById(int id) {

		Session session = getSessionFactory().openSession();
		Ad ad = (Ad) session.get(Ad.class, id);
		session.close();
		return ad;
	}

	@Override
	public void save(Ad ad) {
		
		TransactExecute te = new TransactExecute();
		SessionFactory sessionFactory = te.getCurrentSession();
		sessionFactory.getCurrentSession().save(ad);
			//session.save(ad);
		}
		
	

	@Override
	public void update(Ad ad) {
		Session session = getSessionFactory().openSession();
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
	@Override
public Collection getAllAds()
{
	List ads = new ArrayList<Ad>();
	Session session =HibernateUtil.getSessionFactory().openSession();
	session.beginTransaction();
	ads = session.createCriteria(Ad.class).list();
	if(session!=null && session.isOpen())
	{
		session.close();
	}
	
	return ads;
}
}
