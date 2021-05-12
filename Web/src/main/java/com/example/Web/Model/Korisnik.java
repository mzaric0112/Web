package com.example.Web.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

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

    public Korisnik() {
    }

    public Korisnik(Long id, String korisnickoIme, String ime, String prezime, String lozinka, String telefon, String email, Date datumRodjenja, boolean aktivan, Uloga uloga) {
        this.id = id;
        this.korisnickoIme = korisnickoIme;
        this.ime = ime;
        this.prezime = prezime;
        this.lozinka = lozinka;
        this.telefon = telefon;
        this.email = email;
        this.datumRodjenja = datumRodjenja;
        this.aktivan = aktivan;
        this.uloga = uloga;
    }

    @Override
    public String toString() {
        return "Korisnik{" +
                "id=" + id +
                ", korisnickoIme='" + korisnickoIme + '\'' +
                ", ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", lozinka='" + lozinka + '\'' +
                ", telefon='" + telefon + '\'' +
                ", email='" + email + '\'' +
                ", datumRodjenja=" + datumRodjenja +
                ", aktivan=" + aktivan +
                ", uloga=" + uloga +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public boolean isAktivan() {
        return aktivan;
    }

    public void setAktivan(boolean aktivan) {
        this.aktivan = aktivan;
    }

    public Uloga getUloga() {
        return uloga;
    }

    public void setUloga(Uloga uloga) {
        this.uloga = uloga;
    }

}
