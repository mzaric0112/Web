package com.example.Web.Service.Impl;

import com.example.Web.Model.FitnesCentar;
import com.example.Web.Repository.FitnesCentarRepository;
import com.example.Web.Service.FitnesCentarService;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class FitnesCentarServiceImpl implements FitnesCentarService {
    private final FitnesCentarRepository fitnesCentarRepository;

    @Autowired
    public FitnesCentarServiceImpl(FitnesCentarRepository fitnessRepository){this.fitnesCentarRepository = fitnessRepository;}


    @Override
    public FitnesCentar findOne(Long id){
        FitnesCentar fitnesCentar = this.fitnesCentarRepository.findById(id).get();
        return fitnesCentar;
    }

    @Override
    public List<FitnesCentar> findAll() {
        List<FitnesCentar> fitnesCentri = this.fitnesCentarRepository.findAll();
        return fitnesCentri;

    }

    @Override
    public FitnesCentar create(FitnesCentar fitnesCentar) throws Exception {
        if(fitnesCentar.getId() != null) {
            throw new Exception("ID must be null!");
        }
        FitnesCentar noviFitnesCentar = this.fitnesCentarRepository.save(fitnesCentar);
        return noviFitnesCentar;
    }

    @Override
    public FitnesCentar update(FitnesCentar fitnesCentar) throws Exception {
        FitnesCentar fitnesCentarZaIzmenu = this.fitnesCentarRepository.findById(fitnesCentar.getId()).get();
        if(fitnesCentar.getId() == null) {
            throw new Exception("Fitness center doesn't exist!");
        }
        fitnesCentarZaIzmenu.setNaziv(fitnesCentar.getNaziv());
        fitnesCentarZaIzmenu.setAdresa(fitnesCentar.getAdresa());
        fitnesCentarZaIzmenu.setBrojCentrale(fitnesCentar.getBrojCentrale());
        fitnesCentarZaIzmenu.setEmail(fitnesCentar.getEmail());
        FitnesCentar fitnesCetar = this.fitnesCentarRepository.save(fitnesCentarZaIzmenu);
        return fitnesCentar;
    }

    @Override
    public void delete(Long id) {
        this.fitnesCentarRepository.deleteById(id);
    }


}
