/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Fachada.Sistema;
import Juegos.Apuesta;
import Juegos.ColocarFicha;
import Juegos.Ficha;
import Juegos.Mano;
import Juegos.Movimiento;
import Juegos.Partida;
import Juegos.RecogerFicha;
import Juegos.ITipoMovimiento;
import Usuarios.Jugador;
import Usuarios.Usuario;
import Vistas.Login;
import Vistas.Mesa;
import Vistas.MesaAdmin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Mauro
 */
public class ControladorJuego implements ActionListener, Observer {    
    
    private ILogin vistaLogin;
    private IMesa vistaMesa;
    private Partida partida;
    private IMesaAdmin mesaAdmin;
    private Iinicio vistaInicio;
    private Usuario usu;
       
    
    public ControladorJuego(Iinicio vistaIni) {
        this.vistaInicio = vistaIni;
        //this.partida = Partida.GetInstancia();
    }
    
    public ControladorJuego(IMesa vistaM) {
        this.vistaMesa = vistaM;
        //this.partida = Partida.GetInstancia();
    }
    
//        Sistema s = Sistema.GetInstancia();
//        Partida p = new Partida();
//        s.agregarPartida(p);        
//        p.cargarFichas();
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //CREA UN NEW LOGIN
        if(e.getActionCommand().equals("NEW")){
            
            this.vistaLogin = (ILogin) new Login();
            vistaLogin.inicializar();
            vistaLogin.setControlador(this);
        }
        //LOGIN
        else if(e.getActionCommand().equals("LOGIN")){
            //VALIDAR Y CARGAR USUARIO            
            Usuario unUsu = new Usuario();
            unUsu = unUsu.ValidarUsuario(vistaLogin.getUsuario(), vistaLogin.getContrasena());
            
            //SI EXISTE EL USUARIO
            if(unUsu.getNombre() != null ){
                //SI ES JUGADOR
                if (unUsu.getTipo().puedoJugar())
                {
                    Partida P = new Partida();
                    if(unUsu.ValidarSaldo(unUsu.getTipo().getSaldo(), P.getApuestaActual())){
                        
                        
                        //partida.setJugador1(unUsu);                        
                        this.vistaLogin.setVisible(false);
                        this.vistaMesa = new Mesa();
                        
                        vistaMesa.setVisible(true);
                        ControladorJuego contU = new ControladorJuego(vistaMesa);
                        vistaMesa.setControlador(contU);
                        contU.usu = unUsu;
                        
                        Sistema s = Sistema.GetInstancia();
                        Partida P2 = s.chequeaLugarEnPartida(unUsu);                      
                        if(P2 == null){
                            P.setJugador1(unUsu);
                            unUsu.getTipo().setNumeroJug(1);
                            P.addObserver(contU);
                            P.setEstado("Esperando Jugador");
                            s.agregarPartida(P);
                            vistaMesa.CargarDatosDelJugador(unUsu);
                        }else{
                            if(P2.getJugador2() == null){
                                P2.setEstado("Esperando Jugador");
                                vistaMesa.CargarDatosDelJugador(unUsu);
                            }else{
                                //P.setJugador2(unUsu);
                                P2.setEstado("En Juego");
                                vistaMesa.CargarDatosDelJugador(unUsu);
                                P2.addObserver(contU);
                                P2.InicialPartida();
                                this.partida = P2;
                                //CARGA LA APUESTA ACTUAL
                                vistaMesa.SetApuestaActual(Double.toString(P2.getApuestaActual()));
                                //ACA NO VA PORQUE ES UN EVENTO PARA LOS 3 CONTOLADORES
                                //agregaFichasMesa(P2, contU);
                            }
                        }
                        
                        //vistaMesa.SetApuestaActual(Double.toString(partida.getApuestaActual()));
                        //AGREGA LAS FICHAS DE CADA JUGADOR A LA MESA
                        
                        //agregaFichasMesa2();
                        //vistaMesa.CargarFichasDelJugador();
                        //vistaMesa.SetNombreUsuario(unUsu.getNomCompleto());
                    }
                    else
                    {
                        vistaLogin.SetErrorMsj("Saldo Insuficiente");
                    }
                }
                //SI ES ADMINISTRADOR
                else
                {
                    this.vistaLogin.setVisible(false);
                    this.mesaAdmin = new MesaAdmin();
                    this.mesaAdmin.inicializar();
                    mesaAdmin.setControlador(this);
                    mesaAdmin.cargarDatosAdmin(unUsu);
                }
            }
            else
            {
                vistaLogin.SetErrorMsj("Nombre de Usuario o Contraseña Incorrecto");
            }
        }
        
