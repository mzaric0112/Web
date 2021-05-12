package com.example.Web.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Web.Model.Trener;

import java.util.List;

public interface TrenerRepository  extends JpaRepository<Trener, Long> {
    /*void deleteById(Long id);
    List<Trener> findAll();
    List<Trener> findByByIme(String ime);
    List<Trener> findByByPrezime(String prezime);
    List<Trener> findByByImeOrPrezime(String ime, String prezime);*/

}
