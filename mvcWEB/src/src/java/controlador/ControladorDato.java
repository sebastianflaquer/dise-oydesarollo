package controlador;

import java.util.Observable;
import java.util.Observer;
import modelo.Modelo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dario
 */
public class ControladorDato implements Observer{
    
    private VistaDato vista;
    private Modelo modelo = Modelo.getInstancia();
    private boolean conectado;

    public ControladorDato(VistaDato vista) {
        this.vista = vista;
    }
    public void conectar(){
        if(!conectado){
            vista.mostrar("Registrado!");
            conectado=true;
            modelo.addObserver(this);
        }else vista.mostrar("Ya estas conectado");
            
    }
    public void desconectar(){
        if(conectado){
            modelo.deleteObserver(this);
            conectado=false;
            vista.mostrar("Ya no estas registrado");
        }
    }
    public void enviar(String dato){
        if(conectado){
            modelo.nuevoDato(dato);
        }else vista.mostrar("Debes conectarte para enviar"); //Esto es logica,pero para simplificar...
    }

    @Override
    public void update(Observable origen, Object evento) {
        if(origen==modelo){
            if(evento.equals(Modelo.Eventos.nuevoDato)){
                vista.mostrar(modelo.getDato());
            }else if(evento.equals(Modelo.Eventos.cantidadObservadores)){
                vista.mostrar(modelo.getCantidadObservadores());
            }
        }
    }
    
    
}
