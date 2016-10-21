/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juegos;

import java.util.List;
import Usuarios.Jugador;

/**
 *
 * @author Laura
 */
public class Partida {
    
    //================================================================================
    //ATRIBUTOS
    //================================================================================
    private int id;
    private Jugador jugador1;
    private Jugador jugador2;
    private String estado;    // "En Juego", "Finalizado" o "Sin Iniciar" 
    private static double apuestaInicial;
    private List<Mano> manos;

    //================================================================================
    //SETTERS
    //================================================================================
    public void setId(int id) {
        this.id = id;
    }
    public void setJugador1(Jugador jugador1) {
        this.jugador1 = jugador1;
    }
    public void setJugador2(Jugador jugador2) {
        this.jugador2 = jugador2;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public static void setApuestaInicial(double apuestaInicial) {
        Partida.apuestaInicial = apuestaInicial;
    }
    public void setManos(List<Mano> manos) {
        this.manos = manos;
    }

    //================================================================================
    //GETTERS
    //================================================================================
    public int getId() {
        return id;
    }
    public Jugador getJugador1() {
        return jugador1;
    }
    public Jugador getJugador2() {
        return jugador2;
    }
    public String getEstado() {
        return estado;
    }
    public static double getApuestaInicial() {
        return apuestaInicial;
    }
    public List<Mano> getManos() {
        return manos;
    }

    //================================================================================
    //CONSTRUCTOR
    //================================================================================
    public Partida(int id, Jugador jugador1, Jugador jugador2, String estado, List<Mano> manos) {
        this.id = id;
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.estado = estado;
        this.manos = manos;
    }
    
    //================================================================================
    //METODOS
    //================================================================================
    private Partida(){
        this.estado = "Sin Iniciar";
    }
    
    public void SumarSaldos(){
    
    }
    
    //VALIDAR SALDO
    public boolean ValidarSaldo( Jugador jugador){        
        boolean ret = false;        
        if(jugador.getSaldo() >= apuestaInicial){
            ret = true;
        }        
        return ret;
    }
    
    //ROBAR UNA FICHA DEL MAZO
    public void AddFicha(Jugador j)
    {
         Ficha nueva = Ficha.ObtenerFichaRandom();
         Mano actual = new Mano();
         actual.getFichasJ1().add(nueva);
    }
    
    //OBTIENE EL TURNO ACTUAL
    public Jugador GetTurnoActual()
    {
        return this.getJugador1();
    }
    
    //INICIAR PARTIDA
    public void InicialPartida()
    {
        Mano primera = new Mano();
        primera.repartirFichasAJugadores();
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    

}
