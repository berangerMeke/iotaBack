package com.iota.orign.web.rest;

import com.iota.orign.IotaOrignAdminApp;
import com.iota.orign.domain.APropos;
import com.iota.orign.repository.AProposRepository;

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
 * Integration tests for the {@link AProposResource} REST controller.
 */
@SpringBootTest(classes = IotaOrignAdminApp.class)

@AutoConfigureMockMvc
@WithMockUser
public class AProposResourceIT {

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

    private static final String DEFAULT_TEXT_PARAGRAPHE_1_FR = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_PARAGRAPHE_1_FR = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_PARAGRAPHE_1_EN = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_PARAGRAPHE_1_EN = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_PARAGRAPHE_1_GER = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_PARAGRAPHE_1_GER = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_PARAGRAPHE_1_SW = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_PARAGRAPHE_1_SW = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_PARAGRAPHE_2_FR = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_PARAGRAPHE_2_FR = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_PARAGRAPHE_2_EN = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_PARAGRAPHE_2_EN = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_PARAGRAPHE_2_GER = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_PARAGRAPHE_2_GER = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_PARAGRAPHE_2_SW = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_PARAGRAPHE_2_SW = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_PARAGRAPHE_3_FR = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_PARAGRAPHE_3_FR = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_PARAGRAPHE_3_EN = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_PARAGRAPHE_3_EN = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_PARAGRAPHE_3_GER = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_PARAGRAPHE_3_GER = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_PARAGRAPHE_3_SW = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_PARAGRAPHE_3_SW = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_PARAGRAPHE_4_FR = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_PARAGRAPHE_4_FR = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_PARAGRAPHE_4_EN = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_PARAGRAPHE_4_EN = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_PARAGRAPHE_4_GER = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_PARAGRAPHE_4_GER = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_PARAGRAPHE_4_SW = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_PARAGRAPHE_4_SW = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_PARAGRAPHE_5_FR = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_PARAGRAPHE_5_FR = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_PARAGRAPHE_5_EN = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_PARAGRAPHE_5_EN = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_PARAGRAPHE_5_GER = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_PARAGRAPHE_5_GER = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_PARAGRAPHE_5_SW = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_PARAGRAPHE_5_SW = "BBBBBBBBBB";

    private static final byte[] DEFAULT_IMAGE = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_IMAGE = TestUtil.createByteArray(1, "1");
    private static final String DEFAULT_IMAGE_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_IMAGE_CONTENT_TYPE = "image/png";

    @Autowired
    private AProposRepository aProposRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restAProposMockMvc;

