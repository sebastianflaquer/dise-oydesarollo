/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Controladores.ControladorJuego;
import Controladores.Iinicio;
import Fachada.Sistema;
import ModeloPersistente.PartidaPersistente;
import ModeloPersistente.UsuarioPersistente;
import PersistenciaCont.ManejadorBD;
import Usuarios.Admin;
import Usuarios.ITipo;
import Usuarios.Jugador;
import Usuarios.Usuario;
import Vistas.Inicio;

/**
 *
 * @author Mauro
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // TODO code application logic here
        //ManejadorBD.getInstancia().conectar("jdbc:mysql://localhost/dominoschema?user=root&password=root");
        //System.out.println("OK");
        //int oid = ManejadorBD.getInstancia().proximoOid();
        //ManejadorBD.getInstancia().ejecutar("insert into usuario values(" + oid + ",'pepe','pepe')");
        //System.out.println("oid:" + oid);
        //ManejadorBD.getInstancia().ejecutar("insert into usuario values( NULL, 'Juan','Jugador','pass','Juan Perez', 1000)");
        //ManejadorBD.getInstancia().desconectar();        
        
        cargarUsuarios();
        
        
        Iinicio vistaIni = (Iinicio) new Inicio();
        ControladorJuego cont = new ControladorJuego(vistaIni);
        vistaIni.setControlador(cont);
        vistaIni.inicializar();        
        
    }
    
    //CARGAR USUARIOS
    private static void cargarUsuarios() {
        Sistema s = Sistema.GetInstancia();

        s.agregar(new Usuario("juan", (ITipo) new Jugador(1000), "pass" ,"Juan Perez"));
        s.agregar(new Usuario("ana", (ITipo) new Jugador(90), "pass","Ana Gonzalez"));
        s.agregar(new Usuario("luis", (ITipo) new Jugador(900), "pass","Luis Rivero"));
        s.agregar(new Usuario("admin", (ITipo) new Admin(), "pass","Pedro Hernandez"));
    }


}
