package com.example.Web.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
public class TerminskaListaTreninga implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private int prijavljeniClanovi;


    @ManyToMany(mappedBy = "terminskaListaTreninga")
    private List<Sala> sale = new ArrayList<Sala>();

    @ManyToMany(mappedBy = "terminskaLista")
    private Set<OdrzavanjeTreninga> odrzavanjeTreninga = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPrijavljeniClanovi() {
        return prijavljeniClanovi;
    }

    public void setPrijavljeniClanovi(int prijavljeniClanovi) {
        this.prijavljeniClanovi = prijavljeniClanovi;
    }



    public List<Sala> getSale() {
        return sale;
    }

    public void setSale(ArrayList<Sala> sale) {
        this.sale = sale;
    }
}
