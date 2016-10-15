/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio;

import java.util.ArrayList;

/**
 *
 * @author alumnoFI
 */
public class Calculadora {
    public ArrayList<Integer> valores;
    
    
    public Calculadora(ArrayList<Integer> valores) {
        this.valores = valores;
    }
    
    
    
    public void Add(Integer valor){
        this.valores.add(valor);
    };
    
    
    public ArrayList BuscarPares(){
        ArrayList lista = new ArrayList();
        
        for(int i=0; i< this.valores.size(); i++)
            {
                if (this.valores.get(i) % 2 == 0)
                    {
                        lista.add(this.valores.get(i));
                    }
            }
        return lista;
    };
    
    public int BuscarMayor(){
        int mayor = 0;
        for(int i=0; i< this.valores.size(); i++)
            {
                if (this.valores.get(i) > mayor)
                    {
                        mayor = this.valores.get(i);
                    }
            }
        return mayor;
    };
  
    
    
}
