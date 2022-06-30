/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Anilom
 */
public class Calcularimc {
      private int peso;
      private double estatura;
    
      
    public Calcularimc() {
        
    }
    
    public int getPeso() {
        return peso;
    }

    public double getEstatura() {
        return estatura;
    }

    public Calcularimc(int peso, double estatura) {
        this.peso = peso;
        this.estatura = estatura;
    }
    public double operacion (){
        double imc;
        imc = (this.peso /(this.estatura *this.estatura)) ;
        return imc;
    }
    
    
    
}
