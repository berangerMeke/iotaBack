package com.iota.orign.web.rest;

import com.iota.orign.IotaOrignAdminApp;
import com.iota.orign.domain.Accueil;
import com.iota.orign.repository.AccueilRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Base64Utils;
import javax.persistence.EntityManager;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for the {@link AccueilResource} REST controller.
 */
@SpringBootTest(classes = IotaOrignAdminApp.class)

@AutoConfigureMockMvc
@WithMockUser
public class AccueilResourceIT {

    private static final String DEFAULT_TITRE_FR = "AAAAAAAAAA";
    private static final String UPDATED_TITRE_FR = "BBBBBBBBBB";

    private static final String DEFAULT_TITRE_EN = "AAAAAAAAAA";
    private static final String UPDATED_TITRE_EN = "BBBBBBBBBB";

    private static final String DEFAULT_TITRE_GER = "AAAAAAAAAA";
    private static final String UPDATED_TITRE_GER = "BBBBBBBBBB";

    private static final String DEFAULT_TITRE_SW = "AAAAAAAAAA";
    private static final String UPDATED_TITRE_SW = "BBBBBBBBBB";

    private static final String DEFAULT_SOUS_TITRE_FR = "AAAAAAAAAA";
    private static final String UPDATED_SOUS_TITRE_FR = "BBBBBBBBBB";

    private static final String DEFAULT_SOUS_TITRE_EN = "AAAAAAAAAA";
    private static final String UPDATED_SOUS_TITRE_EN = "BBBBBBBBBB";

    private static final String DEFAULT_SOUS_TITRE_GER = "AAAAAAAAAA";
    private static final String UPDATED_SOUS_TITRE_GER = "BBBBBBBBBB";

    private static final String DEFAULT_SOUS_TITRE_SW = "AAAAAAAAAA";
    private static final String UPDATED_SOUS_TITRE_SW = "BBBBBBBBBB";

    private static final byte[] DEFAULT_IMAGE = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_IMAGE = TestUtil.createByteArray(1, "1");
    private static final String DEFAULT_IMAGE_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_IMAGE_CONTENT_TYPE = "image/png";

    @Autowired
    private AccueilRepository accueilRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restAccueilMockMvc;

    private Accueil accueil;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Accueil createEntity(EntityManager em) {
        Accueil accueil = new Accueil()
            .titreFr(DEFAULT_TITRE_FR)
            .titreEn(DEFAULT_TITRE_EN)
            .titreGer(DEFAULT_TITRE_GER)
            .titreSw(DEFAULT_TITRE_SW)
            .sousTitreFr(DEFAULT_SOUS_TITRE_FR)
            .sousTitreEn(DEFAULT_SOUS_TITRE_EN)
            .sousTitreGer(DEFAULT_SOUS_TITRE_GER)
            .sousTitreSw(DEFAULT_SOUS_TITRE_SW)
            .image(DEFAULT_IMAGE)
            .imageContentType(DEFAULT_IMAGE_CONTENT_TYPE);
        return accueil;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Accueil createUpdatedEntity(EntityManager em) {
        Accueil accueil = new Accueil()
            .titreFr(UPDATED_TITRE_FR)
            .titreEn(UPDATED_TITRE_EN)
            .titreGer(UPDATED_TITRE_GER)
            .titreSw(UPDATED_TITRE_SW)
            .sousTitreFr(UPDATED_SOUS_TITRE_FR)
            .sousTitreEn(UPDATED_SOUS_TITRE_EN)
            .sousTitreGer(UPDATED_SOUS_TITRE_GER)
            .sousTitreSw(UPDATED_SOUS_TITRE_SW)
            .image(UPDATED_IMAGE)
            .imageContentType(UPDATED_IMAGE_CONTENT_TYPE);
        return accueil;
    }

    @BeforeEach
    public void initTest() {
        accueil = createEntity(em);
    }

    @Test
    @Transactional
    public void createAccueil() throws Exception {
        int databaseSizeBeforeCreate = accueilRepository.findAll().size();

        // Create the Accueil
        restAccueilMockMvc.perform(post("/api/accueils")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(accueil)))
            .andExpect(status().isCreated());

        // Validate the Accueil in the database
        List<Accueil> accueilList = accueilRepository.findAll();
        assertThat(accueilList).hasSize(databaseSizeBeforeCreate + 1);
        Accueil testAccueil = accueilList.get(accueilList.size() - 1);
        assertThat(testAccueil.getTitreFr()).isEqualTo(DEFAULT_TITRE_FR);
        assertThat(testAccueil.getTitreEn()).isEqualTo(DEFAULT_TITRE_EN);
        assertThat(testAccueil.getTitreGer()).isEqualTo(DEFAULT_TITRE_GER);
        assertThat(testAccueil.getTitreSw()).isEqualTo(DEFAULT_TITRE_SW);
        assertThat(testAccueil.getSousTitreFr()).isEqualTo(DEFAULT_SOUS_TITRE_FR);
        assertThat(testAccueil.getSousTitreEn()).isEqualTo(DEFAULT_SOUS_TITRE_EN);
        assertThat(testAccueil.getSousTitreGer()).isEqualTo(DEFAULT_SOUS_TITRE_GER);
        assertThat(testAccueil.getSousTitreSw()).isEqualTo(DEFAULT_SOUS_TITRE_SW);
        assertThat(testAccueil.getImage()).isEqualTo(DEFAULT_IMAGE);
        assertThat(testAccueil.getImageContentType()).isEqualTo(DEFAULT_IMAGE_CONTENT_TYPE);
    }

