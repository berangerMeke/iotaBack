package com.iota.orign.repository;

import com.iota.orign.domain.Accueil;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Accueil entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AccueilRepository extends JpaRepository<Accueil, Long> {
}
