/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import dominio.Modelo;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.WindowConstants;

/**
 *
 * @author alumnoFI
 */
public class principal extends javax.swing.JFrame {
    
    private Menu BarraMenu;

    /**
     * Creates new form principal
     */
    public principal() {
        initComponents();
        inicializar();
    }
    
    
    public void inicializar(){
        //cerrar ejecucion de contexto
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        //inicializar variables
        this.BarraMenu = new Menu();
        
        //enlazar elementos
        this.setJMenuBar(this.BarraMenu);

        this.agregarAccionesMenu();
        
        //configuracion de la ventana: tamaño fijo
        //this.setSize(new Dimension(300,400));
        
        //configuracion a pantalla completa
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        this.setVisible(true);
    }
    
    
    //Agrego las acciones correspondientes al menu de la aplicacion
    public void agregarAccionesMenu(){
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ejecutarAccionMenu(((Component)e.getSource()).getName());
            }
        };
        for (int i = 0; i < this.BarraMenu.getComponents().length; i++) {
            JMenu menu = this.BarraMenu.getMenu(i);
            
            for (int j = 0; j < menu.getItemCount(); j++) {
                menu.getItem(j).addActionListener(al);
            }
        }
    }
    private void ejecutarAccionMenu(String action) {
        switch(action)
        {
            case "NuevoDisco":
                this.initNuevoDisco();
                break;
            case "ListadoOrdenado":
                this.initListadoOrdenado();
                break;
            default:
                break;
        }
    }
    
    private void initNuevoDisco()
    {
        FrmDisco frmAgregarDisco = new FrmDisco();
        
        ActionListener eventoAgregarPelicula = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmDisco d = (FrmDisco)((Component)e.getSource()).getParent();
                Modelo.GetInstancia().AgregarDisco(d.GetDisco());
                d.LimpiarPantalla();
            }
        };
        
        frmAgregarDisco.agregarAccionGuardar(eventoAgregarPelicula);
        agregarVentana(frmAgregarDisco);
    }
    
    private void initListadoOrdenado()
    {
        ListadoPeliculasFrm frmLisatdoPeliculas = new ListadoPeliculasFrm();
        agregarVentana(frmLisatdoPeliculas);
        frmLisatdoPeliculas.Actualizar(Modelo.GetInstancia().getListadoPeliculasOrdenado());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
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
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
