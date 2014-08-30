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

package co.edu.uniandes.csw.Arquidalgos.bono.persistence.converter;

import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;


import co.edu.uniandes.csw.Arquidalgos.bono.logic.dto.BonoDTO;
import co.edu.uniandes.csw.Arquidalgos.bono.persistence.entity.BonoEntity;

public abstract class _BonoConverter {

 
	private final static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
	public static BonoDTO entity2PersistenceDTO(BonoEntity entity){
		if (entity != null) {
			BonoDTO dto = new BonoDTO();
					dto.setId(entity.getId());
					dto.setName(entity.getName());
 
			    if(entity.getFecha() != null){
					dto.setFecha(DATE_FORMAT.format(entity.getFecha()));
				}	
					dto.setValor(entity.getValor());
					dto.setUsuariobnId(entity.getUsuariobnId());
					dto.setTienda_bonoId(entity.getTienda_bonoId());
			return dto;
		}else{
			return null;
		}
	}
	
	public static BonoEntity persistenceDTO2Entity(BonoDTO dto){
		if(dto!=null){
			BonoEntity entity=new BonoEntity();
					entity.setId(dto.getId());
			
					entity.setName(dto.getName());
			
 
			      try{ 
			        if(dto.getFecha() != null){
						entity.setFecha(DATE_FORMAT.parse(dto.getFecha()));
					}
				  } catch (Exception ex) {
                        Logger.getLogger(_BonoConverter.class.getName()).log(Level.SEVERE, null, ex);
                  }	
			
					entity.setValor(dto.getValor());
			
					entity.setUsuariobnId(dto.getUsuariobnId());
			
					entity.setTienda_bonoId(dto.getTienda_bonoId());
			
			return entity;
		}else {
			return null;
		}
	}
	
	public static List<BonoDTO> entity2PersistenceDTOList(List<BonoEntity> entities){
		List<BonoDTO> dtos=new ArrayList<BonoDTO>();
		for(BonoEntity entity:entities){
			dtos.add(entity2PersistenceDTO(entity));
		}
		return dtos;
	}
	
	public static List<BonoEntity> persistenceDTO2EntityList(List<BonoDTO> dtos){
		List<BonoEntity> entities=new ArrayList<BonoEntity>();
		for(BonoDTO dto:dtos){
			entities.add(persistenceDTO2Entity(dto));
		}
		return entities;
	}
}