package com.example.Web.Repository;

import com.example.Web.Model.Administrator;
import com.example.Web.Model.Trener;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrenerRepository extends JpaRepository<Trener, Long> {

    Trener findByKorisnickoImeAndLozinka(String korisnickoIme, String lozinka);

}
