package com.epsi.guez.debugme.model.dao;

import com.epsi.guez.debugme.model.Langage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LangageDao extends JpaRepository<Langage, Integer> {
}
