/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas.jabs;

import java.io.File;
//import beans.*;

/**
 *
 * @author Leo
 */
public class PruebasJAXB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ManejadorPersona mp = new ManejadorPersona();
        File origen1 = new File("src\\marcas\\corazonesSolitarios.xml");
        File origen2 = new File("src\\marcas\\masCorazones.xml");
        File destino = new File("src\\marcas\\corazonesReunidos.xml");
        // Cargamos el XML mediante unmarshaling
        mp.abrirListaPersonasJAXB(origen1);
        mp.abrirListaPersonasJAXB(origen2);
        // Comprobamos que se ha cargado
        mp.recorreListaPersona();
        // Ahora vamos a añadir otro Persona
        Persona nuevoPersona = new Persona();
        nuevoPersona.setNombre("Mentirio");
        nuevoPersona.setSimbolo("Mt");
        nuevoPersona.setNumeroAtomico(111);
        mp.anadirPersona(nuevoPersona);
        // Y generamso un nuevo XML mediante marshaling
        mp.guardarListaPersonas(destino);
    }
}
