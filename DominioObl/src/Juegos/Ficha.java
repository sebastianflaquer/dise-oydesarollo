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
public class Ficha {

    //ATRIBUTOS
    private int id;
    private int valor1;
    private int valor2;
    
    //================================================================================
    //GETTERS
    //================================================================================
    public int getId() {
        return id;
    }
    public int getValor1() {
        return valor1;
    }
    public int getValor2() {
        return valor2;
    }
    
    //================================================================================
    //SETTERS
    //================================================================================
    public void setId(int id) {
        this.id = id;
    }
    public void setValor1(int valor1) {
        this.valor1 = valor1;
    }
    public void setValor2(int valor2) {
        this.valor2 = valor2;
    }
    
    //================================================================================
    //CONSTRUCTOR
    //================================================================================
    public Ficha(int id, int valor1, int valor2) {
        this.id = id;
        this.valor1 = valor1;
        this.valor2 = valor2;
    }
    private Ficha(){}
    
    //================================================================================
    //METODOS
    //================================================================================
    
    
    
}
