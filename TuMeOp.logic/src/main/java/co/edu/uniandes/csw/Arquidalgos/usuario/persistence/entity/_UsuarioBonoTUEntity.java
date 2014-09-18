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
public abstract class _UsuarioBonoTUEntity {

	@Id
	@GeneratedValue(generator = "UsuarioAmigo")
        private Long id;
        
	private Long idBono;
	private String idUsuario;

    public Long getIdBono() {
        return idBono;
    }

    public void setIdBono(Long idBono) {
        this.idBono = idBono;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

        
	

}
