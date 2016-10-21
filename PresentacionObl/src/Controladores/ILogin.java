/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controladores;

import controladores.ControladorSistema; 

/**
 *
 * @author Sebastian
 */
public interface ILogin {
    
    void setControlador(ControladorSistema  c);    
    void inicializar();
    
    public String getUsuario();
    public String getContrasena();    
    public void SetErrorMsj(String mensaje);
    //void escribeCambio(String s);

    public void setVisible(boolean b);
    
}
