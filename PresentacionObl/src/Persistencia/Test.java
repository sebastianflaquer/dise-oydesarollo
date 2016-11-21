/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author docenteFI
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ManejadorBD.getInstancia().conectar("jdbc:mysql://localhost/prueba?user=root&password=root");
        System.out.println("OK");
        int oid = ManejadorBD.getInstancia().proximoOid();
        ManejadorBD.getInstancia().ejecutar("insert into usuario values(" + oid + ",'pepe','pepe')");
        System.out.println("oid:" + oid);
        ManejadorBD.getInstancia().desconectar();
        
        
    }
    
}
