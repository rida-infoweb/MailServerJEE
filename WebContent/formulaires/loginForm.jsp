<form name="form" action="login" method="post"  onsubmit="return validateForm()">
                <h4 class="text-center text-danger mt-5" id ="text_champ_oblig"></h4>
                <h4 class="text-center text-danger mt-5" id ="text_pass"></h4>
                <h4 class="text-center text-danger mt-5" id ="text_email"></h4>
   

                <div class="form-group row">
  </div>
  
  <div class="form-group row">
    <label for="email" class="col-sm-4 col-form-label font-weight-bold ">Email</label>
    <div class="col-sm-8">
      <input type="text" name="email" class="form-control" id="email" placeholder="xxxx@rida.ma">

    </div>
  </div>
  <div class="form-group row">
    <label for="password" class="col-sm-4 col-form-label font-weight-bold">Mot de passe</label>
    <div class="col-sm-8">
      <input type="password" name="password" class="form-control" id="password" placeholder="Mot de passe">

    </div>
  </div>

  <button type="submit" class="btn btn-lg btn-success mb-2">S'authentifier</button>
</form>