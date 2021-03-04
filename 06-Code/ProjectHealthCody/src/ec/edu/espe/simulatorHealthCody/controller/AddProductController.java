/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorHealthCody.controller;

import ec.edu.espe.simulatorHealthCody.model.Inventory;
import ec.edu.espe.simulatorHealthCody.model.Product;
import ec.edu.espe.simulatorHealthCody.view.AddProductWindow;
import ec.edu.espe.simulatorHealthCody.view.InventoryWindow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Kenneth Andrade ESPE-DCCO
 */
public class AddProductController implements ActionListener, MouseListener {

    AddProductWindow addProductWindows;
    Inventory inventory;
    public AddProductController(AddProductWindow addProductWindow,Inventory inventory) {
        this.addProductWindows = addProductWindow;
        this.addProductWindows.setLocationRelativeTo(null);
        this.addProductWindows.setVisible(true);
        this.inventory = inventory;
        addProductWindows.btnAdd.addActionListener(this);
        addProductWindows.btnReturn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addProductWindows.btnAdd) {
            String code = addProductWindows.txtCode.getText();
            String name = addProductWindows.txtName.getText();
            int quantitys = Integer.parseInt(addProductWindows.spnQuantity.getValue().toString());
            if (code.equals("") || name.equals("") || addProductWindows.txtPrice.getText().equals("") || (quantitys <= 0 || quantitys > 100)) {
                JOptionPane.showMessageDialog(null, "No se han registrado todos los datos");
            } else {
                try {
                    double price = Double.parseDouble(addProductWindows.txtPrice.getText());
                    if (price <= 0) {
                        JOptionPane.showMessageDialog(null, "Dato de precio no válido");
                        addProductWindows.txtPrice.setText(null);
                        addProductWindows.txtPrice.getAction();
                    } else {
                        Product product = new Product(name, code, price, quantitys);
                        inventory.saveProduct(product);
                        JOptionPane.showMessageDialog(null, "Producto registrado con éxito");
                    }
                } catch (Exception b) {
                    JOptionPane.showMessageDialog(null, "Dato de precio no válido");
                    addProductWindows.txtPrice.setText(null);
                    addProductWindows.txtPrice.getAction();
                }
            }
        }
        if (e.getSource() == addProductWindows.btnReturn) {
            InventoryWindow inventoryWindow;
            InventoryController inventoryController;
            inventoryWindow = new InventoryWindow();
            this.addProductWindows.setVisible(false);
            inventoryController = new InventoryController(inventoryWindow, this.inventory);
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
