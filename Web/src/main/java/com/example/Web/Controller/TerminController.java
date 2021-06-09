package com.example.Web.Controller;

import com.example.Web.Model.OcenaTreninga;
import com.example.Web.Model.Termin;
import com.example.Web.Model.dto.FiltriraniTreninziDTO;
import com.example.Web.Model.dto.ParametriPretrageDTO;
import com.example.Web.Model.dto.TerminDTO;
import com.example.Web.Service.OcenaTreningaService;
import com.example.Web.Service.TerminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="/api/termini")
public class TerminController {
    private final TerminService terminService;
    private final OcenaTreningaService ocenaTreningaService;
    @Autowired
    public TerminController(TerminService terminService, OcenaTreningaService ocenaTreningaService) {
        this.terminService = terminService;
        this.ocenaTreningaService = ocenaTreningaService;
    }





    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TerminDTO> getTermin(@PathVariable("id") Long id)
    {
        Termin Termin = this.terminService.findOne(id);
        TerminDTO trazeniTermin = new TerminDTO();
        trazeniTermin.setId(Termin.getId());
        trazeniTermin.setBrojClanova(Termin.getBrojClanova());
        trazeniTermin.setCena(Termin.getCena());
        trazeniTermin.setDatumKraja(Termin.getDatumKraja());
        trazeniTermin.setDatumPocetka(Termin.getDatumPocetka());
        trazeniTermin.setFitnesCentar(Termin.getFitnesCentar());
        trazeniTermin.setTrening(Termin.getTrening());
        trazeniTermin.setSala(Termin.getSala());
        return new ResponseEntity<>(trazeniTermin, HttpStatus.OK);
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TerminDTO>> getTermini() {
        List<Termin> termini = this.terminService.findAll();

        List<TerminDTO> trazeniTermini = new ArrayList<TerminDTO>();

        for(Termin t : termini) {
            TerminDTO termin = new TerminDTO(t.getId(), t.getCena(), t.getDatumPocetka(), t.getDatumKraja(), t.getBrojClanova(),
            t.getTrening(), t.getSala(), t.getFitnesCentar());
            trazeniTermini.add(termin);
        }
        return new ResponseEntity<>(trazeniTermini, HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TerminDTO> createTermin(@RequestBody TerminDTO tDTO) throws Exception {
        Termin Termin = new Termin(tDTO.getCena(),  tDTO.getDatumPocetka(), tDTO.getDatumKraja(),tDTO.getBrojClanova(),
                tDTO.getTrening(), tDTO.getSala(), tDTO.getFitnesCentar());
        Termin noviTermin = this.terminService.create(Termin);
        TerminDTO TerminDTO = new TerminDTO(noviTermin.getId(), noviTermin.getCena(), noviTermin.getDatumPocetka(), noviTermin.getDatumKraja(),
                noviTermin.getBrojClanova(), noviTermin.getTrening(), noviTermin.getSala(), noviTermin.getFitnesCentar());
        return new ResponseEntity<>(TerminDTO, HttpStatus.CREATED);

    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TerminDTO> updateTermin(@PathVariable Long id,
                      @RequestBody TerminDTO TerminDTO) throws Exception {
        Termin Termin = new Termin(TerminDTO.getCena(),TerminDTO.getDatumPocetka(), TerminDTO.getDatumKraja(), TerminDTO.getBrojClanova(),
                TerminDTO.getTrening(), TerminDTO.getSala(), TerminDTO.getFitnesCentar());
        Termin.setId(id);
        Termin izmenjenTermin = terminService.update(Termin);
        TerminDTO azuriranTermin = new TerminDTO(izmenjenTermin.getId(), izmenjenTermin.getCena(), izmenjenTermin.getDatumPocetka(),
                izmenjenTermin.getDatumKraja(), izmenjenTermin.getBrojClanova(), izmenjenTermin.getTrening(), izmenjenTermin.getSala(),
                izmenjenTermin.getFitnesCentar());
        return new ResponseEntity<>(azuriranTermin, HttpStatus.OK);

    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteTermin(@PathVariable Long id) {
        this.terminService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "/naziv/{naziv}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FiltriraniTreninziDTO>> traziPoNazivu(@PathVariable(name = "naziv") String naziv) throws Exception {
        List<Termin> termini = terminService.findAll();
        List<FiltriraniTreninziDTO> ret = new ArrayList<>();
        for (Termin t : termini) {
            if (t.getTrening().getNaziv().contains(naziv)) {
                FiltriraniTreninziDTO filtrirani = new FiltriraniTreninziDTO();
                filtrirani.setIdt(t.getId());
                filtrirani.setNaziv(t.getTrening().getNaziv());
                filtrirani.setCena(t.getCena());
                filtrirani.setTrajanje(t.getTrening().getTrajanje());
                filtrirani.setDatumPocetka(t.getDatumPocetka());
                filtrirani.setDatumKraja(t.getDatumKraja());
                filtrirani.setImeTrenera(t.getTrening().getTrener().getIme());
                filtrirani.setTipTreninga(t.getTrening().getTipTreninga());
                filtrirani.setNazivFitnesCentra(t.getFitnesCentar().getNaziv());
                filtrirani.setNazivSale(t.getSala().getOznaka());
                float ocenaSrednja = 0;
                int delioc = 0;
                for (OcenaTreninga ocena : this.ocenaTreningaService.getByTreningId(t.getTrening().getId())) {
                    if (ocena.getOcena() > 0) {
                        ocenaSrednja += ocena.getOcena();
                        delioc++;
                    }
                }
                if (delioc == 0) {
                    ocenaSrednja = 0;
                } else {
                    ocenaSrednja /= delioc;
                }
                filtrirani.setProsecnaOcena(ocenaSrednja);
                filtrirani.setPreostalaMesta(t.getSala().getKapacitet() - t.getBrojClanova());
                filtrirani.setOdgovara(true);


                ret.add(filtrirani);
            }
        }
        return new ResponseEntity<>(ret, HttpStatus.OK);
    }
    @PostMapping(
			value = ("/pretraga"),
		    consumes = MediaType.APPLICATION_JSON_VALUE,
    		produces = MediaType.APPLICATION_JSON_VALUE
			)
	public ResponseEntity<List<FiltriraniTreninziDTO>> traziTermine(@RequestBody ParametriPretrageDTO info) throws Exception{
        List<FiltriraniTreninziDTO> ret = new ArrayList<>();
        for(Termin t: this.terminService.findAll()) {
            FiltriraniTreninziDTO filtrirani = new FiltriraniTreninziDTO();
           filtrirani.setIdt(t.getId());
           filtrirani.setNaziv(t.getTrening().getNaziv());
           filtrirani.setCena(t.getCena());
           filtrirani.setTrajanje(t.getTrening().getTrajanje());
           filtrirani.setDatumPocetka(t.getDatumPocetka());
           filtrirani.setDatumKraja(t.getDatumKraja());
           filtrirani.setImeTrenera(t.getTrening().getTrener().getIme());
           filtrirani.setTipTreninga(t.getTrening().getTipTreninga());
           filtrirani.setNazivFitnesCentra(t.getFitnesCentar().getNaziv());
           filtrirani.setNazivSale(t.getSala().getOznaka());
           float ocenaSrednja = 0;
           int delioc = 0;
           for(OcenaTreninga ocena : this.ocenaTreningaService.getByTreningId(t.getTrening().getId())) {
               if(ocena.getOcena() >0) {
                   ocenaSrednja += ocena.getOcena();
                   delioc++;
               }
           }
           if(delioc ==0 ){
               ocenaSrednja =0;
           }
           else{
               ocenaSrednja /= delioc;
           }
            filtrirani.setProsecnaOcena(ocenaSrednja);
            filtrirani.setPreostalaMesta(t.getSala().getKapacitet() - t.getBrojClanova());
            filtrirani.setOdgovara(true);


          ret.add(filtrirani);
        }
        for(FiltriraniTreninziDTO trening : ret) {
            System.out.println(trening + "\n");
        }

		if(info.getNaziv() != null)
			for(FiltriraniTreninziDTO pp : ret)
				if(!pp.getNaziv().contains(info.getNaziv()))
					pp.setOdgovara(false);
        if(info.getCena() != 0)
		for(FiltriraniTreninziDTO pp : ret)
			if(pp.getCena() > info.getCena())
				pp.setOdgovara(false);
        if(info.getTrajanje() != 0)
        for(FiltriraniTreninziDTO pp : ret)
            if(pp.getTrajanje() > info.getTrajanje())
                pp.setOdgovara(false);
		if(info.getDatumPocetka() != null)
			for(FiltriraniTreninziDTO pp : ret)
				if(info.getDatumPocetka().after(pp.getDatumPocetka()))
					pp.setOdgovara(false);

		List<FiltriraniTreninziDTO> zasortiranje = new ArrayList<>();
		for(FiltriraniTreninziDTO pp : ret)
			if(pp.isOdgovara())
				zasortiranje.add(pp);
        for(FiltriraniTreninziDTO trening : zasortiranje) {
            System.out.println(trening + "\n");
        }
/*
		switch (info.getTipSortiranja()) {
		case 1:
			for(int i = 0; i < zasortiranje.size(); i++) {
				for(int j = i; j < zasortiranje.size(); j++) {
					if(zasortiranje.get(i).getNaziv().compareTo(zasortiranje.get(j).getNaziv()) > 0) {
                        FiltriraniTreninziDTO pom = new FiltriraniTreninziDTO();
						pom.zameni(zasortiranje.get(i));
						zasortiranje.get(i).zameni(zasortiranje.get(j));
						zasortiranje.get(j).zameni(pom);
					}

				}
			}
			break;

		case 2:
            for(int i = 0; i < zasortiranje.size(); i++) {
                for(int j = i; j < zasortiranje.size(); j++) {
                    if(zasortiranje.get(i).getTrajanje() > zasortiranje.get(j).getTrajanje()){
                        FiltriraniTreninziDTO pom = new FiltriraniTreninziDTO();
                        pom.zameni(zasortiranje.get(i));
                        zasortiranje.get(i).zameni(zasortiranje.get(j));
                        zasortiranje.get(j).zameni(pom);
                    }
                }
            }
            break;

		case 3:


            for(int i = 0; i < zasortiranje.size(); i++) {
                for(int j = i; j < zasortiranje.size(); j++) {
                    if(zasortiranje.get(i).getCena() > zasortiranje.get(j).getCena()) {
                        FiltriraniTreninziDTO pom = new FiltriraniTreninziDTO();
                        pom.zameni(zasortiranje.get(i));
                        zasortiranje.get(i).zameni(zasortiranje.get(j));
                        zasortiranje.get(j).zameni(pom);
                    }
                }
            }
            break;
		case 4:

            for(int i = 0; i < zasortiranje.size(); i++) {
                for(int j = i; j < zasortiranje.size(); j++) {
                    if(zasortiranje.get(i).getDatumPocetka().after(zasortiranje.get(j).getDatumPocetka())) {
                        FiltriraniTreninziDTO pom = new FiltriraniTreninziDTO();
                        pom.zameni(zasortiranje.get(i));
                        zasortiranje.get(i).zameni(zasortiranje.get(j));
                        zasortiranje.get(j).zameni(pom);
                    }
                }
            }
            break;

		case 5:

            for(int i = 0; i < zasortiranje.size(); i++) {
                for(int j = i; j < zasortiranje.size(); j++) {
                    if(zasortiranje.get(i).getProsecnaOcena() > zasortiranje.get(j).getProsecnaOcena()) {
                        FiltriraniTreninziDTO pom = new FiltriraniTreninziDTO();
                        pom.zameni(zasortiranje.get(i));
                        zasortiranje.get(i).zameni(zasortiranje.get(j));
                        zasortiranje.get(j).zameni(pom);
                    }
                }
            }
            break;
		}*/


		return new ResponseEntity<>(zasortiranje, HttpStatus.OK);
	 }




}