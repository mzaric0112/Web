package com.example.Web.Repository;

import com.example.Web.Model.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministratorRepository extends JpaRepository<Administrator, Long> {
    Administrator findByKorisnickoImeAndLozinka(String korisnickoIme, String lozinka);
}
