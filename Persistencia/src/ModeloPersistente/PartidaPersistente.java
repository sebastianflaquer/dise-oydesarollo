/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloPersistente;

import Juegos.Partida;
import PersistenciaCont.Persistente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Mauro
 */
public class PartidaPersistente implements Persistente{
    private Partida partida;
    
    
    public PartidaPersistente(Partida p) {
        this.partida = p;
    }
    
    
    
    @Override
    public Persistente crearNuevo() {
        return new PartidaPersistente(new Partida());
    }

    @Override
    public Object getObjeto() {
        return partida;
    }
    
    @Override
    public ArrayList<String> getInsertSql() {
        ArrayList r = new ArrayList();
        r.add( "INSERT INTO partida(idPartida,jug1,jug2,estado,apuestaInicial,ApuestaActual)"
                +"VALUES( null, "+ 3 +","+ 3 +" ,'"
                +partida.getEstado()+"',"+partida.getApuestaActual()+","+ partida.getApuestaActual()+ ")");
        
        //INSERT INTO partida(idPartida,jug1,jug2,estado,apuestaInicial,ApuestaActual)VALUES( null, 3,3,'En Juego',100.0,100.0)
        return r;
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
    public void setOid(int oid) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getOid() {
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
