package com.epsi.guez.debugme.controller;

import com.epsi.guez.debugme.config.ApplicationUrl;
import com.epsi.guez.debugme.config.PageMapping;
import com.epsi.guez.debugme.exception.DebugMeException;
import com.epsi.guez.debugme.model.Utilisateur;
import com.epsi.guez.debugme.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class RecruiterController {

    private static final String REDIRECT = "redirect:";

    private UtilisateurService utilisateurService;

    @Autowired
    public RecruiterController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @RequestMapping(value = ApplicationUrl.CHOIX_CRITERES)
    public String choixCriteres() {
        return PageMapping.CHOIX_CRITERES;
    }

    @RequestMapping(value = ApplicationUrl.CHOIX_CRITERES, method = RequestMethod.POST)
    public String choixCriteresPost(int idLangage, int idVille, RedirectAttributes red) {
        String url = ApplicationUrl.CHOIX_CRITERES;
        try {
            List<Utilisateur> users = utilisateurService.findUsersMatching(idLangage, idVille);
            red.addFlashAttribute("users", users);
            url = ApplicationUrl.AFFICHAGE_RESULTATS;
        } catch (DebugMeException e) {
            e.printStackTrace();
        }
        return REDIRECT + url;
    }

    @RequestMapping(value = ApplicationUrl.AFFICHAGE_RESULTATS)
    public String affichageResultats() {
        return PageMapping.AFFICHAGE_RESULTATS;
    }

}
