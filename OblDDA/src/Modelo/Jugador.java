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
public class Jugador extends Tipo{

    //ATRIBUTOS
    private double saldo;
    
    //GETTERS
    public double getSaldo() {
        return saldo;
    }
    //SETTERS
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    //CONSTRUCTOR
    public Jugador(double saldo) {
        this.saldo = saldo;
    }
    
    
}
