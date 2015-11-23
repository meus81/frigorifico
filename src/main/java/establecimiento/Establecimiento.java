package establecimiento;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import excepciones.TropaInexistenteException;
import tropa.Tropa;

public class Establecimiento {
	
	final static Logger logger = Logger.getLogger(Establecimiento.class);
		
	private int numeroEstablecimiento;
	private String titular;
	private String nombre;
	private long cuit;
	private int numeroHabilitacion;
	private String telefono;
	private String direccion;
	private String localidad;
	private String provincia;
	private List<Tropa> tropas;
	private List<Long> tropasReservadas;

	public Establecimiento() {
		this.setTropas(new ArrayList<Tropa>());
	}

	public int getNumeroEstablecimiento() {
		return numeroEstablecimiento;
	}

	public void setNumeroEstablecimiento(int numeroEstablecimiento) {
		this.numeroEstablecimiento = numeroEstablecimiento;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public long getCuit() {
		return cuit;
	}

	public void setCuit(long cuit) {
		this.cuit = cuit;
	}

	public int getNumeroHabilitacion() {
		return numeroHabilitacion;
	}

	public void setNumeroHabilitacion(int numeroHabilitacion) {
		this.numeroHabilitacion = numeroHabilitacion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public List<Tropa> getTropas() {
		return tropas;
	}

	public void setTropas(List<Tropa> tropas) {
		this.tropas = tropas;
	}

	public List<Long> getTropasReservadas() {
		return tropasReservadas;
	}

	public void setTropasReservadas(List<Long> tropasReservadas) {
		this.tropasReservadas = tropasReservadas;
	}

	public int cantidadTropas() {

		return this.getTropas().size();
	}

	public void agregarTropa(Tropa tropa) {
		this.getTropas().add(tropa);
		logger.debug("Estoy agregando la tropa numero:" + tropa.getNumeroTropa());

	}

	public Tropa obtenerTropa(int numeroTropa) throws TropaInexistenteException {
		for (Tropa tropa : this.getTropas()) {
			if (tropa.getNumeroTropa() == numeroTropa){
				logger.debug("Estoy obteniendo la tropa numero:" + tropa.getNumeroTropa());
				return tropa;
			}
		}
		throw new TropaInexistenteException();
	}

	public boolean eliminarTropa(int numeroTropa) {
		for (Tropa tropa : this.getTropas()) {
			if (tropa.getNumeroTropa() == numeroTropa) {
				this.getTropas().remove(tropa);
				logger.debug("Estoy eliminando la tropa numero:" + tropa.getNumeroTropa());
				return true;
			}
		}
		logger.debug("No pude eliminar la tropa numero:" + numeroTropa +" porque no la encobtre");
		return false;
	}

}
