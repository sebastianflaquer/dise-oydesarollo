/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Controladores.ControladorJuego;
import Controladores.IMesa;
import Juegos.Mano;
import Juegos.Partida;
import Usuarios.Jugador;
import Usuarios.Usuario;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JDialog;

/**
 *
 * @author Mauro
 */
public class Mesa extends javax.swing.JFrame implements IMesa { 

    /**
     * Creates new form Mesa
     */
    public Mesa() {
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
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jOptionPane1 = new javax.swing.JOptionPane();
        jPanel5 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        LblNombre = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblSaldo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblApuestaActual = new javax.swing.JLabel();
        txtAumentarApuesta = new javax.swing.JTextField();
        btnAumentarApuesta = new javax.swing.JButton();
        jPanelAceptarApuesta = new javax.swing.JPanel();
        jButtonCancelarApuesta = new javax.swing.JButton();
        jLabelApuesta = new javax.swing.JLabel();
        jButtonAceptarApuesta1 = new javax.swing.JButton();
        lblnuevaApuesta = new javax.swing.JLabel();
        lblErrorApuesta = new javax.swing.JLabel();
        lblRegresiva = new javax.swing.JLabel();
        lblRegresivaApuesta = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnMasFicha = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        fichasJugadorPanel = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPaneFichasJuego = new javax.swing.JScrollPane();
        fichasJuegoPanel = new javax.swing.JPanel();
        lblGanador = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Nombre Usuario:");

        jLabel2.setText("Saldo:");
        jLabel2.setToolTipText("");

        jLabel3.setText("Apúesta Actual:");

        btnAumentarApuesta.setText("Aumentar Apuesta");
        btnAumentarApuesta.setActionCommand("SubirApuesta");

        jButtonCancelarApuesta.setText("Cancelar");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jButtonCancelarApuesta, org.jdesktop.beansbinding.ELProperty.create("CANCELARAPUESTA"), jButtonCancelarApuesta, org.jdesktop.beansbinding.BeanProperty.create("actionCommand"));
        bindingGroup.addBinding(binding);

        jLabelApuesta.setText("Se Aumento la Apuesta a: ");

