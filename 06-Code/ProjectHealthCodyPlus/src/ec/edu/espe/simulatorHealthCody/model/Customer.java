/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorHealthCody.model;

/**
 *
 * @author Kenneth Andrade ESPE-DCCO
 */
public class Customer{

    /**
     * @return the customerUSer
     */
    public String getCustomerUSer() {
        return customerUSer;
    }

    /**
     * @param customerUSer the customerUSer to set
     */
    public void setCustomerUSer(String customerUSer) {
        this.customerUSer = customerUSer;
    }

    /**
     * @return the customerPassword
     */
    public String getCustomerPassword() {
        return customerPassword;
    }

    /**
     * @param customerPassword the customerPassword to set
     */
    public void setCustomerPassword(String customerPassword) {
        this.customerPassword = customerPassword;
    }

    /**
     * @return the customer
     */
    public Person getCustomer() {
        return customer;
    }

    /**
     * @param customer the customer to set
     */
    public void setCustomer(Person customer) {
        this.customer = customer;
    }
    private String customerUSer;
    private String customerPassword;
    private Person customer;
    public Customer(String customerUSer, String customerPassword, Person customer) {
        this.customerUSer = customerUSer;
        this.customerPassword = customerPassword;
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Usuario = " + getCustomerUSer() +"\n" +"Contraseña = " + getCustomerPassword() +"\n"+ "Nombre = " + getCustomer().getNamePerson() +"\n"+ "Id = "+ getCustomer().getIdPerson() +"\n"+ "Genero = "+getCustomer().getGenderPerson()+"\n"+ "Edad = "+getCustomer().getAgePerson()+"\n";
    }

    
    
    
}
