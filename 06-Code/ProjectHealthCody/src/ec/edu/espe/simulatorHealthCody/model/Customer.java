/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorHealthCody.model;

/**
 *
 * @author Mateo Ávila
 */
public class Customer extends User{

    private String codeAppoinment;

    public Customer(String name, String id, String dateOfBirth, String gender, String userName, String accesKey) {
        super(name, id, dateOfBirth, gender, userName, accesKey);
    }

    

    public String getCodeAppoinment() {
        return codeAppoinment;
    }

    public void setCodeAppoinment(String codeAppoinment) {
        this.codeAppoinment = codeAppoinment;
    }
}
