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
public class ControladorListaUsurios implements Observer{
    
    private Usuario logueado;
    private Fachada modelo = Fachada.getInstancia();
    private ListaUsuarios vista;

    public ControladorListaUsurios(Usuario logueado,ListaUsuarios v) {
        modelo.addObserver(this);
        this.logueado = logueado;
        vista=v;
        v.mostarUsuarios(modelo.getLogueados());
    }

    @Override
    public void update(Observable o, Object arg) {
        if(arg.equals(Fachada.EVENTO_USUARIO)){
            vista.mostarUsuarios(modelo.getLogueados());
        }
    }

    public void logout() {
        modelo.logout(logueado);
        modelo.deleteObserver(this);
    }
    
    
}
