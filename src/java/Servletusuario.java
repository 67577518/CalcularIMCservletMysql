/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Dao.DaoUsuario;
import Model.Persona;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Anilom
 */
public class Servletusuario extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
          
            String urut,resp,caca = null;
            urut=" ";
            int caca1 = 0,caca2 = 0;
           int uclave = 0;
            Persona persona = new Persona();
            DaoUsuario daoUsuario = new DaoUsuario();
            RequestDispatcher requestDispatcher = null;
            HttpSession sesion = request.getSession();
            String rut = null;
            
            if(request.getParameter("urut").trim().equalsIgnoreCase("")){
                String msj = "Debe ingresar rut";              
            }else if(request.getParameter("uclave").trim().equalsIgnoreCase("")){
                String msj = "Debe ingresar Clave";              
            }else {
              urut=request.getParameter("urut");
              uclave=Integer.parseInt(request.getParameter("uclave"));

                
            }
         
            
            
            
            List<DaoUsuario> datos;
            datos = new ArrayList<>();
            datos = persona.buscarusuarioporrut(urut);
            
             
                
            if (datos == null || datos.isEmpty()){
              resp="el rut no existe";
           request.setAttribute("resp", resp);
            requestDispatcher = request.getRequestDispatcher("IniciarsesionU.jsp");
            requestDispatcher.forward(request, response);
            
            }else{
              
                 List<DaoUsuario> datos1;
            datos1 = new ArrayList<>();
            datos1 = (List<DaoUsuario>) persona.buscarclave(urut,uclave);
           if(datos1 == null || datos1.isEmpty()){
               resp="clave incorrecta";
           request.setAttribute("resp", resp);
            requestDispatcher = request.getRequestDispatcher("IniciarsesionU.jsp");
            requestDispatcher.forward(request, response);
           }else{
               for( DaoUsuario daousuario : datos1){
                   caca =daousuario.getRut();
                   caca1 = daousuario.getIdusuario();
                   caca2 = daousuario.getClave();
               }
               DaoUsuario usu = new DaoUsuario(caca1, caca,caca2);
                HttpSession session = request.getSession();
                session.setAttribute("usuario", usu);
                request.getRequestDispatcher("pagusuario.jsp").forward(request, response);
           }
            
            }
             
                
                 
            
            
           
            
           
           
           
        }
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
    
        
    
