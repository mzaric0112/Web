package com.example.Web.Model.dto;

import com.example.Web.Model.Uloga;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class KreiranjeKorisnikaDTO {
    private Long id;
    private String korisnickoIme;
    private String lozinka;
    private String ime;
    private String prezime;
    private Date datumRodjenja;
    private String email;
    private String telefon;
    private Uloga uloga;

    public KreiranjeKorisnikaDTO() {
    }

    public KreiranjeKorisnikaDTO(Long id, String korisnickoIme, String lozinka, String ime,
                                 String prezime, Date datumRodjenja, String email, String telefon, Uloga uloga) {
        this.id = id;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
        this.ime = ime;
        this.prezime = prezime;
        this.datumRodjenja = datumRodjenja;
        this.email = email;
        this.telefon = telefon;
        this.uloga = uloga;
    }
    public KreiranjeKorisnikaDTO(Long id, String korisnickoIme, String lozinka, String ime,
                                 String prezime, Date datumRodjenja, String email, String telefon) {
        this.id = id;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
        this.ime = ime;
        this.prezime = prezime;
        this.datumRodjenja = datumRodjenja;
        this.email = email;
        this.telefon = telefon;
    }
}
