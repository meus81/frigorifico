package qrCode;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;


public class GeneradorCodigoQR {
	
	public ByteArrayOutputStream crearCodigoQR(String datos){
		ByteArrayOutputStream out = QRCode.from(datos).to(ImageType.PNG).stream();

/*		try {
		    FileOutputStream fout = new FileOutputStream(new File("C:\\Daniela\\QR_Code.JPG"));

		    fout.write(out.toByteArray());
		    fout.flush();
		    fout.close();

		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} */ 
		return out;
	}
	
	public static void main(String [ ] args){
		GeneradorCodigoQR qrCode = new GeneradorCodigoQR();
		qrCode.crearCodigoQR("www.google.com");
	
	}
	
}
