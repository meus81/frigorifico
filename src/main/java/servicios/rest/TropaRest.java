package servicios.rest;

import java.util.GregorianCalendar;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import bean.tropa.TropaBean;
import modelo.especie.Especie;
import modelo.establecimiento.Establecimiento;
import modelo.tropa.Procedencia;
import modelo.tropa.Tropa;
import modelo.tropa.TropaReservada;
import servicios.EspecieDAO;
import servicios.EstablecimientoDAO;
import servicios.ProcedenciaDAO;
import servicios.TropaDAO;
import servicios.TropaReservadaDAO;


@ApplicationPath("/resources")
@Path("/")
public class TropaRest {
	
	@GET
	@Path("/tropa/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Tropa obtenerTropa(@PathParam("id") int id) {
		System.out.println("El id del parametro de tropa " + id);
		TropaDAO tropaDAO = new TropaDAO();
		return tropaDAO.obtenerTropa(id);
	}
	
	@POST
	@Path("/nueva_tropa_en_palco")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public TropaBean salvarTropaEnPalco(final TropaBean tropaBean){
		
		System.out.println("Estableciento id: " + tropaBean.getEstablecimientoId());
		System.out.println("Especie id: " + tropaBean.getEspecieId());
		System.out.println("Procedencia Id: " + tropaBean.getProcendeciaId());

		EstablecimientoDAO establecimientoDAO = new EstablecimientoDAO();
		Establecimiento establecimiento = establecimientoDAO.obtenerEstablecimiento(tropaBean.getEstablecimientoId());
		
		EspecieDAO especieDAO = new EspecieDAO();
		Especie especie = especieDAO.obtenerEspecie(tropaBean.getEspecieId());
		
		ProcedenciaDAO procedenciaDAO = new ProcedenciaDAO();
		Procedencia procedencia = procedenciaDAO.obtenerProcedencia(tropaBean.getProcendeciaId());
		
		TropaReservadaDAO tropaReservadaDAO = new TropaReservadaDAO();
		TropaReservada tropaReservada = tropaReservadaDAO.obtenerTropaReservadaPorProcedenciaYanioActual(procedencia);
		int ultimoNroTropaReservada = tropaReservada.obtenerSiguienteNroDeTropa();

		TropaDAO tropaDAO = new TropaDAO();
		Tropa tropa = new Tropa();
		tropa.setNumeroTropa(ultimoNroTropaReservada);
		tropa.setEspecie(especie);
		tropa.setEstablecimiento(establecimiento);
		tropa.setAnimalesRecibidos(tropaBean.getAnimalesRecibidos());
		tropa.setFechaFaena(new GregorianCalendar().getTime());
		//averiguar como hacerlo en una transaccion
		tropaDAO.salvarTropa(tropa);
		tropaReservadaDAO.actualizar(tropaReservada);
		
		tropaBean.setIdTropa(tropa.getIdTropa());
		tropaBean.setNumeroTropa(ultimoNroTropaReservada);
		
		return tropaBean;		
	}
	
	@POST
	@Path("/nueva_tropa")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public TropaBean salvarTropa(final TropaBean tropaBean, @Context HttpServletResponse response){
		System.out.println("Estableciento id: " + tropaBean.getEstablecimientoId());
		System.out.println("Especie id: " + tropaBean.getEspecieId());
		
		tropaBean.setIdTropa(100);
		System.out.println(tropaBean);
		return tropaBean;
//		return Response
//				.status(200)
//				.header("Access-Control-Allow-Origin", "*")
//				.header("Access-Control-Allow-Headers",
//				        "origin, content-type, accept, authorization")
//				.header("Access-Control-Allow-Credentials", "true")
//				.header("Access-Control-Allow-Methods",
//				        "GET, POST, PUT, DELETE, OPTIONS, HEAD")
//				.header("Access-Control-Max-Age", "1209600")
//				.entity(tropaBean)
//				.build();
	}
}
