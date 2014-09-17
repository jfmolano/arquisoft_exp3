/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.uniandes.csw.Arquidalgos.usuario.persistence.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author Jonathan
 */
@MappedSuperclass
public abstract class _UsuarioAmigoEntity {

	@Id
	@GeneratedValue(generator = "UsuarioAmigo")
        private Long id;
        
	private String usuarioFacebookId;
	private String amigoFacebookId;

    public String getUsuarioFacebookId() {
        return usuarioFacebookId;
    }

    public void setUsuarioFacebookId(String usuarioId) {
        this.usuarioFacebookId = usuarioId;
    }

    public String getAmigoFacebookId() {
        return amigoFacebookId;
    }

    public void setAmigoFacebookId(String amigoId) {
        this.amigoFacebookId = amigoId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

        
	

}
