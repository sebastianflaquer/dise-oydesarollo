/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladorNumeros;
import controlador.VistaNumeros;
import java.util.ArrayList;
import modelo.Numero;
import modelo.Usuario;

/**
 *
 * @author docenteFI
 */
public class VistaNumerosV2 extends javax.swing.JDialog implements VistaNumeros{

    /**
     * Creates new form VistaNumerosV2
     */
    ControladorNumeros controlador;
    public VistaNumerosV2(java.awt.Frame parent, boolean modal,Usuario u) {
        super(parent, modal);
        initComponents();
        controlador = new ControladorNumeros(this,u);
        
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
        marca = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jScrollPane1.setViewportView(lista);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(40, 30, 470, 230);

        marca.setText("M/DM");
        marca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                marcaActionPerformed(evt);
            }
        });
        getContentPane().add(marca);
        marca.setBounds(230, 280, 120, 30);

        setBounds(0, 0, 583, 365);
    }// </editor-fold>//GEN-END:initComponents

    private void marcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_marcaActionPerformed
        // TODO add your handling code here:
        Numero n = (Numero)lista.getSelectedValue();
        if(n!=null){
            controlador.marcar(n);
        }
    }//GEN-LAST:event_marcaActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList lista;
    private javax.swing.JButton marca;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mostrarNumeros(ArrayList<Numero> numeros) {
        lista.setListData(numeros.toArray());
    }
}