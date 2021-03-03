/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorHealthCody.controller;

import com.toedter.calendar.JDateChooser;
import ec.edu.espe.simulatorHealthCody.model.Authentication;
import ec.edu.espe.simulatorHealthCody.model.Employee;
import ec.edu.espe.simulatorHealthCody.model.Registry;
import ec.edu.espe.simulatorHealthCody.view.REmployee;
import ec.edu.espe.simulatorHealthCody.view.LoginAdministrator;
import ec.edu.espe.simulatorHealthCody.view.LoginCustomer;
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
public class REmployeeController implements ActionListener, MouseListener {

    REmployee rEmployee;
    Registry registry;

    public REmployeeController(REmployee rEmployee, Registry registry) {
        this.rEmployee = rEmployee;
        this.registry = registry;
        this.rEmployee.setLocationRelativeTo(null);
        this.rEmployee.setVisible(true);
        this.rEmployee.btnSave.addActionListener(this);
        this.rEmployee.btnFinish.addActionListener(this);
        this.rEmployee.btnBack.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == rEmployee.btnSave) {
            int option;

            if ((rEmployee.txtName.getText().equals("")) || (rEmployee.txtID.getText().equals("")) || (rEmployee.txtNumberPhone.getText().equals(""))) {
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
                    //emptyFields();
                }
            }
        }
        if (ae.getSource() == rEmployee.btnFinish) {
            Employee employee;
            String userName,password;
            userName = rEmployee.txtUsername.getText();
            if (rEmployee.txtUsername.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Nombre de usuario vacio, Complete");
            } else {
                String name, ID, dateOfBirth, gender, numberPhone;
                name = rEmployee.txtName.getText();
                ID = rEmployee.txtID.getText();
                dateOfBirth = covertDate(rEmployee.jDate);
                gender = rEmployee.cmbGender.getSelectedItem().toString();
                numberPhone = rEmployee.txtNumberPhone.getText();
                employee = new Employee(name, ID, dateOfBirth, gender, numberPhone, userName, "");
                password = employee.generateCode();
                employee.setAccesKey(password);
                JOptionPane.showMessageDialog(null, "Su codigo de acceso es: " + password);
                this.registry.register(employee);
                this.rEmployee.setVisible(false);
                /*LoginAdministrator loginAdministrator;
                LoginAdminControl loginAdminControl;
                loginAdministrator = new LoginAdministrator();
                loginAdminControl = new LoginAdminControl(loginAdministrator);*/

            }
        }
        if (ae.getSource() == rEmployee.btnBack) {
            LoginCustomer loginCustomer = new LoginCustomer();
            LoginCustomerController loginCustomerController;
            this.rEmployee.setVisible(false);
            loginCustomerController = new LoginCustomerController(loginCustomer);
            
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
