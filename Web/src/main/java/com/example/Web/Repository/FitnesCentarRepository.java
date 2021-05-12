package com.example.Web.Repository;

import com.example.Web.Model.FitnesCentar;
import com.example.Web.Model.Trener;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FitnesCentarRepository extends JpaRepository<FitnesCentar, Long> {
    void deleteById(Long id);
    List<FitnesCentar> findAll();
}
