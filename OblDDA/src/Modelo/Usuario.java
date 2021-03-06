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
    
    //================================================================================
    //ATRIBUTOS
    //================================================================================
    private String nombre;    
    private String password;
    private String nomCompleto;
    private Tipo tipo;
    
    
    //================================================================================
    //GETTERS
    //================================================================================
    public String getNombre() {
        return nombre;
    }
    public String getPassword() {
        return password;
    }
    public String getNomCompleto() {
        return nomCompleto;
    }
    public Tipo getTipo() {
        return tipo;
    }
    
    //================================================================================
    //SETTERS
    //================================================================================
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setNomCompleto(String nomCompleto) {
        this.nomCompleto = nomCompleto;
    }
    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
        
    //================================================================================
    //CONSTRUCTOR
    //================================================================================
    public Usuario(String nombre, Tipo tipo, String password, String nomCompleto) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.password = password;
        this.nomCompleto = nomCompleto;
    }
    public Usuario() {
        
    }
    
    
    //================================================================================
    //METODOS
    //================================================================================
    
    // VALIDAR USUARIO
    public Usuario ValidarUsuario(String nombre, String password){
        
        Usuario unUsu = new Usuario();
        boolean ret = false;        
        int i=0;
        while(i < Sistema.GetInstancia().getUsuarios().size() && ret==false)
        {
            if(Sistema.GetInstancia().getUsuarios().get(i).nombre.equals(nombre) && Sistema.GetInstancia().getUsuarios().get(i).password.equals(password)){
                ret = true;
                unUsu.setNombre(nombre);
                unUsu.setPassword(password);
                unUsu.nomCompleto = Sistema.GetInstancia().getUsuarios().get(i).nomCompleto;
                unUsu.tipo = Sistema.GetInstancia().getUsuarios().get(i).tipo;
            }else{
               i++;
            }
        }
        return unUsu;
    }
}