    @Test
    @Transactional
    public void createAccueilWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = accueilRepository.findAll().size();

        // Create the Accueil with an existing ID
        accueil.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restAccueilMockMvc.perform(post("/api/accueils")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(accueil)))
            .andExpect(status().isBadRequest());

        // Validate the Accueil in the database
        List<Accueil> accueilList = accueilRepository.findAll();
        assertThat(accueilList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllAccueils() throws Exception {
        // Initialize the database
        accueilRepository.saveAndFlush(accueil);

        // Get all the accueilList
        restAccueilMockMvc.perform(get("/api/accueils?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(accueil.getId().intValue())))
            .andExpect(jsonPath("$.[*].titreFr").value(hasItem(DEFAULT_TITRE_FR)))
            .andExpect(jsonPath("$.[*].titreEn").value(hasItem(DEFAULT_TITRE_EN)))
            .andExpect(jsonPath("$.[*].titreGer").value(hasItem(DEFAULT_TITRE_GER)))
            .andExpect(jsonPath("$.[*].titreSw").value(hasItem(DEFAULT_TITRE_SW)))
            .andExpect(jsonPath("$.[*].sousTitreFr").value(hasItem(DEFAULT_SOUS_TITRE_FR)))
            .andExpect(jsonPath("$.[*].sousTitreEn").value(hasItem(DEFAULT_SOUS_TITRE_EN)))
            .andExpect(jsonPath("$.[*].sousTitreGer").value(hasItem(DEFAULT_SOUS_TITRE_GER)))
            .andExpect(jsonPath("$.[*].sousTitreSw").value(hasItem(DEFAULT_SOUS_TITRE_SW)))
            .andExpect(jsonPath("$.[*].imageContentType").value(hasItem(DEFAULT_IMAGE_CONTENT_TYPE)))
            .andExpect(jsonPath("$.[*].image").value(hasItem(Base64Utils.encodeToString(DEFAULT_IMAGE))));
    }
    
    @Test
    @Transactional
    public void getAccueil() throws Exception {
        // Initialize the database
        accueilRepository.saveAndFlush(accueil);

        // Get the accueil
        restAccueilMockMvc.perform(get("/api/accueils/{id}", accueil.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(accueil.getId().intValue()))
            .andExpect(jsonPath("$.titreFr").value(DEFAULT_TITRE_FR))
            .andExpect(jsonPath("$.titreEn").value(DEFAULT_TITRE_EN))
            .andExpect(jsonPath("$.titreGer").value(DEFAULT_TITRE_GER))
            .andExpect(jsonPath("$.titreSw").value(DEFAULT_TITRE_SW))
            .andExpect(jsonPath("$.sousTitreFr").value(DEFAULT_SOUS_TITRE_FR))
            .andExpect(jsonPath("$.sousTitreEn").value(DEFAULT_SOUS_TITRE_EN))
            .andExpect(jsonPath("$.sousTitreGer").value(DEFAULT_SOUS_TITRE_GER))
            .andExpect(jsonPath("$.sousTitreSw").value(DEFAULT_SOUS_TITRE_SW))
            .andExpect(jsonPath("$.imageContentType").value(DEFAULT_IMAGE_CONTENT_TYPE))
            .andExpect(jsonPath("$.image").value(Base64Utils.encodeToString(DEFAULT_IMAGE)));
    }

    @Test
    @Transactional
    public void getNonExistingAccueil() throws Exception {
        // Get the accueil
        restAccueilMockMvc.perform(get("/api/accueils/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateAccueil() throws Exception {
        // Initialize the database
        accueilRepository.saveAndFlush(accueil);

        int databaseSizeBeforeUpdate = accueilRepository.findAll().size();

        // Update the accueil
        Accueil updatedAccueil = accueilRepository.findById(accueil.getId()).get();
        // Disconnect from session so that the updates on updatedAccueil are not directly saved in db
        em.detach(updatedAccueil);
        updatedAccueil
            .titreFr(UPDATED_TITRE_FR)
            .titreEn(UPDATED_TITRE_EN)
            .titreGer(UPDATED_TITRE_GER)
            .titreSw(UPDATED_TITRE_SW)
            .sousTitreFr(UPDATED_SOUS_TITRE_FR)
            .sousTitreEn(UPDATED_SOUS_TITRE_EN)
            .sousTitreGer(UPDATED_SOUS_TITRE_GER)
            .sousTitreSw(UPDATED_SOUS_TITRE_SW)
            .image(UPDATED_IMAGE)
            .imageContentType(UPDATED_IMAGE_CONTENT_TYPE);

        restAccueilMockMvc.perform(put("/api/accueils")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(updatedAccueil)))
            .andExpect(status().isOk());

        // Validate the Accueil in the database
        List<Accueil> accueilList = accueilRepository.findAll();
        assertThat(accueilList).hasSize(databaseSizeBeforeUpdate);
        Accueil testAccueil = accueilList.get(accueilList.size() - 1);
        assertThat(testAccueil.getTitreFr()).isEqualTo(UPDATED_TITRE_FR);
        assertThat(testAccueil.getTitreEn()).isEqualTo(UPDATED_TITRE_EN);
        assertThat(testAccueil.getTitreGer()).isEqualTo(UPDATED_TITRE_GER);
        assertThat(testAccueil.getTitreSw()).isEqualTo(UPDATED_TITRE_SW);
        assertThat(testAccueil.getSousTitreFr()).isEqualTo(UPDATED_SOUS_TITRE_FR);
        assertThat(testAccueil.getSousTitreEn()).isEqualTo(UPDATED_SOUS_TITRE_EN);
        assertThat(testAccueil.getSousTitreGer()).isEqualTo(UPDATED_SOUS_TITRE_GER);
        assertThat(testAccueil.getSousTitreSw()).isEqualTo(UPDATED_SOUS_TITRE_SW);
        assertThat(testAccueil.getImage()).isEqualTo(UPDATED_IMAGE);
        assertThat(testAccueil.getImageContentType()).isEqualTo(UPDATED_IMAGE_CONTENT_TYPE);
    }

    @Test
    @Transactional
    public void updateNonExistingAccueil() throws Exception {
        int databaseSizeBeforeUpdate = accueilRepository.findAll().size();

        // Create the Accueil

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restAccueilMockMvc.perform(put("/api/accueils")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(accueil)))
            .andExpect(status().isBadRequest());

        // Validate the Accueil in the database
        List<Accueil> accueilList = accueilRepository.findAll();
        assertThat(accueilList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteAccueil() throws Exception {
        // Initialize the database
        accueilRepository.saveAndFlush(accueil);

        int databaseSizeBeforeDelete = accueilRepository.findAll().size();

        // Delete the accueil
        restAccueilMockMvc.perform(delete("/api/accueils/{id}", accueil.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<Accueil> accueilList = accueilRepository.findAll();
        assertThat(accueilList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
