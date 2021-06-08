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
@AllArgsConstructor
@Entity
public class Sala implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private int kapacitet;
    @Column
    private String oznaka;

    @OneToMany(mappedBy = "sala", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Termin> terminskaListaTreninga = new HashSet<>();

    @ManyToOne(fetch = FetchType.EAGER)
    private FitnesCentar fitnesCentar;

    public Sala() {}

   }
