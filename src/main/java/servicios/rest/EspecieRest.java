package servicios.rest;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import modelo.especie.Especie;
import servicios.EspecieDAO;

@ApplicationPath("/resources")
@Path("/")
public class EspecieRest {
	
	@GET
	@Path("/especie/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Especie getEspecie(@PathParam("id") int id ){
		System.out.println("El id del parametro de especie " + id);
		EspecieDAO especieDAO = new EspecieDAO();
		return especieDAO.obtenerEspecie(id);
	}
}
