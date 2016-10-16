/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Laura
 */
public class Ficha {

//    static Ficha ObternerFichaPorId(int idFicha) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    
    //METODO RANDOM PARA OBTER ITEM DE UNA LISTA
    static Random rand = new Random();    
    static <T> T getRandomItem(List<T> list) {
        return list.get(rand.nextInt(list.size()));
    }
    
    //OBTENER UNA FICHA RANDOM
    static Ficha ObtenerFichaRandom() {
        //preguntar al profesor como hacer el random
        
        //CREO UNA MANO
        Mano unaM = new Mano();
        //CREO LISTA CON LA LISTA DEL MAZO
        List<Ficha> lista = unaM.GetUltimaMano().getFichasMazo();
        //OBTIENE UNA FICHA RANDOM
        Ficha fichaRandom = getRandomItem(lista);
        
        return fichaRandom;
    }
    
    
    
    //ATRIBUTOS
    private int id;
    private int valor1;
    private int valor2;

    //CONSTRUCTOR
    public Ficha(int id, int valor1, int valor2) {
        this.id = id;
        this.valor1 = valor1;
        this.valor2 = valor2;
    }

    private Ficha(){}

    //GETTERS
    public int getId() {
        return id;
    }

    public int getValor1() {
        return valor1;
    }

    public int getValor2() {
        return valor2;
    }

    
    //SETTERS
    public void setId(int id) {
        this.id = id;
    }

    public void setValor1(int valor1) {
        this.valor1 = valor1;
    }

    public void setValor2(int valor2) {
        this.valor2 = valor2;
    }
    
}
