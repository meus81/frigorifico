package jaxrsBeans;

import java.util.ArrayList;
import java.util.Date;


import com.fasterxml.jackson.annotation.JsonFormat;

public class TropaJaxrsBean {
	
	private int idTropa;
	private int numeroTropa;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss.SSS", locale="es-AR", timezone="America/Argentina/Buenos_Aires")
	private Date fechaIngreso;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss.SSS", locale="es-AR", timezone="America/Argentina/Buenos_Aires")
	private Date fechaFaena;
	
	private int animalesRecibidos;
	private int idEstablecimiento;
	private int idEspecie;
	private int idDte;
	private ArrayList<Integer> idCorrales;
	
	public int getIdTropa() {
		return idTropa;
	}
	public void setIdTropa(int idTropa) {
		this.idTropa = idTropa;
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
	
	public int getIdEstablecimiento() {
		return idEstablecimiento;
	}
	public void setIdEstablecimiento(int idEstablecimiento) {
		this.idEstablecimiento = idEstablecimiento;
	}
	
	public int getIdEspecie() {
		return idEspecie;
	}
	public void setIdEspecie(int idEspecie) {
		this.idEspecie = idEspecie;
	}

	public int getIdDte() {
		return idDte;
	}
	public void setIdDte(int idDte) {
		this.idDte = idDte;
	}
	public ArrayList<Integer> getIdCorrales() {
		return idCorrales;
	}
	public void setIdCorrales(ArrayList<Integer> idCorrales) {
		this.idCorrales = idCorrales;
	}
	
	
}
