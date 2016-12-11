/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloPersistente;

import Juegos.Partida;
import PersistenciaCont.ManejadorBD;
import PersistenciaCont.Persistente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Mauro
 */
public class PartidaPersistente implements Persistente {

    private Partida p;

    public PartidaPersistente(Partida p) {
        this.p = p;
    }

    @Override
    public Persistente crearNuevo() {
        return new PartidaPersistente(new Partida());
    }

    @Override
    public Object getObjeto() {
        return p;
    }

    @Override
    public void setOid(int oid) {
        p.setOid(oid);
    }

    @Override
    public int getOid() {
        if (this.p == null) {
            return 0;
        }
        return p.getOid();
    }

    @Override
    public ArrayList<String> getInsertSql() {
        ArrayList r = new ArrayList();
        r.add("INSERT INTO partidas(idPartida,jug1,jug2,estado,apuestaInicial,ApuestaActual)"
                + "VALUES(" + getOid() + "," + p.getJugador1().getId() + "," + p.getJugador2().getId() + " ,'"
                + p.getEstado() + "'," + Partida.getApuestaInicial() + "," + p.getApuestaActual() + ")");
        return r;
    }

    public void ImpactarDatos() {
        try {
            ManejadorBD bd = ManejadorBD.getInstancia();
            bd.conectar("jdbc:mysql://localhost/domino?user=root&password=root");
            String listString = "";
            int oid = bd.proximoOid();
            this.setOid(oid);
            for (String s : this.getInsertSql()) {
                listString += s + "\t";
            }
            //IMPACTA EN TABLA PARTIDA
            bd.ejecutar(listString);
            //IMPACTA EN TABLA MANOS Y MOVIMIENTO
            for (int i = 0; i < this.p.getManos().size(); i++) {
                ManoPersistente mp = new ManoPersistente(this.p.getManos().get(i));
                String listStringManos = "";
                for (String s : mp.getInsertSqlPrueba(getOid())) {
                    listStringManos += s + "\t";
                }
                bd.ejecutar(listStringManos);

                MovimientoPersistente movP = new MovimientoPersistente(this.p.getManos().get(i).getMovimiento());
                int mid = bd.proximoIdMano();
                this.p.getManos().get(i).setId(mid);
                String listStringMov = "";
                for (String s : movP.getInsertSqlPrueba(this.p.getManos().get(i).getId())) {
                    listStringMov += s + "\t";
                }
                bd.ejecutar(listStringMov);
            }
            //ACTUALIZA LOS SALDOS DE LOS JUEGADORES
            String updateSaldoJ1 = "update usuarios set saldo =" + p.getJugador1().getTipo().getSaldo() + " where idUsuario=" + p.getJugador1().getId();
            String updateSaldoJ2 = "update usuarios set saldo =" + p.getJugador2().getTipo().getSaldo() + " where idUsuario=" + p.getJugador2().getId();
            bd.ejecutar(updateSaldoJ1);
            bd.ejecutar(updateSaldoJ2);

        } catch (Exception e) {
            throw e;
        } finally {
            ManejadorBD.getInstancia().desconectar();
        }

    }

    @Override
    public String getUpdateSql() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getDeleteSql() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getSelectSql() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void leer(ResultSet rs) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void limpiar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
