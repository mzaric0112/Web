package com.example.Web.Service.Impl;

import com.example.Web.Model.OcenaTreninga;
import com.example.Web.Repository.OcenaTreningaRepository;
import com.example.Web.Service.OcenaTreningaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//@Component
@Service

public class OcenaTreningaServiceImpl implements OcenaTreningaService {
    private final OcenaTreningaRepository ocenaTreningaRepository;
    @Autowired
    public OcenaTreningaServiceImpl(OcenaTreningaRepository ocenaTreningaRepository) {this.ocenaTreningaRepository = ocenaTreningaRepository;}



     @Override
    public OcenaTreninga findOne(Long id){
        OcenaTreninga OcenaTreninga = this.ocenaTreningaRepository.getOne(id);
        return OcenaTreninga;
    }


    @Override
    public List<OcenaTreninga> findAll() {
        List<OcenaTreninga> OcenaTreninga = this.ocenaTreningaRepository.findAll();
        return OcenaTreninga;
    }

    @Override
    public OcenaTreninga create(OcenaTreninga trening) throws Exception {
        if(trening.getId() != null) {
            throw new Exception("ID must be null!");
        }
        OcenaTreninga noviTrening = this.ocenaTreningaRepository.save(trening);
        return noviTrening;
    }

    @Override
    public OcenaTreninga update(OcenaTreninga trening) throws Exception {
        OcenaTreninga treningZaIzmenu = this.ocenaTreningaRepository.getOne(trening.getId());
        if(trening.getId() == null) {
            throw new Exception("Trening doesn't exist!");
        }
        treningZaIzmenu.setTermin(trening.getTermin());
        treningZaIzmenu.setClan(trening.getClan());
        treningZaIzmenu.setOcena(trening.getOcena());

        OcenaTreninga izmenjenTrening = this.ocenaTreningaRepository.save(treningZaIzmenu);
        return izmenjenTrening;
    }

    @Override
    public void delete(Long id) {
        this.ocenaTreningaRepository.deleteById(id);
    }

    @Override
    public List<OcenaTreninga> getByTreningId(Long id) {
        List<OcenaTreninga> ret = new ArrayList<>();


        for(OcenaTreninga ocena : this.ocenaTreningaRepository.findAll()) {
			if(ocena.getTermin().getTrening().getId() == id) {
				ret.add(ocena);
			}
		}
		return ret;

    }

}
