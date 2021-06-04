package com.example.Web.Service.Impl;

import com.example.Web.Model.Korisnik;
import com.example.Web.Repository.KorisnikRepository;
import com.example.Web.Service.KorisnikService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class KorisnikServiceImpl implements KorisnikService {

    private final KorisnikRepository korisnikRepository;

    @Autowired
    public KorisnikServiceImpl(KorisnikRepository korisnikRepository) {this.korisnikRepository = korisnikRepository; }
    @Override
    public Korisnik findOne(Long id){
        Korisnik korisnik = this.korisnikRepository.getOne(id);
        return korisnik;
    }

    @Override
    public List<Korisnik> findAll() {
        List<Korisnik> korisnici = this.korisnikRepository.findAll();
        return korisnici;
    }

    @Override
    Korisnik create(Korisnik korisnik) throws Exception {
        if(korisnik.getId() != null) {
            throw new Exception("ID must be null!");
        }
        Korisnik noviKorisnik = this.korisnikRepository.save(korisnik);
        return noviKorisnik;
    }

    @Override
    Korisnik update(Korisnik korisnik) throws Exception {
        Korisnik korisnikZaIzmenu = this.korisnikRepository.getOne(korisnik.getId());
        if(korisnik.getId() == null) {
            throw new Exception("User doesn't exist!");
        }
        korisnikZaIzmenu.setIme(korisnik.getIme());
        korisnikZaIzmenu.setPrezime(korisnik.getPrezime());
        korisnikZaIzmenu.setDatumRodjenja(korisnik.getDatumRodjenja());
        korisnikZaIzmenu.setEmail(korisnik.getEmail());
        korisnikZaIzmenu.setTelefon(korisnik.getTelefon());
    }

    @Override
    void delete(Long id) {
        this.korisnikRepository.deleteById(id);♦
    }

}