        jButtonAceptarApuesta1.setText("Aceptar");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jButtonAceptarApuesta1, org.jdesktop.beansbinding.ELProperty.create("ACEPTARAPUESTA"), jButtonAceptarApuesta1, org.jdesktop.beansbinding.BeanProperty.create("actionCommand"));
        bindingGroup.addBinding(binding);

        javax.swing.GroupLayout jPanelAceptarApuestaLayout = new javax.swing.GroupLayout(jPanelAceptarApuesta);
        jPanelAceptarApuesta.setLayout(jPanelAceptarApuestaLayout);
        jPanelAceptarApuestaLayout.setHorizontalGroup(
            jPanelAceptarApuestaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAceptarApuestaLayout.createSequentialGroup()
                .addGroup(jPanelAceptarApuestaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelAceptarApuestaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelApuesta))
                    .addGroup(jPanelAceptarApuestaLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanelAceptarApuestaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblnuevaApuesta)
                            .addGroup(jPanelAceptarApuestaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jButtonAceptarApuesta1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButtonCancelarApuesta)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelAceptarApuestaLayout.setVerticalGroup(
            jPanelAceptarApuestaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAceptarApuestaLayout.createSequentialGroup()
                .addComponent(jLabelApuesta, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(lblnuevaApuesta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonAceptarApuesta1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonCancelarApuesta)
                .addGap(6, 6, 6))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(LblNombre))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblSaldo))
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblApuestaActual, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(lblRegresiva, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jPanelAceptarApuesta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(txtAumentarApuesta, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAumentarApuesta))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblErrorApuesta)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblRegresivaApuesta)
                        .addGap(39, 39, 39))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelAceptarApuesta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 32, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblRegresiva, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblRegresivaApuesta)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnAumentarApuesta)
                    .addComponent(LblNombre)
                    .addComponent(txtAumentarApuesta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(lblSaldo))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(lblApuestaActual, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lblErrorApuesta))))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnMasFicha.setText("+ 1");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, btnMasFicha, org.jdesktop.beansbinding.ELProperty.create("ADDFICHA"), btnMasFicha, org.jdesktop.beansbinding.BeanProperty.create("actionCommand"));
        bindingGroup.addBinding(binding);

        jLabel4.setText("Mis Fichas:");

        fichasJugadorPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.LEFT);
        flowLayout1.setAlignOnBaseline(true);
        fichasJugadorPanel.setLayout(flowLayout1);
        jScrollPane2.setViewportView(fichasJugadorPanel);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnMasFicha)
                .addContainerGap())
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(btnMasFicha))
                .addContainerGap(88, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                    .addContainerGap(39, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        fichasJuegoPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fichasJuegoPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPaneFichasJuego.setViewportView(fichasJuegoPanel);

        lblGanador.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(237, 237, 237)
                .addComponent(lblGanador)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPaneFichasJuego)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPaneFichasJuego, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblGanador))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bindingGroup.bind();

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
            java.util.logging.Logger.getLogger(Mesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Mesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Mesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Mesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Mesa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LblNombre;
    private javax.swing.JButton btnAumentarApuesta;
    private javax.swing.JButton btnMasFicha;
    private javax.swing.JPanel fichasJuegoPanel;
    private javax.swing.JPanel fichasJugadorPanel;
    private javax.swing.JButton jButtonAceptarApuesta1;
    private javax.swing.JButton jButtonCancelarApuesta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelApuesta;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanelAceptarApuesta;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPaneFichasJuego;
    private javax.swing.JLabel lblApuestaActual;
    private javax.swing.JLabel lblErrorApuesta;
    private javax.swing.JLabel lblGanador;
    private javax.swing.JLabel lblRegresiva;
    private javax.swing.JLabel lblRegresivaApuesta;
    private javax.swing.JLabel lblSaldo;
    private javax.swing.JLabel lblnuevaApuesta;
    private javax.swing.JTextField txtAumentarApuesta;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    @Override
    public void inicializar() {
        setVisible(true);
    }

    @Override
    public void SetErrorMsj(String mensaje) {
    }
    @Override
    public double GettxtSubirApuesta(){
        if(this.txtAumentarApuesta.getText().isEmpty()){
            ErrorMensajeApuesta("Debe Ingresar un monto > 0");
        }else if(!this.txtAumentarApuesta.getText().matches("[0-9]+")){
            ErrorMensajeApuesta("Debe Ingresar un Numero");
        }
        else{
            return Double.parseDouble(this.txtAumentarApuesta.getText());
        }
        return -1;
    }
    
    @Override
    public void SetNombreUsuario(String nombreUsuario) {
        this.LblNombre.setText(nombreUsuario);
    }

    @Override
    public void setControlador(ControladorJuego c) {
        this.btnMasFicha.addActionListener(c);
        this.btnAumentarApuesta.addActionListener(c);
        this.jButtonAceptarApuesta1.addActionListener(c);
        this.jButtonCancelarApuesta.addActionListener(c);
    }

    @Override
    public void CargarDatosDelJugador(Usuario unUsu) {
        
        //get nombre de usuario
        if(unUsu.getNomCompleto() != null){
            this.LblNombre.setText(unUsu.getNomCompleto());
            this.lblSaldo.setText(Double.toString(unUsu.getTipo().getSaldo()));
        }else{
            this.LblNombre.setText("trajo null");
        }
    }
    
    @Override
    //ELIMINA LOS BOTONES DE LA MESA
    public void removeAllMesa(){
        this.fichasJugadorPanel.removeAll();
    }
    
    @Override
    //ELIMINA LOS BOTONES DEL TABLERO
    public void removeAllTablero(){
        this.fichasJuegoPanel.removeAll(); 
    }
    
    @Override
    //CARGA LAS FICHAS DEL JUGAROR
    public void CargarFichasDelJugador(int val1, int val2, ControladorJuego c){       
        
        ImageIcon image = new ImageIcon("D:/resources/"+val1+"-"+val2+".jpg");
        
        JButton btn = new JButton(image);
        btn.setPreferredSize( new Dimension(74, 38));
        btn.setBackground(Color.white);
        btn.setContentAreaFilled(false);
        btn.setActionCommand(val1+"-"+val2);
        btn.addActionListener(c);
        this.fichasJugadorPanel.add(val1+"-"+val2,btn);
        validate();
    }
    
    @Override
    //CARGA FICHAS DEL TABLERO
    public void CargarFichasAlTablero(int val1, int val2, ControladorJuego c){
        ImageIcon image = new ImageIcon("D:/resources/"+val1+"-"+val2+".jpg");
      
        JButton btn = new JButton(image);
        btn.setPreferredSize( new Dimension(74, 38));
        btn.setBackground(Color.white);
        btn.setContentAreaFilled(false);
        this.fichasJuegoPanel.add(val1+"-"+val2,btn);
        validate();
    }
        
    
    @Override
    //SEGUN EL TURNO, DESHABILITO EL PANEL DEL JUGADOR
    public void deshabilitarPanelJugador (Usuario UsuarioTurnoActual, Usuario unUsu){
        if(UsuarioTurnoActual == unUsu){
            this.jPanel4.setVisible(true);
            this.btnAumentarApuesta.setVisible(true);
            this.txtAumentarApuesta.setVisible(true);
        }
        else{
            this.jPanel4.setVisible(false);
            this.btnAumentarApuesta.setVisible(false);
            this.txtAumentarApuesta.setVisible(false);
        }
    }

    @Override
    //INCREMENTA LA APUESTA ACTUAL
    public void SetApuestaActual(String mensaje) {
        this.lblApuestaActual.setText(mensaje);
    
    }
    
    @Override
    //OCULTA PANEL JUGADOR Y MUESTRA CARTEL
    public void ocultarPanelesGanador(String jugador){
        this.fichasJuegoPanel.setVisible(false);
        this.lblGanador.setText(jugador);
    }

    @Override
    public void ocultarPanelApuesta() {
        this.jPanelAceptarApuesta.setVisible(false);
    }
    @Override
    public void mostrarPanelApuesta( double valorApuesta) {
        this.lblnuevaApuesta.setText(Double.toString(valorApuesta));
        this.jPanelAceptarApuesta.setVisible(true);
    }
    @Override
    public void mostrarPanelEspera(){
        //this..setVisible(true);
    }
    
    @Override
    public void ErrorMensajeApuesta(String msg){
        this.lblErrorApuesta.setText(msg);
    }

    @Override
    public void SetRegresiva(String numero) {
        this.lblRegresiva.setText(numero);
    }

    @Override
    public void SetRegresivaApuesta(String numero) {
       this.lblRegresivaApuesta.setText(numero);
    }
    
    

}