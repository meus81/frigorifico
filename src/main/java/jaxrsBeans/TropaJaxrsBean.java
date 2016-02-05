package jaxrsBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import modelo.especie.Especie;
import modelo.establecimiento.Establecimiento;
import modelo.tropa.Animal;
import modelo.tropa.Corral;
import modelo.tropa.DTe;

public class TropaJaxrsBean implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;

	private int idTropa;
	
	private int numeroTropa;
	
	//@Temporal(TemporalType.DATE)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss.SSS", locale="es-AR", timezone="America/Argentina/Buenos_Aires")
	private Date fechaIngreso;

	//@Type(type="date")
	//@Temporal(TemporalType.DATE)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss.SSS", locale="es-AR", timezone="America/Argentina/Buenos_Aires")
	private Date fechaFaena;
	
	private int animalesRecibidos;
	
	/*ESTO NO ANDABA PORQUE EXIGE UNA LISTA DE TIPO
	 * ANIMAL Y NO SABEMOS PORQUE CHOTA!
	 * */
	private List<Animal> animales;
	
	
	public TropaJaxrsBean(){
		
	}
	
	public TropaJaxrsBean(int numeroTropa, int animalesRecibidos, DTe dte, Set<Corral> corrales) {
		this.setNumeroTropa(numeroTropa);
		this.setAnimalesRecibidos(animalesRecibidos);
		this.setFechaIngreso(new Date());

	}

	public int getNumeroTropa() {
		return numeroTropa;
	}

	public void setNumeroTropa(int numeroTropa) {
		this.numeroTropa = numeroTropa;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Date getFechaFaena() {
		return fechaFaena;
	}

	public void setFechaFaena(Date fechaFaena) {
		this.fechaFaena = fechaFaena;
	}

	public int getAnimalesRecibidos() {
		return animalesRecibidos;
	}

	public void setAnimalesRecibidos(int animalesRecibidos) {
		this.animalesRecibidos = animalesRecibidos;
	}

	public List<Animal> getAnimales() {
		return animales;
	}
	
	public void setAnimales(List<Animal> animales) {
		this.animales = animales;
	}

}
