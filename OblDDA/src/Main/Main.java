/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Modelo.Admin;
import Modelo.Jugador;
import Modelo.Sistema;
import Modelo.Tipo;
import Modelo.Usuario;
import Vista.ILogin;
import Vista.Login;
import controlador.ControladorSistema;

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
        
        //cargarUsuarios();
        
        new Login().setVisible(true);
        
        ILogin vista = (ILogin) new Login();
        ControladorSistema control = new ControladorSistema(vista);
        
        vista.inicializar();
        vista.setControlador(control);
        
        
        
        
    }
    
    private static void cargarUsuarios() {
        Sistema s = Sistema.GetInstancia();

        s.agregar(new Usuario("nom", (Tipo) new Jugador(100), "pass" ,"Juan perez"));
        s.agregar(new Usuario("nom2", (Tipo) new Jugador(100), "pass2","Ana Gonzalez"));
        s.agregar(new Usuario("admin", (Tipo) new Admin(), "pass","Pedro Hernandez"));
    }
    
}
