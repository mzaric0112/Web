$(document).ready(function(){
     $("#traziTrening").submit(function(event) {
        event.preventDefault();

        var naziv = $("#naziv").val();
        var trajanje = $("#trajanje").val();

        var datumPocetka = $("#datumPocetka").val();
        var cena = $("#cena").val();

        var tipSortiranja = $("#sortiranje").val();
        var obj = JSON.stringify({
                "naziv" : naziv,
                "trajanje" : trajanje,
                "cena" : cena,
                "datumPocetka" : datumPocetka,
                "tipSortiranja" : tipSortiranja
        });

     $.ajax({
                 type: "POST",
                 url: "http://localhost:8181/api/termini/pretraga",
                 dataType: "json",
                 contentType: "application/json",
                 data: obj,
                 success: function (data) {
                     console.log("SUCCESS : ", data);

                         for (i = 0; i < data.length; i++) {
                         var row = "<tr>";
                         row += "<td>" + data[i]['naziv'] + "</td>";
                         row += "<td>" + data[i]['cena'] + "</td>";
                         row += "<td>" + data[i]['trajanje'] + "</td>";
                         row += "<td>" + (data[i]['datumPocetka'].split("T"))[0] + "</td>";
                         row += "<td>" + (data[i]['datumKraja'].split("T"))[0] + "</td>";
                         row += "<td>" + data[i]['preostalaMesta'] + "</td>";
                         row += "<td>" + data[i]['imeTrenera'] + "</td>";
                         row += "<td>" + data[i]['tipTreninga'] + "</td>";
                         row += "<td>" + data[i]['prosecnaOcena'] + "</td>";
                         row += "<td>" + data[i]['nazivFitnesCentra'] + "</td>";
                         row += "<td>" + data[i]['nazivSale'] + "</td>";

                         row += "</tr>";


                         $('#terminiTreninga').append(row);
//                          window.location.href = "pretragaTreninga.html";


                     }
                 },
                 error: function (data) {
                     alert("Dogodila se greska, pogledaj konzolu");
                     console.log("ERROR : ", data);
                 }
             });
     });

});


