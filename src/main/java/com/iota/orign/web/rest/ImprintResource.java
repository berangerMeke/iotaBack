package com.iota.orign.web.rest;

import com.iota.orign.domain.Imprint;
import com.iota.orign.repository.ImprintRepository;
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
 * REST controller for managing {@link com.iota.orign.domain.Imprint}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class ImprintResource {

    private final Logger log = LoggerFactory.getLogger(ImprintResource.class);

    private static final String ENTITY_NAME = "imprint";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ImprintRepository imprintRepository;

    public ImprintResource(ImprintRepository imprintRepository) {
        this.imprintRepository = imprintRepository;
    }

    /**
     * {@code POST  /imprints} : Create a new imprint.
     *
     * @param imprint the imprint to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new imprint, or with status {@code 400 (Bad Request)} if the imprint has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/imprints")
    public ResponseEntity<Imprint> createImprint(@Valid @RequestBody Imprint imprint) throws URISyntaxException {
        log.debug("REST request to save Imprint : {}", imprint);
        if (imprint.getId() != null) {
            throw new BadRequestAlertException("A new imprint cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Imprint result = imprintRepository.save(imprint);
        return ResponseEntity.created(new URI("/api/imprints/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /imprints} : Updates an existing imprint.
     *
     * @param imprint the imprint to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated imprint,
     * or with status {@code 400 (Bad Request)} if the imprint is not valid,
     * or with status {@code 500 (Internal Server Error)} if the imprint couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/imprints")
    public ResponseEntity<Imprint> updateImprint(@Valid @RequestBody Imprint imprint) throws URISyntaxException {
        log.debug("REST request to update Imprint : {}", imprint);
        if (imprint.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        Imprint result = imprintRepository.save(imprint);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, imprint.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /imprints} : get all the imprints.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of imprints in body.
     */
    @GetMapping("/imprints")
    public ResponseEntity<List<Imprint>> getAllImprints(Pageable pageable) {
        log.debug("REST request to get a page of Imprints");
        Page<Imprint> page = imprintRepository.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /imprints/:id} : get the "id" imprint.
     *
     * @param id the id of the imprint to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the imprint, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/imprints/{id}")
    public ResponseEntity<Imprint> getImprint(@PathVariable Long id) {
        log.debug("REST request to get Imprint : {}", id);
        Optional<Imprint> imprint = imprintRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(imprint);
    }

    /**
     * {@code DELETE  /imprints/:id} : delete the "id" imprint.
     *
     * @param id the id of the imprint to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/imprints/{id}")
    public ResponseEntity<Void> deleteImprint(@PathVariable Long id) {
        log.debug("REST request to delete Imprint : {}", id);
        imprintRepository.deleteById(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
