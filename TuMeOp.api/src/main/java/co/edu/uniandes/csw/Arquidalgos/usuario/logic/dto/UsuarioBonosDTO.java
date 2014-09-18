/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.uniandes.csw.Arquidalgos.usuario.logic.dto;

import co.edu.uniandes.csw.Arquidalgos.bono.logic.dto.BonoDTO;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jonathan
 */
@XmlRootElement
public class UsuarioBonosDTO {

 
    
    protected String facebookId;
   
    
    
    public String getFacebookId() {
        return facebookId;
    }

    public void setFacebookId(String id) {
        this.facebookId = id;
    }
    
    
    
    
    public List<BonoDTO> bonos;	
	
    public List<BonoDTO> getBonos(){ return bonos; };
    public void setCreateBonos(List<BonoDTO> bonos){ this.bonos=bonos; };
	
	
}


