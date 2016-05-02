package excepciones;

public class MayorCantidadAnimalesQueCapacidadCorralException extends Exception {

	private static final long serialVersionUID = 1L;

	public String excErrorMayorCantidadAnimalesQueCapaidadEnCorral() {

		return "Error: Se intenta asignar una mayor cantidad de animales que la capacidad del corral";

	}

}
