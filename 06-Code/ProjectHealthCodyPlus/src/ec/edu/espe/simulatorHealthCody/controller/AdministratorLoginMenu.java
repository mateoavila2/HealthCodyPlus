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
public class AdministratorLoginMenu {
    String userAdmin;
    String passwordAdmin;
    String codeAdmin;
    Scanner read = new Scanner(System.in);
    
    public void completeLoginDetails(){
        read.nextLine();
        System.out.print("Usuario: ");
        userAdmin = read.nextLine();
        System.out.print("Contraseña: ");
        passwordAdmin = read.nextLine();
        System.out.print("Codigo de acceso: ");
        codeAdmin = read.nextLine();
    }
    
    public boolean verifyAdministratorData(){
        LogIn LoginAdministrator = new LogIn(userAdmin,passwordAdmin,codeAdmin);
        boolean loginCompareAdmin = LoginAdministrator.LoginAdministrator();
        return loginCompareAdmin;
    }
}
