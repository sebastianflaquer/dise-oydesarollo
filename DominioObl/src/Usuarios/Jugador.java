/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;



public class Jugador implements ITipo {

    //ATRIBUTOS
    private double saldo = 100;
    private int numeroJug;    
    
    //SETTERS
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    @Override
    public void setNumeroJug(int numeroJug) {
        this.numeroJug = numeroJug;
    }
    
    //GETTERS
    @Override
    public double getSaldo() {
        return saldo;
    }
    
    @Override
    public int getNumeroJug() {
        return numeroJug;
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
