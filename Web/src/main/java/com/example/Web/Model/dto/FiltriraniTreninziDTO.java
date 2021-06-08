package com.example.Web.Model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FiltriraniTreninziDTO {
    private String naziv;
    private String tipTreninga;
    private int trajanje;
    private boolean odgovara;
    private Long idtlp;

    public FiltriraniTreninziDTO(){}
}
