/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PersistenciaCont;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Mauro
 */
public interface Persistente {
    
    public ArrayList<String> getInsertSql();
    public void setOid(int oid);
    public String getSelectSql();
    public int getOid();
    public void leer(ResultSet rs) throws SQLException;
    
}
