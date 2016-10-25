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
import Juegos.Ficha;
import Juegos.Partida;
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
        cargarFichas();

//      ILogin vista = (ILogin) new Login();
//      ControladorSistema control = new ControladorSistema(vista);

//      vista.inicializar();
//      vista.setControlador(control);

        ILogin vista = (ILogin) new Login();
        ControladorJuego cont = new ControladorJuego(vista);
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
    private static void cargarFichas() {
        Sistema s = Sistema.GetInstancia();
        //Partida p = Partida.GetInstancia();
        Partida p = new Partida();
        //p.setJugador1(jugador1);
        //p.setJugador2(jugador2);
        s.agregarPartida(p);
        //Sistema s = Sistema.GetInstancia();
        
        //AGREGA LAS FICHAS MEDIANTE UN FOR
        int contador = 0;
        for(int l=0; l<= 6; l++){
            int r = l;
            for(r = l; r <= 6; r++){                
                p.agregarFicha(new Ficha( contador , l, r));                
                contador ++;
            }
        }
          //0
//        p.agregarFicha(new Ficha( 1, 0, 0));
//        p.agregarFicha(new Ficha( 1, 0, 1));
//        p.agregarFicha(new Ficha( 1, 0, 2));
//        p.agregarFicha(new Ficha( 1, 0, 3));
//        p.agregarFicha(new Ficha( 1, 0, 4));
//        p.agregarFicha(new Ficha( 1, 0, 5));
//        p.agregarFicha(new Ficha( 1, 0, 6));
          //1
//        p.agregarFicha(new Ficha( 1, 1, 1));
//        p.agregarFicha(new Ficha( 1, 1, 2));
//        p.agregarFicha(new Ficha( 1, 1, 3));
//        p.agregarFicha(new Ficha( 1, 1, 4));
//        p.agregarFicha(new Ficha( 1, 1, 5));
//        p.agregarFicha(new Ficha( 1, 1, 6));
          //2
//        p.agregarFicha(new Ficha( 1, 2, 2));
//        p.agregarFicha(new Ficha( 1, 2, 3));
//        p.agregarFicha(new Ficha( 1, 2, 4));
//        p.agregarFicha(new Ficha( 1, 2, 5));
//        p.agregarFicha(new Ficha( 1, 2, 6));
          //3
//        p.agregarFicha(new Ficha( 1, 3, 3));
//        p.agregarFicha(new Ficha( 1, 3, 4));
//        p.agregarFicha(new Ficha( 1, 3, 5));
//        p.agregarFicha(new Ficha( 1, 3, 6));
          //4
//        p.agregarFicha(new Ficha( 1, 4, 4));
//        p.agregarFicha(new Ficha( 1, 4, 5));
//        p.agregarFicha(new Ficha( 1, 4, 6));
          //5
//        p.agregarFicha(new Ficha( 1, 5, 5));
//        p.agregarFicha(new Ficha( 1, 5, 6));
          //6 
//        p.agregarFicha(new Ficha( 1, 6, 6));
        
    }
    
    
    
}
