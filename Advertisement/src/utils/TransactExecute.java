package utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;




public class TransactExecute {

	public void executeTransact (TaskExecute task)
	{
		SessionFactory sessionFactory =	HibernateUtil.getSessionFactory();
	
		Session session = sessionFactory.openSession();
		Transaction trans =	session.beginTransaction();
			task.execute();
			trans.commit();
			session.close();
	}
	public SessionFactory getCurrentSession ()
	{
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		return sessionFactory;
	}
}
