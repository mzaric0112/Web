package com.example.Web.Repository;
import com.example.Web.Model.Termin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface TerminRepository extends JpaRepository<Termin, Long> {

    List<Termin> findByCena(double cena);
    List<Termin> findByDatumKraja( Date datumKraja);

    List<Termin> findByDatumPocetka(Date datumKraja);



}
