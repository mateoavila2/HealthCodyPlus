/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorHealthCody.controller;

import ec.edu.espe.simulatorHealthCody.model.Customer;
import ec.edu.espe.simulatorHealthCody.model.Employee;
import ec.edu.espe.simulatorHealthCody.utils.MongoDBManager;
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
    MongoDBManager db;

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
            db = new MongoDBManager();
            db.openConnection("Registry");
            correctUser = db.verifyExistingData(userName,"Customers");
            correctkey = db.verifyExistingData(password,"Customers");
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
}
