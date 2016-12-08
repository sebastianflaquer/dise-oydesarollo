/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloPersistente;

import PersistenciaCont.Persistente;
import Usuarios.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Mauro
 */
public class UsuarioPersistente implements Persistente{
    
    private Usuario usu;
    
    public UsuarioPersistente(Usuario u) {
        this.usu = u;
    }
    
    @Override
    public Persistente crearNuevo() {
        return new UsuarioPersistente(new Usuario());
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
    public ArrayList<String> getInsertSql() {
        ArrayList r = new ArrayList();
        r.add("INSERT INTO usuario(idUsuario,Nombre,TipoJug,Password,nomCompleto,saldo)"
                + "VALUES( null, " + usu.getNombre() + "," + verTipoUsu() + " ,'"
                + usu.getPassword() + "'," + usu.getTipo().getSaldo() + ")");
        return r;
    }
    
    private String verTipoUsu()
    {
        String ret = "Admin";
        double num = this.usu.getTipo().getSaldo();
        if(num != -1)
        {
            ret = "Jugador";
        }
        return ret;
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
    public Object getObjeto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void limpiar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
}
