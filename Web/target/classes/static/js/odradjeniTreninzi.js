$(document).ready(function(){

    var korisnickoIme = localStorage.getItem('korisnickoIme');
    var obj = JSON.stringify({
      "korisnickoIme" : korisnickoIme
      });
     $.ajax({
                 type: "POST",
                 url: "http://localhost:8181/api/termini/odradjeniTreninzi",
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