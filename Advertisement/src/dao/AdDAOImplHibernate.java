package dao;

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
		te.executeTransact(task);
		SessionFactory sessionFactory = te.getCurrentSession();
		te.getCurrentSession().openSession().save(ad);
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

}
