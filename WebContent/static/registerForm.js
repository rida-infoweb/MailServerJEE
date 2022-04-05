function validateForm() {
  let name = document.getElementById("name").value;
  let email = document.getElementById("email").value;
  let password = document.getElementById("password").value;
  let passwordC = document.getElementById("passwordC").value;
  let validRegex = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@rida.ma/;

 var text_champ_oblig, text_pass,text_email;
  if (name === "" || email ==="" || password === "", passwordC === "") {
        text_champ_oblig = "Tous les champs obligatoires !";
        document.getElementById("text_champ_oblig").innerHTML = text_champ_oblig;
    return false;
  }
 if (!email.match(validRegex)){
        text_email = "Email invalide !";
        document.getElementById("text_email").innerHTML = text_email;
    return false;
	
}
  if ( password != passwordC) {
        text_pass = "Les mots de passe ne sont pas semblables !";
        document.getElementById("text_pass").innerHTML = text_pass;

    return false;
  }

}
