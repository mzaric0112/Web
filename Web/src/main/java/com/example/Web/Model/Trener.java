package com.example.Web.Model;

import javax.persistence.*;
import java.util.*;

@Entity
public class Trener extends Korisnik {


    @OneToMany(mappedBy = "trener", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Trening> listaTreninga = new HashSet<Trening>();

    @Column
    private float prosecnaOcena;

    @ManyToOne(fetch = FetchType.EAGER)
    private FitnesCentar fitnesCentar;

    public Set<Trening> getListaTreninga() {
        return listaTreninga;
    }

    public void setListaTreninga(Set<Trening> listaTreninga) {
        this.listaTreninga = listaTreninga;
    }

   /* public float getProsecnaOcena() {
        return prosecnaOcena;
    }

    public void setProsecnaOcena(float prosecnaOcena) {
        this.prosecnaOcena = prosecnaOcena;
    }
*/
    public FitnesCentar getFitnesCentar() {
        return fitnesCentar;
    }

    public void setFitnesCentar(FitnesCentar fitnesCentar) {
        this.fitnesCentar = fitnesCentar;
    }

}
