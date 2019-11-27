package com.epsi.guez.debugme.service;

import com.epsi.guez.debugme.exception.DebugMeException;
import com.epsi.guez.debugme.model.Candidat;

import java.util.List;

public interface CandidatService {
    List<Candidat> findCandidatsMatching(int idLangage, int idDepartement) throws DebugMeException;
}
