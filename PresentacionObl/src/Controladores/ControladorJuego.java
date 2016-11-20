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
    
    public ControladorJuego(Iinicio vistaIni, Partida p) {
        this.vistaInicio = vistaIni;
        this.partida = p;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //CREA UN NEW LOGIN
        if(e.getActionCommand().equals("NEW")){
            
            this.vistaLogin = (ILogin) new Login();
            vistaLogin.inicializar();
            vistaLogin.setControlador(this);
        
            //aca vamos a hacer todo el nuevo login
            System.out.print("hola");
        }
        //LOGIN
        else if(e.getActionCommand().equals("LOGIN")){
            //VALIDAR Y CARGAR USUARIO            
            Usuario unUsu = new Usuario();
            unUsu = unUsu.ValidarUsuario(vistaLogin.getUsuario(), vistaLogin.getContrasena());
            
            //SI EXISTE EL USUARIO
            if(unUsu.getNombre() != null )
            {
                //SI ES JUGADOR
                if (unUsu.getTipo().puedoJugar())
                {
                    if(unUsu.ValidarSaldo(unUsu.getTipo().getSaldo(), this.partida.getApuestaActual())){
                        
                        //partida.setJugador1(unUsu);
                        
                        this.vistaLogin.setVisible(false);
                        this.vistaMesa = new Mesa();
                        vistaMesa.setVisible(true);    
                        vistaMesa.deshabilitarPanelJugador(partida.getTurnoActual());
                        vistaMesa.CargarDatosDelJugador(unUsu);
                        vistaMesa.SetApuestaActual(Double.toString(partida.getApuestaActual()));
                        vistaMesa.setControlador(this);
                        //AGREGA LAS FICHAS DE CADA JUGADOR A LA MESA
                        agregaFichasMesa();
                        agregaFichasMesa2();
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
            Mano nueva = partida.TraeUltimaMano();
            nueva.setMovimiento(new Movimiento(new RecogerFicha(),new Jugador(200)));   //DEBO CARGAR EL JUGADOR DEL TURNO

            partida.getManos().add(nueva);
            
            //AGREGO FICHAS A LA MESA JUGADOR 1
            agregaFichasMesa();
        }
        else if(e.getActionCommand().equals("ADDFICHA2")){            
            partida.AddFichaJugador2(partida.TraeUltimaMano());
            vistaMesa.removeAllMesa2();
            
            //ME GUARDO LA ULTIMA MANO, CREO UNA NUEVA Y LA AGREGO A LA LISTA SETEANDOLE EL TIPO DE MOVIMIENTO
            Mano nueva = partida.TraeUltimaMano();
            nueva.setMovimiento(new Movimiento(new RecogerFicha(),new Jugador(200)));   //DEBO CARGAR EL JUGADOR DEL TURNO

            partida.getManos().add(nueva);
            
            //AGREGO FICHAS A LA MESA JUGADOR 2
            agregaFichasMesa2();
        }
        else if(e.getActionCommand().equals("SubirApuesta"))
        {
            if (vistaMesa.GettxtSubirApuesta() != 0)
            {
                if(this.partida.getJugador1().getTipo().getSaldo() > vistaMesa.GettxtSubirApuesta()
                         && this.partida.getJugador2().getTipo().getSaldo() > vistaMesa.GettxtSubirApuesta() )
                {
                     //ME GUARDO LA ULTIMA MANO, CREO UNA NUEVA Y LA AGREGO A LA LISTA SETEANDOLE EL TIPO DE MOVIMIENTO
                    Mano nueva = partida.TraeUltimaMano();
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
            Mano nueva = partida.TraeUltimaMano();
            nueva.setMovimiento(new Movimiento(new ColocarFicha(),new Jugador(200)));  //DEBO CARGAR EL JUGADOR DEL TURNO

            partida.getManos().add(nueva);
            
            
            String aux = partida.agregarFichaAJugada(nombreficha);
            //SI NO HAY UN GANADOR
            if(aux == "no"){
                vistaMesa.removeAllTablero();            
                //AGREGO FUCHAS A LA MESA DE JUEGO
                agregaFichasTablero();                
                //ACTUALIZO
                vistaMesa.deshabilitarPanelJugador(partida.getTurnoActual());
                vistaMesa.removeAllMesa();
                agregaFichasMesa();
                vistaMesa.removeAllMesa2();
                agregaFichasMesa2();            
            }
            //SI HAY UN GANADOR
            else{
                if(aux == "jugador1"){
                    vistaMesa.ocultarPanelesGanador("Gana Jugador 1");
                }else if(aux == "jugador2"){
                    vistaMesa.ocultarPanelesGanador("Gana Jugador 2");
                }
            }
        }
        
    }

    //ACTUALIZA LAS FICHAS DE LA MESA DE LOS JUGADORES
    public void agregaFichasMesa(){        
        //ArrayList<Ficha> lfichas = partida.GetUltimaMano().getFichasJ1();        
        ArrayList<Ficha> lfichas = partida.TraeUltimaMano().getFichasJ1();
        for(int i = 0; i< lfichas.size(); i++){
            int val1 = lfichas.get(i).getValor1();
            int val2 = lfichas.get(i).getValor2();
            vistaMesa.CargarFichasDelJugador(val1, val2, this);
        }
    } 
    
    //AGREGAR FICHAS A MESA 2
    public void agregaFichasMesa2(){        
        //PARA EL JUGADOR 2
        //ArrayList<Ficha> lfichas2 = partida.GetUltimaMano().getFichasJ2();
        ArrayList<Ficha> lfichas2 = partida.TraeUltimaMano().getFichasJ2();        
        for(int i = 0; i< lfichas2.size(); i++){
            int val1 = lfichas2.get(i).getValor1();
            int val2 = lfichas2.get(i).getValor2();
            vistaMesa.CargarFichasDelJugador2(val1, val2, this);
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

    @Override
    public void update(Observable o, Object arg) {
        System.out.print("paso por aca");
    }
    
}
    
  

