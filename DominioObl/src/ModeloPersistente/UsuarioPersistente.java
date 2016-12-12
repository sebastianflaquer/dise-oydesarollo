/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloPersistente;

import PersistenciaCont.Persistente;
import Usuarios.Admin;
import Usuarios.Jugador;
import Usuarios.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Mauro
 */
public class UsuarioPersistente implements Persistente {

    private Usuario usu;

    public UsuarioPersistente(Usuario u) {
        this.usu = u;
    }

    @Override
    public String getSelectSql() {
        String r = "SELECT * from usuarios";
        if (usu.getNombre() != null) {
            r += " WHERE nombre=" + usu.getNombre();
        }
        return r;
    }

    public String getSelectSqlValidar() {
        return "SELECT * from usuarios WHERE nombre='" + usu.getNombre() + "' and password='" + usu.getPassword() + "'";
    }

    @Override
    public ArrayList<String> getInsertSql() {
        ArrayList r = new ArrayList();
        r.add("INSERT INTO usuario(idUsuario,Nombre,TipoJug,Password,nomCompleto,saldo)"
                + "VALUES( null, " + usu.getNombre() + "," + verTipoUsu() + " ,'"
                + usu.getPassword() + "'," + usu.getTipo().getSaldo() + ")");
        return r;
    }

    private String verTipoUsu() {
        String ret = "Admin";
        double num = this.usu.getTipo().getSaldo();
        if (num != -1) {
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
        boolean ok = false;
        while (rs.first() && !ok) {
            usu.setId(Integer.parseInt(rs.getString(1)));
            usu.setNomCompleto(rs.getString(5));
            usu.setNombre(rs.getString(2));
            usu.setPassword(rs.getString(4));
            if (rs.getString(3).equalsIgnoreCase("Jugador")) {
                usu.setTipo(new Jugador(Double.parseDouble(rs.getString(6))));
            } else {
                usu.setTipo(new Admin());
            }
            ok = true;
        }
    }
}
