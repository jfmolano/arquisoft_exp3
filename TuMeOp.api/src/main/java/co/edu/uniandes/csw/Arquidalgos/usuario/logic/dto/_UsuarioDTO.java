/* ========================================================================
 * Copyright 2014 Arquidalgos
 *
 * Licensed under the MIT, The MIT License (MIT)
 * Copyright (c) 2014 Arquidalgos

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
 * ========================================================================


Source generated by CrudMaker version 1.0.0.201408112050

*/

package co.edu.uniandes.csw.Arquidalgos.usuario.logic.dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement 
public abstract class _UsuarioDTO {

	

	private Long id;
	

	private String name;
	

	private String contrasena;

        private String email;

        private String facebookId;
        private String googleId;

    public String getFacebookId() {
        return facebookId;
    }

    public void setFacebookId(String facebookId) {
        this.facebookId = facebookId;
    }
    
     public String getGoogleId() {
         String resp="vacio";
         if(googleId!=null)
         {
             resp = googleId;
         }
        return resp;
    }

    public void setGoogleId(String googleId) {
        this.googleId = googleId;
    }
        
        
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
        
        

	public Long getId() {
		return id;
	}
 
	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}
 
	public void setName(String name) {
		this.name = name;
	}


	public String getContrasena() {
		return contrasena;
	}
 
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
        
        @Override
        public String toString(){
            
            return "{\"email\":\""+email+"\",\"name\":\""+name+"\",\"hash\":\"\",\"facebookId\":\""+facebookId+"\",\"googleId\":\""+googleId+"\"}";
            
        }
        
        public String toStringSinEmail(){
            
            return "{\"name\":\""+name+"\",\"hash\":\"\",\"facebookId\":\""+facebookId+"\",\"googleId\":\""+googleId+"\"}";
        }
        
        private String hash;

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }
	
}