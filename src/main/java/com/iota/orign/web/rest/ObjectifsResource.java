package com.iota.orign.web.rest;

import com.iota.orign.domain.Objectifs;
import com.iota.orign.repository.ObjectifsRepository;
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
 * REST controller for managing {@link com.iota.orign.domain.Objectifs}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class ObjectifsResource {

    private final Logger log = LoggerFactory.getLogger(ObjectifsResource.class);

    private static final String ENTITY_NAME = "objectifs";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ObjectifsRepository objectifsRepository;

    public ObjectifsResource(ObjectifsRepository objectifsRepository) {
        this.objectifsRepository = objectifsRepository;
    }

    /**
     * {@code POST  /objectifs} : Create a new objectifs.
     *
     * @param objectifs the objectifs to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new objectifs, or with status {@code 400 (Bad Request)} if the objectifs has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/objectifs")
    public ResponseEntity<Objectifs> createObjectifs(@RequestBody Objectifs objectifs) throws URISyntaxException {
        log.debug("REST request to save Objectifs : {}", objectifs);
        if (objectifs.getId() != null) {
            throw new BadRequestAlertException("A new objectifs cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Objectifs result = objectifsRepository.save(objectifs);
        return ResponseEntity.created(new URI("/api/objectifs/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /objectifs} : Updates an existing objectifs.
     *
     * @param objectifs the objectifs to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated objectifs,
     * or with status {@code 400 (Bad Request)} if the objectifs is not valid,
     * or with status {@code 500 (Internal Server Error)} if the objectifs couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/objectifs")
    public ResponseEntity<Objectifs> updateObjectifs(@RequestBody Objectifs objectifs) throws URISyntaxException {
        log.debug("REST request to update Objectifs : {}", objectifs);
        if (objectifs.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        Objectifs result = objectifsRepository.save(objectifs);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, objectifs.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /objectifs} : get all the objectifs.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of objectifs in body.
     */
    @GetMapping("/objectifs")
    public ResponseEntity<List<Objectifs>> getAllObjectifs(Pageable pageable) {
        log.debug("REST request to get a page of Objectifs");
        Page<Objectifs> page = objectifsRepository.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /objectifs/:id} : get the "id" objectifs.
     *
     * @param id the id of the objectifs to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the objectifs, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/objectifs/{id}")
    public ResponseEntity<Objectifs> getObjectifs(@PathVariable Long id) {
        log.debug("REST request to get Objectifs : {}", id);
        Optional<Objectifs> objectifs = objectifsRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(objectifs);
    }

    /**
     * {@code DELETE  /objectifs/:id} : delete the "id" objectifs.
     *
     * @param id the id of the objectifs to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/objectifs/{id}")
    public ResponseEntity<Void> deleteObjectifs(@PathVariable Long id) {
        log.debug("REST request to delete Objectifs : {}", id);
        objectifsRepository.deleteById(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
