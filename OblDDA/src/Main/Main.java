/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Modelo.Admin;
import Modelo.Ficha;
import Modelo.Jugador;
import Modelo.Partida;
import Modelo.Sistema;
import Modelo.Tipo;
import Modelo.Usuario;
import Vista.ILogin;
import Vista.IMesa;
import Vista.Login;
import Vista.Mesa;
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
        
        cargarUsuarios();
        cargarFichas();
        //new Login().setVisible(true);
        
        ILogin vista = (ILogin) new Login();
        ControladorSistema control = new ControladorSistema(vista);
        
        vista.inicializar();
        vista.setControlador(control);
                
        //new Mesa().setVisible(true);
                
    }
    
    //CARGA LOS USUARIOS AL SISTEMA
    private static void cargarUsuarios() {
        Sistema s = Sistema.GetInstancia();

        s.agregar(new Usuario("juan", (Tipo) new Jugador(1000), "pass" ,"Juan perez"));
        s.agregar(new Usuario("ana", (Tipo) new Jugador(25000), "pass","Ana Gonzalez"));
        s.agregar(new Usuario("admin", (Tipo) new Admin(), "pass","Pedro Hernandez"));
    }
    
    //CARGA LAS FICHAS A LA PARTIDA
    private static void cargarFichas() {
        Partida p = Partida.GetInstancia();
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
