package tropa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="procedencia")
public class Procedencia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_procedencia")
	private int idProcedencia;
	private String descripcion;
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getId() {
		return idProcedencia;
	}

	public void setId(int idProcedencia) {
		this.idProcedencia = idProcedencia;
	}
	
}
