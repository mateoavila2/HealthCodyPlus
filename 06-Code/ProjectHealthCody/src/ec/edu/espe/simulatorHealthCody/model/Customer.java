/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorHealthCody.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mateo Ávila
 */
public class Customer extends User{

    private static String codeAppoinment;
    public Customer(String name, String id, String dateOfBirth, String gender, String userName, String accesKey) {
        super(name, id, dateOfBirth, gender, userName, accesKey);
    }

    public Customer() {
    }
    

    

    public String getCodeAppoinment() {
        return codeAppoinment;
    }

    public void setCodeAppoinment(String codeAppoinment) {
        this.codeAppoinment = codeAppoinment;
    }

    
}
