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

    Gson gson = new Gson();
    Employee employe;
    Customer customer;

    public Registry(Employee employe) {
        this.employe = employe;
    }

    public Registry(Customer customer) {
        this.customer = customer;
    }

    

    public void registerAdmin(String fileName) {
        String json;
        json = gson.toJson(employe);
        FileManager.save(fileName, json);
    }
    
    public void registerCustom(String fileName) {
        String json;
        json = gson.toJson(customer);
        FileManager.save(fileName, json);
    }


    /*public void generateAdminCode() {
        administrator.setAdministratorCode("Admin" + administrator.getIdPerson() + administrator.getGenderPerson());
    }*/
}
