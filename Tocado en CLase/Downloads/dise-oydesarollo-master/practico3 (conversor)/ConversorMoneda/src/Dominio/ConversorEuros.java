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
public class ConversorEuros {
    private double cambio;
    
    public ConversorEuros (double valorCambio){
        cambio = valorCambio;
    }
    
    public double eurosAmonedas(double cantidad){
        return cantidad * cambio;
    
    }
    public double monedaAeuro(double cantidad){
        return cantidad / cambio;
    
    }
    
    
}
