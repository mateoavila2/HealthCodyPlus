/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulatorHealthCody;

import ec.edu.espe.simulatorHealthCody.controller.LoginController;
import ec.edu.espe.simulatorHealthCody.model.Authentication;
import ec.edu.espe.simulatorHealthCody.view.PrincipalWindow;

/**
 *
 * @author Rafa
 */
public class HealthCodySystem {
    public static void main(String[] args) {
        
        PrincipalWindow loginWindow;
        Authentication authentication;
        LoginController loginController;
        
        loginWindow = new PrincipalWindow();
        authentication = new Authentication("Customers");
        loginController = new LoginController(loginWindow, authentication);
        
        
    }
}
