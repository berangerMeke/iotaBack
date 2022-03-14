package com.iota.orign.repository;

import com.iota.orign.domain.Objectifs;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Objectifs entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ObjectifsRepository extends JpaRepository<Objectifs, Long> {
}
