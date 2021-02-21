/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorHealthCody.model;

import ec.edu.espe.DBmanager.utils.DBmanager;

/**
 *
 * @author Rafa
 */
public class Authentication {

    private String userName;
    private String accesKey;
    private String collenctionName;
    private final DBmanager operation;

    public Authentication(String userName, String accesKey, String collenctionName) {
        this.userName = userName;
        this.accesKey = accesKey;
        this.collenctionName = collenctionName;
        operation = new DBmanager("Registry", this.collenctionName);
    }

    public boolean login() {
        boolean compare, corretUser, correctKey;
        corretUser = operation.verifyExistingData(userName);
        correctKey = operation.verifyExistingData(accesKey);
        if (corretUser == true && correctKey == true) {
            compare = true;
        } else {
            compare = false;
        }
        return compare;

    }

    public String getCollenctionName() {
        return collenctionName;
    }

    public void setCollenctionName(String collenctionName) {
        this.collenctionName = collenctionName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAccesKey() {
        return accesKey;
    }

    public void setAccesKey(String accesKey) {
        this.accesKey = accesKey;
    }

}
