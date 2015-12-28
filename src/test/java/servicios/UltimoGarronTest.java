package servicios;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;

public class UltimoGarronTest {
	@Test
	public void ultimoGarron(){
		ServiciosDatabase sd= new ServiciosDatabase();
		GregorianCalendar fecha = new GregorianCalendar();
		fecha.set(2015, Calendar.DECEMBER, 1, 15, 20, 10);
	
		System.out.println("La FECHAAAAAAAAAAAAAAAAAAA " + fecha.getTime());
		System.out.println("El ultimo Garron del dia " + fecha + "es: " + sd.obtenerUltimoNumeroGarron(fecha));
		
	}
	
}