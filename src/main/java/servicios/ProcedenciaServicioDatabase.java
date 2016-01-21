package servicios;

import tropa.Procedencia;

public class ProcedenciaServicioDatabase extends ServiciosDatabase {
	
	public Procedencia obtenerProcedencia(int id){
		return (Procedencia)this.obtener(Procedencia.class, id);
	}
}
