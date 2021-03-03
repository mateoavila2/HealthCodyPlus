/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorHealthCody.controller;

import ec.edu.espe.simulatorHealthCody.model.Authentication;
import ec.edu.espe.simulatorHealthCody.model.Registry;
import ec.edu.espe.simulatorHealthCody.view.CustomerMenu;
import ec.edu.espe.simulatorHealthCody.view.LoginAdministrator;
import ec.edu.espe.simulatorHealthCody.view.PrincipalWindow;
import ec.edu.espe.simulatorHealthCody.view.CustomerWindow;
import ec.edu.espe.simulatorHealthCody.view.EmployeeWindow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Rafa
 */
public class LoginController implements ActionListener, MouseListener {

    PrincipalWindow loginWindow;
    Authentication authentication;

    public LoginController(PrincipalWindow window, Authentication authentication) {
        this.loginWindow = window;
        this.authentication = authentication;
        this.loginWindow.setVisible(true);
        window.getBtnLogin().addActionListener(this);
        window.getLblRegister().addMouseListener(this);
        window.getRdbEmployee().addActionListener(this);
        window.getRdbCustomer().addActionListener(this);
        window.getLblAdminLogin().addMouseListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == loginWindow.getBtnLogin()) {
            boolean compare = false;
            this.authentication = new Authentication("Customers");
            String userName, password;
            userName = loginWindow.getTxtUserName().getText();
            password = loginWindow.getTxpPassword().getText();
            compare = this.authentication.login(userName, password);
            if (compare == true) {
                this.loginWindow.setVisible(false);
                CustomerMenu customerMenu;
                CustomerMenuControl customerMenuControl;
                customerMenu = new CustomerMenu();
                customerMenuControl = new CustomerMenuControl(customerMenu);
            } else {
                JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrecta");
                loginWindow.getTxtUserName().setText("");
                loginWindow.getTxpPassword().setText("");
            }
        }
        if (ae.getSource() == loginWindow.getRdbCustomer()) {
            CustomerWindow customerWindow;
            CustomerController customerController;
            customerWindow = new CustomerWindow();
            loginWindow.setVisible(false);
            customerWindow.setVisible(true);
            customerController = new CustomerController(customerWindow);
        }
        if (ae.getSource() == loginWindow.getRdbEmployee()) {
            EmployeeWindow employeeWindow;
            EmployeeController employeeController;
            employeeWindow = new EmployeeWindow();
            loginWindow.setVisible(false);
            employeeWindow.setVisible(true);
            employeeController = new EmployeeController(employeeWindow);

        }

    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if (me.getSource() == loginWindow.getLblRegister()) {
            loginWindow.getRdbCustomer().setVisible(true);
            loginWindow.getRdbEmployee().setVisible(true);
        }

        if (me.getSource() == loginWindow.getLblAdminLogin()) {
            LoginAdministrator loginAdministrator = new LoginAdministrator();
            LoginAdminController loginAdminController;
            loginWindow.setVisible(false);
            loginAdminController = new LoginAdminController(loginAdministrator);
        }
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
