package com.example.Web.Service;

import com.example.Web.Model.FitnesCentar;

import java.util.List;

public interface FitnesCentarService {
    FitnesCentar findOne(Long id);
    List<FitnesCentar> findAll();
    FitnesCentar create(FitnesCentar fitnesCentar) throws Exception;
    FitnesCentar update(FitnesCentar fitnesCentar) throws Exception;
    void delete(Long id);
}
