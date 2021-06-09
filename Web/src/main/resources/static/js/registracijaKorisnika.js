$(document).ready(function(){

	$("#addKorisnikForm").submit(function(event) {

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
        "uloga" : 2
    	});

// alert(newKorisnik);
     $.ajax({
        type: "POST",
        url: "http://localhost:8181/api/korisnik/registrujClana",
        dataType: "json",
        contentType: "application/json",
        data: obj,
        success: function () {
            alert(obj);
            window.location.href = "zahtevZaRegistracijuClana.html";
        	},
        error: function (data) {
            alert("Da li se poruka prenela?");
            alert(data);
            alert("Izgleda da jeste");
        	}
    	});


	});
	$.ajax({
                type: "GET",
                url: "http://localhost:8181/api/korisnik/zahteviZaRegistracijuClana",
                dataType: "json",
                success: function (response) {                              // ova f-ja se izvršava posle uspešnog zahteva
                    console.log("SUCCESS:\n", response);                    // ispisujemo u konzoli povratnu vrednost radi provere

                    for (let trener of response) {                        // prolazimo kroz listu svih zaposlenih
                        let row = "<tr>";                                   // kreiramo red za tabelu
                        row += "<td>" + trener.ime + "</td>";       // ubacujemo podatke jednog zaposlenog u polja
                        row += "<td>" + trener.prezime + "</td>";
                        row += "<td>" + trener.email + "</td>";
                        row += "<td>" + trener.telefon + "</td>";
                        row += "</tr>";                                     // završavamo kreiranje reda

                        $('#zahteviZaRegistracijuClana').append(row);                        // ubacujemo kreirani red u tabelu čiji je id = employees
                    }
                },
                error: function (response) {
                }
            });
});