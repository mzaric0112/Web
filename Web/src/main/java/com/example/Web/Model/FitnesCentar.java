package com.example.Web.Model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity

public class FitnesCentar implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
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

    //termin treba biti ne odrzavanje treninga
    @OneToMany(mappedBy = "fitnesCentar", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
   private Set<Termin> rasporedOdrzavanjaTreninga = new HashSet<>();

    public FitnesCentar() {
    }

    public FitnesCentar(String naziv, String adresa, String brojCentrale, String email) {

        this.naziv = naziv;
        this.adresa = adresa;
        this.brojCentrale = brojCentrale;
        this.email = email;
        this.rasporedOdrzavanjaTreninga = null;
        this.sale = null;
        this.treneri = null;
    }

    public FitnesCentar(Long id, String naziv, String adresa, String brojCentrale, String email,
                        Set<Trener> treneri, Set<Sala> sale, Set<Termin> rasporedOdrzavanjaTreninga) {
        this.id = id;
        this.naziv = naziv;
        this.adresa = adresa;
        this.brojCentrale = brojCentrale;
        this.email = email;
        this.treneri = treneri;
        this.sale = sale;
        this.rasporedOdrzavanjaTreninga = rasporedOdrzavanjaTreninga;
    }
}
