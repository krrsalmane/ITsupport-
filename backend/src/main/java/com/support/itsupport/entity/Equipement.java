package com.support.itsupport.entity;

import jakarta.persistence.*;

@Entity
public class Equipement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String type;
    private String etat; // exemple: "en service", "hors service", "en panne"

    // constructeur, getters et setters
}
