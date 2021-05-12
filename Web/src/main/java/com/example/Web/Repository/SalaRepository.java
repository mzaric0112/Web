package com.example.Web.Repository;

import com.example.Web.Model.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SalaRepository extends JpaRepository<Sala, Long> {
    void deleteById(Long id);
    List<Sala> findAll();
    //Sala findByOznaka(String oznaka);

}
