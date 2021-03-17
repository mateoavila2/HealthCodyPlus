/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorHealthCody.controller;

import com.toedter.calendar.JDateChooser;
import ec.edu.espe.simulatorHealthCody.model.Authentication;
import ec.edu.espe.simulatorHealthCody.model.Customer;
import ec.edu.espe.simulatorHealthCody.model.User;
import ec.edu.espe.simulatorHealthCody.view.LoginCustomer;
import ec.edu.espe.simulatorHealthCody.view.RCustomer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author Mateo Ávila
 */
public class RCustomerController implements ActionListener, MouseListener {

    RCustomer rCustomer;
    User user;

    public RCustomerController(RCustomer rCustomer, User user) {
        this.user = user;
        this.rCustomer = rCustomer;
        this.rCustomer.setLocationRelativeTo(null);
        this.rCustomer.setVisible(true);
        this.rCustomer.btnConfirm.addActionListener(this);
        this.rCustomer.btnFinish.addActionListener(this);
        this.rCustomer.btnBack.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == rCustomer.btnConfirm) {
            int option;

            if ((rCustomer.txtName.getText().equals("")) || (rCustomer.txtID.getText().equals(""))) {
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
        if (ae.getSource() == rCustomer.btnFinish) {
            Customer customer;
            String userName = "", password = "", dateOfBirth = "";
            userName = rCustomer.txtUserName.getText();
            password = rCustomer.txtPassword.getText();
            //btnFinish.setEnabled(true);
            if ((rCustomer.txtUserName.getText().equals("") || (rCustomer.txtPassword.getText().equals("")))) {
                JOptionPane.showMessageDialog(null, "Complete todos los campos");
            } else {
                String name, ID, gender;
                name = rCustomer.txtName.getText();
                ID = rCustomer.txtID.getText();
                gender = rCustomer.cmbGender.getSelectedItem().toString();
                dateOfBirth = covertDate(rCustomer.jDate);
                customer = new Customer(name, ID, dateOfBirth, gender, userName, password);
                System.out.println(customer.toString());
                this.user.register(customer);

                
                LoginCustomer loginCustomer;
                LoginCustomerController loginController;
                loginCustomer = new LoginCustomer();
                this.rCustomer.setVisible(false);
                loginController = new LoginCustomerController(loginCustomer);
            }
        }
        if (ae.getSource() == rCustomer.btnBack) {
            
            this.rCustomer.setVisible(false);
            LoginCustomer loginCustomer = new LoginCustomer();
            LoginCustomerController loginCustomerController = new LoginCustomerController(loginCustomer);

        }

        /*
        if (ae.getSource() == customerWindow.getBtnFinish()) {
            Customer customer;
            Registry registy;
            String userName = "", password = "", dateOfBirth = "";
            userName = customerWindow.getTxtUserName().getText();
            password = customerWindow.getTxtPassword().getText();
            //btnFinish.setEnabled(true);
            if ((customerWindow.getTxtUserName().getText().equals("") || (customerWindow.getTxtPassword().getText().equals("")))) {
                JOptionPane.showMessageDialog(null, "Complete todos los campos");
            } else {
                String name, ID, gender;
                name = customerWindow.getTxtName().getText();
                ID = customerWindow.getTxtID().getText();
                gender = customerWindow.getCmbGender().getSelectedItem().toString();
                dateOfBirth = covertDate(customerWindow.getjDate());
                customer = new Customer(name, ID, dateOfBirth, gender, userName, password);
                registy = new Registry("Customers");
                System.out.println(customer.toString());
                registy.register(customer);
                LoginCustomer loginWindow = new LoginCustomer();
                Authentication authentication = new Authentication("Customers");
                this.customerWindow.setVisible(false);
                LoginCustomerController loginController = new LoginCustomerController(loginWindow, authentication);

            }
        }
        if (ae.getSource() == customerWindow.getBtnBack()) {
            LoginCustomer loginWindow = new LoginCustomer();
            Authentication authentication = new Authentication("Customers");
            this.customerWindow.setVisible(false);
            LoginController loginController = new LoginController(loginWindow, authentication);
        }*/
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

    public void emptyFields() {

    }

    public String covertDate(JDateChooser jDate) {
        DateFormat dateFormat;

        dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        String date = dateFormat.format(jDate.getDate());
        return date;

    }

}
