/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PersistenciaCont;
import java.sql.*;

/**
 *
 * @author Mauro
 */
public class ManejadorBD {    
    
    private Connection conexion;
        
    private static ManejadorBD instancia;

    public static ManejadorBD getInstancia() {
	if (instancia == null){
            instancia = new ManejadorBD();
	}
	return instancia;
    }
    
    public void conectar(String url) {
        try {
            conexion = DriverManager.getConnection(url);
        } catch (SQLException e1) {
            System.out.println("Error de conexión:" + e1.getMessage());
        }
    }

    public void desconectar() {
        try {
            conexion.close();
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión.");
        }
    }
    
    public void ejecutar(String sql) {
        try {
            Statement st = conexion.createStatement();
            st.executeUpdate(sql);
            st.close();
        } catch (SQLException e) {
            System.out.println("Error al ejecutar sql:\n" + sql + "\n" + e.getMessage());
        }
    }

    public ResultSet obtenerResultSet(String sql) {
        ResultSet rs = null;
        try {
            Statement st = conexion.createStatement();
            rs = st.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println("Error al ejecutar sql:\n" + sql + "\n" + e.getMessage());
        }
        return rs;
    }

    
    public int proximoOid() {
        int oid=0;
        try {
            String sql = "SELECT valor FROM parametro WHERE nombre='oid'";
            ResultSet rs = this.obtenerResultSet(sql);
            if (rs.next()) {
                oid=rs.getInt("valor");
            }
            rs.close();
            oid++;
            this.ejecutar("UPDATE parametro set valor=" + oid + " WHERE nombre='oid'");
        } catch (SQLException e) {
                System.out.println("Error al obtener el proximo oid." + e.getMessage());
        }
        return oid;
    }
    
    public int proximoIdMano() {
        int mid=0;
        try {
            String sql = "SELECT valor FROM parametro WHERE nombre='mid'";
            ResultSet rs = this.obtenerResultSet(sql);
            if (rs.next()) {
                mid=rs.getInt("valor");
            }
            rs.close();
            mid++;
            this.ejecutar("UPDATE parametro set valor=" + mid + " WHERE nombre='mid'");
        } catch (SQLException e) {
                System.out.println("Error al obtener el proximo mid." + e.getMessage());
        }
        return mid;
    }
}
