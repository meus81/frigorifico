package tropa;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.Set;

public class Tropa {
	
	private long numeroTropa;
	private GregorianCalendar fechaIngreso;
	private int animalesRecibidos;
	private Set<Ubicacion> ubicaciones;
	private List<Animal> animales;
	private DTe dte;
	
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
	public int getAnimalesRecibidos() {
		return animalesRecibidos;
	}
	public void setAnimalesRecibidos(int animalesRecibidos) {
		this.animalesRecibidos = animalesRecibidos;
	}
	public Set<Ubicacion> getUbicaciones() {
		return ubicaciones;
	}
	public void setUbicaciones(Set<Ubicacion> ubicaciones) {
		this.ubicaciones = ubicaciones;
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
