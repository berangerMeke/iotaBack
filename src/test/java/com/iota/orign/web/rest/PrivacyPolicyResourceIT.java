package com.iota.orign.web.rest;

import com.iota.orign.IotaOrignAdminApp;
import com.iota.orign.domain.PrivacyPolicy;
import com.iota.orign.repository.PrivacyPolicyRepository;

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
 * Integration tests for the {@link PrivacyPolicyResource} REST controller.
 */
@SpringBootTest(classes = IotaOrignAdminApp.class)

@AutoConfigureMockMvc
@WithMockUser
public class PrivacyPolicyResourceIT {

    private static final String DEFAULT_TITRE_PRIVACY_POLICY_EN = "AAAAAAAAAA";
    private static final String UPDATED_TITRE_PRIVACY_POLICY_EN = "BBBBBBBBBB";

    private static final String DEFAULT_TITRE_PRIVACY_POLICY_GER = "AAAAAAAAAA";
    private static final String UPDATED_TITRE_PRIVACY_POLICY_GER = "BBBBBBBBBB";

    private static final String DEFAULT_TITRE_PRIVACY_POLICY_FR = "AAAAAAAAAA";
    private static final String UPDATED_TITRE_PRIVACY_POLICY_FR = "BBBBBBBBBB";

    private static final String DEFAULT_TITRE_PRIVACY_POLICY_SW = "AAAAAAAAAA";
    private static final String UPDATED_TITRE_PRIVACY_POLICY_SW = "BBBBBBBBBB";

    private static final String DEFAULT_CONTENU_PRIVACY_POLICY_EN = "AAAAAAAAAA";
    private static final String UPDATED_CONTENU_PRIVACY_POLICY_EN = "BBBBBBBBBB";

    private static final String DEFAULT_CONTENU_PRIVACY_POLICY_GER = "AAAAAAAAAA";
    private static final String UPDATED_CONTENU_PRIVACY_POLICY_GER = "BBBBBBBBBB";

    private static final String DEFAULT_CONTENU_PRIVACY_POLICY_FR = "AAAAAAAAAA";
    private static final String UPDATED_CONTENU_PRIVACY_POLICY_FR = "BBBBBBBBBB";

    private static final String DEFAULT_CONTENU_PRIVACY_POLICY_SW = "AAAAAAAAAA";
    private static final String UPDATED_CONTENU_PRIVACY_POLICY_SW = "BBBBBBBBBB";

    @Autowired
    private PrivacyPolicyRepository privacyPolicyRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restPrivacyPolicyMockMvc;

    private PrivacyPolicy privacyPolicy;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static PrivacyPolicy createEntity(EntityManager em) {
        PrivacyPolicy privacyPolicy = new PrivacyPolicy()
            .titrePrivacyPolicyEn(DEFAULT_TITRE_PRIVACY_POLICY_EN)
            .titrePrivacyPolicyGer(DEFAULT_TITRE_PRIVACY_POLICY_GER)
            .titrePrivacyPolicyFr(DEFAULT_TITRE_PRIVACY_POLICY_FR)
            .titrePrivacyPolicySw(DEFAULT_TITRE_PRIVACY_POLICY_SW)
            .contenuPrivacyPolicyEn(DEFAULT_CONTENU_PRIVACY_POLICY_EN)
            .contenuPrivacyPolicyGer(DEFAULT_CONTENU_PRIVACY_POLICY_GER)
            .contenuPrivacyPolicyFr(DEFAULT_CONTENU_PRIVACY_POLICY_FR)
            .contenuPrivacyPolicySw(DEFAULT_CONTENU_PRIVACY_POLICY_SW);
        return privacyPolicy;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static PrivacyPolicy createUpdatedEntity(EntityManager em) {
        PrivacyPolicy privacyPolicy = new PrivacyPolicy()
            .titrePrivacyPolicyEn(UPDATED_TITRE_PRIVACY_POLICY_EN)
            .titrePrivacyPolicyGer(UPDATED_TITRE_PRIVACY_POLICY_GER)
            .titrePrivacyPolicyFr(UPDATED_TITRE_PRIVACY_POLICY_FR)
            .titrePrivacyPolicySw(UPDATED_TITRE_PRIVACY_POLICY_SW)
            .contenuPrivacyPolicyEn(UPDATED_CONTENU_PRIVACY_POLICY_EN)
            .contenuPrivacyPolicyGer(UPDATED_CONTENU_PRIVACY_POLICY_GER)
            .contenuPrivacyPolicyFr(UPDATED_CONTENU_PRIVACY_POLICY_FR)
            .contenuPrivacyPolicySw(UPDATED_CONTENU_PRIVACY_POLICY_SW);
        return privacyPolicy;
    }

    @BeforeEach
    public void initTest() {
        privacyPolicy = createEntity(em);
    }

    @Test
    @Transactional
    public void createPrivacyPolicy() throws Exception {
        int databaseSizeBeforeCreate = privacyPolicyRepository.findAll().size();

        // Create the PrivacyPolicy
        restPrivacyPolicyMockMvc.perform(post("/api/privacy-policies")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(privacyPolicy)))
            .andExpect(status().isCreated());

        // Validate the PrivacyPolicy in the database
        List<PrivacyPolicy> privacyPolicyList = privacyPolicyRepository.findAll();
        assertThat(privacyPolicyList).hasSize(databaseSizeBeforeCreate + 1);
        PrivacyPolicy testPrivacyPolicy = privacyPolicyList.get(privacyPolicyList.size() - 1);
        assertThat(testPrivacyPolicy.getTitrePrivacyPolicyEn()).isEqualTo(DEFAULT_TITRE_PRIVACY_POLICY_EN);
        assertThat(testPrivacyPolicy.getTitrePrivacyPolicyGer()).isEqualTo(DEFAULT_TITRE_PRIVACY_POLICY_GER);
        assertThat(testPrivacyPolicy.getTitrePrivacyPolicyFr()).isEqualTo(DEFAULT_TITRE_PRIVACY_POLICY_FR);
        assertThat(testPrivacyPolicy.getTitrePrivacyPolicySw()).isEqualTo(DEFAULT_TITRE_PRIVACY_POLICY_SW);
        assertThat(testPrivacyPolicy.getContenuPrivacyPolicyEn()).isEqualTo(DEFAULT_CONTENU_PRIVACY_POLICY_EN);
        assertThat(testPrivacyPolicy.getContenuPrivacyPolicyGer()).isEqualTo(DEFAULT_CONTENU_PRIVACY_POLICY_GER);
        assertThat(testPrivacyPolicy.getContenuPrivacyPolicyFr()).isEqualTo(DEFAULT_CONTENU_PRIVACY_POLICY_FR);
        assertThat(testPrivacyPolicy.getContenuPrivacyPolicySw()).isEqualTo(DEFAULT_CONTENU_PRIVACY_POLICY_SW);
    }

