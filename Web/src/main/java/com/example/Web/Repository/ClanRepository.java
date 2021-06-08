package com.example.Web.Repository;

import com.example.Web.Model.Clan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClanRepository extends JpaRepository<Clan, Long> {

}
