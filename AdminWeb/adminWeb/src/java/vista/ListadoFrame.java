/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladorListado;
import controlador.VistaListado;
import java.util.ArrayList;
import modelo.Usuario;

/**
 *
 * @author docenteFI
 */
public class ListadoFrame extends javax.swing.JFrame 
                          implements VistaListado{

    private ControladorListado controlador;
    public ListadoFrame(Usuario u, java.awt.Frame parent) {
       // super(parent, modal);
        initComponents();
        controlador=new ControladorListado(this,u);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lista = new javax.swing.JList();
        logout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        jScrollPane1.setViewportView(lista);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(30, 20, 440, 330);

        logout.setText("Logout");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });
        getContentPane().add(logout);
        logout.setBounds(200, 360, 80, 30);

        setBounds(0, 0, 521, 436);
    }// </editor-fold>//GEN-END:initComponents

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        // TODO add your handling code here:
        controlador.logout();
    }//GEN-LAST:event_logoutActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        salir();
    }//GEN-LAST:event_formWindowClosing

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList lista;
    private javax.swing.JButton logout;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mostrar(ArrayList<Usuario> usuarios) {
        lista.setListData(usuarios.toArray());
    }

    private void salir() {
        controlador.logout();
        controlador.salir();
    }

    @Override
    public void mostrar(Usuario actual) {
        if(actual!=null)
            setTitle(actual.toString());
        else setTitle("Sin usuario");
    }

}