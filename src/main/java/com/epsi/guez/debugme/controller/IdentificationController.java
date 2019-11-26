package com.epsi.guez.debugme.controller;

import com.epsi.guez.debugme.config.ApplicationUrl;
import com.epsi.guez.debugme.config.PageMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IdentificationController {

    /**
     * Affiche la page de connexion personnalisée demandée par Spring Security (voir {@link} WebSecurityConfiguration)
     *
     * @return l'URL de la page de connexion personnalisée
     */
    @RequestMapping(value = ApplicationUrl.CONNEXION, method = RequestMethod.GET)
    public String connexion() {
        return PageMapping.CONNEXION;
    }

    /**
     * Redirige vers le menu, il s'agit de la page de redirection par défaut lors d'une authentification avec succès (voir {@link} WebSecurityConfiguration)
     *
     * @return l'URL du menu
     */
    @RequestMapping(value = ApplicationUrl.MENU, method = RequestMethod.GET)
    public String menu() {
        return PageMapping.MENU;
    }
}