package servicios;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;

public class UltimoGarronTest {
	@Test
	public void ultimoGarron(){
		ServiciosDatabase sd= new ServiciosDatabase();
		GregorianCalendar fecha = new GregorianCalendar();
		fecha.set(2015, Calendar.DECEMBER, 1);
		fecha.set(Calendar.HOUR_OF_DAY, 0);
		fecha.set(Calendar.MINUTE, 0);
		fecha.set(Calendar.SECOND, 0);		
		fecha.set(Calendar.MILLISECOND, 0);	
		GregorianCalendar fecha2 = new GregorianCalendar();
		fecha2.set(2015, Calendar.DECEMBER, 1);
		fecha2.set(Calendar.HOUR_OF_DAY, 23);
		fecha2.set(Calendar.MINUTE, 59);		
		fecha2.set(Calendar.SECOND, 59);
		fecha2.set(Calendar.MILLISECOND, 1000);
		


	
		System.out.println("La FECHAAAAAAAAAAAAAAAAAAA " + fecha.getTime());
		System.out.println("El ultimo Garron del dia " + fecha + "es: " + sd.obtenerUltimoNumeroGarron(fecha.getTime(), fecha2.getTime()));
		
	}
	
}