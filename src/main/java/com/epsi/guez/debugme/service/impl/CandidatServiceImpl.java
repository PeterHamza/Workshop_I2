package com.epsi.guez.debugme.service.impl;

import com.epsi.guez.debugme.exception.DebugMeException;
import com.epsi.guez.debugme.model.Candidat;
import com.epsi.guez.debugme.service.CandidatService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidatServiceImpl implements CandidatService {

    @Override
    public List<Candidat> findCandidatsMatching(int idLangage, int idDepartement) throws DebugMeException {
        return null;
    }
}
