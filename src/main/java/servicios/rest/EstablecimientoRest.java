package servicios.rest;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import modelo.establecimiento.Establecimiento;
import servicios.EstablecimientoDAO;

@ApplicationPath("/resources")
@Path("/")
public class EstablecimientoRest {
	
	@GET
	@Path("/establecimiento/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Establecimiento getEstablecimiento(@PathParam("id") int id ){
		System.out.println("El id del parametro de establecimiento " + id);
		EstablecimientoDAO establecimientoDAO = new EstablecimientoDAO();
		return establecimientoDAO.obtenerEstablecimiento(id);
	}
}
