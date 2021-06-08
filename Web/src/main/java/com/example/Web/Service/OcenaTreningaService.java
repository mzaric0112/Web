package com.example.Web.Service;

import com.example.Web.Model.OcenaTreninga;

import java.util.List;

public interface OcenaTreningaService {

    OcenaTreninga findOne(Long id);
    List<OcenaTreninga> findAll();
    OcenaTreninga create(OcenaTreninga trening) throws Exception;
    OcenaTreninga update(OcenaTreninga trening) throws Exception;
    void delete(Long id);
    List<OcenaTreninga> getByTreningId(Long id);


}
