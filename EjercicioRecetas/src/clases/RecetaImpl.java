package clases;

import java.util.ArrayList;
import java.util.List;

public class RecetaImpl extends Receta
{
	public RecetaImpl() 
	{
		super();
	}
	
	public RecetaImpl(String fecha,Byte id,clases.Medicamento medi,Medico medico,String tipo,List<RecetaImpl.Alternativo> alternativo) 
	{
		this.alternativo= alternativo;
		this.fecha=fecha;
		this.id=id;
		this.medicamento=medi;
		this.medico=medico;
		this.tipo=tipo;
	}
	
	public RecetaImpl(Receta r) 
	{
		this.alternativo= r.alternativo;
		this.fecha=r.fecha;
		this.id=r.id;
		this.medicamento=r.medicamento;
		this.medico=r.medico;
		this.tipo=r.tipo;
	}
	
	public String getTodo ()
    {
        return ("ID: "+this.getId()+"\nFecha: "+this.getFecha().toString()+"\nTipo: "+this.getTipo()+
        		"\nMedico: "+this.getMedico().toString()+"\nMedicamiento: "+this.getMedicamento().toString()+
        		"\nAlternadivo: "+this.getAlternativo().toString());
    }
}