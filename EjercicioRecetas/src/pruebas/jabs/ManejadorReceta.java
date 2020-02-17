
package pruebas.jabs;


import java.io.*;
import javax.xml.bind.*;

import clases.Receta;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ManejadorReceta 
{
	Receta listaRecetas;
	

    public void abrirListaRecetasJAXB (File archivoXML)
    {
        JAXBContext contexto;
        try {
            contexto = JAXBContext.newInstance(Receta.class);
            Unmarshaller u = contexto.createUnmarshaller();
            listaRecetas = (Receta) u.unmarshal(archivoXML);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    
    
    public void recorreListaRecetas()
    {
        RecetaEscribible recetaTuneada;
        List<Receta> miListaRecetas = (List<Receta>) listaRecetas;

        for(Receta unaReceta:miListaRecetas){
        	recetaTuneada = new RecetaEscribible(unaReceta);
            System.out.println("\nSiguiente elemento\n----------------------------------------------");
            System.out.println(recetaTuneada.getTodo());
        }
    }
    
    
//    public void anadirPersona(TipoPersona nuevo)
//    {
//        listaPersonas.getPersona().add(nuevo);
//    }
    
//    public void aniadirReceta (Receta r) {
//        JAXBContext contexto;
//        Receta adicionales;
//        try {
//            contexto = JAXBContext.newInstance(Corazoncitos.class);
//            Unmarshaller u = contexto.createUnmarshaller();
//            adicionales = (Receta) u.unmarshal(archivoXML);
//            
//            for(TipoPersona persona:adicionales.getPersona()){
//                
//                listaPersonas.getPersona().add(persona);
//            }
//            
//        }catch (Exception ex) {
//            ex.printStackTrace();
//        }
//    }
    
    
//    public void guardarListaPersonas(File archivoXML)
//    {
//        JAXBContext contexto;
//        File archivo=null;
//        
//        if(!archivoXML.exists())
//        {
//        	archivo=new File("src\\\\marcas\\\\corazonesReunidos.xml");
//        }
//        try {
//            contexto = JAXBContext.newInstance(Corazoncitos.class);
//            Marshaller marshalero = contexto.createMarshaller();
//            marshalero.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//            StringWriter escribiente = new StringWriter();
//            if(!archivoXML.exists())
//            {
//            	marshalero.marshal(listaPersonas, archivo);
//            }else 
//            {
//            	marshalero.marshal(listaPersonas, archivoXML);
//            }
//        	
//            
//            // ahora lo marshaleamos a un stream para visualizarlo
//            marshalero.marshal(listaPersonas, escribiente);
//            System.out.println("-----------------");
//            System.out.println("Object2XML:");
//            System.out.println(escribiente.toString());
//            System.out.println("-----------------");
//        } catch (JAXBException ex) {
//            Logger.getLogger(ManejadorReceta.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    
//    public void ordenarCorazoncitos() 
//    {
//        
//        TipoPersona[] personasArray = new TipoPersona[listaPersonas.getPersona().size()];
//        personasArray = listaPersonas.getPersona().toArray(personasArray);
//        Arrays.sort(personasArray);
//        
//        listaPersonas.getPersona().clear();
//        
//        for(TipoPersona p:personasArray){
//        
//        	listaPersonas.getPersona().add(p);
//        }
//    }
//    
//    public void pintarCorazoncitos() 
//    {
//    	for(TipoPersona persona:listaPersonas.getPersona())
//    	{
//    		System.out.println(persona.toString());
//    	}
//    }
}
