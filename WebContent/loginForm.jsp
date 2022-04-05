<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Messagerie GLCL</title>
<link href="static/css/bootstrap.min.css" rel="stylesheet">
    </head>
<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <h2 class="page-section-heading text-center text-uppercase">Messagerie �lectronique</h2>
                    <div class="row text-center">
                    <div class="col-lg-10 ms-auto"><p class="lead">Messagerie �lectronique des �tudiants du Master G�nie Logiciel pour le Cloud</p></div>
                </div> 
  </div>
</nav>
         
        <section class="page-section mt-5" >
            <div class="container">
                <!-- Contact Section Heading-->
                <h2 class="text-center text-uppercase text-secondary mt-5">Authentification</h2>

                <div class="row justify-content-center">
                    <div class="col-lg-12 col-xl-12">


        <%@include file="formulaires/loginForm.jsp" %>


                       
                    </div>
                </div>
            </div>
        </section>
<script src="static/loginForm.js"></script>

</body>
</html>
