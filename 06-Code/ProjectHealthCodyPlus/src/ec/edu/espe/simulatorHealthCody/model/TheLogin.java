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
public class TheLogin {
    private String user;
    private String password;
    private String accessCode;

    public TheLogin(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public TheLogin(String user, String password, String accessCode) {
        this.user = user;
        this.password = password;
        this.accessCode = accessCode;
    }
    
    public boolean loginAdministrator(){
        AdministratorList administrators = new AdministratorList();
        administrators.readFile();
        boolean compare = false ;
        for(int i=0;i<administrators.getAdministratorList().size();i++){
            if(user.equals(administrators.getAdministratorList().get(i).getAdministratorUSer()) && password.equals(administrators.getAdministratorList().get(i).getAdministratorPassword()) && accessCode.equals(administrators.getAdministratorList().get(i).getAdministratorCode()) ){
                System.out.println("Correcto");
                compare = true;
            }
        }
        if(compare == false){
            System.out.println("Datos Incorrectos");
        }
        return compare;
    }
    
    public boolean loginCustomer(){
        CustomerList customers = new CustomerList();
        customers.readFile();
        boolean compare = false;
        for(int i=0;i<customers.getCustomerList().size();i++){
            if(user.equals(customers.getCustomerList().get(i).getCustomerUSer()) && password.equals(customers.getCustomerList().get(i).getCustomerPassword())){
                System.out.println("Correcto");
                compare = true;
            }
        }
        if(compare == false){
            System.out.println("Datos Incorrectos");
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
