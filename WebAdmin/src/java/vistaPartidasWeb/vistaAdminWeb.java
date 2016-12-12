/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistaPartidasWeb;

import controladorWeb.IWeb;
import controladorWeb.contWeb;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.AsyncContext;

/**
 *
 * @author Mauro
 */
public class vistaAdminWeb implements IWeb {

    private contWeb controlador;
    private AsyncContext contexto;
    private PrintWriter out;

    /**
     *
     * @param contexto
     * @throws IOException
     */
    public void iniciar(AsyncContext contexto) throws IOException {
        this.contexto = contexto;
        out = contexto.getResponse().getWriter();
        controlador = new contWeb(this);
    }

    private void enviar(String evento, String dato) {
        out.write("event: " + evento + "\n");
        dato = dato.replace("\n", "");
        out.write("data: " + dato + "\n\n");
    }
    
    @Override
    public void mostrarIds(ArrayList<Integer> iDsPartidas) {
        for(int i = 0; i < iDsPartidas.size(); i++){
            enviar(iDsPartidas.get(i).toString(), "");
        }
    }

    public void conectar() {
        controlador.conectar();
    }

    public void enviarDato(String dato) throws SQLException {
        controlador.enviar(dato);
    }

    public void CargarPartidas() throws SQLException {
        controlador.cargarPartida();
    }

    

}