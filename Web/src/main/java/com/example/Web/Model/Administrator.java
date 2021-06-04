package com.example.Web.Model;

import javax.persistence.Entity;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Administrator extends Korisnik {
    public Administrator() {
    }

    public Administrator(String korisnickoIme, String lozinka, String ime, String prezime, Date datumRodjenja, String email,
                         String telefon, Uloga uloga) {
        super(korisnickoIme, lozinka, ime, prezime, datumRodjenja, email, telefon, uloga);
    }
}
