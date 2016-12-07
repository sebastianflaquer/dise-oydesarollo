/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladorLogin;
import controlador.VistaLogin;
import javax.swing.JOptionPane;
import modelo.Usuario;

/**
 *
 * @author Dario
 */
public class LoginFrame extends javax.swing.JFrame implements VistaLogin{

    /**
     * Creates new form LoginV1
     */
    private ControladorLogin controlador;
    public LoginFrame() {
        initComponents();
        controlador = new ControladorLogin(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        password = new javax.swing.JTextField();
        login = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setText("Usuario ");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 40, 50, 20);

        jLabel2.setText("Password");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 80, 60, 14);
        getContentPane().add(nombre);
        nombre.setBounds(90, 40, 180, 20);
        getContentPane().add(password);
        password.setBounds(90, 80, 180, 20);

        login.setText("Ingresar");
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });
        getContentPane().add(login);
        login.setBounds(120, 120, 80, 23);

        setBounds(0, 0, 320, 207);
    }// </editor-fold>//GEN-END:initComponents

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        // TODO add your handling code here:
        controlador.login(nombre.getText(), password.getText());
    }//GEN-LAST:event_loginActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton login;
    private javax.swing.JTextField nombre;
    private javax.swing.JTextField password;
    // End of variables declaration//GEN-END:variables

    @Override
    public void ingresar(Usuario usuario) {
       dispose();
       new ListadoFrame(usuario,null).setVisible(true);

    }

    @Override
    public void error(String msg) {
        JOptionPane.showMessageDialog(this,msg );
    }
}