    private APropos aPropos;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static APropos createEntity(EntityManager em) {
        APropos aPropos = new APropos()
            .titreFr(DEFAULT_TITRE_FR)
            .titreEn(DEFAULT_TITRE_EN)
            .titreGer(DEFAULT_TITRE_GER)
            .titreSw(DEFAULT_TITRE_SW)
            .sousTitreFr(DEFAULT_SOUS_TITRE_FR)
            .sousTitreEn(DEFAULT_SOUS_TITRE_EN)
            .sousTitreGer(DEFAULT_SOUS_TITRE_GER)
            .sousTitreSw(DEFAULT_SOUS_TITRE_SW)
            .textParagraphe1Fr(DEFAULT_TEXT_PARAGRAPHE_1_FR)
            .textParagraphe1En(DEFAULT_TEXT_PARAGRAPHE_1_EN)
            .textParagraphe1Ger(DEFAULT_TEXT_PARAGRAPHE_1_GER)
            .textParagraphe1Sw(DEFAULT_TEXT_PARAGRAPHE_1_SW)
            .textParagraphe2Fr(DEFAULT_TEXT_PARAGRAPHE_2_FR)
            .textParagraphe2En(DEFAULT_TEXT_PARAGRAPHE_2_EN)
            .textParagraphe2Ger(DEFAULT_TEXT_PARAGRAPHE_2_GER)
            .textParagraphe2Sw(DEFAULT_TEXT_PARAGRAPHE_2_SW)
            .textParagraphe3Fr(DEFAULT_TEXT_PARAGRAPHE_3_FR)
            .textParagraphe3En(DEFAULT_TEXT_PARAGRAPHE_3_EN)
            .textParagraphe3Ger(DEFAULT_TEXT_PARAGRAPHE_3_GER)
            .textParagraphe3Sw(DEFAULT_TEXT_PARAGRAPHE_3_SW)
            .textParagraphe4Fr(DEFAULT_TEXT_PARAGRAPHE_4_FR)
            .textParagraphe4En(DEFAULT_TEXT_PARAGRAPHE_4_EN)
            .textParagraphe4Ger(DEFAULT_TEXT_PARAGRAPHE_4_GER)
            .textParagraphe4Sw(DEFAULT_TEXT_PARAGRAPHE_4_SW)
            .textParagraphe5Fr(DEFAULT_TEXT_PARAGRAPHE_5_FR)
            .textParagraphe5En(DEFAULT_TEXT_PARAGRAPHE_5_EN)
            .textParagraphe5Ger(DEFAULT_TEXT_PARAGRAPHE_5_GER)
            .textParagraphe5Sw(DEFAULT_TEXT_PARAGRAPHE_5_SW)
            .image(DEFAULT_IMAGE)
            .imageContentType(DEFAULT_IMAGE_CONTENT_TYPE);
        return aPropos;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static APropos createUpdatedEntity(EntityManager em) {
        APropos aPropos = new APropos()
            .titreFr(UPDATED_TITRE_FR)
            .titreEn(UPDATED_TITRE_EN)
            .titreGer(UPDATED_TITRE_GER)
            .titreSw(UPDATED_TITRE_SW)
            .sousTitreFr(UPDATED_SOUS_TITRE_FR)
            .sousTitreEn(UPDATED_SOUS_TITRE_EN)
            .sousTitreGer(UPDATED_SOUS_TITRE_GER)
            .sousTitreSw(UPDATED_SOUS_TITRE_SW)
            .textParagraphe1Fr(UPDATED_TEXT_PARAGRAPHE_1_FR)
            .textParagraphe1En(UPDATED_TEXT_PARAGRAPHE_1_EN)
            .textParagraphe1Ger(UPDATED_TEXT_PARAGRAPHE_1_GER)
            .textParagraphe1Sw(UPDATED_TEXT_PARAGRAPHE_1_SW)
            .textParagraphe2Fr(UPDATED_TEXT_PARAGRAPHE_2_FR)
            .textParagraphe2En(UPDATED_TEXT_PARAGRAPHE_2_EN)
            .textParagraphe2Ger(UPDATED_TEXT_PARAGRAPHE_2_GER)
            .textParagraphe2Sw(UPDATED_TEXT_PARAGRAPHE_2_SW)
            .textParagraphe3Fr(UPDATED_TEXT_PARAGRAPHE_3_FR)
            .textParagraphe3En(UPDATED_TEXT_PARAGRAPHE_3_EN)
            .textParagraphe3Ger(UPDATED_TEXT_PARAGRAPHE_3_GER)
            .textParagraphe3Sw(UPDATED_TEXT_PARAGRAPHE_3_SW)
            .textParagraphe4Fr(UPDATED_TEXT_PARAGRAPHE_4_FR)
            .textParagraphe4En(UPDATED_TEXT_PARAGRAPHE_4_EN)
            .textParagraphe4Ger(UPDATED_TEXT_PARAGRAPHE_4_GER)
            .textParagraphe4Sw(UPDATED_TEXT_PARAGRAPHE_4_SW)
            .textParagraphe5Fr(UPDATED_TEXT_PARAGRAPHE_5_FR)
            .textParagraphe5En(UPDATED_TEXT_PARAGRAPHE_5_EN)
            .textParagraphe5Ger(UPDATED_TEXT_PARAGRAPHE_5_GER)
            .textParagraphe5Sw(UPDATED_TEXT_PARAGRAPHE_5_SW)
            .image(UPDATED_IMAGE)
            .imageContentType(UPDATED_IMAGE_CONTENT_TYPE);
        return aPropos;
    }

    @BeforeEach
    public void initTest() {
        aPropos = createEntity(em);
    }

    @Test
    @Transactional
    public void createAPropos() throws Exception {
        int databaseSizeBeforeCreate = aProposRepository.findAll().size();

        // Create the APropos
        restAProposMockMvc.perform(post("/api/a-propos")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(aPropos)))
            .andExpect(status().isCreated());

        // Validate the APropos in the database
        List<APropos> aProposList = aProposRepository.findAll();
        assertThat(aProposList).hasSize(databaseSizeBeforeCreate + 1);
        APropos testAPropos = aProposList.get(aProposList.size() - 1);
        assertThat(testAPropos.getTitreFr()).isEqualTo(DEFAULT_TITRE_FR);
        assertThat(testAPropos.getTitreEn()).isEqualTo(DEFAULT_TITRE_EN);
        assertThat(testAPropos.getTitreGer()).isEqualTo(DEFAULT_TITRE_GER);
        assertThat(testAPropos.getTitreSw()).isEqualTo(DEFAULT_TITRE_SW);
        assertThat(testAPropos.getSousTitreFr()).isEqualTo(DEFAULT_SOUS_TITRE_FR);
        assertThat(testAPropos.getSousTitreEn()).isEqualTo(DEFAULT_SOUS_TITRE_EN);
        assertThat(testAPropos.getSousTitreGer()).isEqualTo(DEFAULT_SOUS_TITRE_GER);
        assertThat(testAPropos.getSousTitreSw()).isEqualTo(DEFAULT_SOUS_TITRE_SW);
        assertThat(testAPropos.getTextParagraphe1Fr()).isEqualTo(DEFAULT_TEXT_PARAGRAPHE_1_FR);
        assertThat(testAPropos.getTextParagraphe1En()).isEqualTo(DEFAULT_TEXT_PARAGRAPHE_1_EN);
        assertThat(testAPropos.getTextParagraphe1Ger()).isEqualTo(DEFAULT_TEXT_PARAGRAPHE_1_GER);
        assertThat(testAPropos.getTextParagraphe1Sw()).isEqualTo(DEFAULT_TEXT_PARAGRAPHE_1_SW);
        assertThat(testAPropos.getTextParagraphe2Fr()).isEqualTo(DEFAULT_TEXT_PARAGRAPHE_2_FR);
        assertThat(testAPropos.getTextParagraphe2En()).isEqualTo(DEFAULT_TEXT_PARAGRAPHE_2_EN);
        assertThat(testAPropos.getTextParagraphe2Ger()).isEqualTo(DEFAULT_TEXT_PARAGRAPHE_2_GER);
        assertThat(testAPropos.getTextParagraphe2Sw()).isEqualTo(DEFAULT_TEXT_PARAGRAPHE_2_SW);
        assertThat(testAPropos.getTextParagraphe3Fr()).isEqualTo(DEFAULT_TEXT_PARAGRAPHE_3_FR);
        assertThat(testAPropos.getTextParagraphe3En()).isEqualTo(DEFAULT_TEXT_PARAGRAPHE_3_EN);
        assertThat(testAPropos.getTextParagraphe3Ger()).isEqualTo(DEFAULT_TEXT_PARAGRAPHE_3_GER);
        assertThat(testAPropos.getTextParagraphe3Sw()).isEqualTo(DEFAULT_TEXT_PARAGRAPHE_3_SW);
        assertThat(testAPropos.getTextParagraphe4Fr()).isEqualTo(DEFAULT_TEXT_PARAGRAPHE_4_FR);
        assertThat(testAPropos.getTextParagraphe4En()).isEqualTo(DEFAULT_TEXT_PARAGRAPHE_4_EN);
        assertThat(testAPropos.getTextParagraphe4Ger()).isEqualTo(DEFAULT_TEXT_PARAGRAPHE_4_GER);
        assertThat(testAPropos.getTextParagraphe4Sw()).isEqualTo(DEFAULT_TEXT_PARAGRAPHE_4_SW);
        assertThat(testAPropos.getTextParagraphe5Fr()).isEqualTo(DEFAULT_TEXT_PARAGRAPHE_5_FR);
        assertThat(testAPropos.getTextParagraphe5En()).isEqualTo(DEFAULT_TEXT_PARAGRAPHE_5_EN);
        assertThat(testAPropos.getTextParagraphe5Ger()).isEqualTo(DEFAULT_TEXT_PARAGRAPHE_5_GER);
        assertThat(testAPropos.getTextParagraphe5Sw()).isEqualTo(DEFAULT_TEXT_PARAGRAPHE_5_SW);
        assertThat(testAPropos.getImage()).isEqualTo(DEFAULT_IMAGE);
        assertThat(testAPropos.getImageContentType()).isEqualTo(DEFAULT_IMAGE_CONTENT_TYPE);
    }

