$(document).ready(function(){
    var korisnik = localStorage.getItem('id');
        var obj = JSON.stringify({
         "idKorisnika" : korisnik
          });


     $.ajax({
                 type: "POST",
                 url: "http://localhost:8181/api/trener/terminiTrenera",
                 dataType: "json",
                 contentType: "application/json",
                 data: obj,
                 success: function (data) {
                     console.log("SUCCESS : ", data);

                         for (i = 0; i < data.length; i++) {
                         var row = "<tr data-id=" + data[i]['id'] + ">";
                         row += "<td>" + data[i]['nazivTreninga'] + "</td>";
                         row += "<td>" + data[i]['cena'] + "</td>";
                         row += "<td>" + data[i]['datumPocetka'] + "</td>";

                         row += "</tr>";


                         $('#terminiTreninga').append(row);


                             }
                 },
                 error: function (data) {
                     alert("Dogodila se greska, pogledaj konzolu");
                     console.log("ERROR : ", data);
                 }

     });


    let selektovanRed = 0;
    let staraBoja = null;
    $("#terminiTreninga").on('click', 'tr:not(:first-child)', function() {
        if (staraBoja != null) {
            $('#terminiTreninga tr[data-id=' + selektovanRed + ']').css('background-color', staraBoja); // vracamo staru boju
        }
        selektovanRed = this.dataset.id;                    // cuvamo id selektovanog termina
        staraBoja = $(this).css('background-color');        // cuvamo staru boju da bi vratili kad se odselektuje

        $(this).css('background-color', '#a6c9e2');         // postavljamo novu boju
        console.log("Selektovan red ", selektovanRed);      // ispis u konzolu radi provere
    });

    $("#izmeni").click(function() {
        var korisnik = localStorage.getItem('id');
        var termin = selektovanRed;
        var datumPocetka = $("#datumPocetka").val();
        var cena = $("#cena").val();
        var obj = JSON.stringify({
                        "idKorisnika" : korisnik,
                        "idTermina" : termin,
                        "cena" : cena,
                        "datumPocetka" : datumPocetka

                });
       // console.log("Rezervisan termin ", selektovanRed);
        $.ajax({
               type: "POST",
               url: "http://localhost:8181/api/termini/izmena",
               dataType: "json",
               contentType: "application/json",
               data: obj,
               success: function (data) {
                   console.log("SUCCESS : ", data);
                   window.location.href = "izmenaTermina.html";
                   },
               error: function (data) {
                   alert("Greška!");
                   }
               });
    });

});