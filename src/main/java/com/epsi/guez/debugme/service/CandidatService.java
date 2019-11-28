package com.epsi.guez.debugme.service;

import com.epsi.guez.debugme.exception.DebugMeException;
import com.epsi.guez.debugme.model.Candidat;
import com.epsi.guez.debugme.model.Departement;
import com.epsi.guez.debugme.model.Langage;

import java.util.List;

public interface CandidatService {
    List<Candidat> findCandidatsMatching(Langage langage, Departement departement) throws DebugMeException;
}
