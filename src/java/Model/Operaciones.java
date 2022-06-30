/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.List;



/**
 *
 * @author Anilom
 */
public interface Operaciones {
    
    public String insertar(Object obj);
    public String insertarusuario(Object obj);
    public List<?> buscarinsertar (String parametros );
    public List<?> buscarusuarioporrut (String parametros );
    public List<?> buscarclave (String parametros , int parametro );
    public List<?> buscarentrenadorporrut (String parametros );
    public List<?> buscarclaveentrenador (String parametros , int parametro );
    public List<?> buscaradministradorporrut (String parametros );
    public List<?> buscarclaveadministrador (String parametros , int parametro );
    public List<?> consultar();
    public String delete(Object obj);
    public String insertarevaluacion(Object obj);
    public List<?> buscarusuario(String parametro);
    public String updateusuario(Object obj);
   
    
}
