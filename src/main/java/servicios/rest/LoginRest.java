package servicios.rest;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import bean.usuario.Usuario;

@ApplicationPath("/resources")
@Path("/")
public class LoginRest {

	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Usuario loguearse(final Usuario usuario){
		usuario.setIdUsuario(1);
		
		return usuario;
	}
}
