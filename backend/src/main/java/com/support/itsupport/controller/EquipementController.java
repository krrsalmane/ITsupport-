package com.support.itsupport.controller;


import com.support.itsupport.entity.Equipement;
import com.support.itsupport.service.EquipementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipements")
@CrossOrigin(origins = "*")
public class EquipementController {


    @Autowired
    private EquipementService equipementService;

    @PostMapping
    public Equipement ajouterEquipement(@RequestBody Equipement equipement) {
        return equipementService.ajouterEquipement(equipement);
    }

    @PutMapping("/{id}")
    public Equipement modifierEquipement(@PathVariable Long id, @RequestBody Equipement equipement) {
        return equipementService.modifierEquipement(id, equipement);
    }

    @DeleteMapping("/{id}")
    public void supprimerEquipement(@PathVariable Long id) {
        equipementService.supprimerEquipement(id);
    }

    @GetMapping
    public List<Equipement> getAllEquipements() {
        return equipementService.getAllEquipements();
    }
}
