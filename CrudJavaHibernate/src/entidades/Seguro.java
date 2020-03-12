package entidades;

import java.util.GregorianCalendar;

import javax.persistence.*;

@Entity
@Table(name="Seguros")
public class Seguro 
{
	@Id
	@Column(name="idSeguro")
	private int idSeguro;
	@Column(name="nif")
	private String nif;
	@Column(name="nombre")
	private String nombre;
	@Column(name="ape1")
	private String ape1;
	@Column(name="ape2")
	private String ape2;
	@Column(name="edad")
	private int edad;
	@Column(name="numHijos")
	private int numHijos;
	@Column(name="fechaCreacion")
	private GregorianCalendar fechaCreacion;
	
	public Seguro()
	{
		this.idSeguro=0;
		this.nif="000000000";
		this.nombre="default";
		this.ape1="default";
		this.ape2="default";
		this.numHijos=0;
		this.fechaCreacion=new GregorianCalendar(0,0,0);
	}
	
	public Seguro(String nif,String nombre,String ape1,String ape2,int edad,int numHijos,GregorianCalendar fechaCreacion)
	{
		//this.idSeguro=idSeguro;
		this.nif=nif;
		this.nombre=nombre;
		this.ape1=ape1;
		this.ape2=ape2;
		this.edad=edad;
		this.numHijos=numHijos;
		this.fechaCreacion=fechaCreacion;
	}
	
	//constructor con parametros sin el ID y fecha de creacion
	public Seguro(String nif,String nombre,String ape1,String ape2,int edad,int numHijos)
	{
		this.nif=nif;
		this.nombre=nombre;
		this.ape1=ape1;
		this.ape2=ape2;
		this.edad=edad;
		this.numHijos=numHijos;
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

	public GregorianCalendar getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(GregorianCalendar fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public int getEdad() 
	{
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	@Override 
	public String toString() {
		return (this.getIdSeguro()+","+this.getNif()+","+this.getNombre()+","+
				this.getApe1()+","+this.getApe2());
	}
}
