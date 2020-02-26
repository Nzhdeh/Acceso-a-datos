package main;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import clases.Disco;
import clases.PersonFactory;

public class Principal 
{
	public static void main(String[] args) 
	{
		
		try
		{
			SessionFactory sessionFactory = PersonFactory.getSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			
			
			Disco d=new Disco("Yo","titulillo","mp3","local");
			session.save(d);
			
			
			session.getTransaction().commit();
			
			session.close();
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
		
	    
		
	}
}
