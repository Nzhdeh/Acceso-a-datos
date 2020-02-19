/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas.jabs;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import clases.Medicamento;
import clases.Medico;
import clases.Receta;
import clases.RecetaImpl;

public class PruebasJAXB {

//	A partir del XML esquema recetas.xsd, crea las clases Receta, Medicamento y Medico.
//
//	Lee el fichero Recetas.xml, inserta un nuevo objeto Receta en la colección y luego 
//	guárdalo en otro fichero MasRecetas.xml, de acuerdo al mismo esquema.
	
    public static void main(String[] args) 
    {
    	ManejadorReceta ma = new ManejadorReceta();
        File origen = new File("src\\marcas\\recetas.xml");
        File destino = new File("src\\marcas\\masrecetas.xml");
        
    	
    	 Medico m=new Medico();
    	 m.setNumcol((short) 123);
    	 m.setNombre("Angela Vazquez");
    	 m.setEspecialidad("Pediatra");
    	 
    	 Medicamento med=new Medicamento();
    	 med.setNombre("Apruebacina");
    	 med.setLaboratorio("IES Nervion");
    	 med.setPresentacion("Pastillas de 40 unidades");
    	 
    	 RecetaImpl.Alternativo.Medicamento medAlt1=new RecetaImpl.Alternativo.Medicamento();
    	 med.setNombre("Suspencina");
    	 med.setLaboratorio("IES Nervion");
    	 med.setPresentacion("Una Pastilla");
    	 
    	 RecetaImpl.Alternativo.Medicamento medAlt2=new RecetaImpl.Alternativo.Medicamento();
    	 med.setNombre("Repiticina");
    	 med.setLaboratorio("IES Nervion");
    	 med.setPresentacion("Cuatro Pastillas");
    	 
    	 RecetaImpl.Alternativo ra1=new RecetaImpl.Alternativo();
    	 ra1.setMedicamento(medAlt1);
    	 ra1.setOrd((byte)1);
    	 
    	 RecetaImpl.Alternativo ra2=new RecetaImpl.Alternativo();
    	 ra2.setMedicamento(medAlt2);
    	 ra2.setOrd((byte)2);
    	 
    	 
    	 List<RecetaImpl.Alternativo> alternativo = new ArrayList<RecetaImpl.Alternativo>();
    	 alternativo.add(ra1);
    	 alternativo.add(ra2);
    	 
    	 RecetaImpl r=new RecetaImpl();
    	 r.setId((byte)3);
    	 r.setTipo("Droga Dura");
    	 r.setMedico(m);
    	 r.setFecha("11/02/2020");
    	 r.setMedicamento(med);
    	 //r.añadirAlternativo(medAlt1);
    	 
         // Cargamos el XML mediante unmarshaling
         ma.abrirListaRecetasJAXB(origen);
         ma.añadirReceta(r);
         ma.guardarListaRecetas(destino);
         ma.recorreListaRecetas();
    }
}
