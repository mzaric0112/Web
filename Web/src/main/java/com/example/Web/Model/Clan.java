package com.example.Web.Model;

import javax.persistence.*;
import java.util.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Clan extends Korisnik {

    // clan moze ici na vise treninga, na jednom treningu moze biti vise clanova
    @ManyToMany
    @JoinTable( name = "odradjeniTreninzi",
        joinColumns = @JoinColumn( name = "clan_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn( name = "trening_id", referencedColumnName = "id"))
    private Set<Termin> odradjeniTreninzi = new HashSet<>();

    //clan moze da se prijavi za vise treninga, za jedan trening moze da se prijavi vise clanova
    @ManyToMany
    @JoinTable( name = "prijavljeniTreninzi",
            joinColumns = @JoinColumn(name = "clan_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "trening_id", referencedColumnName = "id"))
    private Set<Termin> prijavljeniTreninzi = new HashSet<>();

    //da li trening posmatrati kao grupni ili individualni

    @OneToMany(mappedBy = "clan", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<OcenaTreninga> ocenaTreninga = new HashSet<>();

    public Clan(){}

    public Clan(String korisnickoIme, String lozinka, String ime, String prezime, Date datumRodjenja,
                String email, String telefon, Uloga uloga) {
        super(korisnickoIme, lozinka, ime, prezime, datumRodjenja, email, telefon, uloga);
    }

    public Clan(String korisnickoIme, String ime, String prezime, String lozinka, String telefon, String email, Date datumRodjenja,
                boolean aktivan, Uloga uloga, boolean registrovan) {
        super(korisnickoIme, ime, prezime, lozinka, telefon, email, datumRodjenja, aktivan, uloga, registrovan);
    }

    public Clan(String korisnickoIme, String lozinka, String ime, String prezime, Date datumRodjenja, String email,
                String telefon, Uloga uloga, Set<Termin> odradjeniTreninzi, Set<Termin> prijavljeniTreninzi,
                Set<OcenaTreninga> ocenaTreninga) {
        super(korisnickoIme, lozinka, ime, prezime, datumRodjenja, email, telefon, uloga);
        this.odradjeniTreninzi = odradjeniTreninzi;
        this.prijavljeniTreninzi = prijavljeniTreninzi;
        this.ocenaTreninga = ocenaTreninga;
    }
}
