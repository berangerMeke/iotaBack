package com.iota.orign.web.rest;

import com.iota.orign.domain.APropos;
import com.iota.orign.repository.AProposRepository;
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
 * REST controller for managing {@link com.iota.orign.domain.APropos}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class AProposResource {

    private final Logger log = LoggerFactory.getLogger(AProposResource.class);

    private static final String ENTITY_NAME = "aPropos";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final AProposRepository aProposRepository;

    public AProposResource(AProposRepository aProposRepository) {
        this.aProposRepository = aProposRepository;
    }

    /**
     * {@code POST  /a-propos} : Create a new aPropos.
     *
     * @param aPropos the aPropos to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new aPropos, or with status {@code 400 (Bad Request)} if the aPropos has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/a-propos")
    public ResponseEntity<APropos> createAPropos(@RequestBody APropos aPropos) throws URISyntaxException {
        log.debug("REST request to save APropos : {}", aPropos);
        if (aPropos.getId() != null) {
            throw new BadRequestAlertException("A new aPropos cannot already have an ID", ENTITY_NAME, "idexists");
        }
        APropos result = aProposRepository.save(aPropos);
        return ResponseEntity.created(new URI("/api/a-propos/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /a-propos} : Updates an existing aPropos.
     *
     * @param aPropos the aPropos to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated aPropos,
     * or with status {@code 400 (Bad Request)} if the aPropos is not valid,
     * or with status {@code 500 (Internal Server Error)} if the aPropos couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/a-propos")
    public ResponseEntity<APropos> updateAPropos(@RequestBody APropos aPropos) throws URISyntaxException {
        log.debug("REST request to update APropos : {}", aPropos);
        if (aPropos.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        APropos result = aProposRepository.save(aPropos);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, aPropos.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /a-propos} : get all the aPropos.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of aPropos in body.
     */
    @GetMapping("/a-propos")
    public ResponseEntity<List<APropos>> getAllAPropos(Pageable pageable) {
        log.debug("REST request to get a page of APropos");
        Page<APropos> page = aProposRepository.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /a-propos/:id} : get the "id" aPropos.
     *
     * @param id the id of the aPropos to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the aPropos, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/a-propos/{id}")
    public ResponseEntity<APropos> getAPropos(@PathVariable Long id) {
        log.debug("REST request to get APropos : {}", id);
        Optional<APropos> aPropos = aProposRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(aPropos);
    }

    /**
     * {@code DELETE  /a-propos/:id} : delete the "id" aPropos.
     *
     * @param id the id of the aPropos to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/a-propos/{id}")
    public ResponseEntity<Void> deleteAPropos(@PathVariable Long id) {
        log.debug("REST request to delete APropos : {}", id);
        aProposRepository.deleteById(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
