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
                    employeeWindow.pnlAccess.setVisible(true);
                } else if (option == 1) {
                    //emptyFields();
                }
            }
        }

        if (ae.getSource() == employeeWindow.btnFinish) {
            Employee employee;
            Registry registry;
            registry = new Registry("dd");
            String userName = "", password = "";
            userName = employeeWindow.txtUsername.getText();
            if (employeeWindow.txtUsername.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Nombre de usuario vacio, Complete");
            } else {
                String name,ID,dateOfBirth,gender,numberPhone;
                name = employeeWindow.txtName.getText();
                ID = employeeWindow.txtID.getText();
                dateOfBirth = covertDate(employeeWindow.jDate);
                gender = employeeWindow.cmbGender.getSelectedItem().toString();
                numberPhone = employeeWindow.txtNumberPhone.getText();
                employee = new Employee(name,ID,dateOfBirth,gender,numberPhone,userName,password);
                password = employee.generateCode();
                employee.setAccesKey(password);
                employeeWindow.lblCode.setText(password);
                employeeWindow.lblCode.setVisible(true);
                registry = new Registry("Employee");
                registry.register(employee);
            }

        }
        
        if(ae.getSource() == employeeWindow.btnBack){
            PrincipalWindow loginWindow = new PrincipalWindow();
            Authentication authentication = new Authentication("Customers");
            this.employeeWindow.setVisible(false);
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
