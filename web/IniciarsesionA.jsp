<%-- 
    Document   : IniciarsesionA
    Created on : 11-06-2021, 3:03:41
    Author     : Anilom
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
 

  
     
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="text/javascript" src="js/validarRut.js"></script>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
     
    <title>Hello, world!</title>
  
  <body>
      
      
      
             <nav class="navbar navbar-expand-lg navbar-light bg-light ">
           
  <div class="container-fluid  ">
       <a class="navbar-brand" href="index.html"><img src="Img/png.png" class="img-fluid" width="70px" height="70px"></a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
       <center>
    <div class="collapse navbar-collapse  " id="navbarSupportedContent">
     
      
        

       
    </div>
            </center>
      
  </div>
           
</nav>
    <div class="mx-auto" style="text-align: center">
         <br>
         <center><h1>${resp}</h1></center><br>
         <br>
          <br>
   <h1>Iniciar Sesión Administrador </h1>
   <br> <br>
     




    </div>
      
    

    <!-- Optional JavaScript; choose one of the two! -->

    <!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>

    <!-- Option 2: Separate Popper and Bootstrap JS -->
    <!--
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js" integrity="sha384-SR1sx49pcuLnqZUnnPwx6FCym0wLsk5JZuNx2bPPENzswTNFaQU1RDvt3wT4gWFG" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.min.js" integrity="sha384-j0CNLUeiqtyaRmlzUHCPZ+Gy5fQu0dQ6eZ/xAww941Ai1SxSY+0EQqNXNE6DZiVc" crossorigin="anonymous"></script>
    -->
    <form method="POST" action="Servletadministrador">
  <center><div class="form-floating col-md-4 " style="width: 300px;">
          <input type="text" class="form-control" id="idarut" placeholder="Ingrese Rut" maxlength="10" autofocus oninput="checkRut(this)"  name="arut">
  <label for="floatingInput">Ingrese Rut</label>
        </div>
    <br>
<div class="form-floating" style="width: 300px;">
    <input type="password" class="form-control" id="idaclave" maxlength="4" placeholder="clave" required name="aclave">
  <label for="floatingPassword">Ingrese Clave</label>
</div>
    
    <br><br>
    <button type="sumbit" class="btn btn-success">Iniciar Sesión </button>

   </center>
  </form>
  
  </body>
</html>