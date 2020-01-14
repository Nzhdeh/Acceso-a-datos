//package probandoSAX;


/**
 *
 * @author Leo
 */
import org.xml.sax.helpers.*;
import org.xml.sax.*;
public class GestionContenido extends DefaultHandler 
{

	private Disco disco;
	private StringBuilder data = null;
	
	boolean bAutor = false;
	boolean bTitulo = false;
	boolean bFormato = false;
	boolean bLocalizacion = false;
	
    public GestionContenido() 
    {
        super();
    }
    
    @Override
    public void startDocument()
    {
        System.out.println("Comienzo del documento XML");
    }
    
    @Override
    public void endDocument()
    {
        System.out.println("Fin del documento XML");
    }
    
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

		if (qName.equalsIgnoreCase("Disco")) 
		{
			// create a new Employee and put it in Map
			String id = attributes.getValue("id");
			// initialize Employee object and set id attribute
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
    	Disco disco=new Disco();
        String cad = new String(ch, inicio, longitud);
        cad = cad.replaceAll("[\t\n]",""); // Quitamos tabuladores y saltos de linea
        System.out.println("\t\t" + cad);
    }
}
// FIN GestionContenido
