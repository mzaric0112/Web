package com.example.Web.Repository;

import com.example.Web.Model.Trener;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrenerRepository extends JpaRepository<Trener, Long> {
/*
    List<Trener> findByByIme(String ime);
    List<Trener> findByByImeOrderByIme(String ime);
    List<Trener> findByByPrezime(String prezime);
    List<Trener> findByByImeOrPrezime(String ime, String prezime);
    List<Trener> findByKorisnickoIme(String korisnickoIme);
    List<Trener> findByEmail(String email);*/

}
