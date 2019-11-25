package com.epsi.guez.debugme.controller;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import com.epsi.guez.debugme.config.ApplicationUrl;
import com.epsi.guez.debugme.config.PageMapping;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class ErreurController implements ErrorController {

    private ErrorAttributes errorAttributes;

    @Autowired
    public ErreurController(ErrorAttributes errorAttributes) {
        this.errorAttributes = errorAttributes;
    }

    @Override
    public String getErrorPath() {
        return ApplicationUrl.ERREUR;
    }

    /**
     * Renvoie la page d'erreur lorsqu'une erreur est lancée par Spring
     *
     * @param request : la requête qui a déclenché l'erreur
     * @return la vue et le modèle de la page d'erreur pour afficher l'erreur à l'utilisateur
     */
    @RequestMapping(value = ApplicationUrl.ERREUR, produces = "text/html")
    public ModelAndView errorHtml(HttpServletRequest request) {
        Map<String, Object> attributsErreur = getErrorAttributes(request);
        log.error("Erreur d'accès à la page située à : " + attributsErreur.get("path") + ", avec l'erreur suivante : " + attributsErreur.get("status") + " " + attributsErreur
                .get("error") + " " + attributsErreur.get("message"));
        return new ModelAndView(PageMapping.ERREUR, attributsErreur, getStatus(request));
    }

    /**
     * Récupère le détail d'une {@link HttpServletRequest} sous forme de {@link Map}
     *
     * @param request : la requête qui a déclenché l'erreur
     * @return une {@link Map} contenant les attributs de la requête en erreur et leurs contenus
     */
    private Map<String, Object> getErrorAttributes(HttpServletRequest request) {
        WebRequest requestAttributes = new ServletWebRequest(request);
        return this.errorAttributes.getErrorAttributes(requestAttributes, false);
    }

    /**
     * Trouve le {@link HttpStatus} d'une {@link HttpServletRequest} à partir du code du statut contenu dans la requête
     *
     * @param request : la requête qui a déclenché l'erreur
     * @return le {@link HttpStatus} de la requête
     */
    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        HttpStatus status;

        try {
            status = HttpStatus.valueOf(statusCode);
        } catch (IllegalArgumentException iae) {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
            log.error("Aucun statut HTTP correspondant au code demandé", iae);
        }

        return status;
    }
}
