package modelo.tropa;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import excepciones.CorralNoDisponibleParaGuardarAnimalesException;
import excepciones.MayorCantidadAnimalesQueCapacidadCorralException;

@Entity
@Table(name="tropa_corral")
@IdClass(TropaCorralId.class)

public class TropaCorral implements Serializable{
	
	@Id	
	private int tropa_id_tropa;
	
	@Id
	private int corral_id_corral;
	
	@Column
	private int ocupacion;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss.SSS", locale="es-AR", timezone="America/Argentina/Buenos_Aires")
	@Column(name="fecha_egreso")
	private Date fechaEgreso;

	@ManyToOne
	@JoinColumn(name = "tropa_id_tropa", updatable = false, insertable = false, referencedColumnName= "id_tropa")
	private Tropa tropa;
	
	@ManyToOne
	@JoinColumn(name = "corral_id_corral", updatable = false, insertable = false)
	private Corral corral;

	public int getOcupacion() {
		return ocupacion;
	}

	public void setOcupacion(int ocupacion)
			throws MayorCantidadAnimalesQueCapacidadCorralException, CorralNoDisponibleParaGuardarAnimalesException {
		if (ocupacion <= this.getCorral().getCapacidad()){
			if (this.getCorral().puedeGuardarAnimales()) {
				this.ocupacion = ocupacion;
				this.getCorral().cambiarLibreAOcupado();
			}
			else {
				throw new CorralNoDisponibleParaGuardarAnimalesException();
			}
		} else{
			throw new MayorCantidadAnimalesQueCapacidadCorralException();
		}
	}

	public Date getFechaEgreso() {
		return fechaEgreso;
	}

	public void setFechaEgreso(Date fechaEgreso) {
		this.fechaEgreso = fechaEgreso;
	}

	public Tropa getTropa() {
		return tropa;
	}

	public void setTropa(Tropa tropa) {
		this.tropa = tropa;
	}

	public Corral getCorral() {
		return corral;
	}

	public void setCorral(Corral corral) {
		this.corral = corral;
	}
}
