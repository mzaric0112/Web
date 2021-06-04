package com.example.Web.Model;

import javax.persistence.*;
import java.util.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Trener extends Korisnik {


    @OneToMany(mappedBy = "trener", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Trening> listaTreninga = new HashSet<Trening>();

    @Column
    private float prosecnaOcena;

    @ManyToOne(fetch = FetchType.EAGER)
    private FitnesCentar fitnesCentar;

    public Trener(String korisnickoIme, String lozinka, String ime, String prezime, Date datumRodjenja,
                  String email, String telefon, Uloga uloga) {
        super(korisnickoIme, lozinka, ime, prezime, datumRodjenja, email, telefon, uloga);
    }

    public Trener(String korisnickoIme, String lozinka, String ime, String prezime, Date datumRodjenja, String email, String telefon,
                  Uloga uloga, Set<Trening> listaTreninga, float prosecnaOcena, FitnesCentar fitnesCentar) {
        super(korisnickoIme, lozinka, ime, prezime, datumRodjenja, email, telefon, uloga);
        this.listaTreninga = listaTreninga;
        this.prosecnaOcena = prosecnaOcena;
        this.fitnesCentar = fitnesCentar;
    }
}
