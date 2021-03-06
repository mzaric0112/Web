package com.example.Web.Controller;

import com.example.Web.Model.Korisnik;
import com.example.Web.Model.Termin;
import com.example.Web.Model.Trener;
import com.example.Web.Model.Trening;
import com.example.Web.Model.dto.*;
import com.example.Web.Service.TrenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/trener")
public class TrenerController {
    private final TrenerService trenerService;

    @Autowired
    public TrenerController(TrenerService trenerService) {this.trenerService = trenerService;}

    @PostMapping(value = ("/treninziTrenera"),
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TreningTreneraDTO>> treninziTrenera(@RequestBody KorisnikTreninziDTO kDTO) throws Exception {
        Trener trener = trenerService.findOne(kDTO.getIdKorisnika());
        List<TreningTreneraDTO> treninzi = new ArrayList<>();
        for(Trening t : trener.getListaTreninga()) {
            TreningTreneraDTO trening = new TreningTreneraDTO();
            trening.setId(t.getId());
            trening.setNaziv(t.getNaziv());
            trening.setOpis(t.getOpis());
            trening.setTrajanje(t.getTrajanje());
            trening.setTipTreninga(t.getTipTreninga());
            treninzi.add(trening);

        }

        return new ResponseEntity<>(treninzi, HttpStatus.OK);

    }
    @PostMapping(value = ("/terminiTrenera"),
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TerminiTreneraDTO>> terminiTrenera(@RequestBody KorisnikTreninziDTO kDTO) throws Exception {
        Trener trener = trenerService.findOne(kDTO.getIdKorisnika());
        List<TerminiTreneraDTO> treninzi = new ArrayList<>();
        for(Trening t : trener.getListaTreninga()) {
            for(Termin ter : t.getTerminiTreninga()) {
                TerminiTreneraDTO trening = new TerminiTreneraDTO();
                trening.setId(ter.getId());
                trening.setCena(ter.getCena());
                trening.setDatumPocetka(ter.getDatumPocetka());
                trening.setNazivTreninga(ter.getTrening().getNaziv());
                treninzi.add(trening);
            }


        }

        return new ResponseEntity<>(treninzi, HttpStatus.OK);

    }



    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<KorisnikDTO>> getUsers() {
        List<Trener> korisnici = this.trenerService.findAll();

        List<KorisnikDTO> trazeniKorisnici = new ArrayList<KorisnikDTO>();

        for(Trener k : korisnici) {
            KorisnikDTO korisnik = new KorisnikDTO(k.getId(), k.getIme(), k.getPrezime(), k.getDatumRodjenja(),
                    k.getEmail(), k.getTelefon(),  k.getUloga());
            trazeniKorisnici.add(korisnik);
        }
        return new ResponseEntity<>(trazeniKorisnici, HttpStatus.OK);
    }
    @PostMapping(value = "/brisanje",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> brisanje(@RequestBody KorisnikTreninziDTO id) {
        this.trenerService.delete(id.getIdKorisnika());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    /*
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<KorisnikDTO> getUser(@PathVariable("id") Long id)
    {
        Trener korisnik = this.trenerService.findOne(id);
        KorisnikDTO trazeniKorisnik = new KorisnikDTO();
        trazeniKorisnik.setId(korisnik.getId());
        trazeniKorisnik.setIme(korisnik.getIme());
        trazeniKorisnik.setPrezime(korisnik.getPrezime());
        trazeniKorisnik.setDatumRodjenja(korisnik.getDatumRodjenja());
        trazeniKorisnik.setEmail(korisnik.getEmail());
        trazeniKorisnik.setTelefon(korisnik.getTelefon());
        trazeniKorisnik.setUloga(korisnik.getUloga());

        return new ResponseEntity<>(trazeniKorisnik, HttpStatus.OK);
    }



    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<KreiranjeKorisnikaDTO> createUser(@RequestBody KreiranjeKorisnikaDTO kDTO) throws Exception {
        Trener korisnik = new Trener(kDTO.getKorisnickoIme(), kDTO.getLozinka(), kDTO.getIme(), kDTO.getPrezime(),
                kDTO.getDatumRodjenja(),kDTO.getEmail(), kDTO.getTelefon(),  kDTO.getUloga());
        Trener noviKorisnik = this.trenerService.create(korisnik);
        KreiranjeKorisnikaDTO korisnikDTO = new KreiranjeKorisnikaDTO(noviKorisnik.getId(), noviKorisnik.getKorisnickoIme(),
                noviKorisnik.getLozinka(), noviKorisnik.getIme(), noviKorisnik.getPrezime(),noviKorisnik.getDatumRodjenja(),
                noviKorisnik.getEmail(), noviKorisnik.getTelefon(), noviKorisnik.getUloga());
        return new ResponseEntity<>(korisnikDTO, HttpStatus.CREATED);

    }
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<KreiranjeKorisnikaDTO> updateUser(@PathVariable Long id,
                      @RequestBody KreiranjeKorisnikaDTO kreiranjeKorisnikaDTO) throws Exception {
        Trener korisnik = new Trener(kreiranjeKorisnikaDTO.getKorisnickoIme(), kreiranjeKorisnikaDTO.getLozinka(), kreiranjeKorisnikaDTO.getIme(),
                kreiranjeKorisnikaDTO.getPrezime(), kreiranjeKorisnikaDTO.getDatumRodjenja(), kreiranjeKorisnikaDTO.getEmail(),
                kreiranjeKorisnikaDTO.getTelefon(), kreiranjeKorisnikaDTO.getUloga());
        korisnik.setId(id);
        Korisnik izmenjenKorisnik = trenerService.update(korisnik);
        KreiranjeKorisnikaDTO azuriranKorisnik = new KreiranjeKorisnikaDTO(izmenjenKorisnik.getId(),izmenjenKorisnik.getKorisnickoIme(), izmenjenKorisnik.getLozinka(),
                izmenjenKorisnik.getIme(), izmenjenKorisnik.getPrezime(), izmenjenKorisnik.getDatumRodjenja(), izmenjenKorisnik.getEmail(),
                izmenjenKorisnik.getTelefon(), izmenjenKorisnik.getUloga());
        return new ResponseEntity<>(azuriranKorisnik, HttpStatus.OK);

    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        this.trenerService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


*/




}
