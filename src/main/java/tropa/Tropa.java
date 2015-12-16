package tropa;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="tropa")
public class Tropa {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_tropa")
	private int idTropa;
	
	@Column(name="numero_tropa")
	private long numeroTropa;
	
	@Column(name="fecha_ingreso")
	private GregorianCalendar fechaIngreso;

	@Column(name="fecha_faena")
	private GregorianCalendar fechaFaena;
	
	@Column(name="animales_recibidos")
	private int animalesRecibidos;
	
	@OneToMany(cascade = {CascadeType.PERSIST})
	@JoinColumn(name="tropa_id_tropa",  nullable=false)
	private List<Animal> animales;
	
	@Transient
	private Set<Corral> corrales;
	@Transient
	private DTe dte;
	
	public Tropa(){
		
	}
	
	public Tropa(int numeroTropa, int animalesRecibidos, DTe dte, Set<Corral> corrales) {

		this.setNumeroTropa(numeroTropa);
		this.setAnimalesRecibidos(animalesRecibidos);
		this.setDte(dte);
		this.setFechaIngreso(new GregorianCalendar());
		this.setCorrales(corrales);
		this.setAnimales(new ArrayList<Animal>());

	}

	public long getNumeroTropa() {
		return numeroTropa;
	}

	public void setNumeroTropa(long numeroTropa) {
		this.numeroTropa = numeroTropa;
	}

	public GregorianCalendar getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(GregorianCalendar fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public GregorianCalendar getFechaFaena() {
		return fechaFaena;
	}

	public void setFechaFaena(GregorianCalendar fechaFaena) {
		this.fechaFaena = fechaFaena;
	}

	public int getAnimalesRecibidos() {
		return animalesRecibidos;
	}

	public void setAnimalesRecibidos(int animalesRecibidos) {
		this.animalesRecibidos = animalesRecibidos;
	}

	public Set<Corral> getCorrales() {
		return corrales;
	}

	public void setCorrales(Set<Corral> corrales) {
		this.corrales = corrales;
	}

	public List<Animal> getAnimales() {
		return animales;
	}

	public void setAnimales(List<Animal> animales) {
		this.animales = animales;
	}

	public DTe getDte() {
		return dte;
	}

	public void setDte(DTe dte) {
		this.dte = dte;
	}

}
