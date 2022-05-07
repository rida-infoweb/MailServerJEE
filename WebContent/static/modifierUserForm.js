function validateForm() {
  let name = document.getElementById("name").value;
  let password = document.getElementById("password").value;
  let passwordC = document.getElementById("passwordC").value;

 var text_champ_oblig, text_pass;
  if (name === "" || password === "", passwordC === "") {
        text_champ_oblig = "Tous les champs obligatoires !";
        document.getElementById("text_champ_oblig").innerHTML = text_champ_oblig;
    return false;
  }

  if ( password != passwordC) {
        text_pass = "Les mots de passe ne sont pas semblables !";
        document.getElementById("text_pass").innerHTML = text_pass;

    return false;
  }

}
