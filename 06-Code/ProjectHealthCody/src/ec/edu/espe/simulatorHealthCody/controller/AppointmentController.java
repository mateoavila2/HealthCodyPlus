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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Rafa
 */
public class AppointmentController implements ActionListener, MouseListener {

    AddAppointment addAppointment;
    Appointment appointment;
    int selection = -1;
    List<Date> dates = new ArrayList();

    public AppointmentController(AddAppointment addAppointment) throws ParseException {

        this.addAppointment = addAppointment;
        this.addAppointment.setLocationRelativeTo(null);
        this.addAppointment.setVisible(true);
        showAppointmet();
        this.addAppointment.tableAppoint.addMouseListener(this);
        this.addAppointment.btnSave.addActionListener(this);
        this.addAppointment.btnback.addActionListener(this);
    }
    
    public void show() {
        this.addAppointment.setLocationRelativeTo(null);
        this.addAppointment.setVisible(true);
    }

    public void hide() {
        this.addAppointment.setVisible(false);
    }

    public void showAppointmet() throws ParseException {
        appointment = new Appointment("Scheduled appointments");
        dates = appointment.show();

        String matrix[][] = new String[dates.size()][4];
        for (int i = 0; i < dates.size(); i++) {
            matrix[i][0] = String.valueOf(dates.get(i).getHours()) + " : 0" + String.valueOf(dates.get(i).getMinutes()) + " : 0" + String.valueOf(dates.get(i).getSeconds());
            matrix[i][1] = String.valueOf(dates.get(i).getDate());
            matrix[i][2] = calculateMonth(dates.get(i).getMonth());
            matrix[i][3] = String.valueOf(dates.get(i).getYear() + 1900);
        }

        addAppointment.tableAppoint.setModel(new javax.swing.table.DefaultTableModel(
                matrix,
                new String[]{
                    "Hora", "Dia", "Mes", "Año"
                }
        ));

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String reservate, code;
        if (ae.getSource() == addAppointment.btnSave) {
            if (selection == -1) {
                JOptionPane.showMessageDialog(null, "Cita no seleccionsda \n Seleccione una cita");
            } else {
                for (int i = 0; i < dates.size(); i++) {
                    if (selection == (i)) {
                        appointment = new Appointment("Scheduled reservate");
                        Customer customer = new Customer();
                        code = appointment.find(customer.getCodeAppoinment());

                        if (code.equals("")) {
                            try {
                                appointment = new Appointment("Scheduled appointments");
                                reservate = appointment.delete(i);
                                appointment = new Appointment("Scheduled reservate");
                                appointment.add(reservate, customer.getCodeAppoinment());
                                JOptionPane.showMessageDialog(null, "Cita agendada con exito");
                            } catch (ParseException ex) {
                                Logger.getLogger(AppointmentController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Ya tiene una cita agendada");
                        }

                    }
                }
            }
            CustomerMenu customerMenu;
            CustomerMenuControl customerMenuControl;
            customerMenu = new CustomerMenu();
            this.addAppointment.setVisible(false);
            customerMenuControl = new CustomerMenuControl(customerMenu);
        }
        if (ae.getSource() == addAppointment.btnback) {
            CustomerMenu customerMenu;
            CustomerMenuControl customerMenuControl;
            customerMenu = new CustomerMenu();
            this.addAppointment.setVisible(false);
            customerMenuControl = new CustomerMenuControl(customerMenu);
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if (me.getSource() == addAppointment.tableAppoint) {
            selection = addAppointment.tableAppoint.rowAtPoint(me.getPoint());
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

    public String calculateMonth(int numberMonth) {
        String month;
        if (numberMonth == 0) {
            month = "Enero";
        } else if (numberMonth == 1) {
            month = "Febrero";
        } else if (numberMonth == 2) {
            month = "Marzo";
        } else if (numberMonth == 3) {
            month = "Abril";
        } else if (numberMonth == 4) {
            month = "Mayo";
        } else if (numberMonth == 5) {
            month = "Junio";
        } else if (numberMonth == 6) {
            month = "Julio";
        } else if (numberMonth == 7) {
            month = "Agosto";
        } else if (numberMonth == 8) {
            month = "Septiembre";
        } else if (numberMonth == 9) {
            month = "Octubre";
        } else if (numberMonth == 10) {
            month = "Noviembre";
        } else {
            month = "Diciembre";
        }

        return month;

    }

}
