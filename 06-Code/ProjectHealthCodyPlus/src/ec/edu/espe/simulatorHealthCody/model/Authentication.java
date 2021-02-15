/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorHealthCody.model;

import ec.edu.espe.Filemanager.utils.FileManager;

/**
 *
 * @author Rafa
 */
public class Authentication {

    private String userName;
    private String accesKey;

    public Authentication(String userName, String accesKey) {
        this.userName = userName;
        this.accesKey = accesKey;
    }

    public boolean login(String fileName) {
        boolean compare, corretUser, correctKey;

        corretUser = FileManager.findLogin(fileName, userName);
        correctKey = FileManager.findLogin(fileName, accesKey);
        if (corretUser == true && correctKey == true) {
            compare = true;
        } else {
            compare = false;
        }
        return compare;

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
