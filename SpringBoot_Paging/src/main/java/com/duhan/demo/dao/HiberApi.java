package com.duhan.demo.dao;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.duhan.demo.model.alien;

public class HiberApi{
   
    
  Configuration con = new Configuration().configure().addAnnotatedClass(alien.class);
  SessionFactory sf = con.buildSessionFactory();
  Session session = sf.openSession();
 
  Transaction tx = session.beginTransaction();

  public List<alien> getResponse(){
	  
	 
	  Query q = session.createQuery("from alien");
	  List<alien> a = q.list();
	  tx.commit();
	  System.out.println(a);
	  return a;
	 
	  
  }
}
