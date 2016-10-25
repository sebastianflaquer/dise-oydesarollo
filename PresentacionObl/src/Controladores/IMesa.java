/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Usuarios.Usuario;

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
    public void SetNombreUsuario(String nombreUsuario);
    
    public void setVisible(boolean b);  
    
    //CARGAR DATOS DEL JUGADOR A LA MESA
    public void CargarDatosDelJugador(Usuario unUsu);
    
    //CARGAR FICHAS DEL JUGADOR
    public void CargarFichasDelJugador();
    
}
