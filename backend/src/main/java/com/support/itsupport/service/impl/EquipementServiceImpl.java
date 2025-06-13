package com.support.itsupport.service.impl;

import com.support.itsupport.entity.Equipement;
import com.support.itsupport.repository.EquipementRepository;
import com.support.itsupport.service.EquipementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EquipementServiceImpl implements EquipementService {
    @Autowired
    private EquipementRepository equipementRepository;

    @Override
    public Equipement ajouterEquipement(Equipement equipement) {
        return equipementRepository.save(equipement);
    }

    @Override
    public Equipement modifierEquipement(Long id, Equipement equipement) {
        Equipement existant = equipementRepository.findById(id).orElseThrow();
        existant.setNom(equipement.getNom());
        existant.setType(equipement.getType());
        existant.setEtat(equipement.getEtat());
        return equipementRepository.save(existant);
    }

    @Override
    public void supprimerEquipement(Long id) {
        equipementRepository.deleteById(id);
    }

    @Override
    public List<Equipement> getAllEquipements() {
        return equipementRepository.findAll();
    }
}
