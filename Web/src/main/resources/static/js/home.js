$(document).ready(function(){
    if(localStorage.getItem('korisnickoIme') === null || localStorage.getItem('korisnickoIme') == 'none'){
        $("#clanoviFunkcije").css('display', 'none');
        $("#treneriFunkcije").css('display', 'none');
        $("#adminFunkcije").css('display', 'none');

    }
    if(localStorage.getItem('uloga') == 2) {
        $("#clanoviFunkcije").css('display', 'block');
        $("#treneriFunkcije").css('display', 'none');
        $("#adminFunkcije").css('display', 'none');
    }
    if(localStorage.getItem('uloga') == 1){
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