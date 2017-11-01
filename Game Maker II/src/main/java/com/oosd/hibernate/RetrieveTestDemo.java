package com.oosd.hibernate;  
  
import java.io.IOException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
  
public class RetrieveTestDemo {  
  
    public static void main(String[] args) throws IOException {  
  
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();  
        Session session = sessionFactory.openSession();  
          
        List<Test> tests = session.createQuery("from Test").list();  
          
        List<Resources> resources = session.createQuery("from Resources").list();
        
        session.close();  
          
        for (Test st : tests) {  
            System.out.println(st.getId()+". "+st.getId()+" "+st.getTest());  
        } 

    }  
}    