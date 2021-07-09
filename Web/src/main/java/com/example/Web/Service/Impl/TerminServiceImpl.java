package com.example.Web.Service.Impl;

import com.example.Web.Model.Termin;
import com.example.Web.Repository.TerminRepository;
import com.example.Web.Service.TerminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
//@Component
@Service

public class TerminServiceImpl implements TerminService {
    private final TerminRepository terminRepository;

    @Autowired
    public TerminServiceImpl(TerminRepository terminRepository){this.terminRepository = terminRepository;}

    @Override
    public Termin findOne(Long id){
        Termin termin = this.terminRepository.findById(id).get();
        return termin;
    }

    @Override
    public List<Termin> findAll() {
        List<Termin> termini = this.terminRepository.findAll();
        return termini;
    }

    @Override
    public Termin create(Termin termin) throws Exception {
        if(termin.getId() != null) {
            throw new Exception("ID must be null!");
        }
        Termin noviTermin = this.terminRepository.save(termin);
        return noviTermin;
    }

    @Override
    public Termin update(Termin termin) throws Exception {
        Termin TerminZaIzmenu = this.terminRepository.findById(termin.getId()).get();
        if(termin.getId() == null) {
            throw new Exception("Termin ne postoji!");
        }
        TerminZaIzmenu.setBrojClanova(termin.getBrojClanova());
        TerminZaIzmenu.setCena(termin.getCena());
        TerminZaIzmenu.setDatumKraja(termin.getDatumKraja());
        TerminZaIzmenu.setDatumPocetka(termin.getDatumPocetka());
        TerminZaIzmenu.setFitnesCentar(termin.getFitnesCentar());
        TerminZaIzmenu.setSala(termin.getSala());
        TerminZaIzmenu.setTrening(termin.getTrening());
        Termin izmenjenTermin = terminRepository.save(TerminZaIzmenu);
        return izmenjenTermin;
        }

    @Override
    public void delete(Long id) {
        this.terminRepository.deleteById(id);
    }

}
