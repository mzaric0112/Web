package com.example.Web.Model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter

@Setter
@AllArgsConstructor

public class TreningTreneraDTO {
    private Long id;
    private String naziv;
    private String opis;
    private String tipTreninga;

    private int trajanje;
    public TreningTreneraDTO(){}
}
