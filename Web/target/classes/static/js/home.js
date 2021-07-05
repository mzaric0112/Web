$(document).ready(function(){
    if(localStorage.getItem('korisnickoIme') === null || localStorage.getItem('korisnickoIme') == 'none'){
        $("#clanoviFunkcije").css('display', 'none');
        $("#treneriFunkcije").css('display', 'none');
        $("#adminFunkcije").css('display', 'none');

    } else
    if(localStorage.getItem('uloga') == "CLAN") {
        $("#clanoviFunkcije").css('display', 'block');
        $("#treneriFunkcije").css('display', 'none');
        $("#adminFunkcije").css('display', 'none');
    } else
    if(localStorage.getItem('uloga') == "TRENER"){
        $("#clanoviFunkcije").css('display', 'none');
        $("#treneriFunkcije").css('display', 'block');
        $("#adminFunkcije").css('display', 'none');
    }
    else{
        $("#clanoviFunkcije").css('display', 'none');
        $("#treneriFunkcije").css('display', 'none');
        $("#adminFunkcije").css('display', 'block');
    }

});