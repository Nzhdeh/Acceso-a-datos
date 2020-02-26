package clases;

import java.io.Serializable;

//import org.hibernate.annotations.Entity;
import javax.persistence.*;

@Entity
@Table(name="Discos")
public class Disco implements Serializable
{
	@Id
	@Column(name="id")
	private int id;
	@Column(name="autor")
	private String autor;
	@Column(name="titulo")
	private String titulo;
	@Column(name="formato")
	private String formato;
	@Column(name="localizacion")
	private String localizacion;
	
	public Disco() 
	{
		this.id = 0;
		this.autor = "";
		this.titulo = "";
		this.formato = "";
		this.localizacion = "";
	}
	
	public Disco( String autor, String titulo, String formato, String localizacion) 
	{
		//this.id = id;
		this.autor = autor;
		this.titulo = titulo;
		this.formato = formato;
		this.localizacion = localizacion;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getFormato() {
		return formato;
	}
	public void setFormato(String formato) {
		this.formato = formato;
	}
	public String getLocalizacion() {
		return localizacion;
	}
	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}
	
	
}
