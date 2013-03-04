package utils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.hibernate.SessionFactory;


public class HibernateInitListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    	ServletContext context = event.getServletContext();
    	context.setAttribute("hibernateSessionFactory", sessionFactory);
		
	}

}
