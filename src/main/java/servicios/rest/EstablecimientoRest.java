package servicios.rest;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import establecimiento.Establecimiento;
import servicios.EstablecimientoDAO;

@ApplicationPath("/resources")
@Path("/")
public class EstablecimientoRest {
	
	@GET
	@Path("/verify")
	@Produces(MediaType.TEXT_PLAIN)
	public Response verifyRESTService() {
		String result = "FrigorificoRESTService Successfully started..";
		// return HTTP response 200 in case of success
		return Response.status(200).entity(result).build();
	}
	
	@GET
	@Path("/establecimiento/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Establecimiento getEstablecimiento(@PathParam("id") Long id ){
		System.out.println("El id del parametro de establecimiento " + id);
		EstablecimientoDAO establecimientoDAO = new EstablecimientoDAO();
		return establecimientoDAO.obtenerEstablecimiento(id);
	}
}
