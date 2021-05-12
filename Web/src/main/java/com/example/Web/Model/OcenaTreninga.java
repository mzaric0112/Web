package com.example.Web.Model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class OcenaTreninga implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    private Trening trening;
    @Column
    private float ocena;

    @ManyToMany(mappedBy = "ocene")
    private List<Clan> clanovi = new ArrayList<Clan>();

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

    public float getOcena() {
        return ocena;
    }

    public void setOcena(float ocena) {
        this.ocena = ocena;
    }

    public List<Clan> getClanovi() {
        return clanovi;
    }

    public void setClanovi(ArrayList<Clan> clanovi) {
        this.clanovi = clanovi;
    }
}
