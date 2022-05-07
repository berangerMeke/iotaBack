package com.iota.orign.repository;

import com.iota.orign.domain.PrivacyPolicy;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the PrivacyPolicy entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PrivacyPolicyRepository extends JpaRepository<PrivacyPolicy, Long> {
}
