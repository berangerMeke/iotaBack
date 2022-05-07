package com.iota.orign.repository;

import com.iota.orign.domain.Imprint;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Imprint entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ImprintRepository extends JpaRepository<Imprint, Long> {
}
