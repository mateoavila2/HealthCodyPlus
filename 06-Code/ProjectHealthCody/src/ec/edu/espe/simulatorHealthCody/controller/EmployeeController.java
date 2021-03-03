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
import ec.edu.espe.simulatorHealthCody.view.EmployeeWindow;
import ec.edu.espe.simulatorHealthCody.view.LoginAdministrator;
import ec.edu.espe.simulatorHealthCody.view.PrincipalWindow;
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
public class EmployeeController implements ActionListener, MouseListener {

    EmployeeWindow employeeWindow;
    Registry registry;

    public EmployeeController(EmployeeWindow employeeWindow) {
        this.employeeWindow = employeeWindow;
        employeeWindow.btnSave.addActionListener(this);
        employeeWindow.btnFinish.addActionListener(this);
        employeeWindow.btnBack.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == employeeWindow.btnSave) {
            int option;

            if ((employeeWindow.txtName.getText().equals("")) || (employeeWindow.txtID.getText().equals("")) || (employeeWindow.txtNumberPhone.getText().equals(""))) {
                JOptionPane.showMessageDialog(null, "Campos vacios, Complete todos los campos");

            } else {
                option = JOptionPane.showConfirmDialog(null, "Confirmar registro ?", "Guardar datos", JOptionPane.YES_NO_CANCEL_OPTION);
                if (option == 0) {
                    JOptionPane.showMessageDialog(null, "Datos guardados", "Confirmacion", JOptionPane.INFORMATION_MESSAGE);
                    employeeWindow.lblUsername.setVisible(true);
                    employeeWindow.txtUsername.setVisible(true);
                    employeeWindow.btnFinish.setVisible(true);
                    employeeWindow.lblUserImage.setVisible(true);

                } else if (option == 1) {
                    //emptyFields();
                }
            }
        }

        if (ae.getSource() == employeeWindow.btnFinish) {
            Employee employee;
            String userName;
            String password;

            password = generateCode();
            userName = employeeWindow.txtUsername.getText();

            if (employeeWindow.txtUsername.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Nombre de usuario vacio, Complete");
            } else {
                String name, ID, dateOfBirth, gender, numberPhone;
                name = employeeWindow.txtName.getText();
                ID = employeeWindow.txtID.getText();
                dateOfBirth = covertDate(employeeWindow.jDate);
                gender = employeeWindow.cmbGender.getSelectedItem().toString();
                numberPhone = employeeWindow.txtNumberPhone.getText();
                employee = new Employee(name, ID, dateOfBirth, gender, numberPhone, userName, "");
                employee.setAccesKey(password);
                JOptionPane.showMessageDialog(null, "Su codigo de acceso es : " + password);
                //registry = new Registry("Employee");
                //registry.register(employee);
                this.employeeWindow.setVisible(false);
                LoginAdministrator loginAdministrator = new LoginAdministrator();
                Authentication authentication = new Authentication("Employee");
                LoginAdminController loginAdminController;
                loginAdminController = new LoginAdminController(loginAdministrator, authentication);
            }

        }

        if (ae.getSource() == employeeWindow.btnBack) {
            PrincipalWindow loginWindow = new PrincipalWindow();
            LoginController loginController;
            this.employeeWindow.setVisible(false);
            Authentication authentication = new Authentication("Customers");
            
            loginController = new LoginController(loginWindow, authentication);
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

    public String generateCode() {

        String code = "";
        int number;
        char character;
        for (int i = 0; i < 7; i++) {
            number = (int) (Math.random() * (91 - 65)) + 65;
            character = (char) number;
            code += character;
        }
        return code;

    }

}
