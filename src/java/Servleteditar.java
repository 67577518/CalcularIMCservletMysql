/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Dao.DaoPersona;
import Model.Persona;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Anilom
 */
public class Servleteditar extends HttpServlet {

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
      
       DaoPersona daoPersona = new DaoPersona();
        Persona persona = new Persona();
        RequestDispatcher rd = null;
            String msj,urut,unombre,uapellido,udireccion,uemail,resp;
            int ufono;
            msj = " ";
            urut = " ";
            unombre = " ";
            uapellido = " ";
            udireccion = " ";
            uemail = " ";
            ufono = 0;
            if(request.getParameter("urut").trim().equalsIgnoreCase("")){
                msj = "Debe ingresar rut";              
            }else if(request.getParameter("unombre").trim().equalsIgnoreCase("")){
                msj = "Debe ingresar Nombre";              
            }else if(request.getParameter("uapellido").trim().equalsIgnoreCase("")){
                msj = "Debe ingresar Apellido";               
            }else if(request.getParameter("udireccion").trim().equalsIgnoreCase("")){
                msj = "Debe ingresar la Direccion";                
            }else if(request.getParameter("ufono").trim().equalsIgnoreCase("")){
                msj = "Debe ingresar Fono";                
            }else if(request.getParameter("uemail").trim().equalsIgnoreCase("")){
                msj = "Debe ingresar Email";               
            }else{
                urut=request.getParameter("urut");
                unombre=request.getParameter("unombre");
                uapellido=request.getParameter("uapellido");
                udireccion=request.getParameter("udireccion");
                ufono=Integer.parseInt(request.getParameter("ufono"));
                uemail=request.getParameter("uemail");
                
                daoPersona.setRut(urut);
                daoPersona.setNombre(unombre);
                daoPersona.setApellido(uapellido);
                daoPersona.setDireccion(udireccion);
                daoPersona.setFono(ufono);
                daoPersona.setEmail(uemail);
                
                resp = persona.updateusuario(daoPersona);
                
                  request.setAttribute("resp", resp);
                  rd = request.getRequestDispatcher("pagusuario.jsp");
                  rd.forward(request, response);
                
                
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
