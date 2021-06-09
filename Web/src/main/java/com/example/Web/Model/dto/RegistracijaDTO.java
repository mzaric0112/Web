package com.example.Web.Model.dto;

import com.example.Web.Model.Uloga;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor

public class RegistracijaDTO {
    private String korisnickoIme;
    private String ime;
    private String prezime;
    private String lozinka;
    private String telefon;
    private String email;
    private Date datumRodjenja;

    private Uloga uloga;
    public RegistracijaDTO(){}

}
