package com.support.itsupport.repository;

import com.support.itsupport.entity.Panne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface PanneRepository extends JpaRepository<Panne, Long>{
}
