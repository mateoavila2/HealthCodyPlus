/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorHealthCody.view;

import com.toedter.calendar.JDateChooser;

import ec.edu.espe.simulatorHealthCody.model.Employee;
import ec.edu.espe.simulatorHealthCody.model.Registry;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author Mateo Ávila ESPE
 */
public class EmployeeWindow extends javax.swing.JFrame {

    /**
     * Creates new form RegistryEmployeeWindow
     */
    public EmployeeWindow() {
        initComponents();
        this.setLocationRelativeTo(null);
        lblUsername.setVisible(false);
        txtUsername.setVisible(false);
        btnFinish.setVisible(false);
        lblUserImage.setVisible(false);
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
        jLabel2 = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblID = new javax.swing.JLabel();
        lblBirthDate = new javax.swing.JLabel();
        lblNumberPhone = new javax.swing.JLabel();
        lblGender = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtID = new javax.swing.JTextField();
        txtNumberPhone = new javax.swing.JTextField();
        cmbGender = new javax.swing.JComboBox<>();
        btnSave = new javax.swing.JButton();
        jDate = new com.toedter.calendar.JDateChooser();
        btnBack = new javax.swing.JButton();
        btnFinish = new javax.swing.JButton();
        lblUsername = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        lblUserImage = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Apple SD Gothic Neo", 1, 24)); // NOI18N
        jLabel2.setText("Registro para Administradores");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(50, 50, 370, 32);

        lblName.setText("Nombres y Apellidos:");
        jPanel1.add(lblName);
        lblName.setBounds(50, 110, 170, 16);

        lblID.setText("Cédula o pasaporte:");
        jPanel1.add(lblID);
        lblID.setBounds(50, 170, 113, 16);

        lblBirthDate.setText("Fecha de Nacimiento: ");
        jPanel1.add(lblBirthDate);
        lblBirthDate.setBounds(50, 240, 130, 16);

        lblNumberPhone.setText("Número de contacto:");
        jPanel1.add(lblNumberPhone);
        lblNumberPhone.setBounds(50, 300, 180, 16);

        lblGender.setText("Género:");
        jPanel1.add(lblGender);
        lblGender.setBounds(50, 360, 60, 16);
        jPanel1.add(txtName);
        txtName.setBounds(50, 130, 380, 24);
        jPanel1.add(txtID);
        txtID.setBounds(50, 190, 380, 24);
        jPanel1.add(txtNumberPhone);
        txtNumberPhone.setBounds(50, 320, 210, 24);

        cmbGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Femenino", "Otros" }));
        jPanel1.add(cmbGender);
        cmbGender.setBounds(110, 350, 150, 26);

        btnSave.setText("Guardar");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel1.add(btnSave);
        btnSave.setBounds(350, 350, 76, 32);
        jPanel1.add(jDate);
        jDate.setBounds(190, 230, 190, 29);

        btnBack.setText("Regresar");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        jPanel1.add(btnBack);
        btnBack.setBounds(20, 430, 90, 32);

        btnFinish.setText("Finalizar");
        btnFinish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinishActionPerformed(evt);
            }
        });
        jPanel1.add(btnFinish);
        btnFinish.setBounds(680, 350, 77, 32);

        lblUsername.setForeground(new java.awt.Color(255, 0, 0));
        lblUsername.setText("Cree un nombre de usuario:");
        jPanel1.add(lblUsername);
        lblUsername.setBounds(590, 230, 167, 22);
        jPanel1.add(txtUsername);
        txtUsername.setBounds(570, 260, 185, 24);

        lblUserImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/espe/simulatorHealthCody/images/user.png.png"))); // NOI18N
        lblUserImage.setText("jLabel3");
        jPanel1.add(lblUserImage);
        lblUserImage.setBounds(600, 90, 140, 130);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/espe/simulatorHealthCody/images/RegisterIMG.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(-10, 0, 860, 490);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 860, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        /*int option;

        System.out.println(txtName.getText());
        if ((txtName.getText().equals("")) || (txtID.getText().equals("")) || (txtNumberPhone.getText().equals(""))) {
            JOptionPane.showMessageDialog(null, "Campos vacios, Complete todos los campos");

        } else {
            option = JOptionPane.showConfirmDialog(null, "Confirmar registro ?", "Guardar datos", JOptionPane.YES_NO_CANCEL_OPTION);
            if (option == 0) {
                JOptionPane.showMessageDialog(null, "Datos guardados", "Confirmacion", JOptionPane.INFORMATION_MESSAGE);
                pnlAccess.setVisible(true);
            } else if (option == 1) {
                emptyFields();
            }
        }*/
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnFinishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinishActionPerformed
        /* Employee employee;
        Registry registry;
        registry = new Registry("dd");
        String userName = "", password = "", dateOfBirth = "";
        userName = txtUsername.getText();
        if (txtUsername.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Nombre de usuario vacio, Complete");
        } else {

            dateOfBirth = covertDate(jDate);
            employee = new Employee(txtName.getText(),txtID.getText(),dateOfBirth,cmbGender.getSelectedItem().toString(),txtNumberPhone.getText(),txtUsername.getText(),"");
            password = employee.generateCode();
            lblCode.setText(password);
            employee.setAccesKey(password);
            registry = new Registry("Employees");
            System.out.println(employee.toString());
            //registry.register(employee);
            PrincipalWindow principalWindow;
            this.setVisible(false);
            principalWindow = new PrincipalWindow();
            principalWindow.setVisible(true);
        }*/
    }//GEN-LAST:event_btnFinishActionPerformed
    
    public void emptyFields() {
        /*txtName.setText("");
        txtID.setText("");
        txtNumberPhone.setText("");*/
    }

    /*public String covertDate(JDateChooser jDate) {
        DateFormat dateFormat;

        dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        String date = dateFormat.format(jDate.getDate());
        return date;

    }*/
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
            java.util.logging.Logger.getLogger(EmployeeWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeeWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnBack;
    public javax.swing.JButton btnFinish;
    public javax.swing.JButton btnSave;
    public javax.swing.JComboBox<String> cmbGender;
    public com.toedter.calendar.JDateChooser jDate;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JLabel lblBirthDate;
    public javax.swing.JLabel lblGender;
    public javax.swing.JLabel lblID;
    public javax.swing.JLabel lblName;
    public javax.swing.JLabel lblNumberPhone;
    public javax.swing.JLabel lblUserImage;
    public javax.swing.JLabel lblUsername;
    public javax.swing.JTextField txtID;
    public javax.swing.JTextField txtName;
    public javax.swing.JTextField txtNumberPhone;
    public javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}