package main;

import clases.ApplicationSession;
import clases.PersonFactory;
import clases.Seguro;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.microsoft.sqlserver.jdbc.SQLServerDriver;

public class Principal 
{
	public static void main(String[] args) 
	{
		System.out.println("No funciona en eclipse,me da class not found exception");
		
//		SessionFactory sessionFactory = PersonFactory.getSessionFactory();
//		Session session = sessionFactory.openSession();
		
		Session session = ApplicationSession.getSession();
		
		Seguro seguro = new Seguro(0,"00000000T","Nzhdeh","Yeghiazaryan","Vardumyan",29,0,new Date());
		
		//obtener seguro
		session.beginTransaction();
        int idSeguro = (int)session.save(seguro);
        session.getTransaction().commit();
		
        Seguro seguroNuevo = session.get(Seguro.class, idSeguro);

        System.out.println(seguroNuevo.toString());
        
        //update
        session.beginTransaction();

        seguroNuevo.setNombre("Cambiado");

        session.update(seguroNuevo);

        session.getTransaction().commit();
        
        //delete
        session.beginTransaction();

        session.delete(seguro);

        session.getTransaction().commit();
	}
}
