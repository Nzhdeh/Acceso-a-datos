/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas.jabs;

import java.io.File;

public class PruebasJAXB {


	
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
