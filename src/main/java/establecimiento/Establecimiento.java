package establecimiento;

import java.util.ArrayList;
import java.util.List;

import excepciones.TropaInexistenteException;
import tropa.Tropa;

public class Establecimiento {
	private long cuit;
	private String nombre;
	private List<Tropa> tropas;
	
	public Establecimiento(){
		this.setTropas(new ArrayList<Tropa>());
	}

	public long getCuit() {
		return cuit;
	}

	public void setCuit(long cuit) {
		this.cuit = cuit;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Tropa> getTropas() {
		return tropas;
	}

	public void setTropas(List<Tropa> tropas) {
		this.tropas = tropas;
	}

	public int cantidadTropas() {

		return this.getTropas().size();
	}

	public void agregarTropa(Tropa tropa) {
		this.getTropas().add(tropa);

	}

	public Tropa obtenerTropa(int numeroTropa) throws TropaInexistenteException {
		for (Tropa tropa : this.getTropas()) {
			if (tropa.getNumeroTropa() == numeroTropa)
				return tropa;
		}
		throw new TropaInexistenteException();
	}

	public boolean eliminarTropa(int numeroTropa)  {
		for (Tropa tropa : this.getTropas()) {
			if (tropa.getNumeroTropa() == numeroTropa){
				this.getTropas().remove(tropa);
				return true;
			}	
		}
		return false;
	}

	public int cantidadTotalTropas() {
		return this.getTropas().size();
		
	}

}
