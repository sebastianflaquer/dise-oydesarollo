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
public class ColocarFicha implements ITipoMovimiento{

    //ATRIBUTOS
    private Ficha ficha;
    private String lado;   //"Derecho" o "Izquierdo"
    
    
    //SETTERS
    public void setFicha(Ficha ficha) {
        this.ficha = ficha;
    }

    public void setLado(String lado) {
        this.lado = lado;
    }

    //GETTERS
    public Ficha getFicha() {
        return ficha;
    }

    public String getLado() {
        return lado;
    }

    //CONSTRUCOTR
    public ColocarFicha() {
    }
    
    @Override
    public String nombreTipo(){
        String retorno = "Colocar Ficha";
        return retorno;
    };
    
    @Override
    public double montoApuesta(){
        return -1;
    }
    
    
}
