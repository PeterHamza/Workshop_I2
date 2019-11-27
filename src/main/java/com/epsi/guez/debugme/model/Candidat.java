package com.epsi.guez.debugme.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Candidat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String lienLikedin;

    private int score;

    @ManyToOne
    @JoinColumn(name = "departement_id")
    private Departement departement;
}

