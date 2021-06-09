$(document).ready(function(){

	$("#addTrenerForm").submit(function(event) {

	    event.preventDefault();
	    var korisnickoIme = $("#korisnickoIme").val();
	    var lozinka = $("#lozinka").val();
	    var ime = $("#ime").val();
	    var prezime = $("#prezime").val();
	    var telefon = $("#telefon").val();
	    var email = $("#email").val();
    	var datumRodjenja = $("#datumRodjenja").val();

        //obratiti paznju na nazive
		var obj = JSON.stringify({
        "korisnickoIme" : korisnickoIme,
        "lozinka" : lozinka,
        "ime" : ime,
        "prezime" : prezime,
        "telefon" : telefon,
        "email" : email,
        "datumRodjenja" : datumRodjenja,
        "uloga" : 1
    	});

// alert(newKorisnik);
     $.ajax({
        type: "POST",
        url: "http://localhost:8181/api/korisnik/registracija",
        dataType: "json",
        contentType: "application/json",
        data: obj,
        success: function () {
            alert(obj);
            window.location.href = "index.html";
        	},
        error: function (data) {
            alert("Da li se poruka prenela?");
            alert(data);
            alert("Izgleda da jeste");
        	}
    	});


	});
});