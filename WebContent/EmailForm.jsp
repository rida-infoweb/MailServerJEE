<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.mail.entities.User"%>
    
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
<%
//allow access only if session exists
User user = (User) session.getAttribute("user");
String userName = null;
String sessionID = null;
Cookie[] cookies = request.getCookies();
if(cookies !=null){
for(Cookie cookie : cookies){
	if(cookie.getName().equals("user")) userName = cookie.getValue();
	if(cookie.getName().equals("JSESSIONID")) sessionID = cookie.getValue();
}
}
%>


<nav class="navbar navbar-expand-lg navbar-light bg-light">
<div class="container-fluid">
<h2 class="page-section-heading text-center text-uppercase">Messagerie électronique</h2>
                 <div class="row text-center">
                 <div class="col-lg-10 ms-auto"><p class="lead">Messagerie électronique des étudiants du Master Génie Logiciel pour le Cloud</p></div>
                </div>       
  </div>
</nav>
 <section class="page-section mt-5" >
            <div class="container">
               <div class="row mt-2">
  <table class="table table-secondary">
  <thead>
    <tr>
      <th>Bonjour Mr <%=user.getName()%></th>
      <th><%=userName %></th>
    </tr>
  </thead>
</table> 
 </div>
           <div class="container">
  <div class="row">
    <div class="col-sm">
    <form action="LogoutServlet" method="post">
<input type="submit" value="Se déconnecter" class="text-center text-uppercase text-white btn btn-danger" >
</form>
    </div>
    <div class="col-sm">
      <a class="text-center text-uppercase text-white btn btn-success" class=""href="ShowReceivingMail">Messages reçus</a>
    </div>
    <div class="col-sm">
      <a class="text-center text-uppercase text-white btn btn-warning" class=""href="MsgEnvoyesServlet">Messages envoyés</a>
    </div>
  </div>
 
</div> 


                <!-- Contact Section Heading-->
                <h2 class="text-center text-uppercase text-secondary mt-5">Nouveau message</h2>

                <div class="row justify-content-center">
                    <div class="col-lg-12 col-xl-12">


        <%@include file="formulaires/EmailForm.jsp" %>


                       
                    </div>
                </div>
            </div>
        </section>  
         
       

</body>
</html>