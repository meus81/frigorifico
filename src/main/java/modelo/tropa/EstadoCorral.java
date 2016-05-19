package modelo.tropa;

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

import com.fasterxml.jackson.annotation.JsonSubTypes;


@Entity
@Table(name = "estado_corral")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_estado", discriminatorType = DiscriminatorType.INTEGER)
@JsonSubTypes({ 
	@JsonSubTypes.Type(value = Libre.class, name = "Libre"),
	@JsonSubTypes.Type(value = Ocupado.class, name = "Ocupado"),
	@JsonSubTypes.Type(value = FueraDeServicio.class, name = "Fuera de Servicio")
})
public abstract class EstadoCorral implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_estado")
	private int idEstado;

	public boolean puedeGuardarAnimales() {
		return false;
	}
	
}
