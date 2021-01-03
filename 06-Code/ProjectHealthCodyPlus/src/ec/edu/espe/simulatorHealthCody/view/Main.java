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
import ec.edu.espe.simulatorHealthCody.controller.AdministratorMenuOptions;
import ec.edu.espe.simulatorHealthCody.controller.MenuDataCustomer;
import ec.edu.espe.simulatorHealthCody.model.AppointmentsAdmin;
import ec.edu.espe.simulatorHealthCody.model.AppointmentsAdminList;
import ec.edu.espe.simulatorHealthCody.model.MedicalHistory;
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
        int returns = 0;
        switch(option){
            case 1:
                LogInMenu loginMenu = new LogInMenu();
                loginMenu.showMenuLogin();
                int loginOption = loginMenu.selectOptionLoginMenu();
                
                switch(loginOption){
                    case 1:                        
                        boolean loginCompareAdmin;
                        int optionMenuAdmin;
                        int optionCustomerMedical;
                        int optionMedicalMenu = 0;
                        do{
                            AdministratorLoginMenu administratorLoginMenu = new AdministratorLoginMenu();
                            administratorLoginMenu.completeLoginDetails();
                            loginCompareAdmin = administratorLoginMenu.verifyAdministratorData();
                        }while(loginCompareAdmin == false);
                         AdministratorMenuOptions administratorMenuOptions = new AdministratorMenuOptions();
                         do
                        {
                        administratorMenuOptions.showAdminOptions();
                        optionMenuAdmin = administratorMenuOptions.selectOptionMenuAdmin();
                        switch(optionMenuAdmin)
                        {
                            
                            case 1: 
                                    MenuDataCustomer menuMedicalHistory = new MenuDataCustomer();
                                    optionCustomerMedical=menuMedicalHistory.selectMedicalHistoryOption();
                                    
                                    MedicalHistory medicalHistory = new MedicalHistory();
                                   
                                    if(optionCustomerMedical==1)
                                    {
                                        medicalHistory.searchCustomer();
                                    }
                                    if(optionCustomerMedical==2)
                                    {
                                        optionMedicalMenu = optionCustomerMedical;
                                    }
                                    else
                                    {
                                        System.out.println("OPCION NO VALIDA");
                                    }
                                    break;
                            case 2:
                                    
                                    AppointmentsAdmin appointmentsAdmin = new AppointmentsAdmin("","");
                                    
                                    AppointmentsAdminList appointmentsAdminList = new AppointmentsAdminList();
                                    appointmentsAdminList.saveAppointments(appointmentsAdmin);
                                break;
                            case 3: 
                                    break; 
                            case 4: 
                                    break; 
                            case 5: 
                                    break;
                        }
                        }while(optionMenuAdmin!=5);
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
