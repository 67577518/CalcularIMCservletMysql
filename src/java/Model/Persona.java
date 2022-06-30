/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


import Dao.DaoPersona;
import Dao.DaoPersonausuario;
import Dao.DaoUsuario;
import Dao.Daoentrenador;
import Dao.Daoadministrador;
import Dao.Daoregistroevaluacion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author Anilom
 */
public class Persona implements Operaciones{
 //implementacion de la interfaz operaciones
    Conexion conexion = new Conexion();
    @Override
    public String insertar(Object obj) {
        //variable respuesta es lo que retorna el metodo insertar, exito o error.
        String resp="";
        int nfilas;
        DaoPersonausuario daoPersonausuario = (DaoPersonausuario) obj;
        Connection connection;
        PreparedStatement pst,pst2;
       //consultas preparadas.
        String query = "insert into tblpersona values(?,?,?,?,?,?)";
        String query2 = "insert into tblusuario values (null,?,?)" ;
        //int incrementable=null;
        
        try {
            Class.forName(conexion.getDriver());
            connection = (Connection) DriverManager.getConnection(conexion.getUrl(), conexion.getUsuario(), conexion.getClave());
            pst = (PreparedStatement) connection.prepareStatement(query);
            pst.setString(1, daoPersonausuario.getRut());
            pst.setString(2, daoPersonausuario.getNombre());
            pst.setString(3, daoPersonausuario.getApellido());
            pst.setString(4, daoPersonausuario.getDireccion());
            pst.setInt(5, daoPersonausuario.getFono());
            pst.setString(6, daoPersonausuario.getEmail());
            nfilas = pst.executeUpdate();
            pst2 = (PreparedStatement) connection.prepareStatement(query2);
       
            pst2.setString(1,daoPersonausuario.getRut());
            pst2.setInt(2,daoPersonausuario.getClave());
            nfilas = pst2.executeUpdate();
            
            resp = "Registro insertado con exito";
            
        } catch (ClassNotFoundException | SQLException e) {
            resp = e.getMessage();
        }        
        return resp;
    }
    @Override
    public String insertarusuario(Object obj) {
        //variable respuesta es lo que retorna el metodo insertar, exito o error.
        String resp="";
        int nfilas;
        DaoUsuario daoUsuario = (DaoUsuario) obj;
        Connection connection;
        PreparedStatement pst2;
       //consultas preparadas.
        String query2 = "insert into tblusuario values (null,?,?)" ;
        //int incrementable=null;
        
        try {
            Class.forName(conexion.getDriver());
            connection = (Connection) DriverManager.getConnection(conexion.getUrl(), conexion.getUsuario(), conexion.getClave());
            
            pst2 = (PreparedStatement) connection.prepareStatement(query2);
       
            pst2.setString(1,daoUsuario.getRut());
            pst2.setInt(2,daoUsuario.getClave());
            nfilas = pst2.executeUpdate();
            
            resp = "Registro insertado con exito";
            
        } catch (ClassNotFoundException | SQLException e) {
            resp = e.getMessage();
        }        
        return resp;
    }

   
    @Override
    public List<DaoPersona> buscarinsertar(String parametro) {
           
        List<DaoPersona> datos = new ArrayList<>();
        Connection con;
        PreparedStatement pst;
        ResultSet resultSet;  
        
        String query = "select * from tblpersona where rut = ? ";
        
        try {
            Class.forName(conexion.getDriver());
            con = (Connection) DriverManager.getConnection(conexion.getUrl(), conexion.getUsuario(), conexion.getClave());
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setString(1, parametro);
            resultSet = pst.executeQuery();
            
            while(resultSet.next()){
                datos.add(new DaoPersona(resultSet.getString("rut"), resultSet.getString("nombre"), resultSet.getString("apellido"), resultSet.getString("direccion"), resultSet.getInt("fono"), resultSet.getString("email")));
            }
            
            
        } catch (ClassNotFoundException | SQLException e) {
        }


        return datos;
    }
    
    @Override
    public List<DaoUsuario> buscarusuarioporrut(String parametro) {
           
        List<DaoUsuario> datos = new ArrayList<>();
        Connection con;
        PreparedStatement pst;
        ResultSet resultSet;  
        
        String query = "select * from tblusuario where rut = ? ";
        
        try {
            Class.forName(conexion.getDriver());
            con = (Connection) DriverManager.getConnection(conexion.getUrl(), conexion.getUsuario(), conexion.getClave());
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setString(1, parametro);
            resultSet = pst.executeQuery();
            
            while(resultSet.next()){
                datos.add(new DaoUsuario(resultSet.getInt("idusuario"), resultSet.getString("rut"), resultSet.getInt("clave") ));
            }
            
            
        } catch (ClassNotFoundException | SQLException e) {
        }


        return datos;
    }

