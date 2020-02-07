package pruebas.jabs;

import clases.TipoPersona;

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
    public String getTodo ()
    {
        return ("ID: "+this.getID()+"\nNombre: "+this.getNombre()+"\nSexo: "+this.getSexo()+
        		"\nSexo Buscado: "+this.getSexoBuscado()+"\nFecha de Nacimiento: "+this.getFechaNacimiento()+
        		"\nIngresos: "+this.getIngresos()+"\nPreferencia: "+this.getPreferencias());
    }
}
