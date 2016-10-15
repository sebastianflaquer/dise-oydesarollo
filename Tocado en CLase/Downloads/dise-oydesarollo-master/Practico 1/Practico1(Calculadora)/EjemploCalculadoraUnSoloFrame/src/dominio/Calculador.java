/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dominio;

import java.util.ArrayList;

/**
 *
 * @author docenteFI
 */
public class Calculador {
    
    private ArrayList<Integer> valores;
    
    public Calculador()
    {
        this.valores = new ArrayList<>();
    }
    
    public void SetValor(Integer valor)
    {
        this.valores.add(valor);
    }

    @Override
    public String toString() {
        String cadena = "";
        
        for(int i = 0; i< this.valores.size();i++)
        {
            cadena = cadena.concat(this.valores.get(i).toString()).concat(" - ");
        }
        
        return cadena;
    }

    public Integer buscarElMayor() {
        
        Integer elMayor = Integer.MIN_VALUE;
        
        for(int i = 0; i< this.valores.size();i++)
        {
            if (elMayor <= this.valores.get(i)) {
                elMayor = this.valores.get(i);
            }
        }
        
        return elMayor;        
    }

    public Integer contarLosPares() {
        
        Integer contar = 0;
        
        for(int i = 0; i< this.valores.size();i++)
        {
            if (this.valores.get(i) % 2 == 0) {
                contar++;
            }
        }
        
        return contar; 
    }
    
    
}
