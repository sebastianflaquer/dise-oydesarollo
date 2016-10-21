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
    private int id;
    private TipoMov tipoMov;
    private Calendar fechaHora;  //REVISAR
    private Jugador jugador;
    
    //SETTERS
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
    public Movimiento(int id, TipoMov tipoMov, Calendar fechaHora, Jugador jugador) {
        this.id = id;
        this.tipoMov = tipoMov;
        this.fechaHora = fechaHora;
        this.jugador = jugador;
    }
    
    
}
