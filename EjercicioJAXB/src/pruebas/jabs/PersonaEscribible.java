package pruebas.jabs;

import clases.TipoPersona;

//import beans.*;

/**
 *
 * @author Leo
 */
// Derivamos la clase Atomo para añadirle un método que devuelva una cadena con todos los datos del Atomo
public class PersonaEscribible extends TipoPersona {
    
    public PersonaEscribible (TipoPersona p){
        super();
        this.setID(p.getID());
        this.setNombre(p.getNombre());
        this.setSexo(p.getSexo());
        this.setSexoBuscado(p.getSexoBuscado());
        this.setFechaNacimiento(p.getFechaNacimiento());
        this.setIngresos(p.getIngresos());
        //aqui tengo una duda sobre las preferencias
        this.setPreferencias(p.getPreferencias());
    }
    // Este es el metodo
    public String getTodo (){
        String cadPersona;
        cadPersona = "Id: "+this.getID();
        cadPersona = "Nombre: "+this.getNombre();
        cadPersona +="\nSexo: "+this.getSexo();
        cadPersona +="\nSexo Buscado: "+this.getSexoBuscado();
        cadPersona +="\nFecha de Nacimiento: "+this.getFechaNacimiento();
        cadPersona +="\nIngresos: "+this.getIngresos();
        cadPersona +="\nPreferencia: "+this.getPreferencias();
        return cadPersona;
    }
}
