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
}