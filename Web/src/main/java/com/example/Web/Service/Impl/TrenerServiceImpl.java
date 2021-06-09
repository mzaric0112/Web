package com.example.Web.Service.Impl;

import com.example.Web.Model.Administrator;
import com.example.Web.Model.Trener;
import com.example.Web.Repository.TrenerRepository;
import com.example.Web.Service.TrenerService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class TrenerServiceImpl implements TrenerService {

    private final TrenerRepository trenerRepository;

    @Autowired
    public TrenerServiceImpl(TrenerRepository trenerRepository) {this.trenerRepository = trenerRepository; }
    @Override
    public Trener findOne(Long id){
        Trener korisnik = this.trenerRepository.getOne(id);
        return korisnik;
    }
    @Override
    public Trener getByKorisnickoImeAndLozinka(String korisnickoIme, String lozinka){
        Trener trener = this.trenerRepository.findByKorisnickoImeAndLozinka(korisnickoIme,lozinka);
        return  trener;
    }

    @Override
    public List<Trener> findAll() {
        List<Trener> korisnici = this.trenerRepository.findAll();
        return korisnici;
    }

    @Override
    public Trener create(Trener korisnik) throws Exception {
        if(korisnik.getId() != null) {
            throw new Exception("ID must be null!");
        }
        Trener noviKorisnik = this.trenerRepository.save(korisnik);
        return noviKorisnik;
    }

    @Override
    public Trener update(Trener korisnik) throws Exception {
        Trener korisnikZaIzmenu = this.trenerRepository.getOne(korisnik.getId());
        if(korisnik.getId() == null) {
            throw new Exception("User doesn't exist!");
        }
        korisnikZaIzmenu.setIme(korisnik.getIme());
        korisnikZaIzmenu.setPrezime(korisnik.getPrezime());
        korisnikZaIzmenu.setDatumRodjenja(korisnik.getDatumRodjenja());
        korisnikZaIzmenu.setEmail(korisnik.getEmail());
        korisnikZaIzmenu.setTelefon(korisnik.getTelefon());
        Trener izmenjenKorisnik = trenerRepository.save(korisnikZaIzmenu);
        return izmenjenKorisnik;
    }

    @Override
    public void delete(Long id) {
        this.trenerRepository.deleteById(id);
    }

}
