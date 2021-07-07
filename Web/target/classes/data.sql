INSERT INTO ADMINISTRATOR (korisnickoime, lozinka, ime, prezime,  telefon, email, datumrodjenja, aktivan, uloga, registrovan) VALUES ('marijaza', 'ftn', 'Marija', 'Zaric', '0645552222', 'marijaza@gmail.com', '1998-12-01', 'true', 0, 'true');
INSERT INTO CLAN (korisnickoime, lozinka, ime, prezime,  telefon, email, datumrodjenja, aktivan, uloga, registrovan) VALUES ('sanjami', 'ftn', 'Sanja', 'Mitrovic', '0645852222', 'sanjami@gmail.com', '1995-04-11', 'true', 2, 'true');
INSERT INTO CLAN (korisnickoime, lozinka, ime, prezime,  telefon, email, datumrodjenja, aktivan, uloga, registrovan) VALUES ('markoer', 'ftn', 'Marko', 'Eric', '0665857482', 'markoer@gmail.com', '1992-01-08', 'true', 2, 'true');
INSERT INTO FITNES_CENTAR (naziv, adresa, email, broj_centrale) VALUES ('Sparta', 'Cara Dusana 5', 'sparta@gmail.com', '021741963');

INSERT INTO TRENER (korisnickoime, lozinka, ime, prezime,  telefon, email, datumrodjenja, aktivan, uloga, prosecna_ocena, fitnes_centar_id, registrovan) VALUES ('zoranjo', 'ftn', 'Zoran', 'Jovanovic', '0665857482', 'zoranjo@gmail.com', '1997-03-02', 'true', 1, 0.00,1, 'true');
INSERT INTO SALA(kapacitet, oznaka, fitnes_centar_id) VALUES (25, 'Sala1', 1);
INSERT INTO TRENING(naziv, opis, tip_treninga, trajanje, trener_id) VALUES ('joga', 'Trening za opustanje misica.', 'relaks', 60, 1);
INSERT INTO TRENING(naziv, opis, tip_treninga, trajanje, trener_id) VALUES ('karate', 'Borilacka vestina.', 'borilacka vestina', 60, 1);
INSERT INTO TRENER (korisnickoime, lozinka, ime, prezime,  telefon, email, datumrodjenja, aktivan, uloga, prosecna_ocena, fitnes_centar_id, registrovan) VALUES ('vanjail', 'ftn', 'Vanja', 'Ilic', '0619557482', 'vanjail@gmail.com', '1996-10-22', 'true', 1, 0.00,1, 'true');
INSERT INTO TRENER (korisnickoime, lozinka, ime, prezime,  telefon, email, datumrodjenja, aktivan, uloga, prosecna_ocena, fitnes_centar_id, registrovan) VALUES ('markoni', 'ftn', 'Marko', 'Nikolic', '0665857695', 'markoni@gmail.com', '1989-11-04', 'true', 1, 0.00,1, 'true');
INSERT INTO CLAN (korisnickoime, lozinka, ime, prezime,  telefon, email, datumrodjenja, aktivan, uloga, registrovan) VALUES ('tanjami', 'ftn', 'Tanja', 'Milic', '0624457482', 'tanjami@gmail.com', '1996-06-18', 'true', 2, 'true');
INSERT INTO CLAN (korisnickoime, lozinka, ime, prezime,  telefon, email, datumrodjenja, aktivan, uloga, registrovan) VALUES ('oljabo', 'ftn', 'Olja', 'Bojcic', '0624413122', 'oljabo@gmail.com', '1992-05-28', 'true', 2, 'true');
INSERT INTO CLAN (korisnickoime, lozinka, ime, prezime,  telefon, email, datumrodjenja, aktivan, uloga, registrovan) VALUES ('ivanaste', 'ftn', 'Ivana', 'Stevanovic', '0619363122', 'ivanaste@gmail.com', '1995-01-01', 'true', 2, 'true');
INSERT INTO CLAN (korisnickoime, lozinka, ime, prezime,  telefon, email, datumrodjenja, aktivan, uloga, registrovan) VALUES ('lazarpo', 'ftn', 'Lazar', 'Popovic', '0619363332', 'lazarpo@gmail.com', '1997-03-01', 'true', 2, 'true');
INSERT INTO TRENING(naziv, opis, tip_treninga, trajanje, trener_id) VALUES ('dzudo', 'Borilacka vestina.', 'borilacka vestina', 90, 2);
INSERT INTO TRENING(naziv, opis, tip_treninga, trajanje, trener_id) VALUES ('gimnastika', 'Trening za povecavanje mobilnosti misica.', 'istezanje misica', 60, 3);
INSERT INTO TRENING(naziv, opis, tip_treninga, trajanje, trener_id) VALUES ('aerobik', 'Trening za povecavanje mobilnosti misica.', 'istezanje misica', 60, 3);
INSERT INTO TRENING(naziv, opis, tip_treninga, trajanje, trener_id) VALUES ('akrobatika', 'Trening za zabavu.', 'zabava', 60, 2);
INSERT INTO TRENING(naziv, opis, tip_treninga, trajanje, trener_id) VALUES ('ples', 'Razne vrste plesa', 'ples', 60, 2);
INSERT INTO TRENING(naziv, opis, tip_treninga, trajanje, trener_id) VALUES ('ritmicka gimnastika', 'Trening za decu.', 'zabava', 60, 1);
INSERT INTO SALA(kapacitet, oznaka, fitnes_centar_id) VALUES (15, 'Sala2', 1);
INSERT INTO SALA(kapacitet, oznaka, fitnes_centar_id) VALUES (40, 'Sala3', 1);
INSERT INTO SALA(kapacitet, oznaka, fitnes_centar_id) VALUES (40, 'Sala4', 1);
INSERT INTO TERMIN(broj_clanova, cena, datum_kraja, datum_pocetka, fitnes_centar_id, sala_id, trening_id) VALUES (0, 200, '2021-06-12 12:15:00', '2021-06-12 11:15:00', 1, 1, 1);
INSERT INTO TERMIN(broj_clanova, cena, datum_kraja, datum_pocetka, fitnes_centar_id, sala_id, trening_id) VALUES (0, 200, '2021-06-12 19:15:00', '2021-06-12 18:15:00', 1, 1, 2);
INSERT INTO TERMIN(broj_clanova, cena, datum_kraja, datum_pocetka, fitnes_centar_id, sala_id, trening_id) VALUES (0, 200, '2021-06-12 12:15:00', '2021-06-12 11:15:00', 1, 2, 4);
INSERT INTO TERMIN(broj_clanova, cena, datum_kraja, datum_pocetka, fitnes_centar_id, sala_id, trening_id) VALUES (0, 200, '2021-06-12 12:45:00', '2021-06-12 11:15:00', 1, 4, 3);
INSERT INTO TERMIN(broj_clanova, cena, datum_kraja, datum_pocetka, fitnes_centar_id, sala_id, trening_id) VALUES (0, 200, '2021-06-13 12:15:00', '2021-06-13 11:15:00', 1, 1, 7);
INSERT INTO TERMIN(broj_clanova, cena, datum_kraja, datum_pocetka, fitnes_centar_id, sala_id, trening_id) VALUES (0, 200, '2021-06-12 14:15:00', '2021-06-12 13:15:00', 1, 3, 8);
INSERT INTO CLAN (korisnickoime, lozinka, ime, prezime,  telefon, email, datumrodjenja, aktivan, uloga, registrovan) VALUES ('nemanjama', 'ftn', 'Nemanja', 'Markovic', '0614863332', 'nemanjama@gmail.com', '1997-03-01', 'true', 2, 'false');
INSERT INTO CLAN (korisnickoime, lozinka, ime, prezime,  telefon, email, datumrodjenja, aktivan, uloga, registrovan) VALUES ('anasa', 'ftn', 'Ana', 'Saran', '0619315232', 'anasa@gmail.com', '1997-03-01', 'true', 2, 'false');
INSERT INTO TRENER (korisnickoime, lozinka, ime, prezime,  telefon, email, datumrodjenja, aktivan, uloga, prosecna_ocena, fitnes_centar_id, registrovan) VALUES ('novakdjo', 'ftn', 'Novak', 'Djokovic', '0664857695', 'novakdjo@gmail.com', '1989-11-04', 'true', 1, 0.00,1, 'false');

