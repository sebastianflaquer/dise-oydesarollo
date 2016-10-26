/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juegos;

import Fachada.Sistema;
import Usuarios.Jugador;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Observable;

/**
 *
 * @author Laura
 */
public class Partida extends Observable{
    
    //================================================================================
    //ATRIBUTOS
    //================================================================================
    private static int ultId=0;
    private int id;
    private Jugador jugador1;
    private Jugador jugador2;
    private String estado;    // "En Juego", "Finalizado" o "Sin Iniciar" 
    private static double apuestaInicial = 100; //apuesta inicial 100
    private ArrayList<Mano> manos = new ArrayList<Mano>();
    private int turnoActual;
    //private ArrayList<Ficha> fichas = new ArrayList<Ficha>();
    
    private static Partida instancia;
    public static Partida GetInstancia()
    {
        if (instancia == null) 
            instancia = new Partida();       
        
        return instancia;
    }

    //================================================================================
    //SETTERS
    //================================================================================
    
    public static void setUltId(int ultId) {
        Partida.ultId = ultId;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setJugador1(Jugador jugador1) {
        this.jugador1 = jugador1;
    }
    public void setJugador2(Jugador jugador2) {
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

    //================================================================================
    //GETTERS
    //================================================================================
    
    public static int getUltId() {
        return ultId;
    }
    public int getId() {
        return id;
    }
    public Jugador getJugador1() {
        return jugador1;
    }
    public Jugador getJugador2() {
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

    //================================================================================
    //CONSTRUCTOR
    //================================================================================
    public Partida() {
        this.id=++Partida.ultId;
        this.jugador1 = null;
        this.jugador2 = null;
        this.estado = "Sin Iniciar";
        this.manos = new ArrayList<Mano>();
        this.turnoActual = 0;
    }
    
    //================================================================================
    //METODOS
    //================================================================================
    
    public void agregarMano(Mano m){
        if(m != null){
            this.manos.add(m);
        }
    }
    
    public void cambiarTurno(){
        if(this.turnoActual == 1 || this.turnoActual == 0)
            this.turnoActual = 2;
        else { this.turnoActual = 1;}            
    }   
    
    //INICIAR PARTIDA
    public void InicialPartida(){
        //cargar jugadores        
        //cambiarestado        
        //crear mano y agregar a la lista
        Mano primeraMano = GetUltimaMano();
        //repartir ficha a los jugadores
        primeraMano.repartirFichasAJugadores();      
        
        
    }    
    public void SumarSaldos(){}
    
    
    //VALIDAR SALDO
    public boolean ValidarSaldo( Jugador jugador){        
        boolean ret = false;        
        if(jugador.getSaldo() >= apuestaInicial){
            ret = true;
        }        
        return ret;
    }
    
    //ROBAR UNA FICHA DEL MAZO
    public void AddFichaJugador(Mano m){        
        if(m.getFichasJ1().size() + m.getFichasJ2().size() + m.getFichasJugadas().size() < 28)
        {
            Ficha nueva = m.ObtenerFichaRandom();
            m.getFichasJ1().add(nueva);
        }
    }
    
    //ROBAR UNA FICHA DEL MAZO
    public void AddFichaJugador2(Mano m){
        if(m.getFichasJ1().size() + m.getFichasJ2().size() + m.getFichasJugadas().size() < 28 )
        {
            Ficha nueva = m.ObtenerFichaRandom();
            m.getFichasJ2().add(nueva);
        }
    }
    
    //AGREGA FICHAS A LA LISTA DE FICHAS
    public void agregarFicha(Ficha f) {
        if (f != null)
        {
            Mano m = GetUltimaMano();
            m.getFichasMazo().add(f);
        }
    }
  
    //TRAE LA ULTIMA MANO
    public Mano GetUltimaMano(){
        Mano unaM = new Mano();
        unaM = this.manos.get(this.manos.size() -1);
        return unaM;
    }
    
    //AGREGA LA FICHA A LA JUGADA Y LA REMUEVE DEL LISTADO DEL JUGADOR
    public void agregarFichaAJugada(String nombreficha) {
        
        //HACE SPLIT PARA SEPARAR LOS VALORES       
        String string = nombreficha;
        String[] parts = string.split("-");
        String val1 = parts[0];
        String val2 = parts[1];
        
        Ficha unaF = new Ficha();
        
        String conts = "";
        conts = val1 + val2; 
        int intCont = Integer.parseInt(conts);
        
        unaF.setId(intCont);
        unaF.setValor1( Integer.parseInt(val1));
        unaF.setValor2( Integer.parseInt(val2));   
        
        boolean agrego = AddFichasJugadas(unaF);
        if(agrego){
            RemoveListaJugador(unaF);
        }
    }
    
    //ELIMINA LA FICHA JUGADA DE LA LISTA DEL JUGADOR
    public void RemoveListaJugador(Ficha f){
        Mano m = GetUltimaMano();
        if (this.turnoActual == 1 || this.turnoActual == 0){
            //ArrayList listaFichasJ1            
            for(int i = 0; i< m.getFichasJ1().size(); i++){
                if(m.getFichasJ1().get(i).getId() == f.getId()){
                    m.getFichasJ1().remove(i);
                }
            }
            this.turnoActual = 2;
        }else{
            //ArrayList listaFichasJ1            
            for(int i = 0; i< m.getFichasJ2().size(); i++){
                if(m.getFichasJ2().get(i).getId() == f.getId()){
                    m.getFichasJ2().remove(i);
                }
            }
            this.turnoActual = 1;
        }
        
    }
    
    //AGREGA LA FICHA A LA LISTA DE JUGADAS
    public boolean AddFichasJugadas(Ficha f){
        boolean retorno = false; 
        Mano m = GetUltimaMano();
        String lugar = validarSiPuedeDescartar(f,m);
        
        if(lugar == "start1"){
            //hay que darla vuelta
            daVueltaLaFicha(f);
            m.getFichasJugadas().add(0,f);
            retorno = true;            
        }
        else if(lugar == "start2"){
            m.getFichasJugadas().add(0,f);
            retorno = true;
        }
        else if(lugar == "end1"){            
            m.getFichasJugadas().add(f);
            retorno = true;
        }
        else if(lugar == "end2"){
            //hay que darla vuelta
            daVueltaLaFicha(f);
            m.getFichasJugadas().add(f);
            retorno = true;
        }
        else if(m.getFichasJugadas().isEmpty()){
            m.getFichasJugadas().add(f);
            retorno = true;
        }
        return retorno;
    }
    
    //DA VUELTA LAS FICHAS
    public Ficha daVueltaLaFicha(Ficha f){
        int aux = f.getValor1();
        f.setValor1(f.getValor2());
        f.setValor2(aux);
        
        return f;
    }
    
    //VALIDA SI EL JUGADOR PUEDE PONER UNA FICHA
    public String validarSiPuedeDescartar(Ficha f, Mano m){
        String lugar = "";
        if(m.getFichasJugadas().size() > 0){            
            Ficha primera = m.getFichasJugadas().get(0);
            Ficha ultima =  m.getFichasJugadas().get(m.getFichasJugadas().size()-1);
            
            if(primera.getValor1() == f.getValor1())
            {
                lugar = "start1";
            }
            else if(primera.getValor1() == f.getValor2())
            {
                lugar = "start2";
            }
            else if(ultima.getValor2() == f.getValor1())
            {
                lugar = "end1";
            }
            else if(ultima.getValor2() == f.getValor2())
            {
                lugar = "end2";
            }
            else
            {
                lugar = "no";
            }
        }
        return lugar;
    }
        
        
    


    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

}
