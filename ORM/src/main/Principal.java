package main;

import java.sql.Date;

import clases.PersistenciaSeguro;
import clases.Seguro;

public class Principal 
{
	@SuppressWarnings("deprecation")
	public static void main(String[] args) 
	{
		Date d=new Date(2019,3,8);
		Seguro s=new Seguro("123456789A","Nzhdeh","Yeghiazaryan","Vardumyan",29,0,d);
		PersistenciaSeguro ps=new PersistenciaSeguro();
		
		ps.insertSeguro(s);
	}
}
