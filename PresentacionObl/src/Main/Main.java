/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Controladores.ControladorJuego;
import Controladores.ILogin;
import Usuarios.Admin;
import Usuarios.Jugador;
import Fachada.Sistema;
import Usuarios.Usuario;
import Usuarios.ITipo;
import Vistas.Login;

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
        
        cargarUsuarios();

//        ILogin vista = (ILogin) new Login();
//        ControladorSistema control = new ControladorSistema(vista);
//        
//        vista.inicializar();
//        vista.setControlador(control);

        ILogin vista = (ILogin) new Login();
        ControladorJuego cont = new ControladorJuego(vista);
        vista.inicializar();
        vista.setControlador(cont);
        
        
        
    }
    
    private static void cargarUsuarios() {
        Sistema s = Sistema.GetInstancia();

        s.agregar(new Usuario("nom", (ITipo) new Jugador(100), "pass" ,"Juan perez"));
        s.agregar(new Usuario("nom2", (ITipo) new Jugador(100), "pass2","Ana Gonzalez"));
        s.agregar(new Usuario("admin", (ITipo) new Admin(), "pass","Pedro Hernandez"));
    }
    
}
