/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.Usuario;

/**
 *
 * @author docenteFI
 */
public interface Login {
    
    public void mostrarErrorLogin();

    public void ingresar(Usuario logueado);
    
    public void habilitar(boolean b);
    
}
