package com.epsi.guez.debugme.service.impl;

import com.epsi.guez.debugme.model.Langage;
import com.epsi.guez.debugme.model.dao.LangageDao;
import com.epsi.guez.debugme.service.LangageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LangageServiceImpl implements LangageService {

    private LangageDao langageDao;

    @Autowired
    public LangageServiceImpl(LangageDao langageDao) {
        this.langageDao = langageDao;
    }

    @Override
    public List<Langage> findAll() {
        return langageDao.findAll();
    }
}
