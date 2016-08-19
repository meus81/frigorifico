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
import javax.ws.rs.core.Response;

import bean.tropa.TropaBean;
import especie.Especie;
import establecimiento.Establecimiento;
import servicios.EspecieDAO;
import servicios.EstablecimientoDAO;
import servicios.ProcedenciaDAO;
import servicios.TropaDAO;
import servicios.TropaReservadaDAO;
import tropa.Procedencia;
import tropa.Tropa;
import tropa.TropaReservada;


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
	
	@GET
	@Path("/siguiente_tropa/{id_procedencia}")
	@Produces(MediaType.APPLICATION_JSON)
	public TropaReservada obtenerSiguienteNumeroTropa(@PathParam("id_procedencia") int idProcedencia) {
		System.out.println("El id del parametro de tropa " + idProcedencia);
		ProcedenciaDAO procedenciaDAO = new ProcedenciaDAO();
		Procedencia procedencia = procedenciaDAO.obtenerProcedencia(idProcedencia);
		
		TropaReservadaDAO tropaReservadaDAO = new TropaReservadaDAO();
		return tropaReservadaDAO.obtenerTropaReservadaPorProcedenciaYanioActual(procedencia);
	}
	
	@POST
	@Path("/nueva_tropa_en_palco")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public TropaBean salvarTropaEnPalco(final TropaBean tropaBean){
		

		EstablecimientoDAO establecimientoDAO = new EstablecimientoDAO();
		Establecimiento establecimiento = establecimientoDAO.obtenerEstablecimiento(tropaBean.getEstablecimientoId());
		
		EspecieDAO especieDAO = new EspecieDAO();
		Especie especie = especieDAO.obtenerEspecie(tropaBean.getEspecieId());
		
		ProcedenciaDAO procedenciaDAO = new ProcedenciaDAO();
		Procedencia procedencia = procedenciaDAO.obtenerProcedencia(tropaBean.getProcendeciaId());
		
		TropaReservadaDAO tropaReservadaDAO = new TropaReservadaDAO();
		TropaReservada tropaReservada = tropaReservadaDAO.obtenerTropaReservadaPorProcedenciaYanioActual(procedencia);
		int ultimoNroTropaReservada = tropaBean.getNumeroTropa();
		
		System.out.println("Estableciento id: " + tropaBean.getEstablecimientoId());
		System.out.println("Especie id: " + tropaBean.getEspecieId());
		System.out.println("Procedencia Id: " + tropaBean.getProcendeciaId());
		System.out.println("Ultimo numero de tropa reservada: " + ultimoNroTropaReservada);
		System.out.println("" );
		
		
		TropaDAO tropaDAO = new TropaDAO();
		Tropa tropa = new Tropa();
		tropa.setNumeroTropa(ultimoNroTropaReservada);
		tropa.setEspecie(especie);
		tropa.setProcedencia(procedencia);
		tropa.setEstablecimiento(establecimiento);

		tropa.setFechaFaena(new GregorianCalendar().getTime());
		//TODO averiguar como hacerlo en una transaccion
		tropaDAO.salvarTropa(tropa);
		tropaReservadaDAO.actualizar(tropaReservada);
		tropaBean.setIdTropa(tropa.getIdTropa());
		
		System.out.println("Id de tropa guardado: " + tropa.getIdTropa());
		tropaBean.setFechaFaena(tropa.getFechaFaena());
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
	}
	
	@GET
	@Path("/verificar_tropa_faenada/{nro_tropa}/{id_procedencia}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response verificar_nro_tropa_faenada(@PathParam("nro_tropa") int nroTropa, 
												@PathParam("id_procedencia") int idProcedencia) {
		System.out.println("El nro de tropa es " + nroTropa);
		System.out.println("El nro de procedencia es " + idProcedencia);
		
		TropaDAO tropaDao = new TropaDAO();
		Tropa tropa = tropaDao.obtenerTropaPorNroTropa(nroTropa, idProcedencia);
		if (tropa != null){
			if (tropa.getFechaFaena() != null){
				String json = "{\"result\": \"true\"}";
				return Response.status(200).header("Access-Control-Allow-Methods","GET, POST, PUT, DELETE, OPTIONS, HEAD")
						.entity(json).build();
			}
		}
		
		String json = "{\"result\": \"false\"}";
		return Response.status(200).header("Access-Control-Allow-Methods","GET, POST, PUT, DELETE, OPTIONS, HEAD")
				.entity(json).build();

	}
	
}
