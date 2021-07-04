$(document).ready(function(){
	var korisnik = "<tr>";
	korisnik += "<th>" + localStorage.getItem('ime') + "</th>";
	korisnik += "<th>" + localStorage.getItem('prezime') + "</th>";
	korisnik += "<th>" + localStorage.getItem('uloga') + "</th>";
	korisnik += "<th>" + localStorage.getItem('telefon') + "</th>";
	korisnik += "<th>" + localStorage.getItem('email') + "</th>";
	korisnik += "<th>" + localStorage.getItem('korisnickoIme') + "</th>";
	korisnik += "<th>" + localStorage.getItem('datumRodjenja') + "</th>";
	korisnik += "</tr>";
	$('#profil').append(korisnik);
});