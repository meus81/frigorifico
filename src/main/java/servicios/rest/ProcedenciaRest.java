package servicios.rest;

import java.util.List;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import tropa.Procedencia;
import servicios.ProcedenciaDAO;


@ApplicationPath("/resources")
@Path("/")


public class ProcedenciaRest {

	
	@GET
	@Path("/procedencia/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Procedencia getProcedencia(@PathParam("id") int id ){
		System.out.println("El id del parametro de procedencia " + id);
		ProcedenciaDAO procedenciaDAO = new ProcedenciaDAO();
		return procedenciaDAO.obtenerProcedencia(id);
	}

	@GET
	@Path("/procedencias")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Procedencia> getProcedencias(){
		System.out.println("invocando el servicio para obtener todas las procedencias");
		ProcedenciaDAO procedenciaDAO = new ProcedenciaDAO();
		return procedenciaDAO.obtenerProcedencias();
	}
}
