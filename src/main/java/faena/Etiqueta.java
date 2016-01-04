package faena;

import java.io.ByteArrayOutputStream;
import java.io.File;

import qrCode.GeneradorCodigoQR;
import qrCode.GeneradorEtiqueta;
import qrCode.MedioImpresionImpresoraComun;
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
		File codigoQRGenerado = generadorCodigoQR.crearCodigoQrFile(datos);
		MedioImpresionImpresoraComun miic = 
				new MedioImpresionImpresoraComun(datos, codigoQRGenerado);		
		GeneradorEtiqueta ge = new GeneradorEtiqueta();
		ge.imprimir(datos, codigoQRGenerado, miic);
	}
}
