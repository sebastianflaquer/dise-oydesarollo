/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controladores;

import Usuarios.Usuario;

/**
 *
 * @author Sebastian
 */
public interface IMesaAdmin {
    
    public void setVisible(boolean b);
    public void inicializar();
    public void terminar();
    public void cargarDatosAdmin(Usuario admin);

}
