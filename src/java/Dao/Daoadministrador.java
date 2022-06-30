/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

/**
 *
 * @author Anilom
 */
public class Daoadministrador {
     private int idadministrador;
    private String rut;
    private int clave;

    public Daoadministrador() {
    }

    public Daoadministrador(int idadministrador, String rut, int clave) {
        this.idadministrador = idadministrador;
        this.rut = rut;
        this.clave = clave;
    }

    public int getIdadministrador() {
        return idadministrador;
    }

    public void setIdadministrador(int idadministrador) {
        this.idadministrador = idadministrador;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }
    
    
}
