package com.example.Web.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Sala implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private double kapacitet;
    @Column
    private String oznaka;

    @ManyToMany
    @JoinTable(name = "termini",
            joinColumns = @JoinColumn(name = "sala_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "termin_id", referencedColumnName = "id"))
    private List<TerminskaListaTreninga> terminskaListaTreninga = new ArrayList<TerminskaListaTreninga>();


    @ManyToOne(fetch = FetchType.EAGER)
    private FitnesCentar fitnesCentar;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getKapacitet() {
        return kapacitet;
    }

    public void setKapacitet(double kapacitet) {
        this.kapacitet = kapacitet;
    }

    public String getOznaka() {
        return oznaka;
    }

    public void setOznaka(String oznaka) {
        this.oznaka = oznaka;
    }

    public List<TerminskaListaTreninga> getTerminskaListaTreninga() {
        return terminskaListaTreninga;
    }

    public void setTerminskaListaTreninga(ArrayList<TerminskaListaTreninga> terminskaListaTreninga) {
        this.terminskaListaTreninga = terminskaListaTreninga;
    }

    public FitnesCentar getFitnesCentar() {
        return fitnesCentar;
    }

    public void setFitnesCentar(FitnesCentar fitnesCentar) {
        this.fitnesCentar = fitnesCentar;
    }
}
