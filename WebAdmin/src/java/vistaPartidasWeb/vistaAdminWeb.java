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
import javax.servlet.AsyncContext;

/**
 *
 * @author Mauro
 */
public class vistaAdminWeb implements IWeb {

    private contWeb controlador;
    private AsyncContext contexto;
    private PrintWriter out;
    

    public void iniciar(AsyncContext contexto) throws IOException {
        this.contexto = contexto;
        out = contexto.getResponse().getWriter();
        controlador = new contWeb(this);
    }

}
