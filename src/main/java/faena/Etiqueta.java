package faena;

import java.io.ByteArrayOutputStream;

import qrCode.GeneradorCodigoQR;
import tropa.Animal;
import tropa.Tropa;

public class Etiqueta {
	private static int PESO_CABEZA_ENTERA = 5;

	public void imprimirEtiquetas(Tropa tropa, Animal animal, boolean cabezaAlMedio) {
		// TODO terminar de implementar este metodo

		double peso;
		if (cabezaAlMedio) {
			peso = animal.getPeso();
		} else {
			peso = animal.getPeso() + PESO_CABEZA_ENTERA;
		}

		String datos = "Tropa: " + tropa.getNumeroTropa() + "\n Fecha Faena: " + tropa.getFechaFaena()
				+ "\n Numero de Garron: " + animal.getGarron() + "\n Peso del animal: " + peso
				+ "\n Categoría del animal: " + animal.getCategoria();
		
		
		GeneradorCodigoQR generadorCodigoQR = new GeneradorCodigoQR();
		
		ByteArrayOutputStream codigoQRGenerado = generadorCodigoQR.crearCodigoQR(datos);
		
		

		/*
		 * System.out.println("Tropa: " + tropa.getNumeroTropa());
		 * System.out.println("Fecha Faena: " + tropa.getFechaFaena());
		 * System.out.println("Numero de Garron: " + animal.getGarron());
		 * System.out.println("Peso del animal: " + peso); System.out.println(
		 * "Categoría del animal: " + animal.getCategoria());
		 */

	}
}
