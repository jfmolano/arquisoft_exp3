/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.uniandes.csw.Arquidalgos.usuario.logic.dto;

import co.edu.uniandes.csw.Arquidalgos.tienda.logic.dto.TiendaDTO;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jonathan
 */
@XmlRootElement
public class UsuarioTiendasDTO {

 
    
    protected String facebookId;
   
    
    
    public String getFacebookId() {
        return facebookId;
    }

    public void setFacebookId(String id) {
        this.facebookId = id;
    }
    
    
    
    
    public List<TiendaDTO> tiendas;	

    public List<TiendaDTO> getTiendas() {
        return tiendas;
    }

    public void setTiendas(List<TiendaDTO> tiendas) {
        this.tiendas = tiendas;
    }

	
	
}


