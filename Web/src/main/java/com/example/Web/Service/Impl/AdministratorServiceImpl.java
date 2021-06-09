package com.example.Web.Service.Impl;

import com.example.Web.Model.Administrator;
import com.example.Web.Repository.AdministratorRepository;
import com.example.Web.Service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministratorServiceImpl implements AdministratorService {
    private final AdministratorRepository administratorRepository;

    @Autowired
    public AdministratorServiceImpl(AdministratorRepository administratorRepository) {this.administratorRepository = administratorRepository;}


    @Override
    public Administrator findOne(Long id){
        Administrator korisnik = this.administratorRepository.getOne(id);
        return korisnik;
    }
    @Override

    public Administrator getByKorisnickoImeAndLozinka(String korisnickoIme, String lozinka){
        Administrator korisnik = this.administratorRepository.findByKorisnickoImeAndLozinka(korisnickoIme, lozinka);
        return korisnik;
    }

    @Override
    public List<Administrator> findAll() {
        List<Administrator> korisnici = this.administratorRepository.findAll();
        return korisnici;
        
    }

    @Override
    public Administrator create(Administrator korisnik) throws Exception {
        if(korisnik.getId() != null) {
            throw new Exception("ID must be null!");
        }
        Administrator noviKorisnik = this.administratorRepository.save(korisnik);
        return noviKorisnik;

    }

    @Override
    public Administrator update(Administrator korisnik) throws Exception {
        Administrator korisnikZaIzmenu = this.administratorRepository.getOne(korisnik.getId());
        if(korisnik.getId() == null) {
            throw new Exception("User doesn't exist!");
        }
        korisnikZaIzmenu.setIme(korisnik.getIme());
        korisnikZaIzmenu.setPrezime(korisnik.getPrezime());
        korisnikZaIzmenu.setDatumRodjenja(korisnik.getDatumRodjenja());
        korisnikZaIzmenu.setEmail(korisnik.getEmail());
        korisnikZaIzmenu.setTelefon(korisnik.getTelefon());
        Administrator izmenjenKorisnik = administratorRepository.save(korisnikZaIzmenu);
        return izmenjenKorisnik;
    }

    @Override
    public void delete(Long id) {
        this.administratorRepository.deleteById(id);
    }



}

