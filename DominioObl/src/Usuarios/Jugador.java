/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;



public class Jugador implements ITipo {

    //ATRIBUTOS
    private double saldo = 100;
    
    
    //SETTERS
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    //GETTERS
    @Override
    public double getSaldo() {
        return saldo;
    }
    
    //CONSTRUCTOR
    public Jugador(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public boolean puedoJugar() {
        return true;
    }
    
   
    
    
}
