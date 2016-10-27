/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juegos;

import java.util.Calendar;
import Usuarios.Jugador;

/**
 *
 * @author Laura
 */
public class Movimiento {

    

    
    
    //ATRIBUTOS
    private static int ultId=0;
    private int id;
    private TipoMov tipoMov;
    private Calendar fechaHora;  //REVISAR
    private Jugador jugador;
    
    //SETTERS
    public static void setUltId(int ultId) {
        Movimiento.ultId = ultId;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setTipoMov(TipoMov tipoMov) {
        this.tipoMov = tipoMov;
    }

    public void setFechaHora(Calendar fechaHora) {
        this.fechaHora = fechaHora;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }
    
    //GETTERS
    public static int getUltId() {
        return ultId;
    }
    public int getId() {
        return id;
    }

    public TipoMov getTipoMov() {
        return tipoMov;
    }

    public Calendar getFechaHora() {
        return fechaHora;
    }

    public Jugador getJugador() {
        return jugador;
    }
    
    
    //CONSTRUCOTR
    public Movimiento(TipoMov m, Jugador j) {
        this.id = ++Movimiento.ultId;
        this.tipoMov = m;
        this.fechaHora = Calendar.getInstance();
        this.jugador = j;
    }
    
    
}
