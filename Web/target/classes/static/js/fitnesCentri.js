$(document).ready(function(){

      $.ajax({
                      type: "GET",
                      url: "http://localhost:8181/api/fitnesCentar",
                      dataType: "json",
                      success: function (response) {                              // ova f-ja se izvršava posle uspešnog zahteva
                          console.log("SUCCESS:\n", response);                    // ispisujemo u konzoli povratnu vrednost radi provere

                          for (let trener of response) {                        // prolazimo kroz listu svih zaposlenih
                              let row = "<tr>";                                   // kreiramo red za tabelu
                              row += "<td>" + trener.naziv + "</td>";       // ubacujemo podatke jednog zaposlenog u polja
                              row += "<td>" + trener.adresa + "</td>";
                              row += "<td>" + trener.brojCentrale + "</td>";
                              row += "<td>" + trener.email + "</td>";
                              row += "</tr>";                                     // završavamo kreiranje reda

                              $('#fitnesCentri').append(row);                        // ubacujemo kreirani red u tabelu čiji je id = employees
                          }
                      },
                      error: function (response) {
                      }

      });
});