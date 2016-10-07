/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

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
    
    
    //CONSTRUCOTR
    public Mano(List<Ficha> fichasJ1, List<Ficha> fichasJ2, List<Ficha> fichasMazo, List<Ficha> fichasJugadas) {
        this.fichasJ1 = fichasJ1;
        this.fichasJ2 = fichasJ2;
        this.fichasMazo = fichasMazo;
        this.fichasJugadas = fichasJugadas;
    }
    
    
    //METODOS
    
}
