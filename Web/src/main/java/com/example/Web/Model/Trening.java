package com.example.Web.Model;
import javax.persistence.*;
import java.io.*;
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
public class Trening implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String naziv;
    @Column
    private String opis;
    @Column(nullable = false)
    private String tipTreninga;
    @Column(nullable = false)
    
    private int trajanje;

    @OneToMany(mappedBy = "trening", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Termin> terminiTreninga = new HashSet<>();

    @ManyToOne(fetch = FetchType.EAGER)
    private Trener trener;






}
