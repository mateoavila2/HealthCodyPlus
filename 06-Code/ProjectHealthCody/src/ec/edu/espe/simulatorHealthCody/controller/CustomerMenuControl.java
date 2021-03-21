/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorHealthCody.controller;

import ec.edu.espe.simulatorHealthCody.model.Appointment;
import ec.edu.espe.simulatorHealthCody.model.Customer;
import ec.edu.espe.simulatorHealthCody.view.AddAppointment;
import ec.edu.espe.simulatorHealthCody.view.CustomerMenu;
import ec.edu.espe.simulatorHealthCody.view.LoginCustomer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Rafa
 */
public class CustomerMenuControl implements ActionListener {

    CustomerMenu customerMenu;

    public CustomerMenuControl(CustomerMenu customerMenu) {
        this.customerMenu = customerMenu;
        this.customerMenu.setLocationRelativeTo(null);
        this.customerMenu.setVisible(true);
        this.customerMenu.btnReturn.addActionListener(this);
        this.customerMenu.btnAddAppointment.addActionListener(this);
        this.customerMenu.btnShowAppointment.addActionListener(this);
    }
    public void show() {
        this.customerMenu.setLocationRelativeTo(null);
        this.customerMenu.setVisible(true);
    }

    public void hide() {
        this.customerMenu.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == customerMenu.btnReturn) {
            LoginCustomer loginCustomer;
            LoginCustomerController loginController;
            loginCustomer = new LoginCustomer();
            this.customerMenu.setVisible(false);
            loginController = new LoginCustomerController(loginCustomer);

        }
        if (ae.getSource() == customerMenu.btnAddAppointment) {
            AddAppointment addAppointment;
            AppointmentController appointmentController;
            addAppointment = new AddAppointment();
            this.customerMenu.setVisible(false);
            try {
                appointmentController = new AppointmentController(addAppointment);
            } catch (ParseException ex) {
                Logger.getLogger(CustomerMenuControl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (ae.getSource() == customerMenu.btnShowAppointment) {
            String recovered;
            Appointment appointment = new Appointment("Scheduled reservate");
            Customer customer = new Customer();
            recovered = appointment.find(customer.getCodeAppoinment());
            if (recovered.equals("")) {
                JOptionPane.showMessageDialog(null, "No tiene citas agendadas");
            } else {
                JOptionPane.showMessageDialog(null, "Su cita agendada es: \n" + recovered);

            }

        }
    }

}
