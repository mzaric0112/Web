package com.example.Web.Controller;

import com.example.Web.Model.Korisnik;
import com.example.Web.Model.dto.KorisnikDTO;
import com.example.Web.Model.dto.KreiranjeKorisnikaDTO;
import com.example.Web.Service.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/users")
public class KorisnikController {
    private final KorisnikService korisnikService;

    @Autowired
    public KorisnikController(KorisnikService korisnikService) {this.korisnikService = korisnikService;}


    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<KorisnikDTO> getUser(@PathVariable("id") Long id)
    {
        Korisnik korisnik = this.korisnikService.findOne(id);
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

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<KorisnikDTO>> getUsers() {
        List<Korisnik> korisnici = this.korisnikService.findAll();

        List<KorisnikDTO> trazeniKorisnici = new ArrayList<KorisnikDTO>();

        for(Korisnik k : korisnici) {
            KorisnikDTO korisnik = new KorisnikDTO(k.getId(), k.getIme(), k.getPrezime(), k.getDatumRodjenja(),
                    k.getEmail(), k.getTelefon(),  k.getUloga());
            trazeniKorisnici.add(korisnik);
        }
        return new ResponseEntity<>(trazeniKorisnici, HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<KreiranjeKorisnikaDTO> createUser(@RequestBody KreiranjeKorisnikaDTO kDTO) throws Exception {
        Korisnik korisnik = new Korisnik(kDTO.getKorisnickoIme(), kDTO.getLozinka(), kDTO.getIme(), kDTO.getPrezime(),
                kDTO.getDatumRodjenja(),kDTO.getEmail(), kDTO.getTelefon(),  kDTO.getUloga());
        Korisnik noviKorisnik = this.korisnikService.create(korisnik);
        KreiranjeKorisnikaDTO korisnikDTO = new KreiranjeKorisnikaDTO(noviKorisnik.getId(), noviKorisnik.getKorisnickoIme(),
                noviKorisnik.getLozinka(), noviKorisnik.getIme(), noviKorisnik.getPrezime(),noviKorisnik.getDatumRodjenja(),
                noviKorisnik.getEmail(), noviKorisnik.getTelefon(), noviKorisnik.getUloga());
        return new ResponseEntity<>(korisnikDTO, HttpStatus.CREATED);

    }
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<KreiranjeKorisnikaDTO> updateUser(@PathVariable Long id,
                      @RequestBody KreiranjeKorisnikaDTO kreiranjeKorisnikaDTO) throws Exception {
        Korisnik korisnik = new Korisnik(kreiranjeKorisnikaDTO.getKorisnickoIme(), kreiranjeKorisnikaDTO.getLozinka(), kreiranjeKorisnikaDTO.getIme(),
                kreiranjeKorisnikaDTO.getPrezime(), kreiranjeKorisnikaDTO.getDatumRodjenja(), kreiranjeKorisnikaDTO.getEmail(),
                kreiranjeKorisnikaDTO.getTelefon(), kreiranjeKorisnikaDTO.getUloga());
        korisnik.setId(id);
        Korisnik izmenjenKorisnik = korisnikService.update(korisnik);
        KreiranjeKorisnikaDTO azuriranKorisnik = new KreiranjeKorisnikaDTO(izmenjenKorisnik.getId(),izmenjenKorisnik.getKorisnickoIme(), izmenjenKorisnik.getLozinka(),
                izmenjenKorisnik.getIme(), izmenjenKorisnik.getPrezime(), izmenjenKorisnik.getDatumRodjenja(), izmenjenKorisnik.getEmail(),
                izmenjenKorisnik.getTelefon(), izmenjenKorisnik.getUloga());
        return new ResponseEntity<>(azuriranKorisnik, HttpStatus.OK);

    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        this.korisnikService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }







}
