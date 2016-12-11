/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juegos;

import ModeloPersistente.PartidaPersistente;
import Usuarios.Jugador;
import Usuarios.Usuario;
import java.util.ArrayList;
import java.util.Observable;

public class Partida extends Observable implements Runnable {

    //================================================================================
    //ATRIBUTOS
    //================================================================================
    private static int ultId = 0;
    private int oid;
    private Usuario jugador1;
    private Usuario jugador2;
    private String estado;    // "En Juego", "Finalizado" o "Sin Iniciar" o "Esperando Jugador"
    private static double apuestaInicial = 100; //apuesta inicial 100
    private ArrayList<Mano> manos = new ArrayList<Mano>();
    private int turnoActual;
    private double apuestaActual;
    private Usuario turnoActualJugador;

    //HILOS
    private Boolean onTurno;
    private Boolean onApuesta;
    private int regresivaTurno;
    private int regresivaApuesta;
    private Thread hilo;

    //================================================================================
    //SETTERS
    //================================================================================
    public static void setUltId(int ultId) {
        Partida.ultId = ultId;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public void setJugador1(Usuario jugador1) {
        this.jugador1 = jugador1;
    }

    public void setJugador2(Usuario jugador2) {
        this.jugador2 = jugador2;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public static void setApuestaInicial(double apuestaInicial) {
        Partida.apuestaInicial = apuestaInicial;
    }

    public void setManos(ArrayList<Mano> manos) {
        this.manos = manos;
    }

    public void setTurnoActual(int turnoActual) {
        this.turnoActual = turnoActual;
    }

    public void setApuestaActual(double apuestaActual) {
        this.apuestaActual = apuestaActual;
    }

    public void setTurnoActualJugador(Usuario turnoActualJugador) {
        this.turnoActualJugador = turnoActualJugador;
    }

    public void setOnTurno(Boolean onTurno) {
        this.onTurno = onTurno;
    }

    public void setOnApuesta(Boolean onApuesta) {
        this.onApuesta = onApuesta;
    }

    //================================================================================
    //GETTERS
    //================================================================================
    public static int getUltId() {
        return ultId;
    }

    public int getOid() {
        return oid;
    }

    public Usuario getJugador1() {
        return jugador1;
    }

    public Usuario getJugador2() {
        return jugador2;
    }

    public String getEstado() {
        return estado;
    }

    public static double getApuestaInicial() {
        return apuestaInicial;
    }

    public ArrayList<Mano> getManos() {
        return manos;
    }

    public int getTurnoActual() {
        return turnoActual;
    }

    public double getApuestaActual() {
        return apuestaActual;
    }

    public Usuario getTurnoActualJugador() {
        return turnoActualJugador;
    }

    public int getRegrasivaTurno() {
        return regresivaTurno;
    }

    public int getRegrasivaApuesta() {
        return regresivaApuesta;
    }

    public Boolean getOnTurno() {
        return onTurno;
    }

    public Boolean getOnApuesta() {
        return onApuesta;
    }

    //================================================================================
    //CONSTRUCTOR
    //================================================================================
    public Partida() {
        this.oid = 1;
        this.jugador1 = null;
        this.jugador2 = null;
        this.estado = "Sin Iniciar";
        this.manos = new ArrayList<Mano>();
        this.turnoActual = 0;
        this.apuestaActual = Partida.apuestaInicial;
        this.regresivaTurno = 30;
        this.regresivaApuesta = 15;
        this.onApuesta = false;
    }

    //================================================================================
    //METODOS
    //================================================================================
    public void Iniciar() {
        this.onTurno = true;
        this.hilo = new Thread(this);
        this.hilo.start();
    }

    public void acepaApuesta() {
        this.onApuesta = false;
        resetApuesta();
    }

    public void resetTurno() {
        this.regresivaTurno = 30;
    }

    public void resetApuesta() {
        this.regresivaApuesta = 15;
    }

    public void Detener() {
        this.onTurno = false;
        this.onApuesta = false;
    }

    @Override
    public void run() {
        while (this.onTurno) {
            if (this.regresivaTurno == 0) {
                // fin de la partida
                this.estado = "Finalizado"; // o "Finalizado2" depende el Turno
                String JugGanador = "";
                String ganador = "";
                if (this.getTurnoActualJugador() == this.getJugador1()) {
                    JugGanador = "Gana Jugador 2";
                    ganador = "Jugador 2";
                } else {
                    JugGanador = "Gana Jugador 1";
                    ganador = "Jugador 1";
                }
                NotificarAccion("FinDelTiempo", JugGanador);
                this.onTurno = false;
                this.SumarSaldos(ganador);
                //PERSISTE LOS DATOS DE LA PARTIDA
                this.guardarEnBD();
            } else {
                try {
                    this.regresivaTurno--;
                    NotificarAccion("RegresivaTurno", Integer.toString(this.regresivaTurno));
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                }
            }
            while (onApuesta) {
                if (this.regresivaApuesta == 0) {
                    this.estado = "Finalizado";
                    String JugGanador = "";
                    String winner = "";
                    if (this.getTurnoActualJugador() == this.getJugador1()) {
                        JugGanador = "Gana Jugador 1";
                        winner = "Jugador 1";
                    } else {
                        JugGanador = "Gana Jugador 2";
                        winner = "Jugador 2";
                    }
                    NotificarAccion("FinTiempoApuesta", JugGanador);
                    this.onApuesta = false;
                    this.SumarSaldos(winner);
                    //PERSISTE LOS DATOS DE LA PARTIDA
                    this.guardarEnBD();
                    Detener();
                } else {
                    try {
                        this.regresivaApuesta--;
                        NotificarAccion("RegresivaApuesta", "");
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                    }
                }
            }
        }
    }

    private void guardarEnBD() {
        PartidaPersistente pp = new PartidaPersistente(this);
        pp.ImpactarDatos();
    }
    
        public void SumarSaldos(String jugador) {
            if(jugador.equalsIgnoreCase("Jugador 1"))
            {
                double nuevoSaldo = this.getApuestaActual() + this.getJugador1().getTipo().getSaldo();
                this.getJugador1().getTipo().setSaldo(nuevoSaldo); 
                double nuevoSaldoJ2 =  this.getJugador2().getTipo().getSaldo() - this.getApuestaActual();
                this.getJugador2().getTipo().setSaldo(nuevoSaldoJ2);
            }
            else
            {
                double nuevoSaldoJ2 = this.getApuestaActual() + this.getJugador2().getTipo().getSaldo();
                this.getJugador2().getTipo().setSaldo(nuevoSaldoJ2); 
                double nuevoSaldo = this.getJugador1().getTipo().getSaldo() - this.getApuestaActual();
                this.getJugador1().getTipo().setSaldo(nuevoSaldo);
            }
            
    }

    //AGREGAR MANO
    public void agregarMano(Mano m) {
        if (m != null) {
            this.manos.add(m);
        }
    }

    //CAMBIAR TURNO
    public void cambiarTurno() {
        if (this.turnoActualJugador == this.jugador1) {
            this.setTurnoActualJugador(this.jugador2);
        } else {
            this.setTurnoActualJugador(this.jugador1);
        }
    }

    //INICIAR PARTIDA
    public void InicialPartida() {

        //CARGA LAS FICHAS
        cargarFichas();
        //crear mano y agregar a la lista
        Mano primeraMano = TraeUltimaMano();
        //Agrega las fichas a cada jugajor
        primeraMano.repartirFichasAJugadores();
        NotificarAccion("AgregarFichasMesa", "");
    }

    //CARGA LAS FICHAS A LA PARTIDA
    public void cargarFichas() {
        //CREA LA PRIMER MANO Y LA AGREGA EN LA LISTA
        Mano m = new Mano();
        //SE TOMA COMO QUE EL PRIMER MOVIMIENTO ES "RECOGER FICHA" 
        m.setMovimiento(new Movimiento(new Apuesta(this.getApuestaActual()), this.turnoActualJugador));
        agregarMano(m);
        //AGREGA LAS FICHAS AL MAZO
        String conts = "";
        for (int l = 0; l <= 6; l++) {
            int r = l;
            for (r = l; r <= 6; r++) {
                conts = Integer.toString(l) + Integer.toString(r);
                int intCont = Integer.parseInt(conts);
                this.agregarFicha(new Ficha(intCont, l, r));
            }
        }
    }
    //VALIDAR SALDO
    public boolean ValidarSaldo(Jugador jugador) {
        boolean ret = false;
        if (jugador.getSaldo() >= apuestaInicial) {
            ret = true;
        }
        return ret;
    }

    //ROBAR UNA FICHA DEL MAZO
    public boolean AddFichaJugador(Mano m) {
        boolean retorno = false;
        if (this.turnoActualJugador == this.jugador1) {
            if (m.getFichasJ1().size() + m.getFichasJ2().size() + m.getFichasJugadas().size() < 28) {
                Ficha nueva = m.ObtenerFichaRandom();
                m.getFichasJ1().add(nueva);
                retorno = true;
            }
        } else if (this.turnoActualJugador == this.jugador2) {
            if (m.getFichasJ1().size() + m.getFichasJ2().size() + m.getFichasJugadas().size() < 28) {
                Ficha nueva = m.ObtenerFichaRandom();
                m.getFichasJ2().add(nueva);
                retorno = true;
            }
        }
        return retorno;
    }

    //AGREGA FICHAS A LA LISTA DE FICHAS
    public void agregarFicha(Ficha f) {
        if (f != null) {
            Mano m = TraeUltimaMano();
            m.getFichasMazo().add(f);
        }
    }

    //TRAE LA ULTIMA MANO
    public Mano GetUltimaMano() {
        Mano unaM = new Mano();
        unaM.setFichasJ1(this.manos.get(this.manos.size() - 1).getFichasJ1());
        unaM.setFichasJ2(this.manos.get(this.manos.size() - 1).getFichasJ2());
        unaM.setFichasJugadas(this.manos.get(this.manos.size() - 1).getFichasJugadas());
        unaM.setFichasMazo(this.manos.get(this.manos.size() - 1).getFichasMazo());
        return unaM;
    }

    public Mano TraeUltimaMano() {
        return this.manos.get(this.manos.size() - 1);
    }

    //AGREGA LA FICHA A LA JUGADA Y LA REMUEVE DEL LISTADO DEL JUGADOR
    public String agregarFichaAJugada(String nombreficha) {
        String retorno = "";
        //HACE SPLIT PARA SEPARAR LOS VALORES       
        String string = nombreficha;
        String[] parts = string.split("-");
        String val1 = parts[0];
        String val2 = parts[1];
        //CREA UNA NUEVA FICHA
        Ficha unaF = new Ficha();
        String conts = "";
        conts = val1 + val2;
        int intCont = Integer.parseInt(conts);
        unaF.setId(intCont);
        unaF.setValor1(Integer.parseInt(val1));
        unaF.setValor2(Integer.parseInt(val2));
        boolean agrego = AddFichasJugadas(unaF);
        if (agrego) {
            RemoveListaJugador(unaF);
            if (chequeaGanador(unaF) == "Jugador 1") {
                retorno = "jugador1";
            } else if (chequeaGanador(unaF) == "Jugador 2") {
                retorno = "jugador2";
            } else {
                retorno = "no";
            }
        } else {
            retorno = "noagrego";
        }
        return retorno;
    }

    //ELIMINA LA FICHA JUGADA DE LA LISTA DEL JUGADOR
    public void RemoveListaJugador(Ficha f) {
        Mano m = TraeUltimaMano();
        if (this.turnoActualJugador == this.jugador1) {
            for (int i = 0; i < m.getFichasJ1().size(); i++) {
                if (m.getFichasJ1().get(i).getId() == f.getId()) {
                    m.getFichasJ1().remove(i);
                }
            }
            this.setTurnoActualJugador(this.jugador2);
        } else if (this.turnoActualJugador == this.jugador2) {
            for (int i = 0; i < m.getFichasJ2().size(); i++) {
                if (m.getFichasJ2().get(i).getId() == f.getId()) {
                    m.getFichasJ2().remove(i);
                }
            }
            this.setTurnoActualJugador(this.jugador1);
        }
    }

    //CHEQUEA GANADOR
    //INVERTI LOS TURNOS YA QUE QUEDARON CAMBIADOS
    public String chequeaGanador(Ficha unaF) {
        String ganador = "no";
        Mano m = TraeUltimaMano();
        if (this.turnoActualJugador == this.jugador2) {
            if (m.getFichasJ1().isEmpty()) {
                ganador = "Jugador 1";
                this.estado = "Finalizado";
                this.Detener();
                this.SumarSaldos(ganador);
                this.guardarEnBD();
            }
        } else if (this.turnoActualJugador == this.jugador1) {
            if (m.getFichasJ2().isEmpty()) {
                ganador = "Jugador 2";
                this.estado = "Finalizado";
                this.Detener();
                this.SumarSaldos(ganador);
                this.guardarEnBD();
            }
        }
        return ganador;
    }

    //AGREGA LA FICHA A LA LISTA DE JUGADAS
    public boolean AddFichasJugadas(Ficha f) {
        boolean retorno = false;
        Mano m = TraeUltimaMano();
        String lugar = validarSiPuedeDescartar(f, m);
        if (lugar == "start1") {
            //hay que darla vuelta
            daVueltaLaFicha(f);
            m.getFichasJugadas().add(0, f);
            retorno = true;
        } else if (lugar == "start2") {
            m.getFichasJugadas().add(0, f);
            retorno = true;
        } else if (lugar == "end1") {
            m.getFichasJugadas().add(f);
            retorno = true;
        } else if (lugar == "end2") {
            //hay que darla vuelta
            daVueltaLaFicha(f);
            m.getFichasJugadas().add(f);
            retorno = true;
        } else if (m.getFichasJugadas().isEmpty()) {
            m.getFichasJugadas().add(f);
            retorno = true;
        }
        return retorno;
    }

    //DA VUELTA LAS FICHAS
    public Ficha daVueltaLaFicha(Ficha f) {
        int aux = f.getValor1();
        f.setValor1(f.getValor2());
        f.setValor2(aux);
        return f;
    }

    //VALIDA SI EL JUGADOR PUEDE PONER UNA FICHA
    public String validarSiPuedeDescartar(Ficha f, Mano m) {
        String lugar = "";
        if (m.getFichasJugadas().size() > 0) {
            Ficha primera = m.getFichasJugadas().get(0);
            Ficha ultima = m.getFichasJugadas().get(m.getFichasJugadas().size() - 1);

            if (primera.getValor1() == f.getValor1()) {
                lugar = "start1";
            } else if (primera.getValor1() == f.getValor2()) {
                lugar = "start2";
            } else if (ultima.getValor2() == f.getValor1()) {
                lugar = "end1";
            } else if (ultima.getValor2() == f.getValor2()) {
                lugar = "end2";
            } else {
                lugar = "no";
            }
        }
        return lugar;
    }

    //NOTIFICAR ACCION
    public void NotificarAccion(String accion, String valor) {
        Mensaje aux = new Mensaje();
        aux.setAccion(accion);
        aux.setValor(valor);
        this.setChanged();
        this.notifyObservers(aux);
    }

}