    @Override
    public List<?> buscarclave(String parametro1,int parametro2 ) {
        List<DaoUsuario> datos = new ArrayList<>();
        Connection con;
        PreparedStatement pst;
        ResultSet resultSet;  
        
        String query = "select * from tblusuario where rut = ? and clave = ? ";
        
        try {
            Class.forName(conexion.getDriver());
            con = (Connection) DriverManager.getConnection(conexion.getUrl(), conexion.getUsuario(), conexion.getClave());
            pst = (PreparedStatement) con.prepareStatement(query);
             pst.setString(1, parametro1);
             pst.setInt(2, parametro2);
            resultSet = pst.executeQuery();
            
            while(resultSet.next()){
                datos.add(new DaoUsuario(resultSet.getInt("idusuario"), resultSet.getString("rut"), resultSet.getInt("clave") ));
            }
            
            
        } catch (ClassNotFoundException | SQLException e) {
        }


        return datos;
    }

    @Override
    public List<?> buscarentrenadorporrut(String parametro) {
        List<Daoentrenador> datos = new ArrayList<>();
        Connection con;
        PreparedStatement pst;
        ResultSet resultSet;  
        
        String query = "select * from tblentrenador where rut = ? ";
        
        try {
            Class.forName(conexion.getDriver());
            con = (Connection) DriverManager.getConnection(conexion.getUrl(), conexion.getUsuario(), conexion.getClave());
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setString(1, parametro);
            resultSet = pst.executeQuery();
            
            while(resultSet.next()){
                datos.add(new Daoentrenador(resultSet.getInt("identrenador"), resultSet.getString("rut"), resultSet.getInt("clave") ));
            }
            
            
        } catch (ClassNotFoundException | SQLException e) {
        }


        return datos;
    }

    @Override
    public List<?> buscarclaveentrenador(String parametro1, int parametro2) {
         List<Daoentrenador> datos = new ArrayList<>();
        Connection con;
        PreparedStatement pst;
        ResultSet resultSet;  
        
        String query = "select * from tblentrenador where rut = ? and clave = ? ";
        
        try {
            Class.forName(conexion.getDriver());
            con = (Connection) DriverManager.getConnection(conexion.getUrl(), conexion.getUsuario(), conexion.getClave());
            pst = (PreparedStatement) con.prepareStatement(query);
             pst.setString(1, parametro1);
             pst.setInt(2, parametro2);
            resultSet = pst.executeQuery();
            
            while(resultSet.next()){
                datos.add(new Daoentrenador(resultSet.getInt("identrenador"), resultSet.getString("rut"), resultSet.getInt("clave") ));
            }
            
            
        } catch (ClassNotFoundException | SQLException e) {
        }


        return datos;
    }

    @Override
    public List<?> buscaradministradorporrut(String parametro) {
        List<Daoadministrador> datos = new ArrayList<>();
        Connection con;
        PreparedStatement pst;
        ResultSet resultSet;  
        
        String query = "select * from tbladministrador where rut = ? ";
        
        try {
            Class.forName(conexion.getDriver());
            con = (Connection) DriverManager.getConnection(conexion.getUrl(), conexion.getUsuario(), conexion.getClave());
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setString(1, parametro);
            resultSet = pst.executeQuery();
            
            while(resultSet.next()){
                datos.add(new Daoadministrador(resultSet.getInt("idadministrador"), resultSet.getString("rut"), resultSet.getInt("clave") ));
            }
            
            
        } catch (ClassNotFoundException | SQLException e) {
        }


        return datos;
    }

    @Override
    public List<?> buscarclaveadministrador(String parametro1, int parametro2) {
        List<Daoadministrador> datos = new ArrayList<>();
        Connection con;
        PreparedStatement pst;
        ResultSet resultSet;  
        
        String query = "select * from tbladministrador where rut = ? and clave = ? ";
        
        try {
            Class.forName(conexion.getDriver());
            con = (Connection) DriverManager.getConnection(conexion.getUrl(), conexion.getUsuario(), conexion.getClave());
            pst = (PreparedStatement) con.prepareStatement(query);
             pst.setString(1, parametro1);
             pst.setInt(2, parametro2);
            resultSet = pst.executeQuery();
            
            while(resultSet.next()){
                datos.add(new Daoadministrador(resultSet.getInt("idadministrador"), resultSet.getString("rut"), resultSet.getInt("clave") ));
            }
            
            
        } catch (ClassNotFoundException | SQLException e) {
        }


        return datos;
    }
    @Override
    public List<DaoUsuario> consultar() {
        List<DaoUsuario> datos = new ArrayList<>();
        
        Connection connection;
        PreparedStatement pst;
        
        ResultSet resultSet;
        
        String query = "select *  from tblusuario ";
        
        try {
            Class.forName(conexion.getDriver());
            connection = (Connection) DriverManager.getConnection(conexion.getUrl(), conexion.getUsuario(), conexion.getClave());
            pst = (PreparedStatement) connection.prepareStatement(query);
            
            resultSet = pst.executeQuery();
            
            //pasamos el resultSet 
            
            while(resultSet.next()){
             datos.add(new DaoUsuario( resultSet.getInt(1) , resultSet.getString(2), resultSet.getInt(3)));
            }
            
        } catch (ClassNotFoundException | SQLException e) {
            e.getMessage();            
        }        
        return datos;
    }   
    
