/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Controladores.ControladorJuego;
import Controladores.ILogin;
import Controladores.Iinicio;
import Fachada.Sistema;
import Juegos.Apuesta;
import Juegos.Ficha;
import Juegos.Mano;
import Juegos.Movimiento;
import Juegos.Partida;
import Juegos.RecogerFicha;
import PersistenciaCont.ManejadorBD;
import Usuarios.Admin;
import Usuarios.ITipo;
import Usuarios.Jugador;
import Usuarios.Usuario;
import Vistas.Inicio;
import Vistas.Login;
import java.util.ArrayList;

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
        //cargarPartidasDePrueba();
        
        Iinicio vistaIni = (Iinicio) new Inicio();
        ControladorJuego cont = new ControladorJuego(vistaIni);
        vistaIni.setControlador(cont);
        vistaIni.inicializar();        

//      ILogin vista = (ILogin) new Login();
//      ControladorJuego cont = new ControladorJuego(vista,p);
//      vista.inicializar();
//      vista.setControlador(cont);
//      p.setJugador1(s.getUsuarios().get(1).getTipo().);
        
    }
    
    //CARGAR USUARIOS
    private static void cargarUsuarios() {
        Sistema s = Sistema.GetInstancia();

        s.agregar(new Usuario("juan", (ITipo) new Jugador(1000), "pass" ,"Juan Perez"));
        s.agregar(new Usuario("ana", (ITipo) new Jugador(90), "pass","Ana Gonzalez"));
        s.agregar(new Usuario("luis", (ITipo) new Jugador(900), "pass","Luis Rivero"));
        s.agregar(new Usuario("admin", (ITipo) new Admin(), "pass","Pedro Hernandez"));
    }
    
    //CARGA LAS FICHAS A LA PARTIDA
//    private static void cargarFichas(Partida p) {
//        
//        //Sistema s = Sistema.GetInstancia();
//        //CREA LA PRIMER MANO Y LA AGREGA EN LA LISTA
//        Mano m = new Mano();
//        //SE TOMA COMO QUE EL PRIMER MOVIMIENTO ES "RECOGER FICHA" 
//        m.setMovimiento(new Movimiento(new RecogerFicha(),new Jugador(200)));
//        p.agregarMano(m);
//        
//        //AGREGA LAS FICHAS AL MAZO
//        String conts = "";        
//        for(int l=0; l<= 6; l++){
//            int r = l;
//            for(r = l; r <= 6; r++){
//                conts = Integer.toString(l) + Integer.toString(r); 
//                int intCont = Integer.parseInt(conts);
//                p.agregarFicha(new Ficha( intCont, l, r));
//            }
//        }
//        //INICIA LA PARTIDA 
//        p.InicialPartida();        
//    }
    
    
    private static void cargarPartidasDePrueba() {
        Sistema s = Sistema.GetInstancia();
        
        Partida unaP = new Partida();
        ArrayList<Mano> nueva = new ArrayList<Mano>();
        Mano m = new Mano();
        m.setMovimiento(new Movimiento(new Apuesta(1500),unaP.getTurnoActualJugador()));
        nueva.add(m);
        nueva.add(m);
        unaP.setManos(nueva);
        Partida otraP = new Partida();
        otraP.setManos(nueva);

        s.agregarPartida(unaP);
        s.agregarPartida(otraP);

    }
}
