/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladorDato;
import controlador.VistaDato;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.AsyncContext;

/**
 *
 * @author Dario
 */
public class VistaDatoWeb implements VistaDato {
    
    private ControladorDato controlador;
    private AsyncContext contexto;
    private PrintWriter out;

     public void iniciar(AsyncContext contexto) throws IOException {
        this.contexto = contexto;
        out = contexto.getResponse().getWriter();
        controlador = new ControladorDato(this);
    }

    @Override
    public void mostrar(String dato) {
        enviar("dato",dato + "<BR>");
    }
      @Override
    public void mostrar(int conectados) {
        enviar("conectados","Hay " + conectados + " conectado(s)");
    }
    /*
        Envio datos a la pagina
        //En el ejemplo del observador esto estaba en el servlet, ahora esta en la vista
    */
    private void enviar(String evento, String dato) {
    
        out.write("event: " + evento + "\n"); 
        dato = dato.replace("\n", ""); 
        out.write("data: " + dato + "\n\n"); 
        if (out.checkError()) {//checkError llama a flush, si da false evio bien
            cerrar();            
        } else {
            //TODO OK!
             System.out.println("Enviado:" + dato);
        }
    }
     
    private void cerrar(){
        controlador.desconectar();
         try{
             contexto.complete(); //finalizo el contexto asincronico
         }catch(Exception e){}   
    }

    public void conectar() {
        controlador.conectar();
    }

    public void desconectar() {
        controlador.desconectar();
    }

    public void enviarDato(String dato) {
        controlador.enviar(dato);
    }

  
    
}
