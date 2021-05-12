package com.example.Web.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class TerminskaListaTreninga implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private int prijavljeniClanovi;
    @Column
    private OdrzavanjeTreninga odrzavanje;

    @ManyToMany(mappedBy = "terminskaListaTreninga")
    private List<Sala> sale = new ArrayList<Sala>();

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

    public OdrzavanjeTreninga getOdrzavanje() {
        return odrzavanje;
    }

    public void setOdrzavanje(OdrzavanjeTreninga odrzavanje) {
        this.odrzavanje = odrzavanje;
    }

    public List<Sala> getSale() {
        return sale;
    }

    public void setSale(ArrayList<Sala> sale) {
        this.sale = sale;
    }
}
