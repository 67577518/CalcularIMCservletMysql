/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Dao.Daoentrenador;
import Dao.Daoregistroevaluacion;
import Model.Persona;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
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
public class Registraevaluacion extends HttpServlet {

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
         Daoregistroevaluacion daoregistroevaluacion = new Daoregistroevaluacion();
            Persona persona = new Persona();
            RequestDispatcher requestDispatcher = null;
            String fecha,estado,msj,resp;
            int peso = 0,usuario,identrenador;
            double imc,estatura;
            imc = 0;
            estado=" ";
            msj=" ";
            estatura = 0;
            usuario=Integer.parseInt(request.getParameter("usuario"));
            if(usuario == 0){
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Debe ingresar usuario');");
                out.println("</script>");
                msj="  ";
            }else if(request.getParameter("fecha").trim().equalsIgnoreCase("")){
              
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Debe ingresar fecha');");
                out.println("</script>");
                msj="  ";
            }else if(request.getParameter("peso").trim().equalsIgnoreCase("")){
               
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Debe ingresar peso');");
                out.println("</script>");
                msj="  ";
            }else if(request.getParameter("estatura").trim().equalsIgnoreCase("")){
                
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Debe ingresar estatura');");
                out.println("</script>");
                msj="  ";
            }else {
                peso=Integer.parseInt(request.getParameter("peso"));
                estatura=Double.parseDouble(request.getParameter("estatura"));
                fecha=request.getParameter("fecha");
                
                Calcularimc calcularimc = new Calcularimc(peso, estatura);
                imc = calcularimc.operacion();
                
                if(imc < 18.5){
                estado= "Bajo peso";
                }else{
                if(imc < 24.9){
                estado= "normal";
                }else{
                if(imc < 29.9){
                    estado= "sobrepeso";
                }else{
                if(imc < 34.9){
                    estado= "obesidad I";
                }else{
                if(imc < 39.9){
                    estado= "obesidad II";
                }else{
                if(imc < 49.9){
                    estado= "obesidad III";
                }else{
                if(imc > 50){
                    estado= "obesidad IV";
                }else{

                }
                }
                }
                }
                }
                }
                }
                  HttpSession session = request.getSession();
                  Daoentrenador usu = (Daoentrenador)session.getAttribute("usuario");
                  identrenador=usu.getIdentrenador();
                   daoregistroevaluacion.setPeso(peso);
                   daoregistroevaluacion.setEstatura(estatura);
                   daoregistroevaluacion.setFecha(fecha);
                   daoregistroevaluacion.setImc(imc);
                   daoregistroevaluacion.setEstado(estado);
                   daoregistroevaluacion.setIdusuario(usuario);
                   daoregistroevaluacion.setIdentrenador(identrenador);
                   
                 resp = persona.insertarevaluacion(daoregistroevaluacion);
                 
                 request.setAttribute("resp", resp);
                  requestDispatcher = request.getRequestDispatcher("pagentrenador.jsp");
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
