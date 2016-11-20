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
    
    //================================================================================
    //ATRIBUTOS
    //================================================================================
    private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    private ArrayList<Partida> partidas = new ArrayList<Partida>();    
    
    private static Sistema instancia;
    
    public static Sistema GetInstancia()
    {
        if (instancia == null) 
            instancia = new Sistema();       
        
        return instancia;
    }
    
    //================================================================================
    //SETTERS
    //================================================================================
    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    public void setPartidas(ArrayList<Partida> partidas) {
        this.partidas = partidas;
    }
    
    //================================================================================
    //GETTERS
    //================================================================================
    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }
    public ArrayList<Partida> getPartidas() {
        return partidas;
    }
    
    //================================================================================
    //METODOS
    //================================================================================
    
    //ARGEGA UN USUARIO
    public void agregar(Usuario u) {
        if (u != null)
        {
            usuarios.add(u);
        }
    }
    
    //AGREGA UNA PARTIDA
    public void agregarPartida(Partida p)
    {
        if(p != null)
        {
            partidas.add(p);
        }
    }
    
    //CHEQUEA LUGAR LIBRE
    public Partida chequeaLugarEnPartida(Usuario unUsu){
        boolean ret = false;
        Partida p = null;
        int i = 0;
        while(i < this.partidas.size() && ret == false){
            if(this.partidas.get(i).getJugador1() == null){
                ret = true;
                this.partidas.get(i).setJugador1(unUsu);
                p = this.partidas.get(i);
            }else{
                ret = true;
                this.partidas.get(i).setJugador2(unUsu);
                p = this.partidas.get(i);
            }
        }
        return p;
    }
    
}
