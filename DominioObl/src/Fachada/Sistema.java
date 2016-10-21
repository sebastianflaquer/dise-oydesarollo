/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fachada;

import Juegos.Partida;
import Usuarios.Usuario;
import java.util.ArrayList;
import java.util.List;


public class Sistema {

    private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    private ArrayList<Partida> partidas = new ArrayList<Partida>();
    
    private static Sistema instancia;
    
    public static Sistema GetInstancia()
    {
        if (instancia == null) 
            instancia = new Sistema();       
        
        return instancia;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public void setPartidas(ArrayList<Partida> partidas) {
        this.partidas = partidas;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public List<Partida> getPartidas() {
        return partidas;
    }

    public void agregar(Usuario u) {
        if (u != null)
        {
            usuarios.add(u);
        }
        
    }
    
}
