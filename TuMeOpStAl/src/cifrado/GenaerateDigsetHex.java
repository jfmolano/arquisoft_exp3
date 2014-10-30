package cifrado;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;

public class GenaerateDigsetHex {


	public static void main(String[] args) {
		verificar(firmar( "Hola"));
		
	}
	public static String firmar(  String datos) {
		try {
			PrivateKey priv = CipherKeyPair.leerDSA().getPrivate();
			Signature firma = Signature.getInstance(priv.getAlgorithm());
			firma.initSign(priv);
			firma.update(datos.getBytes());
			byte [] signature = firma.sign();

			System.out.println("D:"+ datos);
			System.out.println("S:"+TransByteString.transformar(signature));
			return datos + "Z" + TransByteString.transformar(signature);
		}
		catch (Exception e) {
			System.out.println("Excepcion: " + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}



	public static void verificar( String documentoFirmado) {
		try {

			PublicKey pub = CipherKeyPair.leerDSA().getPublic();
			String[] messageParts = documentoFirmado.split("Z");
			System.out.println("D:"+ messageParts[0]);
			System.out.println("S:"+ messageParts[1]);

			Signature sig = Signature.getInstance(pub.getAlgorithm());
			sig.initVerify(pub);
			sig.update(messageParts[0].getBytes());
			boolean verifies = sig.verify(TransByteString.destransformar(messageParts[1]));
			System.out.println("Verificacion: " + verifies);
		}
		catch (Exception e) {
			System.out.println("Excepcion: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
