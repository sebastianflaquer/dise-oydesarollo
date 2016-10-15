/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.Observable;
import java.util.Observer;
import modelo.Fachada;
import modelo.Usuario;

/**
 *
 * @author docenteFI
 */
public class ControladorLogin implements Observer{
    
    private Fachada modelo = Fachada.getInstancia();
    private Login vista;

    public ControladorLogin(Login vista) {
        this.vista = vista;
        modelo.addObserver(this);
        vista.habilitar(modelo.isHabilitado());
    }
    
    public void login(String nom,String pass){
        Usuario logueado = modelo.login(nom, pass);
        if(logueado==null){
            vista.mostrarErrorLogin();
        }else{
            vista.ingresar(logueado);
        }
    }

    @Override
    public void update(Observable origen, Object evento) {
        if(evento.equals(Fachada.EVENTO_LOGIN)){
            vista.habilitar(modelo.isHabilitado());
        }
    }
    
    
}
