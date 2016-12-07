/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observadorWeb;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;
import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dario
 */
@WebServlet(name = "ObservadorServlet", urlPatterns = {"/observadorServlet"})
public class ObservadorServlet extends HttpServlet implements Observer{

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    private PrintWriter out;
    private Observado observado;
    

    public ObservadorServlet() {
        observado = Observado.getInstancia();
        observado.addObserver(this);
        ObservadorFrame.main(null); //Creo un frame desde el servlet (no es real pero es muy practico para ejemplos)
    }
    
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
            //Para que no se cierre la conexion SSE al terminar el processRequest 
            //tengo que crear una respuesta asincronica para este request 
            //y asi poder enviar datos en cualquier momento al navegador (o sea cuando llega el update)
            request.setAttribute("org.apache.catalina.ASYNC_SUPPORTED", true);
            AsyncContext contexto = request.startAsync();
            
            //Estos dos seteos son obligaotrios por protocolo
            contexto.getResponse().setContentType("text/event-stream"); 
            contexto.getResponse().setCharacterEncoding("UTF-8");
            //Para que el navegador no intente reconectarse si no recibe datos, por defecto el timeout es muy bajo, 0 = sin timeout
            contexto.setTimeout(0); 
            
            //Me guardo la salida de datos al navegador
            out = contexto.getResponse().getWriter();
            //Muestro la fecha actual en el navegador
            mostrarFecha(observado.getFecha());
            
            ///OJO: Tomcat crea un solo objeto servlet (de cada clase) para procesar TODOS los request, 
            //asi que si se conectan dos paginas la comunicacion con la primera se va a perder por que el contexto y el out de la prmera se van a pisar
            //con el de la siguiente.. esto se soluciona en el ejemplo siguiente, MVCWeb
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

    @Override
    public void update(Observable o, Object evento) {
        if(evento==Observado.Eventos.nuevaFecha){
            mostrarFecha(observado.getFecha());
        }
    }

    private void mostrarFecha(Date fecha) {
        enviar("fecha",new SimpleDateFormat("'Hoy es' EEEE d 'de' MMMM").format(fecha));
        enviar("hora", new SimpleDateFormat("'Son las' HH:mm:ss").format(fecha));
    }
    /*
        Envio datos a la pagina
    */
    private void enviar(String evento, String dato) {
    
        if(out!=null){
            out.write("event: " + evento + "\n"); //asi se especifica el nombre del evento, con este nombre se registran los listeners en la pagina
            dato = dato.replace("\n", ""); //el dato no puede tener \n por protocolo
            out.write("data: " + dato + "\n\n"); //envio el dato
            out.flush();
        }
    }
    

}
