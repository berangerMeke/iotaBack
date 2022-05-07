package com.iota.orign.repository;

import com.iota.orign.domain.GoogleAnalitcs;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the GoogleAnalitcs entity.
 */
@SuppressWarnings("unused")
@Repository
public interface GoogleAnalitcsRepository extends JpaRepository<GoogleAnalitcs, Long> {
}
