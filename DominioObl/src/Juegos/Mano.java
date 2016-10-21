/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juegos;

import static Juegos.Ficha.ObtenerFichaRandom;
import java.util.List;

/**
 *
 * @author Laura
 */
public class Mano {

    

    
    //ATRIBUTOS
    private List<Ficha> fichasJ1;
    private List<Ficha> fichasJ2;
    private List<Ficha> fichasMazo;
    private List<Ficha> fichasJugadas;
    private Movimiento movimiento;
    

    //SETTERS
    public void setFichasJ1(List<Ficha> fichasJ1) {
        this.fichasJ1 = fichasJ1;
    }

    public void setFichasJ2(List<Ficha> fichasJ2) {
        this.fichasJ2 = fichasJ2;
    }

    public void setFichasMazo(List<Ficha> fichasMazo) {
        this.fichasMazo = fichasMazo;
    }

    public void setFichasJugadas(List<Ficha> fichasJugadas) {
        this.fichasJugadas = fichasJugadas;
    }
    
    public void setMovimiento(Movimiento movimiento) {
        this.movimiento = movimiento;
    }

    
    //GETTERS
    public List<Ficha> getFichasJ1() {
        return fichasJ1;
    }

    public List<Ficha> getFichasJ2() {
        return fichasJ2;
    }

    public List<Ficha> getFichasMazo() {
        return fichasMazo;
    }

    public List<Ficha> getFichasJugadas() {
        return fichasJugadas;
    }
    public Movimiento getMovimiento() {
        return movimiento;
    }
    
    
    
    //CONSTRUCOTR
    public Mano(List<Ficha> fichasJ1, List<Ficha> fichasJ2, List<Ficha> fichasMazo, List<Ficha> fichasJugadas) {
        this.fichasJ1 = fichasJ1;
        this.fichasJ2 = fichasJ2;
        this.fichasMazo = fichasMazo;
        this.fichasJugadas = fichasJugadas;
    }
    
    public Mano(){}
    
    public Mano GetUltimaMano()
    {
        Mano ultima = new Mano();
        return ultima;
    }
    
    //METODOS
    
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
