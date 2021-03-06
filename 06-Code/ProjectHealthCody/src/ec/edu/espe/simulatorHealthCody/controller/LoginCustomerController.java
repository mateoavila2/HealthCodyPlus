/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorHealthCody.controller;

import ec.edu.espe.simulatorHealthCody.model.Authentication;
import ec.edu.espe.simulatorHealthCody.model.Customer;
import ec.edu.espe.simulatorHealthCody.model.Registry;
import ec.edu.espe.simulatorHealthCody.utils.DBmanager;
import ec.edu.espe.simulatorHealthCody.view.CustomerMenu;
import ec.edu.espe.simulatorHealthCody.view.LoginAdministrator;
import ec.edu.espe.simulatorHealthCody.view.LoginCustomer;
import ec.edu.espe.simulatorHealthCody.view.RCustomer;
import ec.edu.espe.simulatorHealthCody.view.REmployee;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Rafa
 */
public class LoginCustomerController implements ActionListener, MouseListener {

    LoginCustomer loginCustomer;
    DBmanager db;

    public LoginCustomerController(LoginCustomer loginCustomer) {
        this.loginCustomer = loginCustomer;
        this.loginCustomer.setLocationRelativeTo(null);
        this.loginCustomer.setVisible(true);
        this.loginCustomer.btnLogin.addActionListener(this);
        this.loginCustomer.lblRegister.addMouseListener(this);
        this.loginCustomer.rdbCustomer.addActionListener(this);
        this.loginCustomer.rdbEmployee.addActionListener(this);
        this.loginCustomer.lblAdminLogin.addMouseListener(this);
        this.loginCustomer.lblAdminLogin.addMouseListener(this);
    }

    public void login(String userName, String password) {
        boolean compare, corretUser, correctKey;
        corretUser = true;//operation.verifyExistingData(userName);
        correctKey = true;//operation.verifyExistingData(accesKey);
        if (corretUser == true && correctKey == true) {
            compare = true;
        } else {
            compare = false;
        }
        System.out.println(compare);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == loginCustomer.btnLogin) {
            if (loginCustomer.txtUserName.getText().equals("") && loginCustomer.txpPassword.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Datos no ingresados");
            } else {
                boolean correctUser, correctkey;
                db = new DBmanager("Registry", "Customers");
                correctUser = db.verifyExistingData(loginCustomer.txtUserName.getText());
                correctkey = db.verifyExistingData(loginCustomer.txpPassword.getText());
                if ((correctUser == true) && correctkey == true) {
                    Customer customer = new Customer();
                    customer.setCodeAppoinment(loginCustomer.txtUserName.getText());
                    loginCustomer.txtUserName.setText("");
                    loginCustomer.txpPassword.setText("");
                    CustomerMenu customerMenu;
                    CustomerMenuControl customerMenuControl;
                    customerMenu = new CustomerMenu();
                    this.loginCustomer.setVisible(false);
                    customerMenuControl = new CustomerMenuControl(customerMenu);
                } else {
                    loginCustomer.txtUserName.setText("");
                    loginCustomer.txpPassword.setText("");
                    JOptionPane.showMessageDialog(null, " Usuario o contaseña no existennte \n\t Intente de nuevo");
                }
            }

        }
        if (ae.getSource() == loginCustomer.rdbEmployee) {
            Registry registry;
            registry = new Registry("Employees");
            REmployee rEmployee = new REmployee();
            REmployeeController rEmployeeController;
            this.loginCustomer.setVisible(false);
            rEmployeeController = new REmployeeController(rEmployee, registry);
        }
        if (ae.getSource() == loginCustomer.rdbCustomer) {
            Registry registry;
            registry = new Registry("Customers");
            RCustomer rCustomer = new RCustomer();
            RCustomerController rCustomerController;
            this.loginCustomer.setVisible(false);
            rCustomerController = new RCustomerController(rCustomer, registry);
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if (me.getSource() == loginCustomer.lblRegister) {
            loginCustomer.rdbCustomer.setVisible(true);
            loginCustomer.rdbEmployee.setVisible(true);
        }
        if (me.getSource() == loginCustomer.lblAdminLogin) {
            LoginAdministrator loginAdministrator;
            LoginAdminControlller loginAdminControlller;
            loginAdministrator = new LoginAdministrator();
            this.loginCustomer.setVisible(false);
            loginAdminControlller = new LoginAdminControlller(loginAdministrator);

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
