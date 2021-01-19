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
public class Customer extends Person{
    private String customerUSer;
    private String customerPassword;
    private boolean fillSurvey = false;

    public Customer(String namePerson, String idPerson, String genderPerson, int agePerson, String customerUSer, String customerPassword) {
        super(namePerson, idPerson, genderPerson, agePerson);
        this.customerUSer = customerUSer;
        this.customerPassword = customerPassword;
    }

    public String getCustomerUSer() {
        return customerUSer;
    }

    public void setCustomerUSer(String customerUSer) {
        this.customerUSer = customerUSer;
    }

    public String getCustomerPassword() {
        return customerPassword;
    }

    public void setCustomerPassword(String customerPassword) {
        this.customerPassword = customerPassword;
    }

    public boolean isFillSurvey() {
        return fillSurvey;
    }

    public void setFillSurvey(boolean fillSurvey) {
        this.fillSurvey = fillSurvey;
    }
    
    
    @Override
    public String toString() {
        return namePerson + "," + idPerson + "," + genderPerson + "," + agePerson + "," + customerUSer + "," + customerPassword + "\n";
    }
    
}
