package com.epsi.guez.debugme.service.impl;

import com.epsi.guez.debugme.exception.DebugMeException;
import com.epsi.guez.debugme.model.Candidat;
import com.epsi.guez.debugme.model.Departement;
import com.epsi.guez.debugme.model.Langage;
import com.epsi.guez.debugme.model.dao.CandidatDao;
import com.epsi.guez.debugme.service.CandidatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class CandidatServiceImpl implements CandidatService {

    private CandidatDao candidatDao;

    @Autowired
    public CandidatServiceImpl(CandidatDao candidatDao) {
        this.candidatDao = candidatDao;
    }

    @Override
    public List<Candidat> findCandidatsMatching(Langage langage, Departement departement) throws DebugMeException {
        List<Candidat> candidats = candidatDao.findAllByDepartement(departement);
        Iterator it = candidats.iterator();
        List<Candidat> candidatsLangage = langage.getCandidats();
        while (it.hasNext()) {
            boolean remove = true;
            Candidat candidat = (Candidat) it.next();
            for(Candidat candidatLangage : candidatsLangage) {
                if(candidat.getId().equals(candidatLangage.getId())) {
                    remove = false;
                    break;
                }
            }
            if (!remove) {
                it.remove();
            }
        }
        return candidats;
    }
}
