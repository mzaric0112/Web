package com.example.Web.Service;

import com.example.Web.Model.Trener;

import java.util.List;

public interface TrenerService {
    Trener findOne(Long id);
    List<Trener> findAll();
    Trener create(Trener korisnik) throws Exception;
    Trener update(Trener korisnik) throws Exception;
    void delete(Long id);
}

