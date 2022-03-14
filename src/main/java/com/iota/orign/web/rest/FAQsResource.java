package com.iota.orign.web.rest;

import com.iota.orign.domain.FAQs;
import com.iota.orign.repository.FAQsRepository;
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
 * REST controller for managing {@link com.iota.orign.domain.FAQs}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class FAQsResource {

    private final Logger log = LoggerFactory.getLogger(FAQsResource.class);

    private static final String ENTITY_NAME = "fAQs";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final FAQsRepository fAQsRepository;

    public FAQsResource(FAQsRepository fAQsRepository) {
        this.fAQsRepository = fAQsRepository;
    }

    /**
     * {@code POST  /fa-qs} : Create a new fAQs.
     *
     * @param fAQs the fAQs to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new fAQs, or with status {@code 400 (Bad Request)} if the fAQs has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/fa-qs")
    public ResponseEntity<FAQs> createFAQs(@RequestBody FAQs fAQs) throws URISyntaxException {
        log.debug("REST request to save FAQs : {}", fAQs);
        if (fAQs.getId() != null) {
            throw new BadRequestAlertException("A new fAQs cannot already have an ID", ENTITY_NAME, "idexists");
        }
        FAQs result = fAQsRepository.save(fAQs);
        return ResponseEntity.created(new URI("/api/fa-qs/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /fa-qs} : Updates an existing fAQs.
     *
     * @param fAQs the fAQs to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated fAQs,
     * or with status {@code 400 (Bad Request)} if the fAQs is not valid,
     * or with status {@code 500 (Internal Server Error)} if the fAQs couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/fa-qs")
    public ResponseEntity<FAQs> updateFAQs(@RequestBody FAQs fAQs) throws URISyntaxException {
        log.debug("REST request to update FAQs : {}", fAQs);
        if (fAQs.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        FAQs result = fAQsRepository.save(fAQs);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, fAQs.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /fa-qs} : get all the fAQs.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of fAQs in body.
     */
    @GetMapping("/fa-qs")
    public ResponseEntity<List<FAQs>> getAllFAQs(Pageable pageable) {
        log.debug("REST request to get a page of FAQs");
        Page<FAQs> page = fAQsRepository.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /fa-qs/:id} : get the "id" fAQs.
     *
     * @param id the id of the fAQs to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the fAQs, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/fa-qs/{id}")
    public ResponseEntity<FAQs> getFAQs(@PathVariable Long id) {
        log.debug("REST request to get FAQs : {}", id);
        Optional<FAQs> fAQs = fAQsRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(fAQs);
    }

    /**
     * {@code DELETE  /fa-qs/:id} : delete the "id" fAQs.
     *
     * @param id the id of the fAQs to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/fa-qs/{id}")
    public ResponseEntity<Void> deleteFAQs(@PathVariable Long id) {
        log.debug("REST request to delete FAQs : {}", id);
        fAQsRepository.deleteById(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
