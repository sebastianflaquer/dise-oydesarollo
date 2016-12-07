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
import vista.VistaDatoWeb;

/**
 *
 * @author Dario
 */
@WebServlet(name = "VistaDatoServlet", urlPatterns = {"/VistaDatoServlet"})
public class VistaDatoServlet extends HttpServlet {

    //Tomcat crea solo un objeto por servlet. 
    //Por eso el servlet no puede no puede ser la vista, pero puede ser el "conector" o "puente" de cada pagina, (o sesion web) con su vista.
    
    public VistaDatoServlet() {
        
        vista.VistaFrame.main(null);

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
            VistaDatoWeb vista = new VistaDatoWeb();
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
            sesion.setAttribute("VistaDatoWeb", vista); 
            //Le paso la salida asincronica a la vista
            vista.iniciar(contexto); 
            
        }else{
            
            //Invocacion de metodos a la vista luego de haber sido creada, en este ejemplo se hacen via jquery desde el js...
            VistaDatoWeb vista = (VistaDatoWeb)sesion.getAttribute("VistaDatoWeb");
            if(vista==null){
                 System.out.println("Se perdio la sesion?");
                 return;
            }
            switch(accion){
                case "conectar"    : vista.conectar();break;
                case "desconectar" : vista.desconectar();break;
                case "enviar"      : vista.enviarDato(request.getParameter("dato"));
            }
           
        }
       
    }
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
