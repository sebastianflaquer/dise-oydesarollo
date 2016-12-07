/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Dario
 */
public class Notificador {
    
    private String dato;

    public String getDato() {
        return dato;
    }

    public void nuevoDato(String dato) {
        if(!dato.trim().isEmpty()){
            this.dato = dato;
            Modelo.getInstancia().avisar(Modelo.Eventos.nuevoDato);
        }
        
    }
   
    
    
    
    
}
