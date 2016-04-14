package modelo.tropa;

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

import com.fasterxml.jackson.annotation.JsonFormat;

import modelo.especie.Especie;
import modelo.establecimiento.Establecimiento;

@Entity
@Table(name="tropa")
public class Tropa implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_tropa")
	private int idTropa;
	
	@Column(name="numero_tropa")
	private int numeroTropa;
	
	@Column(name="fecha_ingreso")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss.SSS", locale="es-AR", timezone="America/Argentina/Buenos_Aires")
	private Date fechaIngreso;

	@Column(name="fecha_faena")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss.SSS", locale="es-AR", timezone="America/Argentina/Buenos_Aires")
	private Date fechaFaena;
	
	@Column(name="animales_recibidos")
	private int animalesRecibidos;
	
	@OneToMany(mappedBy="tropa")
	private List<Animal> animales;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="establecimiento_id_establecimiento")
	private Establecimiento establecimiento;
	
	@OneToOne
	@JoinColumn(name="especie_id_especie")
	private Especie especie;
	
	@OneToOne
	@JoinColumn(name="")
	private Set<Corral> corrales;
	
	@Transient
	private DTe dte;
	
	public Tropa(){
		
	}
	
	public Tropa(int numeroTropa, int animalesRecibidos, DTe dte, Set<Corral> corrales) {
		this.setNumeroTropa(numeroTropa);
		this.setAnimalesRecibidos(animalesRecibidos);
		this.setDte(dte);
		this.setFechaIngreso(new Date());
		this.setCorrales(corrales);
		this.setAnimales(new ArrayList<Animal>());

	}

	public int getIdTropa() {
		return idTropa;
	}

	public void setIdTropa(int idTropa) {
		this.idTropa = idTropa;
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

	public Establecimiento getEstablecimiento() {
		return establecimiento;
	}
	
	public void setEstablecimiento(Establecimiento establecimiento) {
		this.establecimiento = establecimiento;
	}
	
	public List<Animal> getAnimales() {
		return animales;
	}
	
	public void setAnimales(List<Animal> animales) {
		this.animales = animales;
	}

	public Especie getEspecie() {
		return especie;
	}

	public void setEspecie(Especie especie) {
		this.especie = especie;
	}

	public Set<Corral> getCorrales() {
		return corrales;
	}

	public void setCorrales(Set<Corral> corrales) {
		this.corrales = corrales;
	}

	public DTe getDte() {
		return dte;
	}

	public void setDte(DTe dte) {
		this.dte = dte;
	}
	
	public void agregarAnimal(Animal animal){
		this.getAnimales().add(animal);
	}

}
