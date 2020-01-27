package pruebas.jabs;

//import beans.*;

/**
 *
 * @author Leo
 */
// Derivamos la clase Atomo para añadirle un método que devuelva una cadena con todos los datos del Atomo
public class AtomoEscribible extends Persona {
    
    public AtomoEscribible (Persona uno){
        super();
        this.setId(uno.getId());
        this.setNombre(uno.getNombre());
        this.setSexo(uno.getSexo());
        this.setSexoBuscado(uno.getSexoBuscado());
        this.setFechaNacimiento(uno.getFechaNacimiento());
        this.setIngresos(uno.getIngresos());
        this.setPreferencia(uno.getPreferencia());
    }
    // Este es el método
    public String getTodo (){
        String cadAtomo;
        cadAtomo = "Id: "+this.getId();
        cadAtomo = "Nombre: "+this.getNombre();
        cadAtomo +="\nSexo: "+this.getSexo();
        cadAtomo +="\nSexo Buscado: "+this.getSexoBuscado();
        cadAtomo +="\nFecha de Nacimiento: "+this.getFechaNacimiento();
        cadAtomo +="\nIngresos: "+this.getIngresos();
        cadAtomo +="\nPreferencia: "+this.getPreferencia();
        return cadAtomo;
    }
}
