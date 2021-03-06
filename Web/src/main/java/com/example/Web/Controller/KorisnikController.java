package com.example.Web.Controller;

import com.example.Web.Model.*;
import com.example.Web.Model.dto.*;
import com.example.Web.Service.AdministratorService;
import com.example.Web.Service.ClanService;
import com.example.Web.Service.TrenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/korisnik")
public class KorisnikController {
    private final ClanService clanService;
    private final TrenerService trenerService;
    private final AdministratorService administratorService;

    @Autowired
    public KorisnikController(ClanService clanService, TrenerService trenerService, AdministratorService administratorService) {this.clanService = clanService;
    this.trenerService = trenerService;
    this.administratorService = administratorService; }

    @GetMapping(value="/zahteviZaRegistracijuClana", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<RegistracijaDTO>> getRegistracijaClana() {
        List<Clan> clanovi = this.clanService.findAll();

        List<RegistracijaDTO> trazeniTreneri = new ArrayList<RegistracijaDTO>();

        for(Clan t : clanovi) {
            if(t.isRegistrovan() == false) {
                RegistracijaDTO trener = new RegistracijaDTO( t.getKorisnickoIme(), t.getIme(), t.getPrezime(), t.getLozinka(),
                        t.getTelefon(), t.getEmail(), t.getDatumRodjenja(), t.getUloga());
                trazeniTreneri.add(trener);
            }

        }
        return new ResponseEntity<>(trazeniTreneri, HttpStatus.OK);
    }

    @GetMapping(value="/zahteviZaRegistracijuTrenera", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<RegistracijaDTO>> getRegistracijaTrenera() {
        List<Trener> treneri = this.trenerService.findAll();

        List<RegistracijaDTO> trazeniTreneri = new ArrayList<RegistracijaDTO>();

        for(Trener t : treneri) {
            if(t.isRegistrovan() == false) {
                RegistracijaDTO trener = new RegistracijaDTO( t.getKorisnickoIme(), t.getIme(), t.getPrezime(), t.getLozinka(),
                        t.getTelefon(), t.getEmail(), t.getDatumRodjenja(), t.getUloga());
                trazeniTreneri.add(trener);
            }

        }
        return new ResponseEntity<>(trazeniTreneri, HttpStatus.OK);
    }
    @PostMapping(
			value =("/login"),
		    consumes = MediaType.APPLICATION_JSON_VALUE,
		    produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LogovaniKorisnikDTO> KorisnikLogin(@RequestBody KorisnikLoginDTO korisnikLoginDTO) throws Exception{
        Administrator admin = this.administratorService.getByKorisnickoImeAndLozinka(korisnikLoginDTO.getKorisnickoIme(), korisnikLoginDTO.getLozinka());
        Clan clan = this.clanService.getByKorisnickoImeAndLozinka(korisnikLoginDTO.getKorisnickoIme(), korisnikLoginDTO.getLozinka());
        Trener trener = this.trenerService.getByKorisnickoImeAndLozinka(korisnikLoginDTO.getKorisnickoIme(), korisnikLoginDTO.getLozinka());
        LogovaniKorisnikDTO korisnikDTO = new LogovaniKorisnikDTO();
        if(admin != null) {
            if(admin.isAktivan() == false || admin.isRegistrovan()== false) {

                throw new Exception("Nalog nije aktiviran");
            }
            else {
                korisnikDTO = new LogovaniKorisnikDTO(admin.getId(), admin.getKorisnickoIme(), admin.getIme(), admin.getPrezime(),
                        "ne prenosim sifru", admin.getTelefon(), admin.getEmail(), admin.getDatumRodjenja(), admin.isAktivan(), admin.getUloga());
                return new ResponseEntity<>(korisnikDTO,HttpStatus.OK);
            }


        }
        else if(clan != null) {
            if(clan.isAktivan() == false || clan.isRegistrovan() == false) {
                throw new Exception("Nalog nije aktiviran");
            }
            else{
                korisnikDTO = new LogovaniKorisnikDTO(clan.getId(), clan.getKorisnickoIme(), clan.getIme(), clan.getPrezime(),
                        "ne prenosim sifru", clan.getTelefon(), clan.getEmail(), clan.getDatumRodjenja(), clan.isAktivan(), clan.getUloga());
                return new ResponseEntity<>(korisnikDTO,HttpStatus.OK);

            }


        }
        else if(trener != null) {
            if(trener.isAktivan() == false || trener.isRegistrovan() == false) {
                throw new Exception("Nalog nije aktiviran");
            }
            else{
                korisnikDTO = new LogovaniKorisnikDTO(trener.getId(), trener.getKorisnickoIme(), trener.getIme(), trener.getPrezime(),
                        "ne prenosim sifru", trener.getTelefon(), trener.getEmail(), trener.getDatumRodjenja(), trener.isAktivan(), trener.getUloga());
                return new ResponseEntity<>(korisnikDTO,HttpStatus.OK);
            }

        }
        else
            throw new Exception("Kredincijali nisu tacni");





	}



    @GetMapping(value = "/clanovi/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<KorisnikDTO> getClan(@PathVariable("id") Long id)
    {
        Clan korisnik = this.clanService.findOne(id);
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
    @GetMapping(value="/clanovi", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<KorisnikDTO>> getClanovi() {
        List<Clan> korisnici = this.clanService.findAll();

        List<KorisnikDTO> trazeniKorisnici = new ArrayList<KorisnikDTO>();

        for(Clan k : korisnici) {
            KorisnikDTO korisnik = new KorisnikDTO(k.getId(), k.getIme(), k.getPrezime(), k.getDatumRodjenja(),
                    k.getEmail(), k.getTelefon(),  k.getUloga());
            trazeniKorisnici.add(korisnik);
        }
        return new ResponseEntity<>(trazeniKorisnici, HttpStatus.OK);
    }
    @PostMapping(value="/registrujClana" ,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<KreiranjeKorisnikaDTO> createClan(@RequestBody RegistracijaDTO DTO) throws Exception {
        Clan korisnik = new Clan(DTO.getKorisnickoIme(), DTO.getLozinka(), DTO.getIme(), DTO.getPrezime(),
                DTO.getTelefon(), DTO.getEmail(), DTO.getDatumRodjenja(), true, DTO.getUloga(), false);

        Clan noviKorisnik = this.clanService.create(korisnik);
        KreiranjeKorisnikaDTO korisnikDTO = new KreiranjeKorisnikaDTO(noviKorisnik.getId(), noviKorisnik.getKorisnickoIme(),
                noviKorisnik.getLozinka(), noviKorisnik.getIme(), noviKorisnik.getPrezime(),noviKorisnik.getDatumRodjenja(),
                noviKorisnik.getEmail(), noviKorisnik.getTelefon(), noviKorisnik.getUloga());
        return new ResponseEntity<>(korisnikDTO, HttpStatus.CREATED);

    }
    @PutMapping(value = "/clanovi/{id}", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<KreiranjeKorisnikaDTO> updateClan(@PathVariable Long id,
                                                            @RequestBody KreiranjeKorisnikaDTO kreiranjeKorisnikaDTO) throws Exception {
        Clan korisnik = new Clan(kreiranjeKorisnikaDTO.getKorisnickoIme(), kreiranjeKorisnikaDTO.getLozinka(), kreiranjeKorisnikaDTO.getIme(),
                kreiranjeKorisnikaDTO.getPrezime(), kreiranjeKorisnikaDTO.getDatumRodjenja(), kreiranjeKorisnikaDTO.getEmail(),
                kreiranjeKorisnikaDTO.getTelefon(), kreiranjeKorisnikaDTO.getUloga());
        korisnik.setId(id);
        Clan izmenjenKorisnik = clanService.update(korisnik);
        KreiranjeKorisnikaDTO azuriranKorisnik = new KreiranjeKorisnikaDTO(izmenjenKorisnik.getId(),izmenjenKorisnik.getKorisnickoIme(), izmenjenKorisnik.getLozinka(),
                izmenjenKorisnik.getIme(), izmenjenKorisnik.getPrezime(), izmenjenKorisnik.getDatumRodjenja(), izmenjenKorisnik.getEmail(),
                izmenjenKorisnik.getTelefon(), izmenjenKorisnik.getUloga());
        return new ResponseEntity<>(azuriranKorisnik, HttpStatus.OK);

    }
    @DeleteMapping(value = "/clanovi/{id}")
    public ResponseEntity<Void> deleteClan(@PathVariable Long id) {
        this.clanService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @GetMapping(value = "/treneri/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<KorisnikDTO> getTrener(@PathVariable("id") Long id)
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

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value="/treneri")
    public ResponseEntity<List<KorisnikDTO>> getTreneri() {
        List<Trener> korisnici = this.trenerService.findAll();

        List<KorisnikDTO> trazeniKorisnici = new ArrayList<KorisnikDTO>();

        for(Trener k : korisnici) {
            KorisnikDTO korisnik = new KorisnikDTO(k.getId(), k.getIme(), k.getPrezime(), k.getDatumRodjenja(),
                    k.getEmail(), k.getTelefon(),  k.getUloga());
            trazeniKorisnici.add(korisnik);
        }
        return new ResponseEntity<>(trazeniKorisnici, HttpStatus.OK);
    }

    @PostMapping(value="/registrujTrenera",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<KreiranjeKorisnikaDTO> createTrener(@RequestBody RegistracijaDTO DTO) throws Exception {
        Trener korisnik = new Trener(DTO.getKorisnickoIme(), DTO.getLozinka(), DTO.getIme(), DTO.getPrezime(),
                DTO.getTelefon(), DTO.getEmail(), DTO.getDatumRodjenja(), true, DTO.getUloga(), false);

        Trener noviKorisnik = this.trenerService.create(korisnik);
        KreiranjeKorisnikaDTO korisnikDTO = new KreiranjeKorisnikaDTO(noviKorisnik.getId(), noviKorisnik.getKorisnickoIme(),
                noviKorisnik.getLozinka(), noviKorisnik.getIme(), noviKorisnik.getPrezime(),noviKorisnik.getDatumRodjenja(),
                noviKorisnik.getEmail(), noviKorisnik.getTelefon(), noviKorisnik.getUloga());
        return new ResponseEntity<>(korisnikDTO, HttpStatus.CREATED);

    }
    @PutMapping(value = "/treneri/{id}", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<KreiranjeKorisnikaDTO> updateTrener(@PathVariable Long id,
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
    @DeleteMapping(value = "/treneri/{id}")
    public ResponseEntity<Void> deleteTrener(@PathVariable Long id) {
        this.trenerService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
