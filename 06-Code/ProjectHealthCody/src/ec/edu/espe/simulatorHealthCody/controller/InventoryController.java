/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorHealthCody.controller;

import com.google.gson.Gson;
import ec.edu.espe.simulatorHealthCody.model.Product;
import ec.edu.espe.simulatorHealthCody.utils.MongoDBManager;
import ec.edu.espe.simulatorHealthCody.view.AddProductWindow;
import ec.edu.espe.simulatorHealthCody.view.EmployeeMenu;
import ec.edu.espe.simulatorHealthCody.view.InventoryWindow;
import ec.edu.espe.simulatorHealthCody.view.TableInventoryWindow;
import javax.swing.JOptionPane;

/**
 *
 * @author Kenneth Andrade ESPE-DCCO
 */
public class InventoryController {

    InventoryWindow inventoryWindow;
    Product product;
    MongoDBManager db;
    Gson gson;

    public InventoryController(InventoryWindow inventoryWindow, Product product) {
        this.inventoryWindow = inventoryWindow;
        this.product = product;
        db = new MongoDBManager();
        gson = new Gson();

    }

    public void show() {
        this.inventoryWindow.setLocationRelativeTo(null);
        this.inventoryWindow.setVisible(true);
    }

    public void hide() {
        this.inventoryWindow.setVisible(false);
    }

    public void addProduct() {
        hide();
        AddProductWindow addProductWindow = new AddProductWindow();
        AddProductController controller = new AddProductController(addProductWindow, product);
        controller.show();
    }

    public void findProduct(String dataToFind) {
        boolean status;
        if (dataToFind.equals("")) {
            JOptionPane.showMessageDialog(null, "El cuadro de texto esta vacio");
        } else {
            status = db.verifyExistingData(dataToFind,"Products");
            if (status == true) {
                String recovered;
                db.openConnection("Inventory");
                recovered = db.find(dataToFind,"Products");
                product = gson.fromJson(recovered, Product.class);
                JOptionPane.showMessageDialog(null, product.toString());
            } else {
                this.inventoryWindow.txtProduct.setText("");
                JOptionPane.showMessageDialog(null, "El dato ingresado no existe");
            }
        }
    }
    public boolean validateEntry(String data) {
        boolean status;
        status = db.verifyExistingData(data,"Products");
        if (status == true) {
            return true;
        } else {
            return false;
        }
    }
    public void modifyProduct(String dataTofind, String dataToupdate) {

        boolean status;

        if (dataToupdate.equals("")) {
            JOptionPane.showMessageDialog(null, "El cuadro de texto esta vacio");
        } else {
            db.setKeyName("name");
            db.openConnection("Inventory");
            status = db.update(dataTofind, dataToupdate,"Products");
            if (status == true) {
                JOptionPane.showMessageDialog(null, "Atributo modificado");
                this.inventoryWindow.txtProduct.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo modificar el producto");
            }
        }
    }
    public void deleteProduct(String dataTodelete) {
        boolean status;
        if (dataTodelete.equals("")) {
            JOptionPane.showMessageDialog(null, "El cuadro de texto esta vacio");
        } else {
            db.setKeyName("code");
            db.openConnection("Inventory");
            status = db.delete(dataTodelete,"Products");
            if (status == true) {
                JOptionPane.showMessageDialog(null, "Producto eliminado");
                this.inventoryWindow.txtProduct.setText("");
            } else {
                this.inventoryWindow.txtProduct.setText("");
                JOptionPane.showMessageDialog(null, "El codigo ingresado no existe");
            }

        }

    }
    public void showProducts() {
        hide();
        TableInventoryWindow table = new TableInventoryWindow();
        TableInventaryController tableControl = new TableInventaryController(table, product);
        tableControl.show();

    }

    public void back() {
        hide();
        EmployeeMenu employeeMenu = new EmployeeMenu();
        EmployeeMenuControl employeeMenuControl;
        employeeMenu = new EmployeeMenu();
        employeeMenuControl = new EmployeeMenuControl(employeeMenu);
        employeeMenuControl.show();

    }
}
