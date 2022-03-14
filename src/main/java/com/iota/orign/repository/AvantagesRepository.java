package com.iota.orign.repository;

import com.iota.orign.domain.Avantages;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Avantages entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AvantagesRepository extends JpaRepository<Avantages, Long> {
}
