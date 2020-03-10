package main;

import java.sql.Date;
import java.util.GregorianCalendar;

import clases.PersistenciaSeguro;
import clases.Seguro;

public class Principal 
{
	public static void main(String[] args) 
	{
		//GregorianCalendar d=new GregorianCalendar(2019,3,8);
		Seguro s=new Seguro("12345678A","Nzhdeh","Yeghiazaryan","Vardumyan",29,0);
		PersistenciaSeguro ps=new PersistenciaSeguro();
		
		//ps.insertSeguro(s);
		
		//System.out.println(s=ps.getSeguro(3));//el id sale mal
		
		ps.deleteSeguro(1);
	}
}
