/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import Modelo.Jugador;
import Modelo.Partida;
import Modelo.Usuario;
import Vista.ILogin;
import Vista.IMesa;
import Vista.Mesa;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Laura
 */
public class ControladorSistema implements ActionListener {
    private ILogin vistaLogin;
    private IMesa vistaMesa;
    private Partida partida;

    public ControladorSistema(ILogin vista) {
        
        this.vistaLogin = vista;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getActionCommand().equals("LOGIN"))
        {
            //VALIDAR Y CARGAR USUARIO
            
            Usuario unUsu = new Usuario();
            unUsu = unUsu.ValidarUsuario(vistaLogin.getUsuario(), vistaLogin.getContrasena());
            
            //boolean esValido = unUsu.ValidarUsuario(vistaLogin.getUsuario(), vistaLogin.getContrasena());
            
            if(unUsu!= null)
            {
                //unUsu.setNombre(vistaLogin.getUsuario());
                //vistaLogin.SetErrorMsj("");
                this.vistaLogin.setVisible(false);
                
                this.vistaMesa = new Mesa();
                vistaMesa.setVisible(true);
                vistaMesa.CargarDatosDelJugador(unUsu);
                vistaMesa.CargarFichasDelJugador();
                //vistaMesa.SetNombreUsuario(unUsu.getNomCompleto());
            }
            else
            {
                vistaLogin.SetErrorMsj("Nombre de Usuario o Contraseña Incorrecto");
            }
        }        
        else if(e.getActionCommand().equals("AddFicha"))
        {
            partida.AddFichaJugador(partida.GetTurnoActual());
        }
        // controlador.ControladorSistema controlador;        que era esto???
    }
    
}
