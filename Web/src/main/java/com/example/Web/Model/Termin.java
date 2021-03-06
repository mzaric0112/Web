package com.example.Web.Model;
import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@Entity
public class Termin implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private double cena;
    @Column(nullable = false)
    private Date datumPocetka;
    //ovo mozda i nije potrebno jer se moze izracunati na osnovu datuma pocetka i trajanja treninga
    @Column
    private Date datumKraja;
    @Column
    private int brojClanova;

    @JsonIgnore
    @OneToMany(mappedBy = "termin", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<OcenaTreninga> ocena = new HashSet<>();

    @ManyToOne(fetch = FetchType.EAGER)
    private Trening trening;


    @ManyToMany(mappedBy = "prijavljeniTreninzi")
    private Set<Clan> prijavljeniClanovi = new HashSet<>();
    @ManyToMany(mappedBy = "odradjeniTreninzi")
    private Set<Clan> clanoviOdradiliTrening = new HashSet<>();

    @ManyToOne(fetch = FetchType.EAGER)
    private Sala sala;

    @ManyToOne(fetch = FetchType.EAGER)
    private FitnesCentar fitnesCentar;

    public Termin(){}

    public Termin( double cena, Date datumPocetka, Trening trening,
                   FitnesCentar fitnesCentar) {

        this.cena = cena;
        this.datumPocetka = datumPocetka;
        this.trening = trening;
        this.fitnesCentar = fitnesCentar;
    }
}
