
package pruebas.jabs;


import java.io.*;
import javax.xml.bind.*;
//import beans.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leo
 */
public class ManejadorPersona {
	Corazoncitos listaPersonas;
    public void abrirListaAtomosJAXB (File archivoXML){
        JAXBContext contexto;
        try {
            contexto = JAXBContext.newInstance(Corazoncitos.class);
            Unmarshaller u = contexto.createUnmarshaller();
            listaPersonas = (Corazoncitos) u.unmarshal(archivoXML);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public void recorreListaPersonas(){
        PersonaEscribible personaTuneao;
        List<Persona> miListaPersonas = listaPersonas.getPersona();
        for(Persona unaPersona:miListaPersonas){
            personaTuneao = new PersonaEscribible(unaPersona);
            System.out.println("\nSiguiente elemento\n----------------------------------------------");
            System.out.println(personaTuneao.getTodo());
        }
    }
    public void anadirPersona(Persona nuevo){
        listaPersonas.getPersona().add(nuevo);
    }
    public void guardarListaPersonas(File archivoXML){
        JAXBContext contexto;
        try {
            contexto = JAXBContext.newInstance(Corazoncitos.class);
            Marshaller marshalero = contexto.createMarshaller();
            marshalero.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            StringWriter escribiente = new StringWriter();
            marshalero.marshal(listaPersonas, archivoXML);
            // ahora lo marshaleamos a un stream para visualizarlo
            marshalero.marshal(listaPersonas, escribiente);
            System.out.println("-----------------");
            System.out.println("Object2XML:");
            System.out.println(escribiente.toString());
            System.out.println("-----------------");
        } catch (JAXBException ex) {
            Logger.getLogger(ManejadorPersona.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
