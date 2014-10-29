/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.Arquidalgos.tienda.logic.ejb;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.security.KeyPair;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 *
 * @author JoseMiguel
 */
@Singleton
@Startup
public class KeyIOLoader {
    private static KeyPair kpRSA;
    private static KeyPair kpDSA;
    
    
    public static KeyPair getKeyPairRSA()
    {
        if (kpRSA == null)
        {
            try {
                kpRSA = leerRSA();
            } catch (Exception ex) {
                Logger.getLogger(KeyIOLoader.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return kpRSA;
    }
    public static KeyPair getKeyPairDSA()
    {
        if (kpDSA == null)
        {
            try {
                kpDSA = leerDSA();
            } catch (Exception ex) {
                Logger.getLogger(KeyIOLoader.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return kpDSA;
    }
    private static KeyPair leerRSA() throws Exception {
        System.out.println("Read Key");
        File file= new File("../generated/jsp/TuMeOp.web");
        File[] files = file.listFiles();
        boolean found = false;
        System.out.println(file.getAbsolutePath() + " numero:" + files.length);
        for(int i = 0; i< files.length && !found; i++)
        {
            file = new File(files[i].getPath() + "/META-INF/public");
            
            found = file.exists();
        }
        
        ObjectInputStream ois = new ObjectInputStream( new FileInputStream(file));
        KeyPair resp = (KeyPair) ois.readObject();
        ois.close();
        return resp;
    }
     public static KeyPair leerDSA() throws Exception {
        System.out.println("Read DSA Key");
        File file= new File("../generated/jsp/TuMeOp.web");
        File[] files = file.listFiles();
        boolean found = false;
        System.out.println(file.getAbsolutePath() + " numero:" + files.length);
        for(int i = 0; i< files.length && !found; i++)
        {
            file = new File(files[i].getPath() + "/META-INF/publicDSA");
            
            found = file.exists();
        }
        
        ObjectInputStream ois = new ObjectInputStream( new FileInputStream(file));
        KeyPair resp = (KeyPair) ois.readObject();
        ois.close();
        return resp;
    }
}
