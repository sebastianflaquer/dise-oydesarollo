/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;

import Fachada.Sistema;
import java.util.logging.Logger;

public class Usuario {
    
    //ATRIBUTOS
    private String nombre;
    private ITipo tipo;
    private String password;
    private String nomCompleto;
    private boolean logeado = false;

    
    //GETTERS
    public String getNombre() {
        return nombre;
    }

    public ITipo getTipo() {
        return (ITipo) tipo;
    }

    public String getPassword() {
        return password;
    }

    public String getNomCompleto() {
        return nomCompleto;
    }
    public boolean isLogeado() {
        return logeado;
    }
    
    //SETTERS
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipo(ITipo tipo) {
        this.tipo = (ITipo) tipo;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNomCompleto(String nomCompleto) {
        this.nomCompleto = nomCompleto;
    }
    public void setLogeado(boolean logeado) {
        this.logeado = logeado;
    }
        
    //CONSTRUCTOR
    public Usuario(String nombre, ITipo tipo, String password, String nomCompleto) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.password = password;
        this.nomCompleto = nomCompleto;
    }
    public Usuario(){}
    
    //VALIDAR EL SALDO PARA INGRESAR A LA PARTIDA
    public boolean ValidarSaldo(double saldoU, double saldoP)
    {
        boolean ret = false;
        if (saldoU >= saldoP)
        {
            ret = true;
        }
        return ret;
    }
    
    // VALIDAR USUARIO
    public Usuario ValidarUsuario(String nombre, String password){
        
        Usuario unUsu = new Usuario();
        boolean ret = false;        
        int i=0;
        
        while(i < Sistema.GetInstancia().getUsuarios().size() && ret==false)
        {
            if(Sistema.GetInstancia().getUsuarios().get(i).nombre.equals(nombre) && Sistema.GetInstancia().getUsuarios().get(i).password.equals(password) && Sistema.GetInstancia().getUsuarios().get(i).isLogeado() == false){
                ret = true;
                unUsu.setNombre(nombre);
                unUsu.setPassword(password);
                unUsu.setLogeado(true);
                unUsu.nomCompleto = Sistema.GetInstancia().getUsuarios().get(i).nomCompleto;
                unUsu.tipo = Sistema.GetInstancia().getUsuarios().get(i).tipo;
            }else{
               i++;
            }
        }
        return unUsu;
    }
}
