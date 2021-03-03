/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorHealthCody.controller;

import com.google.gson.Gson;
import ec.edu.espe.simulatorHealthCody.model.Appointment;
import ec.edu.espe.simulatorHealthCody.model.Inventory;
import ec.edu.espe.simulatorHealthCody.view.TableDateWindow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Kenneth Andrade ESPE-DCCO
 */
public class TableDateController implements ActionListener, MouseListener {

    TableDateWindow tableDateWindow;

    public TableDateController(TableDateWindow tableDateWindow) {
        this.tableDateWindow = tableDateWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == tableDateWindow.btnDates) {
            Gson gson = new Gson();
            ArrayList<String[]> data = new ArrayList<String[]>();

            Appointment appointment = new Appointment("Scheduled appointments");
            List<Date> dates;
            try {
                dates = appointment.show();
                String matrix[][] = new String[dates.size()][4];
                for (int i = 0; i < dates.size(); i++) {
                    matrix[i][0] = String.valueOf(dates.get(i));
                }

                tableDateWindow.tblDates.setModel(new javax.swing.table.DefaultTableModel(
                        matrix,
                        new String[]{
                            "                                           FECHAS"
                        }
                ));
            } catch (Exception bd) {
                JOptionPane.showMessageDialog(null, "NO SE ENCONTRARON FECHAS");
            } finally {
                tableDateWindow.tblDates.setVisible(true);
                tableDateWindow.btnPrint.setVisible(true);
            }
        }
        if (e.getSource() == tableDateWindow.btnPrint) {
            try {
                tableDateWindow.tblDates.print();
            } catch (Exception b) {
                JOptionPane.showMessageDialog(null, "No se puede imprimir el inventario total");
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e
    ) {
    }

    @Override
    public void mousePressed(MouseEvent e
    ) {
    }

    @Override
    public void mouseReleased(MouseEvent e
    ) {
    }

    @Override
    public void mouseEntered(MouseEvent e
    ) {
    }

    @Override
    public void mouseExited(MouseEvent e
    ) {
    }

}
