package com.example.Web.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
//@Table(name = "KORISNIK")
@MappedSuperclass
//@Entity
public class Korisnik implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "KORISNICKOIME", unique = true)
    private String korisnickoIme;
    @Column(nullable = false)
    private String ime;
    @Column(nullable = false)
    private String prezime;
    @Column(nullable = false)
    private String lozinka;
    @Column
    private String telefon;
    @Column
    private String email;
    @Column(name = "DATUMRODJENJA")
    private Date datumRodjenja;
    @Column
    private boolean aktivan;
    @Column(nullable = false)
    private Uloga uloga;


    public Korisnik() {
    }
}
