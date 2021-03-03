/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorHealthCody.controller;

import ec.edu.espe.simulatorHealthCody.model.Authentication;
import ec.edu.espe.simulatorHealthCody.view.EmployeeMenu;
import ec.edu.espe.simulatorHealthCody.view.LoginAdministrator;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Rafa
 */
public class LoginAdminControl implements ActionListener{
    LoginAdministrator loginAdministrator;
    Authentication authentication;
    public LoginAdminControl(LoginAdministrator loginAdministrator) {
        this.loginAdministrator = loginAdministrator;
        authentication = new Authentication("Employees");
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == loginAdministrator.btnLogin){
        
        boolean comparateAdmin = authentication.login(loginAdministrator.txtUser.getText(),loginAdministrator.txtCode.getText());
        if (comparateAdmin == false) {
            JOptionPane.showMessageDialog(null, "Usuario o Código incorrectos");
            loginAdministrator.txtUser.setText(null);
            loginAdministrator.txtCode.setText(null);
            loginAdministrator.txtUser.getAction();
            loginAdministrator.txtCode.getAction();
        } else {
            this.loginAdministrator.setVisible(false);
            EmployeeMenu employeeMenu;
            Employee
        }
        }
    }
    
    
}
