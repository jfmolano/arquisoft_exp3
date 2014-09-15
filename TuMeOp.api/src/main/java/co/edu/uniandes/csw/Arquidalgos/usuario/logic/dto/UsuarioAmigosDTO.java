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

 
    
    protected Long id;
   
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    
    
    
    public List<UsuarioDTO> amigos;	
	
    public List<UsuarioDTO> getAmigos(){ return amigos; };
    public void setCreateAmigos(List<UsuarioDTO> amigos){ this.amigos=amigos; };
	
	
}


