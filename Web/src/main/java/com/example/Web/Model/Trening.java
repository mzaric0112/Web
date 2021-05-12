package com.example.Web.Model;
import javax.persistence.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Trening implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String naziv;
    @Column
    private String opis;
    @Column(nullable = false)
    private String tipTreninga;
    @Column(nullable = false)
    
    private int trajanje;

    @OneToMany(mappedBy = "trening", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<OcenaTreninga> ocenaTreninga = new HashSet<>();

    @ManyToOne(fetch = FetchType.EAGER)
    private Trener trener;

    @ManyToMany(mappedBy = "treninzi")
    private List<Clan> korisniciOdradiliTrening = new ArrayList<Clan>();

    @ManyToMany(mappedBy = "prijavljeniTreninzi")
    private List<Clan> prijavljeniClanovi = new ArrayList<Clan>();

    @OneToMany(mappedBy = "trening", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<OdrzavanjeTreninga> odrzavanjeTreninga = new HashSet<>();




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getTipTreninga() {
        return tipTreninga;
    }

    public void setTipTreninga(String tipTreninga) {
        this.tipTreninga = tipTreninga;
    }

    public int getTrajanje() {
        return trajanje;
    }

    public void setTrajanje(int trajanje) {
        this.trajanje = trajanje;
    }

    public Trener getTrener() {
        return trener;
    }

    public void setTrener(Trener trener) {
        this.trener = trener;
    }

    public List<Clan> getKorisniciOdradiliTrening() {
        return korisniciOdradiliTrening;
    }

    public void setKorisniciOdradiliTrening(ArrayList<Clan> korisniciOdradiliTrening) {
        this.korisniciOdradiliTrening = korisniciOdradiliTrening;
    }

    public List<Clan> getPrijavljeniClanovi() {
        return prijavljeniClanovi;
    }

    public void setPrijavljeniClanovi(ArrayList<Clan> prijavljeniClanovi) {
        this.prijavljeniClanovi = prijavljeniClanovi;
    }

}
