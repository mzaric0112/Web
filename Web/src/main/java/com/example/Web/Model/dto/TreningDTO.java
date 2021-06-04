package com.example.Web.Model.dto;

import com.example.Web.Model.Trener;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
@Getter
@Setter
public class TreningDTO {
    private Long id;
    private String naziv;
    private String opis;
    private String tipTreninga;

    private int trajanje;
    private Trener trener;

    public TreningDTO() {
    }

    public TreningDTO(Long id, String naziv, String opis, String tipTreninga, int trajanje, Trener trener) {
        this.id = id;
        this.naziv = naziv;
        this.opis = opis;
        this.tipTreninga = tipTreninga;
        this.trajanje = trajanje;
        this.trener = trener;
    }
}
