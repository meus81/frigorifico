package jaxrsBeans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class JaxrsTropaBean implements Serializable{

	private int idTropa;
	private int numeroTropa;
	
	//@Temporal(TemporalType.DATE)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss.SSS", locale="es-AR", 
			    timezone="America/Argentina/Buenos_Aires")
	private Date fechaIngreso;

	//@Type(type="date")
	//@Temporal(TemporalType.DATE)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss.SSS", locale="es-AR", 
			    timezone="America/Argentina/Buenos_Aires")
	private Date fechaFaena;
	private int animalesRecibidos;
	
	
	
	public JaxrsTropaBean(){
		
	}
	
	public int getNumeroTropa() {
		return numeroTropa;
	}

	public void setNumeroTropa(int numeroTropa) {
		this.numeroTropa = numeroTropa;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Date getFechaFaena() {
		return fechaFaena;
	}

	public void setFechaFaena(Date fechaFaena) {
		this.fechaFaena = fechaFaena;
	}

	public int getAnimalesRecibidos() {
		return animalesRecibidos;
	}

	public void setAnimalesRecibidos(int animalesRecibidos) {
		this.animalesRecibidos = animalesRecibidos;
	}

}
