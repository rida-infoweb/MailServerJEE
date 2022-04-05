function validateForm() {
  let email = document.getElementById("email").value;
  let password = document.getElementById("password").value;
  let validRegex = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@rida.ma/;

 var text_champ_oblig, text_email;
  if (email ==="" || password === "") {
        text_champ_oblig = "Tous les champs obligatoires !";
        document.getElementById("text_champ_oblig").innerHTML = text_champ_oblig;
    return false;
  }
 if (!email.match(validRegex)){
        text_email = "Email invalide !";
        document.getElementById("text_email").innerHTML = text_email;
    return false;
	
}

}
