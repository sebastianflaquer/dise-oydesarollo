/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladorWeb;

import Fachada.Sistema;
import Juegos.Mensaje;
import Juegos.Partida;
import java.sql.SQLException;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Mauro
 */
public class contWeb implements Observer {

    private IWeb vista;
    //private Sistema fachada = Sistema.GetInstancia();
    private Partida partida;

    public contWeb(IWeb vista) {
        this.vista = vista;
        partida = new Partida();
    }

    public void conectar() {
        partida.addObserver(this);
    }

    public void enviar(String dato) throws SQLException {
        partida.nuevoDato(dato); //ID PARTIDA SELECCIONADA
    }

    @Override
    public void update(Observable o, Object arg) {
        Mensaje msg = (Mensaje) arg;
        this.partida = (Partida) o;

        //AGREGAR FICHA MESA
        if (msg.getAccion().equalsIgnoreCase("ManosCargadas")) {
            
            //ACA DEBERIA CARGAR LAS MANOS
            
        } else {
            System.out.print("Ultimo Else.");
        }
    }

}
