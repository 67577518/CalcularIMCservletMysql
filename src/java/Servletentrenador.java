/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Dao.DaoUsuario;
import Dao.Daoentrenador;
import Model.Persona;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
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
public class Servletentrenador extends HttpServlet {

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
        String tipo = request.getParameter("tipo");
     
            /* TODO output your page here. You may use following sample code. */
            String erut,msj,resp,caca=" ";
            erut=" ";
            int eclave = 0 ,caca1 = 0,caca2 = 0;
            
            msj=" ";
                 RequestDispatcher requestDispatcher = null;
          
          Persona persona = new Persona();
            if(request.getParameter("erut").trim().equalsIgnoreCase("")){
                msj = "Debe ingresar rut";              
            }else if(request.getParameter("eclave").trim().equalsIgnoreCase("")){
                msj = "Debe ingresar Clave";              
            }else {
                erut=request.getParameter("erut");
                
               eclave=Integer.parseInt(request.getParameter("eclave"));
              
            }
           List<Daoentrenador> datos;
            datos = new ArrayList<>();
            datos = (List<Daoentrenador>) persona.buscarentrenadorporrut(erut);
            
             
                
            if (datos == null || datos.isEmpty()){
              resp="el rut no existe";
           request.setAttribute("resp", resp);
            requestDispatcher = request.getRequestDispatcher("IniciarsesionE.jsp");
            requestDispatcher.forward(request, response);
            
            }else{
              
                 List<Daoentrenador> datos1;
            datos1 = new ArrayList<>();
            datos1 = (List<Daoentrenador>) persona.buscarclaveentrenador(erut,eclave);
           if(datos1 == null || datos1.isEmpty()){
               resp="clave incorrecta";
            request.setAttribute("resp", resp);
            requestDispatcher = request.getRequestDispatcher("IniciarsesionE.jsp");
            requestDispatcher.forward(request, response);
           }else{
               for( Daoentrenador daoentrenador : datos1){
                   caca =daoentrenador.getRut();
                   caca1 = daoentrenador.getIdentrenador();
                   caca2 = daoentrenador.getClave();
               }
               Daoentrenador usu = new Daoentrenador(caca1, caca,caca2);
                HttpSession session = request.getSession();
                session.setAttribute("usuario", usu);
                request.getRequestDispatcher("pagentrenador.jsp").forward(request, response);
            
           
           
               
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
