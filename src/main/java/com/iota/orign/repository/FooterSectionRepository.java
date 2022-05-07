package com.iota.orign.repository;

import com.iota.orign.domain.FooterSection;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the FooterSection entity.
 */
@SuppressWarnings("unused")
@Repository
public interface FooterSectionRepository extends JpaRepository<FooterSection, Long> {
}
