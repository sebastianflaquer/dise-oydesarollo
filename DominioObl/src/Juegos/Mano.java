/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juegos;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;



public class Mano {    

    //================================================================================
    //ATRIBUTOS
    //================================================================================
    private static int ultId=0;
    private int id;
    private ArrayList<Ficha> fichasJ1;    
    private ArrayList<Ficha> fichasJ2;
    private ArrayList<Ficha> fichasMazo;
    private ArrayList<Ficha> fichasJugadas;
    private Movimiento movimiento;
    
    //================================================================================
    //SETTERS
    //================================================================================
    public static void setUltId(int ultId) {
        Mano.ultId = ultId;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setFichasJ1(ArrayList<Ficha> fichasJ1) {
        this.fichasJ1.addAll(fichasJ1);
    }
    public void setFichasJ2(ArrayList<Ficha> fichasJ2) {
        this.fichasJ2.addAll(fichasJ2);
    }
    public void setFichasMazo(ArrayList<Ficha> fichasMazo) {
        this.fichasMazo.addAll(fichasMazo);
    }
    public void setFichasJugadas(ArrayList<Ficha> fichasJugadas) {
        this.fichasJugadas.addAll(fichasJugadas);
    }    
    public void setMovimiento(Movimiento movimiento) {
        this.movimiento = movimiento;
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
    public ArrayList<Ficha> getFichasJ1() {
        return fichasJ1;
    }
    public ArrayList<Ficha> getFichasJ2() {
        return fichasJ2;
    }
    public ArrayList<Ficha> getFichasMazo() {
        return fichasMazo;
    }
    public ArrayList<Ficha> getFichasJugadas() {
        return fichasJugadas;
    }
    public Movimiento getMovimiento() {
        return movimiento;
    }
    
    //================================================================================
    //CONSTRUCTOR
    //================================================================================
    public Mano() {
      this.id = ++Mano.ultId;
      this.fichasJ1 = new ArrayList<Ficha>();
      this.fichasJ2 = new ArrayList<Ficha>();
      this.fichasMazo = new ArrayList<Ficha>();
      this.fichasJugadas  = new ArrayList<Ficha>();
      
    }
       
    //================================================================================
    //METODOS
    //================================================================================
    
    //REPARTIR FICHAS A LOS JUGADORES   
    public void repartirFichasAJugadores(){
        
        //Cargo lista fichas jugador 1
        for(int i1 = 0; i1<7; i1++){
            Ficha unaF = ObtenerFichaRandom();
            fichasJ1.add(unaF);
            actualizarFichasMazo(unaF);
        }
        
        //Cargo lista fichas jugador 2
        for(int i2 = 0; i2<7; i2++){
            Ficha unaF = ObtenerFichaRandom();
            fichasJ2.add(unaF);
            actualizarFichasMazo(unaF);
        }        
    }
    
    //ACTUALIZAR FICHAS MAZO
    public void actualizarFichasMazo(Ficha unaFicha){
        for(int i=0; i<this.fichasMazo.size(); i++)
        {
            if(this.fichasMazo.get(i).equals(unaFicha))
            {
                this.fichasMazo.remove(i);
            }
        }
    }   
    
    //METODO RANDOM PARA OBTER ITEM DE UNA LISTA
    static Random rand = new Random();    
    static <T> T getRandomItem(List<T> list) {
        return list.get(rand.nextInt(list.size()));
    }
    
    //OBTENER UNA FICHA RANDOM
    public Ficha ObtenerFichaRandom() {
        //OBTIENE UNA FICHA RANDOM
        Ficha fichaRandom;
        fichaRandom = getRandomItem(this.fichasMazo);
        this.fichasMazo.remove(fichaRandom);
        return fichaRandom;
    }
}
