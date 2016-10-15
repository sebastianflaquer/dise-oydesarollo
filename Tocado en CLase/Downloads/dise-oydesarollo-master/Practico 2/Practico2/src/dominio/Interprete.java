/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

/**
 *
 * @author alumnoFI
 */
public class Interprete {
    private String Nombre;
    private int CantDiscos;
    private String Genero;

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setCantDiscos(int CantDiscos) {
        this.CantDiscos = CantDiscos;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }

    public int getCantDiscos() {
        return CantDiscos;
    }

    public String getGenero() {
        return Genero;
    }

    public String getNombre() {
        return Nombre;
    }
    
}
