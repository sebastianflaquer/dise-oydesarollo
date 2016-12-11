/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Controladores.ControladorJuego;
import Controladores.IMesaAdmin;
import Fachada.Sistema;
import Juegos.Partida;
import Usuarios.Usuario;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sebastian
 */
public class MesaAdmin extends javax.swing.JFrame implements IMesaAdmin {

    /**
     * Creates new form MesaAdmin
     */
    public MesaAdmin() {
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

        jPanel1 = new javax.swing.JPanel();
        MenuAdmin = new javax.swing.JPanel();
        NomAdmin = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        listPartidas = new javax.swing.JList();
        btnVerManos = new javax.swing.JButton();
        lblPartidas = new javax.swing.JLabel();
        lblManos = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnSalir.setText("Salir");

        jLabel1.setText("Nombre:");

        javax.swing.GroupLayout MenuAdminLayout = new javax.swing.GroupLayout(MenuAdmin);
        MenuAdmin.setLayout(MenuAdminLayout);
        MenuAdminLayout.setHorizontalGroup(
            MenuAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuAdminLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(NomAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 430, Short.MAX_VALUE)
                .addComponent(btnSalir))
        );
        MenuAdminLayout.setVerticalGroup(
            MenuAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuAdminLayout.createSequentialGroup()
                .addGroup(MenuAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSalir)
                    .addGroup(MenuAdminLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(MenuAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NomAdmin)
                            .addComponent(jLabel1))))
                .addGap(0, 25, Short.MAX_VALUE))
        );

        jScrollPane3.setViewportView(listPartidas);

        btnVerManos.setText(">");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, btnVerManos, org.jdesktop.beansbinding.ELProperty.create("VERMANOS"), btnVerManos, org.jdesktop.beansbinding.BeanProperty.create("actionCommand"));
        bindingGroup.addBinding(binding);

        lblPartidas.setText("Partidas:");

        lblManos.setText("Manos:");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MenuAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnVerManos))
                    .addComponent(lblPartidas))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblManos)
                        .addContainerGap())
                    .addComponent(jScrollPane1)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(MenuAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPartidas)
                    .addComponent(lblManos))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(btnVerManos))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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
            java.util.logging.Logger.getLogger(MesaAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MesaAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MesaAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MesaAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MesaAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MenuAdmin;
    private javax.swing.JLabel NomAdmin;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnVerManos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblManos;
    private javax.swing.JLabel lblPartidas;
    private javax.swing.JList listPartidas;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    @Override
    public void inicializar() {
        setVisible(true);
        try {
            cargarPartidas();
        } catch (SQLException ex) {
            Logger.getLogger(MesaAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void terminar() {
        setVisible(false);
    }

    @Override
    public void setControlador(ControladorJuego c) {
        this.btnVerManos.addActionListener(c);
    }

    @Override
    public void cargarDatosAdmin(Usuario admin) {
        this.NomAdmin.setText(admin.getNomCompleto());
    }

    public void cargarPartidas() throws SQLException {
        this.listPartidas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.listPartidas.setModel(Sistema.GetInstancia().modelList());
        this.jTable1.setModel(modelTableManos());
    }

    //LISTA DE PARTIDAS
    private DefaultListModel modelList() {
        DefaultListModel<String> model = new DefaultListModel<>();
        for (int i = 0; i < Sistema.GetInstancia().getPartidas().size(); i++) {
            int id = Sistema.GetInstancia().getPartidas().get(i).getOid();
            String str = Integer.toString(id);
            model.addElement("Partida ID: " + str);
        }
        return model;
    }

    //AGREGA A LA LISTA EL MODELO
    @Override
    public void CargarManosDePartida() {
        try {
            this.jTable1.setModel(modelListManos());
        } catch (SQLException ex) {
            Logger.getLogger(MesaAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private DefaultTableModel modelTableManos() {
        DefaultTableModel modelTable = new DefaultTableModel();
        modelTable.addColumn("Id");
        modelTable.addColumn("F J1");
        modelTable.addColumn("F J2");
        modelTable.addColumn("F Mesa");
        modelTable.addColumn("F Jugadas");
        modelTable.addColumn("Tipo Mov");
        return modelTable;
    }

    //MODELO LISTA DE MANOS
    private DefaultTableModel modelListManos() throws SQLException {
        int idPartidaSel = this.listPartidas.getSelectedIndex() + 1;
        DefaultTableModel modelTable = modelTableManos();

        for (int i = 0; i < Sistema.GetInstancia().getPartidaPorId(idPartidaSel).getManos().size(); i++) {
            int id = Sistema.GetInstancia().getPartidaPorId(idPartidaSel).getManos().get(i).getId();
            int fj1 = Sistema.GetInstancia().getCantFichasPorMano(id, "cantFichasJ1");
            int fj2 = Sistema.GetInstancia().getCantFichasPorMano(id, "cantFichasJ2");;
            int fm = Sistema.GetInstancia().getCantFichasPorMano(id, "cantFichasMazo");;
            int fj = Sistema.GetInstancia().getCantFichasPorMano(id, "cantFichasJugadas");;
            String TipoMano = Sistema.GetInstancia().getPartidaPorId(idPartidaSel).getManos().get(i).getMovimiento().getTipoMov().nombreTipo();
            if (TipoMano.equalsIgnoreCase("Apuesta")) {
                double apuesta = Sistema.GetInstancia().getPartidaPorId(idPartidaSel).getManos().get(i).getMovimiento().getTipoMov().montoApuesta();
                //TipoMano += ": $" + Double.toString(apuesta);
            }
            //AGREGA LA ROW A LA TABLA
            modelTable.addRow(
                    new Object[]{
                        Integer.toString(id),
                        Integer.toString(fj1),
                        Integer.toString(fj2),
                        Integer.toString(fm),
                        Integer.toString(fj),
                        TipoMano,}
            );
        }
        return modelTable;
    }

}
