package tropa;

public class DTe {
	
	private int numero;
	private int animalesEnviados;
	
	public DTe(int numero, int animalesEnviados) {
		this.setNumero(numero);
		this.setAnimalesEnviados(animalesEnviados);
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getAnimalesEnviados() {
		return animalesEnviados;
	}
	public void setAnimalesEnviados(int animalesEnviados) {
		this.animalesEnviados = animalesEnviados;
	}
	
	
}
