package com.oosd.hibernate;  
  
import org.hibernate.Session;
import org.hibernate.SessionFactory;
  
public class InsertTestDemo {  
  
    public static void main(String[] args) {  
  
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();  
        Session session = sessionFactory.openSession();  
        session.beginTransaction();  
          
        Test test = new Test(); 
        test.setTest("TestString1");
        
        Test test2 = new Test(); 
        test2.setTest("TestString2");
          
        session.save(test);  
        session.getTransaction().commit();  
          
        session.close();  
  
    }  
}  
