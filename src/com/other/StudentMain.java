package com.other;

import org.hibernate.ReplicationMode;
import org.hibernate.Session;

public class StudentMain {
	
	public static void main(String[] args) {
		StudentMain sm = new StudentMain();
		sm.flush();
	}
	
	public void evict(){
		Session sess = HibernateUtil.getSession();
		Student s = (Student)sess.get(Student.class,1);
		sess.evict(s);
		sess.beginTransaction();
		s.setName("Raju");
		sess.getTransaction().commit();
		
	}
	
	public void replicate(){
		Session sess = HibernateUtil.getSession();
		Student s = (Student) sess.get(Student.class, 2);
		sess.evict(s);
		sess.beginTransaction();
		
		sess.replicate(s, ReplicationMode.LATEST_VERSION);
		s.setName("Netaji");
		sess.getTransaction().commit();
		sess.close();
	}
	
	public void flush(){
		Session sess = HibernateUtil.getSession();
		Student s = (Student) sess.get(Student.class,1);
		sess.beginTransaction();
		s.setName("Neha");
		sess.flush();
		//sess.getTransaction().commit();
		sess.close(); // if sess.close() is commented then the database is not updated
		
	}
	
	public void refresh(){
		Session sess = HibernateUtil.getSession();
		Student s = (Student) sess.get(Student.class,1);
		sess.beginTransaction();
		
	}
	
}
