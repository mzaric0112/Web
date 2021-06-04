package com.example.Web.Service.Impl;

import com.example.Web.Model.Trening;
import com.example.Web.Repository.TreningRepository;
import com.example.Web.Service.TreningService;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class TreningServiceImpl implements TreningService {
    private final TreningRepository treningRepository;

    @Autowired
    public TreningServiceImpl(TreningRepository treningRepository) {this.treningRepository = treningRepository;}

     @Override
    public Trening findOne(Long id){
        Trening trening = this.treningRepository.getOne(id);
        return trening;
    }


    @Override
    public List<Trening> findAll() {
        List<Trening> treninzi = this.treningRepository.findAll();
        return treninzi;
    }

    @Override
    public Trening create(Trening trening) throws Exception {
        if(trening.getId() != null) {
            throw new Exception("ID must be null!");
        }
        Trening noviTrening = this.treningRepository.save(trening);
        return noviTrening;
    }

    @Override
    public Trening update(Trening trening) throws Exception {
        Trening treningZaIzmenu = this.treningRepository.getOne(trening.getId());
        if(trening.getId() == null) {
            throw new Exception("Trening doesn't exist!");
        }
        treningZaIzmenu.setNaziv(trening.getNaziv());
        treningZaIzmenu.setOpis(trening.getOpis());
        treningZaIzmenu.setTrener(trening.getTrener());
        treningZaIzmenu.setTipTreninga(trening.getTipTreninga());
        treningZaIzmenu.setTrajanje(trening.getTrajanje());

        Trening izmenjenTrening = this.treningRepository.save(treningZaIzmenu);
        return izmenjenTrening;
    }

    @Override
    public void delete(Long id) {
        this.treningRepository.deleteById(id);
    }



}
