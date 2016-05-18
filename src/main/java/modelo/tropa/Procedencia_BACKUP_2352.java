package modelo.tropa;

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
	
	public int getIdProcedencia() {
		return idProcedencia;
	}
	public void setIdProcedencia(int idProcedencia) {
		this.idProcedencia = idProcedencia;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
