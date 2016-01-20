package tropa;

public class TropaReservada {

	private int desde;
	private int hasta;
	private int ultimaTropa;
	private int anio;
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
	
	public int obtenerProximaTropa(Procedencia procedencia, int anio){
		return this.getUltimaTropa() + 1;
	}

	public void obtenerSiguienteNroDeTropa() {
		int siguienteNroDeTropa = this.getUltimaTropa() + 1;
		if (siguienteNroDeTropa <=  this.getHasta()){
			this.setUltima_tropa(siguienteNroDeTropa);
		} else {
			//TODO: Levantar un exception!!!
		}
	}
}