    @Override
    public String delete(Object obj) {
     
        DaoUsuario daoUsuario = (DaoUsuario) obj;
        Connection connection;
        PreparedStatement pst,pst2;
        int nfilas,nfilas2;
        
        String query = "delete from tblusuario where idusuario = ?";
        String query2 = "delete from tblevaluacion where idusuario = ?";
        String resp = "";
        
        try {
            Class.forName(conexion.getDriver());
            connection = (Connection) DriverManager.getConnection(conexion.getUrl(), conexion.getUsuario(), conexion.getClave());
            pst2 = (PreparedStatement) connection.prepareStatement(query2);            
            pst2.setInt(1, daoUsuario.getIdusuario());
            nfilas2 = pst2.executeUpdate();
            pst = (PreparedStatement) connection.prepareStatement(query);            
            pst.setInt(1, daoUsuario.getIdusuario());
            
            nfilas = pst.executeUpdate();
            
            if(nfilas > 0){
                resp = "Registro eliminado con exito";
            }else{
                resp = "No se pudo realizar un borrado";
            }
            
        } catch (ClassNotFoundException | SQLException e) {
           resp =  e.getMessage();
        }
        return resp;
        
    }

    @Override
    public String insertarevaluacion(Object obj) {
         Daoregistroevaluacion daoregistroevaluacion  = (Daoregistroevaluacion) obj;
        Connection connection;
        PreparedStatement pst;
        String resp;
        String query="insert into tblevaluacion values(null,?,?,?,?,?,?,?)";
        int nfilas;
       try {
            Class.forName(conexion.getDriver());
            connection = (Connection) DriverManager.getConnection(conexion.getUrl(), conexion.getUsuario(), conexion.getClave());
            pst = (PreparedStatement) connection.prepareStatement(query);
            pst.setInt(1, daoregistroevaluacion.getPeso());
            pst.setDouble(2, daoregistroevaluacion.getEstatura());
            pst.setString(3, daoregistroevaluacion.getFecha());
            pst.setDouble(4, daoregistroevaluacion.getImc());
            pst.setString(5, daoregistroevaluacion.getEstado());
            pst.setInt(6, daoregistroevaluacion.getIdusuario());
            pst.setInt(7, daoregistroevaluacion.getIdentrenador());
       
            nfilas = pst.executeUpdate();
         
       
         if(nfilas > 0){
                resp = "Registro insertado con exito";
            }else{
                resp = "no se registro";
            }
            
          
            
        } catch (ClassNotFoundException | SQLException e) {
            resp = e.getMessage();
        }        
        return resp;
    }

    @Override
    public List<DaoPersona> buscarusuario(String parametro) {
         List<DaoPersona> datos = new ArrayList<>();
        Connection con;
        PreparedStatement pst;
        ResultSet resultSet;  
        
        String query = "select * from tblpersona where rut = ? ";
        
          try {
            Class.forName(conexion.getDriver());
            con = (Connection) DriverManager.getConnection(conexion.getUrl(), conexion.getUsuario(), conexion.getClave());
            pst = (PreparedStatement) con.prepareStatement(query);
             pst.setString(1, parametro);
           
            resultSet = pst.executeQuery();
            
            while(resultSet.next()){
                datos.add(new DaoPersona(resultSet.getString("rut"), resultSet.getString("nombre"), resultSet.getString("apellido"), resultSet.getString("direccion"), resultSet.getInt("fono"), resultSet.getString("email") ));
            }
            
            
        } catch (ClassNotFoundException | SQLException e) {
        }


        return datos;
        
        
        
        
      
        
        
    }

    @Override
    public String updateusuario(Object obj) {
        DaoPersona daoPersona = (DaoPersona) obj;
        Connection connection;
        PreparedStatement pst;
        int nfilas;
        
        String query = "update tblpersona set direccion = ? ,fono = ? , email = ?  where rut = ?";
        String resp = "";
        
        try {
            Class.forName(conexion.getDriver());
            connection = (Connection) DriverManager.getConnection(conexion.getUrl(), conexion.getUsuario(), conexion.getClave());
            pst = (PreparedStatement) connection.prepareStatement(query);
            pst.setString(1, daoPersona.getDireccion());
            pst.setInt(2, daoPersona.getFono());
            pst.setString(3, daoPersona.getEmail());
            pst.setString(4, daoPersona.getRut());
            
            nfilas = pst.executeUpdate();
            
            if(nfilas > 0){
                resp = "Registro actualizado con exito";
            }else{
                resp = "No se realizaron cambios";
            }
            
        } catch (ClassNotFoundException | SQLException e) {
           resp =  e.getMessage();
        }
        return resp;
    }
    
  

   
}
    
    



