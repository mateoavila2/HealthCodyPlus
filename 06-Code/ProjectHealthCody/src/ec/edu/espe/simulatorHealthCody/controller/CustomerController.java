/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorHealthCody.controller;

import com.toedter.calendar.JDateChooser;
import ec.edu.espe.simulatorHealthCody.model.Authentication;
import ec.edu.espe.simulatorHealthCody.model.Customer;
import ec.edu.espe.simulatorHealthCody.model.Registry;
import ec.edu.espe.simulatorHealthCody.view.PrincipalWindow;
import ec.edu.espe.simulatorHealthCody.view.CustomerWindow;
import static java.awt.SystemColor.window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author Rafa
 */
public class CustomerController implements ActionListener, MouseListener {

    CustomerWindow customerWindow;
    Registry registry;

    public CustomerController(CustomerWindow window) {
        this.customerWindow = window;
        window.getBtnConfirm().addActionListener(this);
        window.getBtnFinish().addActionListener(this);
        window.getBtnBack().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == customerWindow.getBtnConfirm()) {
            int option;

            if ((customerWindow.getTxtName().getText().equals("")) || (customerWindow.getTxtID().getText().equals(""))) {
                JOptionPane.showMessageDialog(null, "Campos vacios, Complete todos los campos");

            } else {
                option = JOptionPane.showConfirmDialog(null, "Confirmar registro ?", "Guardar datos", JOptionPane.YES_NO_CANCEL_OPTION);
                if (option == 0) {
                    JOptionPane.showMessageDialog(null, "Datos guardados", "Confirmacion", JOptionPane.INFORMATION_MESSAGE);
                    customerWindow.getLblMessage().setVisible(true);
                    customerWindow.getLblUserName().setEnabled(true);
                    customerWindow.getTxtUserName().setEnabled(true);
                    customerWindow.getLblPassword().setEnabled(true);
                    customerWindow.getTxtPassword().setEnabled(true);
                    customerWindow.getBtnConfirm().setEnabled(false);
                    customerWindow.getBtnFinish().setEnabled(true);
                } else if (option == 1) {

                }
            }
        }
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
                PrincipalWindow loginWindow = new PrincipalWindow();
                Authentication authentication = new Authentication("Customers");
                this.customerWindow.setVisible(false);
                LoginController loginController = new LoginController(loginWindow, authentication);

            }
        }
        if (ae.getSource() == customerWindow.getBtnBack()) {
            PrincipalWindow loginWindow = new PrincipalWindow();
            Authentication authentication = new Authentication("Customers");
            this.customerWindow.setVisible(false);
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

    public String covertDate(JDateChooser jDate) {
        DateFormat dateFormat;

        dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        String date = dateFormat.format(jDate.getDate());
        return date;

    }

}
