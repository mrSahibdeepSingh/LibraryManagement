package com.elibrary.connectionUtils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.elibrary.beans.BookBean;
import com.elibrary.beans.IssueBookBean;
import com.elibrary.beans.LibrarianBean;
 
public class SessionUtils {

	private static SessionUtils instance = new SessionUtils();
	private SessionFactory sessionFactory;
	
	public static SessionUtils getInstance()
	{
		return instance;
	}
	private SessionUtils()
	{
		Configuration config = new Configuration().configure().addAnnotatedClass(LibrarianBean.class).addAnnotatedClass(BookBean.class).addAnnotatedClass(IssueBookBean.class);
		ServiceRegistry sref = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		sessionFactory = config.buildSessionFactory(sref);
	}
	
	public static Session getSession()
	{
		 Session session = getInstance().sessionFactory.openSession();
		 
		return session;
		
	}
}

