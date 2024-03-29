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

package co.edu.uniandes.csw.Arquidalgos.usuario.service;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.inject.Inject;

import co.edu.uniandes.csw.Arquidalgos.usuario.logic.api.IUsuarioLogicService;
import co.edu.uniandes.csw.Arquidalgos.usuario.logic.dto.UsuarioDTO;
import com.sun.enterprise.deployment.node.ApplicationNode;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Hex;


public abstract class _UsuarioService {

	@Inject
	protected IUsuarioLogicService usuarioLogicService;
 
	
	@POST
	public UsuarioDTO createUsuario(UsuarioDTO usuario){
		return usuarioLogicService.createUsuario(usuario);
	}
        
        @POST
        @Path("/crearUsuario")
        public UsuarioDTO crearUsuario(UsuarioDTO usuario) throws Exception {
            
            Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
            String key = "123";
            SecretKeySpec secret_key = new SecretKeySpec(key.getBytes(), "HmacSHA256");
            sha256_HMAC.init(secret_key);
            
            System.out.println("TO String: "+usuario.toString());
            
            String hash = Hex.encodeHexString(sha256_HMAC.doFinal(usuario.toString().getBytes()));
            System.out.println("CODIGO HASH: "+hash);
            System.out.println("CODIGO HASH JSON "+usuario.getHash());
            
            boolean alterado = !(hash.equalsIgnoreCase(usuario.getHash()));
            System.out.println("Alterado: "+alterado);

            if (alterado){
                //throw new Exception("Se han alterado los datos");
            }
            UsuarioDTO resp = createUsuario(usuario);
            System.out.println(resp);
            return resp;
        }
	
        
	@DELETE
	@Path("{id}")
	public void deleteUsuario(@PathParam("id") Long id){
		usuarioLogicService.deleteUsuario(id);
	}
	
	@GET
	public List<UsuarioDTO> getUsuarios(){
		return usuarioLogicService.getUsuarios();
	}
	
	@GET
	@Path("{id}")
	public UsuarioDTO getUsuario(@PathParam("id") Long id){
		return usuarioLogicService.getUsuario(id);
	}
	
	@PUT
    @Path("{id}")
	public void updateUsuario(@PathParam("id") Long id, UsuarioDTO usuario){
		usuarioLogicService.updateUsuario(usuario);
	}
	
}
