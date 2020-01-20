import org.xml.sax.helpers.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import org.xml.sax.*;

public class GestionContenido extends DefaultHandler{

	private Disco disco;
    private String actual;
    
	boolean bAutor = false;
	boolean bTitulo = false;
	boolean bFormato = false;
	boolean bLocalizacion = false;

    public GestionContenido() {
        super();
    }
    @Override
    public void startDocument(){

        //System.out.println("Comienzo del documento XML");

    }
    @Override
    public void endDocument(){

        //System.out.println("Fin del documento XML");

    }
    @Override
    public void startElement(String uri, String nombre, String nombreC, Attributes att){
        //System.out.println("\t<"+nombre +">");
        this.actual = nombre;
        
        switch(nombre)
        {
	        case "album":
	        	this.disco = new Disco();
	        	break;
	        	
	        case "autor":
	        	bAutor=true;
	        	break;
	        	
	        case "titulo":
	        	bTitulo=true;
	        	break;
	        	
	        case "formato":
	        	bFormato=true;
	        	break;
	        	
	        case "localizacion":
	        	bLocalizacion=true;
	        	break;
        }
    }
    @Override
    public void endElement(String uri, String nombre, String nombreC){
        //System.out.println("\t</"+nombre +">");
    	bAutor = false;
    	bTitulo = false;
    	bFormato = false;
    	bLocalizacion = false;
        ConexionJDBC conex = new ConexionJDBC();
        if(nombre.equals("album")){
            System.out.println(disco.toString());
            conex.insertarDisco(disco);
        }
    }
    @Override
    public void characters (char[] ch, int inicio, int longitud)
            throws SAXException{
        if(bAutor && bTitulo && bFormato && bLocalizacion)
        {
            String cad = new String(ch, inicio, longitud);
            cad = cad.replaceAll("[\t\n]",""); // Quitamos tabuladores y saltos de linea
            //System.out.println("\t\t" + cad );
            switch (actual){
                case "autor":
                    disco.setAutor(cad);
                    break;
                case "titulo":
                    disco.setTitulo(cad);
                    break;
                case "formato":
                    disco.setFormato(cad);
                    break;
                case "localizacion":
                    disco.setLocalizacion(cad);
                    break;
                case "album":
                    break;
            }
        }
    }
}
