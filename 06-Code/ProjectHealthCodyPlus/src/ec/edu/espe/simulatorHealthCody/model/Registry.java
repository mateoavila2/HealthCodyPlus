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
public class Registry {
    Administrator administrator;
    Customer customer;

    public Registry(Administrator administrator) {
        this.administrator = administrator;
    }

    public Registry(Customer customer) {
        this.customer = customer;
    }
    
    public void Registeradministrator(){
        AdministratorList administrators = new AdministratorList();
        administrators.saveAdministrator(administrator);
        //administrators.readFile();
    }
    
    public void RegisterCustomer(){
        CustomerList customers = new CustomerList();
        customers.saveCustomer(customer);
        //customers.readFile();
    }
    
    public void generateAdminCode(){
        administrator.setAdministratorCode(administrator.getIdPerson() + administrator.getNamePerson());
    }
}
