package modelo.tropa;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="animal")
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class,
		  property = "idAnimal")
public class Animal implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_animal")
	private int idAnimal;
	private int garron;
	private double peso;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "categoria_id_categoria", nullable = false, updatable = false)
	private Categoria categoria;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="tropa_id_tropa")
	private Tropa tropa;
	
	@Column(name="cabeza_faenada_entera")
	private boolean cabezaFaenadaEntera;
	
	public int getGarron() {
		return garron;
	}

	public void setGarron(int garron) {
		this.garron = garron;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public int getIdAnimal() {
		return idAnimal;
	}

	public void setIdAnimal(int idAnimal) {
		this.idAnimal = idAnimal;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Tropa getTropa() {
		return tropa;
	}

	public void setTropa(Tropa tropa) {
		this.tropa = tropa;
	}

	public boolean isCabezaFaenadaEntera() {
		return cabezaFaenadaEntera;
	}

	public void setCabezaFaenadaEntera(boolean cabezaFaenadaEntera) {
		this.cabezaFaenadaEntera = cabezaFaenadaEntera;
	}
	
	
}
