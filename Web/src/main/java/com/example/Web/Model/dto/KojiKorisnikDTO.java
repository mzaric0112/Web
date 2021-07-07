package com.example.Web.Model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@AllArgsConstructor
public class KojiKorisnikDTO {
    private Long idKorisnika;
    private Long idTermina;
    private float ocena;
    public KojiKorisnikDTO(){}
}
