package com.epsi.guez.debugme.model.dao;

import com.epsi.guez.debugme.model.Candidat;
import com.epsi.guez.debugme.model.Departement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CandidatDao extends JpaRepository<Candidat, Integer> {

    List<Candidat> findAllByDepartement(Departement departement);

}
