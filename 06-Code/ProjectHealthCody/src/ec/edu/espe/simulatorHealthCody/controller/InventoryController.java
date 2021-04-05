/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorHealthCody.controller;

import com.google.gson.Gson;
import ec.edu.espe.simulatorHealthCody.model.Product;
import ec.edu.espe.simulatorHealthCody.utils.NosqlDBManager;
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
    NosqlDBManager db;
    Gson gson;

    public InventoryController(InventoryWindow inventoryWindow, Product product) {
        this.inventoryWindow = inventoryWindow;
        this.product = product;
        db = new NosqlDBManager("Inventory", "Products");
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
            status = db.verifyExistingData(dataToFind);
            if (status == true) {
                String recovered;
                recovered = db.find(dataToFind);
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
        status = db.verifyExistingData(data);
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
            status = db.update(dataTofind, dataToupdate);
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
            status = db.delete(dataTodelete);
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

    /* @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == inventoryWindow.btnAddProduct) {
            AddProductWindow addProductWindow;
            addProductWindow = new AddProductWindow();
            AddProductController addProductController;
            this.inventoryWindow.setVisible(false);
            addProductController = new AddProductController(addProductWindow, this.product);
        }
        if (e.getSource() == inventoryWindow.btnAccept) {
            if (inventoryWindow.txtProduct.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Dato no ingresado");
            } else {
                if (inventoryWindow.rdbSearch.isSelected() == true) {
                    String dataToFind = inventoryWindow.txtProduct.getText();
                    System.out.println(dataToFind);
                    String recovered = this.product.findProduct(dataToFind);
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

                    String recovered = this.product.findProduct(dataToModify);
                    if (recovered.equals("")) {
                        JOptionPane.showMessageDialog(null, "No se ha encontrado dato");
                    } else {
                        this.product.updateProduct(dataToModify, dataToUpdate, "name");
                        JOptionPane.showMessageDialog(null, "Dato modificado con éxito");
                    }

                }
                if (inventoryWindow.rdbDelete.isSelected() == true) {
                    String dataTodeleted = inventoryWindow.txtProduct.getText();

                    String recovered = this.product.findProduct(dataTodeleted);
                    if (recovered.equals("")) {
                        JOptionPane.showMessageDialog(null, "No se ha encontrado dato");
                    } else {
                        this.product.deleteProduct(dataTodeleted, "code");
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
            tableInventaryController = new TableInventaryController(tableInventoryWindow, this.product);
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

    @Ove*/
}
