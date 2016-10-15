/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import javax.swing.*;

/**
 *
 * @author alumnoFI
 */
public class Menu extends JMenuBar{

    
    private JMenu menuDiscos;
    private JMenu menuConsultas;
    
    private JMenuItem itemAgregarDisco;
    private JMenuItem itemListadoDiscos;
    
    public Menu() {
        init();
    }
    
    public void init(){
        menuDiscos = new JMenu("Discos");
        menuConsultas = new JMenu("Consultas");
        itemAgregarDisco = new JMenuItem("Nueva");
        itemAgregarDisco.setName("NuevoDisco");
        itemListadoDiscos = new JMenuItem("Listado");
        itemListadoDiscos.setName("ListadoOrdenado");
        
        menuDiscos.add(itemAgregarDisco);
        menuConsultas.add(itemListadoDiscos);
        
        this.add(menuDiscos);
        this.add(menuConsultas);

    }
    
}
