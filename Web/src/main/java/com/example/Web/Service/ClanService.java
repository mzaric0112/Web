package com.example.Web.Service;

import com.example.Web.Model.Clan;

import java.util.List;

public interface ClanService {
    Clan findOne(Long id);
    List<Clan> findAll();
    Clan create(Clan clan) throws Exception;
    Clan update(Clan clan) throws Exception;
    void delete(Long id);
    Clan getByKorisnickoImeAndLozinka(String korisnickoIme, String lozinka);
}
