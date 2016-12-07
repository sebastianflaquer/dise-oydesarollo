/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observadorWeb;



import java.util.Date;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author alumnoFI
 */
public class Observado extends Observable implements Runnable{

    
    private static Observado instancia;
    private Date fecha = new Date();
    private Thread hilo;
    private boolean correr;

    private Observado()  {
        arrancar();
    }

    public static Observado getInstancia() {
         if(instancia == null){
             instancia = new Observado();
         }
        return instancia;
    }

    public Date getFecha() {
        return fecha;
    }
    
    public void actualizarFecha(){
        fecha = new Date();
        avisar(Eventos.nuevaFecha);
    }
    protected void avisar(Object param){
        setChanged();
        notifyObservers(param);
    }

    @Override
    public void run() {
        while(correr){
            actualizarFecha();
            try {
                hilo.sleep(1000);
            } catch (InterruptedException ex) {}
            
        }
    }

    public void arrancar() {
         if(!correr){
             correr = true;
             hilo = new Thread(this);
             hilo.start();
         }

    }
    public void parar(){
        correr = false;
    }
    public enum Eventos{
        nuevaFecha;
    }

    

    
}
    
    

