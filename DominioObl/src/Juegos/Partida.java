/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juegos;

import Fachada.Sistema;
import Usuarios.Jugador;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Observable;

/**
 *
 * @author Laura
 */
public class Partida extends Observable{
    
    //================================================================================
    //ATRIBUTOS
    //================================================================================
    private static int ultId=0;
    private int id;
    private Jugador jugador1;
    private Jugador jugador2;
    private String estado;    // "En Juego", "Finalizado" o "Sin Iniciar" 
    private static double apuestaInicial = 100; //apuesta inicial 100
    private ArrayList<Mano> manos = new ArrayList<Mano>();
    //private ArrayList<Ficha> fichas = new ArrayList<Ficha>();
    
    
    
    private static Partida instancia;
    public static Partida GetInstancia()
    {
        if (instancia == null) 
            instancia = new Partida();       
        
        return instancia;
    }

    //================================================================================
    //SETTERS
    //================================================================================
    
    public static void setUltId(int ultId) {
        Partida.ultId = ultId;
    }
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
    public void setManos(ArrayList<Mano> manos) {
        this.manos = manos;
    }

    //================================================================================
    //GETTERS
    //================================================================================
    
    public static int getUltId() {
        return ultId;
    }
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
    public ArrayList<Mano> getManos() {
        return manos;
    }

    //================================================================================
    //CONSTRUCTOR
    //================================================================================
    public Partida() {
        this.id=++Partida.ultId;
        this.jugador1 = null;
        this.jugador2 = null;
        this.estado = "Sin Iniciar";
        this.manos = new ArrayList<Mano>();
    }
    
    //================================================================================
    //METODOS
    //================================================================================
    
    public void agregarMano(Mano m)
    {
        if(m != null)
        {
            this.manos.add(m);
        }
    }
    
    
    
    //INICIAR PARTIDA
    public void InicialPartida()
    {
        //cargar jugadores        
        //cambiarestado        
        //crear mano y agregar a la lista
        Mano primeraMano = GetUltimaMano();
        //repartir ficha a los jugadores
        primeraMano.repartirFichasAJugadores();
        
        
        
    }    
    public void SumarSaldos(){}
    
    
    //VALIDAR SALDO
    public boolean ValidarSaldo( Jugador jugador){        
        boolean ret = false;        
        if(jugador.getSaldo() >= apuestaInicial){
            ret = true;
        }        
        return ret;
    }
    
    //ROBAR UNA FICHA DEL MAZO
    public void AddFichaJugador(Mano m)
    {
        Ficha nueva = m.ObtenerFichaRandom();
        Jugador j= this.GetTurnoActual();
        if(j.equals(this.jugador1))
        {
            m.getFichasJ1().add(nueva);
        }
        else
        {
            m.getFichasJ2().add(nueva);
        }
    }
    
    //OBTIENE EL TURNO ACTUAL
    public Jugador GetTurnoActual()
    {
        return this.getJugador1();
    }
    
    //AGREGA FICHAS A LA LISTA DE FICHAS
    public void agregarFicha(Ficha f) {
        if (f != null)
        {
            Mano m = GetUltimaMano();
            m.getFichasMazo().add(f);
        }
    }
    
  
    //TRAE LA ULTIMA MANO
    public Mano GetUltimaMano()
    {
        Mano unaM = new Mano();
        unaM = this.manos.get(this.manos.size() -1);
        //FALTA ARMAR, HAY QUE RECORRER LA LISTA Y TRAER LA ULTIMA
        
        return unaM;
    }

    //ACTUALIZA TODOS LOS DATOS DE LAS MESAS
    public void actualizarMesa() {        
    }

    //ingresarMovimiento
    public void ingresarMovimiento() {
        //Validar si la ficha se puede poner en la lista de fichas jugadas
        //validarMovimiento();    
        
    }

    private void validarMovimiento(Ficha f) {
        
        //se fija en el listado de fichasen juego puede poner la ficha al principio, al final, en ambos lugares o en ninguno
        //Si al principio o final lo agrega (llama a una funcion que la agrega)
        //.actualizarFichasMazo();
        

        //si en ambos pregunta
        //si en ninguno tira error.
        
    }


    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

}
