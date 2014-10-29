package co.edu.uniandes.csw.Arquidalgos.hash;

import co.edu.uniandes.csw.Arquidalgos.tienda.logic.ejb.CipherKeyPair;
import co.edu.uniandes.csw.Arquidalgos.tienda.logic.ejb.KeyIOLoader;
import co.edu.uniandes.csw.Arquidalgos.tienda.logic.ejb.TransByteString;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;

public class GenaerateDigsetHex {


    public static String firmar( String datos) {
        try {
            PrivateKey priv = KeyIOLoader.getKeyPairDSA().getPrivate();
            Signature firma = Signature.getInstance(priv.getAlgorithm());
            firma.initSign(priv);
            firma.update(datos.getBytes());
            byte[] signature = firma.sign();

            System.out.println("D:" + datos);
            System.out.println("S:" + TransByteString.transformar(signature));
            return datos + "Z" + TransByteString.transformar(signature);
            
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Excepcion: " + e.getMessage());
            return null;
        } catch (InvalidKeyException e) {
            System.out.println("Excepcion: " + e.getMessage());
            return null;
        } catch (SignatureException e) {
            System.out.println("Excepcion: " + e.getMessage());
            return null;
        }
    }

    public static String verificarAndGetMessage( String documentoFirmado) throws Exception {
        try {
            PublicKey pub = KeyIOLoader.getKeyPairDSA().getPublic();
            System.out.println("Documento firmado" + documentoFirmado);
            String[] messageParts = documentoFirmado.split("Z");
            System.out.println("D:" + messageParts[0]);
            System.out.println("S:" + messageParts[1]);

            Signature sig = Signature.getInstance(pub.getAlgorithm());
            sig.initVerify(pub);
            sig.update(messageParts[0].getBytes());
            boolean verifies = sig.verify(TransByteString.destransformar(messageParts[1]));
            if(!verifies)
            {
                throw new Exception("Se ha alterado la información no continuar");
            }
            return messageParts[0];
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Excepcion: " + e.getMessage());
        } catch (InvalidKeyException e) {
            System.out.println("Excepcion: " + e.getMessage());
        } catch (SignatureException e) {
            System.out.println("Excepcion: " + e.getMessage());
        }
        return null;
    }
}
