/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import Modelo.Usuario;
import Vista.ILogin;
import Vista.IMesa;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Laura
 */
public class ControladorSistema implements ActionListener {
    private ILogin vistaLogin;
    private IMesa vistaMesa;

    public ControladorSistema(ILogin vista) {
        
        this.vistaLogin = vista;        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getActionCommand().equals("LOGIN"))
        {
            //proceos el login            
            Usuario unUsu = new Usuario();
            boolean esValido = unUsu.ValidarUsuario(vistaLogin.getUsuario(), vistaLogin.getContrasena());
            if (esValido = true)
            {
                vistaLogin.SetErrorMsj("vpe");
                // this.vista.setVisible(false);
                vistaMesa.inicializar();
            }
            else
            {
                vistaLogin.SetErrorMsj("Error!!");
            }
        }
        // controlador.ControladorSistema controlador;        que era esto???
    }
    
}
