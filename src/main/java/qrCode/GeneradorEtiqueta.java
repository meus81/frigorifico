package qrCode;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.ByteArrayOutputStream;

public class GeneradorEtiqueta {

	public void imprimir(String datos, ByteArrayOutputStream codigoQRGenerado){
		PrinterJob job = PrinterJob.getPrinterJob();
		job.setPrintable(new RenderEtiqueta(datos, codigoQRGenerado));
		try {
			job.print();
		} catch (PrinterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private class RenderEtiqueta implements Printable{
		String datos;
		ByteArrayOutputStream codigoQRGenerado;
		
		
		
		public RenderEtiqueta(String datos, ByteArrayOutputStream codigoQRGenerado) {
			this.datos = datos;
			this.codigoQRGenerado = codigoQRGenerado;
		}

		public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
			// User (0,0) is typically outside the
		    // imageable area, so we must translate
		    // by the X and Y values in the PageFormat
		    // to avoid clipping.
		    Graphics2D g2d = (Graphics2D)graphics;
		    g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

		    // Now we perform our rendering
		    graphics.drawString("Hello world!", 100, 100);

		    // tell the caller that this page is part
		    // of the printed document
		    return PAGE_EXISTS;
		}
		
	}
	
	public static void main(String[] args) {
		
		//TODO http://stackoverflow.com/questions/9308412/sending-a-barcode-to-a-zebra-printer-from-a-java-application
		
		

	}

}
