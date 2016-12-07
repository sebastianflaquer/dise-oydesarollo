/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Usuario;
import vistaWeb.ListadoUsuariosWeb;


/**
 *
 * @author Dario
 */
@WebServlet(name = "ListadoUsuarios", urlPatterns = {"/listadoUsuarios"})
public class ListadoUsuarios extends HttpServlet {

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
  
        HttpSession sesion = request.getSession(false);
        if(sesion==null) return;
        Usuario usuario  = (Usuario) sesion.getAttribute("usuario");
        if(usuario==null) return;
        String accion = request.getParameter("accion");
        if(accion==null) return;
        
        if(accion.equals("new")){
                    
            request.setAttribute("org.apache.catalina.ASYNC_SUPPORTED", true);
            AsyncContext contexto = request.startAsync();
            contexto.getResponse().setContentType("text/event-stream");
            contexto.getResponse().setCharacterEncoding("UTF-8");
            contexto.setTimeout(0);
            ListadoUsuariosWeb vista = new ListadoUsuariosWeb();
            sesion.setAttribute("ListadoUsuariosWeb", vista);
            vista.iniciar(contexto, usuario);
            
        }else{
            ListadoUsuariosWeb vista = (ListadoUsuariosWeb) sesion.getAttribute("ListadoUsuariosWeb");
            if(vista==null) return;
            if(accion.equals("logout")) vista.logout();
            
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
