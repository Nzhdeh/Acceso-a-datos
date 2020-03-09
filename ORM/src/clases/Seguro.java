package clases;

import java.sql.Date;

public class Seguro 
{
	private int idSeguro;
	private String nif;
	private String nombre;
	private String ape1;
	private String ape2;
	private int edad;
	private int numHijos;
	private Date fechaCreacion;
	
	public Seguro()
	{
		this.idSeguro=0;
		this.nif="000000000";
		this.nombre="sdfsd";
		this.ape1="edswfsd";
		this.ape2="fmbdfj";
		this.numHijos=0;
		this.fechaCreacion=new Date(0,0,0);
	}
	
	public Seguro(int idSeguro,String nif,String nombre,String ape1,String ape2,int edad,int numHijos,Date fechaCreacion)
	{
		this.idSeguro=idSeguro;
		this.nif=nif;
		this.nombre=nombre;
		this.ape1=ape1;
		this.ape2=ape2;
		this.edad=edad;
		this.numHijos=numHijos;
		this.fechaCreacion=fechaCreacion;
	}
	
	//constructor con parametros sin el ID
	public Seguro(String nif,String nombre,String ape1,String ape2,int edad,int numHijos,Date fechaCreacion)
	{
		this.nif=nif;
		this.nombre=nombre;
		this.ape1=ape1;
		this.ape2=ape2;
		this.edad=edad;
		this.numHijos=numHijos;
		this.fechaCreacion=fechaCreacion;
	}

	public int getIdSeguro() {
		return idSeguro;
	}

	public void setIdSeguro(int idSeguro) {
		this.idSeguro = idSeguro;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApe1() {
		return ape1;
	}

	public void setApe1(String ape1) {
		this.ape1 = ape1;
	}

	public String getApe2() {
		return ape2;
	}

	public void setApe2(String ape2) {
		this.ape2 = ape2;
	}

	public int getNumHijos() {
		return numHijos;
	}

	public void setNumHijos(int numHijos) {
		this.numHijos = numHijos;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public int getEdad() 
	{
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
}
