/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;



public class Admin implements ITipo {

    
    //ATRIBUTOS
    
    
    //CONSTRUCTOR
    public Admin() {
        
    }
    
    @Override
    public boolean puedoJugar() {
        return false;
    }

    @Override
    public double getSaldo() {
        return -1;
    }
    
   
    
}
