package com.support.itsupport.service;

import com.support.itsupport.entity.Equipement;

import java.util.List;

public interface EquipementService {
    Equipement ajouterEquipement(Equipement equipement);
    Equipement modifierEquipement(Long id, Equipement equipement);
    void supprimerEquipement(Long id);
    List<Equipement> getAllEquipements();
}
