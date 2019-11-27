package com.epsi.guez.debugme.service.impl;

import com.epsi.guez.debugme.exception.DebugMeException;
import com.epsi.guez.debugme.model.Utilisateur;
import com.epsi.guez.debugme.model.dao.UtilisateurDao;
import com.epsi.guez.debugme.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {

    private UtilisateurDao utilisateurDao;

    @Autowired
    public UtilisateurServiceImpl(UtilisateurDao utilisateurDao) {
        this.utilisateurDao = utilisateurDao;
    }

    /**
     * Récupère les informations d'un utilisateur à partir de son nom d'utilisateur
     *
     * @param username : le nom d'utilisateur
     * @return les informations de l'utilisateur correspondant au nom passé en paramètre, null si inexistant
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Utilisateur utilisateur = utilisateurDao.findByUsername(username);

        if (utilisateur == null) {
            throw new UsernameNotFoundException("Le couple Nom d'utilisateur/Mot de passe est incorrect");
        }
        return new User(utilisateur.getUsername(), utilisateur.getPassword(), utilisateur.getAuthorities());
    }

    @Override
    public Utilisateur findOne(String username) {
        return utilisateurDao.findByUsername(username);
    }

    @Override
    public List<Utilisateur> findUsersMatching(int idLangage, int idVille) throws DebugMeException {
        List<Utilisateur> utilisateursMatching = new ArrayList<>();



        return utilisateursMatching;
    }
}
