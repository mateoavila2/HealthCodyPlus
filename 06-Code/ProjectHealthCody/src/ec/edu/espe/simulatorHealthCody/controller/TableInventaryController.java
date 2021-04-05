/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorHealthCody.controller;

import com.google.gson.Gson;
import ec.edu.espe.simulatorHealthCody.model.Product;
import ec.edu.espe.simulatorHealthCody.utils.MongoDBManager;
import ec.edu.espe.simulatorHealthCody.view.InventoryWindow;
import ec.edu.espe.simulatorHealthCody.view.TableInventoryWindow;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Kenneth Andrade ESPE-DCCO
 */
public class TableInventaryController {

    TableInventoryWindow tableInventoryWindow;
    Product product;
    MongoDBManager db;
    Gson gson;

    public TableInventaryController(TableInventoryWindow tableInventoryWindow, Product product) {
        this.tableInventoryWindow = tableInventoryWindow;
        this.product = product;
        db = new MongoDBManager();
        db.openConnection("Inventory");
        gson = new Gson();

    }

    public void show() {
        this.tableInventoryWindow.setLocationRelativeTo(null);
        this.tableInventoryWindow.setVisible(true);
    }

    public void hide() {
        this.tableInventoryWindow.setVisible(false);
    }

    public void showtTable() {
        Gson gson = new Gson();
        String jsonProducts;
        jsonProducts = db.read("Products");

        ArrayList<String[]> data = new ArrayList<String[]>();

        String[] recovered = jsonProducts.split("\r\n");
        List<Product> products = new ArrayList<Product>();
        for (int i = 0; i < recovered.length; i++) {
            products.add(gson.fromJson(recovered[i], Product.class));
        }
        //

        String matrix[][] = new String[products.size()][4];
        for (int i = 0; i < products.size(); i++) {
            matrix[i][0] = products.get(i).getNameProduct().toString();
            matrix[i][1] = products.get(i).getCodeProduct().toString();
            matrix[i][2] = String.valueOf(products.get(i).getPriceProduct());
            matrix[i][3] = String.valueOf(products.get(i).getQuantity());
        }
        tableInventoryWindow.tblInventory.setModel(new javax.swing.table.DefaultTableModel(
                matrix,
                new String[]{
                    "Nombre", "Código", "Precio", "Cantidad"
                }
        ) {
            Class[] types = new Class[]{
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
        tableInventoryWindow.tblInventory.setVisible(true);
        tableInventoryWindow.btnPrint.setVisible(true);

    }

    public void print() {
        try {
            tableInventoryWindow.tblInventory.print();
        } catch (Exception b) {
            JOptionPane.showMessageDialog(null, "No se puede imprimir el inventario total");
        }

    }

    public void back() {
        hide();
        InventoryWindow inventoryWindow = new InventoryWindow();
        InventoryController inventoryController;
        inventoryController = new InventoryController(inventoryWindow,product);
        inventoryController.show();
    }
}
