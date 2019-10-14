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
public class UserAccount {
    private int id;
    private String name;
    private String pass;
    private Timestamp dateIsert;

    public UserAccount() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Timestamp getDateIsert() {
        return dateIsert;
    }

    public void setDateIsert(Timestamp dateIsert) {
        this.dateIsert = dateIsert;
    }

}
