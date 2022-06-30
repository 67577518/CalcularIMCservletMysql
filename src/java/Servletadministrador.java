/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Dao.DaoUsuario;
import Dao.Daoadministrador;
import Model.Persona;
import java.io.IOException;
import java.io.PrintWriter;
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
public class Servletadministrador extends HttpServlet {

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
       
            /* TODO output your page here. You may use following sample code. */
            String arut,msj,resp;
            arut=" ";
            int aclave = 0;
          
            msj=" ";
           RequestDispatcher requestDispatcher = null;
            HttpSession sesion = request.getSession();
            Persona persona = new Persona();
            if(request.getParameter("arut").trim().equalsIgnoreCase("")){
                msj = "Debe ingresar rut";              
            }else if(request.getParameter("aclave").trim().equalsIgnoreCase("")){
                msj = "Debe ingresar Clave";              
            }else {
                arut=request.getParameter("arut");
                
                aclave=Integer.parseInt(request.getParameter("aclave"));
                
              
            }
           
            List<Daoadministrador> datos;
            datos = new ArrayList<>();
            datos = (List<Daoadministrador>) persona.buscaradministradorporrut(arut);
            
             
                
            if (datos == null || datos.isEmpty()){
              resp="el rut no existe";
              request.setAttribute("resp", resp);
              requestDispatcher = request.getRequestDispatcher("IniciarsesionA.jsp");
              requestDispatcher.forward(request, response);
            
            }else{
              
              List<Daoadministrador> datos1;
              datos1 = new ArrayList<>();
              datos1 = (List<Daoadministrador>) persona.buscarclaveadministrador(arut,aclave);
              if(datos1 == null || datos1.isEmpty()){
               resp="clave incorrecta";
             request.setAttribute("resp", resp);
              requestDispatcher = request.getRequestDispatcher("IniciarsesionA.jsp");
            requestDispatcher.forward(request, response);
           }else{
               sesion.setAttribute("usuario", arut);
               response.sendRedirect("pagadministrador.jsp");
           }
            
            }
           //esto es para redirigir a un jsp;
            
          
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
