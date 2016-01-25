package servicios;

import modelo.tropa.Procedencia;

public class ProcedenciaDAO extends DAO {
	
	public Procedencia obtenerProcedencia(int id){
		return (Procedencia)this.obtener(Procedencia.class, id);
	}
}
