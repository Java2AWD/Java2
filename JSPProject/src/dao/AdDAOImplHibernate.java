package dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
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
	TransactExecute te = new TransactExecute();

	
	
	@Override
	public Ad getById(int id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Ad ad = (Ad) session.get(Ad.class, id);
		return ad;
	}
	
	@Override
	public int  create(Ad ad) {
		int id =0;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			id = (Integer) session.save(ad);
			//session.getTransaction().commit();
			return id;
		}
		
	 

	@Override
	public void update(Ad ad) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.update(ad);
			//session.getTransaction().commit();
	}

	@Override
	public void deleteById(int id) {
		Ad ad = new Ad();
		ad.setAdId(id);
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.delete(ad);	
 /*Query query = session.createQuery("Delete Ad where id =:id");
 query.setInteger("id", id);
 result = query.executeUpdate();
 System.out.println(result);
*/
	}
	


	@Override
	public List<Ad> getAllMessagesByUserId(int user_id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		List<Ad> adsList = new ArrayList<Ad>();
		String hql = "from Ad where user_id =:user_id";
		Query query = session.createQuery(hql);
		query.setInteger("user_id", user_id);
		adsList=query.list();
		return adsList;
		
	}

	@Override
	public List<Ad> getAllMessagesByCategoryId(int category_id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		List<Ad> adsList = new ArrayList<Ad>();
		String hql = "from Ad where category_id =:category_id";
		Query query = session.createQuery(hql);
		query.setInteger("category_id", category_id);
		adsList=query.list();
		//session.getTransaction().commit();
		return adsList;


	}

}