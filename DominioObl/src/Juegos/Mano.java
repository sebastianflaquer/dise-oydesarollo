/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juegos;

import static Juegos.Ficha.ObtenerFichaRandom;
import java.util.ArrayList;

/**
 *
 * @author Laura
 */
public class Mano {

    

    //================================================================================
    //ATRIBUTOS
    //================================================================================
    private ArrayList<Ficha> fichasJ1 = new ArrayList<Ficha>();    
    private ArrayList<Ficha> fichasJ2 = new ArrayList<Ficha>();
    private ArrayList<Ficha> fichasMazo = new ArrayList<Ficha>();
    private ArrayList<Ficha> fichasJugadas = new ArrayList<Ficha>();
    private Movimiento movimiento;
    
    //================================================================================
    //SETTERS
    //================================================================================
    public void setFichasJ1(ArrayList<Ficha> fichasJ1) {
        this.fichasJ1 = fichasJ1;
    }
    public void setFichasJ2(ArrayList<Ficha> fichasJ2) {
        this.fichasJ2 = fichasJ2;
    }
    public void setFichasMazo(ArrayList<Ficha> fichasMazo) {
        this.fichasMazo = fichasMazo;
    }
    public void setFichasJugadas(ArrayList<Ficha> fichasJugadas) {
        this.fichasJugadas = fichasJugadas;
    }    
    public void setMovimiento(Movimiento movimiento) {
        this.movimiento = movimiento;
    }

    //================================================================================
    //GETTERS
    //================================================================================
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
    //================================================================================//CONSTRUCOTR
    public Mano() {
        this.fichasJ1 = null;
        this.fichasJ2 = null;
        this.fichasMazo = null;
        this.fichasJugadas = null;
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

    
    
}