        //VER MANOS DE LA PARTIDA (MODO ADMIN)
        else if(e.getActionCommand().equals("SALIR")){
            mesaAdmin.CargarManosDePartida();
        }
        
        //VER MANOS DE LA PARTIDA (MODO ADMIN)
        else if(e.getActionCommand().equals("VERMANOS")){
            mesaAdmin.CargarManosDePartida();
        }
        //ADDFICHA
        else if(e.getActionCommand().equals("ADDFICHA")){            
            partida.AddFichaJugador(partida.TraeUltimaMano());
            vistaMesa.removeAllMesa();
            
            //ME GUARDO LA ULTIMA MANO, CREO UNA NUEVA Y LA AGREGO A LA LISTA SETEANDOLE EL TIPO DE MOVIMIENTO
            Mano nueva = partida.GetUltimaMano();
            nueva.setMovimiento(new Movimiento(new RecogerFicha(),new Jugador(200)));   //DEBO CARGAR EL JUGADOR DEL TURNO

            partida.getManos().add(nueva);
            
            //AGREGO FICHAS A LA MESA JUGADOR 1
            agregaFichasMesa(partida, this);
        }
//        else if(e.getActionCommand().equals("ADDFICHA2")){            
//            partida.AddFichaJugador2(partida.TraeUltimaMano());
//            //vistaMesa.removeAllMesa2();
//            
//            //ME GUARDO LA ULTIMA MANO, CREO UNA NUEVA Y LA AGREGO A LA LISTA SETEANDOLE EL TIPO DE MOVIMIENTO
//            Mano nueva = partida.GetUltimaMano();
//            nueva.setMovimiento(new Movimiento(new RecogerFicha(),new Jugador(200)));   //DEBO CARGAR EL JUGADOR DEL TURNO
//
//            partida.getManos().add(nueva);
//            
//            //AGREGO FICHAS A LA MESA JUGADOR 2
//            agregaFichasMesa2();
//        }
        else if(e.getActionCommand().equals("SubirApuesta"))
        {
            if (vistaMesa.GettxtSubirApuesta() != 0)
            {
                if(this.partida.getJugador1().getTipo().getSaldo() > vistaMesa.GettxtSubirApuesta()
                         && this.partida.getJugador2().getTipo().getSaldo() > vistaMesa.GettxtSubirApuesta() )
                {
                     //ME GUARDO LA ULTIMA MANO, CREO UNA NUEVA Y LA AGREGO A LA LISTA SETEANDOLE EL TIPO DE MOVIMIENTO
                    Mano nueva = partida.GetUltimaMano();
                    nueva.setMovimiento(new Movimiento(new Apuesta(vistaMesa.GettxtSubirApuesta()),new Jugador(200)));   //DEBO CARGAR EL JUGADOR DEL TURNO

                    partida.getManos().add(nueva);
                    //SETEO EL NUEVO VALOR EN LA MESA
                    this.partida.setApuestaActual(vistaMesa.GettxtSubirApuesta());
                    vistaMesa.SetApuestaActual(Double.toString(vistaMesa.GettxtSubirApuesta()));
                }
            }
        }
        //BOTONFICHA
        else if(e.getActionCommand().equals(e.getActionCommand())){            
            //AGREGAR FICHA A FICHAS JUGADAS
            //partida.ingresarMovimiento(e);
            String nombreficha = e.getActionCommand();
            
            //ME GUARDO LA ULTIMA MANO, CREO UNA NUEVA Y LA AGREGO A LA LISTA SETEANDOLE EL TIPO DE MOVIMIENTO
            Mano nueva = partida.GetUltimaMano();
            nueva.setMovimiento(new Movimiento(new ColocarFicha(),new Jugador(200)));  //DEBO CARGAR EL JUGADOR DEL TURNO

            partida.getManos().add(nueva);
            
            
            String aux = partida.agregarFichaAJugada(nombreficha);
            //SI NO HAY UN GANADOR
            if(aux == "no"){
                vistaMesa.removeAllTablero();            
                //AGREGO FUCHAS A LA MESA DE JUEGO
                agregaFichasTablero();                
                //ACTUALIZO
//                vistaMesa.deshabilitarPanelJugador(partida.getTurnoActual());
                vistaMesa.removeAllMesa();
                agregaFichasMesa(partida, this);
//              vistaMesa.removeAllMesa2();
                //agregaFichasMesa2(this.partida);            
            }
            //SI HAY UN GANADOR
            else{
                if(aux == "jugador1"){
//                    vistaMesa.ocultarPanelesGanador("Gana Jugador 1");
                }else if(aux == "jugador2"){
//                    vistaMesa.ocultarPanelesGanador("Gana Jugador 2");
                }
            }
        }
        
    }

    //ACTUALIZA LAS FICHAS DE LA MESA DE LOS JUGADORES
    public void agregaFichasMesa(Partida p, ControladorJuego cont){
            if (cont.usu.getNombre().equalsIgnoreCase(p.getJugador1().getNombre()))
            {
                ArrayList<Ficha> lfichas = p.TraeUltimaMano().getFichasJ1();
                    for(int i = 0; i< lfichas.size(); i++){
                    int val1 = lfichas.get(i).getValor1();
                    int val2 = lfichas.get(i).getValor2();
                    vistaMesa.CargarFichasDelJugador(val1, val2, this);
                }                
            }
            else
                {
                ArrayList<Ficha> lfichas2 = p.TraeUltimaMano().getFichasJ2();
                for(int i = 0; i< lfichas2.size(); i++){
                    int val1 = lfichas2.get(i).getValor1();
                    int val2 = lfichas2.get(i).getValor2();
                    vistaMesa.CargarFichasDelJugador(val1, val2, this);
                }
            }
        
        }
    
    //AGREGAR FICHAS A MESA 2
    //public void agregaFichasMesa2(){        
//        //PARA EL JUGADOR 2
//        //ArrayList<Ficha> lfichas2 = partida.GetUltimaMano().getFichasJ2();
//        ArrayList<Ficha> lfichas2 = partida.TraeUltimaMano().getFichasJ2();        
//        for(int i = 0; i< lfichas2.size(); i++){
//            int val1 = lfichas2.get(i).getValor1();
//            int val2 = lfichas2.get(i).getValor2();
////            vistaMesa.CargarFichasDelJugador2(val1, val2, this);
//        }
//    }
    
    //AGREGAR FICHAS A TABLERO
    public void agregaFichasTablero(){ 
        ArrayList<Ficha> listaFJ = partida.TraeUltimaMano().getFichasJugadas();
        for(int i = 0; i< listaFJ.size(); i++){
            int val1 = listaFJ.get(i).getValor1();
            int val2 = listaFJ.get(i).getValor2();
            vistaMesa.CargarFichasAlTablero(val1, val2, this);
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.print("paso por aca");
        
        //agregaFichasMesa(partida);
        //Actualizar fichas del mazo
        //actualizar fichas de cada jugador
        //actualizar fichas del tablero
        
    }
    
}
    
  

