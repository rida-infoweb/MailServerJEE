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
        