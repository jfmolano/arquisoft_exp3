/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.uniandes.csw.Arquidalgos.usuario.logic.dto;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jonathan
 */
@XmlRootElement
public class UsuarioAmigosDTO {

 
    
    protected String facebookId;
   
    private String hash;

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }
    
    
    
    public String getFacebookId() {
        return facebookId;
    }

    public void setFacebookId(String id) {
        this.facebookId = id;
    }
    
    
    
    
    public List<UsuarioDTO> amigos;	
	
    public List<UsuarioDTO> getAmigos(){ return amigos; };
    public void setCreateAmigos(List<UsuarioDTO> amigos){ this.amigos=amigos; };
	
    @Override
    public String toString (){
       
        
       
        String fbId = "\"facebookId\":\""+facebookId+"\"";
        
        String sAmigos = "\"amigos\":[";
        
        for (int i = 0; i < amigos.size(); i++) {
            
            sAmigos += amigos.get(i).toStringSinEmail();
            
            if ( i < amigos.size()-1){
                
                sAmigos +=",";
            }
            
        }
        sAmigos+="]";
        return ((("{"+fbId+","+sAmigos+"}").replace("Ã©", "é")).replace("Ã¡", "á"));
    }
    
   }


