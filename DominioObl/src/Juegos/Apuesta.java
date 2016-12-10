/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juegos;

/**
 *
 * @author Laura
 */
public class Apuesta implements ITipoMovimiento {
    
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
    
    @Override
    public String nombreTipo(){
        return "Apuesta";
    };
    
    @Override
    public double montoApuesta(){
        return monto;
    }
    
}
