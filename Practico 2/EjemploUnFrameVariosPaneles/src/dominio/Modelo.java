/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.util.ArrayList;
import java.util.Collections;

/**
 * El modelo es mi fachada
 */
public class Modelo {
    
    private ArrayList<Pelicula> peliculas;
    private static Modelo elModelo;
    
    
    private Modelo(){
        
        this.peliculas = new ArrayList<>();
    }
    
    public static Modelo GetInstancia()
    {
        if(elModelo == null){
            elModelo = new Modelo();
        }
        
        return elModelo;
    }
    
    
    public void AgregarPelicula(Pelicula pPelicula)
    {
        this.peliculas.add(pPelicula);
    }
    
    public ArrayList<Pelicula> getListadoPeliculasOrdenado(){
        
        ArrayList temp = new ArrayList<>();
        
        temp.addAll(this.peliculas);
        
        Collections.sort(temp);
        
        return temp;
    }
}
