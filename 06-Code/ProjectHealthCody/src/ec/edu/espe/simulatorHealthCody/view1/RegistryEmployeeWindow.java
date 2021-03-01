/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorHealthCody.view1;

/**
 *
 * @author Mateo Ávila ESPE
 */
public class RegistryEmployeeWindow extends javax.swing.JFrame {

    /**
     * Creates new form RegistryEmployeeWindow
     */
    public RegistryEmployeeWindow() {
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
        jLabel2 = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblID = new javax.swing.JLabel();
        lblBirthDate = new javax.swing.JLabel();
        lblNumberPhone = new javax.swing.JLabel();
        lblGender = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtID = new javax.swing.JTextField();
        txtNumberPhone = new javax.swing.JTextField();
        jMonth = new javax.swing.JComboBox<>();
        cmbDay = new javax.swing.JComboBox<>();
        ccmbGender = new javax.swing.JComboBox<>();
        jYear = new javax.swing.JSpinner();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Apple SD Gothic Neo", 1, 36)); // NOI18N
        jLabel2.setText("Registro para Administradores");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(50, 90, 510, 44);

        lblName.setText("Nombres y Apellidos:");
        jPanel1.add(lblName);
        lblName.setBounds(50, 150, 170, 16);

        lblID.setText("Cédula o pasaporte:");
        jPanel1.add(lblID);
        lblID.setBounds(50, 210, 125, 16);

        lblBirthDate.setText("Fecha de Nacimiento: (dd/mm/aaaa)");
        jPanel1.add(lblBirthDate);
        lblBirthDate.setBounds(50, 270, 270, 16);

        lblNumberPhone.setText("Número de contacto:");
        jPanel1.add(lblNumberPhone);
        lblNumberPhone.setBounds(50, 340, 180, 16);

        lblGender.setText("Género:");
        jPanel1.add(lblGender);
        lblGender.setBounds(60, 400, 60, 16);
        jPanel1.add(txtName);
        txtName.setBounds(50, 170, 470, 26);
        jPanel1.add(txtID);
        txtID.setBounds(50, 230, 470, 26);
        jPanel1.add(txtNumberPhone);
        txtNumberPhone.setBounds(50, 360, 460, 26);

        jMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
        jPanel1.add(jMonth);
        jMonth.setBounds(150, 300, 140, 27);

        cmbDay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        jPanel1.add(cmbDay);
        cmbDay.setBounds(50, 300, 72, 27);

        ccmbGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Femenino", "Otros" }));
        jPanel1.add(ccmbGender);
        ccmbGender.setBounds(120, 400, 150, 27);
        jPanel1.add(jYear);
        jYear.setBounds(290, 300, 70, 26);

        jButton1.setText("Guardar");
        jPanel1.add(jButton1);
        jButton1.setBounds(90, 440, 93, 29);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/espe/simulatorHealthCody/view1/RegisterIMG.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 860, 490);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            java.util.logging.Logger.getLogger(RegistryEmployeeWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistryEmployeeWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistryEmployeeWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistryEmployeeWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistryEmployeeWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ccmbGender;
    private javax.swing.JComboBox<String> cmbDay;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JComboBox<String> jMonth;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSpinner jYear;
    private javax.swing.JLabel lblBirthDate;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNumberPhone;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNumberPhone;
    // End of variables declaration//GEN-END:variables
}