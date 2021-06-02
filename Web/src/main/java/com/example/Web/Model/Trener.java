package com.example.Web.Model;

import javax.persistence.*;
import java.util.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@Entity
public class Trener extends Korisnik {


    @OneToMany(mappedBy = "trener", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Trening> listaTreninga = new HashSet<Trening>();

    @Column
    private float prosecnaOcena;

    @ManyToOne(fetch = FetchType.EAGER)
    private FitnesCentar fitnesCentar;

    

}
