/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorHealthCody.controller;

import com.google.gson.Gson;
import com.toedter.calendar.JDateChooser;
import ec.edu.espe.simulatorHealthCody.model.Employee;
import ec.edu.espe.simulatorHealthCody.utils.NosqlDBManager;
import ec.edu.espe.simulatorHealthCody.view.REmployee;
import ec.edu.espe.simulatorHealthCody.view.LoginAdministrator;
import ec.edu.espe.simulatorHealthCody.view.LoginCustomer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author Rafa
 */
public class REmployeeController {

    REmployee rEmployee;
    Employee employee;
    NosqlDBManager db;
    Gson gson;

    public REmployeeController(REmployee rEmployee, Employee employee) {
        this.rEmployee = rEmployee;
        this.employee = employee;
        db = new NosqlDBManager("Registry", "Employees");
        gson = new Gson();
    }

    public void show() {
        this.rEmployee.setLocationRelativeTo(null);
        this.rEmployee.setVisible(true);
    }

    public void hide() {
        this.rEmployee.setVisible(false);
    }

    public void confirmData() {

        int option;

        if (employee.getName().equals("") || employee.getId().equals("")) {
            JOptionPane.showMessageDialog(null, "Campos vacios, Complete todos los campos");
        } else {
            option = JOptionPane.showConfirmDialog(null, "Confirmar registro ?", "Guardar datos", JOptionPane.YES_NO_CANCEL_OPTION);

            if (option == 0) {
                JOptionPane.showMessageDialog(null, "Datos guardados", "Confirmacion", JOptionPane.INFORMATION_MESSAGE);
                rEmployee.lblIMessaage.setVisible(true);
                rEmployee.lblUSerimage.setVisible(true);
                rEmployee.lblUsername.setVisible(true);
                rEmployee.txtUsername.setVisible(true);
                rEmployee.btnFinish.setVisible(true);
            } else if (option == 1) {

            }
        }
    }

    public boolean finish() {
        boolean status;

        if (employee.getUserName().equals("")) {
            JOptionPane.showMessageDialog(null, "Complete todos los campos");
            status = false;
        } else {
            String dateOfBirth, gender, numberPhone, password;
            dateOfBirth = covertDate(rEmployee.jDate);
            gender = rEmployee.cmbGender.getSelectedItem().toString();
            numberPhone = rEmployee.txtNumberPhone.getText();
            password = employee.generateCode();
            employee.setAccesKey(password);
            JOptionPane.showMessageDialog(null, "Su codigo de acceso es: " + password);
            status = true;
        }
        return status;

    }

    public void registerEmployee() {
        boolean status;
        String jsonEmployee;
        jsonEmployee = gson.toJson(employee);
        status = db.save(jsonEmployee);
        if (status = true) {
            hide();
            LoginAdministrator loginAdministrator;
            LoginAdminControlller loginAdminControl;
            loginAdministrator = new LoginAdministrator();
            loginAdminControl = new LoginAdminControlller(loginAdministrator);

        } else {
            JOptionPane.showMessageDialog(null, "Ocurrio un error inesperado");
        }

    }

    public void back() {
        hide();
        LoginCustomer loginCustomer = new LoginCustomer();
        LoginCustomerController loginCustomerController;
        loginCustomerController = new LoginCustomerController(loginCustomer);
        loginCustomerController.show();

    }

    public String covertDate(JDateChooser jDate) {
        DateFormat dateFormat;

        dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        String date = dateFormat.format(jDate.getDate());
        return date;

    }

}
