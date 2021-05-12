package com.example.Web.Service;

import com.example.Web.Model.Korisnik;
import com.example.Web.Model.Sala;
import com.example.Web.Repository.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaService {
    @Autowired
    private SalaRepository salaRepository;

    public Sala findOne(Long id) {
        Sala s = this.salaRepository.getOne(id);
        return s;
    }

    public List<Sala> findAll(){
        List<Sala> k = this.salaRepository.findAll();
        return k;
    }

    public Sala save(Sala s) {
        return this.salaRepository.save(s);
    }

    public void delete(Long id) {
        this.salaRepository.deleteById(id);
    }
}
