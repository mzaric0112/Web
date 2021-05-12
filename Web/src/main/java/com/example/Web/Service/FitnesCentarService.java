package com.example.Web.Service;


import com.example.Web.Model.FitnesCentar;
import com.example.Web.Repository.FitnesCentarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FitnesCentarService {
    @Autowired
    private FitnesCentarRepository fitnesCentarRepository;

    public FitnesCentar findOne(Long id) {
        FitnesCentar fitnesCentar = this.fitnesCentarRepository.getOne(id);
        return fitnesCentar;
    }

    public List<FitnesCentar> findAll() {
        List<FitnesCentar> fitnesCentar = this.fitnesCentarRepository.findAll();
        return fitnesCentar;
    }

    public FitnesCentar save(FitnesCentar employee) {
        return this.fitnesCentarRepository.save(employee);
    }

    public void delete(Long id) {
        this.fitnesCentarRepository.deleteById(id);
    }
}
