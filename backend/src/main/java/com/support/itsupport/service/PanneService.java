package com.support.itsupport.service;

import com.support.itsupport.entity.Panne;
import com.support.itsupport.repository.PanneRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PanneService {

    private final PanneRepository panneRepository;

    public PanneService(PanneRepository panneRepository) {
        this.panneRepository = panneRepository;
    }

    public List<Panne> getAllPannes() {
        return panneRepository.findAll();
    }

    public Optional<Panne> getPanneById(Long id) {
        return panneRepository.findById(id);
    }

    public Panne addPanne(Panne panne) {
        return panneRepository.save(panne);
    }


}

