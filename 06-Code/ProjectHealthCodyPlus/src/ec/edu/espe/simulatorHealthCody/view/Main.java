/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorHealthCody.view;

import ec.edu.espe.simulatorHealthCody.controller.AdministratorLoginMenu;
import ec.edu.espe.simulatorHealthCody.controller.AdministratorRegistryMenu;
import ec.edu.espe.simulatorHealthCody.controller.CustomerLoginMenu;
import ec.edu.espe.simulatorHealthCody.controller.CustomerRegistryMenu;
import ec.edu.espe.simulatorHealthCody.controller.LogInMenu;
import ec.edu.espe.simulatorHealthCody.controller.PrincipalMenu;
import ec.edu.espe.simulatorHealthCody.controller.RegistryMenu;
import java.util.Scanner;

/**
 *
 * @author Rafael Buse ESPE-DCCO
 */
public class Main {
    public static void main(String[] args) {
        int option;
        Scanner read = new Scanner(System.in);
        do{
        PrincipalMenu princioalmenu = new PrincipalMenu();
        princioalmenu.showMenuPrincipal();
        option = princioalmenu.selectOptionMenu();
        switch(option){
            case 1:
                LogInMenu loginMenu = new LogInMenu();
                loginMenu.showMenuLogin();
                int loginOption = loginMenu.selectOptionLoginMenu();
                
                switch(loginOption){
                    case 1:                        
                        boolean loginCompareAdmin;
                        do{
                            AdministratorLoginMenu administratorLoginMenu = new AdministratorLoginMenu();
                            administratorLoginMenu.completeLoginDetails();
                            loginCompareAdmin = administratorLoginMenu.verifyAdministratorData();
                        }while(loginCompareAdmin == false);
                        break;
                    
                    case 2:
                        boolean loginCompareCustomer;
                        do{
                            CustomerLoginMenu customerLoginMenu = new CustomerLoginMenu();
                            customerLoginMenu.completeLoginDetails();
                            loginCompareCustomer = customerLoginMenu.verifyCustomerData();
                        }while(loginCompareCustomer == false);
                        break;
                }
                break;
            case 2:
                RegistryMenu registryMenu = new RegistryMenu();
                registryMenu.showMenuRegistry();
                int registerOption = registryMenu.selectOptionRegistryMenu();
                switch(registerOption){ 
                    case 1:
                        AdministratorRegistryMenu administratorRegistryMenu = new AdministratorRegistryMenu();
                        administratorRegistryMenu.completeAdminData();
                        administratorRegistryMenu.saveRegistryAdminData();
                        
                        break;
                    
                    case 2:
                        CustomerRegistryMenu customerRegistryMenu = new CustomerRegistryMenu();
                        customerRegistryMenu.completeCustomerData();
                        customerRegistryMenu.saveRegistryCustomerData();
                        break;
                }
                break;
                
            case 3:
                option = 3;
                break;
        }
        }while(option==1 || option==2);        
    }
}
