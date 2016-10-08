/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Laura
 */
public class Usuario {
    //ATRIBUTOS
    private String nombre;
    private Tipo tipo;
    private String password;
    private String nomCompleto;
    
    //GETTERS
    public String getNombre() {
        return nombre;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public String getPassword() {
        return password;
    }

    public String getNomCompleto() {
        return nomCompleto;
    }
    
    //SETTERS
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNomCompleto(String nomCompleto) {
        this.nomCompleto = nomCompleto;
    }
        
    //CONSTRUCTOR
    public Usuario(String nombre, Tipo tipo, String password, String nomCompleto) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.password = password;
        this.nomCompleto = nomCompleto;
    }
    
    public boolean ValidarUsuario(String nombre, String password){
        boolean ret = false;
        
        int i=0;
        while(i < Sistema.GetInstancia().getUsuarios().size())
        {
            if(Sistema.GetInstancia().getUsuarios().get(i).nombre.equals(nombre) && 
                    Sistema.GetInstancia().getUsuarios().get(i).password.equals(password))
            {
                ret = true;
            }
            else
            {
               i++;
            }
        }
        return ret;
    }
    
}
