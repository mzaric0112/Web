package com.example.Web.Model;


import javax.persistence.*;
import java.util.*;

@Entity
public class Clan extends Korisnik {

    // clan moze ici na vise treninga, na jednom treningu moze biti vise clanova
    @ManyToMany
    @JoinTable( name = "odradjeniTreninzi",
        joinColumns = @JoinColumn( name = "clan_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn( name = "trening_id", referencedColumnName = "id"))
    private List<Trening> treninzi = new ArrayList<Trening>();

    //clan moze da se prijavi za vise treninga, za jedan trening moze da se prijavi vise clanova
    @ManyToMany
    @JoinTable( name = "prijavljeniTreninzi",
            joinColumns = @JoinColumn(name = "clan_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "trening_id", referencedColumnName = "id"))
    private List<Trening> prijavljeniTreninzi = new ArrayList<Trening>();

    //da li trening posmatrati kao grupni ili individualni

    @ManyToMany
    @JoinTable( name = "ocenjeniTreninzi",
            joinColumns = @JoinColumn(name = "clan_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "ocena_treninga_id", referencedColumnName = "id"))
    private List<OcenaTreninga> ocene = new ArrayList<OcenaTreninga>();

    public List<Trening> getTreninzi() {
        return treninzi;
    }

    public void setTreninzi(ArrayList<Trening> treninzi) {
        this.treninzi = treninzi;
    }

    public List<Trening> getPrijavljeniTreninzi() {
        return prijavljeniTreninzi;
    }

    public void setPrijavljeniTreninzi(ArrayList<Trening> prijavljeniTreninzi) {
        this.prijavljeniTreninzi = prijavljeniTreninzi;
    }

    public List<OcenaTreninga> getOcene() {
        return ocene;
    }

    public void setOcene(ArrayList<OcenaTreninga> ocene) {
        this.ocene = ocene;
    }


}
