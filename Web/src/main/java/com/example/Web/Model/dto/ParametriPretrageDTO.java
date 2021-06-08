package com.example.Web.Model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class ParametriPretrageDTO {
    private String naziv;
    private double cena;
    private int trajanje;
    private Date datumPocetka;
    private int tipSortiranja;

    public ParametriPretrageDTO() {}

}
