package com.iota.orign.web.rest;

import com.iota.orign.domain.PrivacyPolicy;
import com.iota.orign.repository.PrivacyPolicyRepository;
import com.iota.orign.web.rest.errors.BadRequestAlertException;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link com.iota.orign.domain.PrivacyPolicy}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class PrivacyPolicyResource {

    private final Logger log = LoggerFactory.getLogger(PrivacyPolicyResource.class);

    private static final String ENTITY_NAME = "privacyPolicy";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final PrivacyPolicyRepository privacyPolicyRepository;

    public PrivacyPolicyResource(PrivacyPolicyRepository privacyPolicyRepository) {
        this.privacyPolicyRepository = privacyPolicyRepository;
    }

    /**
     * {@code POST  /privacy-policies} : Create a new privacyPolicy.
     *
     * @param privacyPolicy the privacyPolicy to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new privacyPolicy, or with status {@code 400 (Bad Request)} if the privacyPolicy has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/privacy-policies")
    public ResponseEntity<PrivacyPolicy> createPrivacyPolicy(@Valid @RequestBody PrivacyPolicy privacyPolicy) throws URISyntaxException {
        log.debug("REST request to save PrivacyPolicy : {}", privacyPolicy);
        if (privacyPolicy.getId() != null) {
            throw new BadRequestAlertException("A new privacyPolicy cannot already have an ID", ENTITY_NAME, "idexists");
        }
        PrivacyPolicy result = privacyPolicyRepository.save(privacyPolicy);
        return ResponseEntity.created(new URI("/api/privacy-policies/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /privacy-policies} : Updates an existing privacyPolicy.
     *
     * @param privacyPolicy the privacyPolicy to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated privacyPolicy,
     * or with status {@code 400 (Bad Request)} if the privacyPolicy is not valid,
     * or with status {@code 500 (Internal Server Error)} if the privacyPolicy couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/privacy-policies")
    public ResponseEntity<PrivacyPolicy> updatePrivacyPolicy(@Valid @RequestBody PrivacyPolicy privacyPolicy) throws URISyntaxException {
        log.debug("REST request to update PrivacyPolicy : {}", privacyPolicy);
        if (privacyPolicy.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        PrivacyPolicy result = privacyPolicyRepository.save(privacyPolicy);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, privacyPolicy.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /privacy-policies} : get all the privacyPolicies.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of privacyPolicies in body.
     */
    @GetMapping("/privacy-policies")
    public ResponseEntity<List<PrivacyPolicy>> getAllPrivacyPolicies(Pageable pageable) {
        log.debug("REST request to get a page of PrivacyPolicies");
        Page<PrivacyPolicy> page = privacyPolicyRepository.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /privacy-policies/:id} : get the "id" privacyPolicy.
     *
     * @param id the id of the privacyPolicy to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the privacyPolicy, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/privacy-policies/{id}")
    public ResponseEntity<PrivacyPolicy> getPrivacyPolicy(@PathVariable Long id) {
        log.debug("REST request to get PrivacyPolicy : {}", id);
        Optional<PrivacyPolicy> privacyPolicy = privacyPolicyRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(privacyPolicy);
    }

    /**
     * {@code DELETE  /privacy-policies/:id} : delete the "id" privacyPolicy.
     *
     * @param id the id of the privacyPolicy to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/privacy-policies/{id}")
    public ResponseEntity<Void> deletePrivacyPolicy(@PathVariable Long id) {
        log.debug("REST request to delete PrivacyPolicy : {}", id);
        privacyPolicyRepository.deleteById(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
