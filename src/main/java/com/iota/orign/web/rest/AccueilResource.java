package com.iota.orign.web.rest;

import com.iota.orign.domain.Accueil;
import com.iota.orign.repository.AccueilRepository;
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
 * REST controller for managing {@link com.iota.orign.domain.Accueil}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class AccueilResource {

    private final Logger log = LoggerFactory.getLogger(AccueilResource.class);

    private static final String ENTITY_NAME = "accueil";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final AccueilRepository accueilRepository;

    public AccueilResource(AccueilRepository accueilRepository) {
        this.accueilRepository = accueilRepository;
    }

    /**
     * {@code POST  /accueils} : Create a new accueil.
     *
     * @param accueil the accueil to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new accueil, or with status {@code 400 (Bad Request)} if the accueil has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/accueils")
    public ResponseEntity<Accueil> createAccueil(@RequestBody Accueil accueil) throws URISyntaxException {
        log.debug("REST request to save Accueil : {}", accueil);
        if (accueil.getId() != null) {
            throw new BadRequestAlertException("A new accueil cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Accueil result = accueilRepository.save(accueil);
        return ResponseEntity.created(new URI("/api/accueils/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /accueils} : Updates an existing accueil.
     *
     * @param accueil the accueil to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated accueil,
     * or with status {@code 400 (Bad Request)} if the accueil is not valid,
     * or with status {@code 500 (Internal Server Error)} if the accueil couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/accueils")
    public ResponseEntity<Accueil> updateAccueil(@RequestBody Accueil accueil) throws URISyntaxException {
        log.debug("REST request to update Accueil : {}", accueil);
        if (accueil.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        Accueil result = accueilRepository.save(accueil);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, accueil.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /accueils} : get all the accueils.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of accueils in body.
     */
    @GetMapping("/accueils")
    public ResponseEntity<List<Accueil>> getAllAccueils(Pageable pageable) {
        log.debug("REST request to get a page of Accueils");
        Page<Accueil> page = accueilRepository.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /accueils/:id} : get the "id" accueil.
     *
     * @param id the id of the accueil to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the accueil, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/accueils/{id}")
    public ResponseEntity<Accueil> getAccueil(@PathVariable Long id) {
        log.debug("REST request to get Accueil : {}", id);
        Optional<Accueil> accueil = accueilRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(accueil);
    }

    /**
     * {@code DELETE  /accueils/:id} : delete the "id" accueil.
     *
     * @param id the id of the accueil to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/accueils/{id}")
    public ResponseEntity<Void> deleteAccueil(@PathVariable Long id) {
        log.debug("REST request to delete Accueil : {}", id);
        accueilRepository.deleteById(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
