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

package co.edu.uniandes.csw.Arquidalgos.tumeop.master.persistence.entity;

import co.edu.uniandes.csw.Arquidalgos.tienda.persistence.entity.TiendaEntity;
import co.edu.uniandes.csw.Arquidalgos.tumeop.persistence.entity.TuMeOpEntity;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn; 
import org.eclipse.persistence.annotations.JoinFetch;

@Entity
@IdClass(TuMeOptiendaOPEntityId.class)
@NamedQueries({
    @NamedQuery(name = "TuMeOptiendaOPEntity.getByMasterId", query = "SELECT  u FROM TuMeOptiendaOPEntity u WHERE u.tuMeOpId=:tuMeOpId"),
    @NamedQuery(name = "TuMeOptiendaOPEntity.deleteTuMeOptiendaOPEntity", query = "DELETE FROM TuMeOptiendaOPEntity u WHERE u.tuMeOpId=:tuMeOpId and  u.tiendaOPId=:tiendaOPId")
})
public class TuMeOptiendaOPEntity implements Serializable {

    @Id
    @Column(name = "tuMeOpId")
    private Long tuMeOpId;
    @Id
    @Column(name = "tiendaOPId")
    private Long tiendaOPId;
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "tuMeOpId", referencedColumnName = "id")
    @JoinFetch
    private TiendaEntity tuMeOpIdEntity;
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "tiendaOPId", referencedColumnName = "id")
    @JoinFetch
    private TiendaEntity tiendaOPIdEntity; 

    public TuMeOptiendaOPEntity() {
    }

    public TuMeOptiendaOPEntity(Long tuMeOpId, Long tiendaOPId) {
        this.tuMeOpId =tuMeOpId;
        this.tiendaOPId = tiendaOPId;
    }

    public Long getTuMeOpId() {
        return tuMeOpId;
    }

    public void setTuMeOpId(Long tuMeOpId) {
        this.tuMeOpId = tuMeOpId;
    }

    public Long getTiendaOPId() {
        return tiendaOPId;
    }

    public void setTiendaOPId(Long tiendaOPId) {
        this.tiendaOPId = tiendaOPId;
    }

    public TiendaEntity getTuMeOpIdEntity() {
        return tuMeOpIdEntity;
    }

    public void setTuMeOpIdEntity(TiendaEntity tuMeOpIdEntity) {
        this.tuMeOpIdEntity = tuMeOpIdEntity;
    }

    public TiendaEntity getTiendaOPIdEntity() {
        return tiendaOPIdEntity;
    }

    public void setTiendaOPIdEntity(TiendaEntity tiendaOPIdEntity) {
        this.tiendaOPIdEntity = tiendaOPIdEntity;
    }

}
