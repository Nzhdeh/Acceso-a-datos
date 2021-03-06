
public class Disco {

	//private int id;
	private String autor;
	private String titulo;
	private String formato;
	private String localizacion;
	
	public Disco()
	{
		//this.id=0;
		this.autor="autor";
		this.titulo="titulo";
		this.formato="formato";
		this.localizacion="localizacion";
	}
	
	public Disco(int id,String autor,String titulo,String formato,String localizacion)
	{
		//this.id=id;
		this.autor=autor;
		this.titulo=titulo;
		this.formato=formato;
		this.localizacion=localizacion;
	}

//	public int getId() 
//	{
//		return id;
//	}
//
//	public void setId(int id) 
//	{
//		this.id = id;
//	}

	public String getAutor() 
	{
		return autor;
	}

	public void setAutor(String autor) 
	{
		this.autor = autor;
	}

	public String getTitulo() 
	{
		return titulo;
	}

	public void setTitulo(String titulo) 
	{
		this.titulo = titulo;
	}

	public String getFormato() 
	{
		return formato;
	}

	public void setFormato(String formato) 
	{
		this.formato = formato;
	}

	public String getLocalizacion() 
	{
		return localizacion;
	}

	public void setLocalizacion(String localizacion) 
	{
		this.localizacion = localizacion;
	}
	
	@Override
	public String toString()
	{
		return (getAutor()+","+getTitulo()+","+getFormato()+","+getLocalizacion());
	}
}
