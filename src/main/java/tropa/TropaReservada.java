package tropa;

import java.util.GregorianCalendar;

public class TropaReservada {

	private int desde;
	private int hasta;
	private int ultima_tropa;
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

	public int getUltima_tropa() {
		return ultima_tropa;
	}

	public void setUltima_tropa(int ultima_tropa) {
		this.ultima_tropa = ultima_tropa;
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
		return this.getUltima_tropa() + 1;
	}
}
