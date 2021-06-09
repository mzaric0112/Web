$(document).ready(function(){

	$("#dodavanjeFitnesCentraForm").submit(function(event) {

	    event.preventDefault();
	    var naziv = $("#naziv").val();
	    var adresa = $("#adresa").val();
	    var brojCentrale = $("#brojCentrale").val();
	    var email = $("#email").val();
		var obj = JSON.stringify({
        "naziv" : naziv,
        "adresa" : adresa,
        "brojCentrale" : brojCentrale,
        "email" : email,

    	});

// alert(newKorisnik);
     $.ajax({
        type: "POST",
        url: "http://localhost:8181/api/fitnesCentar",
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