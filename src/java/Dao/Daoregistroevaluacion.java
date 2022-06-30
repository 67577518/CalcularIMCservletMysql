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
public class Daoregistroevaluacion {
    private int	idevaluacion;
    private int peso;
    private double estatura;
    private String fecha; 
    private double imc;
    private String estado;
    private int idusuario;
    private int identrenador;

    public Daoregistroevaluacion() {
    }

    public Daoregistroevaluacion(int idevaluacion, int peso, double estatura, String fecha, double imc, String estado, int idusuario, int identrenador) {
        this.idevaluacion = idevaluacion;
        this.peso = peso;
        this.estatura = estatura;
        this.fecha = fecha;
        this.imc = imc;
        this.estado = estado;
        this.idusuario = idusuario;
        this.identrenador = identrenador;
    }

    public int getIdevaluacion() {
        return idevaluacion;
    }

    public void setIdevaluacion(int idevaluacion) {
        this.idevaluacion = idevaluacion;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public double getEstatura() {
        return estatura;
    }

    public void setEstatura(double estatura) {
        this.estatura = estatura;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getImc() {
        return imc;
    }

    public void setImc(double imc) {
        this.imc = imc;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public int getIdentrenador() {
        return identrenador;
    }

    public void setIdentrenador(int identrenador) {
        this.identrenador = identrenador;
    }
    
    
    
}
