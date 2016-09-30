/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package presentacion;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author 138924
 */
public class BarraMenu extends JMenuBar{
    private JMenu menuPelicula;
    private JMenu menuConsultas;
    
    private JMenuItem itemAgregarPelicula;
    private JMenuItem itemListadoPeliculas;
    

    public BarraMenu() {
        init();
    }

    private void init() {
        //inicializo componentes
        menuPelicula = new JMenu("Peliculas");
        menuConsultas = new JMenu("Consultas");
        
        itemAgregarPelicula = new JMenuItem("Nueva");
        itemAgregarPelicula.setName("NuevaPelicula");
        
        itemListadoPeliculas = new JMenuItem("Listado alfabetico");
        itemListadoPeliculas.setName("ListadoAlfabetico");
        
        //armo estructura
        menuPelicula.add(itemAgregarPelicula);
        menuConsultas.add(itemListadoPeliculas);
        
        this.add(menuPelicula);
        this.add(menuConsultas);
        
    }
    
    
}