package com.example.Web.Controller;

import com.example.Web.Model.Clan;
import com.example.Web.Model.OcenaTreninga;
import com.example.Web.Model.Termin;
import com.example.Web.Model.dto.KojiKorisnikDTO;
import com.example.Web.Service.ClanService;
import com.example.Web.Service.OcenaTreningaService;
import com.example.Web.Service.TerminService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api/ocenaTermina")
public class OcenaTreningaController {
    private final OcenaTreningaService ocenaTreningaService;
    private final ClanService clanService;
    private final TerminService terminService;
    public OcenaTreningaController(OcenaTreningaService ocenaTreningaService, ClanService clanService, TerminService terminService) {
        this.ocenaTreningaService = ocenaTreningaService;
        this.clanService = clanService;
        this.terminService = terminService;
    }

    @PostMapping(value = ("/ocenjivanje"),
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<OcenaTreninga> ocenjivanje(@RequestBody KojiKorisnikDTO info) throws Exception {
        Clan clan = clanService.findOne(info.getIdKorisnika());
        Termin Termin = terminService.findOne(info.getIdTermina());
        OcenaTreninga ocena = new OcenaTreninga();
        ocena.setTermin(Termin);
        ocena.setClan(clan);
        ocena.setOcena(info.getOcena());
        OcenaTreninga novaOcena = this.ocenaTreningaService.create(ocena);
        KojiKorisnikDTO kdto = new KojiKorisnikDTO(novaOcena.getClan().getId(), novaOcena.getTermin().getId(), novaOcena.getOcena() );




        return new ResponseEntity<>(ocena, HttpStatus.OK);


    }

}
