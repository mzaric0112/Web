package com.example.Web.Service;

import com.example.Web.Model.Trening;

import java.util.List;

public interface TreningService {
    Trening findOne(Long id);
    List<Trening> findAll();
    Trening create(Trening trening) throws Exception;
    Trening update(Trening trening) throws Exception;
    void delete(Long id);
}
