package com.iota.orign.web.rest;

import com.iota.orign.domain.DernieresNouvelles;
import com.iota.orign.repository.DernieresNouvellesRepository;
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

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link com.iota.orign.domain.DernieresNouvelles}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class DernieresNouvellesResource {

    private final Logger log = LoggerFactory.getLogger(DernieresNouvellesResource.class);

    private static final String ENTITY_NAME = "dernieresNouvelles";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final DernieresNouvellesRepository dernieresNouvellesRepository;

    public DernieresNouvellesResource(DernieresNouvellesRepository dernieresNouvellesRepository) {
        this.dernieresNouvellesRepository = dernieresNouvellesRepository;
    }

    /**
     * {@code POST  /dernieres-nouvelles} : Create a new dernieresNouvelles.
     *
     * @param dernieresNouvelles the dernieresNouvelles to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new dernieresNouvelles, or with status {@code 400 (Bad Request)} if the dernieresNouvelles has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/dernieres-nouvelles")
    public ResponseEntity<DernieresNouvelles> createDernieresNouvelles(@RequestBody DernieresNouvelles dernieresNouvelles) throws URISyntaxException {
        log.debug("REST request to save DernieresNouvelles : {}", dernieresNouvelles);
        if (dernieresNouvelles.getId() != null) {
            throw new BadRequestAlertException("A new dernieresNouvelles cannot already have an ID", ENTITY_NAME, "idexists");
        }
        DernieresNouvelles result = dernieresNouvellesRepository.save(dernieresNouvelles);
        return ResponseEntity.created(new URI("/api/dernieres-nouvelles/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /dernieres-nouvelles} : Updates an existing dernieresNouvelles.
     *
     * @param dernieresNouvelles the dernieresNouvelles to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated dernieresNouvelles,
     * or with status {@code 400 (Bad Request)} if the dernieresNouvelles is not valid,
     * or with status {@code 500 (Internal Server Error)} if the dernieresNouvelles couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/dernieres-nouvelles")
    public ResponseEntity<DernieresNouvelles> updateDernieresNouvelles(@RequestBody DernieresNouvelles dernieresNouvelles) throws URISyntaxException {
        log.debug("REST request to update DernieresNouvelles : {}", dernieresNouvelles);
        if (dernieresNouvelles.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        DernieresNouvelles result = dernieresNouvellesRepository.save(dernieresNouvelles);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, dernieresNouvelles.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /dernieres-nouvelles} : get all the dernieresNouvelles.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of dernieresNouvelles in body.
     */
    @GetMapping("/dernieres-nouvelles")
    public ResponseEntity<List<DernieresNouvelles>> getAllDernieresNouvelles(Pageable pageable) {
        log.debug("REST request to get a page of DernieresNouvelles");
        Page<DernieresNouvelles> page = dernieresNouvellesRepository.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /dernieres-nouvelles/:id} : get the "id" dernieresNouvelles.
     *
     * @param id the id of the dernieresNouvelles to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the dernieresNouvelles, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/dernieres-nouvelles/{id}")
    public ResponseEntity<DernieresNouvelles> getDernieresNouvelles(@PathVariable Long id) {
        log.debug("REST request to get DernieresNouvelles : {}", id);
        Optional<DernieresNouvelles> dernieresNouvelles = dernieresNouvellesRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(dernieresNouvelles);
    }

    /**
     * {@code DELETE  /dernieres-nouvelles/:id} : delete the "id" dernieresNouvelles.
     *
     * @param id the id of the dernieresNouvelles to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/dernieres-nouvelles/{id}")
    public ResponseEntity<Void> deleteDernieresNouvelles(@PathVariable Long id) {
        log.debug("REST request to delete DernieresNouvelles : {}", id);
        dernieresNouvellesRepository.deleteById(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
