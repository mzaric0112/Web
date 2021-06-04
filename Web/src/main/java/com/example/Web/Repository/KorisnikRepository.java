package com.example.Web.Repository;

import com.example.Web.Model.Korisnik;
import com.example.Web.Model.Trener;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KorisnikRepository extends JpaRepository<Korisnik, Long> {

    List<Korisnik> findByByIme(String ime);
    List<Korisnik> findByByImeOrderByIme(String ime);
    List<Korisnik> findByByPrezime(String prezime);
    List<Korisnik> findByByImeOrPrezime(String ime, String prezime);
    List<Korisnik> findByKorisnickoIme(String korisnickoIme);
    List<Korisnik> findByEmail(String email);

}
