/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloPersistente;

import Juegos.Mano;
import PersistenciaCont.Persistente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Mauro
 */
public class ManoPersistente implements Persistente{
    private Mano mano;
    
    public ManoPersistente(Mano m) {
        this.mano = m;
    }

    @Override
    public String getSelectSql() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //FALTA IDPARTIDA
    @Override
    public ArrayList<String> getInsertSql() {
        ArrayList r = new ArrayList();
        r.add("INSERT INTO manos(idMano,cantFichasj1,cantFichasj2,canfichasMazo,cantFichasJugadas, idPartida)"
                + "VALUES( null, " + mano.getFichasJ1().size() + "," + mano.getFichasJ2().size() + " ,"
                + mano.getFichasMazo().size() + "," + mano.getFichasJugadas().size() + ")");
        return r;
    }
    
    public ArrayList<String> getInsertSqlConId(int idPartida) {
        ArrayList r = new ArrayList();
        r.add("INSERT INTO manos(idMano,cantFichasJ1,cantFichasJ2,cantFichasMazo,cantFichasJugadas, idPartida)"
                + "VALUES(null, " + mano.getFichasJ1().size() + "," + mano.getFichasJ2().size() + " ,"
                + mano.getFichasMazo().size() + "," + mano.getFichasJugadas().size() + "," + idPartida + ")");
        return r;
    }

    @Override
    public void setOid(int oid) {
        mano.setId(oid);
    }

    @Override
    public int getOid() {
        if(this.mano==null) return 0;
        return mano.getId();
    }

    @Override
    public void leer(ResultSet rs) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
