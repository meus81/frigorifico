package servicios.rest;

import java.util.List;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import especie.Especie;
import servicios.CategoriaDAO;
import tropa.Categoria;

@ApplicationPath("/resources")
@Path("/")
public class CategoriaRest {

	@GET
	@Path("/categorias/{id_especie}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Categoria> getCategoriasPorEspecie(@PathParam("id_especie") int idEspecie ){
		CategoriaDAO categoriaDAO = new CategoriaDAO();
		return categoriaDAO.obtenerCategoriasPorEspecie(idEspecie);
	}

}
