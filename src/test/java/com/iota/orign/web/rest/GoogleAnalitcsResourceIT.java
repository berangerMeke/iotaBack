package com.iota.orign.web.rest;

import com.iota.orign.IotaOrignAdminApp;
import com.iota.orign.domain.GoogleAnalitcs;
import com.iota.orign.repository.GoogleAnalitcsRepository;

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
 * Integration tests for the {@link GoogleAnalitcsResource} REST controller.
 */
@SpringBootTest(classes = IotaOrignAdminApp.class)

@AutoConfigureMockMvc
@WithMockUser
public class GoogleAnalitcsResourceIT {

    private static final String DEFAULT_GOOGLE_ANALYTICS_ID = "AAAAAAAAAA";
    private static final String UPDATED_GOOGLE_ANALYTICS_ID = "BBBBBBBBBB";

    @Autowired
    private GoogleAnalitcsRepository googleAnalitcsRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restGoogleAnalitcsMockMvc;

    private GoogleAnalitcs googleAnalitcs;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static GoogleAnalitcs createEntity(EntityManager em) {
        GoogleAnalitcs googleAnalitcs = new GoogleAnalitcs()
            .googleAnalyticsID(DEFAULT_GOOGLE_ANALYTICS_ID);
        return googleAnalitcs;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static GoogleAnalitcs createUpdatedEntity(EntityManager em) {
        GoogleAnalitcs googleAnalitcs = new GoogleAnalitcs()
            .googleAnalyticsID(UPDATED_GOOGLE_ANALYTICS_ID);
        return googleAnalitcs;
    }

    @BeforeEach
    public void initTest() {
        googleAnalitcs = createEntity(em);
    }

    @Test
    @Transactional
    public void createGoogleAnalitcs() throws Exception {
        int databaseSizeBeforeCreate = googleAnalitcsRepository.findAll().size();

        // Create the GoogleAnalitcs
        restGoogleAnalitcsMockMvc.perform(post("/api/google-analitcs")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(googleAnalitcs)))
            .andExpect(status().isCreated());

        // Validate the GoogleAnalitcs in the database
        List<GoogleAnalitcs> googleAnalitcsList = googleAnalitcsRepository.findAll();
        assertThat(googleAnalitcsList).hasSize(databaseSizeBeforeCreate + 1);
        GoogleAnalitcs testGoogleAnalitcs = googleAnalitcsList.get(googleAnalitcsList.size() - 1);
        assertThat(testGoogleAnalitcs.getGoogleAnalyticsID()).isEqualTo(DEFAULT_GOOGLE_ANALYTICS_ID);
    }

    @Test
    @Transactional
    public void createGoogleAnalitcsWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = googleAnalitcsRepository.findAll().size();

        // Create the GoogleAnalitcs with an existing ID
        googleAnalitcs.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restGoogleAnalitcsMockMvc.perform(post("/api/google-analitcs")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(googleAnalitcs)))
            .andExpect(status().isBadRequest());

        // Validate the GoogleAnalitcs in the database
        List<GoogleAnalitcs> googleAnalitcsList = googleAnalitcsRepository.findAll();
        assertThat(googleAnalitcsList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void checkGoogleAnalyticsIDIsRequired() throws Exception {
        int databaseSizeBeforeTest = googleAnalitcsRepository.findAll().size();
        // set the field null
        googleAnalitcs.setGoogleAnalyticsID(null);

        // Create the GoogleAnalitcs, which fails.

        restGoogleAnalitcsMockMvc.perform(post("/api/google-analitcs")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(googleAnalitcs)))
            .andExpect(status().isBadRequest());

        List<GoogleAnalitcs> googleAnalitcsList = googleAnalitcsRepository.findAll();
        assertThat(googleAnalitcsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllGoogleAnalitcs() throws Exception {
        // Initialize the database
        googleAnalitcsRepository.saveAndFlush(googleAnalitcs);

        // Get all the googleAnalitcsList
        restGoogleAnalitcsMockMvc.perform(get("/api/google-analitcs?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(googleAnalitcs.getId().intValue())))
            .andExpect(jsonPath("$.[*].googleAnalyticsID").value(hasItem(DEFAULT_GOOGLE_ANALYTICS_ID)));
    }
    
    @Test
    @Transactional
    public void getGoogleAnalitcs() throws Exception {
        // Initialize the database
        googleAnalitcsRepository.saveAndFlush(googleAnalitcs);

        // Get the googleAnalitcs
        restGoogleAnalitcsMockMvc.perform(get("/api/google-analitcs/{id}", googleAnalitcs.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(googleAnalitcs.getId().intValue()))
            .andExpect(jsonPath("$.googleAnalyticsID").value(DEFAULT_GOOGLE_ANALYTICS_ID));
    }

    @Test
    @Transactional
    public void getNonExistingGoogleAnalitcs() throws Exception {
        // Get the googleAnalitcs
        restGoogleAnalitcsMockMvc.perform(get("/api/google-analitcs/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateGoogleAnalitcs() throws Exception {
        // Initialize the database
        googleAnalitcsRepository.saveAndFlush(googleAnalitcs);

        int databaseSizeBeforeUpdate = googleAnalitcsRepository.findAll().size();

        // Update the googleAnalitcs
        GoogleAnalitcs updatedGoogleAnalitcs = googleAnalitcsRepository.findById(googleAnalitcs.getId()).get();
        // Disconnect from session so that the updates on updatedGoogleAnalitcs are not directly saved in db
        em.detach(updatedGoogleAnalitcs);
        updatedGoogleAnalitcs
            .googleAnalyticsID(UPDATED_GOOGLE_ANALYTICS_ID);

        restGoogleAnalitcsMockMvc.perform(put("/api/google-analitcs")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(updatedGoogleAnalitcs)))
            .andExpect(status().isOk());

        // Validate the GoogleAnalitcs in the database
        List<GoogleAnalitcs> googleAnalitcsList = googleAnalitcsRepository.findAll();
        assertThat(googleAnalitcsList).hasSize(databaseSizeBeforeUpdate);
        GoogleAnalitcs testGoogleAnalitcs = googleAnalitcsList.get(googleAnalitcsList.size() - 1);
        assertThat(testGoogleAnalitcs.getGoogleAnalyticsID()).isEqualTo(UPDATED_GOOGLE_ANALYTICS_ID);
    }

    @Test
    @Transactional
    public void updateNonExistingGoogleAnalitcs() throws Exception {
        int databaseSizeBeforeUpdate = googleAnalitcsRepository.findAll().size();

        // Create the GoogleAnalitcs

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restGoogleAnalitcsMockMvc.perform(put("/api/google-analitcs")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(googleAnalitcs)))
            .andExpect(status().isBadRequest());

        // Validate the GoogleAnalitcs in the database
        List<GoogleAnalitcs> googleAnalitcsList = googleAnalitcsRepository.findAll();
        assertThat(googleAnalitcsList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteGoogleAnalitcs() throws Exception {
        // Initialize the database
        googleAnalitcsRepository.saveAndFlush(googleAnalitcs);

        int databaseSizeBeforeDelete = googleAnalitcsRepository.findAll().size();

        // Delete the googleAnalitcs
        restGoogleAnalitcsMockMvc.perform(delete("/api/google-analitcs/{id}", googleAnalitcs.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<GoogleAnalitcs> googleAnalitcsList = googleAnalitcsRepository.findAll();
        assertThat(googleAnalitcsList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
