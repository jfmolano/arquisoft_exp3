package cifrado;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.crypto.Cipher;

public class CipherKeyPair {

private final static String ALGORITMO="RSA";
    
    
    public static KeyPair kp;


	private static KeyPair kpDSA;
    public static String cifrarRSA(String pwd) {
        try {
            PublicKey key = leerRSA().getPublic();
            Cipher cipher = Cipher.getInstance(ALGORITMO);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte [] clearText = pwd.getBytes();
            byte [] cipheredText = cipher.doFinal(clearText);
            return TransByteString.transformar(cipheredText);
        }
        catch (Exception ex )
        {
                    Logger.getLogger(CipherKeyPair.class.getName()).log(Level.SEVERE, null, ex);
                    return null;
        }
    }
    public static String descifrarRSA(String cipheredText) {
        try {
            PrivateKey key = leerRSA().getPrivate();
                byte[] bytesCifrados = TransByteString.destransformar(cipheredText);
                Cipher cipher = Cipher.getInstance(ALGORITMO);
                cipher.init(Cipher.DECRYPT_MODE, key);
                byte [] clearText = cipher.doFinal(bytesCifrados);
                String s3 = new String(clearText);
                return s3;
        } 
        catch (Exception ex) {
            Logger.getLogger(CipherKeyPair.class.getName()).log(Level.SEVERE, null, ex);

            return "";
        }
    }
    public static KeyPair leerRSA() throws Exception {
    	if (kp == null)
    	{
    		ObjectInputStream ois = new ObjectInputStream( new FileInputStream("lib/public"));
    		kp = (KeyPair) ois.readObject();
    		ois.close();
    	}
    	return kp;
        
    }
    public static KeyPair leerDSA() throws Exception {
    	if (kpDSA == null)
    	{
    		ObjectInputStream ois = new ObjectInputStream( new FileInputStream("lib/publicDSA"));
    		kpDSA = (KeyPair) ois.readObject();
    		ois.close();
    	}
    	return kpDSA;
        
    }
}
