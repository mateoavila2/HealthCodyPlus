/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorHealthCody.view;
import ec.edu.espe.simulatorHealthCody.controller.RCustomerController;
import ec.edu.espe.simulatorHealthCody.model.Customer;


/**
 *
 * @author Mateo Ávila ESPE
 */
public class RCustomer extends javax.swing.JFrame {
    Customer customer = new Customer();
    RCustomerController controller = new RCustomerController(this, customer);
    
    /**
     * Creates new form RegistryCustomerWindow
     */
    public RCustomer() {
        initComponents();
        this.setLocationRelativeTo(null);
        lblMessage.setVisible(false);
        lblUserName.setEnabled(false);
        txtUserName.setEnabled(false);
        lblPassword.setEnabled(false);
        txtPassword.setEnabled(false);
        btnFinish.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        txtName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblID = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        lblBirthday = new javax.swing.JLabel();
        btnConfirm = new javax.swing.JButton();
        lblGender = new javax.swing.JLabel();
        jDate = new com.toedter.calendar.JDateChooser();
        cmbGender = new javax.swing.JComboBox<>();
        txtID = new javax.swing.JTextField();
        lblPassword = new javax.swing.JLabel();
        lblUserName = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        lblMessage = new javax.swing.JLabel();
        btnFinish = new javax.swing.JButton();
        txtPassword = new javax.swing.JPasswordField();
        lblimage = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);
        jPanel1.add(txtName);
        txtName.setBounds(20, 80, 300, 30);

        jLabel2.setFont(new java.awt.Font("Apple SD Gothic Neo", 1, 24)); // NOI18N
        jLabel2.setText("Registro de usuario");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(70, 10, 230, 32);

        lblName.setText("Nombres y Apellidos:");
        jPanel1.add(lblName);
        lblName.setBounds(20, 60, 150, 16);

        lblID.setText("Cédula o pasaporte:");
        jPanel1.add(lblID);
        lblID.setBounds(20, 120, 130, 16);

        btnBack.setText("Regresar");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        jPanel1.add(btnBack);
        btnBack.setBounds(20, 500, 90, 32);

        lblBirthday.setText("Fecha de nacimiento: ");
        jPanel1.add(lblBirthday);
        lblBirthday.setBounds(20, 240, 130, 16);

        btnConfirm.setText("Confirmar");
        btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });
        jPanel1.add(btnConfirm);
        btnConfirm.setBounds(130, 290, 90, 32);

        lblGender.setText("Género:");
        jPanel1.add(lblGender);
        lblGender.setBounds(20, 190, 60, 16);
        jPanel1.add(jDate);
        jDate.setBounds(150, 240, 170, 29);

        cmbGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Femenino", "Otros" }));
        jPanel1.add(cmbGender);
        cmbGender.setBounds(80, 190, 200, 26);
        jPanel1.add(txtID);
        txtID.setBounds(20, 140, 300, 30);

        lblPassword.setText("Contraseña:");
        jPanel1.add(lblPassword);
        lblPassword.setBounds(20, 410, 80, 16);

        lblUserName.setText("Nombre de usuario:");
        jPanel1.add(lblUserName);
        lblUserName.setBounds(20, 360, 120, 16);
        jPanel1.add(txtUserName);
        txtUserName.setBounds(20, 380, 230, 24);

        lblMessage.setForeground(new java.awt.Color(255, 0, 0));
        lblMessage.setText("Cree un usuario y una contraseña");
        jPanel1.add(lblMessage);
        lblMessage.setBounds(20, 340, 200, 16);

        btnFinish.setText("Finalizar");
        btnFinish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinishActionPerformed(evt);
            }
        });
        jPanel1.add(btnFinish);
        btnFinish.setBounds(270, 500, 90, 32);
        jPanel1.add(txtPassword);
        txtPassword.setBounds(20, 430, 230, 22);

        lblimage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/espe/simulatorHealthCody/images/RegisterIMG.png"))); // NOI18N
        lblimage.setText("jLabel1");
        jPanel1.add(lblimage);
        lblimage.setBounds(0, 0, 380, 550);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed

        customer.setName(txtName.getText());
        customer.setId(txtID.getText());
        controller.confirmData();
        
    }//GEN-LAST:event_btnConfirmActionPerformed

    private void btnFinishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinishActionPerformed
        boolean status;
        customer.setUserName(txtUserName.getText());
        customer.setAccesKey(txtPassword.getText());
        status = controller.finish();
        if(status == true){
            controller.registerCustomer();
        }
        
    }//GEN-LAST:event_btnFinishActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        controller.back();
    }//GEN-LAST:event_btnBackActionPerformed

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
            java.util.logging.Logger.getLogger(RCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RCustomer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnBack;
    public javax.swing.JButton btnConfirm;
    public javax.swing.JButton btnFinish;
    public javax.swing.JComboBox<String> cmbGender;
    private javax.swing.JButton jButton1;
    public com.toedter.calendar.JDateChooser jDate;
    public javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JLabel lblBirthday;
    public javax.swing.JLabel lblGender;
    public javax.swing.JLabel lblID;
    public javax.swing.JLabel lblMessage;
    public javax.swing.JLabel lblName;
    public javax.swing.JLabel lblPassword;
    public javax.swing.JLabel lblUserName;
    private javax.swing.JLabel lblimage;
    public javax.swing.JTextField txtID;
    public javax.swing.JTextField txtName;
    public javax.swing.JPasswordField txtPassword;
    public javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}
