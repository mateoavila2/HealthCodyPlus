/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorHealthCody.controller;

import ec.edu.espe.simulatorHealthCody.model.Inventory;
import ec.edu.espe.simulatorHealthCody.view.EmployeeMenu;
import ec.edu.espe.simulatorHealthCody.view.InventoryWindow;
import ec.edu.espe.simulatorHealthCody.view.LoginAdministrator;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 *
 * @author Rafa
 */
public class EmployeeMenuControl implements ActionListener,MouseListener{
    EmployeeMenu employeeMenu;
    Inventory inventory;

    public EmployeeMenuControl(EmployeeMenu employeeMenu) {
        inventory = new Inventory("Products");
        this.employeeMenu = employeeMenu;
        this.employeeMenu.setLocationRelativeTo(null);
        this.employeeMenu.setVisible(true);
        employeeMenu.btnInventory.addActionListener(this);
        employeeMenu.btnReturn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == employeeMenu.btnInventory){
        InventoryWindow inventoryWindow;
        InventoryController inventoryController;
        inventoryWindow = new InventoryWindow();
        this.employeeMenu.setVisible(false);
        inventoryController = new InventoryController(inventoryWindow);
        }
        
        if(ae.getSource() == employeeMenu.btnReturn){
        
            this.employeeMenu.setVisible(false);
            LoginAdministrator loginAdministrator;
            LoginAdminController loginAdminController;
            loginAdministrator = new LoginAdministrator();
            loginAdminController = new LoginAdminController(loginAdministrator);
        
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
    
    
}
