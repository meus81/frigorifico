package excepciones;

public class CorralNoDisponibleParaGuardarAnimalesException extends Exception {

	private static final long serialVersionUID = 1L;

	public String excErrorCorralNoDisponible() {

		return "Error: Se intenta guardar animales en un corral que no esta disponible!";

	}
}
