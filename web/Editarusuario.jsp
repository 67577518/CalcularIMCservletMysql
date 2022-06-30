<%-- 
    Document   : Editarusuario
    Created on : 15-07-2021, 1:02:55
    Author     : Anilom
--%>

<%@page import="Dao.DaoPersona"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
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
      <a class="navbar-brand" href="index.html">Cerrar Sesion</a>
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
              <li><a class="dropdown-item" href="Buscarevaluaciones.html">buscar evaluaciones</a></li>
              <li><a class="dropdown-item" href="Editarusuario.html">Editar Usuario</a></li>
            
          </ul>
        </li>

      </ul>
           
        

       
    </div>
            </center>
      
  </div>
           
</nav>
      <br><br>
         

  <center><h1>Editar Perfil</h1> </center>
  <br><br>
  <form action="Servleteditar" method="POST">
      <center><div style="width: 300px;">
                      <%
        
       // DaoPersona daoPersona = new DaoPersona();
        List<DaoPersona> datos = new ArrayList(); 
        
        datos = (List<DaoPersona>)request.getAttribute("datos");
          
        for(DaoPersona daoPersona: datos){      
        %>
        
       
      
      
      <div class="form-group">
        <label for="">Rut</label>        
        <input type="text" name="urut" class="form-control" readonly id="idurut" required  value="<%= daoPersona.getRut() %>">
        </div>
        <div class="form-group">
            <label for="">Nombre</label>        
            <input type="text" name="unombre" class="form-control"  id="idunombre" required readonly value="<%= daoPersona.getNombre() %>">
            
          </div>
        <div class="form-group">  
            <label for="">Apellido</label>      
            <input type="text" name="uapellido" class="form-control" readonly  required id="iduapellido"  value="<%= daoPersona.getApellido() %>">        
           
        </div>
        <div class="form-group"> 
            <label for="">Direccion</label>       
            <input type="text" name="udireccion" class="form-control" id="idudireccion" required value="<%= daoPersona.getDireccion() %>">        
            
          </div>
          <div class="form-group">
            <label for="">Telefono</label>        
            <input type="tel" name="ufono" class="form-control" id="idufono" pattern="[0-9]+" maxlength="9" required value="<%= daoPersona.getFono() %>">        
           
          </div>
          <div class="form-group">
            <label for="">Email</label>        
            <input type="email" name="uemail" class="form-control" id="iduemail" required value="<%= daoPersona.getEmail() %>">        
           
          </div>
          
        <%
         }
        %>
        
              
              <br><br>
          <button type="submit" class="btn btn-primary" value="Add Producto">Actualizar</button>
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