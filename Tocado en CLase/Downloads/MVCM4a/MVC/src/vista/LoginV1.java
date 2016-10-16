/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladorLogin;
import controlador.Login;
import javax.swing.JOptionPane;
import modelo.Usuario;

/**
 *
 * @author docenteFI
 */
public class LoginV1 extends javax.swing.JDialog implements Login{

    /**
     * Creates new form LoginV1
     */
    private ControladorLogin controlador;
    public LoginV1(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
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
        usuario = new javax.swing.JTextField();
        pass = new javax.swing.JTextField();
        login = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setText("Usuario");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 50, 70, 20);

        jLabel2.setText("Password");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 100, 80, 30);
        getContentPane().add(usuario);
        usuario.setBounds(90, 50, 160, 30);
        getContentPane().add(pass);
        pass.setBounds(90, 100, 160, 30);

        login.setText("Login");
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });
        getContentPane().add(login);
        login.setBounds(270, 100, 80, 30);

        setBounds(0, 0, 416, 186);
    }// </editor-fold>//GEN-END:initComponents

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        // TODO add your handling code here:
        controlador.login(usuario.getText(), pass.getText());
    }//GEN-LAST:event_loginActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton login;
    private javax.swing.JTextField pass;
    private javax.swing.JTextField usuario;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mostrarErrorLogin() {
        JOptionPane.showMessageDialog(this,"Login incorrecto");
    }

    @Override
    public void ingresar(Usuario logueado) {
        new ListaUsuariosV1(null, false,logueado).setVisible(true);
        dispose();
    }

    @Override
    public void habilitar(boolean b) {
        login.setEnabled(b);
    }
}