INSERT INTO TERMIN(broj_clanova, cena, datum_kraja, datum_pocetka, fitnes_centar_id, sala_id, trening_id) VALUES (0, 200, '2021-07-12 12:15:00', '2021-06-12 11:15:00', 1, 1, 1);
INSERT INTO TERMIN(broj_clanova, cena, datum_kraja, datum_pocetka, fitnes_centar_id, sala_id, trening_id) VALUES (0, 200, '2021-07-12 19:15:00', '2021-06-12 18:15:00', 1, 1, 2);
INSERT INTO TERMIN(broj_clanova, cena, datum_kraja, datum_pocetka, fitnes_centar_id, sala_id, trening_id) VALUES (0, 200, '2021-07-12 12:15:00', '2021-06-12 11:15:00', 1, 2, 4);
INSERT INTO TERMIN(broj_clanova, cena, datum_kraja, datum_pocetka, fitnes_centar_id, sala_id, trening_id) VALUES (0, 200, '2021-07-12 12:45:00', '2021-06-12 11:15:00', 1, 4, 3);
INSERT INTO TERMIN(broj_clanova, cena, datum_kraja, datum_pocetka, fitnes_centar_id, sala_id, trening_id) VALUES (0, 200, '2021-07-13 12:15:00', '2021-06-13 11:15:00', 1, 1, 7);
INSERT INTO TERMIN(broj_clanova, cena, datum_kraja, datum_pocetka, fitnes_centar_id, sala_id, trening_id) VALUES (0, 200, '2021-07-12 14:15:00', '2021-06-12 13:15:00', 1, 3, 8);
INSERT INTO ODRADJENI_TRENINZI(CLAN_ID, TRENING_ID) VALUES (1, 1);
INSERT INTO OCENA_TRENINGA(OCENA, CLAN_ID, TERMIN_ID) VALUES (4, 1, 1);
INSERT INTO FITNES_CENTAR (naziv, adresa, email, broj_centrale) VALUES ('Atina', 'Beogradska 15', 'atina@gmail.com', '021711163');
INSERT INTO FITNES_CENTAR (naziv, adresa, email, broj_centrale) VALUES ('Troya', 'Dunavska 12', 'troya@gmail.com', '021778663');









