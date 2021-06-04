package com.example.Web.Model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
@Getter
@Setter
public class FitnesCentarDTO {
    private Long id;
    private String naziv;
    private String adresa;
    private String brojCentrale;
    private String email;

    public FitnesCentarDTO() {
    }

    public FitnesCentarDTO(Long id, String naziv, String adresa, String brojCentrale, String email) {
        this.id = id;
        this.naziv = naziv;
        this.adresa = adresa;
        this.brojCentrale = brojCentrale;
        this.email = email;
    }
}
