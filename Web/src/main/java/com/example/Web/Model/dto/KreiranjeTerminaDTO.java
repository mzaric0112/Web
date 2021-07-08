package com.example.Web.Model.dto;

import com.example.Web.Model.Trening;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor

public class KreiranjeTerminaDTO {
    private Long korisnik;
    private Long trening;
    private Date datumPocetka;
    private double cena;

    public KreiranjeTerminaDTO(){}
}
