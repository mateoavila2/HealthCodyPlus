/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorHealthCody.view;

import com.google.gson.Gson;
import ec.edu.espe.simulatorHealthCody.model.Appointment;
import ec.edu.espe.simulatorHealthCody.model.Inventory;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Kenneth Andrade ESPE-DCCO
 */
public class TableDateWindow extends javax.swing.JFrame {

    /**
     * Creates new form TableDateWindow
     */
    public TableDateWindow() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDates = new javax.swing.JTable();
        lblDates = new javax.swing.JLabel();
        btnDates = new javax.swing.JButton();
        btnReturn = new javax.swing.JButton();
        btnPrint = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        tblDates.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "                                           FECHAS"
            }
        ));
        jScrollPane1.setViewportView(tblDates);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(140, 90, 410, 90);

        lblDates.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblDates.setText("FECHAS DE CITAS");
        jPanel1.add(lblDates);
        lblDates.setBounds(260, 30, 240, 29);

        btnDates.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnDates.setText("Ver Citas");
        btnDates.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatesActionPerformed(evt);
            }
        });
        jPanel1.add(btnDates);
        btnDates.setBounds(70, 240, 150, 40);

        btnReturn.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnReturn.setText("Regresar");
        jPanel1.add(btnReturn);
        btnReturn.setBounds(290, 240, 170, 40);

        btnPrint.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnPrint.setText("Imprimir");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });
        jPanel1.add(btnPrint);
        btnPrint.setBounds(530, 240, 150, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/espe/simulatorHealthCody/images/SecundaryMenuIMG.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 740, 300);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 742, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDatesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatesActionPerformed
        // TODO add your handling code here:

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

            tblDates.setModel(new javax.swing.table.DefaultTableModel(
                    matrix,
                    new String[]{
                        "                                           FECHAS"
                    }
            ));
        } catch (Exception bd) {
            JOptionPane.showMessageDialog(null, "NO SE ENCONTRARON FECHAS");
        } finally {
            tblDates.setVisible(true);
            btnPrint.setVisible(true);
        }
    }//GEN-LAST:event_btnDatesActionPerformed

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        // TODO add your handling code here:
        try {
            tblDates.print();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se puede imprimir el inventario total");
        }
    }//GEN-LAST:event_btnPrintActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TableDateWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TableDateWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TableDateWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TableDateWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TableDateWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnDates;
    public javax.swing.JButton btnPrint;
    public javax.swing.JButton btnReturn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel lblDates;
    public javax.swing.JTable tblDates;
    // End of variables declaration//GEN-END:variables
}
