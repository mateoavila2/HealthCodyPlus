/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorHealthCody.controller;

import ec.edu.espe.simulatorHealthCody.view.CustomerMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Rafa
 */
public class CustomerMenuControl implements ActionListener{
    CustomerMenu customerMenu;

    public CustomerMenuControl(CustomerMenu customerMenu) {
        this.customerMenu = customerMenu;
        this.customerMenu.setLocationRelativeTo(null);
        this.customerMenu.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        //if(ae.getSource() == customerMenu)
    }
    
    
    
    
}
