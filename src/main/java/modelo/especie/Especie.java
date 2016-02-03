package modelo.especie;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes;

@Entity
@Table(name = "especie")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_especie", discriminatorType = DiscriminatorType.INTEGER)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "descripcion")
@JsonSubTypes({ 
	@JsonSubTypes.Type(value = Ovino.class, name = "Ovino"),
	@JsonSubTypes.Type(value = Porcino.class, name = "Porcino"),
	@JsonSubTypes.Type(value = Vacuno.class, name = "Vacuno")
})
public abstract class Especie implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_especie")
	private int idEspecie;

	@Column(name = "descripcion_especie")
	private String descripcion;
	private String codigo;

	public int getIdEspecie() {
		return idEspecie;
	}

	public void setIdEspecie(int idEspecie) {
		this.idEspecie = idEspecie;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
}
