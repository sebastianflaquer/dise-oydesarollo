/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

/**
 *
 * @author alumnoFI
 */
public interface InterfazVista {
    void setControlador(ControlConversor  c);
    void arranca();
    
    double getCantidad();
    void escribeCambio(String s);
    
    static final String AEURO = "Pesetas a Euros";
    static final String APESETAS = "Eutos a Pesetas";
       
}
    
    
   

