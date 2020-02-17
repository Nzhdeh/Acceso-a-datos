package pruebas.jabs;
import clases.*;
// Derivamos la clase Atomo para añadirle un método que devuelva una cadena con todos los datos del Atomo
public class RecetaEscribible extends Receta {
    
    public RecetaEscribible (Receta p){
        super();
        this.setId(p.getId());
        this.setFecha(p.getFecha());
        this.setTipo(p.getTipo());
        this.setMedico(p.getMedico());
        this.setMedicamento(p.getMedicamento());
        
        this.setAlternativo(p.getAlternativo());
    }
    // Este es el metodo
    public String getTodo ()
    {
        return ("ID: "+this.getId()+"\nFecha: "+this.getFecha()+"\nTipo: "+this.getTipo()+
        		"\nMedico: "+this.getMedico()+"\nMedicamiento: "+this.getMedicamento()+
        		"\nAlternadivo: "+this.getAlternativo());
    }
}
