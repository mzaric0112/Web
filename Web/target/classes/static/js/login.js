$(document).ready(function(){

  $("#loginKorisnikForm").submit(function(event) {

      event.preventDefault();
      var korisnickoIme = $("#korisnickoIme").val();
      var lozinka= $("#lozinka").val();

      var obj = JSON.stringify({
      "korisnickoIme" : korisnickoIme,
      "lozinka" : lozinka
      });

   $.ajax({
      type: "POST",
      url: "http://localhost:8080/api",
      dataType: "json",
      contentType: "application/json",
      data: obj,
      success: function (data) {

          console.log("SUCCESS : ", data);

          localStorage.setItem('id', data.id);
          localStorage.setItem('ime', data.ime);
          localStorage.setItem('prezime', data.prezime);
          localStorage.setItem('korisnickoIme', data.korisnickoIme);
          localStorage.setItem('telefon', data.telefon);
          localStorage.setItem('uloga', data.uloga);
          localStorage.setItem('email', data.email);
          localStorage.setItem('datumRodjenja', data.datumRodjenja);
          localStorage.setItem('korisnickoIme', data.korisnickoIme);

          window.location.href = "index.html";
          },
      error: function (data) {
          console.log("ERROR " + JSON.stringify(data));
          alert("Nalog nije aktivan, proverite unos ili se obratite adminu");
          }
      });
  });
});

