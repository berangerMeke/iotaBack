package com.iota.orign.web.rest;

import com.iota.orign.IotaOrignAdminApp;
import com.iota.orign.domain.Imprint;
import com.iota.orign.repository.ImprintRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for the {@link ImprintResource} REST controller.
 */
@SpringBootTest(classes = IotaOrignAdminApp.class)

@AutoConfigureMockMvc
@WithMockUser
public class ImprintResourceIT {

    private static final String DEFAULT_TITRE_IMPRINT_EN = "AAAAAAAAAA";
    private static final String UPDATED_TITRE_IMPRINT_EN = "BBBBBBBBBB";

    private static final String DEFAULT_TITRE_IMPRINT_FR = "AAAAAAAAAA";
    private static final String UPDATED_TITRE_IMPRINT_FR = "BBBBBBBBBB";

    private static final String DEFAULT_TITRE_IMPRINT_GER = "AAAAAAAAAA";
    private static final String UPDATED_TITRE_IMPRINT_GER = "BBBBBBBBBB";

    private static final String DEFAULT_TITRE_IMPRINT_SW = "AAAAAAAAAA";
    private static final String UPDATED_TITRE_IMPRINT_SW = "BBBBBBBBBB";

    private static final String DEFAULT_CONTENU_IMPRINT_EN = "AAAAAAAAAA";
    private static final String UPDATED_CONTENU_IMPRINT_EN = "BBBBBBBBBB";

    private static final String DEFAULT_CONTENU_IMPRINT_GER = "AAAAAAAAAA";
    private static final String UPDATED_CONTENU_IMPRINT_GER = "BBBBBBBBBB";

    private static final String DEFAULT_CONTENU_IMPRINT_FR = "AAAAAAAAAA";
    private static final String UPDATED_CONTENU_IMPRINT_FR = "BBBBBBBBBB";

    private static final String DEFAULT_CONTENU_IMPRINT_SW = "AAAAAAAAAA";
    private static final String UPDATED_CONTENU_IMPRINT_SW = "BBBBBBBBBB";

    @Autowired
    private ImprintRepository imprintRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restImprintMockMvc;

    private Imprint imprint;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Imprint createEntity(EntityManager em) {
        Imprint imprint = new Imprint()
            .titreImprintEn(DEFAULT_TITRE_IMPRINT_EN)
            .titreImprintFr(DEFAULT_TITRE_IMPRINT_FR)
            .titreImprintGer(DEFAULT_TITRE_IMPRINT_GER)
            .titreImprintSw(DEFAULT_TITRE_IMPRINT_SW)
            .contenuImprintEn(DEFAULT_CONTENU_IMPRINT_EN)
            .contenuImprintGer(DEFAULT_CONTENU_IMPRINT_GER)
            .contenuImprintFr(DEFAULT_CONTENU_IMPRINT_FR)
            .contenuImprintSw(DEFAULT_CONTENU_IMPRINT_SW);
        return imprint;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Imprint createUpdatedEntity(EntityManager em) {
        Imprint imprint = new Imprint()
            .titreImprintEn(UPDATED_TITRE_IMPRINT_EN)
            .titreImprintFr(UPDATED_TITRE_IMPRINT_FR)
            .titreImprintGer(UPDATED_TITRE_IMPRINT_GER)
            .titreImprintSw(UPDATED_TITRE_IMPRINT_SW)
            .contenuImprintEn(UPDATED_CONTENU_IMPRINT_EN)
            .contenuImprintGer(UPDATED_CONTENU_IMPRINT_GER)
            .contenuImprintFr(UPDATED_CONTENU_IMPRINT_FR)
            .contenuImprintSw(UPDATED_CONTENU_IMPRINT_SW);
        return imprint;
    }

    @BeforeEach
    public void initTest() {
        imprint = createEntity(em);
    }

    @Test
    @Transactional
    public void createImprint() throws Exception {
        int databaseSizeBeforeCreate = imprintRepository.findAll().size();

        // Create the Imprint
        restImprintMockMvc.perform(post("/api/imprints")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(imprint)))
            .andExpect(status().isCreated());

        // Validate the Imprint in the database
        List<Imprint> imprintList = imprintRepository.findAll();
        assertThat(imprintList).hasSize(databaseSizeBeforeCreate + 1);
        Imprint testImprint = imprintList.get(imprintList.size() - 1);
        assertThat(testImprint.getTitreImprintEn()).isEqualTo(DEFAULT_TITRE_IMPRINT_EN);
        assertThat(testImprint.getTitreImprintFr()).isEqualTo(DEFAULT_TITRE_IMPRINT_FR);
        assertThat(testImprint.getTitreImprintGer()).isEqualTo(DEFAULT_TITRE_IMPRINT_GER);
        assertThat(testImprint.getTitreImprintSw()).isEqualTo(DEFAULT_TITRE_IMPRINT_SW);
        assertThat(testImprint.getContenuImprintEn()).isEqualTo(DEFAULT_CONTENU_IMPRINT_EN);
        assertThat(testImprint.getContenuImprintGer()).isEqualTo(DEFAULT_CONTENU_IMPRINT_GER);
        assertThat(testImprint.getContenuImprintFr()).isEqualTo(DEFAULT_CONTENU_IMPRINT_FR);
        assertThat(testImprint.getContenuImprintSw()).isEqualTo(DEFAULT_CONTENU_IMPRINT_SW);
    }

