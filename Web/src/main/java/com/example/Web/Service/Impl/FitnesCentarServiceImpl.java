package com.example.Web.Service.Impl;

import com.example.Web.Model.FitnesCentar;
import com.example.Web.Repository.FitnesCentarRepository;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class FitnesCentarServiceImpl {
    private final FitnesCentarRepository fitnesCentarRepository;

    @Autowired
    public FitnesCentarServiceImpl(FitnesCentarRepository fitnessRepository){this.fitnesCentarRepository = fitnessRepository;}


    @Override
    public FitnesCentar findOne(Long id){
        FitnesCentar fitnesCentar = this.fitnesCentarRepository.getOne(id);
        return fitnesCentar;
    }

    @Override
    public List<FitnesCentar> findAll() {
        List<FitnesCentar> fitnesCentri = this.fitnesCentarRepository.findAll();
        return fitnesCentri;

    }

    @Override
    FitnesCentar create(FitnesCentar fitnesCentar) throws Exception {
        if(fitnesCentar.getId() != null) {
            throw new Exception("ID must be null!");
        }
        FitnesCentar noviFitnesCentar = this.fitnesCentarRepository.save(fitnesCentar);
        return noviFitnesCentar;
    }

    @Override
    FitnesCentar update(FitnesCentar fitnesCentar) throws Exception {
        FitnesCentar fitnesCentarZaIzmenu = this.fitnesCentarRepository.getOne(fitnesCentar.getId());
        if(fitnesCentar.getId() == null) {
            throw new Exception("Fitness center doesn't exist!");
        }
        fitnesCentarZaIzmenu.setNaziv(fitnesCentar.getNaziv());
        fitnesCentarZaIzmenu.setAdresa(fitnesCentar.getAdresa());
        fitnesCentarZaIzmenu.setBrojCentrale(fitnesCentar.getBrojCentrale());
        fitnesCentarZaIzmenu.setEmail(fitnesCentar.getEmail());

    }

    @Override
    void delete(Long id) {
        this.fitnesCentarRepository.deleteById(id);♦
    }


}
