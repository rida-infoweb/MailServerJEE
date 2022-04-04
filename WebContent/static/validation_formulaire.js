function validateForm() {
  let nom = document.getElementById("nom").value;
  let prenom = document.getElementById("prenom").value;
  let note = document.getElementById("note").value;
 var text_nom, text_note;
  if (nom === "" || prenom ==="" || note.length == 0) {
        text_nom = "Tous les champs obligatoires !";
        document.getElementById("text_nom").innerHTML = text_nom;
    return false;
  }
 
  if ( note < 0 || note > 20) {
        text_note = "La note est comprise entre 0 et 20 !";
        document.getElementById("text_note").innerHTML = text_note;

    return false;
  }

}