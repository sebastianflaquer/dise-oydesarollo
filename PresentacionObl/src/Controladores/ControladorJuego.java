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
                        vistaMesa.ocultarPanelApuesta();
                        vistaMesa.SetApuestaActual(Double.toString(P.getApuestaActual()));
                        contU.usu = unUsu;    
                        
                        Sistema s = Sistema.GetInstancia();
                        Partida P2 = s.chequeaLugarEnPartida(unUsu);
                        
                        //SI ES UNA PARTIDA VACIA
                        if(P2 == null){
                            P.setJugador1(unUsu);
                            P.setTurnoActualJugador(unUsu);
                            //unUsu.getTipo().setNumeroJug(1);
                            P.addObserver(contU);
                            P.setEstado("Esperando Jugador");
                            this.partida = P;
                            s.agregarPartida(P);
                            vistaMesa.CargarDatosDelJugador(unUsu);
                        }else{ //SI YA TIENE UN JUGADOR
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
                                
                                
                                //PRUEBA HILOS
                                this.partida.Iniciar();

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
        //SI ACEPTA LA APUESTA
        else if(e.getActionCommand().equals("ACEPTARAPUESTA")){            
            
            this.vistaMesa.ocultarPanelApuesta();
            double NApuesta = this.partida.TraeUltimaMano().getMovimiento().getTipoMov().montoApuesta();
            
            //si el otro jugador acepta            
            this.partida.setApuestaActual(NApuesta);
            vistaMesa.SetApuestaActual(Double.toString(NApuesta));
            this.partida.NotificarAccion("SubirApuesta","");
        }
        //SI CANCELA LA APUESTA
        else if(e.getActionCommand().equals("CANCELARAPUESTA")){
            
            this.vistaMesa.ocultarPanelApuesta();
            if(partida.getTurnoActualJugador() == partida.getJugador1()){
                this.partida.NotificarAccion("GanaJugador","Gana Jugador 1");
            }else if(partida.getTurnoActualJugador() == partida.getJugador1()){
                this.partida.NotificarAccion("GanaJugador","Gana Jugador 2");
            }
            
        }
        //ADDFICHA - FUNCIONA
        else if(e.getActionCommand().equals("ADDFICHA")){            
            boolean agrego = partida.AddFichaJugador(partida.TraeUltimaMano());
            if(agrego){
                vistaMesa.removeAllMesa();
                //ME GUARDO LA ULTIMA MANO, CREO UNA NUEVA Y LA AGREGO A LA LISTA SETEANDOLE EL TIPO DE MOVIMIENTO
                Mano nueva = partida.GetUltimaMano();
                nueva.setMovimiento(new Movimiento(new RecogerFicha(),this.partida.getTurnoActualJugador()));   //DEBO CARGAR EL JUGADOR DEL TURNO
                partida.getManos().add(nueva);            
                //AGREGO FICHAS A LA MESA JUGADOR 1
                agregaFichasMesa(partida,this.usu.getNombre());                
            }else{
                if(partida.getTurnoActualJugador() == partida.getJugador1()){
                    this.partida.NotificarAccion("GanaJugador","Gana Jugador 2");
                }else if(partida.getTurnoActualJugador() == partida.getJugador1()){
                    this.partida.NotificarAccion("GanaJugador","Gana Jugador 1");
                }
            }
        }
        
        //SUBIR APUESTA
        else if(e.getActionCommand().equals("SubirApuesta")){
            
            double nApuesta = vistaMesa.GettxtSubirApuesta();
            double suma = nApuesta + this.partida.getApuestaActual();
            //CHEKEA SI EL VALOR ES VALIDO
            if(nApuesta != -1){
                //CHEQUEA SI ES DISTINTO A CERO
                if (nApuesta > 0){
                    //SI LOS SALDOS DE LAS 2 PERSONAS SON MAYORES Y SI ES MAYOR A LA PUESTA ACTUAL
                    if(this.partida.getJugador1().getTipo().getSaldo() >= suma && this.partida.getJugador2().getTipo().getSaldo() >= suma){
                        
                        //ME GUARDO LA ULTIMA MANO, CREO UNA NUEVA Y LA AGREGO A LA LISTA SETEANDOLE EL TIPO DE MOVIMIENTO
                        Mano nueva = partida.GetUltimaMano();
                        nueva.setMovimiento(new Movimiento(new Apuesta(suma),this.partida.getTurnoActualJugador()));   //DEBO CARGAR EL JUGADOR DEL TURNO
                        partida.getManos().add(nueva);
                        
                        //muestra el panel a el otro jugador
                        this.partida.NotificarAccion("MostrasApuesta", Double.toString(suma));                        
                    }else{
                        this.vistaMesa.ErrorMensajeApuesta("La apuesta no puede ser mayo al saldo");
                        //MOSTRAR MENSAJE DE QUE EL MONTO ES MUY ALTO
                    }
                }
            }
        }
        
        //BOTONFICHA
        else if(e.getActionCommand().equals(e.getActionCommand())){
            
            //AGREGAR FICHA A FICHAS JUGADAS
            String nombreficha = e.getActionCommand();
            
            String aux = this.partida.agregarFichaAJugada(nombreficha);
            //SI NO HAY UN GANADOR
            if(aux != "noagrego"){
                //ME GUARDO LA ULTIMA MANO, CREO UNA NUEVA Y LA AGREGO A LA LISTA SETEANDOLE EL TIPO DE MOVIMIENTO
                Mano nueva = this.partida.GetUltimaMano();
                nueva.setMovimiento(new Movimiento(new ColocarFicha(),this.partida.getTurnoActualJugador()));  //DEBO CARGAR EL JUGADOR DEL TURNO
                this.partida.getManos().add(nueva);
                
                if(aux == "no"){
                    this.partida.NotificarAccion("BotonFicha",nombreficha);
                }
                //SI HAY UN GANADOR
                else{
                    if(aux == "jugador1"){
                        this.partida.NotificarAccion("GanaJugador","Gana Jugador 1");
                        //vistaMesa.ocultarPanelesGanador("");
                    }else if(aux == "jugador2"){
                        this.partida.NotificarAccion("GanaJugador","Gana Jugador 2");
                        //vistaMesa.ocultarPanelesGanador("");
                    }
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
        agregaFichasTablero();
        //3 - SACA LAS FICHAS DEL LA MESA DEL JUGADOR
        agregaFichasMesa(p,this.usu.getNombre());
    }
    
    //MOSTRAR PANEL APUESTA
    public void mostrarPanelApuesta(double Valor){
        //SI ES EL QUE APOSTO
        if(this.usu.getNombre().equalsIgnoreCase(this.partida.getTurnoActualJugador().getNombre())){
            this.vistaMesa.mostrarPanelEspera();
        }//SI ES EL QUE RECIBE LA APUESTA
        else{
            this.vistaMesa.mostrarPanelApuesta(Valor);
        }
    }
    
    @Override
    public void update(Observable o, Object arg) {        
        //esto lo hace 2 veces, 1 para cada controlador
        Mensaje msg = (Mensaje)arg;
        this.partida = (Partida) o;
        
        //CUENTA REGRESIVA
        System.out.println(Integer.toString(this.partida.getRegrasivaTurno()));
        
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
            vistaMesa.SetApuestaActual(Double.toString(this.partida.getApuestaActual()));
        }
        //MOSTRAR PANEL APUESTA
        else if(msg.getAccion().equalsIgnoreCase("MostrasApuesta")){
            mostrarPanelApuesta(Double.parseDouble(msg.getValor()));
            //vistaMesa.mostrarPanelApuesta((Partida) o, this.partida.getTurnoActualJugador());
        }
        //GANA JUGADOR
        else if(msg.getAccion().equalsIgnoreCase("GanaJugador")){
            vistaMesa.ocultarPanelesGanador(msg.getValor());
        }
        else{
            System.out.print("Ultimo Else.");
        }
    }
}
    
  

