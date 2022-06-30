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
public class DaoUsuario {

   

   
    private int idusuario;
    private String rut;
    private int clave;

    public DaoUsuario(int idusuario, String rut, int clave) {
        this.idusuario = idusuario;
        this.rut = rut;
        this.clave = clave;
    }

    public DaoUsuario() {
    }

    public DaoUsuario(int aInt, String string, String string0, String string1, int aInt0, String string2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
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


