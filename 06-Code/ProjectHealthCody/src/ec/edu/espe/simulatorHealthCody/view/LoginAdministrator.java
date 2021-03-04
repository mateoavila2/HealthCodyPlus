/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorHealthCody.view;

import ec.edu.espe.simulatorHealthCody.model.Authentication;
import javax.swing.JOptionPane;

/**
 *
 * @author Mateo Ávila ESPE
 */
public class LoginAdministrator extends javax.swing.JFrame {

    /**
     * Creates new form LoginAdministrator
     */
    public LoginAdministrator() {
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
        btnReturn = new javax.swing.JButton();
        btnLogin = new javax.swing.JButton();
        txtCode = new javax.swing.JTextField();
        txtUser = new javax.swing.JTextField();
        lblCodeForget = new javax.swing.JLabel();
        lblCode = new javax.swing.JLabel();
        lblUser = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        imgLogin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        btnReturn.setText("Regresar");
        jPanel1.add(btnReturn);
        btnReturn.setBounds(150, 420, 83, 32);

        btnLogin.setText("Login");
        jPanel1.add(btnLogin);
        btnLogin.setBounds(50, 420, 61, 32);
        jPanel1.add(txtCode);
        txtCode.setBounds(60, 310, 300, 24);
        jPanel1.add(txtUser);
        txtUser.setBounds(60, 260, 300, 24);

        lblCodeForget.setText("¿Olvidaste tu usuario o contraseña?");
        jPanel1.add(lblCodeForget);
        lblCodeForget.setBounds(60, 360, 240, 16);

        lblCode.setText("Código:");
        jPanel1.add(lblCode);
        lblCode.setBounds(60, 290, 60, 16);

        lblUser.setText("Usuario:");
        jPanel1.add(lblUser);
        lblUser.setBounds(60, 240, 60, 16);

        jLabel2.setFont(new java.awt.Font("Apple SD Gothic Neo", 1, 36)); // NOI18N
        jLabel2.setText("Ingreso para administradores");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(60, 150, 500, 80);

        imgLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/espe/simulatorHealthCody/images/LoginAdministratorIMG.png"))); // NOI18N
        imgLogin.setText("jLabel1");
        jPanel1.add(imgLogin);
        imgLogin.setBounds(0, 0, 940, 480);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 937, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(LoginAdministrator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginAdministrator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginAdministrator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginAdministrator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginAdministrator().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnLogin;
    public javax.swing.JButton btnReturn;
    public javax.swing.JLabel imgLogin;
    public javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JLabel lblCode;
    public javax.swing.JLabel lblCodeForget;
    public javax.swing.JLabel lblUser;
    public javax.swing.JTextField txtCode;
    public javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
