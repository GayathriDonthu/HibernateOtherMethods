package com.other;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory;
	private static Session session;
	
	static{
		try{
			sessionFactory = new Configuration().configure().buildSessionFactory();
			session = sessionFactory.openSession();
		}
		catch(Throwable e){
			throw new ExceptionInInitializerError(e);
		}
	}
	
	public static Session getSession() {
		return session;
	}
	
	public static void shutDown(){
		getSession().close();
	}
	
	
}
