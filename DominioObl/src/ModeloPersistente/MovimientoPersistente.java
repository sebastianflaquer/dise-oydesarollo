/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloPersistente;

import Juegos.Movimiento;
import PersistenciaCont.Persistente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Mauro
 */
public class MovimientoPersistente implements Persistente {
    private Movimiento mov;
    
    public MovimientoPersistente(Movimiento m)
    {
        this.mov = m;
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
    public Persistente crearNuevo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<String> getInsertSql() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public ArrayList<String> getInsertSqlPrueba(int idMano) {
        ArrayList r = new ArrayList();
        r.add("INSERT INTO movimiento(idMovimiento,fechaHora,tipoMov,idUsuario,idMano)"
                + "VALUES(null, " + mov.getFechaHora() + ",'" + mov.getTipoMov().nombreTipo() + " ',"
                + 1 + "," + idMano + ")");
        return r;
    }

    @Override
    public void setOid(int oid) {
        this.mov.setId(oid);
    }
    
    @Override
    public int getOid() {
        if(this.mov==null) return 0;
        return mov.getId();
    }

    @Override
    public void leer(ResultSet rs) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getObjeto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void limpiar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
