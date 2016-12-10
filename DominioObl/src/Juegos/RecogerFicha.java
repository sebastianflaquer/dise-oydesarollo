/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juegos;



public class RecogerFicha implements ITipoMovimiento{
    
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
    public RecogerFicha() {
    }
    
    @Override
    public String nombreTipo(){
        return "RecogerFicha";
    };
    
    @Override
    public double montoApuesta(){
        return -1;
    }
    
    
}
