/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorHealthCody.controller;

import ec.edu.espe.simulatorHealthCody.model.Authentication;
import ec.edu.espe.simulatorHealthCody.utils.DBmanager;
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
public class LoginAdminControlller implements ActionListener {

    LoginAdministrator loginAdministrator;
    DBmanager db;

    public LoginAdminControlller(LoginAdministrator loginAdministrator) {
        
        this.loginAdministrator = loginAdministrator;
        this.loginAdministrator.setLocationRelativeTo(null);
        this.loginAdministrator.setVisible(true);
        this.loginAdministrator.btnLogin.addActionListener(this);
        this.loginAdministrator.btnReturn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == loginAdministrator.btnLogin) {

            boolean correctUser, correctkey;
            db = new DBmanager("Registry", "Customers");
            correctUser = db.verifyExistingData(loginAdministrator.txtUser.getText());
            correctkey = db.verifyExistingData(loginAdministrator.txtCode.getText());
            if ((correctUser == true) || (correctkey == true)) {
                EmployeeMenu employeeMenu;
                EmployeeMenuControl employeeMenuControl;
                employeeMenu = new EmployeeMenu();
                this.loginAdministrator.setVisible(false);
                employeeMenuControl = new EmployeeMenuControl(employeeMenu);
            } else {
                JOptionPane.showMessageDialog(null, "Usuario o Código incorrectos");
                loginAdministrator.txtUser.setText(null);
                loginAdministrator.txtCode.setText(null);
                loginAdministrator.txtUser.getAction();
                loginAdministrator.txtCode.getAction();
            }
        }
        if (ae.getSource() == loginAdministrator.btnReturn) {
            this.loginAdministrator.setVisible(false);
            LoginCustomer loginWindow = new LoginCustomer();
            LoginCustomerController loginController = new LoginCustomerController(loginWindow);

        }
    }

}
