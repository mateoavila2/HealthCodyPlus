/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorHealthCody.controller;

import ec.edu.espe.simulatorHealthCody.view.EmployeeMenu;
import ec.edu.espe.simulatorHealthCody.view.InventoryWindow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Rafa
 */
public class EmployeeMenuControl implements ActionListener {

    EmployeeMenu employeeMenu;
    
    public EmployeeMenuControl(EmployeeMenu employeeMenu) {
        this.employeeMenu = employeeMenu;
        this.employeeMenu.setLocationRelativeTo(null);
        this.employeeMenu.setVisible(true);
        employeeMenu.btnInventory1.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == employeeMenu.btnInventory1) {
            this.employeeMenu.setVisible(false);
            InventoryWindow inventoryWindow;
            InventoryController inventoryController;
            inventoryWindow = new InventoryWindow();
            inventoryController = new InventoryController(inventoryWindow);
            
        }
        
        
        
        
    }
    
}
