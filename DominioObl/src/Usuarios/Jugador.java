/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;

/**
 *
 * @author Laura
 */
public class Jugador extends Tipo {

    //ATRIBUTOS
    private double saldo;
    
    //SETTERS
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    //GETTERS
    public double getSaldo() {
        return saldo;
    }
    
    //CONSTRUCTOR
    public Jugador(double saldo) {
        this.saldo = saldo;
    }
    
    
}
