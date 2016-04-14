package modelo.tropa;

import java.util.GregorianCalendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="corral")
public class Corral {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_corral")
	private int idCorral;
	
	private int numero;
	private int capacidad;
	private int ocupacion;
	
	@Column(name="fecha_egreso")
	private GregorianCalendar fechaEgreso;
	
	public Corral(){
		
	}
	
	public Corral(int numero, int capacidad) {
		this.setNumero(numero);
		this.setCapacidad(capacidad);
	}
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public int getOcupacion() {
		return ocupacion;
	}

	public void setOcupacion(int ocupacion) {
		this.ocupacion = ocupacion;
	}

	public GregorianCalendar getFechaEgreso() {
		return fechaEgreso;
	}

	public void setFechaEgreso(GregorianCalendar fechaEgreso) {
		this.fechaEgreso = fechaEgreso;
	}
	
	

}
