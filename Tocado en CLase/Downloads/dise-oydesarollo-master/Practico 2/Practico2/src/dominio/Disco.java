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
public class Disco implements Comparable<Disco>{
    private int Numero;
    private String Titulo;
    private String Genero;
    private Interprete Interprete;
    private String Cantante;
    private int Anio;

    public void setNumero(int Numero) {
        this.Numero = Numero;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }

    public void setCantante(String Cantante) {
        this.Cantante = Cantante;
    }

    public int getNumero() {
        return Numero;
    }

    public String getGenero() {
        return Genero;
    }

    public String getCantante() {
        return Cantante;
    }
    
    
    @Override
    public int compareTo(Disco o) {
        return this.getTitulo().compareToIgnoreCase(o.getTitulo());
    }

    @Override
    public String toString() {
        return "Disco{" + "autor=" + Interprete.getNombre() + ", año=" + Anio + ", titulo=" + Titulo + '}';
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public void setAnio(int Anio) {
        this.Anio = Anio;
    }

    public String getTitulo() {
        return Titulo;
    }

    public int getAnio() {
        return Anio;
    }
    public void setInterprete(Interprete Interprete) {
        this.Interprete = Interprete;
    }

    public Interprete getInterprete() {
        return Interprete;
    }
    
    
}