    @Test
    @Transactional
    public void createAProposWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = aProposRepository.findAll().size();

        // Create the APropos with an existing ID
        aPropos.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restAProposMockMvc.perform(post("/api/a-propos")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(aPropos)))
            .andExpect(status().isBadRequest());

        // Validate the APropos in the database
        List<APropos> aProposList = aProposRepository.findAll();
        assertThat(aProposList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllAPropos() throws Exception {
        // Initialize the database
        aProposRepository.saveAndFlush(aPropos);

        // Get all the aProposList
        restAProposMockMvc.perform(get("/api/a-propos?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(aPropos.getId().intValue())))
            .andExpect(jsonPath("$.[*].titreFr").value(hasItem(DEFAULT_TITRE_FR)))
            .andExpect(jsonPath("$.[*].titreEn").value(hasItem(DEFAULT_TITRE_EN)))
            .andExpect(jsonPath("$.[*].titreGer").value(hasItem(DEFAULT_TITRE_GER)))
            .andExpect(jsonPath("$.[*].titreSw").value(hasItem(DEFAULT_TITRE_SW)))
            .andExpect(jsonPath("$.[*].sousTitreFr").value(hasItem(DEFAULT_SOUS_TITRE_FR)))
            .andExpect(jsonPath("$.[*].sousTitreEn").value(hasItem(DEFAULT_SOUS_TITRE_EN)))
            .andExpect(jsonPath("$.[*].sousTitreGer").value(hasItem(DEFAULT_SOUS_TITRE_GER)))
            .andExpect(jsonPath("$.[*].sousTitreSw").value(hasItem(DEFAULT_SOUS_TITRE_SW)))
            .andExpect(jsonPath("$.[*].textParagraphe1Fr").value(hasItem(DEFAULT_TEXT_PARAGRAPHE_1_FR)))
            .andExpect(jsonPath("$.[*].textParagraphe1En").value(hasItem(DEFAULT_TEXT_PARAGRAPHE_1_EN)))
            .andExpect(jsonPath("$.[*].textParagraphe1Ger").value(hasItem(DEFAULT_TEXT_PARAGRAPHE_1_GER)))
            .andExpect(jsonPath("$.[*].textParagraphe1Sw").value(hasItem(DEFAULT_TEXT_PARAGRAPHE_1_SW)))
            .andExpect(jsonPath("$.[*].textParagraphe2Fr").value(hasItem(DEFAULT_TEXT_PARAGRAPHE_2_FR)))
            .andExpect(jsonPath("$.[*].textParagraphe2En").value(hasItem(DEFAULT_TEXT_PARAGRAPHE_2_EN)))
            .andExpect(jsonPath("$.[*].textParagraphe2Ger").value(hasItem(DEFAULT_TEXT_PARAGRAPHE_2_GER)))
            .andExpect(jsonPath("$.[*].textParagraphe2Sw").value(hasItem(DEFAULT_TEXT_PARAGRAPHE_2_SW)))
            .andExpect(jsonPath("$.[*].textParagraphe3Fr").value(hasItem(DEFAULT_TEXT_PARAGRAPHE_3_FR)))
            .andExpect(jsonPath("$.[*].textParagraphe3En").value(hasItem(DEFAULT_TEXT_PARAGRAPHE_3_EN)))
            .andExpect(jsonPath("$.[*].textParagraphe3Ger").value(hasItem(DEFAULT_TEXT_PARAGRAPHE_3_GER)))
            .andExpect(jsonPath("$.[*].textParagraphe3Sw").value(hasItem(DEFAULT_TEXT_PARAGRAPHE_3_SW)))
            .andExpect(jsonPath("$.[*].textParagraphe4Fr").value(hasItem(DEFAULT_TEXT_PARAGRAPHE_4_FR)))
            .andExpect(jsonPath("$.[*].textParagraphe4En").value(hasItem(DEFAULT_TEXT_PARAGRAPHE_4_EN)))
            .andExpect(jsonPath("$.[*].textParagraphe4Ger").value(hasItem(DEFAULT_TEXT_PARAGRAPHE_4_GER)))
            .andExpect(jsonPath("$.[*].textParagraphe4Sw").value(hasItem(DEFAULT_TEXT_PARAGRAPHE_4_SW)))
            .andExpect(jsonPath("$.[*].textParagraphe5Fr").value(hasItem(DEFAULT_TEXT_PARAGRAPHE_5_FR)))
            .andExpect(jsonPath("$.[*].textParagraphe5En").value(hasItem(DEFAULT_TEXT_PARAGRAPHE_5_EN)))
            .andExpect(jsonPath("$.[*].textParagraphe5Ger").value(hasItem(DEFAULT_TEXT_PARAGRAPHE_5_GER)))
            .andExpect(jsonPath("$.[*].textParagraphe5Sw").value(hasItem(DEFAULT_TEXT_PARAGRAPHE_5_SW)))
            .andExpect(jsonPath("$.[*].imageContentType").value(hasItem(DEFAULT_IMAGE_CONTENT_TYPE)))
            .andExpect(jsonPath("$.[*].image").value(hasItem(Base64Utils.encodeToString(DEFAULT_IMAGE))));
    }
    
    @Test
    @Transactional
    public void getAPropos() throws Exception {
        // Initialize the database
        aProposRepository.saveAndFlush(aPropos);

        // Get the aPropos
        restAProposMockMvc.perform(get("/api/a-propos/{id}", aPropos.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(aPropos.getId().intValue()))
            .andExpect(jsonPath("$.titreFr").value(DEFAULT_TITRE_FR))
            .andExpect(jsonPath("$.titreEn").value(DEFAULT_TITRE_EN))
            .andExpect(jsonPath("$.titreGer").value(DEFAULT_TITRE_GER))
            .andExpect(jsonPath("$.titreSw").value(DEFAULT_TITRE_SW))
            .andExpect(jsonPath("$.sousTitreFr").value(DEFAULT_SOUS_TITRE_FR))
            .andExpect(jsonPath("$.sousTitreEn").value(DEFAULT_SOUS_TITRE_EN))
            .andExpect(jsonPath("$.sousTitreGer").value(DEFAULT_SOUS_TITRE_GER))
            .andExpect(jsonPath("$.sousTitreSw").value(DEFAULT_SOUS_TITRE_SW))
            .andExpect(jsonPath("$.textParagraphe1Fr").value(DEFAULT_TEXT_PARAGRAPHE_1_FR))
            .andExpect(jsonPath("$.textParagraphe1En").value(DEFAULT_TEXT_PARAGRAPHE_1_EN))
            .andExpect(jsonPath("$.textParagraphe1Ger").value(DEFAULT_TEXT_PARAGRAPHE_1_GER))
            .andExpect(jsonPath("$.textParagraphe1Sw").value(DEFAULT_TEXT_PARAGRAPHE_1_SW))
            .andExpect(jsonPath("$.textParagraphe2Fr").value(DEFAULT_TEXT_PARAGRAPHE_2_FR))
            .andExpect(jsonPath("$.textParagraphe2En").value(DEFAULT_TEXT_PARAGRAPHE_2_EN))
            .andExpect(jsonPath("$.textParagraphe2Ger").value(DEFAULT_TEXT_PARAGRAPHE_2_GER))
            .andExpect(jsonPath("$.textParagraphe2Sw").value(DEFAULT_TEXT_PARAGRAPHE_2_SW))
            .andExpect(jsonPath("$.textParagraphe3Fr").value(DEFAULT_TEXT_PARAGRAPHE_3_FR))
            .andExpect(jsonPath("$.textParagraphe3En").value(DEFAULT_TEXT_PARAGRAPHE_3_EN))
            .andExpect(jsonPath("$.textParagraphe3Ger").value(DEFAULT_TEXT_PARAGRAPHE_3_GER))
            .andExpect(jsonPath("$.textParagraphe3Sw").value(DEFAULT_TEXT_PARAGRAPHE_3_SW))
            .andExpect(jsonPath("$.textParagraphe4Fr").value(DEFAULT_TEXT_PARAGRAPHE_4_FR))
            .andExpect(jsonPath("$.textParagraphe4En").value(DEFAULT_TEXT_PARAGRAPHE_4_EN))
            .andExpect(jsonPath("$.textParagraphe4Ger").value(DEFAULT_TEXT_PARAGRAPHE_4_GER))
            .andExpect(jsonPath("$.textParagraphe4Sw").value(DEFAULT_TEXT_PARAGRAPHE_4_SW))
            .andExpect(jsonPath("$.textParagraphe5Fr").value(DEFAULT_TEXT_PARAGRAPHE_5_FR))
            .andExpect(jsonPath("$.textParagraphe5En").value(DEFAULT_TEXT_PARAGRAPHE_5_EN))
            .andExpect(jsonPath("$.textParagraphe5Ger").value(DEFAULT_TEXT_PARAGRAPHE_5_GER))
            .andExpect(jsonPath("$.textParagraphe5Sw").value(DEFAULT_TEXT_PARAGRAPHE_5_SW))
            .andExpect(jsonPath("$.imageContentType").value(DEFAULT_IMAGE_CONTENT_TYPE))
            .andExpect(jsonPath("$.image").value(Base64Utils.encodeToString(DEFAULT_IMAGE)));
    }

    @Test
    @Transactional
    public void getNonExistingAPropos() throws Exception {
        // Get the aPropos
        restAProposMockMvc.perform(get("/api/a-propos/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateAPropos() throws Exception {
        // Initialize the database
        aProposRepository.saveAndFlush(aPropos);

        int databaseSizeBeforeUpdate = aProposRepository.findAll().size();

        // Update the aPropos
        APropos updatedAPropos = aProposRepository.findById(aPropos.getId()).get();
        // Disconnect from session so that the updates on updatedAPropos are not directly saved in db
        em.detach(updatedAPropos);
        updatedAPropos
            .titreFr(UPDATED_TITRE_FR)
            .titreEn(UPDATED_TITRE_EN)
            .titreGer(UPDATED_TITRE_GER)
            .titreSw(UPDATED_TITRE_SW)
            .sousTitreFr(UPDATED_SOUS_TITRE_FR)
            .sousTitreEn(UPDATED_SOUS_TITRE_EN)
            .sousTitreGer(UPDATED_SOUS_TITRE_GER)
            .sousTitreSw(UPDATED_SOUS_TITRE_SW)
            .textParagraphe1Fr(UPDATED_TEXT_PARAGRAPHE_1_FR)
            .textParagraphe1En(UPDATED_TEXT_PARAGRAPHE_1_EN)
            .textParagraphe1Ger(UPDATED_TEXT_PARAGRAPHE_1_GER)
            .textParagraphe1Sw(UPDATED_TEXT_PARAGRAPHE_1_SW)
            .textParagraphe2Fr(UPDATED_TEXT_PARAGRAPHE_2_FR)
            .textParagraphe2En(UPDATED_TEXT_PARAGRAPHE_2_EN)
            .textParagraphe2Ger(UPDATED_TEXT_PARAGRAPHE_2_GER)
            .textParagraphe2Sw(UPDATED_TEXT_PARAGRAPHE_2_SW)
            .textParagraphe3Fr(UPDATED_TEXT_PARAGRAPHE_3_FR)
            .textParagraphe3En(UPDATED_TEXT_PARAGRAPHE_3_EN)
            .textParagraphe3Ger(UPDATED_TEXT_PARAGRAPHE_3_GER)
            .textParagraphe3Sw(UPDATED_TEXT_PARAGRAPHE_3_SW)
            .textParagraphe4Fr(UPDATED_TEXT_PARAGRAPHE_4_FR)
            .textParagraphe4En(UPDATED_TEXT_PARAGRAPHE_4_EN)
            .textParagraphe4Ger(UPDATED_TEXT_PARAGRAPHE_4_GER)
            .textParagraphe4Sw(UPDATED_TEXT_PARAGRAPHE_4_SW)
            .textParagraphe5Fr(UPDATED_TEXT_PARAGRAPHE_5_FR)
            .textParagraphe5En(UPDATED_TEXT_PARAGRAPHE_5_EN)
            .textParagraphe5Ger(UPDATED_TEXT_PARAGRAPHE_5_GER)
            .textParagraphe5Sw(UPDATED_TEXT_PARAGRAPHE_5_SW)
            .image(UPDATED_IMAGE)
            .imageContentType(UPDATED_IMAGE_CONTENT_TYPE);

        restAProposMockMvc.perform(put("/api/a-propos")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(updatedAPropos)))
            .andExpect(status().isOk());

        // Validate the APropos in the database
        List<APropos> aProposList = aProposRepository.findAll();
        assertThat(aProposList).hasSize(databaseSizeBeforeUpdate);
        APropos testAPropos = aProposList.get(aProposList.size() - 1);
        assertThat(testAPropos.getTitreFr()).isEqualTo(UPDATED_TITRE_FR);
        assertThat(testAPropos.getTitreEn()).isEqualTo(UPDATED_TITRE_EN);
        assertThat(testAPropos.getTitreGer()).isEqualTo(UPDATED_TITRE_GER);
        assertThat(testAPropos.getTitreSw()).isEqualTo(UPDATED_TITRE_SW);
        assertThat(testAPropos.getSousTitreFr()).isEqualTo(UPDATED_SOUS_TITRE_FR);
        assertThat(testAPropos.getSousTitreEn()).isEqualTo(UPDATED_SOUS_TITRE_EN);
        assertThat(testAPropos.getSousTitreGer()).isEqualTo(UPDATED_SOUS_TITRE_GER);
        assertThat(testAPropos.getSousTitreSw()).isEqualTo(UPDATED_SOUS_TITRE_SW);
        assertThat(testAPropos.getTextParagraphe1Fr()).isEqualTo(UPDATED_TEXT_PARAGRAPHE_1_FR);
        assertThat(testAPropos.getTextParagraphe1En()).isEqualTo(UPDATED_TEXT_PARAGRAPHE_1_EN);
        assertThat(testAPropos.getTextParagraphe1Ger()).isEqualTo(UPDATED_TEXT_PARAGRAPHE_1_GER);
        assertThat(testAPropos.getTextParagraphe1Sw()).isEqualTo(UPDATED_TEXT_PARAGRAPHE_1_SW);
        assertThat(testAPropos.getTextParagraphe2Fr()).isEqualTo(UPDATED_TEXT_PARAGRAPHE_2_FR);
        assertThat(testAPropos.getTextParagraphe2En()).isEqualTo(UPDATED_TEXT_PARAGRAPHE_2_EN);
        assertThat(testAPropos.getTextParagraphe2Ger()).isEqualTo(UPDATED_TEXT_PARAGRAPHE_2_GER);
        assertThat(testAPropos.getTextParagraphe2Sw()).isEqualTo(UPDATED_TEXT_PARAGRAPHE_2_SW);
        assertThat(testAPropos.getTextParagraphe3Fr()).isEqualTo(UPDATED_TEXT_PARAGRAPHE_3_FR);
        assertThat(testAPropos.getTextParagraphe3En()).isEqualTo(UPDATED_TEXT_PARAGRAPHE_3_EN);
        assertThat(testAPropos.getTextParagraphe3Ger()).isEqualTo(UPDATED_TEXT_PARAGRAPHE_3_GER);
        assertThat(testAPropos.getTextParagraphe3Sw()).isEqualTo(UPDATED_TEXT_PARAGRAPHE_3_SW);
        assertThat(testAPropos.getTextParagraphe4Fr()).isEqualTo(UPDATED_TEXT_PARAGRAPHE_4_FR);
        assertThat(testAPropos.getTextParagraphe4En()).isEqualTo(UPDATED_TEXT_PARAGRAPHE_4_EN);
        assertThat(testAPropos.getTextParagraphe4Ger()).isEqualTo(UPDATED_TEXT_PARAGRAPHE_4_GER);
        assertThat(testAPropos.getTextParagraphe4Sw()).isEqualTo(UPDATED_TEXT_PARAGRAPHE_4_SW);
        assertThat(testAPropos.getTextParagraphe5Fr()).isEqualTo(UPDATED_TEXT_PARAGRAPHE_5_FR);
        assertThat(testAPropos.getTextParagraphe5En()).isEqualTo(UPDATED_TEXT_PARAGRAPHE_5_EN);
        assertThat(testAPropos.getTextParagraphe5Ger()).isEqualTo(UPDATED_TEXT_PARAGRAPHE_5_GER);
        assertThat(testAPropos.getTextParagraphe5Sw()).isEqualTo(UPDATED_TEXT_PARAGRAPHE_5_SW);
        assertThat(testAPropos.getImage()).isEqualTo(UPDATED_IMAGE);
        assertThat(testAPropos.getImageContentType()).isEqualTo(UPDATED_IMAGE_CONTENT_TYPE);
    }

    @Test
    @Transactional
    public void updateNonExistingAPropos() throws Exception {
        int databaseSizeBeforeUpdate = aProposRepository.findAll().size();

        // Create the APropos

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restAProposMockMvc.perform(put("/api/a-propos")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(aPropos)))
            .andExpect(status().isBadRequest());

        // Validate the APropos in the database
        List<APropos> aProposList = aProposRepository.findAll();
        assertThat(aProposList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteAPropos() throws Exception {
        // Initialize the database
        aProposRepository.saveAndFlush(aPropos);

        int databaseSizeBeforeDelete = aProposRepository.findAll().size();

        // Delete the aPropos
        restAProposMockMvc.perform(delete("/api/a-propos/{id}", aPropos.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<APropos> aProposList = aProposRepository.findAll();
        assertThat(aProposList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
