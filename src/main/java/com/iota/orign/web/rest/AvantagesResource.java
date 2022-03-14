package com.iota.orign.web.rest;

import com.iota.orign.domain.Avantages;
import com.iota.orign.repository.AvantagesRepository;
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
 * REST controller for managing {@link com.iota.orign.domain.Avantages}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class AvantagesResource {

    private final Logger log = LoggerFactory.getLogger(AvantagesResource.class);

    private static final String ENTITY_NAME = "avantages";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final AvantagesRepository avantagesRepository;

    public AvantagesResource(AvantagesRepository avantagesRepository) {
        this.avantagesRepository = avantagesRepository;
    }

    /**
     * {@code POST  /avantages} : Create a new avantages.
     *
     * @param avantages the avantages to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new avantages, or with status {@code 400 (Bad Request)} if the avantages has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/avantages")
    public ResponseEntity<Avantages> createAvantages(@RequestBody Avantages avantages) throws URISyntaxException {
        log.debug("REST request to save Avantages : {}", avantages);
        if (avantages.getId() != null) {
            throw new BadRequestAlertException("A new avantages cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Avantages result = avantagesRepository.save(avantages);
        return ResponseEntity.created(new URI("/api/avantages/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /avantages} : Updates an existing avantages.
     *
     * @param avantages the avantages to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated avantages,
     * or with status {@code 400 (Bad Request)} if the avantages is not valid,
     * or with status {@code 500 (Internal Server Error)} if the avantages couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/avantages")
    public ResponseEntity<Avantages> updateAvantages(@RequestBody Avantages avantages) throws URISyntaxException {
        log.debug("REST request to update Avantages : {}", avantages);
        if (avantages.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        Avantages result = avantagesRepository.save(avantages);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, avantages.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /avantages} : get all the avantages.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of avantages in body.
     */
    @GetMapping("/avantages")
    public ResponseEntity<List<Avantages>> getAllAvantages(Pageable pageable) {
        log.debug("REST request to get a page of Avantages");
        Page<Avantages> page = avantagesRepository.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /avantages/:id} : get the "id" avantages.
     *
     * @param id the id of the avantages to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the avantages, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/avantages/{id}")
    public ResponseEntity<Avantages> getAvantages(@PathVariable Long id) {
        log.debug("REST request to get Avantages : {}", id);
        Optional<Avantages> avantages = avantagesRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(avantages);
    }

    /**
     * {@code DELETE  /avantages/:id} : delete the "id" avantages.
     *
     * @param id the id of the avantages to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/avantages/{id}")
    public ResponseEntity<Void> deleteAvantages(@PathVariable Long id) {
        log.debug("REST request to delete Avantages : {}", id);
        avantagesRepository.deleteById(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
