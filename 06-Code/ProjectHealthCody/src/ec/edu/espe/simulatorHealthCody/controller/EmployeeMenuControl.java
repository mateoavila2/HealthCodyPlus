/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorHealthCody.controller;

import ec.edu.espe.simulatorHealthCody.model.Inventory;
import ec.edu.espe.simulatorHealthCody.view.EmployeeMenu;
import ec.edu.espe.simulatorHealthCody.view.InventoryWindow;
import ec.edu.espe.simulatorHealthCody.view.LoginCustomer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.registry.Registry;

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
        this.employeeMenu.btnInventory1.addActionListener(this);
        this.employeeMenu.btnReturn.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == employeeMenu.btnInventory1) {
            InventoryWindow inventoryWindow;
            InventoryController inventoryController;
            inventoryWindow = new InventoryWindow();
            this.employeeMenu.setVisible(false);
            Inventory inventory = new Inventory("Products");
            inventoryController = new InventoryController(inventoryWindow,inventory);
            
        }
        
        if(ae.getSource() == employeeMenu.btnReturn){
            this.employeeMenu.setVisible(false);
            LoginCustomer loginCustomer = new LoginCustomer();
            LoginCustomerController loginCustomerController = new LoginCustomerController(loginCustomer);
        }
        
        
        
        
    }
    
}
