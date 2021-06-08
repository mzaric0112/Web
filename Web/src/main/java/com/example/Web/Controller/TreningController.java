package com.example.Web.Controller;

import com.example.Web.Model.Trening;
import com.example.Web.Model.dto.TreningDTO;
import com.example.Web.Service.TreningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/treninzi")
public class TreningController {

     private final TreningService treningService;

    @Autowired
    public TreningController(TreningService treningService) {this.treningService = treningService;}


    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TreningDTO> getTraining(@PathVariable("id") Long id)
    {
        Trening trening = this.treningService.findOne(id);
        TreningDTO trazeniTrening = new TreningDTO();
        trazeniTrening.setId(trening.getId());
        trazeniTrening.setNaziv(trening.getNaziv());
        trazeniTrening.setOpis(trening.getOpis());
        trazeniTrening.setTipTreninga(trening.getTipTreninga());
        trazeniTrening.setTrajanje(trening.getTrajanje());
        trazeniTrening.setTrener(trening.getTrener());


        return new ResponseEntity<>(trazeniTrening, HttpStatus.OK);
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TreningDTO>> getTreninzi() {
        List<Trening> treninzi = this.treningService.findAll();

        List<TreningDTO> trazeniTreninzi = new ArrayList<TreningDTO>();

        for(Trening t : treninzi) {
            TreningDTO trening = new TreningDTO(t.getId(), t.getNaziv(), t.getOpis(), t.getTipTreninga(), t.getTrajanje(),t.getTrener());
            trazeniTreninzi.add(trening);
        }
        return new ResponseEntity<>(trazeniTreninzi, HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TreningDTO> createTraining(@RequestBody TreningDTO tDTO) throws Exception {
        Trening trening = new Trening(tDTO.getNaziv(), tDTO.getOpis(), tDTO.getTipTreninga(),tDTO.getTrajanje(), tDTO.getTrener());
        Trening noviTrening = this.treningService.create(trening);
        TreningDTO treningDTO = new TreningDTO(noviTrening.getId(), noviTrening.getNaziv(), noviTrening.getOpis(),
                noviTrening.getTipTreninga(), noviTrening.getTrajanje(), noviTrening.getTrener());
        return new ResponseEntity<>(treningDTO, HttpStatus.CREATED);

    }
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TreningDTO> updateTraining(@PathVariable Long id,
                      @RequestBody TreningDTO treningDTO) throws Exception {
        Trening trening = new Trening(treningDTO.getNaziv(), treningDTO.getOpis(), treningDTO.getTipTreninga(),
                treningDTO.getTrajanje(), treningDTO.getTrener());
        trening.setId(id);
        Trening izmenjenTrening = treningService.update(trening);
        TreningDTO azuriranTrening = new TreningDTO(izmenjenTrening.getId(), izmenjenTrening.getNaziv(), izmenjenTrening.getOpis(),
                izmenjenTrening.getTipTreninga(), izmenjenTrening.getTrajanje(), izmenjenTrening.getTrener());
        return new ResponseEntity<>(azuriranTrening, HttpStatus.OK);

    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteTraining(@PathVariable Long id) {
        this.treningService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
