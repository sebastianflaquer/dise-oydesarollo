/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import vistaPartidasWeb.vistaAdminWeb;

/**
 *
 * @author Mauro
 */
@WebServlet(name = "AppServer", urlPatterns = {"/AppServer"})
public class AppServer extends HttpServlet{
    
    public AppServer() {
        //Vistas.MesaAdmin.main(null);
        vistaPartidasWeb.MesaAdmin.main(null);
        
    }
    
        /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        String accion = request.getParameter("accion");
        if(accion==null) return; //Tengo que saber si en este request estoy creando una vista o conectando con una existente
        
        HttpSession sesion = request.getSession(true); 
        
        if(accion.equals("new")){ //cuando se crea el EventSource en el js se invoca este servlet con "accion=new"
            
            //creo contexto asincronico y hago los seteos
            request.setAttribute("org.apache.catalina.ASYNC_SUPPORTED", true);
            AsyncContext contexto = request.startAsync();
            contexto.getResponse().setContentType("text/event-stream"); 
            contexto.getResponse().setCharacterEncoding("UTF-8");
            contexto.setTimeout(0); 
            
            //Creo la vista nueva
            vistaAdminWeb vista = new vistaAdminWeb();
            /*
            Una sola vista (de este tipo) por sesion, si se abren varios tabs o ventanas del mismo navegador
            la sesion sera la misma y se "pisa" la vista anterior de la sesion por esta. 
            En este ejemplo, todos los tabs se van a actualizar igual por que los objetos vista, 
            aunque no esten en la sesion, igual estan en la coleccion de observadores del modelo
            y tienen cada uno su salida asincronica al navegador activa, asi que van a actualizar al navegador.
            Por otro lado todo, si cualquier tab invoca un metodo (p. ej desconectar) este se va a ejecutar sobre
            la vista del ultimo tab no sobre la propia (ver el else de este if) y va a causar que ningun tab pueda enviar
            datos, aunque seguiran recibiendo actualizaciones... En el ejemplo usuariosWeb esto esta solucionado.
            */
            sesion.setAttribute("VistaAdminWeb", vista); 
            //Le paso la salida asincronica a la vista
            vista.iniciar(contexto); 
            
        }else{
            
            //Invocacion de metodos a la vista luego de haber sido creada, en este ejemplo se hacen via jquery desde el js...
            vistaAdminWeb vista = (vistaAdminWeb)sesion.getAttribute("VistaAdminWeb");
            if(vista==null){
                 System.out.println("Se perdio la sesion?");
                 return;
            }
            switch(accion){
                case "conectar"    : vista.conectar();break;
//                case "desconectar" : vista.desconectar();break;
//                case "enviar"      : vista.enviarDato(request.getParameter("dato"));
            }
           
        }
       
    }
    
}
