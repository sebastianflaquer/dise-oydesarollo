/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladorWeb;

import Fachada.Sistema;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Mauro
 */
public class contWeb implements Observer{
        private IWeb vista;
        private Sistema fachada = Sistema.GetInstancia();
        
        
        public contWeb(IWeb vista) {
        this.vista = vista;
    }
    
    

    @Override
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
