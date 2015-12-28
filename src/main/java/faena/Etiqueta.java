package faena;

import tropa.Animal;
import tropa.Tropa;

public class Etiqueta {
	private static int PESO_CABEZA_ENTERA = 5;

	public void imprimirEtiquetas(Tropa tropa, Animal animal, boolean cabezaAlMedio) {
		// TODO terminar de implementar este metodo
		System.out.println("Tropa: " + tropa.getNumeroTropa());
		System.out.println("Fecha Faena: " + tropa.getFechaFaena());
		System.out.println("Numero de Garron: " + animal.getGarron());
		double peso;
		if (cabezaAlMedio) {
			peso = animal.getPeso();
		} else {
			peso = animal.getPeso() + PESO_CABEZA_ENTERA;
		}
		System.out.println("Peso del animal: " + peso);
		System.out.println("Categoría del animal: " + animal.getCategoria());

	}
}
