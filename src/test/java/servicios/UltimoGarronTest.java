package servicios;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Test;

public class UltimoGarronTest {
	@Test
	public void ultimoGarron(){
		ServiciosDatabase sd= new ServiciosDatabase();
		Calendar fecha = new GregorianCalendar();
		fecha.set(2015, Calendar.DECEMBER, 1);
		
		System.out.println("El ultimo Garron del dia " + fecha + "es: " + sd.obtenerUltimoNumeroGarron(fecha));
		
	}
	
}