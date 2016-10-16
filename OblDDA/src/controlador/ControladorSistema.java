/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import Modelo.Usuario;
import Vista.ILogin;
import Vista.Login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Laura
 */
public class ControladorSistema implements ActionListener {
    private ILogin vista;

    public ControladorSistema(ILogin vista) {
        
        this.vista = vista;        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getActionCommand().equals("LOGIN"))
        {
            //proceos el login            
            Usuario unUsu = new Usuario();
            boolean esValido = unUsu.ValidarUsuario( vista.getUsuario(), vista.getContrasena());
            
            if (esValido == true)
            {
                vista.SetErrorMsj("Esto es un error");
                this.vista.setVisible(false);
            }
        }
        controlador.ControladorSistema controlador;
    }
    
}
