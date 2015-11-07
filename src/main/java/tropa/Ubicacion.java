package tropa;

public class Ubicacion {
	
	private Corral corral;
	private int cantidadOcupada;
	
	public Ubicacion(Corral corral, int cantidadOcupada) {
		this.setCorral(corral);
		this.setCantidadOcupada(cantidadOcupada);
	}
	
	public Corral getCorral() {
		return corral;
	}
	public void setCorral(Corral corral) {
		this.corral = corral;
	}
	public int getCantidadOcupada() {
		return cantidadOcupada;
	}
	public void setCantidadOcupada(int cantidadOcupada) {
		this.cantidadOcupada = cantidadOcupada;
	}
	
	
	
}
