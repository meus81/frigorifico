package modelo.establecimiento;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import excepciones.TropaInexistenteException;
import modelo.tropa.Tropa;

@Entity
@Table(name="establecimiento")
public class Establecimiento {
	
	final static Logger logger = Logger.getLogger(Establecimiento.class);
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_establecimiento")
	private int idEstablecimiento;
	
	@Column(name="codigo_establecimiento")
	private String codigoEstablecimiento;
	private String titular;
	private String nombre;
	private long cuit;
	@Column(name="numero_habilitacion")
	private int numeroHabilitacion;
	private String telefono;
	private String direccion;
	private String localidad;
	private String provincia;
	
	@OneToMany(mappedBy="establecimiento")
	@JsonManagedReference
	private List<Tropa> tropas;

	public Establecimiento() {
		this.setTropas(new ArrayList<Tropa>());
	}

	public String getCodigoEstablecimiento() {
		return codigoEstablecimiento;
	}

	public void setCodigoEstablecimiento(String codigoEstablecimiento) {
		this.codigoEstablecimiento = codigoEstablecimiento;
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
