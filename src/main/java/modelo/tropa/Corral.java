package modelo.tropa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="corral")
public class Corral implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_corral")
	private int idCorral;
	
	private int numero;
	private int capacidad;
	
	@OneToOne
	@JoinColumn(name = "estado_id_estado")
	private EstadoCorral estado;
	
	
	public Corral(){
		
	}
	
	public Corral(int numero, int capacidad, EstadoCorral estadoCorral) {
		this.setNumero(numero);
		this.setCapacidad(capacidad);
		this.setEstado(estadoCorral);
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

	public EstadoCorral getEstado() {
		return estado;
	}

	public void setEstado(EstadoCorral estado) {
		this.estado = estado;
	}

	public void cambiarLibreAOcupado() {
		this.setEstado(new Ocupado());
		
	}

	public boolean puedeGuardarAnimales() {
		return this.getEstado().puedeGuardarAnimales();
	}
}
