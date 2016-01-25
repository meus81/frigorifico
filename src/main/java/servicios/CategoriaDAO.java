package servicios;

import modelo.tropa.Categoria;

public class CategoriaDAO extends DAO{

	public Categoria obtenerCategoria(int id){
		return (Categoria)this.obtener(Categoria.class, id);
	}
	
}
