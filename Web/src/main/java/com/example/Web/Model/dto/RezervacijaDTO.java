package com.example.Web.Model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter

public class RezervacijaDTO {
        private Long idKorisnika;
        private Long idTermina;

        public RezervacijaDTO() {}

}
