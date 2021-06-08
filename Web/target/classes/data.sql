INSERT INTO ADMINISTRATOR (korisnickoime, lozinka, ime, prezime,  telefon, email, datumrodjenja, aktivan, uloga) VALUES ('marijaza', 'ftn', 'Marija', 'Zaric', '0645552222', 'marijaza@gmail.com', '1998-12-01', 'true', 0);
INSERT INTO CLAN (korisnickoime, lozinka, ime, prezime,  telefon, email, datumrodjenja, aktivan, uloga) VALUES ('sanjami', 'ftn', 'Sanja', 'Mitrovic', '0645852222', 'sanjami@gmail.com', '1995-04-11', 'true', 2);
INSERT INTO CLAN (korisnickoime, lozinka, ime, prezime,  telefon, email, datumrodjenja, aktivan, uloga) VALUES ('markoer', 'ftn', 'Marko', 'Eric', '0665857482', 'markoer@gmail.com', '1992-01-08', 'true', 2);
INSERT INTO FITNES_CENTAR (naziv, adresa, email, broj_centrale) VALUES ('Sparta', 'Cara Dusana 5', 'sparta@gmail.com', '021741963');

INSERT INTO TRENER (korisnickoime, lozinka, ime, prezime,  telefon, email, datumrodjenja, aktivan, uloga, prosecna_ocena, fitnes_centar_id) VALUES ('zoranjo', 'ftn', 'Zoran', 'Jovanovic', '0665857482', 'zoranjo@gmail.com', '1997-03-02', 'true', 1, 4.00,1);
INSERT INTO SALA(kapacitet, oznaka, fitnes_centar_id) VALUES (25.00, 'Sala1', 1);
INSERT INTO TRENING(naziv, opis, tip_treninga, trajanje, trener_id) VALUES ('joga', 'Trening za opustanje misica.', 'relaks', 60, 1);
INSERT INTO TRENING(naziv, opis, tip_treninga, trajanje, trener_id) VALUES ('karate', 'Borilacka vestina.', 'borilacka vestina', 60, 1);


