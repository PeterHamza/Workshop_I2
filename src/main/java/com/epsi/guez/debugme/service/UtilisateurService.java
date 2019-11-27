package com.epsi.guez.debugme.service;

import com.epsi.guez.debugme.exception.DebugMeException;
import com.epsi.guez.debugme.model.Utilisateur;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UtilisateurService extends UserDetailsService {

    /**
     * Récupère un utilisateur à partir de son nom d'utilisateur
     *
     * @param username : le nom d'utilisateur
     * @return l'utilisateur correspondant au nom passé en paramètre, null si inexistant
     */
    Utilisateur findOne(String username);

    List<Utilisateur> findUsersMatching(int idLangage, int idVille) throws DebugMeException;
}
