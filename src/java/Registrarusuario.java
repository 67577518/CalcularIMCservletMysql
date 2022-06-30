/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Dao.DaoPersona;
import Dao.DaoPersonausuario;
import Dao.DaoUsuario;
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

/**
 *
 * @author Anilom
 */
public class Registrarusuario extends HttpServlet {

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
        String msj,rut,nombre,apellido,direccion,email,resp = null;
            int fono,clave;
            
            DaoPersonausuario daoPersonausuario = new DaoPersonausuario();
            DaoUsuario daoUsuario = new DaoUsuario();
            Persona persona = new Persona();
            RequestDispatcher requestDispatcher = null;
        
            
           
            if(request.getParameter("rut").trim().equalsIgnoreCase("")){
                msj = "Debe ingresar rut";              
            }else if(request.getParameter("nombre").trim().equalsIgnoreCase("")){
                msj = "Debe ingresar Nombre";              
            }else if(request.getParameter("apellido").trim().equalsIgnoreCase("")){
                msj = "Debe ingresar Apellido";               
            }else if(request.getParameter("direccion").trim().equalsIgnoreCase("")){
                msj = "Debe ingresar la Direccion";                
            }else if(request.getParameter("fono").trim().equalsIgnoreCase("")){
                msj = "Debe ingresar Fono";                
            }else if(request.getParameter("email").trim().equalsIgnoreCase("")){
                msj = "Debe ingresar Email";               
            }else if(request.getParameter("clave").trim().equalsIgnoreCase("")){
                msj = "Debe ingresar clave";               
            }else{
                rut=request.getParameter("rut");
                nombre=request.getParameter("nombre");
                apellido=request.getParameter("apellido");
                direccion=request.getParameter("direccion");
                fono=Integer.parseInt(request.getParameter("fono"));
                email=request.getParameter("email");
                clave=Integer.parseInt(request.getParameter("clave"));
                
                
                List<DaoPersona> datos = new ArrayList<>();
                datos = persona.buscarinsertar(rut);
                
                
                if (datos == null || datos.isEmpty()){
                         daoPersonausuario.setRut(rut);
                         daoPersonausuario.setNombre(nombre);
                         daoPersonausuario.setApellido(apellido);
                         daoPersonausuario.setDireccion(direccion);
                         daoPersonausuario.setFono(fono);
                         daoPersonausuario.setEmail(email);
                         daoPersonausuario.setClave(clave);
                         
                         resp = persona.insertar(daoPersonausuario);
                         
                      
                
                }else{
                   List<DaoUsuario> datos1;
                   datos1 = new ArrayList<>();
                   datos1 = persona.buscarusuarioporrut(rut);
            
             
                
              if (datos1 == null || datos1.isEmpty()){
                   daoUsuario.setRut(rut);
                  daoUsuario.setClave(clave);
             resp = persona.insertarusuario(daoUsuario);
              
            
            }else{
                    resp = "el usuario ya se encuentra registrado";
                    request.setAttribute("resp", resp);
                    requestDispatcher = request.getRequestDispatcher("pagadministrador.jsp");
                    requestDispatcher.forward(request, response);
                 
            
            }
                     
     
                
            }
                request.setAttribute("resp", resp);
                  requestDispatcher = request.getRequestDispatcher("pagadministrador.jsp");
                  requestDispatcher.forward(request, response);
              
    
    
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
    
        
    
