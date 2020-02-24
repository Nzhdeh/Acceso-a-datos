package clases;

public class AlternativoImpl extends Receta.Alternativo
{
	public AlternativoImpl(Receta.Alternativo.Medicamento m)
	{
		this.medicamento=m;		
	}
	
	@Override
	public String toString()
	{
		return ("Nombre: "+this.getMedicamento().getNombre()+"\nLaboratorio: "+this.getMedicamento().getLaboratorio()
				+"\nPresentacion: "+this.getMedicamento().getPresentacion());
		
	}
}
