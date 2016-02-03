package servicios.rest;

import javax.json.JsonObject;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
	@Path("/tropa")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvarTropaCompleta(final Tropa tropa){
		System.out.println("imprimo tropa: " + tropa.getNumeroTropa());
		System.out.println("imprimo animales recibidos: " + tropa.getAnimalesRecibidos());
		System.out.println("Fecha Ingreso: " + tropa.getFechaIngreso());
		System.out.println("Fecha Faena: " + tropa.getFechaFaena());
		System.out.println("Corrales: " + tropa.getCorrales());
		System.out.println("Dte: " + tropa.getDte());
		System.out.println("Especie: " + tropa.getEspecie());
		System.out.println("Establecimiento: " + tropa.getEstablecimiento());
		System.out.println("Animales en tropa: " + tropa.getAnimales());
		
		String result = "Tropa creada";
		TropaDAO tropaDAO = new TropaDAO();
		tropaDAO.salvarTropa(tropa);
		return Response.status(200).entity(result).build();
		
	}
}
