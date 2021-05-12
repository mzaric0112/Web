package com.example.Web.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

@Entity
public class OdrzavanjeTreninga implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Trening trening;
    @Column
    private double cena;
    @Column
    private Date datumPocetka;
    @Column
    private Date datumKraja;
    @ManyToOne(fetch = FetchType.EAGER)
    private FitnesCentar fitnesCentar;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Trening getTrening() {
        return trening;
    }

    public void setTrening(Trening trening) {
        this.trening = trening;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public Date getDatumPocetka() {
        return datumPocetka;
    }

    public void setDatumPocetka(Date datumPocetka) {
        this.datumPocetka = datumPocetka;
    }

    public Date getDatumKraja() {
        return datumKraja;
    }

    public void setDatumKraja(Date datumKraja) {
        this.datumKraja = datumKraja;
    }

    public FitnesCentar getFitnesCentar() {
        return fitnesCentar;
    }

    public void setFitnesCentar(FitnesCentar fitnesCentar) {
        this.fitnesCentar = fitnesCentar;
    }
}
