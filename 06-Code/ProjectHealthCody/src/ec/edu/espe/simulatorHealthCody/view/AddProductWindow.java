/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorHealthCody.view;

import ec.edu.espe.simulatorHealthCody.model.Inventory;
import ec.edu.espe.simulatorHealthCody.model.Product;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author Mateo Ávila ESPE
 */
public class AddProductWindow extends javax.swing.JFrame {

    /**
     * Creates new form AddProductWindow
     */
    public AddProductWindow() {
        initComponents();
        this.setLocationRelativeTo(null);
        SpinnerNumberModel modelSpinner = new SpinnerNumberModel();
        modelSpinner.setMaximum(100);
        modelSpinner.setMinimum(0);
        spnQuantity.setModel(modelSpinner);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblCode = new javax.swing.JLabel();
        lblPrice = new javax.swing.JLabel();
        lblQuantity = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtCode = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        spnQuantity = new javax.swing.JSpinner();
        btnReturn = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Apple SD Gothic Neo", 1, 48)); // NOI18N
        jLabel1.setText("Agregar nuevo producto");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(220, 60, 580, 90);

        lblName.setText("Nombre del producto:");
        jPanel2.add(lblName);
        lblName.setBounds(180, 190, 160, 16);

        lblCode.setText("Código del producto:");
        jPanel2.add(lblCode);
        lblCode.setBounds(180, 240, 119, 16);

        lblPrice.setText("Precio del producto:");
        jPanel2.add(lblPrice);
        lblPrice.setBounds(180, 290, 115, 16);

        lblQuantity.setText("Cantidad del producto:");
        jPanel2.add(lblQuantity);
        lblQuantity.setBounds(330, 350, 130, 16);

        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });
        jPanel2.add(txtName);
        txtName.setBounds(330, 186, 380, 30);
        jPanel2.add(txtCode);
        txtCode.setBounds(330, 236, 380, 30);
        jPanel2.add(txtPrice);
        txtPrice.setBounds(330, 286, 380, 30);
        jPanel2.add(spnQuantity);
        spnQuantity.setBounds(490, 350, 60, 22);

        btnReturn.setText("Regresar");
        btnReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnActionPerformed(evt);
            }
        });
        jPanel2.add(btnReturn);
        btnReturn.setBounds(470, 430, 160, 60);

        btnAdd.setText("Agregar");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jPanel2.add(btnAdd);
        btnAdd.setBounds(290, 430, 160, 60);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/espe/simulatorHealthCody/images/SecundaryMenuIMG.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(0, 0, 980, 550);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 976, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        String code = txtCode.getText();
        String name = txtName.getText();
        int quantitys = Integer.parseInt(spnQuantity.getValue().toString());
        if (code.equals("") || name.equals("") || txtPrice.getText().equals("") || (quantitys <= 0 || quantitys > 100)) {
            JOptionPane.showMessageDialog(null, "No se han registrado todos los datos");
        } else {
            try {
                double price = Double.parseDouble(txtPrice.getText());
                if (price <= 0) {
                    JOptionPane.showMessageDialog(null, "Dato de precio no válido");
                    txtPrice.setText(null);
                    txtPrice.getAction();
                } else {
                    Product product = new Product(name, code, price, quantitys);
                    Inventory inventory = new Inventory("Products");
                    inventory.saveProduct(product);
                    JOptionPane.showMessageDialog(null, "Producto registrado con éxito");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Dato de precio no válido");
                txtPrice.setText(null);
                txtPrice.getAction();
            }
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturnActionPerformed
        // TODO add your handling code here:
        InventoryWindow inventoryWindow = new InventoryWindow();
        this.setVisible(false);
        inventoryWindow.setLocationRelativeTo(null);
        inventoryWindow.setVisible(true);
    }//GEN-LAST:event_btnReturnActionPerformed

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

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
            java.util.logging.Logger.getLogger(AddProductWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddProductWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddProductWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddProductWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddProductWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAdd;
    public javax.swing.JButton btnReturn;
    private javax.swing.JComboBox<String> jComboBox1;
    public javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JLabel lblCode;
    public javax.swing.JLabel lblName;
    public javax.swing.JLabel lblPrice;
    public javax.swing.JLabel lblQuantity;
    public javax.swing.JSpinner spnQuantity;
    public javax.swing.JTextField txtCode;
    public javax.swing.JTextField txtName;
    public javax.swing.JTextField txtPrice;
    // End of variables declaration//GEN-END:variables
}
