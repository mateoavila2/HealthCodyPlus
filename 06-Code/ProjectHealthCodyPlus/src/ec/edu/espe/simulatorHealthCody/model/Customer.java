/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorHealthCody.model;

/**
 *
 * @author Rafael Buse ESPE-DCCO
 */
public class Customer extends User {

    private String codeAppoinment;

    public Customer(String name, String id, int age, String gender, String userName, String accesKey) {
        super(name, id, age, gender, userName, accesKey);
        codeAppoinment = "null" + this.userName;
    }

    public String getCodeAppoinment() {
        return codeAppoinment;
    }

    public void setCodeAppoinment(String codeAppoinment) {
        this.codeAppoinment = codeAppoinment;
    }
}
