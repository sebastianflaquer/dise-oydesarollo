/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Controladores.ControladorJuego;
import Controladores.ILogin;
import Fachada.Sistema;
import Juegos.Ficha;
import Juegos.Mano;
import Juegos.Partida;
import Usuarios.Admin;
import Usuarios.ITipo;
import Usuarios.Jugador;
import Usuarios.Usuario;
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
        
        cargarUsuarios();
        
        Sistema s = Sistema.GetInstancia();
        Partida p = new Partida();
        s.agregarPartida(p);
        
        cargarFichas(p);

        ILogin vista = (ILogin) new Login();

        ControladorJuego cont = new ControladorJuego(vista,p);
        vista.inicializar();
        vista.setControlador(cont);
        
    }
    
    //CARGAR USUARIOS
    private static void cargarUsuarios() {
        Sistema s = Sistema.GetInstancia();

        s.agregar(new Usuario("juan", (ITipo) new Jugador(1000), "pass" ,"Juan perez"));
        s.agregar(new Usuario("ana", (ITipo) new Jugador(2500), "pass","Ana Gonzalez"));
        s.agregar(new Usuario("admin", (ITipo) new Admin(), "pass","Pedro Hernandez"));
    }
    
    //CARGA LAS FICHAS A LA PARTIDA
    private static void cargarFichas(Partida p) {
        
        //Sistema s = Sistema.GetInstancia();
        //CREA LA PRIMER MANO Y LA AGREGA EN LA LISTA
        Mano m = new Mano();
        p.agregarMano(m);
        
        //AGREGA LAS FICHAS AL MAZO
        String conts = "";        
        for(int l=0; l<= 6; l++){
            int r = l;
            for(r = l; r <= 6; r++){
                conts = Integer.toString(l) + Integer.toString(r); 
                int intCont = Integer.parseInt(conts);
                p.agregarFicha(new Ficha( intCont, l, r));
            }
        }
        //INICIA LA PARTIDA 
        p.InicialPartida();
        
    }
}
