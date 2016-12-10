/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juegos;

import java.util.Calendar;
import Usuarios.Usuario;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;


public class Movimiento {

    
    //ATRIBUTOS
    private static int ultId=0;
    private int id;
    private ITipoMovimiento tipoMov;
    private String fechaHora; 
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

    public void setFechaHora(String fechaHora) {
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

    public String getFechaHora() {
        return fechaHora;
    }

    public Usuario getJugador() {
        return jugador;
    }
    
    
    //CONSTRUCOTR
    public Movimiento(ITipoMovimiento m, Usuario j) {
        this.id = ++Movimiento.ultId;
        this.tipoMov = m;
        this.fechaHora = this.convertirFecha();
        this.jugador = j;
    }
    
    public String convertirFecha()
    {
        Calendar c1 = GregorianCalendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
        return sdf.format(c1.getTime());
    }
    

    
    
}
