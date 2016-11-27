/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Usuarios.Usuario;
import javax.swing.JPanel;

/**
 *
 * @author Mauro
 */
public interface IMesa {
    
    public void setControlador(ControladorJuego  c);    
    public void inicializar();
    
    //public String getUsuario();
    //public String getContrasena();    
    public void SetErrorMsj(String mensaje);
    public void SetApuestaActual(String mensaje);
    public void SetNombreUsuario(String nombreUsuario);
    public double GettxtSubirApuesta();
    
    public void setVisible(boolean b);  
    
    //CARGAR DATOS DEL JUGADOR A LA MESA
    public void CargarDatosDelJugador(Usuario unUsu);
    public void CargarFichasDelJugador(int val1, int val2, ControladorJuego c);    
    //PARA EL SEGUNDO JUGADOR
//    public void CargarFichasDelJugador2(int val1, int val2, ControladorJuego c);
    
    //REMOVE ALL MESA
    public void removeAllMesa();
//    public void removeAllMesa2();    
    public void removeAllTablero();    
    public void CargarFichasAlTablero(int val1, int val2, ControladorJuego c);
    public void deshabilitarPanelJugador(Usuario UsuarioTurnoActual, Usuario unUsu);
//    public void deshabilitarPanelJugador (int turno);

//    public void ocultarPanelesGanador(String jugador);
    
    
}
