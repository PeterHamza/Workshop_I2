package com.epsi.guez.debugme.controller;

import com.epsi.guez.debugme.config.ApplicationUrl;
import com.epsi.guez.debugme.config.PageMapping;
import com.epsi.guez.debugme.exception.DebugMeException;
import com.epsi.guez.debugme.model.Candidat;
import com.epsi.guez.debugme.model.ChoixCriteresForm;
import com.epsi.guez.debugme.model.Departement;
import com.epsi.guez.debugme.model.Langage;
import com.epsi.guez.debugme.service.CandidatService;
import com.epsi.guez.debugme.service.DepartementService;
import com.epsi.guez.debugme.service.LangageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class RecruiterController {

    private static final String REDIRECT = "redirect:";

    private CandidatService candidatService;
    private LangageService langageService;
    private DepartementService departementService;

    @Autowired
    public RecruiterController(CandidatService candidatService, LangageService langageService, DepartementService departementService) {
        this.candidatService = candidatService;
        this.langageService = langageService;
        this.departementService = departementService;
    }

    @RequestMapping(value = ApplicationUrl.CHOIX_CRITERES)
    public String choixCriteres(ModelMap model) {
        List<Langage> langages = langageService.findAll();
        List<Departement> departements = departementService.findAll();
        ChoixCriteresForm form = new ChoixCriteresForm();
        model.put("form", form);
        model.put("langages", langages);
        model.put("departements", departements);
        return PageMapping.CHOIX_CRITERES;
    }

    @RequestMapping(value = ApplicationUrl.CHOIX_CRITERES, method = RequestMethod.POST)
    public String choixCriteresPost(@ModelAttribute("dossierDto") ChoixCriteresForm form, RedirectAttributes red) {
        String url = ApplicationUrl.CHOIX_CRITERES;
        try {
            List<Candidat> candidats = candidatService.findCandidatsMatching(form.getLangage(), form.getDepartement());
            if (candidats.isEmpty()) {
                red.addFlashAttribute("message", "Aucun utilisateur trouvé pour le moment !");
            } else {
                red.addFlashAttribute("candidats", candidats);
            }
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
