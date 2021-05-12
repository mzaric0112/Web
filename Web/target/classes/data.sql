INSERT INTO ADMINISTRATOR (korisnickoime, lozinka, ime, prezime,  telefon, email, datumrodjenja, aktivan, uloga) VALUES ('marijaza', 'ftn', 'Marija', 'Zaric', '0645552222', 'marijaza@gmail.com', '1998-12-01', 'true', 0);
INSERT INTO CLAN (korisnickoime, lozinka, ime, prezime,  telefon, email, datumrodjenja, aktivan, uloga) VALUES ('jovanaza', 'ftn1', 'Jovana', 'Zaric', '0645569622', 'jovanaza@gmail.com', '2002-02-01', 'true', 2);
INSERT INTO CLAN (korisnickoime, lozinka, ime, prezime,  telefon, email, datumrodjenja, aktivan, uloga) VALUES ('andjelaza', 'ftn2', 'Andjela', 'Zaric', '0645552522', 'andjelaza@gmail.com', '1997-03-05', 'true', 2);
INSERT INTO FITNES_CENTAR (naziv, adresa, email, broj_centrale) VALUES ('Sparta', 'Cara Dusana 5', 'sparta@gmail.com', '021741963');
INSERT INTO TRENER (korisnickoime, lozinka, ime, prezime,  telefon, email, datumrodjenja, aktivan, uloga, PROSECNA_OCENA , FITNES_CENTAR_ID ) VALUES ('ivaniv', 'kakoje', 'Ivan', 'Ivanovic', '0631569622', 'ivaniv@gmail.com', '1996-07-03', 'true', 1, 0, 1);
INSERT INTO TRENER (korisnickoime, lozinka, ime, prezime,  telefon, email, datumrodjenja, aktivan, uloga, PROSECNA_OCENA , FITNES_CENTAR_ID ) VALUES ('tamarajo', 'kakoje1', 'Tamara', 'Jovanovic', '0631569452', 'tamarajo@gmail.com', '1992-05-09', 'true', 1, 0, 1);
INSERT INTO TRENING (NAZIV, OPIS, TIP_TRENINGA, TRAJANJE, TRENER_ID) VALUES ('Pilates', 'Trenig za istezanje misica i relaksaciju', 'relaksacija', 45, 2);
INSERT INTO TRENING (NAZIV, OPIS, TIP_TRENINGA, TRAJANJE, TRENER_ID) VALUES ('Joga', 'Trenig za istezanje misica i relaksaciju', 'relaksacija', 45, 2);
INSERT INTO TRENING (NAZIV, OPIS, TIP_TRENINGA, TRAJANJE, TRENER_ID) VALUES ('Dzudo', 'Borilacka vestina', 'borilacka vestina', 90, 1);
INSERT INTO TRENING (NAZIV, OPIS, TIP_TRENINGA, TRAJANJE, TRENER_ID) VALUES ('Karate', 'Borilacka vestina', 'borilacka vestina', 45, 1);
INSERT INTO SALA (KAPACITET, OZNAKA, FITNES_CENTAR_ID) VALUES (30, 'SALA1', 1);
INSERT INTO SALA (KAPACITET, OZNAKA, FITNES_CENTAR_ID) VALUES (22, 'SALA2', 1);
INSERT INTO SALA (KAPACITET, OZNAKA, FITNES_CENTAR_ID) VALUES (15, 'SALA3', 1);
INSERT INTO ODRZAVANJE_TRENINGA(CENA, DATUM_POCETKA, DATUM_KRAJA, FITNES_CENTAR_ID) values (300, '2021-05-12 12:15:00', '2021-05-12 13:00:00', 1);
INSERT INTO ODRZAVANJE_TRENINGA(CENA, DATUM_POCETKA, DATUM_KRAJA, FITNES_CENTAR_ID) values (300, '2021-05-12 13:15:00', '2021-05-12 14:00:00', 1);
INSERT INTO TRENINZI(ODRZAVANJE_TRENINGA_ID, TRENING_ID) values (1, 1);
INSERT INTO TRENINZI(ODRZAVANJE_TRENINGA_ID, TRENING_ID) values (2, 2);
insert  into TERMINSKA_LISTA_TRENINGA(PRIJAVLJENI_CLANOVI) values (14);
insert  into TERMINSKA_LISTA_TRENINGA(PRIJAVLJENI_CLANOVI) values (12);
insert  into TERMINSKA_LISTA_TRENINGA(PRIJAVLJENI_CLANOVI) values (9);
INSERT INTO TERMINI_TRENINGA(ODRZAVANJE_TRENINGA_ID, TERINSKA_LISTA_ID ) VALUES (1, 1);
INSERT INTO TERMINI(SALA_ID, TERMIN_ID) values (1, 1);



