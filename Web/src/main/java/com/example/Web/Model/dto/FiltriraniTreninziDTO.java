package com.example.Web.Model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class FiltriraniTreninziDTO {
    private Long idt;
    private String naziv;
    private double cena;
    private int trajanje;
    private Date datumPocetka;
    private Date datumKraja;
    private int preostalaMesta;
    private String imeTrenera;
    private String tipTreninga;
    private float prosecnaOcena;
    private String nazivFitnesCentra;
    private String nazivSale;
    private boolean odgovara;


    public FiltriraniTreninziDTO(){}
    public void zameni(FiltriraniTreninziDTO dto) {
        this.setNaziv(dto.getNaziv());
        this.setCena(dto.getCena());
        this.setTrajanje(dto.getTrajanje());
        this.setDatumPocetka(dto.getDatumPocetka());
        this.setDatumKraja(dto.getDatumKraja());
        this.setPreostalaMesta(dto.getPreostalaMesta());
        this.setImeTrenera(dto.getImeTrenera());
        this.setTipTreninga(dto.getTipTreninga());
        this.setProsecnaOcena(dto.getProsecnaOcena());
        this.setNazivFitnesCentra(dto.getNazivFitnesCentra());
        this.setNazivSale(dto.getNazivSale());
        this.setOdgovara(dto.isOdgovara());
        this.setIdt(dto.getIdt());

    }

}
