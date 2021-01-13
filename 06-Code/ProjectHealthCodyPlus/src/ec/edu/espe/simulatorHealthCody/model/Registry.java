/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorHealthCody.model;

import com.google.gson.Gson;
import ec.edu.espe.Filemanager.utils.FileManager;

/**
 *
 * @author Rafael Buse ESPE-DCCO
 */
public class Registry {
    Administrator administrator;
    Customer customer;
    Gson gson = new Gson();

    public Registry(Administrator administrator) {
        this.administrator = administrator;
    }

    public Registry(Customer customer) {
        this.customer = customer;
    }
    
    public void registerAdministrator(){
        String AdminDataJson = gson.toJson(administrator);
        FileManager.save("AdministratorList.json", AdminDataJson);
    }
    
    public void registerCustomer(){
        String CustomerDataJson = gson.toJson(customer);
        FileManager.save("CustomerList.json", CustomerDataJson);
    }
    
    public void generateAdminCode(){
        administrator.setAdministratorCode("Admin"+administrator.getIdPerson() + administrator.getGenderPerson());
    }
}
