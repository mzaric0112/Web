$(document).ready(function(){

      $.ajax({
                      type: "GET",
                      url: "http://localhost:8181/api/fitnesCentar",
                      dataType: "json",
                      success: function (data) {                              // ova f-ja se izvršava posle uspešnog zahteva
                          console.log("SUCCESS:\n", data);                    // ispisujemo u konzoli povratnu vrednost radi provere

                        for (i = 0; i < data.length; i++) {
                            var row = "<tr data-id=" + data[i]['id'] + ">";                                  // kreiramo red za tabelu
                              row += "<td>" + data[i]['naziv'] + "</td>";       // ubacujemo podatke jednog zaposlenog u polja
                              row += "<td>" + data[i]['adresa']  + "</td>";
                              row += "<td>" + data[i]['brojCentrale'] + "</td>";
                              row += "<td>" + data[i]['email'] + "</td>";
                              row += "</tr>";                                     // završavamo kreiranje reda

                              $('#fitnesCentri').append(row);                        // ubacujemo kreirani red u tabelu čiji je id = employees
                          }
                      },
                      error: function (response) {
                            alert("Dogodila se greska, pogledaj konzolu");
                          console.log("ERROR : ", data);

                      }

      });
      let selektovanRed = 0;
                                    let staraBoja = null;
                                    $("#fitnesCentri").on('click', 'tr:not(:first-child)', function() {
                                        if (staraBoja != null) {
                                            $('#fitnesCentri tr[data-id=' + selektovanRed + ']').css('background-color', staraBoja); // vracamo staru boju
                                        }
                                        selektovanRed = this.dataset.id;                    // cuvamo id selektovanog termina
                                        staraBoja = $(this).css('background-color');        // cuvamo staru boju da bi vratili kad se odselektuje

                                        $(this).css('background-color', '#a6c9e2');         // postavljamo novu boju
                                        console.log("Selektovan red ", selektovanRed);      // ispis u konzolu radi provere
                                    });

       $("#obrisi").click(function() {
                                var obj = JSON.stringify({
                                               "idKorisnika" : selektovanRed

                                       });
                              // console.log("Rezervisan termin ", selektovanRed);
                               $.ajax({
                                      type: "POST",
                                      url: "http://localhost:8181/api/fitnesCentar/brisanje",
                                      dataType: "json",
                                      contentType: "application/json",
                                      data: obj,
                                      success: function (data) {
                                          console.log("SUCCESS : ", data);

                                          },
                                      error: function (data) {
                                          alert("Greška!");
                                          console.log("ERROR : ", data);
                                          }
                               });
       });

$("#izmeni").click(function() {
        var naziv = $("#naziv").val();
        var adresa = $("#adresa").val();
        var brojCentrale = $("#brojCentrale").val();
        var email = $("#email").val();
        var obj = JSON.stringify({
           "id" : selektovanRed,
           "naizv" : naziv,
           "adresa" : adresa,
           "brojCentrale" : brojCentrale,
           "email" : email

           });
                              // console.log("Rezervisan termin ", selektovanRed);
           $.ajax({
               type: "POST",
               url: "http://localhost:8181/api/fitnesCentar/izmena",
               dataType: "json",
               contentType: "application/json",
               data: obj,
               success: function (data) {
               console.log("SUCCESS : ", data);
                window.location.href = "brisanjeFitnesCentra.html";

                            },
                                      error: function (data) {
                                          alert("Greška!");
                                          console.log("ERROR : ", data);
                                          }
                               });
       });

});