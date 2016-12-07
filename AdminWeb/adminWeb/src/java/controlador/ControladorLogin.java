/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.Modelo;

/**
 *
 * @author Dario
 */
import Fachada.Sistema;
import Usuarios.Usuario;
public class ControladorLogin {
    
    private Sistema s = Sistema.GetInstancia();    
    private Modelo modelo = Modelo.getInstancia();
    private VistaLogin vista;
    private Usuario usuario;

    public ControladorLogin(VistaLogin vista) {
        this.vista = vista;
    }
    public void login(String n,String p){
        
        
        Usuario u = new Usuario();
        Usuario unUsu = u.ValidarUsuario(n, p);
        
       
        if(unUsu!=null){
            vista.ingresar(unUsu);
        }else vista.error("Login incorrecto");
    }
    
    
    
}
