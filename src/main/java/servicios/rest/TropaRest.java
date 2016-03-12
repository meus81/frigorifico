package servicios.rest;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import bean.tropa.TropaBean;
import modelo.especie.Especie;
import modelo.establecimiento.Establecimiento;
import modelo.tropa.Tropa;
import servicios.EspecieDAO;
import servicios.EstablecimientoDAO;
import servicios.TropaDAO;



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
	public TropaBean salvarTropaCompleta(final TropaBean tropaBean){
		
		System.out.println("Numero tropa: " + tropaBean.getNumeroTropa());
		System.out.println("Fecha Faena: " + tropaBean.getFechaFaena());
		System.out.println("Estableciento id: " + tropaBean.getEstablecimientoId());
		System.out.println("Especie id: " + tropaBean.getEspecieId());

		EstablecimientoDAO establecimientoDAO = new EstablecimientoDAO();
		Establecimiento establecimiento = establecimientoDAO.obtenerEstablecimiento(tropaBean.getEstablecimientoId());
		
		EspecieDAO especieDAO = new EspecieDAO();
		Especie especie = especieDAO.obtenerEspecie(tropaBean.getEspecieId());
		
		TropaDAO tropaDAO = new TropaDAO();
		Tropa tropa = new Tropa();
		tropa.setNumeroTropa(tropaBean.getNumeroTropa());
		tropa.setEspecie(especie);
		tropa.setEstablecimiento(establecimiento);
		tropa.setFechaFaena(tropaBean.getFechaFaena());
		
		/**TODO no hay forma de que cuando guardemos una tropa nos devuelva el id que le puso???
		 * porque sino despues de guardarla tengo que volver a consultar*/
		tropaDAO.salvarTropa(tropa);
		
		System.out.println("Despues de salvar la tropa, se le asigno el id????");
		System.out.println(tropa.getIdTropa());
		tropaBean.setIdTropa(tropa.getIdTropa());
		
		return tropaBean;
		
	}
}
