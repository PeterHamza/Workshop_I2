package com.epsi.guez.debugme.model.dao;

import com.epsi.guez.debugme.model.Departement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartementDao extends JpaRepository<Departement, Integer> {

}
