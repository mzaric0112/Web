package com.example.Web.Repository;
import com.example.Web.Model.Trening;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TreningRepository extends JpaRepository<Trening, Long> {
    List<Trening> findByNaziv(String naziv);
    List<Trening> findByTipTreninga(String tipTreninga);


}

