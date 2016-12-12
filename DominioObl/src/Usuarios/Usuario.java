/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;

import Fachada.Sistema;
import ModeloPersistente.UsuarioPersistente;
import PersistenciaCont.ManejadorBD;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Usuario {

    //ATRIBUTOS
    private static int ultId = 0;
    private int id;
    private String nombre;
    private ITipo tipo;
    private String password;
    private String nomCompleto;
    private boolean logeado = false;

    //GETTERS
    public static int getUltId() {
        return ultId;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public ITipo getTipo() {
        return (ITipo) tipo;
    }

    public String getPassword() {
        return password;
    }

    public String getNomCompleto() {
        return nomCompleto;
    }

    public boolean isLogeado() {
        return logeado;
    }

    //SETTERS
    public static void setUltId(int ultId) {
        Usuario.ultId = ultId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipo(ITipo tipo) {
        this.tipo = (ITipo) tipo;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNomCompleto(String nomCompleto) {
        this.nomCompleto = nomCompleto;
    }

    public void setLogeado(boolean logeado) {
        this.logeado = logeado;
    }

    //CONSTRUCTOR
    public Usuario(String nombre, ITipo tipo, String password, String nomCompleto) {
        this.id = ++Usuario.ultId;
        this.nombre = nombre;
        this.tipo = tipo;
        this.password = password;
        this.nomCompleto = nomCompleto;
    }

    public Usuario() {
    }

    //VALIDAR EL SALDO PARA INGRESAR A LA PARTIDA
    public boolean ValidarSaldo(double saldoU, double saldoP) {
        boolean ret = false;
        if (saldoU >= saldoP) {
            ret = true;
        }
        return ret;
    }

    // VALIDAR USUARIO
    public Usuario ValidarUsuario(String nombre, String password) {

        Usuario unUsu = new Usuario();
        boolean ret = false;
        int i = 0;
        while (i < Sistema.GetInstancia().getUsuarios().size() && ret == false) {
            if (Sistema.GetInstancia().getUsuarios().get(i).nombre.equals(nombre) && Sistema.GetInstancia().getUsuarios().get(i).password.equals(password) && Sistema.GetInstancia().getUsuarios().get(i).isLogeado() == false) {
                ret = true;
                unUsu.setNombre(nombre);
                unUsu.setPassword(password);
                unUsu.setLogeado(true);
                unUsu.nomCompleto = Sistema.GetInstancia().getUsuarios().get(i).nomCompleto;
                unUsu.tipo = Sistema.GetInstancia().getUsuarios().get(i).tipo;
            } else {
                i++;
            }
        }
        return unUsu;
    }
    
    public Usuario ValidarUsuEnBD(String nombre, String password) throws SQLException
    {
        UsuarioPersistente u = new UsuarioPersistente(this);
        this.setNombre(nombre);
        this.setPassword(password);
        String query = u.getSelectSqlValidar();
        ManejadorBD bd = new ManejadorBD();
        bd.conectar("jdbc:mysql://localhost/domino?user=root&password=root");
        ResultSet rs = bd.obtenerResultSet(query);
        u.leer(rs);
        return this;
    }
}
