/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.awt.Color;

/**
 *
 * @author docenteFI
 */
public class Numero {
    
    private int valor;
    private Color color;
    private String usuario;

    public Numero(int valor, Color color) {
        this.valor = valor;
        this.color = color;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void marcar(String u) {
        if(usuario==null){
            color = Color.MAGENTA;
            usuario = u;
             Fachada.getInstancia().avisar(Fachada.EVENTO_NUMERO);
        }else if(usuario.equals(u)){
            color = Color.RED;
            usuario = null;
            Fachada.getInstancia().avisar(Fachada.EVENTO_NUMERO);
        }
    }

    public String getMarcador() {
        return usuario;
    }

    @Override
    public String toString() {
        return "Numero{" + "valor=" + valor +  ", usuario=" + usuario + '}';
    }
    
     
    
}
