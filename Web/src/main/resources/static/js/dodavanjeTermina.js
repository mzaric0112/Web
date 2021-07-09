$(document).ready(function () {
var korisnik = localStorage.getItem('id');
    var obj = JSON.stringify({
     "idKorisnika" : korisnik
      });
    $.ajax({
        type: "POST",
        url: "http://localhost:8181/api/trener/treninziTrenera",
        dataType: "json",
        contentType: "application/json",
        data: obj,
        success: function (data) {                              // ova f-ja se izvršava posle uspešnog zahteva
            console.log("SUCCESS:\n", data);                    // ispisujemo u konzoli povratnu vrednost radi provere

            for (i = 0; i < data.length; i++) {

               var row = "<tr data-id=" + data[i]['id'] + ">";                                 // kreiramo red za tabelu
                row += "<td>" + data[i]['naziv'] + "</td>";       // ubacujemo podatke jednog zaposlenog u polja
                row += "<td>" + data[i]['opis'] + "</td>";
                row += "<td>" + data[i]['tipTreninga'] + "</td>";
                row += "<td>" + data[i]['trajanje'] + "</td>";

                row += "</tr>";                                     // završavamo kreiranje reda

                $('#treninzi').append(row);
                 window.location.href = "izmenaTermina.html";
                                      // ubacujemo kreirani red u tabelu čiji je id = employees
            }
        },
        error: function (data) {
        alert("Dogodila se greska, pogledaj konzolu");
                        console.log("ERROR : ", data);
        }
    });
     let selektovanRed = 0;
        let staraBoja = null;
        $("#treninzi").on('click', 'tr:not(:first-child)', function() {
            if (staraBoja != null) {
                $('#treninzi tr[data-id=' + selektovanRed + ']').css('background-color', staraBoja); // vracamo staru boju
            }
            selektovanRed = this.dataset.id;                    // cuvamo id selektovanog termina
            staraBoja = $(this).css('background-color');        // cuvamo staru boju da bi vratili kad se odselektuje

            $(this).css('background-color', '#a6c9e2');         // postavljamo novu boju
            console.log("Selektovan red ", selektovanRed);      // ispis u konzolu radi provere
        });
     $("#kreiraj").click(function() {
             var korisnik = localStorage.getItem('id');
             var trening = selektovanRed;
             var datumPocetka = $("#datumPocetka").val();
             var cena = $("#cena").val();
              var obj = JSON.stringify({
                             "korisnik" : korisnik,
                             "trening" : trening,
                             "datumPocetka" : datumPocetka,
                             "cena" : cena
                     });
            // console.log("Rezervisan termin ", selektovanRed);
             $.ajax({
                    type: "POST",
                    url: "http://localhost:8181/api/termini/kreiranje",
                    dataType: "json",
                    contentType: "application/json",
                    data: obj,
                    success: function (data) {
                        console.log("SUCCESS : ", data);
                        },
                    error: function (data) {
                        alert("Greška!");
                        }
                    });
         });

});