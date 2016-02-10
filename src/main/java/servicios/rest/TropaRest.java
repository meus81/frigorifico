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

import org.json.JSONObject;

import jaxrsBeans.JaxrsTropaBean;
import modelo.tropa.Tropa;
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
	@Path("/tropaJaxrsbean")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response salvarTropaCompleta(final JaxrsTropaBean tropaJaxrsBean){
		
		System.out.println("imprimo tropa: " + tropaJaxrsBean.getNumeroTropa());
		System.out.println("imprimo animales recibidos: " + tropaJaxrsBean.getAnimalesRecibidos());
		System.out.println("Fecha Ingreso: " + tropaJaxrsBean.getFechaIngreso());
		System.out.println("Fecha Faena: " + tropaJaxrsBean.getFechaFaena());
//		System.out.println("Corrales: " + tropaJaxrsBean.getIdCorrales());
//		System.out.println("Dte: " + tropaJaxrsBean.getIdDte());
//		System.out.println("Especie: " + tropaJaxrsBean.getIdEspecie());
//		System.out.println("Establecimiento: " + tropaJaxrsBean.getIdEstablecimiento());
		
		String result = "Result: Tropa creada";
//		TropaDAO tropaDAO = new TropaDAO();
//		tropaDAO.salvarTropa(tropa);
		return Response.status(201).entity(result).build();
		
	}
}
