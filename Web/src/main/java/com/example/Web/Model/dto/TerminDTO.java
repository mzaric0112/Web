package com.example.Web.Model.dto;

import com.example.Web.Model.FitnesCentar;
import com.example.Web.Model.Sala;
import com.example.Web.Model.Trening;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class TerminDTO {

    private Long id;
    private double cena;
    private Date datumPocetka;
    private Date datumKraja;
    private int brojClanova;
    private Trening trening;

    private Sala sala;

    private FitnesCentar fitnesCentar;
    public TerminDTO(){}

    public TerminDTO(Long id, double cena, Date datumPocetka, Date datumKraja, int brojClanova, Trening trening, Sala sala, FitnesCentar fitnesCentar) {
        this.id = id;
        this.cena = cena;
        this.datumPocetka = datumPocetka;
        this.datumKraja = datumKraja;
        this.brojClanova = brojClanova;
        this.trening = trening;
        this.sala = sala;
        this.fitnesCentar = fitnesCentar;
    }
}
