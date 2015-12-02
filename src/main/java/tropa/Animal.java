package tropa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="animal")
public class Animal {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name="id_animal")
	private int idAnimal;
	private int garron;
	private double peso;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "id_categoria", nullable = false, updatable = false)
	private Categoria categoria;
	
	
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

}
