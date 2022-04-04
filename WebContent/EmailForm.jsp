<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Mailing Server GLCL</title>
<link href="static/css/bootstrap.min.css" rel="stylesheet">
    </head>
<body>
	        <section class="page-section mt-5" >
            <div class="container">
                <!-- Contact Section Heading-->
                <h2 class="text-center text-uppercase text-secondary mt-5">Nouveau Message</h2>

                <div class="row justify-content-center">
                    <div class="col-lg-12 col-xl-12">




<form action="EmailSendingServlet" method="post">

                <div class="form-group row">
    <label for="recipient" class="col-sm-2 col-form-label">Destinataires</label>
    
    <div class="col-sm-6">
      <input type="text" name="recipient" class="form-control" id="recipient" placeholder="Destinataires">
      
      
    </div>
  </div>
  <div class="form-group row">
    <label for="subject" class="col-sm-2 col-form-label">Objet</label>
    <div class="col-sm-6">
      <input type="text" name="subject" class="form-control" id="subject" placeholder="Objet">

    </div>
  </div>
  <div class="form-group row">
    <label for="content" class="col-sm-2 col-form-label">Note</label>
    <div class="col-sm-6">
<td><textarea rows="10" cols="39" name="content"></textarea> </td>
    </div>
  </div>
  <button type="submit" class="btn btn-lg btn-success mb-2">Envoyer</button>
</form>
                       
                    </div>
                </div>
            </div>
        </section>
</body>
</html>



<!--
<form action="EmailSendingServlet" method="post">
		<table border="0" width="35%" align="center">
			<caption> <h2>Nouveau E-mail</h2> </caption>
			<tr>
				<td>Adresse de destination </td>
				<td><input type="text" name="recipient" size="50"/></td>
			</tr>
			<tr>
				<td>Objet </td>
				<td><input type="text" name="subject" size="50"/></td>
			</tr>
			<tr>
				<td>Contenu </td>
				<td><textarea rows="10" cols="39" name="content"></textarea> </td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" />Envoyer</td>
			</tr>
		</table>
		
		
		
	</form>
  -->
*/