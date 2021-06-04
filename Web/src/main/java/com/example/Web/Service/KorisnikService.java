package com.example.Web.Service;

import com.example.Web.Model.Korisnik;

import java.util.List;

public interface KorisnikService {
    Korisnik findOne(Long id);
    List<Korisnik> findAll();
    Korisnik create(Korisnik korisnik) throws Exception;
    Korisnik update(Korisnik korisnik) throws Exception;
    void delete(Long id);
}

