/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorHealthCody.controller;

import ec.edu.espe.simulatorHealthCody.model.Authentication;
import ec.edu.espe.simulatorHealthCody.view.EmployeeMenu;
import ec.edu.espe.simulatorHealthCody.view.LoginAdministrator;
import ec.edu.espe.simulatorHealthCody.view.PrincipalWindow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Rafa
 */
public class LoginAdminController implements ActionListener, MouseListener {

    LoginAdministrator loginAdministrator;
    Authentication authentication;

    public LoginAdminController(LoginAdministrator loginAdministrator) {
        this.loginAdministrator = loginAdministrator;
        this.loginAdministrator.setLocationRelativeTo(null);
        this.loginAdministrator.setVisible(true);
        authentication = new Authentication("Employees");
        loginAdministrator.btnLogin.addActionListener(this);
        loginAdministrator.btnReturn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == loginAdministrator.btnLogin) {
            boolean compare;
            String userName, password;
            userName = loginAdministrator.txtUser.getText();
            password = loginAdministrator.txtCode.getText();
            System.out.println(userName);
            System.out.println(password);
            compare = authentication.login(userName, password);
            if (compare == true) {
                EmployeeMenu employeeMenu;
                EmployeeMenuControl employeeMenuControl;
                employeeMenu = new EmployeeMenu();
                this.loginAdministrator.setVisible(false);
                employeeMenuControl = new EmployeeMenuControl(employeeMenu);
            } else {
                JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrecta");
                loginAdministrator.txtUser.setText("");
                loginAdministrator.txtCode.setText("");
            }
        }
        if (ae.getSource() == loginAdministrator.btnReturn) {
            PrincipalWindow loginWindow = new PrincipalWindow();
            Authentication authentication = new Authentication("Customers");
            this.loginAdministrator.setVisible(false);
            LoginController loginController = new LoginController(loginWindow, authentication);
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {

    }

    @Override
    public void mousePressed(MouseEvent me) {

    }

    @Override
    public void mouseReleased(MouseEvent me) {

    }

    @Override
    public void mouseEntered(MouseEvent me) {

    }

    @Override
    public void mouseExited(MouseEvent me) {

    }

}
