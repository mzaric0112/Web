package com.example.Web.Model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@Entity
public class OcenaTreninga implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //ovde treba biti termin
    @ManyToOne(fetch = FetchType.EAGER)
    private Termin termin;
    @Column
    private float ocena;

    @ManyToOne(fetch = FetchType.EAGER)
    private Clan clan;

    public OcenaTreninga(){}


}
