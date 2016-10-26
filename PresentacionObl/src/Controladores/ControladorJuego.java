/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Fachada.Sistema;
import Juegos.Ficha;
import Juegos.Partida;
import Usuarios.Usuario;
import Vistas.Mesa;
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

    
    public ControladorJuego(ILogin vistaLog, Partida p) {
        this.vistaLogin = vistaLog;
        this.partida = p;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //LOGIN
        if(e.getActionCommand().equals("LOGIN")){
            //VALIDAR Y CARGAR USUARIO            
            Usuario unUsu = new Usuario();
            unUsu = unUsu.ValidarUsuario(vistaLogin.getUsuario(), vistaLogin.getContrasena());
            
            if(unUsu.getNombre() != null )
            {
                this.vistaLogin.setVisible(false);
                
                this.vistaMesa = new Mesa();
                vistaMesa.setVisible(true);    
                vistaMesa.deshabilitarPanelJugador(partida.getTurnoActual());
                
                vistaMesa.CargarDatosDelJugador(unUsu);
                vistaMesa.setControlador(this);
                //AGREGA LAS FICHAS DE CADA JUGADOR A LA MESA
                agregaFichasMesa();
                agregaFichasMesa2();
                
                //vistaMesa.CargarFichasDelJugador();
                //vistaMesa.SetNombreUsuario(unUsu.getNomCompleto());
            }
            else
            {
                vistaLogin.SetErrorMsj("Nombre de Usuario o Contraseña Incorrecto");
            }
        }        
        //ADDFICHA
        else if(e.getActionCommand().equals("ADDFICHA")){            
            partida.AddFichaJugador(partida.GetUltimaMano());
            vistaMesa.removeAllMesa();
            agregaFichasMesa();
        }
        else if(e.getActionCommand().equals("ADDFICHA2")){            
            partida.AddFichaJugador2(partida.GetUltimaMano());
            vistaMesa.removeAllMesa2();
            agregaFichasMesa2();
        }
        //BOTONFICHA
        else if(e.getActionCommand().equals(e.getActionCommand())){            
            //AGREGAR FICHA A FICHAS JUGADAS
            //partida.ingresarMovimiento(e);
            String nombreficha = e.getActionCommand();
            partida.agregarFichaAJugada(nombreficha);
            vistaMesa.removeAllTablero();
            agregaFichasTablero();
            
            vistaMesa.deshabilitarPanelJugador(partida.getTurnoActual());
            vistaMesa.removeAllMesa();
            agregaFichasMesa();
            
            vistaMesa.removeAllMesa2();
            agregaFichasMesa2();
        }        
    }

    //ACTUALIZA LAS FICHAS DE LA MESA DE LOS JUGADORES
    public void agregaFichasMesa(){        
        ArrayList<Ficha> lfichas = partida.GetUltimaMano().getFichasJ1();        
        for(int i = 0; i< lfichas.size(); i++){
            int val1 = lfichas.get(i).getValor1();
            int val2 = lfichas.get(i).getValor2();
            vistaMesa.CargarFichasDelJugador(val1, val2, this);
        }
    }    
    
    public void agregaFichasMesa2(){        
        //PARA EL JUGADOR 2
        ArrayList<Ficha> lfichas2 = partida.GetUltimaMano().getFichasJ2();        
        for(int i = 0; i< lfichas2.size(); i++){
            int val1 = lfichas2.get(i).getValor1();
            int val2 = lfichas2.get(i).getValor2();
            vistaMesa.CargarFichasDelJugador2(val1, val2, this);
        }
    }
    
    public void agregaFichasTablero(){ 
        ArrayList<Ficha> listaFJ = partida.GetUltimaMano().getFichasJugadas();
        for(int i = 0; i< listaFJ.size(); i++){
            int val1 = listaFJ.get(i).getValor1();
            int val2 = listaFJ.get(i).getValor2();
            vistaMesa.CargarFichasAlTablero(val1, val2, this);
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
    
  

