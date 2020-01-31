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
        
        
        mp.abrirListaPersonasJAXB(origen1);
        mp.aniadirPersona(origen2);
        mp.guardarListaPersonas(destino);
        mp.recorreListaPersonas();
//        mp.ordenarCorazoncitos();
//        mp.pintarCorazoncitos();
    }
}
