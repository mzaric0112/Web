package com.example.Web.Controller;

import com.example.Web.Model.FitnesCentar;
import com.example.Web.Model.dto.FitnesCentarDTO;
import com.example.Web.Model.dto.KorisnikTreninziDTO;
import com.example.Web.Repository.FitnesCentarRepository;
import com.example.Web.Service.FitnesCentarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/fitnesCentar")
public class FitnesCentarController {
    private final FitnesCentarService fitnesCentarService;

    @Autowired
    public FitnesCentarController(FitnesCentarService fitnesCentarService) {this.fitnesCentarService = fitnesCentarService;}


     @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FitnesCentarDTO> getFitnessCenter(@PathVariable("id") Long id)
    {
        FitnesCentar fitnesCentar = this.fitnesCentarService.findOne(id);
        FitnesCentarDTO trazeniFitnesCentar = new FitnesCentarDTO();
        trazeniFitnesCentar.setId(fitnesCentar.getId());
        trazeniFitnesCentar.setAdresa(fitnesCentar.getAdresa());
        trazeniFitnesCentar.setNaziv(fitnesCentar.getNaziv());
        trazeniFitnesCentar.setBrojCentrale(fitnesCentar.getBrojCentrale());
        trazeniFitnesCentar.setEmail(fitnesCentar.getEmail());
        return new ResponseEntity<>(trazeniFitnesCentar, HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FitnesCentarDTO>> getFitnessCenters() {
        List<FitnesCentar> fitnesCentri = this.fitnesCentarService.findAll();

        List<FitnesCentarDTO> trazeniFitnesCentri = new ArrayList<FitnesCentarDTO>();

        for(FitnesCentar fc : fitnesCentri) {
            FitnesCentarDTO fitnesCentar = new FitnesCentarDTO(fc.getId(), fc.getNaziv(),fc.getAdresa(),fc.getBrojCentrale(),
            fc.getEmail());
            trazeniFitnesCentri.add(fitnesCentar);
        }
        return new ResponseEntity<>(trazeniFitnesCentri, HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FitnesCentarDTO> createFitnessCenter(@RequestBody FitnesCentarDTO fcDTO) throws Exception {
        FitnesCentar fitnesCentar = new FitnesCentar(fcDTO.getNaziv(), fcDTO.getAdresa(), fcDTO.getBrojCentrale(), fcDTO.getEmail());
        FitnesCentar noviFitnesCentar = this.fitnesCentarService.create(fitnesCentar);
        FitnesCentarDTO fitnesCentarDTO = new FitnesCentarDTO(noviFitnesCentar.getId(),noviFitnesCentar.getNaziv(),
                noviFitnesCentar.getAdresa(), noviFitnesCentar.getBrojCentrale(), noviFitnesCentar.getEmail());
        return new ResponseEntity<>(fitnesCentarDTO, HttpStatus.CREATED);

    }
    @PutMapping(value = "/izmena",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> izmena(@RequestBody FitnesCentarDTO fcDTO) throws Exception {
        //FitnesCentar fitnesCentar = new FitnesCentar(fcDTO.getId(), fcDTO.getNaziv(), fcDTO.getAdresa(), fcDTO.getBrojCentrale(), fcDTO.getEmail());
        FitnesCentar fitnesCentar = fitnesCentarService.findOne(fcDTO.getId());
        fitnesCentar.setAdresa(fcDTO.getAdresa());
        fitnesCentar.setNaziv(fcDTO.getNaziv());
        fitnesCentar.setEmail(fcDTO.getEmail());
        fitnesCentar.setBrojCentrale(fcDTO.getBrojCentrale());



        return new ResponseEntity<>(HttpStatus.OK);

    }
    @PostMapping(value = "/brisanje",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> brisanje(@RequestBody KorisnikTreninziDTO id) {
        this.fitnesCentarService.delete(id.getIdKorisnika());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
