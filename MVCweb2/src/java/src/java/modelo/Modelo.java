/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;



import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author alumnoFI
 */
public class Modelo extends Observable{

    
    private Notificador nt = new Notificador();
    private static Modelo instancia = new Modelo();

    private Modelo()  {
    }

    public static Modelo getInstancia() {
        return instancia;
    }
            
    protected void avisar(Object param){
        setChanged();
        notifyObservers(param);
    }
    public enum Eventos{
        nuevoDato,cantidadObservadores;
    }

    public String getDato() {
        return nt.getDato();
    }

    public void nuevoDato(String dato) {
        nt.nuevoDato(dato);
    }

    public int getCantidadObservadores() {
        return countObservers();
    }
    @Override
    public void addObserver(Observer obs){
        super.addObserver(obs);
        avisar(Eventos.cantidadObservadores);
        
    }
    @Override
    public void deleteObserver(Observer obs){
        super.deleteObserver(obs);
        avisar(Eventos.cantidadObservadores);
        
    }
}
    
    

