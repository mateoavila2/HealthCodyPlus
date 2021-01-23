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
public class User {

    private String user;
    private String password;
    private String accessCode;
    Gson gson = new Gson();

    public User(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public User(String user, String accessCode, String password) {
        this.password = password;
        this.accessCode = accessCode;
    }

    public boolean LoginAdministrator() {
        boolean verifyCode = FileManager.findLogin("AdministratorList.json", accessCode);
        boolean verifyPassword = FileManager.findLogin("AdministratorList.json", password);
        boolean compare;
        if (verifyCode == true && verifyPassword == true) {
            compare = true;
        } else {
            compare = false;
        }
        return compare;
    }

    public boolean LoginCustomer() {

        boolean verifyUser = FileManager.findLogin("CustomerList.json", user);
        boolean verifyPassword = FileManager.findLogin("CustomerList.json", password);

        boolean compare = false;
        if (verifyUser == true && verifyPassword == true) {
            compare = true;
        } else {
            compare = false;
        }
        return compare;
    }

    public boolean checkFirtsTime() {
        boolean verified;
        String dataCustom = FileManager.find("CustomerList.json", user);
        Customer customer = new Customer("", "", "", 0, "", "");
        customer = gson.fromJson(dataCustom, Customer.class);
        if (customer.isFillSurvey() == false) {
            verified = false;
            customer.setFillSurvey(true);
            FileManager.delete("CustomerList.json", user);
            String jsonC = gson.toJson(customer);
            FileManager.save("CustomerList.json", jsonC);
        } else {
            verified = true;
        }
        return verified;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccessCode() {
        return accessCode;
    }

    public void setAccessCode(String accessCode) {
        this.accessCode = accessCode;
    }

}
