package com.iota.orign.repository;

import com.iota.orign.domain.APropos;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the APropos entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AProposRepository extends JpaRepository<APropos, Long> {
}
