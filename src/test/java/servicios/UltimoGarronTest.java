package servicios;

import java.util.Date;

import org.junit.Test;

public class UltimoGarronTest {
	@Test
	public void ultimoGarron(){
		ServiciosDatabase sd= new ServiciosDatabase();
		Date fecha = new Date();
		fecha.setYear(2015);
		fecha.setMonth(12);
		fecha.setDate(01);
		fecha.setHours(15);
		fecha.setMinutes(20);
		fecha.setSeconds(10);
		
		System.out.println("El ultimo Garron del dia " + fecha + "es: " + sd.obtenerUltimoNumeroGarron(fecha));
		
	}
	
}