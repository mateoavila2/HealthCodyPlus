/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorHealthCody.controller;

import com.google.gson.Gson;
import ec.edu.espe.simulatorHealthCody.model.Iva;
import ec.edu.espe.simulatorHealthCody.model.Product;
import ec.edu.espe.simulatorHealthCody.utils.MongoDBManager;
import ec.edu.espe.simulatorHealthCody.view.AddProductWindow;
import ec.edu.espe.simulatorHealthCody.view.InventoryWindow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author Kenneth Andrade ESPE-DCCO
 */
public class AddProductController {

    AddProductWindow addProductWindows;
    Product product;
    MongoDBManager db;
    Gson gson;

    public AddProductController(AddProductWindow addProductWindow, Product product) {
        this.addProductWindows = addProductWindow;
        this.product = product;
        db = new MongoDBManager();
        gson = new Gson();
    }

    public void show() {
        this.addProductWindows.setLocationRelativeTo(null);
        this.addProductWindows.setVisible(true);
    }

    public void hide() {
        this.addProductWindows.setVisible(false);
    }

    public void saveProduct() {
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
                    
                    String jsonProduct;
                    
                    db.openConnection("Inventory");

                    IvaController ivaController = new IvaController();
                    double price2 = ivaController.calculate(Float.parseFloat(String.valueOf(price)));
                    //JOptionPane.showMessageDialog(null, "El valor con iva es de: " + price2);
                    price = price2;
                    

                    Product product = new Product(name, code, price, quantitys);
                    jsonProduct = gson.toJson(product);
                    price = Math.round(price*100.0)/100.0;
                    boolean status = db.save(jsonProduct, "Products");
                    JOptionPane.showMessageDialog(null, "El valor con iva es de: " + price);
                    JOptionPane.showMessageDialog(null, "Producto registrado con éxito");
                    
                }

            } catch (Exception b) {
                JOptionPane.showMessageDialog(null, "Dato de precio no válido");
                addProductWindows.txtPrice.setText(null);
                addProductWindows.txtPrice.getAction();
            }
        }

    }

    public void back() {
        hide();
        InventoryWindow inventoryWindow;
        InventoryController inventoryController;
        inventoryWindow = new InventoryWindow();
        inventoryController = new InventoryController(inventoryWindow, product);
        inventoryController.show();

    }
}
