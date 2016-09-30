/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

/**
 *
 * @author alumnoFI
 */
public class ConversorEurosPesetas extends ConversorEuros{
    private ConversorEuros conversor;
    
    public ConversorEurosPesetas(){
        super(166.386D);
    }
    
    public double eurosAPesetas(double cantidad){
        return eurosAmonedas(cantidad);
    
    }
    
    public double pesetasAeuros(double cantidad){
        return monedaAeuro(cantidad);
    
    }
    
    
    
    
}
