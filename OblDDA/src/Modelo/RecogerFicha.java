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
public class RecogerFicha extends TipoMov{
    
    //ATRIBUTOS
    private Ficha ficha;

    //SETTERS
    public void setFicha(Ficha ficha) {
        this.ficha = ficha;
    }

    //GETTERS
    public Ficha getFicha() {
        return ficha;
    }

    //CONSTRUCTOR    
    public RecogerFicha(Ficha ficha) {
        this.ficha = ficha;
    }
}
