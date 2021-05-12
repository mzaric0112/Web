package com.example.Web.Service;


import com.example.Web.Model.Korisnik;
import com.example.Web.Repository.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KorisnikService {
    @Autowired
    private KorisnikRepository korisnikRepository;

    public Korisnik findOne(Long id) {
        Korisnik korisnik = this.korisnikRepository.getOne(id);
        return korisnik;
    }

    public List<Korisnik> findAll(){
         List<Korisnik> korisnici = this.korisnikRepository.findAll();
         return korisnici;
    }

    public Korisnik save(Korisnik korisnik) {
        return this.korisnikRepository.save(korisnik);
    }

    public void delete(Long id) {
        this.korisnikRepository.deleteById(id);
    }

}
