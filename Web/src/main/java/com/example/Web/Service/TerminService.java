package com.example.Web.Service;

import com.example.Web.Model.Termin;

import java.util.List;

public interface TerminService {

    Termin findOne(Long id);
    List<Termin> findAll();
    Termin create(Termin trening) throws Exception;
    Termin update(Termin trening) throws Exception;
    void delete(Long id);

}
