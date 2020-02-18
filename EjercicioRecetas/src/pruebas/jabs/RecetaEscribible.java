package pruebas.jabs;
import clases.*;
// Derivamos la clase Atomo para añadirle un método que devuelva una cadena con todos los datos del Atomo
public class RecetaEscribible extends RecetaImpl {
    
    public RecetaEscribible (RecetaImpl p){
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
        return ("ID: "+this.getId()+"\nFecha: "+this.getFecha().toString()+"\nTipo: "+this.getTipo()+
        		"\nMedico: "+this.getMedico().toString()+"\nMedicamiento: "+this.getMedicamento().toString()+
        		"\nAlternadivo: "+this.getAlternativo().toString());
    }
    
//    public String getTodo ()
//    {
//        return ("ID: "+this.getId()+"\nFecha: "+this.getFecha().toString()+"\nTipo: "+this.getTipo()+
//        		"\nMedico: "+this.getMedico().toString()+"\nMedicamiento: "+this.getMedicamento().toString()+
//        		"\nAlternadivo: "+this.getAlternativo().toString());
//    }
}
