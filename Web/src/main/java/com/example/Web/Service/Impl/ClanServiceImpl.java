package com.example.Web.Service.Impl;

import com.example.Web.Model.Clan;
import com.example.Web.Repository.ClanRepository;
import com.example.Web.Service.ClanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClanServiceImpl implements ClanService {
    private final ClanRepository clanRepository;

    @Autowired
    public ClanServiceImpl(ClanRepository clanRepository ){this.clanRepository = clanRepository;}


    @Override
    public Clan findOne(Long id){
        Clan korisnik = this.clanRepository.findById(id).get();
        return korisnik;
    }
    @Override

    public Clan getByKorisnickoImeAndLozinka(String korisnickoIme, String lozinka) {
        Clan korisnik = this.clanRepository.findByKorisnickoImeAndLozinka(korisnickoIme,lozinka);
        return korisnik;
    }

    @Override
    public List<Clan> findAll() {
        List<Clan> korisnici = this.clanRepository.findAll();
        return korisnici;
    }

    @Override
    public Clan create(Clan korisnik) throws Exception {
        if(korisnik.getId() != null) {
            throw new Exception("ID must be null!");
        }
        Clan noviKorisnik = this.clanRepository.save(korisnik);
        return noviKorisnik;
    }

    @Override
    public Clan update(Clan korisnik) throws Exception {
        Clan korisnikZaIzmenu = this.clanRepository.findById(korisnik.getId()).get();
        if(korisnik.getId() == null) {
            throw new Exception("User doesn't exist!");
        }
        korisnikZaIzmenu.setIme(korisnik.getIme());
        korisnikZaIzmenu.setPrezime(korisnik.getPrezime());
        korisnikZaIzmenu.setDatumRodjenja(korisnik.getDatumRodjenja());
        korisnikZaIzmenu.setEmail(korisnik.getEmail());
        korisnikZaIzmenu.setTelefon(korisnik.getTelefon());
        Clan izmenjenKorisnik = clanRepository.save(korisnikZaIzmenu);
        return izmenjenKorisnik;
    }

    @Override
    public void delete(Long id) {
        this.clanRepository.deleteById(id);
    }

}
