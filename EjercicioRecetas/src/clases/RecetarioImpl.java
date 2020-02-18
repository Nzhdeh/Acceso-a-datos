package clases;

import java.util.ArrayList;
import java.util.List;

public class RecetarioImpl extends Recetario
{
	protected List<RecetaImpl> receta;
	
	@Override
	public List<Receta> getReceta() {
		// TODO Auto-generated method stub
		return super.getReceta();
	}
	public List<RecetaImpl> obtenerReceta() {
		if (receta == null) {
            receta = new ArrayList<RecetaImpl>();
        }
        return this.receta;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}

}
