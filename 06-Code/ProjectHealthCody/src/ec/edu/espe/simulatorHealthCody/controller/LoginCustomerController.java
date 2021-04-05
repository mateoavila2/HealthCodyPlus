/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorHealthCody.controller;

import ec.edu.espe.simulatorHealthCody.model.Customer;
import ec.edu.espe.simulatorHealthCody.model.Employee;
import ec.edu.espe.simulatorHealthCody.utils.NosqlDBManager;
import ec.edu.espe.simulatorHealthCody.view.CustomerMenu;
import ec.edu.espe.simulatorHealthCody.view.LoginAdministrator;
import ec.edu.espe.simulatorHealthCody.view.LoginCustomer;
import ec.edu.espe.simulatorHealthCody.view.RCustomer;
import ec.edu.espe.simulatorHealthCody.view.REmployee;
import javax.swing.JOptionPane;

/**
 *
 * @author Rafa
 */
public class LoginCustomerController{

    LoginCustomer loginCustomer;
    NosqlDBManager db;

    public LoginCustomerController(LoginCustomer loginCustomer) {
        this.loginCustomer = loginCustomer;
    }

    public void show() {
        this.loginCustomer.setLocationRelativeTo(null);
        this.loginCustomer.setVisible(true);
    }

    public void hide() {
        this.loginCustomer.setVisible(false);
    }

    public void login(String userName, String password) {
        if (userName.equals("") && password.equals("")) {
            JOptionPane.showMessageDialog(null, "Datos no ingresados");
        } else {
            boolean correctUser, correctkey;
            db = new NosqlDBManager("Registry", "Customers");
            correctUser = db.verifyExistingData(userName);
            correctkey = db.verifyExistingData(password);
            if ((correctUser == true) && correctkey == true) {
                Customer customer = new Customer();
                customer.setCodeAppoinment(loginCustomer.txtUserName.getText());
                loginCustomer.txtUserName.setText("");
                loginCustomer.txpPassword.setText("");
                hide();
                CustomerMenu customerMenu;
                customerMenu = new CustomerMenu();
                CustomerMenuControl customerMenuControl;
                
                
                customerMenuControl = new CustomerMenuControl(customerMenu);
            } else {
                loginCustomer.txtUserName.setText("");
                loginCustomer.txpPassword.setText("");
                JOptionPane.showMessageDialog(null, " Usuario o contaseña no existennte \n\t Intente de nuevo");
            }

        }

    }
    
    public void pressCustomer(){
        hide();
        RCustomer rcustomer = new RCustomer();
        Customer customer = new Customer();
        RCustomerController controller = new RCustomerController(rcustomer, customer);
        controller.show();
    }
    
    public void pressEmployee(){
        hide();
        REmployee rEmployee = new REmployee();
        Employee employee = new Employee();
        REmployeeController controller = new REmployeeController(rEmployee, employee);
        controller.show();
    }
    
    public void changeForAdmin(){
        hide();
        LoginAdministrator loginAdministrator = new LoginAdministrator();
        LoginAdminControlller controlller = new LoginAdminControlller(loginAdministrator);
        controlller.show();
    
    }

    /*@Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == loginCustomer.btnLogin) {
            if (loginCustomer.txtUserName.getText().equals("") && loginCustomer.txpPassword.getText().equals("")) {

            } else {
                boolean correctUser, correctkey;
                db = new NosqlDBManager("Registry", "Customers");
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

    }*/

}
