/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorHealthCody.model;

import ec.edu.espe.Filemanager.utils.FileManager;
import java.util.ArrayList;

/**
 *
 * @author Rafael Buse ESPE-DCCO
 */
public class LogIn {
    private String user;
    private String password;
    private String accessCode;

    public LogIn(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public LogIn(String user,String accessCode, String password) {
        this.password = password;
        this.accessCode = accessCode;
    }
    
    public boolean LoginAdministrator(){
        boolean verifyCode = FileManager.findLogin("AdministratorList.json", accessCode);
        boolean verifyPassword = FileManager.findLogin("AdministratorList.json", password);
        
        boolean compare = false ;
        if(verifyCode == true && verifyPassword == true){
            System.out.println("Encontrado");
            compare = true;
        }else{
            System.out.println("No enontrado");
        }
        return compare;
    }
    
    public boolean LoginCustomer(){
        
        boolean verifyUser = FileManager.findLogin("AdministratorList.json", accessCode);
        boolean verifyPassword = FileManager.findLogin("AdministratorList.json", password);
        
        boolean compare = false ;
        if(verifyUser == true && verifyPassword == true){
            System.out.println("Encontrado");
            compare = true;
        }else{
            System.out.println("No enontrado");
        }
        return compare;
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
