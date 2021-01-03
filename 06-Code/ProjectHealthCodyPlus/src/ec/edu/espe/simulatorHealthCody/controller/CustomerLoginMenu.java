/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorHealthCody.controller;

import ec.edu.espe.simulatorHealthCody.model.LogIn;
import java.util.Scanner;

/**
 *
 * @author Rafael Buse ESPE-DCCO
 */
public class CustomerLoginMenu {
    String userCustomer;
    String passwordCustomer;
    Scanner read = new Scanner(System.in);
    
    public void completeLoginDetails(){
        read.nextLine();
        System.out.print("Usuario: ");
        userCustomer = read.nextLine();
        System.out.print("Contraseña: ");
        passwordCustomer  = read.nextLine();
    }
    
    public boolean verifyCustomerData(){
        LogIn LoginCustomer = new LogIn(userCustomer ,passwordCustomer);
        boolean loginCompareCustomer = LoginCustomer.LoginCustomer();
        return loginCompareCustomer;
    }
}
