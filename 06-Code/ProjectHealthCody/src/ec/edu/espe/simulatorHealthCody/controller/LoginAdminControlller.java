/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorHealthCody.controller;

import ec.edu.espe.simulatorHealthCody.model.Authentication;
import ec.edu.espe.simulatorHealthCody.model.Customer;
import ec.edu.espe.simulatorHealthCody.utils.MongoDBManager;
import ec.edu.espe.simulatorHealthCody.view.CustomerMenu;
import ec.edu.espe.simulatorHealthCody.view.EmployeeMenu;
import ec.edu.espe.simulatorHealthCody.view.LoginAdministrator;
import ec.edu.espe.simulatorHealthCody.view.LoginCustomer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Rafa
 */
public class LoginAdminControlller {

    LoginAdministrator loginAdministrator;
    MongoDBManager db;

    public LoginAdminControlller(LoginAdministrator loginAdministrator) {

        this.loginAdministrator = loginAdministrator;
        db = new MongoDBManager();
        db.openConnection("Registry");

    }

    public void show() {
        this.loginAdministrator.setLocationRelativeTo(null);
        this.loginAdministrator.setVisible(true);
    }

    public void hide() {
        this.loginAdministrator.setVisible(false);
    }

    public void login(String userName, String password) {
        if (userName.equals("") && password.equals("")) {
            JOptionPane.showMessageDialog(null, "Datos no ingresados");
        } else {
            boolean correctUser, correctkey;
            correctUser = db.verifyExistingData(userName,"Employees");
            correctkey = db.verifyExistingData(password,"Employees");
            if ((correctUser == true) && correctkey == true) {
                hide();
                EmployeeMenu employeeMenu;
                EmployeeMenuControl employeeMenuControl;
                employeeMenu = new EmployeeMenu();
                employeeMenuControl = new EmployeeMenuControl(employeeMenu);
                employeeMenuControl.show();

            } else {
                JOptionPane.showMessageDialog(null, "Usuario o Código incorrectos");
                loginAdministrator.txtUser.setText("");
                loginAdministrator.txtCode.setText("");
            }
        }
    }
    public void back() {
        hide();
        LoginCustomer loginWindow = new LoginCustomer();
        LoginCustomerController loginController = new LoginCustomerController(loginWindow);
        loginController.show();
    }
}
