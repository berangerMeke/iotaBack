package com.iota.orign.web.rest;

import com.iota.orign.domain.FooterSection;
import com.iota.orign.repository.FooterSectionRepository;
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
 * REST controller for managing {@link com.iota.orign.domain.FooterSection}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class FooterSectionResource {

    private final Logger log = LoggerFactory.getLogger(FooterSectionResource.class);

    private static final String ENTITY_NAME = "footerSection";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final FooterSectionRepository footerSectionRepository;

    public FooterSectionResource(FooterSectionRepository footerSectionRepository) {
        this.footerSectionRepository = footerSectionRepository;
    }

    /**
     * {@code POST  /footer-sections} : Create a new footerSection.
     *
     * @param footerSection the footerSection to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new footerSection, or with status {@code 400 (Bad Request)} if the footerSection has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/footer-sections")
    public ResponseEntity<FooterSection> createFooterSection(@RequestBody FooterSection footerSection) throws URISyntaxException {
        log.debug("REST request to save FooterSection : {}", footerSection);
        if (footerSection.getId() != null) {
            throw new BadRequestAlertException("A new footerSection cannot already have an ID", ENTITY_NAME, "idexists");
        }
        FooterSection result = footerSectionRepository.save(footerSection);
        return ResponseEntity.created(new URI("/api/footer-sections/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /footer-sections} : Updates an existing footerSection.
     *
     * @param footerSection the footerSection to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated footerSection,
     * or with status {@code 400 (Bad Request)} if the footerSection is not valid,
     * or with status {@code 500 (Internal Server Error)} if the footerSection couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/footer-sections")
    public ResponseEntity<FooterSection> updateFooterSection(@RequestBody FooterSection footerSection) throws URISyntaxException {
        log.debug("REST request to update FooterSection : {}", footerSection);
        if (footerSection.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        FooterSection result = footerSectionRepository.save(footerSection);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, footerSection.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /footer-sections} : get all the footerSections.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of footerSections in body.
     */
    @GetMapping("/footer-sections")
    public ResponseEntity<List<FooterSection>> getAllFooterSections(Pageable pageable) {
        log.debug("REST request to get a page of FooterSections");
        Page<FooterSection> page = footerSectionRepository.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /footer-sections/:id} : get the "id" footerSection.
     *
     * @param id the id of the footerSection to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the footerSection, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/footer-sections/{id}")
    public ResponseEntity<FooterSection> getFooterSection(@PathVariable Long id) {
        log.debug("REST request to get FooterSection : {}", id);
        Optional<FooterSection> footerSection = footerSectionRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(footerSection);
    }

    /**
     * {@code DELETE  /footer-sections/:id} : delete the "id" footerSection.
     *
     * @param id the id of the footerSection to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/footer-sections/{id}")
    public ResponseEntity<Void> deleteFooterSection(@PathVariable Long id) {
        log.debug("REST request to delete FooterSection : {}", id);
        footerSectionRepository.deleteById(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
