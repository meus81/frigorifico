package establecimiento;

public class Establecimiento {
	private long cuit;
	private String nombre;
	private List <Tropa> tropas;
	public long getCuit() {
		return cuit;
	}
	public void setCuit(long cuit) {
		this.cuit = cuit;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<Tropa> getTropas() {
		return tropas;
	}
	public void setTropas(List<Tropa> tropas) {
		this.tropas = tropas;
	}
	
}
