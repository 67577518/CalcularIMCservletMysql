<%-- 
    Document   : Registrarevaluacion.jsp
    Created on : 11-06-2021, 9:22:03
    Author     : Anilom
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Dao.DaoUsuario"%>
<%@page import="Model.Persona"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    
           
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">

    <title>Hello, world!</title>
  </head>
 
  <body>
 
       <nav class="navbar navbar-expand-lg navbar-light bg-light ">
           
  <div class="container-fluid  ">
      <a class="navbar-brand" href="index.html">Cerrar sesion</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
       <center>
    <div class="collapse navbar-collapse  " id="navbarSupportedContent">
     
      <ul class="navbar-nav ml-auto">
 <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            ¿Que decea hacer?
           
          </a>
          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
              <li><a class="dropdown-item" href="Registrarevaluacion.html">Registrar Usuario</a></li>   
          </ul>
        </li>

      </ul>
           
        

       
    </div>
            </center>
      
  </div>
           
</nav>
      <br><br>
         

  <center><h1>Registrar Evaluaciones</h1> </center>
  <br><br>
  
       
  <form method="POST" action="Registraevaluacion">
      
      
    <center><div style="width: 300px;">
            
            <select class="form-select" name="usuario" id="idusuario"  style="width: 300px;" aria-label="Default select example">
                <option value="0">Seleccione Usuario</option>
                
                <%
        
        Persona persona = new Persona();
        List<DaoUsuario> datos = new ArrayList();
        
        datos = persona.consultar();
        
        for(DaoUsuario daoUsuario : datos  ){
        %>
            

        <option value="<%= daoUsuario.getIdusuario() %>">  <%= daoUsuario.getRut() %>  </h2> </option>
       
                
        <%
        }
        %>
                
         
    </select> 
    
    <br>
    
    <div class="form-group"><input type="date" name="fecha" required class="form-control"  id="idfecha"  ></div>
    
   
    <br>
    
    
    <div class="form-group"><input type="int" name="peso" required class="form-control" id="idpeso" placeholder="Ingrese peso" ></div>
    
    <br>
    <div class="form-group"><input type="double" name="estatura" required class="form-control" id="idestatura" placeholder="Ingrese estatura" ></div>
   
    <br>
    <br>
    <div class="form-group"><input type="submit" class="btn btn-primary" value="registrar evaluacion"></div>
     
          </div></center>
  </form>

    <!-- Optional JavaScript; choose one of the two! -->

    <!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>

    <!-- Option 2: Separate Popper and Bootstrap JS -->
    <!--
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js" integrity="sha384-SR1sx49pcuLnqZUnnPwx6FCym0wLsk5JZuNx2bPPENzswTNFaQU1RDvt3wT4gWFG" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.min.js" integrity="sha384-j0CNLUeiqtyaRmlzUHCPZ+Gy5fQu0dQ6eZ/xAww941Ai1SxSY+0EQqNXNE6DZiVc" crossorigin="anonymous"></script>
    -->
       

  </body>
</html>