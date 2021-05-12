package com.example.Web.Repository;

import com.example.Web.Model.Clan;
import com.example.Web.Model.Trener;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClanRepository extends JpaRepository<Clan, Long> {
    /*void deleteById(Long id);
    List<Clan> findAll();
    List<Clan> findByByIme(String ime);
    List<Trener> findByByPrezime(String prezime);
    List<Trener> findByByImeOrPrezime(String ime, String prezime);*/
}
