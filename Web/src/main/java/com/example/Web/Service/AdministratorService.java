package com.example.Web.Service;

import com.example.Web.Model.Administrator;

import java.util.List;

public interface AdministratorService {

    Administrator findOne(Long id);
    List<Administrator> findAll();
    Administrator create(Administrator clan) throws Exception;
    Administrator update(Administrator clan) throws Exception;
    void delete(Long id);
    Administrator getByKorisnickoImeAndLozinka(String korisnickoIme, String lozinka);


}
