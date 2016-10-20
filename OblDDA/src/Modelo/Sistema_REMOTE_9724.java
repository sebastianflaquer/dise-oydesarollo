/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.List;


public class Sistema {

    private ListaUsuarios usuarios = new ListaUsuarios();
    private List<Partida> partidas;
    
    private static Sistema instancia;
    
    public static Sistema GetInstancia()
    {
        if (instancia == null) 
            instancia = new Sistema();       
        
        return instancia;
    }

    public void setUsuarios(ListaUsuarios usuarios) {
        this.usuarios = usuarios;
    }

    public void setPartidas(List<Partida> partidas) {
        this.partidas = partidas;
    }

    public ListaUsuarios getUsuarios() {
        return usuarios;
    }

    public List<Partida> getPartidas() {
        return partidas;
    }

    public void agregar(Usuario u) {
        if (u != null)
        {
            usuarios.agregarInicio(u);
        }
        
    }
    
}
