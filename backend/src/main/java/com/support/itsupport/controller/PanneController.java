package com.support.itsupport.controller;

import com.support.itsupport.entity.Panne;
import com.support.itsupport.service.PanneService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pannes")
@CrossOrigin("*") // Allows frontend to connect
public class PanneController {

    private final PanneService panneService;

    public PanneController(PanneService panneService) {
        this.panneService = panneService;
    }

    @GetMapping
    public List<Panne> getAllPannes() {
        return panneService.getAllPannes();
    }


    @GetMapping("/{id}")
    public Optional<Panne> getPanneById(@PathVariable Long id) {
        return panneService.getPanneById(id);
    }

    @PostMapping
    public Panne createPanne(@RequestBody Panne panne) {
        return panneService.addPanne(panne);
    }

    @PutMapping("/{id}")
    public Panne updatePanne(@PathVariable Long id, @RequestBody Panne panne) {
        return panneService.updatePanne(id, panne);
    }

    @DeleteMapping("/{id}")
    public void deletePanne(@PathVariable Long id) {
        panneService.deletePanne(id);
    }
}

