
package pruebas.jabs;


import java.io.*;
import javax.xml.bind.*;

import clases.Receta;
import clases.RecetaImpl;
import clases.Recetario;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ManejadorReceta 
{
	Recetario listaRecetas;
	

    public void abrirListaRecetasJAXB (File archivoXML)
    {
        JAXBContext contexto;
        try {
            contexto = JAXBContext.newInstance(Recetario.class);
            Unmarshaller u = contexto.createUnmarshaller();
            listaRecetas = (Recetario) u.unmarshal(archivoXML);
            
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    
    
//    public void recorreListaRecetas()
//    {
//        RecetaEscribible recetaTuneada;
//        List<RecetaImpl> miListaRecetas =  listaRecetas.getReceta();
//
//        for(RecetaImpl unaReceta:miListaRecetas)
//        {
//        	recetaTuneada = new RecetaEscribible(unaReceta);
//            System.out.println("\nSiguiente elemento\n----------------------------------------------");
//            System.out.println(recetaTuneada.getTodo());
//        }
//    }
    
    
    public void añadirReceta(RecetaImpl nuevo)
    {
    	listaRecetas.getReceta().add((Receta)nuevo);
    }
    
    
    public void guardarListaRecetas(File archivoXML)
    {
        JAXBContext contexto;
        try {
        	contexto = JAXBContext.newInstance(Recetario.class);
            Marshaller serializar = contexto.createMarshaller();
            serializar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            StringWriter writer = new StringWriter();
            serializar.marshal(listaRecetas,archivoXML);
            serializar.marshal(listaRecetas,writer);
        } catch (JAXBException ex) {
            Logger.getLogger(ManejadorReceta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
