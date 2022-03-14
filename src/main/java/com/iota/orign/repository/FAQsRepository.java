package com.iota.orign.repository;

import com.iota.orign.domain.FAQs;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the FAQs entity.
 */
@SuppressWarnings("unused")
@Repository
public interface FAQsRepository extends JpaRepository<FAQs, Long> {
}
