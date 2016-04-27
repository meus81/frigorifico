package tropa;

import org.junit.Test;

import com.google.gson.Gson;

import modelo.tropa.Tropa;
import modelo.tropa.TropaCorral;
import servicios.TropaDAO;

public class TropaTest {
	
	@Test
	public void obtenerTropa(){
		TropaDAO tropaDAO =  new TropaDAO();
		
		Tropa tropa = tropaDAO.obtenerTropa(60);
		
		Gson gson = new Gson();
//		System.out.println(gson.toJson(tropa));
		for (TropaCorral tropaCorral : tropa.getCorrales()) {
			System.out.println("TropaCorral: " + tropaCorral.getFechaEgreso() + "- Ocupacion: "+ tropaCorral.getOcupacion() + "- Numero corral: " + tropaCorral.getCorral().getNumero());
		}
	}
}
