/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import modelo.Numero;

/**
 *
 * @author docenteFI
 */
public class PanelNumeros extends javax.swing.JPanel {

    /**
     * Creates new form PanelNumeros
     */
    public PanelNumeros(ArrayList<Numero> numeros,ActionListener al) {
        initComponents();
        GridLayout diseño = new GridLayout(1,numeros.size());
        setLayout(diseño);
        mostrar(numeros,al);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(null);
    }// </editor-fold>//GEN-END:initComponents

    private void mostrar(ArrayList<Numero> numeros,ActionListener al) {
        for(Numero n:numeros){
            Boton b = new Boton(n.getValor()+"");
            b.setNumero(n);
            b.setBackground(n.getColor());
            b.setForeground(Color.WHITE);
            b.addActionListener(al);
            if(n.getMarcador()!=null){
                b.setToolTipText(n.getMarcador());
            }else b.setToolTipText("sin marcar");
            
            add(b);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}