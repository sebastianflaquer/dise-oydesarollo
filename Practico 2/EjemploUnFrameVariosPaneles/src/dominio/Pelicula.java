/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

/**
 *
 * @author Santiago
 */
public class Pelicula  implements Comparable<Pelicula>{

    @Override
    public int compareTo(Pelicula o) {
        return this.getTitulo().compareToIgnoreCase(o.getTitulo());
    }

    @Override
    public String toString() {
        return "Pelicula{" + "autor=" + autor + ", año=" + año + ", titulo=" + titulo + '}';
    }
    
    private String autor;

    /**
     * Get the value of autor
     *
     * @return the value of autor
     */
    public String getAutor() {
        return autor;
    }

    /**
     * Set the value of autor
     *
     * @param autor new value of autor
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }
    
        private String año;

    /**
     * Get the value of año
     *
     * @return the value of año
     */
    public String getAño() {
        return año;
    }

    /**
     * Set the value of año
     *
     * @param año new value of año
     */
    public void setAño(String año) {
        this.año = año;
    }
    
    private String titulo;

    /**
     * Get the value of titulo
     *
     * @return the value of titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Set the value of titulo
     *
     * @param titulo new value of titulo
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    
    
}
