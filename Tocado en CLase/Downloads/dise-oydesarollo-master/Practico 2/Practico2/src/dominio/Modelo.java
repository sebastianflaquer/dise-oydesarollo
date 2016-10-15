/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.util.ArrayList;

/**
 *
 * @author alumnoFI
 */

        //CLASE DISQUERA
public class Modelo {
    private ArrayList<Disco> Discos;
    private ArrayList<Interprete> Interpretes;
    private static Modelo elModelo;

    public void setDiscos(ArrayList<Disco> Discos) {
        this.Discos = Discos;
    }

    public void setInterpretes(ArrayList<Interprete> Interpretes) {
        this.Interpretes = Interpretes;
    }

    public ArrayList<Disco> getDiscos() {
        return Discos;
    }

    public ArrayList<Interprete> getInterpretes() {
        return Interpretes;
    }
    
    private Modelo(){
        
        this.Discos = new ArrayList<>();
        this.Interpretes = new ArrayList<>();
    }
    
    public static Modelo GetInstancia()
    {
        if(elModelo == null){
            elModelo = new Modelo();
        }
        
        return elModelo;
    }
    
    public void AgregarDisco(Disco disco)
    {
        this.Discos.add(disco);
    }
    
}
    