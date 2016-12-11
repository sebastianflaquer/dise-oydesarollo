/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fachada;

import Juegos.Apuesta;
import Juegos.ColocarFicha;
import Juegos.ITipoMovimiento;
import Juegos.Mano;
import Juegos.Movimiento;
import Juegos.Partida;
import Juegos.RecogerFicha;
import PersistenciaCont.ManejadorBD;
import Usuarios.Jugador;
import Usuarios.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;

public class Sistema {

    //================================================================================
    //ATRIBUTOS
    //================================================================================
    private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    private ArrayList<Partida> partidas = new ArrayList<Partida>();

    private static Sistema instancia;

    public static Sistema GetInstancia() {
        if (instancia == null) {
            instancia = new Sistema();
        }

        return instancia;
    }

    //================================================================================
    //SETTERS
    //================================================================================
    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public void setPartidas(ArrayList<Partida> partidas) {
        this.partidas = partidas;
    }

    //================================================================================
    //GETTERS
    //================================================================================
    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public ArrayList<Partida> getPartidas() {
        return partidas;
    }

    //================================================================================
    //METODOS
    //================================================================================
    //ARGEGA UN USUARIO
    public void agregar(Usuario u) {
        if (u != null) {
            usuarios.add(u);
        }
    }

    //AGREGA UNA PARTIDA
    public void agregarPartida(Partida p) {
        if (p != null) {
            partidas.add(p);
        }
    }

    //CHEQUEA LUGAR LIBRE
    public Partida chequeaLugarEnPartida(Usuario unUsu) {
        boolean ret = false;

        Partida p = null;
        int i = 0;

        while (i < this.partidas.size() && ret == false) {
            if (this.partidas.get(i).getJugador1() == null) {
                ret = true;
                this.partidas.get(i).setJugador1(unUsu);
                p = this.partidas.get(i);
                unUsu.getTipo().setNumeroJug(1);
            } else {
                ret = true;
                this.partidas.get(i).setJugador2(unUsu);
                p = this.partidas.get(i);
                unUsu.getTipo().setNumeroJug(2);
            }
        }
        return p;
    }

    public DefaultListModel modelList() throws SQLException {
        DefaultListModel<String> model = new DefaultListModel<>();

        ManejadorBD bd = ManejadorBD.getInstancia();
        bd.conectar("jdbc:mysql://localhost/domino?user=root&password=root");
        ResultSet rs = bd.obtenerResultSet("Select * from partidas");
        while (rs.next()) {
            int id = rs.getInt(1);
            String str = Integer.toString(id);
            model.addElement("Partida ID: " + str);
        }
        return model;
//        for (int i = 0; i < Sistema.GetInstancia().getPartidas().size(); i++) {
//            int id = Sistema.GetInstancia().getPartidas().get(i).getOid();
//            String str = Integer.toString(id);
//            model.addElement("Partida ID: " + str);
//        }
//        return model;
    }

    public Partida getPartidaPorId(int id) throws SQLException {
        try {
            ManejadorBD bd = ManejadorBD.getInstancia();
            bd.conectar("jdbc:mysql://localhost/domino?user=root&password=root");
            ResultSet rs = bd.obtenerResultSet("Select * from partidas where idPartida=" + id);
            Partida p = new Partida();
            boolean ok = false;
            while (rs.first() && !ok) {
                p.setOid(rs.getInt(1));
//            ResultSet rs2 = bd.obtenerResultSet("Select * from usuarios where idUsuario=" + rs.getInt(2));
//            p.setJugador1();
                p.setEstado(rs.getString(4));
                ResultSet rsManos = bd.obtenerResultSet("Select * from manos where idPartida=" + rs.getInt(1));
                ArrayList<Mano> manos = new ArrayList<Mano>();
                while (rsManos.next()) {
                    Mano m = new Mano();
                    m.setId(rsManos.getInt(1));
                    //FALTA CARGAR LA CANTIDAD DE FICHAS DE LOS JUGADORES
                    ResultSet rsMov = bd.obtenerResultSet("Select * from movimiento where idMano=" + rsManos.getInt(1));
                    boolean ok2 = false;
                    ITipoMovimiento tMov = null;
                    while (rsMov.first() && !ok2) {
                        if (rsMov.getString(3).equalsIgnoreCase("Apuesta ")) {
                            tMov = new Apuesta(-1);
                        } else if (rsMov.getString(3).equalsIgnoreCase("ColocarFicha ")) {
                            tMov = new ColocarFicha();
                        } else {
                            tMov = new RecogerFicha();
                        }
                        ok2 = true;
                    }
                    // CORREGIR
                    Movimiento mov = new Movimiento(tMov, new Usuario());
                    m.setMovimiento(mov);
                    manos.add(m);
                }
                p.setManos(manos);
                //PARA SALIR DEL WHILE
                ok = true;
            }
            return p;
        } catch (Exception e) {
            throw e;
        } finally {
            ManejadorBD.getInstancia().desconectar();
        }

    }

    public int getCantFichasPorMano(int idMano, String columna) throws SQLException {
        try {
            ManejadorBD bd = ManejadorBD.getInstancia();
            bd.conectar("jdbc:mysql://localhost/domino?user=root&password=root");
            boolean ok = false;
            int ret = -1;
            ResultSet rs = bd.obtenerResultSet("Select * from manos where idMano=" + idMano);
            while (rs.first() && !ok) {
                ret = Integer.parseInt(rs.getString(columna));
                ok = true;
            }
            return ret;
        } catch (SQLException | NumberFormatException e) {
            throw e;
        } finally {
            ManejadorBD.getInstancia().desconectar();
        }

    }

}
