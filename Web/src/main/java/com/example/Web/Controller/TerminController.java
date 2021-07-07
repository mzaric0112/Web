package com.example.Web.Controller;

import com.example.Web.Model.Clan;
import com.example.Web.Model.OcenaTreninga;
import com.example.Web.Model.Termin;
import com.example.Web.Model.dto.*;
import com.example.Web.Service.ClanService;
import com.example.Web.Service.OcenaTreningaService;
import com.example.Web.Service.TerminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Console;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value="/api/termini")
public class TerminController {
    private final TerminService terminService;
    private final OcenaTreningaService ocenaTreningaService;
    private final ClanService clanService;
    @Autowired
    public TerminController(TerminService terminService, OcenaTreningaService ocenaTreningaService, ClanService clanService) {
        this.terminService = terminService;
        this.ocenaTreningaService = ocenaTreningaService;
        this.clanService = clanService;
    }



    	@PostMapping(
			value = ("/rezervacija"),
		    consumes = MediaType.APPLICATION_JSON_VALUE,
    		produces = MediaType.APPLICATION_JSON_VALUE
			)
	public ResponseEntity<RezervacijaDTO> rezervisi (@RequestBody RezervacijaDTO info) throws Exception{

            Termin Termin = this.terminService.findOne(info.getIdTermina());
            if((Termin.getSala().getKapacitet() - Termin.getPrijavljeniClanovi().size()) < 1) {

                throw new Exception("Nema slobodnih mesta za trazeni termin!");
            }
            else{
                Clan clan = clanService.findOne(info.getIdKorisnika());
                Termin.getPrijavljeniClanovi().add(clan);
                Termin.setBrojClanova(Termin.getBrojClanova()+1);
                terminService.update(Termin);
                clan.getPrijavljeniTreninzi().add(Termin);
                clanService.update(clan);

            }


            //this.terminskaListaProjekcijaService.dodajRezervaciju(info.getNumber(), this.korisnikService.getByUsername(info.getString()));

		return new ResponseEntity<>(info, HttpStatus.OK);
	}

    @PostMapping(
            value = ("/otkazivanjeTermina"),
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<RezervacijaDTO> otkazi (@RequestBody RezervacijaDTO info) throws Exception{

        Termin Termin = this.terminService.findOne(info.getIdTermina());

            Clan clan = clanService.findOne(info.getIdKorisnika());
            Termin.getPrijavljeniClanovi().remove(clan);
            Termin.setBrojClanova(Termin.getBrojClanova()-1);
            terminService.update(Termin);
            clan.getPrijavljeniTreninzi().remove(Termin);
            clanService.update(clan);




        //this.terminskaListaProjekcijaService.dodajRezervaciju(info.getNumber(), this.korisnikService.getByUsername(info.getString()));

        return new ResponseEntity<>(info, HttpStatus.OK);
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

  @PostMapping(value = ("/odradjeniTreninzi"),
          consumes = MediaType.APPLICATION_JSON_VALUE,
          produces = MediaType.APPLICATION_JSON_VALUE
  )
  public ResponseEntity<List<OdradjeniTreninziDTO>> odradjeniTreninzi(@RequestBody KorisnikTreninziDTO info) {
        Clan clan = clanService.findOne(info.getIdKorisnika());
        List<OdradjeniTreninziDTO> ret = new ArrayList<>();
     for(Termin t: clan.getOdradjeniTreninzi()) {
        OdradjeniTreninziDTO odr = new OdradjeniTreninziDTO();
        odr.setIdt(t.getId());
        odr.setNaziv(t.getTrening().getNaziv());
        odr.setCena(t.getCena());
        odr.setTrajanje(t.getTrening().getTrajanje());
        odr.setDatumPocetka(t.getDatumPocetka());
        odr.setTipTreninga(t.getTrening().getTipTreninga());
        odr.setImeTrenera(t.getTrening().getTrener().getIme());
        float suma = 0;
        for(OcenaTreninga o : t.getOcena()) {
            suma += o.getOcena();
        }
        odr.setProsecnaOcena(suma / t.getOcena().size());
        odr.setNazivFitnesCentra(t.getFitnesCentar().getNaziv());
        odr.setNazivSale(t.getSala().getOznaka());
        odr.setOdgovara(true);
        ret.add(odr);
     }
      return new ResponseEntity<>(ret, HttpStatus.OK);


  }

    @PostMapping(value = ("/rezervisaniTreninzi"), consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FiltriraniTreninziDTO>> createUser(@RequestBody KorisnikTreninziDTO kDTO) throws Exception {
        Clan korisnik =  clanService.findOne(kDTO.getIdKorisnika());
        List<FiltriraniTreninziDTO> ret = new ArrayList<>();
        for(Termin t : korisnik.getPrijavljeniTreninzi()) {
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

            filtrirani.getProsecnaOcena();
            filtrirani.getPreostalaMesta();
            ret.add(filtrirani);
        }
        return new ResponseEntity<>(ret, HttpStatus.CREATED);

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


        }
        List<FiltriraniTreninziDTO> zasortiranje = new ArrayList<>();
        for(FiltriraniTreninziDTO pp : ret)
            if(pp.isOdgovara())
                zasortiranje.add(pp);
        for(FiltriraniTreninziDTO trening : zasortiranje) {
            System.out.println(trening + "\n");
        }

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
		}


		return new ResponseEntity<>(zasortiranje, HttpStatus.OK);
	 }




}