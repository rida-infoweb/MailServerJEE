<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="com.mail.entities.Email"%>

    
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

    <nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <h2 class="page-section-heading text-center text-uppercase">Messagerie électronique</h2>
                    <div class="row text-center">
                    <div class="col-lg-10 ms-auto"><p class="lead">Messagerie électronique des étudiants du Master Génie Logiciel pour le Cloud</p></div>
                </div> 
  </div>
</nav>
<%
List<Email> emails = (List<Email>)request.getAttribute("emails");

%>
    <section class="page-section mt-5" >
            <div class="container">
                <!-- Contact Section Heading-->
                <h2 class="text-center text-uppercase text-secondary mt-5">Messages reçus</h2>

                <div class="row justify-content-center">
                    <div class="col-lg-12 col-xl-12">
<table class="table table-striped table-bordered">
	<tr>
		<th>From</th>
		<th>Object</th>
		<th>Messages</th>
		
	</tr>
<%
	for(Email e : emails){
%>
	<tr>
		<td><%=e.getFrom() %></td>
		<td><%=e.getObjet() %></td>
		<td><%=e.getMessage() %></td>
	
	</tr>
<%
	}
%>
</table>

                       
                    </div>
                </div>
            </div>
        </section>     
      
      

</body>
</html>