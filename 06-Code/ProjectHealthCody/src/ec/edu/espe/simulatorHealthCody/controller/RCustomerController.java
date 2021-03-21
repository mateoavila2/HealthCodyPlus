/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorHealthCody.controller;

import com.google.gson.Gson;
import com.toedter.calendar.JDateChooser;
import ec.edu.espe.simulatorHealthCody.model.Customer;
import ec.edu.espe.simulatorHealthCody.utils.MongoDBManager;
import ec.edu.espe.simulatorHealthCody.view.LoginCustomer;
import ec.edu.espe.simulatorHealthCody.view.RCustomer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author Rafa
 */
public class RCustomerController {

    RCustomer rCustomer;
    Customer customer;
    MongoDBManager db;
    Gson gson;

    public RCustomerController(RCustomer rCustomer, Customer customer) {
        this.rCustomer = rCustomer;
        this.customer = customer;
        db = new MongoDBManager();
        db.openConnection("Registry");
        gson = new Gson();
    }
    public void show() {
        this.rCustomer.setLocationRelativeTo(null);
        this.rCustomer.setVisible(true);
    }

    public void hide() {
        this.rCustomer.setVisible(false);
    }

    public void confirmData() {
        int option;

        if (customer.getName().equals("") || customer.getId().equals("")) {
            JOptionPane.showMessageDialog(null, "Campos vacios, Complete todos los campos");
        } else {
            option = JOptionPane.showConfirmDialog(null, "Confirmar registro ?", "Guardar datos", JOptionPane.YES_NO_CANCEL_OPTION);

            if (option == 0) {
                JOptionPane.showMessageDialog(null, "Datos guardados", "Confirmacion", JOptionPane.INFORMATION_MESSAGE);
                rCustomer.lblMessage.setVisible(true);
                rCustomer.lblUserName.setEnabled(true);
                rCustomer.txtUserName.setEnabled(true);
                rCustomer.lblPassword.setEnabled(true);
                rCustomer.txtPassword.setEnabled(true);
                rCustomer.btnConfirm.setEnabled(false);
                rCustomer.btnFinish.setEnabled(true);
            } else if (option == 1) {

            }
        }
    }

    public boolean finish() {
        boolean status;

        if (customer.getUserName().equals("") || customer.getAccesKey().equals("")) {
            JOptionPane.showMessageDialog(null, "Complete todos los campos");
            status = false;
        } else {
            String dateOfBirth, gender;
            gender = rCustomer.cmbGender.getSelectedItem().toString();
            dateOfBirth = covertDate(rCustomer.jDate);
            customer.setDateOfBirth(dateOfBirth);
            customer.setGender(gender);
            status = true;
        }
        return status;

    }

    public void registerCustomer() {
        boolean status;
        String jsonCustomer;
        jsonCustomer = gson.toJson(customer);
        status = db.save(jsonCustomer,"Customers");
        if (status = true) {
            hide();
            LoginCustomer loginCustomer;
            LoginCustomerController loginController;
            loginCustomer = new LoginCustomer();
            loginController = new LoginCustomerController(loginCustomer);
            loginController.show();

        } else {
            JOptionPane.showMessageDialog(null, "Ocurrio un error inesperado");
        }

    }

    public void back() {
        hide();
        LoginCustomer loginCustomer = new LoginCustomer();
        LoginCustomerController loginCustomerController = new LoginCustomerController(loginCustomer);
        loginCustomerController.show();

    }

    public String covertDate(JDateChooser jDate) {
        DateFormat dateFormat;

        dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        String date = dateFormat.format(jDate.getDate());
        return date;

    }

}
