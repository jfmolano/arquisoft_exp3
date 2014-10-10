/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.Arquidalgos.tienda.logic.ejb;


import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;

/**
 *
 * @author JoseMiguel
 */
public class CipherKeyPair {
    private final static String ALGORITMO="RSA";
    
    
    
    public static String cifrar(String pwd) {
        try {
            System.out.println("Descifrado: " + pwd);
            PublicKey key = KeyIOLoader.getKeyPair().getPublic();
            Cipher cipher = Cipher.getInstance(ALGORITMO);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte [] clearText = pwd.getBytes();
            byte [] cipheredText = cipher.doFinal(clearText);
            String s3 = TransByteString.transformar(cipheredText);
            System.out.println("Cifrado: " +s3);
            return s3;
        }
        catch (Exception ex )
        {
                    Logger.getLogger(CipherKeyPair.class.getName()).log(Level.SEVERE, null, ex);
                    return null;
        }
    }
    public static String descifrar(String cipheredText) {
        try {
            System.out.println("Cifrado: " + cipheredText);
            PrivateKey key = KeyIOLoader.getKeyPair().getPrivate();
            byte[] bytesCifrados = TransByteString.destransformar(cipheredText);
            Cipher cipher = Cipher.getInstance(ALGORITMO);
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte [] clearText = cipher.doFinal(bytesCifrados);
            String s3 = new String(clearText);
            System.out.println("Descifrado: " +s3);
            return s3;
        } 
        catch (Exception ex) {
            Logger.getLogger(CipherKeyPair.class.getName()).log(Level.SEVERE, null, ex);

            return "";
        }
    }
    
}
