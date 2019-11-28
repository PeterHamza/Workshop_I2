package com.epsi.guez.debugme.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Candidat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "departement_id")
    private Departement departement;

    @Column(name = "lien_linkedin")
    private String lienLinkedin;

    private int score;

    @ManyToMany
    @JoinTable(
            name = "candidat_langage",
            joinColumns = @JoinColumn(name = "candidat_id"),
            inverseJoinColumns = @JoinColumn(name = "langage_id"))
    List<Langage> langages = new ArrayList<>();
}

