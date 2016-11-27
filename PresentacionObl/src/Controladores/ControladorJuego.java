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
import Juegos.Mensaje;
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
                            P.setTurnoActualJugador(unUsu);
                            //unUsu.getTipo().setNumeroJug(1);
                            P.addObserver(contU);
                            P.setEstado("Esperando Jugador");
                            this.partida = P;
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
                                this.partida = P2;
                                P2.addObserver(contU);
                                contU.partida = this.partida;
                                int d = P2.countObservers();
                                P2.InicialPartida();                                
                                //CARGA LA APUESTA ACTUAL
                                vistaMesa.SetApuestaActual(Double.toString(P2.getApuestaActual()));
                                //ACA NO VA PORQUE ES UN EVENTO PARA LOS 3 CONTOLADORES                                
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
        
        //VER MANOS DE LA PARTIDA (MODO ADMIN) //MODO ADMINISTRADOR
        else if(e.getActionCommand().equals("SALIR")){
            mesaAdmin.CargarManosDePartida();
        }
        
        //VER MANOS DE LA PARTIDA (MODO ADMIN) //MODO ADMINISTRADOR
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
            //agregaFichasMesa(partida, this);
        }
        
        //SUBIR APUESTA
        else if(e.getActionCommand().equals("SubirApuesta")){
            
            if (vistaMesa.GettxtSubirApuesta() != 0){
                if(this.partida.getJugador1().getTipo().getSaldo() > vistaMesa.GettxtSubirApuesta() && 
                   this.partida.getJugador2().getTipo().getSaldo() > vistaMesa.GettxtSubirApuesta()){
                    
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
            Mano nueva = this.partida.GetUltimaMano();
            nueva.setMovimiento(new Movimiento(new ColocarFicha(),new Jugador(200)));  //DEBO CARGAR EL JUGADOR DEL TURNO
            this.partida.getManos().add(nueva);
            
            String aux = this.partida.agregarFichaAJugada(nombreficha);
            //SI NO HAY UN GANADOR
            if(aux == "no"){
                this.partida.NotificarAccion("BotonFicha",nombreficha);
            }
            //SI HAY UN GANADOR
            else{
                if(aux == "jugador1"){
    //              vistaMesa.ocultarPanelesGanador("Gana Jugador 1");
                }else if(aux == "jugador2"){
    //              vistaMesa.ocultarPanelesGanador("Gana Jugador 2");
                }
            }
            
        }
    }

    //AGREGAR FICHAS A TABLERO
    public void agregaFichasTablero(){ 
        ArrayList<Ficha> listaFJ = partida.TraeUltimaMano().getFichasJugadas();
        for(int i = 0; i< listaFJ.size(); i++){
            int val1 = listaFJ.get(i).getValor1();
            int val2 = listaFJ.get(i).getValor2();
            vistaMesa.CargarFichasAlTablero(val1, val2, this);
        }
    }
    
    //ACTUALIZA LAS FICHAS DE LA MESA DE LOS JUGADORES
    public void agregaFichasMesa(Partida p, String nombreJug ){        
        
        if(nombreJug == null || nombreJug == ""){
            nombreJug = this.usu.getNombre();
        }
        
        //si el nombre es igual
        if (nombreJug.equalsIgnoreCase(p.getJugador1().getNombre())){
            ArrayList<Ficha> lfichas = p.TraeUltimaMano().getFichasJ1();
            for(int i = 0; i< lfichas.size(); i++){
                int val1 = lfichas.get(i).getValor1();
                int val2 = lfichas.get(i).getValor2();
                vistaMesa.CargarFichasDelJugador(val1, val2, this);
            }                
        }
        //si es el otro jugador
        else if(nombreJug.equalsIgnoreCase(p.getJugador2().getNombre())){
            ArrayList<Ficha> lfichas2 = p.TraeUltimaMano().getFichasJ2();
            for(int i = 0; i< lfichas2.size(); i++){
                int val1 = lfichas2.get(i).getValor1();
                int val2 = lfichas2.get(i).getValor2();
                vistaMesa.CargarFichasDelJugador(val1, val2, this);
            }
        }
        
        //OCULTA Y MUESTRA LOS PANELES DE LOS 2 JUGADORES
        vistaMesa.deshabilitarPanelJugador(partida.getTurnoActualJugador(), this.usu);
    }
    
    public void BotonFicha(Partida p, String nombreficha){        
        //ELIMINA LAS FICHAS DEL DE JUEGO
        vistaMesa.removeAllTablero();
        //ELIMINA FICHAS DEL JUGADOR
        vistaMesa.removeAllMesa();
        agregaFichasMesa(p,this.usu.getNombre());
        
        //AGREGO FUCHAS A LA MESA DE JUEGO        
        //ACTUALIZO        
        //AGREGA LAS FICHAS A LA MESA
              
    }
    
    //CARGA AL USUARIO DEL CONTROLADOR EL TURNO ACTUAL
//    public void CargarTurnoActual(){
//        int turnoactual = this.partida.getTurnoActual();        
//        if(turnoactual == 1){
//            this.usu = this.partida.getJugador1();
//        }else if(turnoactual == 2){
//            this.usu = this.partida.getJugador1();
//       }
//   }
    
    public void manejaTurno(){
        //HABILITA PANELES DEL TURNO ACTUAL Y CONTROLA
        
    
    }   

    @Override
    public void update(Observable o, Object arg) {        
        //esto lo hace 2 veces, 1 para cada controlador
        Mensaje msg = (Mensaje)arg;
        
        this.partida = (Partida) o;
        //AGREGAR FICHA MESA
        if(msg.getAccion().equalsIgnoreCase("AgregarFichasMesa")){
            agregaFichasMesa((Partida) o, msg.getValor());
        }
        //BOTON FICHA
        else if(msg.getAccion().equalsIgnoreCase("BotonFicha")){
            //
            BotonFicha((Partida) o, msg.getValor());
        }
        //SUBIR APUESTA
        else if(msg.getAccion().equalsIgnoreCase("SubirApuesta")){
            //SubirApuesta((Partida) o, msg.getValor());
        }
        //ADD FICHA
        else if(msg.getAccion().equalsIgnoreCase("AddFicha")){
            //AddFicha((Partida) o, msg.getValor());
        }
        else{
            System.out.print("Ultimo Else.");
        }
        
        //Actualizar fichas del mazo
        //actualizar fichas de cada jugador
        //actualizar fichas del tablero
        
    }
    
}
    
  

