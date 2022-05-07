<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.Collection"%>
    <%@page import="com.mail.entities.User"%>
    
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Messagerie GLCL</title>
<link href="static/css/bootstrap.min.css" rel="stylesheet">

    </head>
    <body >
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <h2 class="page-section-heading text-center text-uppercase">Messagerie électronique</h2>
                    <div class="row text-center">
                    <div class="col-lg-10 ms-auto"><p class="lead">Messagerie électronique des étudiants du Master Génie Logiciel pour le Cloud</p></div>
                </div>             
  </div>
</nav>
<%
User userexistant = (User)request.getAttribute("userexistant");

%>
   
        <section class="page-section mt-5" >
            <div class="container">
                <!-- Contact Section Heading-->
                <h1 class="text-center text-uppercase text-white mt-5"><span class="badge bg-secondary">Liste des utilisateurs</span></h1>
                <div class="row justify-content-center">
                    <div class="col-lg-12 col-xl-12">
                    <div class="row">

<table class="table table-striped table-bordered">
	<tr>
		<th>Confirmez vous votre suppression ?</th>

	</tr>

	<tr>
		<td class="text-center">
			<a href="DeleteUserConfServlet?id=<%=userexistant.getId() %>" class="btn btn-success">Oui</a>
			<a href="ListUserServlet" class="btn btn-danger">Non</a>
			
			
		</td>
	</tr>

</table> 
</div>                
                    </div>
                </div>
            </div>
        </section>
        
        
<script src="static/js/bootstrap.bundle.min.js"></script>
    </body>
</html>