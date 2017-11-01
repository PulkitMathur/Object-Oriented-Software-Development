package com.oosd.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CreateTestDemo {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();  
        Session session = sessionFactory.openSession();  
        session.beginTransaction();  
          
        Test test = new Test();  
        test.setTest("0");  
          
        session.save(test);  
        session.getTransaction().commit();  
          
        session.close(); 
	}
}
