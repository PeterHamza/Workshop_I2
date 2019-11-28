package com.epsi.guez.debugme.service;

import com.epsi.guez.debugme.model.Departement;
import com.epsi.guez.debugme.model.dao.DepartementDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartementServiceImpl implements DepartementService {

    DepartementDao departementDao;

    @Autowired
    public DepartementServiceImpl(DepartementDao departementDao) {
        this.departementDao = departementDao;
    }

    @Override
    public List<Departement> findAll() {
        return departementDao.findAll();
    }
}
