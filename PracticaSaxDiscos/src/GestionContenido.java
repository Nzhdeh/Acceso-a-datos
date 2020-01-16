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
	
	private ConexionJDBC conexion;
	Connection conn;
	
    public GestionContenido() 
    {
        super();
        //crear la conexion aqui
        conexion=new ConexionJDBC();
        conn = conexion.getConnection();
    }
    
    @Override
    public void startDocument()
    {
        //System.out.println("Comienzo del documento XML");
    }
    
    @Override
    public void endDocument()
    {
    	//cerrar la conexion
    	 try 
         {
 			conn.close();
 		 } catch (SQLException e) 
         {
 			e.printStackTrace();
 		 }
    }
    
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException 
    {

    	switch(qName) 
    	{
	    	case "album":
	    		disco=new Disco();	
	    		break;
	    		
	    	case "autor":
	    		bAutor = true;
	    		break;
	    		
	    	case "titulo":
	    		bTitulo = true;
	    		break;
	    		
	    	case "formato":
	    		bFormato = true;
	    		break;
	    		
	    	case "localizacion":
	    		bLocalizacion = true;
	    		break;
    	}
    	
		data = new StringBuilder();
	}
    
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
		if (bAutor) {
			// age element, set Employee age
			disco.setAutor(data.toString());
			bAutor = false;
		} else if (bTitulo) {
			disco.setTitulo(data.toString());
			bTitulo = false;
		} else if (bFormato) {
			disco.setFormato(data.toString());
			bFormato = false;
		} else if (bLocalizacion) {
			disco.setLocalizacion(data.toString());
			bLocalizacion = false;
		}
		
		
	}
    
    @Override
    public void characters (char[] ch, int inicio, int longitud)
            throws SAXException
    {
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
