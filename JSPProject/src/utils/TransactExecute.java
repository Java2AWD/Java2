package utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;




public class TransactExecute {

	public void executeTransact (TaskExecute task)
	{
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
			task.execute();
			session.getTransaction().commit();
			session.close();
		
	}
	public SessionFactory getCurrentSession ()
	{
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		return sessionFactory;
	}
}
