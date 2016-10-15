/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author docenteFI
 */
public class SistemaUsuarios {
    
    private ArrayList<Usuario> usuarios = new ArrayList();
    private ArrayList<Usuario> logueados = new ArrayList();
    private boolean habilitado=true;
    private ArrayList<Numero> numeros = new ArrayList();

    public SistemaUsuarios() {
        numeros.add(new Numero(0,Color.GREEN));
        numeros.add(new Numero(1,Color.BLACK));
        numeros.add(new Numero(2,Color.RED));
        numeros.add(new Numero(3,Color.BLACK));
        numeros.add(new Numero(4,Color.RED));
    }
    
    
    public void agregar(Usuario u){
        usuarios.add(u);
    }
    public Usuario login(String nom,String c){
        if(!habilitado) return null;
        for(Usuario u:usuarios){
            if(u.getNombre().equals(nom) && u.getPassword().equals(c)){
                logueados.add(u);
                Fachada.getInstancia().avisar(Fachada.EVENTO_USUARIO);
                return u;
            }
        }
        return null;
    }
    public void logout(Usuario u){
        logueados.remove(u);
        Fachada.getInstancia().avisar(Fachada.EVENTO_USUARIO);
    }

    public ArrayList<Usuario> getLogueados() {
        return logueados;
    }

    public void deshabilitar() {
        habilitar(false);
    }
    public void habilitar() {
        habilitar(true);
    }

    private void habilitar(boolean b) {
        habilitado = b;
        Fachada.getInstancia().avisar(Fachada.EVENTO_LOGIN);
    }

    public boolean isHabilitado() {
        return habilitado;
    }
    //Esto no iria aqui
    public ArrayList<Numero> getNumeros(){
       
       
        return numeros;
        
    }

    public void masNumeros() {
        numeros.add(new Numero(numeros.size(),Color.BLUE));
        Fachada.getInstancia().avisar(Fachada.EVENTO_NUMERO);
    }
    
    
    
}
