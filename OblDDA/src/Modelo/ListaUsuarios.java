/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Mauro
 */
public class ListaUsuarios {
    private Usuario inicio;
    
    
    public Usuario getInicio() {
        return inicio;
    }


    public void agregarInicio(Usuario n) {
        if(this.inicio==null)
        {
            this.inicio=n;
        }
        else{
            n.setSig(this.inicio);
            this.inicio=n;
        }
    }

    public int cantElementos() {
        Usuario aux = this.inicio;
        int cant=0;
        while(aux!=null)
        {
            cant++;
            aux = aux.getSig();
        }
        return cant;
    }
}
