/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas.jabs;

import java.io.File;
import java.util.List;

import clases.Medicamento;
import clases.Medico;
import clases.Receta;

public class PruebasJAXB {

//	A partir del XML esquema recetas.xsd, crea las clases Receta, Medicamento y Medico.
//
//	Lee el fichero Recetas.xml, inserta un nuevo objeto Receta en la colección y luego 
//	guárdalo en otro fichero MasRecetas.xml, de acuerdo al mismo esquema.
	
    public static void main(String[] args) 
    {
    	
    	 Medico m=new Medico();
    	 m.setNumcol((short) 123);
    	 m.setNombre("Angela Vazquez");
    	 m.setEspecialidad("Pediatra");
    	 
    	 Medicamento med=new Medicamento();
    	 med.setNombre("Apruebacina");
    	 med.setLaboratorio("IES Nervion");
    	 med.setPresentacion("Pastillas de 40 unidades");
    	 
    	 Receta.Alternativo.Medicamento medAlt1=new Receta.Alternativo.Medicamento();
    	 med.setNombre("Suspencina");
    	 med.setLaboratorio("IES Nervion");
    	 med.setPresentacion("Una Pastilla");
    	 
    	 Receta.Alternativo.Medicamento medAlt2=new Receta.Alternativo.Medicamento();
    	 med.setNombre("Repiticina");
    	 med.setLaboratorio("IES Nervion");
    	 med.setPresentacion("Cuatro Pastillas");
    	 
    	 Receta.Alternativo ra1=new Receta.Alternativo();
    	 ra1.setMedicamento(medAlt1);
    	 ra1.setOrd((byte)1);
    	 
    	 Receta.Alternativo ra2=new Receta.Alternativo();
    	 ra2.setMedicamento(medAlt2);
    	 ra2.setOrd((byte)2);
    	 
    	 List<Receta.Alternativo> alternativo = null;
    	 alternativo.add(ra1);
    	 alternativo.add(ra2);
    	 
    	 Receta r=new Receta();
    	 r.setId((byte)3);
    	 r.setTipo("Droga Dura");
    	 r.setMedico(m);
    	 r.setFecha("11/02/2020");
    	 r.setMedicamento(med);
    	 r.setAlternativo(alternativo);
    	 
    	 
    	 ManejadorReceta ma = new ManejadorReceta();
         File origen = new File("src\\marcas\\recetas.xml");
         File destino = new File("src\\marcas\\masrecetas.xml");
         
         //añadimos la receta al xml recetas
         
         // Cargamos el XML mediante unmarshaling
         ma.abrirListaAtomosJAXB(origen);
         // Comprobamos que se ha cargado
         ma.recorreListaAtomos();
         // Ahora vamos a aÃ±adir otro Ã¡tomo
         Atomo nuevoAtomo = new Atomo();
         nuevoAtomo.setNombre("Mentirio");
         nuevoAtomo.setSimbolo("Mt");
         nuevoAtomo.setNumeroAtomico(111);
         ma.anadirAtomo (nuevoAtomo);
         // Y generamso un nuevo XML mediante marshaling
         ma.guardarListaAtomos(destino);
    }
}
