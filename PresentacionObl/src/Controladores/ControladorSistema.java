/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import Usuarios.Jugador;
import Juegos.Partida;
import Usuarios.Usuario;
import Vistas.Mesa;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 




public class ControladorSistema implements ActionListener {

    
    private ILogin vistaLogin;
    private IMesa vistaMesa;
    private Partida partida;

//    public ControladorSistema(ILogin vista) {
//        this.vistaLogin = vista;        
//    }
    
    public ControladorSistema(ILogin vistaLog) {
        this.vistaLogin = vistaLog;
    }
   

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getActionCommand().equals("LOGIN"))
        {
            //proceos el login            
            Usuario unUsu = new Usuario();
            boolean esValido = unUsu.ValidarUsuario(vistaLogin.getUsuario(), vistaLogin.getContrasena());
            if (esValido == true)
            {
                unUsu.setNombre(vistaLogin.getUsuario());
                vistaLogin.SetErrorMsj("vpe");
                this.vistaLogin.setVisible(false);
                
                this.vistaMesa = new Mesa();
                vistaMesa.setVisible(true);
                vistaMesa.SetNombreUsuario(unUsu.getNombre());
            }
            else
            {
                vistaLogin.SetErrorMsj("Error!!");
            }
        }        
        else if(e.getActionCommand().equals("AddFicha"))
        {
            partida.AddFicha(partida.GetTurnoActual());
        }
        // controlador.ControladorSistema controlador;        que era esto???
    }
    
}
