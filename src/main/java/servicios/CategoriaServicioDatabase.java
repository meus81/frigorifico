package servicios;

import tropa.Categoria;

public class CategoriaServicioDatabase extends ServiciosDatabase{

	public Categoria obtenerCategoria(int id){
		return (Categoria)this.obtener(Categoria.class, id);
	}
	
}
