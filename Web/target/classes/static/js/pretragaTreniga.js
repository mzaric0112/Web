$(document).ready(function(){
     $("#traziProjekciju").submit(function(event) {
        event.preventDefault();

        var naziv = $("#naziv").val();
        var trajanje = $("#trajanje").val();
        var tipTreninga = $("#tipTreninga").val();

        var tipSortiranja = $("#sortiranje").val();
        var obj = JSON.stringify({
                "naziv" : naziv,
                "trajanje" : trajanje,
                "tipTreninga" : tipTreninga,
                "tipSortiranja" : tipSortiranja

     });
     $.ajax({
                 type: "POST",
                 url: "http://localhost:8080/api/terminkaListaProjekcija/pretraga",
                 dataType: "json",
                 contentType: "application/json",
                 data: obj,
                 success: function (data) {
                     console.log("SUCCESS : ", data);
                         for (i = 0; i < data.length; i++) {
                         var row = "<tr>";
                         row += "<td>" + data[i]['naziv'] + "</td>";
                         row += "<td>" + (data[i]['vreme'].split("T"))[0] + "</td>";
                         row += "<td>" + data[i]['cena'] + "</td>";
                         row += "<td>" + data[i]['srednjaOcena'] + "</td>";
                         row += "<td>" + data[i]['zanr'] + "</td>";
                         row += "<td>" + data[i]['trajanje'] + "</td>";
                         row += "<td>" + data[i]['bioskopNaziv']; + "</td>";
                         row += "<td>" + data[i]['salaOznaka']; + "</td>";
                         row += "</tr>";


                         $('#projekcije').append(row);

                         var opcija = "<option  value = " + data[i]['idtlp'] + ">";
                         opcija += data[i]['naziv'] + " - ";
                         opcija += (data[i]['vreme'].split("T"))[0] + " - ";
                         opcija += data[i]['bioskopNaziv'] + " - ";
                         opcija += data[i]['salaOznaka'] + " - ";
                         opcija += data[i]['cena'];
                         opcija += "</option>";
                         $('#selekcijaProjekcije').append(opcija);
                     }
                 },
                 error: function (data) {
                     alert("Dogodila se greska, pogledaj konzolu");
                     console.log("ERROR : ", data);
                 }
             });
         });



}
