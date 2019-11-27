package com.epsi.guez.debugme.controller;

import com.epsi.guez.debugme.config.ApplicationUrl;
import com.epsi.guez.debugme.config.PageMapping;
import com.epsi.guez.debugme.exception.DebugMeException;
import com.epsi.guez.debugme.service.QuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CandidatController {

    private static final String REDIRECT = "redirect:";

    private QuestionnaireService questionnaireService;

    @Autowired
    public CandidatController(QuestionnaireService questionnaireService) {
        this.questionnaireService = questionnaireService;
    }

    @RequestMapping(value = ApplicationUrl.REGLES)
    public String regles() {
        return PageMapping.REGLES;
    }

    @RequestMapping(value = ApplicationUrl.QUESTIONNAIRE)
    public String questionnaire() {
        return PageMapping.QUESTIONNAIRE;
    }

    @RequestMapping(value = ApplicationUrl.MERCI)
    public String merci() {
        return PageMapping.MERCI;
    }

    @RequestMapping(value = ApplicationUrl.QUESTIONNAIRE, method = RequestMethod.POST)
    public String choixCriteres() {
        String url = ApplicationUrl.CHOIX_CRITERES;
        try {
            questionnaireService.envoyerReponses();
            url = ApplicationUrl.MERCI;
        } catch (DebugMeException e) {
            e.printStackTrace();
        }
        return REDIRECT + url;
    }
}
