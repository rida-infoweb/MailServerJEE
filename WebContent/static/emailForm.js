function validateForm() {
  let recipient = document.getElementById("recipient").value;
  let subject = document.getElementById("subject").value;
  let validRegex = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@rida.ma/;

 var text_champ_oblig, text_email;
  if (recipient ==="" || subject === "") {
        text_champ_oblig = "Tous les champs obligatoires !";
        document.getElementById("text_champ_oblig").innerHTML = text_champ_oblig;
    return false;
  }
 if (!recipient.match(validRegex)){
        text_email = "Email invalide !";
        document.getElementById("text_email").innerHTML = text_email;
    return false;
	
}

}
