/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Dario
 */
public class Usuario {
    
    private String nombre;
    private String password;
    private String nombreCompleto;
    private boolean logeado;

    public Usuario() {
    }

    public Usuario(String nombre, String password) {
        this.nombre = nombre;
        this.password = password;
    }

    public Usuario(String nombre, String password, String nombreCompleto) {
        this.nombre = nombre;
        this.password = password;
        this.nombreCompleto = nombreCompleto;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return nombreCompleto;
    }
    @Override
    public boolean equals(Object o){
        Usuario u = (Usuario) o;
        return getNombre().equalsIgnoreCase(u.getNombre());
    }

    public boolean isLogeado() {
        return logeado;
    }

    protected void setLogeado(boolean logeado) {
        this.logeado = logeado;
    }
    public void logout(){
        setLogeado(false);
        Modelo.getInstancia().avisar(Modelo.Eventos.CambioListaUsuarios);
    }

    
    
}
