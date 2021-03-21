/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorHealthCody.model;

import ec.edu.espe.simulatorHealthCody.utils.MongoDBManager;


/**
 *
 * @author Mateo Ávila
 */
public class Authentication {

    private String collenctionName;
    MongoDBManager operation;

    public Authentication(String collenctionName) {
        this.collenctionName = collenctionName;
        operation = new MongoDBManager();
        operation.openConnection("Registry");
    }

   /* public boolean login(String userName,String accesKey) {
        boolean compare, corretUser, correctKey;
        corretUser = operation.verifyExistingData(userName,"");
        correctKey = operation.verifyExistingData(accesKey);
        if (corretUser == true && correctKey == true) {
            compare = true;
        } else {
            compare = false;
        }
        return compare;
    } */
}
