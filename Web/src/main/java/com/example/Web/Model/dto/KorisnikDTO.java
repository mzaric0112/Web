package com.example.Web.Model.dto;

import com.example.Web.Model.Uloga;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class KorisnikDTO {

    private Long id;
    private String ime;
    private String prezime;
    private Date datumRodjenja;
    private String email;
    private String telefon;
    private Uloga uloga;

    public KorisnikDTO() {}

    public KorisnikDTO(Long id, String ime, String prezime, Date datumRodjenja, String email, String telefon, Uloga uloga) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.datumRodjenja = datumRodjenja;
        this.email = email;
        this.telefon = telefon;
        this.uloga = uloga;
    }
}
