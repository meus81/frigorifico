package modelo.tropa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tropa_reservada")
public class TropaReservada {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_tropa_reservada")
	private int idTropaReservada;
	
	@Column(name="ultima_tropa")
	private int ultimaTropa;

	private int desde;
	private int hasta;
	private int anio;
	
	@OneToOne
	@JoinColumn(name="procedencia_id_procedencia")
	private Procedencia procedencia;
	
	public TropaReservada(){
	}

	public int getDesde() {
		return desde;
	}

	public void setDesde(int desde) {
		this.desde = desde;
	}

	public int getHasta() {
		return hasta;
	}

	public void setHasta(int hasta) {
		this.hasta = hasta;
	}

	public int getUltimaTropa() {
		return ultimaTropa;
	}

	public void setUltima_tropa(int ultimaTropa) {
		this.ultimaTropa = ultimaTropa;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public Procedencia getProcedencia() {
		return procedencia;
	}

	public void setProcedencia(Procedencia procedencia) {
		this.procedencia = procedencia;
	}
	
	public int obtenerSiguienteNroDeTropa() {
		int siguienteNroDeTropa = this.getUltimaTropa() + 1;
		if (siguienteNroDeTropa <=  this.getHasta()){
			this.setUltima_tropa(siguienteNroDeTropa);
		} else {
			//TODO: Levantar un exception!!! Se quedo sin tropas reservadas para esa procedencia
		}
		return this.getUltimaTropa();
	}
}
