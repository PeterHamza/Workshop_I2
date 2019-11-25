package com.epsi.guez.debugme.model.dao;

import com.epsi.guez.debugme.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurDao extends JpaRepository<Utilisateur, Integer> {

    Utilisateur findByUsername(String username);
}
