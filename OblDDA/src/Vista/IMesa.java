/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Usuario;
import controlador.ControladorSistema;
/**
 *
 * @author Mauro
 */
public interface IMesa {
    
    void setControlador(ControladorSistema  c);    
    void inicializar();
    
    public void SetErrorMsj(String mensaje);
    public void SetNombreUsuario(String nombreUsuario);
    public void setVisible(boolean b);
    
    //CARGAR DATOS DEL JUGADOR A LA MESA
    public void CargarDatosDelJugador(Usuario unUsu);
    
    //CARGAR FICHAS DEL JUGADOR
    public void CargarFichasDelJugador();
    
}
