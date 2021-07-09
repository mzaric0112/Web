$(document).ready(function(){

      $.ajax({
                      type: "GET",
                      url: "http://localhost:8181/api/trener",
                      dataType: "json",
                      success: function (response) {                              // ova f-ja se izvršava posle uspešnog zahteva
                          console.log("SUCCESS:\n", response);                    // ispisujemo u konzoli povratnu vrednost radi provere

                          for (let trener of response) {                        // prolazimo kroz listu svih zaposlenih
                              let row = "<tr data-id=" + trener.id + ">";                                  // kreiramo red za tabelu
                              row += "<td>" + trener.ime + "</td>";       // ubacujemo podatke jednog zaposlenog u polja
                              row += "<td>" + trener.prezime + "</td>";
                              row += "<td>" + trener.datumRodjenja + "</td>";
                              row += "</tr>";                                     // završavamo kreiranje reda

                              $('#terminiTreninga').append(row);                        // ubacujemo kreirani red u tabelu čiji je id = employees
                          }
                      },
                      error: function (response) {
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

 $("#obrisi").click(function() {
          var trener = selektovanRed;
          var obj = JSON.stringify({
          "idKorisnika" : trener
           });
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
                                              }
                                          });
                               });

});