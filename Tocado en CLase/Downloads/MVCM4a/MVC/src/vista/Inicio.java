/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import modelo.Fachada;
import modelo.Usuario;

/**
 *
 * @author docenteFI
 */
public class Inicio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        cargarUsuarios();
        new Principal().setVisible(true);
    }

    private static void cargarUsuarios() {
        Fachada f = Fachada.getInstancia();
        f.agregar(new Usuario("a","a","Juan perez"));
        f.agregar(new Usuario("b","b","Ana Gonzalez"));
        f.agregar(new Usuario("c","c","Pedro Hernandez"));
    }
    
}
