/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conversormoneda;

import Dominio.ConversorEurosPesetas;
import Presentacion.ControlConversor;
import Presentacion.InterfazVista;
import Presentacion.VistaConversor;

/**
 *
 * @author alumnoFI
 */
public class ConversorMoneda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        ConversorEurosPesetas modelo = new ConversorEurosPesetas();
        
        InterfazVista vista = (InterfazVista) new VistaConversor();
        
        ControlConversor control = new ControlConversor(vista, modelo);
        
        vista.setControlador(control);
        
        vista.arranca();
        
        
    }
    
}
