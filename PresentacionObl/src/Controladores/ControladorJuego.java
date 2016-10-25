/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Juegos.Ficha;
import Juegos.Partida;
import Usuarios.Usuario;
import Vistas.Mesa;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Mauro
 */
public class ControladorJuego implements ActionListener, Observer {
    private ILogin vistaLogin;
    private IMesa vistaMesa;
    private Partida partida;

    
    public ControladorJuego(ILogin vistaLog, Partida p) {
        this.vistaLogin = vistaLog;
        this.partida = p;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("LOGIN"))
        {
            //VALIDAR Y CARGAR USUARIO            
            Usuario unUsu = new Usuario();
            unUsu = unUsu.ValidarUsuario(vistaLogin.getUsuario(), vistaLogin.getContrasena());
            //boolean esValido = unUsu.ValidarUsuario(vistaLogin.getUsuario(), vistaLogin.getContrasena());
            
            if(unUsu.getNombre() != null )
            {
                //unUsu.setNombre(vistaLogin.getUsuario());
                //vistaLogin.SetErrorMsj("");
                this.vistaLogin.setVisible(false);
                
                this.vistaMesa = new Mesa();
                vistaMesa.setVisible(true);
                vistaMesa.CargarDatosDelJugador(unUsu);
                
                //vistaMesa.CargarFichasDelJugador();
                //vistaMesa.SetNombreUsuario(unUsu.getNomCompleto());
            }
            else
            {
                vistaLogin.SetErrorMsj("Nombre de Usuario o Contraseña Incorrecto");
            }
        }        
        else if(e.getActionCommand().equals("AddFicha"))
        {
            partida.AddFichaJugador(partida.GetUltimaMano());
        }
    }

    //ACTUALIZA LAS FICHAS DE LA MESA DE LOS JUGADORES
    public void agregaFichasMesa(){        
        ArrayList<Ficha> lfichas = partida.GetUltimaMano().getFichasJ1();        
        for(int i = 0; i< lfichas.size(); i++){
            int val1 = lfichas.get(i).getValor1();
            int val2 = lfichas.get(i).getValor2();
            vistaMesa.CargarFichasDelJugador(val1, val2);
        }
    }
    
    
    
    @Override
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
