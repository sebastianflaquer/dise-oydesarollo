/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import javax.swing.JButton;
import modelo.Numero;

/**
 *
 * @author docenteFI
 */
public class Boton extends JButton{

    private Numero numero;
    
    public Boton(String text) {
        super(text);
    }

    public Numero getNumero() {
        return numero;
    }

    public void setNumero(Numero numero) {
        this.numero = numero;
    }
    
    
    
    
}
