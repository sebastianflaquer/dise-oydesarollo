/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juegos;

import java.util.Calendar;
import Usuarios.Jugador;
import Usuarios.Usuario;


public class Movimiento {

    
    //ATRIBUTOS
    private static int ultId=0;
    private int id;
    private ITipoMovimiento tipoMov;
    private Calendar fechaHora;  //REVISAR
    private Usuario jugador;
    
    //SETTERS
    public static void setUltId(int ultId) {
        Movimiento.ultId = ultId;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setTipoMov(ITipoMovimiento tipoMov) {
        this.tipoMov = tipoMov;
    }

    public void setFechaHora(Calendar fechaHora) {
        this.fechaHora = fechaHora;
    }

    public void setJugador(Usuario jugador) {
        this.jugador = jugador;
    }
    
    //GETTERS
    public static int getUltId() {
        return ultId;
    }
    public int getId() {
        return id;
    }

    public ITipoMovimiento getTipoMov() {
        return tipoMov;
    }

    public Calendar getFechaHora() {
        return fechaHora;
    }

    public Usuario getJugador() {
        return jugador;
    }
    
    
    //CONSTRUCOTR
    public Movimiento(ITipoMovimiento m, Usuario j) {
        this.id = ++Movimiento.ultId;
        this.tipoMov = m;
        this.fechaHora = Calendar.getInstance();
        this.jugador = j;
    }
    
    
}
