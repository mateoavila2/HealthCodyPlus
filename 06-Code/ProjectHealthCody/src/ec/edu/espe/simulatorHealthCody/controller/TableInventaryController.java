/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorHealthCody.controller;

import com.google.gson.Gson;
import ec.edu.espe.simulatorHealthCody.model.Inventory;
import ec.edu.espe.simulatorHealthCody.model.Product;
import ec.edu.espe.simulatorHealthCody.view.TableInventoryWindow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Kenneth Andrade ESPE-DCCO
 */
public class TableInventaryController implements ActionListener, MouseListener {

    TableInventoryWindow tableInventoryWindow;
    Inventory inventory;

    public TableInventaryController(TableInventoryWindow tableInventoryWindow) {
        this.tableInventoryWindow = tableInventoryWindow;
        this.tableInventoryWindow.setLocationRelativeTo(null);
        this.tableInventoryWindow.setVisible(true);
        inventory = new Inventory("Products");
        tableInventoryWindow.btnInventary.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == tableInventoryWindow.btnInventary) {
            Gson gson = new Gson();
            ArrayList<String[]> data = new ArrayList<String[]>();

            String[] recovered = inventory.showProducts().split("\r\n");
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
        if (e.getSource() == tableInventoryWindow.btnPrint) {
            try {
                tableInventoryWindow.tblInventory.print();
            } catch (Exception b) {
                JOptionPane.showMessageDialog(null, "No se puede imprimir el inventario total");
            }
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
