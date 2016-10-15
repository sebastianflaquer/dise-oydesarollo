/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import dominio.Calculador;
import presentacion.JFrameCalculador;

/**
 *
 * @author Santiago
 */
public class Inicio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
         Calculador calc = new Calculador();
        JFrameCalculador view = 
                new JFrameCalculador(calc);
        
        view.setVisible(true);
    }
    
}
