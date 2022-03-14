package com.iota.orign.repository;

import com.iota.orign.domain.DernieresNouvelles;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the DernieresNouvelles entity.
 */
@SuppressWarnings("unused")
@Repository
public interface DernieresNouvellesRepository extends JpaRepository<DernieresNouvelles, Long> {
}
