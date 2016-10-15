/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Dominio.ConversorEurosPesetas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author alumnoFI
 */
public class ControlConversor implements ActionListener {
    
    private InterfazVista vista;
    private ConversorEurosPesetas modelo;
    
    public ControlConversor(InterfazVista vista, ConversorEurosPesetas modelo)
    {
        this.vista = vista;
        this.modelo = modelo;
        
    }
    
    @Override
    public void actionPerformed(ActionEvent evento)
    {
        double cantidad = vista.getCantidad();
        
        if (evento.getActionCommand().equals(InterfazVista.AEURO))
        {
            vista.escribeCambio(cantidad + "pesetas son:" + modelo.pesetasAeuros(cantidad)+ " euros");
        }
        else if(evento.getActionCommand().equals(InterfazVista.APESETAS))
        {
            vista.escribeCambio(cantidad + "euros son:" + modelo.eurosAPesetas(cantidad)+ "pesetas");
        }
        else
            vista.escribeCambio("error");
    }
    
}
