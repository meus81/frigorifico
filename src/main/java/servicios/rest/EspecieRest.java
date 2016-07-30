package servicios.rest;

import java.util.List;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import especie.Especie;
import servicios.EspecieDAO;

@ApplicationPath("/resources")
@Path("/")
public class EspecieRest {
	
	@GET
	@Path("/especie/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Especie getEspecie(@PathParam("id") Long id ){
		System.out.println("El id del parametro de especie " + id);
		EspecieDAO especieDAO = new EspecieDAO();
		return especieDAO.obtenerEspecie(id);
	}

	@GET
	@Path("/especies")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Especie> getEspecies(){
		System.out.println("invocando el servicio para obtener todas las especies");
		EspecieDAO especieDAO = new EspecieDAO();
		return especieDAO.obtenerEspecies();
	}
	
}
