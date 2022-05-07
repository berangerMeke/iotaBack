package com.iota.orign.web.rest;

import com.iota.orign.domain.GoogleAnalitcs;
import com.iota.orign.repository.GoogleAnalitcsRepository;
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
 * REST controller for managing {@link com.iota.orign.domain.GoogleAnalitcs}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class GoogleAnalitcsResource {

    private final Logger log = LoggerFactory.getLogger(GoogleAnalitcsResource.class);

    private static final String ENTITY_NAME = "googleAnalitcs";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final GoogleAnalitcsRepository googleAnalitcsRepository;

    public GoogleAnalitcsResource(GoogleAnalitcsRepository googleAnalitcsRepository) {
        this.googleAnalitcsRepository = googleAnalitcsRepository;
    }

    /**
     * {@code POST  /google-analitcs} : Create a new googleAnalitcs.
     *
     * @param googleAnalitcs the googleAnalitcs to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new googleAnalitcs, or with status {@code 400 (Bad Request)} if the googleAnalitcs has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/google-analitcs")
    public ResponseEntity<GoogleAnalitcs> createGoogleAnalitcs(@Valid @RequestBody GoogleAnalitcs googleAnalitcs) throws URISyntaxException {
        log.debug("REST request to save GoogleAnalitcs : {}", googleAnalitcs);
        if (googleAnalitcs.getId() != null) {
            throw new BadRequestAlertException("A new googleAnalitcs cannot already have an ID", ENTITY_NAME, "idexists");
        }
        GoogleAnalitcs result = googleAnalitcsRepository.save(googleAnalitcs);
        return ResponseEntity.created(new URI("/api/google-analitcs/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /google-analitcs} : Updates an existing googleAnalitcs.
     *
     * @param googleAnalitcs the googleAnalitcs to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated googleAnalitcs,
     * or with status {@code 400 (Bad Request)} if the googleAnalitcs is not valid,
     * or with status {@code 500 (Internal Server Error)} if the googleAnalitcs couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/google-analitcs")
    public ResponseEntity<GoogleAnalitcs> updateGoogleAnalitcs(@Valid @RequestBody GoogleAnalitcs googleAnalitcs) throws URISyntaxException {
        log.debug("REST request to update GoogleAnalitcs : {}", googleAnalitcs);
        if (googleAnalitcs.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        GoogleAnalitcs result = googleAnalitcsRepository.save(googleAnalitcs);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, googleAnalitcs.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /google-analitcs} : get all the googleAnalitcs.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of googleAnalitcs in body.
     */
    @GetMapping("/google-analitcs")
    public ResponseEntity<List<GoogleAnalitcs>> getAllGoogleAnalitcs(Pageable pageable) {
        log.debug("REST request to get a page of GoogleAnalitcs");
        Page<GoogleAnalitcs> page = googleAnalitcsRepository.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /google-analitcs/:id} : get the "id" googleAnalitcs.
     *
     * @param id the id of the googleAnalitcs to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the googleAnalitcs, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/google-analitcs/{id}")
    public ResponseEntity<GoogleAnalitcs> getGoogleAnalitcs(@PathVariable Long id) {
        log.debug("REST request to get GoogleAnalitcs : {}", id);
        Optional<GoogleAnalitcs> googleAnalitcs = googleAnalitcsRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(googleAnalitcs);
    }

    /**
     * {@code DELETE  /google-analitcs/:id} : delete the "id" googleAnalitcs.
     *
     * @param id the id of the googleAnalitcs to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/google-analitcs/{id}")
    public ResponseEntity<Void> deleteGoogleAnalitcs(@PathVariable Long id) {
        log.debug("REST request to delete GoogleAnalitcs : {}", id);
        googleAnalitcsRepository.deleteById(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
