package com.example.Web.Model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class KorisnikLoginDTO {
    private String korisnickoIme;
    private String lozinka;
    public KorisnikLoginDTO() {}

}
