/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


public class Sistema {

<<<<<<< HEAD
    private List<Usuario> usuarios = new List<Usuario>();
=======
    private ListaUsuarios usuarios = new ListaUsuarios();
>>>>>>> 4bdd54e7b59bbbb7fe148b46624e05b18b2f7b6a
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
<<<<<<< HEAD
        if (u != null){
            usuarios.add(u);
        }        
    } 
    
=======
        if (u != null)
        {
            usuarios.agregarInicio(u);
        }
        
    }
>>>>>>> 4bdd54e7b59bbbb7fe148b46624e05b18b2f7b6a
    
}
