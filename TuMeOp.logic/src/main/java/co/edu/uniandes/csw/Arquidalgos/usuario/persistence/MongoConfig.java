/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.uniandes.csw.Arquidalgos.usuario.persistence;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lnicole_92
 */
public class MongoConfig {
    private MongoClient mongoClient; 
    public DB db; 
    public MongoConfig() { 
    try { 
        
        System.out.println("MONGO DB");
        mongoClient = new MongoClient("172.24.98.137", 27017); 
        } catch (UnknownHostException ex) { 
        Logger.getLogger(MongoConfig.class.getName()).log(Level.SEVERE, null, ex); 
        } 
          db = mongoClient.getDB("test"); 
//    
        
//        MongoClientURI uri = new MongoClientURI("mongodb://admin:admin@localhost:27017/tumejoropcionusuario");
//    mongoClient = new MongoClient(uri); 
//        } catch (UnknownHostException ex) { 
//    Logger.getLogger(MongoConfig.class.getName()).log(Level.SEVERE, null, ex); 
//    } 
//    db = mongoClient.getDB("test"); 
    }   
}