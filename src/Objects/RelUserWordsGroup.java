/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import java.sql.Timestamp;

/**
 *
 * @author pedro
 */
public class RelUserWordsGroup {
    private int idUser;
    private int idWordsGroup;
    private Timestamp dateIsert;

    public RelUserWordsGroup() {
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdWordsGroup() {
        return idWordsGroup;
    }

    public void setIdWordsGroup(int idWordsGroup) {
        this.idWordsGroup = idWordsGroup;
    }

    public Timestamp getDateIsert() {
        return dateIsert;
    }

    public void setDateIsert(Timestamp dateIsert) {
        this.dateIsert = dateIsert;
    }
    
            
}
