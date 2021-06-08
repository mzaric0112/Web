$(document).ready(function () {
    $.ajax({
        type: "GET",
        url: "http://localhost:8181/api/treninzi",
        dataType: "json",
        success: function (response) {                              // ova f-ja se izvršava posle uspešnog zahteva
            console.log("SUCCESS:\n", response);                    // ispisujemo u konzoli povratnu vrednost radi provere

            for (let trening of response) {                        // prolazimo kroz listu svih zaposlenih
                let row = "<tr>";                                   // kreiramo red za tabelu
                row += "<td>" + trening.naziv + "</td>";       // ubacujemo podatke jednog zaposlenog u polja
                row += "<td>" + trening.opis + "</td>";
                row += "<td>" + trening.tipTreninga + "</td>";
                row += "<td>" + trening.trajanje + "</td>";
                row += "</tr>";                                     // završavamo kreiranje reda

                $('#treninzi').append(row);                        // ubacujemo kreirani red u tabelu čiji je id = employees
            }
        },
        error: function (response) {
        }
    });
});