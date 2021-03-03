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

    public InventoryController(InventoryWindow inventoryWindow, Inventory inventory) {
        this.inventoryWindow = inventoryWindow;
        this.inventory = inventory;
        this.inventoryWindow.setLocationRelativeTo(null);
        this.inventoryWindow.setVisible(true);
        this.inventoryWindow.btnAddProduct.addActionListener(this);
        this.inventoryWindow.btnAccept.addActionListener(this);
        this.inventoryWindow.btnReturn.addActionListener(this);
        this.inventoryWindow.btnViewInventory.addActionListener(this);
        this.inventoryWindow.rdbSearch.addActionListener(this);
        this.inventoryWindow.rdbModific.addActionListener(this);
        this.inventoryWindow.rdbDelete.addActionListener(this);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == inventoryWindow.btnAddProduct) {
            AddProductWindow addProductWindow;
            addProductWindow = new AddProductWindow();
            AddProductController addProductController;
            this.inventoryWindow.setVisible(false);
            addProductController = new AddProductController(addProductWindow, this.inventory);
        }
        if (e.getSource() == inventoryWindow.btnAccept) {
            if (inventoryWindow.txtProduct.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Dato no ingresado");
            } else {
                if (inventoryWindow.rdbSearch.isSelected() == true) {
                    String dataToFind = inventoryWindow.txtProduct.getText();
                    System.out.println(dataToFind);
                    String recovered = this.inventory.findProduct(dataToFind);
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


                    String recovered = this.inventory.findProduct(dataToModify);
                    if (recovered.equals("")) {
                        JOptionPane.showMessageDialog(null, "No se ha encontrado dato");
                    } else {
                        this.inventory.updateProduct(dataToModify, dataToUpdate, "name");
                        JOptionPane.showMessageDialog(null, "Dato modificado con éxito");
                    }

                }
                if (inventoryWindow.rdbDelete.isSelected() == true) {
                    String dataTodeleted = inventoryWindow.txtProduct.getText();

                    String recovered = this.inventory.findProduct(dataTodeleted);
                    if (recovered.equals("")) {
                        JOptionPane.showMessageDialog(null, "No se ha encontrado dato");
                    } else {
                        this.inventory.deleteProduct(dataTodeleted, "code");
                        JOptionPane.showMessageDialog(null, "Dato eliminado con éxito");
                    }
                }
            }
        }
        if (e.getSource() == inventoryWindow.btnReturn) {
            EmployeeMenu employeeMenu = new EmployeeMenu();
            EmployeeMenuControl employeeMenuControl;
            employeeMenu = new EmployeeMenu();
            this.inventoryWindow.setVisible(false);
            employeeMenuControl = new EmployeeMenuControl(employeeMenu);
        }
        if (e.getSource() == inventoryWindow.btnViewInventory) {

            TableInventoryWindow tableInventoryWindow;
            TableInventaryController tableInventaryController;
            tableInventoryWindow = new TableInventoryWindow();
            this.inventoryWindow.setVisible(false);
            tableInventaryController = new TableInventaryController(tableInventoryWindow,this.inventory);
        }
        if (e.getSource() == inventoryWindow.rdbSearch) {
            inventoryWindow.txtProduct.setText(null);
            inventoryWindow.txtProduct.getAction();
            inventoryWindow.txtProduct.setVisible(true);
            inventoryWindow.btnAccept.setVisible(true);
            inventoryWindow.lblModificD.setVisible(false);
        }
        if (e.getSource() == inventoryWindow.rdbModific) {
            inventoryWindow.txtProduct.setText(null);
            inventoryWindow.txtProduct.getAction();
            inventoryWindow.txtProduct.setVisible(true);
            inventoryWindow.btnAccept.setVisible(true);
            inventoryWindow.lblModificD.setText("Dato a modificar");
            inventoryWindow.lblModificD.setVisible(true);
        }
        if (e.getSource() == inventoryWindow.rdbDelete) {
            inventoryWindow.txtProduct.setText(null);
            inventoryWindow.txtProduct.getAction();
            inventoryWindow.txtProduct.setVisible(true);
            inventoryWindow.btnAccept.setVisible(true);
            inventoryWindow.lblModificD.setText("Código del producto");
            inventoryWindow.lblModificD.setVisible(true);
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
