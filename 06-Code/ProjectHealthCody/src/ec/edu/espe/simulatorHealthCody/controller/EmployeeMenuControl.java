/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorHealthCody.controller;

import ec.edu.espe.simulatorHealthCody.model.Product;
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
public class EmployeeMenuControl{

    EmployeeMenu employeeMenu;

    public EmployeeMenuControl(EmployeeMenu employeeMenu) {
        this.employeeMenu = employeeMenu;

    }

    public void show() {
        this.employeeMenu.setLocationRelativeTo(null);
        this.employeeMenu.setVisible(true);
    }

    public void hide() {
        this.employeeMenu.setVisible(false);
    }

    public void nextInventoryWindow() {
        hide();
        Product product = new Product();
        InventoryWindow inventoryWindow = new InventoryWindow();;
        InventoryController inventoryController;
        inventoryController = new InventoryController(inventoryWindow, product);
        inventoryController.show();

    }

    public void back() {
        hide();
        LoginCustomer loginCustomer = new LoginCustomer();
        LoginCustomerController loginCustomerController = new LoginCustomerController(loginCustomer);
        loginCustomerController.show();

    }

}
