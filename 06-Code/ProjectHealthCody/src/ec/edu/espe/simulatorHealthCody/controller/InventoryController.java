/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorHealthCody.controller;

import com.google.gson.Gson;
import ec.edu.espe.simulatorHealthCody.model.Inventory;
import ec.edu.espe.simulatorHealthCody.model.Product;
import ec.edu.espe.simulatorHealthCody.view.AddProductWindow;
import ec.edu.espe.simulatorHealthCody.view.EmployeeMenu;
import ec.edu.espe.simulatorHealthCody.view.InventoryWindow;
import ec.edu.espe.simulatorHealthCody.view.TableInventoryWindow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Kenneth Andrade ESPE-DCCO
 */
public class InventoryController implements ActionListener, MouseListener {

    InventoryWindow inventoryWindow;
    Inventory inventory;
    public InventoryController(InventoryWindow inventoryWindow) {
        this.inventoryWindow = inventoryWindow;
        this.inventoryWindow.setLocationRelativeTo(null);
        this.inventoryWindow.setVisible(true);
        inventory = new Inventory("Products");
        inventoryWindow.btnAddProduct.addActionListener(this);
        inventoryWindow.btnAccept.addActionListener(this);
        inventoryWindow.btnReturn.addActionListener(this);
        inventoryWindow.btnViewInventory.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == inventoryWindow.btnAddProduct) {
            AddProductWindow addProductWindow = new AddProductWindow();
            
        }
        if (e.getSource() == inventoryWindow.btnAccept) {
            if (inventoryWindow.txtProduct.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Dato no ingresado");
            } else {
                if (inventoryWindow.rdbSearch.isSelected() == true) {
                    String dataToFind = inventoryWindow.txtProduct.getText();
                    System.out.println(dataToFind);
                    String recovered = inventory.findProduct(dataToFind);
                    if (recovered.equals("")) {
                        JOptionPane.showMessageDialog(null, "No se ha encontrado dato");
                    } else {
                        Gson gson = new Gson();
                        Product product = gson.fromJson(recovered, Product.class);
                        JOptionPane.showMessageDialog(null, product.toString());
                    }
                }
                if (inventoryWindow.rdbModific.isSelected() == true) {
                    String dataToModify = inventoryWindow.txtProduct.getText();
                    String dataToUpdate = JOptionPane.showInputDialog("Ingrese el nuevo dato");

                    Inventory inventory = new Inventory("Products");
                    String recovered = inventory.findProduct(dataToModify);
                    if (recovered.equals("")) {
                        JOptionPane.showMessageDialog(null, "No se ha encontrado dato");
                    } else {
                        inventory.updateProduct(dataToModify, dataToUpdate, "name");
                        JOptionPane.showMessageDialog(null, "Dato modificado con éxito");
                    }

                }
                if (inventoryWindow.rdbDelete.isSelected() == true) {
                    String dataTodeleted = inventoryWindow.txtProduct.getText();
                    Inventory inventory = new Inventory("Products");

                    String recovered = inventory.findProduct(dataTodeleted);
                    if (recovered.equals("")) {
                        JOptionPane.showMessageDialog(null, "No se ha encontrado dato");
                    } else {
                        inventory.deleteProduct(dataTodeleted, "code");
                        JOptionPane.showMessageDialog(null, "Dato eliminado con éxito");
                    }
                }
            }
        }
        if (e.getSource() == inventoryWindow.btnReturn) {
            EmployeeMenu employeeMenu = new EmployeeMenu();
            this.inventoryWindow.setVisible(false);
            inventoryWindow.setLocationRelativeTo(null);
            inventoryWindow.setVisible(true);
        }
        if(e.getSource()==inventoryWindow.btnViewInventory)
        {
            this.inventoryWindow.setVisible(false);
            TableInventoryWindow tableInventoryWindow;
            TableInventaryController tableInventaryController;
            tableInventoryWindow = new TableInventoryWindow();
            tableInventaryController = new TableInventaryController(tableInventoryWindow);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
