/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.Observable;
import java.util.Observer;
import modelo.Fachada;
import modelo.Numero;
import modelo.Usuario;

/**
 *
 * @author docenteFI
 */
public class ControladorNumeros implements Observer{
    
    private Fachada modelo = Fachada.getInstancia();
    private VistaNumeros vista;
    private Usuario usuario;

    public ControladorNumeros(VistaNumeros vista,Usuario u) {
        this.vista = vista;
        modelo.addObserver(this);
        vista.mostrarNumeros(modelo.getNumeros());
        usuario = u;
    }

    @Override
    public void update(Observable o, Object arg) {
        if(arg.equals(Fachada.EVENTO_NUMERO)){
            vista.mostrarNumeros(modelo.getNumeros());
        }
    }

    public void marcar(Numero numero) {
        numero.marcar(usuario.getNombre());
    }
    
    
    
    
}
