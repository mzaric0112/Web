package com.example.Web.Model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
public class IzmenaTerminaDTO {
    private Long idKorisnika;
    private Long idTermina;
    private double cena;
    private Date datumPocetka;

    public IzmenaTerminaDTO(){}
}
