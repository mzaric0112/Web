$(document).ready(function(){
    if(localStorage.getItem('korisnickoIme') === null || localStorage.getItem('korisnickoIme') == 'none'){
        $("#clanoviFunkcije").css('display', 'none');
        $("#treneriFunkcije").css('display', 'none');
        $("#adminFunkcije").css('display', 'none');

    }else if(localStorage.getItem('uloga') == 'CLAN') {
        $("#gledaociFunkcije").css('display', 'block');
        $("#treneriFunkcije").css('display', 'none');
        $("#adminFunkcije").css('display', 'none');
    }else if(localStorage.getItem('uloga') == 'TRENER'){
        $("#gledaociFunkcije").css('display', 'none');
        $("#menadzeriFunkcije").css('display', 'block');
        $("#adminFunkcije").css('display', 'none');
    }else{
        $("#gledaociFunkcije").css('display', 'none');
        $("#treneriFunkcije").css('display', 'none');
        $("#adminFunkcije").css('display', 'block');
    }

});