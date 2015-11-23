package tropa;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Set;

public class Tropa {

	private long numeroTropa;
	private GregorianCalendar fechaIngreso;
	private GregorianCalendar fechaFaena;
	private int animalesRecibidos;
	private Set<Corral> corrales;
	private List<Animal> animales;
	private DTe dte;

	public Tropa(int numeroTropa, int animalesRecibidos, DTe dte, Set<Corral> corrales) {

		this.setNumeroTropa(numeroTropa);
		this.setAnimalesRecibidos(animalesRecibidos);
		this.setDte(dte);
		this.setFechaIngreso(new GregorianCalendar());
		this.setCorrales(corrales);
		this.setAnimales(new ArrayList<Animal>());

	}

	public long getNumeroTropa() {
		return numeroTropa;
	}

	public void setNumeroTropa(long numeroTropa) {
		this.numeroTropa = numeroTropa;
	}

	public GregorianCalendar getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(GregorianCalendar fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public GregorianCalendar getFechaFaena() {
		return fechaFaena;
	}

	public void setFechaFaena(GregorianCalendar fechaFaena) {
		this.fechaFaena = fechaFaena;
	}

	public int getAnimalesRecibidos() {
		return animalesRecibidos;
	}

	public void setAnimalesRecibidos(int animalesRecibidos) {
		this.animalesRecibidos = animalesRecibidos;
	}

	public Set<Corral> getCorrales() {
		return corrales;
	}

	public void setCorrales(Set<Corral> corrales) {
		this.corrales = corrales;
	}

	public List<Animal> getAnimales() {
		return animales;
	}

	public void setAnimales(List<Animal> animales) {
		this.animales = animales;
	}

	public DTe getDte() {
		return dte;
	}

	public void setDte(DTe dte) {
		this.dte = dte;
	}

}
