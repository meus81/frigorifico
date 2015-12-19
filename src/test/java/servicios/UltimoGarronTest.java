package servicios;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Test;

public class UltimoGarronTest {
	@Test
	public void ultimoGarron() throws ParseException{
		ServiciosDatabase sd= new ServiciosDatabase();
		GregorianCalendar fecha = new GregorianCalendar();
		fecha.set(2015, Calendar.FEBRUARY, 2);
		
		Calendar c = Calendar.getInstance();
		c.set(2015, Calendar.FEBRUARY, 2);
	
		System.out.println("La FECHAAAAAAAAAAAAAAAAAAA " + fecha);
		System.out.println("El ultimo Garron del dia " + fecha + "es: " + sd.obtenerUltimoNumeroGarron(fecha));
		
	}
	
}