    @Test
    @Transactional
    public void createImprintWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = imprintRepository.findAll().size();

        // Create the Imprint with an existing ID
        imprint.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restImprintMockMvc.perform(post("/api/imprints")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(imprint)))
            .andExpect(status().isBadRequest());

        // Validate the Imprint in the database
        List<Imprint> imprintList = imprintRepository.findAll();
        assertThat(imprintList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllImprints() throws Exception {
        // Initialize the database
        imprintRepository.saveAndFlush(imprint);

        // Get all the imprintList
        restImprintMockMvc.perform(get("/api/imprints?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(imprint.getId().intValue())))
            .andExpect(jsonPath("$.[*].titreImprintEn").value(hasItem(DEFAULT_TITRE_IMPRINT_EN)))
            .andExpect(jsonPath("$.[*].titreImprintFr").value(hasItem(DEFAULT_TITRE_IMPRINT_FR)))
            .andExpect(jsonPath("$.[*].titreImprintGer").value(hasItem(DEFAULT_TITRE_IMPRINT_GER)))
            .andExpect(jsonPath("$.[*].titreImprintSw").value(hasItem(DEFAULT_TITRE_IMPRINT_SW)))
            .andExpect(jsonPath("$.[*].contenuImprintEn").value(hasItem(DEFAULT_CONTENU_IMPRINT_EN)))
            .andExpect(jsonPath("$.[*].contenuImprintGer").value(hasItem(DEFAULT_CONTENU_IMPRINT_GER)))
            .andExpect(jsonPath("$.[*].contenuImprintFr").value(hasItem(DEFAULT_CONTENU_IMPRINT_FR)))
            .andExpect(jsonPath("$.[*].contenuImprintSw").value(hasItem(DEFAULT_CONTENU_IMPRINT_SW)));
    }
    
    @Test
    @Transactional
    public void getImprint() throws Exception {
        // Initialize the database
        imprintRepository.saveAndFlush(imprint);

        // Get the imprint
        restImprintMockMvc.perform(get("/api/imprints/{id}", imprint.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(imprint.getId().intValue()))
            .andExpect(jsonPath("$.titreImprintEn").value(DEFAULT_TITRE_IMPRINT_EN))
            .andExpect(jsonPath("$.titreImprintFr").value(DEFAULT_TITRE_IMPRINT_FR))
            .andExpect(jsonPath("$.titreImprintGer").value(DEFAULT_TITRE_IMPRINT_GER))
            .andExpect(jsonPath("$.titreImprintSw").value(DEFAULT_TITRE_IMPRINT_SW))
            .andExpect(jsonPath("$.contenuImprintEn").value(DEFAULT_CONTENU_IMPRINT_EN))
            .andExpect(jsonPath("$.contenuImprintGer").value(DEFAULT_CONTENU_IMPRINT_GER))
            .andExpect(jsonPath("$.contenuImprintFr").value(DEFAULT_CONTENU_IMPRINT_FR))
            .andExpect(jsonPath("$.contenuImprintSw").value(DEFAULT_CONTENU_IMPRINT_SW));
    }

    @Test
    @Transactional
    public void getNonExistingImprint() throws Exception {
        // Get the imprint
        restImprintMockMvc.perform(get("/api/imprints/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateImprint() throws Exception {
        // Initialize the database
        imprintRepository.saveAndFlush(imprint);

        int databaseSizeBeforeUpdate = imprintRepository.findAll().size();

        // Update the imprint
        Imprint updatedImprint = imprintRepository.findById(imprint.getId()).get();
        // Disconnect from session so that the updates on updatedImprint are not directly saved in db
        em.detach(updatedImprint);
        updatedImprint
            .titreImprintEn(UPDATED_TITRE_IMPRINT_EN)
            .titreImprintFr(UPDATED_TITRE_IMPRINT_FR)
            .titreImprintGer(UPDATED_TITRE_IMPRINT_GER)
            .titreImprintSw(UPDATED_TITRE_IMPRINT_SW)
            .contenuImprintEn(UPDATED_CONTENU_IMPRINT_EN)
            .contenuImprintGer(UPDATED_CONTENU_IMPRINT_GER)
            .contenuImprintFr(UPDATED_CONTENU_IMPRINT_FR)
            .contenuImprintSw(UPDATED_CONTENU_IMPRINT_SW);

        restImprintMockMvc.perform(put("/api/imprints")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(updatedImprint)))
            .andExpect(status().isOk());

        // Validate the Imprint in the database
        List<Imprint> imprintList = imprintRepository.findAll();
        assertThat(imprintList).hasSize(databaseSizeBeforeUpdate);
        Imprint testImprint = imprintList.get(imprintList.size() - 1);
        assertThat(testImprint.getTitreImprintEn()).isEqualTo(UPDATED_TITRE_IMPRINT_EN);
        assertThat(testImprint.getTitreImprintFr()).isEqualTo(UPDATED_TITRE_IMPRINT_FR);
        assertThat(testImprint.getTitreImprintGer()).isEqualTo(UPDATED_TITRE_IMPRINT_GER);
        assertThat(testImprint.getTitreImprintSw()).isEqualTo(UPDATED_TITRE_IMPRINT_SW);
        assertThat(testImprint.getContenuImprintEn()).isEqualTo(UPDATED_CONTENU_IMPRINT_EN);
        assertThat(testImprint.getContenuImprintGer()).isEqualTo(UPDATED_CONTENU_IMPRINT_GER);
        assertThat(testImprint.getContenuImprintFr()).isEqualTo(UPDATED_CONTENU_IMPRINT_FR);
        assertThat(testImprint.getContenuImprintSw()).isEqualTo(UPDATED_CONTENU_IMPRINT_SW);
    }

    @Test
    @Transactional
    public void updateNonExistingImprint() throws Exception {
        int databaseSizeBeforeUpdate = imprintRepository.findAll().size();

        // Create the Imprint

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restImprintMockMvc.perform(put("/api/imprints")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(imprint)))
            .andExpect(status().isBadRequest());

        // Validate the Imprint in the database
        List<Imprint> imprintList = imprintRepository.findAll();
        assertThat(imprintList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteImprint() throws Exception {
        // Initialize the database
        imprintRepository.saveAndFlush(imprint);

        int databaseSizeBeforeDelete = imprintRepository.findAll().size();

        // Delete the imprint
        restImprintMockMvc.perform(delete("/api/imprints/{id}", imprint.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<Imprint> imprintList = imprintRepository.findAll();
        assertThat(imprintList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
