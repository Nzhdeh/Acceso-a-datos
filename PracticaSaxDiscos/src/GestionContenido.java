//package probandoSAX;


/**
 *
 * @author Leo
 */
import org.xml.sax.helpers.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.xml.sax.*;
public class GestionContenido extends DefaultHandler 
{
	private String propiedad;
	private Disco disco;
	private StringBuilder data = null;
	
	boolean bAutor = false;
	boolean bTitulo = false;
	boolean bFormato = false;
	boolean bLocalizacion = false;
	
    public GestionContenido() 
    {
        super();
        //crear la conexion aqui
    }
    
    @Override
    public void startDocument()
    {
        System.out.println("Comienzo del documento XML");
    }
    
    @Override
    public void endDocument()
    {
    	//cerrar la conexion
    	
    }
    
//    	Connection conexion = null;
//    	ConexionJDBC conexionJdbc=new ConexionJDBC();
//    	
//        int filas = 0;
//        PreparedStatement sentencia = null;
//        String  miOrden = "INSERT INTO Discos VALUES(?,?,?,?)";
//
//        try{
//        	conexion=conexionJdbc.getConnection();
//            sentencia = conexion.prepareStatement(miOrden);
//            sentencia.setString(1, disco.getAutor());
//            sentencia.setString(2, disco.getTitulo());
//            sentencia.setString(3, disco.getFormato());
//            sentencia.setString(4, disco.getLocalizacion());
//            filas = sentencia.executeUpdate();
//
//        }catch (SQLException e){
//            e.printStackTrace();;
//        }
    
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

		if (qName.equalsIgnoreCase("album")) 
		{
			// create a new Disco and put it in Map
			String id = attributes.getValue("id");
			// initialize Disco object and set id attribute
			disco=new Disco();
			disco.setId(Integer.parseInt(id));
			
		// initialize list
		} else if (qName.equalsIgnoreCase("autor")) 
		{
			bAutor = true;
		} else if (qName.equalsIgnoreCase("titulo")) 
		{
			bTitulo = true;
		} else if (qName.equalsIgnoreCase("formato")) 
		{
			bFormato = true;
		} else if (qName.equalsIgnoreCase("localizacion")) 
		{
			bLocalizacion = true;
		}
		// create the data container
		data = new StringBuilder();
	}
    
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
		if (bAutor) {
			// age element, set Employee age
			//disco.setAutor(data.toString());
			bAutor = false;
		} else if (bTitulo) {
			//disco.setTitulo(data.toString());
			bTitulo = false;
		} else if (bFormato) {
			//disco.setFormato(data.toString());
			bFormato = false;
		} else if (bLocalizacion) {
			//disco.setLocalizacion(data.toString());
			bLocalizacion = false;
		}
		
		//si es disco hacemos el incert
		
		Connection conexion = null;
    	ConexionJDBC conexionJdbc=new ConexionJDBC();
    	
        int filas = 0;
        PreparedStatement sentencia = null;
        String  miOrden = "INSERT INTO Discos VALUES(?,?,?,?)";

        try{
        	conexion=conexionJdbc.getConnection();
            sentencia = conexion.prepareStatement(miOrden);
            sentencia.setString(1, disco.getAutor());
            sentencia.setString(2, disco.getTitulo());
            sentencia.setString(3, disco.getFormato());
            sentencia.setString(4, disco.getLocalizacion());
            filas = sentencia.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();;
        }
	}
    
    @Override
    public void characters (char[] ch, int inicio, int longitud)
            throws SAXException
    {
    	Disco disco=new Disco();
        String cad = new String(ch, inicio, longitud);
        cad = cad.replaceAll("[\t\n]",""); // Quitamos tabuladores y saltos de linea
        //System.out.println("\t\t" + cad);
        
        switch(cad) 
        {        
        	case "autor":
        		disco.setAutor(data.toString());
        		break;
        		
        	case "titulo":
        		disco.setTitulo(data.toString());
        		break;
        		
        	case "formato":
        		disco.setFormato(data.toString());
        		break;
        		
        	case "localizacion":
        		disco.setLocalizacion(data.toString());
        		break;
        }
    }
}
// FIN GestionContenido
