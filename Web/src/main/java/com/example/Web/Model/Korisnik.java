package com.example.Web.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
//@Table(name = "KORISNIK")
@MappedSuperclass
//@Entity
public class Korisnik implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "KORISNICKOIME", unique = true)
    private String korisnickoIme;
    @Column(nullable = false)
    private String ime;
    @Column(nullable = false)
    private String prezime;
    @Column(nullable = false)
    private String lozinka;
    @Column
    private String telefon;
    @Column
    private String email;
    @Column(name = "DATUMRODJENJA")
    private Date datumRodjenja;
    @Column
    private boolean aktivan;
    @Column(nullable = false)
    private Uloga uloga;
    @Column
    private boolean registrovan;


    public Korisnik() {
    }

    public Korisnik(String korisnickoIme,String lozinka, String ime, String prezime,
                    Date datumRodjenja,  String email, String telefon,  Uloga uloga) {

        this.korisnickoIme = korisnickoIme;
        this.ime = ime;
        this.prezime = prezime;
        this.lozinka = lozinka;
        this.telefon = telefon;
        this.email = email;
        this.datumRodjenja = datumRodjenja;
        this.aktivan = true;
        this.uloga = uloga;
    }

    public Korisnik( String korisnickoIme, String ime, String prezime, String lozinka,
                    String telefon, String email, Date datumRodjenja, boolean aktivan, Uloga uloga, boolean registrovan) {

        this.korisnickoIme = korisnickoIme;
        this.ime = ime;
        this.prezime = prezime;
        this.lozinka = lozinka;
        this.telefon = telefon;
        this.email = email;
        this.datumRodjenja = datumRodjenja;
        this.aktivan = aktivan;
        this.uloga = uloga;
        this.registrovan = registrovan;
    }
}
