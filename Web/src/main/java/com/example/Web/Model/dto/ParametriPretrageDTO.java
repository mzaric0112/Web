package com.example.Web.Model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ParametriPretrageDTO {
    private String naziv;
    private String tipTreninga;
    private int trajanje;
    private int tipSortiranja;

    public ParametriPretrageDTO() {}

}
