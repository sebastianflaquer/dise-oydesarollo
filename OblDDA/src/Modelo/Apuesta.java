/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Laura
 */
public class Apuesta extends TipoMov {
    
    //ATRIBUTOS
    private double monto;
    
    
    //SETTERS
    public void setMonto(double monto) {
        this.monto = monto;
    }
    
    //GETTERS
    public double getMonto() {
        return monto;
    }
    

    //CONSTRUCTOR
    public Apuesta(double monto) {
        this.monto = monto;
    }
    
    
    
}
