package com.example.Web.Model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity

public class FitnesCentar implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String naziv;
    @Column
    private String adresa;
    @Column
    private String brojCentrale;
    @Column
    private String email;

    @OneToMany(mappedBy = "fitnesCentar", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Trener> treneri = new HashSet<Trener>();

    @OneToMany(mappedBy = "fitnesCentar", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Sala> sale = new HashSet<Sala>();

    @OneToMany(mappedBy = "fitnesCentar", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<OdrzavanjeTreninga> rasporedOdrzavanjaTreninga = new HashSet<OdrzavanjeTreninga>();

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

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getBrojCentrale() {
        return brojCentrale;
    }

    public void setBrojCentrale(String brojCentrale) {
        this.brojCentrale = brojCentrale;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Trener> getTreneri() {
        return treneri;
    }

    public void setTreneri(Set<Trener> treneri) {
        this.treneri = treneri;
    }

    public Set<Sala> getSale() {
        return sale;
    }

    public void setSale(Set<Sala> sale) {
        this.sale = sale;
    }

    public Set<OdrzavanjeTreninga> getRasporedOdrzavanjaTreninga() {
        return rasporedOdrzavanjaTreninga;
    }

    public void setRasporedOdrzavanjaTreninga(Set<OdrzavanjeTreninga> rasporedOdrzavanjaTreninga) {
        this.rasporedOdrzavanjaTreninga = rasporedOdrzavanjaTreninga;
    }
}
