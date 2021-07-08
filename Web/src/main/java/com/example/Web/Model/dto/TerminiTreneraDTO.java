package com.example.Web.Model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor

public class TerminiTreneraDTO {
    private Long id;
    private double cena;
    private Date datumPocetka;
    private String nazivTreninga;

    public TerminiTreneraDTO(){}

}