    @Test
    @Transactional
    public void createPrivacyPolicyWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = privacyPolicyRepository.findAll().size();

        // Create the PrivacyPolicy with an existing ID
        privacyPolicy.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restPrivacyPolicyMockMvc.perform(post("/api/privacy-policies")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(privacyPolicy)))
            .andExpect(status().isBadRequest());

        // Validate the PrivacyPolicy in the database
        List<PrivacyPolicy> privacyPolicyList = privacyPolicyRepository.findAll();
        assertThat(privacyPolicyList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllPrivacyPolicies() throws Exception {
        // Initialize the database
        privacyPolicyRepository.saveAndFlush(privacyPolicy);

        // Get all the privacyPolicyList
        restPrivacyPolicyMockMvc.perform(get("/api/privacy-policies?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(privacyPolicy.getId().intValue())))
            .andExpect(jsonPath("$.[*].titrePrivacyPolicyEn").value(hasItem(DEFAULT_TITRE_PRIVACY_POLICY_EN)))
            .andExpect(jsonPath("$.[*].titrePrivacyPolicyGer").value(hasItem(DEFAULT_TITRE_PRIVACY_POLICY_GER)))
            .andExpect(jsonPath("$.[*].titrePrivacyPolicyFr").value(hasItem(DEFAULT_TITRE_PRIVACY_POLICY_FR)))
            .andExpect(jsonPath("$.[*].titrePrivacyPolicySw").value(hasItem(DEFAULT_TITRE_PRIVACY_POLICY_SW)))
            .andExpect(jsonPath("$.[*].contenuPrivacyPolicyEn").value(hasItem(DEFAULT_CONTENU_PRIVACY_POLICY_EN)))
            .andExpect(jsonPath("$.[*].contenuPrivacyPolicyGer").value(hasItem(DEFAULT_CONTENU_PRIVACY_POLICY_GER)))
            .andExpect(jsonPath("$.[*].contenuPrivacyPolicyFr").value(hasItem(DEFAULT_CONTENU_PRIVACY_POLICY_FR)))
            .andExpect(jsonPath("$.[*].contenuPrivacyPolicySw").value(hasItem(DEFAULT_CONTENU_PRIVACY_POLICY_SW)));
    }
    
    @Test
    @Transactional
    public void getPrivacyPolicy() throws Exception {
        // Initialize the database
        privacyPolicyRepository.saveAndFlush(privacyPolicy);

        // Get the privacyPolicy
        restPrivacyPolicyMockMvc.perform(get("/api/privacy-policies/{id}", privacyPolicy.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(privacyPolicy.getId().intValue()))
            .andExpect(jsonPath("$.titrePrivacyPolicyEn").value(DEFAULT_TITRE_PRIVACY_POLICY_EN))
            .andExpect(jsonPath("$.titrePrivacyPolicyGer").value(DEFAULT_TITRE_PRIVACY_POLICY_GER))
            .andExpect(jsonPath("$.titrePrivacyPolicyFr").value(DEFAULT_TITRE_PRIVACY_POLICY_FR))
            .andExpect(jsonPath("$.titrePrivacyPolicySw").value(DEFAULT_TITRE_PRIVACY_POLICY_SW))
            .andExpect(jsonPath("$.contenuPrivacyPolicyEn").value(DEFAULT_CONTENU_PRIVACY_POLICY_EN))
            .andExpect(jsonPath("$.contenuPrivacyPolicyGer").value(DEFAULT_CONTENU_PRIVACY_POLICY_GER))
            .andExpect(jsonPath("$.contenuPrivacyPolicyFr").value(DEFAULT_CONTENU_PRIVACY_POLICY_FR))
            .andExpect(jsonPath("$.contenuPrivacyPolicySw").value(DEFAULT_CONTENU_PRIVACY_POLICY_SW));
    }

    @Test
    @Transactional
    public void getNonExistingPrivacyPolicy() throws Exception {
        // Get the privacyPolicy
        restPrivacyPolicyMockMvc.perform(get("/api/privacy-policies/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updatePrivacyPolicy() throws Exception {
        // Initialize the database
        privacyPolicyRepository.saveAndFlush(privacyPolicy);

        int databaseSizeBeforeUpdate = privacyPolicyRepository.findAll().size();

        // Update the privacyPolicy
        PrivacyPolicy updatedPrivacyPolicy = privacyPolicyRepository.findById(privacyPolicy.getId()).get();
        // Disconnect from session so that the updates on updatedPrivacyPolicy are not directly saved in db
        em.detach(updatedPrivacyPolicy);
        updatedPrivacyPolicy
            .titrePrivacyPolicyEn(UPDATED_TITRE_PRIVACY_POLICY_EN)
            .titrePrivacyPolicyGer(UPDATED_TITRE_PRIVACY_POLICY_GER)
            .titrePrivacyPolicyFr(UPDATED_TITRE_PRIVACY_POLICY_FR)
            .titrePrivacyPolicySw(UPDATED_TITRE_PRIVACY_POLICY_SW)
            .contenuPrivacyPolicyEn(UPDATED_CONTENU_PRIVACY_POLICY_EN)
            .contenuPrivacyPolicyGer(UPDATED_CONTENU_PRIVACY_POLICY_GER)
            .contenuPrivacyPolicyFr(UPDATED_CONTENU_PRIVACY_POLICY_FR)
            .contenuPrivacyPolicySw(UPDATED_CONTENU_PRIVACY_POLICY_SW);

        restPrivacyPolicyMockMvc.perform(put("/api/privacy-policies")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(updatedPrivacyPolicy)))
            .andExpect(status().isOk());

        // Validate the PrivacyPolicy in the database
        List<PrivacyPolicy> privacyPolicyList = privacyPolicyRepository.findAll();
        assertThat(privacyPolicyList).hasSize(databaseSizeBeforeUpdate);
        PrivacyPolicy testPrivacyPolicy = privacyPolicyList.get(privacyPolicyList.size() - 1);
        assertThat(testPrivacyPolicy.getTitrePrivacyPolicyEn()).isEqualTo(UPDATED_TITRE_PRIVACY_POLICY_EN);
        assertThat(testPrivacyPolicy.getTitrePrivacyPolicyGer()).isEqualTo(UPDATED_TITRE_PRIVACY_POLICY_GER);
        assertThat(testPrivacyPolicy.getTitrePrivacyPolicyFr()).isEqualTo(UPDATED_TITRE_PRIVACY_POLICY_FR);
        assertThat(testPrivacyPolicy.getTitrePrivacyPolicySw()).isEqualTo(UPDATED_TITRE_PRIVACY_POLICY_SW);
        assertThat(testPrivacyPolicy.getContenuPrivacyPolicyEn()).isEqualTo(UPDATED_CONTENU_PRIVACY_POLICY_EN);
        assertThat(testPrivacyPolicy.getContenuPrivacyPolicyGer()).isEqualTo(UPDATED_CONTENU_PRIVACY_POLICY_GER);
        assertThat(testPrivacyPolicy.getContenuPrivacyPolicyFr()).isEqualTo(UPDATED_CONTENU_PRIVACY_POLICY_FR);
        assertThat(testPrivacyPolicy.getContenuPrivacyPolicySw()).isEqualTo(UPDATED_CONTENU_PRIVACY_POLICY_SW);
    }

    @Test
    @Transactional
    public void updateNonExistingPrivacyPolicy() throws Exception {
        int databaseSizeBeforeUpdate = privacyPolicyRepository.findAll().size();

        // Create the PrivacyPolicy

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restPrivacyPolicyMockMvc.perform(put("/api/privacy-policies")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(privacyPolicy)))
            .andExpect(status().isBadRequest());

        // Validate the PrivacyPolicy in the database
        List<PrivacyPolicy> privacyPolicyList = privacyPolicyRepository.findAll();
        assertThat(privacyPolicyList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deletePrivacyPolicy() throws Exception {
        // Initialize the database
        privacyPolicyRepository.saveAndFlush(privacyPolicy);

        int databaseSizeBeforeDelete = privacyPolicyRepository.findAll().size();

        // Delete the privacyPolicy
        restPrivacyPolicyMockMvc.perform(delete("/api/privacy-policies/{id}", privacyPolicy.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<PrivacyPolicy> privacyPolicyList = privacyPolicyRepository.findAll();
        assertThat(privacyPolicyList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
