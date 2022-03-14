package com.iota.orign.web.rest;

import com.iota.orign.IotaOrignAdminApp;
import com.iota.orign.domain.Avantages;
import com.iota.orign.repository.AvantagesRepository;

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
 * Integration tests for the {@link AvantagesResource} REST controller.
 */
@SpringBootTest(classes = IotaOrignAdminApp.class)

@AutoConfigureMockMvc
@WithMockUser
public class AvantagesResourceIT {

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

    private static final String DEFAULT_TEXT_PARAGRAPHE_6_FR = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_PARAGRAPHE_6_FR = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_PARAGRAPHE_6_EN = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_PARAGRAPHE_6_EN = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_PARAGRAPHE_6_GER = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_PARAGRAPHE_6_GER = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_PARAGRAPHE_6_SW = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_PARAGRAPHE_6_SW = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_PARAGRAPHE_7_FR = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_PARAGRAPHE_7_FR = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_PARAGRAPHE_7_EN = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_PARAGRAPHE_7_EN = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_PARAGRAPHE_7_GER = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_PARAGRAPHE_7_GER = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_PARAGRAPHE_7_SW = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_PARAGRAPHE_7_SW = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_PARAGRAPHE_8_FR = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_PARAGRAPHE_8_FR = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_PARAGRAPHE_8_EN = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_PARAGRAPHE_8_EN = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_PARAGRAPHE_8_GER = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_PARAGRAPHE_8_GER = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_PARAGRAPHE_8_SW = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_PARAGRAPHE_8_SW = "BBBBBBBBBB";

    private static final byte[] DEFAULT_IMAGE = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_IMAGE = TestUtil.createByteArray(1, "1");
    private static final String DEFAULT_IMAGE_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_IMAGE_CONTENT_TYPE = "image/png";

    @Autowired
    private AvantagesRepository avantagesRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restAvantagesMockMvc;

    private Avantages avantages;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Avantages createEntity(EntityManager em) {
        Avantages avantages = new Avantages()
            .titreFr(DEFAULT_TITRE_FR)
            .titreEn(DEFAULT_TITRE_EN)
            .titreGer(DEFAULT_TITRE_GER)
            .titreSw(DEFAULT_TITRE_SW)
            .sousTitreFr(DEFAULT_SOUS_TITRE_FR)
            .sousTitreEn(DEFAULT_SOUS_TITRE_EN)
            .sousTitreGer(DEFAULT_SOUS_TITRE_GER)
            .sousTitreSw(DEFAULT_SOUS_TITRE_SW)
            .textParagraphe1FR(DEFAULT_TEXT_PARAGRAPHE_1_FR)
            .textParagraphe1En(DEFAULT_TEXT_PARAGRAPHE_1_EN)
            .textParagraphe1Ger(DEFAULT_TEXT_PARAGRAPHE_1_GER)
            .textParagraphe1Sw(DEFAULT_TEXT_PARAGRAPHE_1_SW)
            .textParagraphe2Fr(DEFAULT_TEXT_PARAGRAPHE_2_FR)
            .textParagraphe2En(DEFAULT_TEXT_PARAGRAPHE_2_EN)
            .textParagraphe2Ger(DEFAULT_TEXT_PARAGRAPHE_2_GER)
            .textParagraphe2Sw(DEFAULT_TEXT_PARAGRAPHE_2_SW)
            .textParagraphe3FR(DEFAULT_TEXT_PARAGRAPHE_3_FR)
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
            .textParagraphe6Fr(DEFAULT_TEXT_PARAGRAPHE_6_FR)
            .textParagraphe6En(DEFAULT_TEXT_PARAGRAPHE_6_EN)
            .textParagraphe6Ger(DEFAULT_TEXT_PARAGRAPHE_6_GER)
            .textParagraphe6Sw(DEFAULT_TEXT_PARAGRAPHE_6_SW)
            .textParagraphe7Fr(DEFAULT_TEXT_PARAGRAPHE_7_FR)
            .textParagraphe7En(DEFAULT_TEXT_PARAGRAPHE_7_EN)
            .textParagraphe7Ger(DEFAULT_TEXT_PARAGRAPHE_7_GER)
            .textParagraphe7Sw(DEFAULT_TEXT_PARAGRAPHE_7_SW)
            .textParagraphe8Fr(DEFAULT_TEXT_PARAGRAPHE_8_FR)
            .textParagraphe8En(DEFAULT_TEXT_PARAGRAPHE_8_EN)
            .textParagraphe8Ger(DEFAULT_TEXT_PARAGRAPHE_8_GER)
            .textParagraphe8Sw(DEFAULT_TEXT_PARAGRAPHE_8_SW)
            .image(DEFAULT_IMAGE)
            .imageContentType(DEFAULT_IMAGE_CONTENT_TYPE);
        return avantages;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Avantages createUpdatedEntity(EntityManager em) {
        Avantages avantages = new Avantages()
            .titreFr(UPDATED_TITRE_FR)
            .titreEn(UPDATED_TITRE_EN)
            .titreGer(UPDATED_TITRE_GER)
            .titreSw(UPDATED_TITRE_SW)
            .sousTitreFr(UPDATED_SOUS_TITRE_FR)
            .sousTitreEn(UPDATED_SOUS_TITRE_EN)
            .sousTitreGer(UPDATED_SOUS_TITRE_GER)
            .sousTitreSw(UPDATED_SOUS_TITRE_SW)
            .textParagraphe1FR(UPDATED_TEXT_PARAGRAPHE_1_FR)
            .textParagraphe1En(UPDATED_TEXT_PARAGRAPHE_1_EN)
            .textParagraphe1Ger(UPDATED_TEXT_PARAGRAPHE_1_GER)
            .textParagraphe1Sw(UPDATED_TEXT_PARAGRAPHE_1_SW)
            .textParagraphe2Fr(UPDATED_TEXT_PARAGRAPHE_2_FR)
            .textParagraphe2En(UPDATED_TEXT_PARAGRAPHE_2_EN)
            .textParagraphe2Ger(UPDATED_TEXT_PARAGRAPHE_2_GER)
            .textParagraphe2Sw(UPDATED_TEXT_PARAGRAPHE_2_SW)
            .textParagraphe3FR(UPDATED_TEXT_PARAGRAPHE_3_FR)
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
            .textParagraphe6Fr(UPDATED_TEXT_PARAGRAPHE_6_FR)
            .textParagraphe6En(UPDATED_TEXT_PARAGRAPHE_6_EN)
            .textParagraphe6Ger(UPDATED_TEXT_PARAGRAPHE_6_GER)
            .textParagraphe6Sw(UPDATED_TEXT_PARAGRAPHE_6_SW)
            .textParagraphe7Fr(UPDATED_TEXT_PARAGRAPHE_7_FR)
            .textParagraphe7En(UPDATED_TEXT_PARAGRAPHE_7_EN)
            .textParagraphe7Ger(UPDATED_TEXT_PARAGRAPHE_7_GER)
            .textParagraphe7Sw(UPDATED_TEXT_PARAGRAPHE_7_SW)
            .textParagraphe8Fr(UPDATED_TEXT_PARAGRAPHE_8_FR)
            .textParagraphe8En(UPDATED_TEXT_PARAGRAPHE_8_EN)
            .textParagraphe8Ger(UPDATED_TEXT_PARAGRAPHE_8_GER)
            .textParagraphe8Sw(UPDATED_TEXT_PARAGRAPHE_8_SW)
            .image(UPDATED_IMAGE)
            .imageContentType(UPDATED_IMAGE_CONTENT_TYPE);
        return avantages;
    }

    @BeforeEach
    public void initTest() {
        avantages = createEntity(em);
    }

    @Test
    @Transactional
    public void createAvantages() throws Exception {
        int databaseSizeBeforeCreate = avantagesRepository.findAll().size();

        // Create the Avantages
        restAvantagesMockMvc.perform(post("/api/avantages")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(avantages)))
            .andExpect(status().isCreated());

        // Validate the Avantages in the database
        List<Avantages> avantagesList = avantagesRepository.findAll();
        assertThat(avantagesList).hasSize(databaseSizeBeforeCreate + 1);
        Avantages testAvantages = avantagesList.get(avantagesList.size() - 1);
        assertThat(testAvantages.getTitreFr()).isEqualTo(DEFAULT_TITRE_FR);
        assertThat(testAvantages.getTitreEn()).isEqualTo(DEFAULT_TITRE_EN);
        assertThat(testAvantages.getTitreGer()).isEqualTo(DEFAULT_TITRE_GER);
        assertThat(testAvantages.getTitreSw()).isEqualTo(DEFAULT_TITRE_SW);
        assertThat(testAvantages.getSousTitreFr()).isEqualTo(DEFAULT_SOUS_TITRE_FR);
        assertThat(testAvantages.getSousTitreEn()).isEqualTo(DEFAULT_SOUS_TITRE_EN);
        assertThat(testAvantages.getSousTitreGer()).isEqualTo(DEFAULT_SOUS_TITRE_GER);
        assertThat(testAvantages.getSousTitreSw()).isEqualTo(DEFAULT_SOUS_TITRE_SW);
        assertThat(testAvantages.getTextParagraphe1FR()).isEqualTo(DEFAULT_TEXT_PARAGRAPHE_1_FR);
        assertThat(testAvantages.getTextParagraphe1En()).isEqualTo(DEFAULT_TEXT_PARAGRAPHE_1_EN);
        assertThat(testAvantages.getTextParagraphe1Ger()).isEqualTo(DEFAULT_TEXT_PARAGRAPHE_1_GER);
        assertThat(testAvantages.getTextParagraphe1Sw()).isEqualTo(DEFAULT_TEXT_PARAGRAPHE_1_SW);
        assertThat(testAvantages.getTextParagraphe2Fr()).isEqualTo(DEFAULT_TEXT_PARAGRAPHE_2_FR);
        assertThat(testAvantages.getTextParagraphe2En()).isEqualTo(DEFAULT_TEXT_PARAGRAPHE_2_EN);
        assertThat(testAvantages.getTextParagraphe2Ger()).isEqualTo(DEFAULT_TEXT_PARAGRAPHE_2_GER);
        assertThat(testAvantages.getTextParagraphe2Sw()).isEqualTo(DEFAULT_TEXT_PARAGRAPHE_2_SW);
        assertThat(testAvantages.getTextParagraphe3FR()).isEqualTo(DEFAULT_TEXT_PARAGRAPHE_3_FR);
        assertThat(testAvantages.getTextParagraphe3En()).isEqualTo(DEFAULT_TEXT_PARAGRAPHE_3_EN);
        assertThat(testAvantages.getTextParagraphe3Ger()).isEqualTo(DEFAULT_TEXT_PARAGRAPHE_3_GER);
        assertThat(testAvantages.getTextParagraphe3Sw()).isEqualTo(DEFAULT_TEXT_PARAGRAPHE_3_SW);
        assertThat(testAvantages.getTextParagraphe4Fr()).isEqualTo(DEFAULT_TEXT_PARAGRAPHE_4_FR);
        assertThat(testAvantages.getTextParagraphe4En()).isEqualTo(DEFAULT_TEXT_PARAGRAPHE_4_EN);
        assertThat(testAvantages.getTextParagraphe4Ger()).isEqualTo(DEFAULT_TEXT_PARAGRAPHE_4_GER);
        assertThat(testAvantages.getTextParagraphe4Sw()).isEqualTo(DEFAULT_TEXT_PARAGRAPHE_4_SW);
        assertThat(testAvantages.getTextParagraphe5Fr()).isEqualTo(DEFAULT_TEXT_PARAGRAPHE_5_FR);
        assertThat(testAvantages.getTextParagraphe5En()).isEqualTo(DEFAULT_TEXT_PARAGRAPHE_5_EN);
        assertThat(testAvantages.getTextParagraphe5Ger()).isEqualTo(DEFAULT_TEXT_PARAGRAPHE_5_GER);
        assertThat(testAvantages.getTextParagraphe5Sw()).isEqualTo(DEFAULT_TEXT_PARAGRAPHE_5_SW);
        assertThat(testAvantages.getTextParagraphe6Fr()).isEqualTo(DEFAULT_TEXT_PARAGRAPHE_6_FR);
        assertThat(testAvantages.getTextParagraphe6En()).isEqualTo(DEFAULT_TEXT_PARAGRAPHE_6_EN);
        assertThat(testAvantages.getTextParagraphe6Ger()).isEqualTo(DEFAULT_TEXT_PARAGRAPHE_6_GER);
        assertThat(testAvantages.getTextParagraphe6Sw()).isEqualTo(DEFAULT_TEXT_PARAGRAPHE_6_SW);
        assertThat(testAvantages.getTextParagraphe7Fr()).isEqualTo(DEFAULT_TEXT_PARAGRAPHE_7_FR);
        assertThat(testAvantages.getTextParagraphe7En()).isEqualTo(DEFAULT_TEXT_PARAGRAPHE_7_EN);
        assertThat(testAvantages.getTextParagraphe7Ger()).isEqualTo(DEFAULT_TEXT_PARAGRAPHE_7_GER);
        assertThat(testAvantages.getTextParagraphe7Sw()).isEqualTo(DEFAULT_TEXT_PARAGRAPHE_7_SW);
        assertThat(testAvantages.getTextParagraphe8Fr()).isEqualTo(DEFAULT_TEXT_PARAGRAPHE_8_FR);
        assertThat(testAvantages.getTextParagraphe8En()).isEqualTo(DEFAULT_TEXT_PARAGRAPHE_8_EN);
        assertThat(testAvantages.getTextParagraphe8Ger()).isEqualTo(DEFAULT_TEXT_PARAGRAPHE_8_GER);
        assertThat(testAvantages.getTextParagraphe8Sw()).isEqualTo(DEFAULT_TEXT_PARAGRAPHE_8_SW);
        assertThat(testAvantages.getImage()).isEqualTo(DEFAULT_IMAGE);
        assertThat(testAvantages.getImageContentType()).isEqualTo(DEFAULT_IMAGE_CONTENT_TYPE);
    }

    @Test
    @Transactional
    public void createAvantagesWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = avantagesRepository.findAll().size();

        // Create the Avantages with an existing ID
        avantages.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restAvantagesMockMvc.perform(post("/api/avantages")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(avantages)))
            .andExpect(status().isBadRequest());

        // Validate the Avantages in the database
        List<Avantages> avantagesList = avantagesRepository.findAll();
        assertThat(avantagesList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllAvantages() throws Exception {
        // Initialize the database
        avantagesRepository.saveAndFlush(avantages);

        // Get all the avantagesList
        restAvantagesMockMvc.perform(get("/api/avantages?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(avantages.getId().intValue())))
            .andExpect(jsonPath("$.[*].titreFr").value(hasItem(DEFAULT_TITRE_FR)))
            .andExpect(jsonPath("$.[*].titreEn").value(hasItem(DEFAULT_TITRE_EN)))
            .andExpect(jsonPath("$.[*].titreGer").value(hasItem(DEFAULT_TITRE_GER)))
            .andExpect(jsonPath("$.[*].titreSw").value(hasItem(DEFAULT_TITRE_SW)))
            .andExpect(jsonPath("$.[*].sousTitreFr").value(hasItem(DEFAULT_SOUS_TITRE_FR)))
            .andExpect(jsonPath("$.[*].sousTitreEn").value(hasItem(DEFAULT_SOUS_TITRE_EN)))
            .andExpect(jsonPath("$.[*].sousTitreGer").value(hasItem(DEFAULT_SOUS_TITRE_GER)))
            .andExpect(jsonPath("$.[*].sousTitreSw").value(hasItem(DEFAULT_SOUS_TITRE_SW)))
            .andExpect(jsonPath("$.[*].textParagraphe1FR").value(hasItem(DEFAULT_TEXT_PARAGRAPHE_1_FR)))
            .andExpect(jsonPath("$.[*].textParagraphe1En").value(hasItem(DEFAULT_TEXT_PARAGRAPHE_1_EN)))
            .andExpect(jsonPath("$.[*].textParagraphe1Ger").value(hasItem(DEFAULT_TEXT_PARAGRAPHE_1_GER)))
            .andExpect(jsonPath("$.[*].textParagraphe1Sw").value(hasItem(DEFAULT_TEXT_PARAGRAPHE_1_SW)))
            .andExpect(jsonPath("$.[*].textParagraphe2Fr").value(hasItem(DEFAULT_TEXT_PARAGRAPHE_2_FR)))
            .andExpect(jsonPath("$.[*].textParagraphe2En").value(hasItem(DEFAULT_TEXT_PARAGRAPHE_2_EN)))
            .andExpect(jsonPath("$.[*].textParagraphe2Ger").value(hasItem(DEFAULT_TEXT_PARAGRAPHE_2_GER)))
            .andExpect(jsonPath("$.[*].textParagraphe2Sw").value(hasItem(DEFAULT_TEXT_PARAGRAPHE_2_SW)))
            .andExpect(jsonPath("$.[*].textParagraphe3FR").value(hasItem(DEFAULT_TEXT_PARAGRAPHE_3_FR)))
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
            .andExpect(jsonPath("$.[*].textParagraphe6Fr").value(hasItem(DEFAULT_TEXT_PARAGRAPHE_6_FR)))
            .andExpect(jsonPath("$.[*].textParagraphe6En").value(hasItem(DEFAULT_TEXT_PARAGRAPHE_6_EN)))
            .andExpect(jsonPath("$.[*].textParagraphe6Ger").value(hasItem(DEFAULT_TEXT_PARAGRAPHE_6_GER)))
            .andExpect(jsonPath("$.[*].textParagraphe6Sw").value(hasItem(DEFAULT_TEXT_PARAGRAPHE_6_SW)))
            .andExpect(jsonPath("$.[*].textParagraphe7Fr").value(hasItem(DEFAULT_TEXT_PARAGRAPHE_7_FR)))
            .andExpect(jsonPath("$.[*].textParagraphe7En").value(hasItem(DEFAULT_TEXT_PARAGRAPHE_7_EN)))
            .andExpect(jsonPath("$.[*].textParagraphe7Ger").value(hasItem(DEFAULT_TEXT_PARAGRAPHE_7_GER)))
            .andExpect(jsonPath("$.[*].textParagraphe7Sw").value(hasItem(DEFAULT_TEXT_PARAGRAPHE_7_SW)))
            .andExpect(jsonPath("$.[*].textParagraphe8Fr").value(hasItem(DEFAULT_TEXT_PARAGRAPHE_8_FR)))
            .andExpect(jsonPath("$.[*].textParagraphe8En").value(hasItem(DEFAULT_TEXT_PARAGRAPHE_8_EN)))
            .andExpect(jsonPath("$.[*].textParagraphe8Ger").value(hasItem(DEFAULT_TEXT_PARAGRAPHE_8_GER)))
            .andExpect(jsonPath("$.[*].textParagraphe8Sw").value(hasItem(DEFAULT_TEXT_PARAGRAPHE_8_SW)))
            .andExpect(jsonPath("$.[*].imageContentType").value(hasItem(DEFAULT_IMAGE_CONTENT_TYPE)))
            .andExpect(jsonPath("$.[*].image").value(hasItem(Base64Utils.encodeToString(DEFAULT_IMAGE))));
    }
    
    @Test
    @Transactional
    public void getAvantages() throws Exception {
        // Initialize the database
        avantagesRepository.saveAndFlush(avantages);

        // Get the avantages
        restAvantagesMockMvc.perform(get("/api/avantages/{id}", avantages.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(avantages.getId().intValue()))
            .andExpect(jsonPath("$.titreFr").value(DEFAULT_TITRE_FR))
            .andExpect(jsonPath("$.titreEn").value(DEFAULT_TITRE_EN))
            .andExpect(jsonPath("$.titreGer").value(DEFAULT_TITRE_GER))
            .andExpect(jsonPath("$.titreSw").value(DEFAULT_TITRE_SW))
            .andExpect(jsonPath("$.sousTitreFr").value(DEFAULT_SOUS_TITRE_FR))
            .andExpect(jsonPath("$.sousTitreEn").value(DEFAULT_SOUS_TITRE_EN))
            .andExpect(jsonPath("$.sousTitreGer").value(DEFAULT_SOUS_TITRE_GER))
            .andExpect(jsonPath("$.sousTitreSw").value(DEFAULT_SOUS_TITRE_SW))
            .andExpect(jsonPath("$.textParagraphe1FR").value(DEFAULT_TEXT_PARAGRAPHE_1_FR))
            .andExpect(jsonPath("$.textParagraphe1En").value(DEFAULT_TEXT_PARAGRAPHE_1_EN))
            .andExpect(jsonPath("$.textParagraphe1Ger").value(DEFAULT_TEXT_PARAGRAPHE_1_GER))
            .andExpect(jsonPath("$.textParagraphe1Sw").value(DEFAULT_TEXT_PARAGRAPHE_1_SW))
            .andExpect(jsonPath("$.textParagraphe2Fr").value(DEFAULT_TEXT_PARAGRAPHE_2_FR))
            .andExpect(jsonPath("$.textParagraphe2En").value(DEFAULT_TEXT_PARAGRAPHE_2_EN))
            .andExpect(jsonPath("$.textParagraphe2Ger").value(DEFAULT_TEXT_PARAGRAPHE_2_GER))
            .andExpect(jsonPath("$.textParagraphe2Sw").value(DEFAULT_TEXT_PARAGRAPHE_2_SW))
            .andExpect(jsonPath("$.textParagraphe3FR").value(DEFAULT_TEXT_PARAGRAPHE_3_FR))
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
            .andExpect(jsonPath("$.textParagraphe6Fr").value(DEFAULT_TEXT_PARAGRAPHE_6_FR))
            .andExpect(jsonPath("$.textParagraphe6En").value(DEFAULT_TEXT_PARAGRAPHE_6_EN))
            .andExpect(jsonPath("$.textParagraphe6Ger").value(DEFAULT_TEXT_PARAGRAPHE_6_GER))
            .andExpect(jsonPath("$.textParagraphe6Sw").value(DEFAULT_TEXT_PARAGRAPHE_6_SW))
            .andExpect(jsonPath("$.textParagraphe7Fr").value(DEFAULT_TEXT_PARAGRAPHE_7_FR))
            .andExpect(jsonPath("$.textParagraphe7En").value(DEFAULT_TEXT_PARAGRAPHE_7_EN))
            .andExpect(jsonPath("$.textParagraphe7Ger").value(DEFAULT_TEXT_PARAGRAPHE_7_GER))
            .andExpect(jsonPath("$.textParagraphe7Sw").value(DEFAULT_TEXT_PARAGRAPHE_7_SW))
            .andExpect(jsonPath("$.textParagraphe8Fr").value(DEFAULT_TEXT_PARAGRAPHE_8_FR))
            .andExpect(jsonPath("$.textParagraphe8En").value(DEFAULT_TEXT_PARAGRAPHE_8_EN))
            .andExpect(jsonPath("$.textParagraphe8Ger").value(DEFAULT_TEXT_PARAGRAPHE_8_GER))
            .andExpect(jsonPath("$.textParagraphe8Sw").value(DEFAULT_TEXT_PARAGRAPHE_8_SW))
            .andExpect(jsonPath("$.imageContentType").value(DEFAULT_IMAGE_CONTENT_TYPE))
            .andExpect(jsonPath("$.image").value(Base64Utils.encodeToString(DEFAULT_IMAGE)));
    }

    @Test
    @Transactional
    public void getNonExistingAvantages() throws Exception {
        // Get the avantages
        restAvantagesMockMvc.perform(get("/api/avantages/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateAvantages() throws Exception {
        // Initialize the database
        avantagesRepository.saveAndFlush(avantages);

        int databaseSizeBeforeUpdate = avantagesRepository.findAll().size();

        // Update the avantages
        Avantages updatedAvantages = avantagesRepository.findById(avantages.getId()).get();
        // Disconnect from session so that the updates on updatedAvantages are not directly saved in db
        em.detach(updatedAvantages);
        updatedAvantages
            .titreFr(UPDATED_TITRE_FR)
            .titreEn(UPDATED_TITRE_EN)
            .titreGer(UPDATED_TITRE_GER)
            .titreSw(UPDATED_TITRE_SW)
            .sousTitreFr(UPDATED_SOUS_TITRE_FR)
            .sousTitreEn(UPDATED_SOUS_TITRE_EN)
            .sousTitreGer(UPDATED_SOUS_TITRE_GER)
            .sousTitreSw(UPDATED_SOUS_TITRE_SW)
            .textParagraphe1FR(UPDATED_TEXT_PARAGRAPHE_1_FR)
            .textParagraphe1En(UPDATED_TEXT_PARAGRAPHE_1_EN)
            .textParagraphe1Ger(UPDATED_TEXT_PARAGRAPHE_1_GER)
            .textParagraphe1Sw(UPDATED_TEXT_PARAGRAPHE_1_SW)
            .textParagraphe2Fr(UPDATED_TEXT_PARAGRAPHE_2_FR)
            .textParagraphe2En(UPDATED_TEXT_PARAGRAPHE_2_EN)
            .textParagraphe2Ger(UPDATED_TEXT_PARAGRAPHE_2_GER)
            .textParagraphe2Sw(UPDATED_TEXT_PARAGRAPHE_2_SW)
            .textParagraphe3FR(UPDATED_TEXT_PARAGRAPHE_3_FR)
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
            .textParagraphe6Fr(UPDATED_TEXT_PARAGRAPHE_6_FR)
            .textParagraphe6En(UPDATED_TEXT_PARAGRAPHE_6_EN)
            .textParagraphe6Ger(UPDATED_TEXT_PARAGRAPHE_6_GER)
            .textParagraphe6Sw(UPDATED_TEXT_PARAGRAPHE_6_SW)
            .textParagraphe7Fr(UPDATED_TEXT_PARAGRAPHE_7_FR)
            .textParagraphe7En(UPDATED_TEXT_PARAGRAPHE_7_EN)
            .textParagraphe7Ger(UPDATED_TEXT_PARAGRAPHE_7_GER)
            .textParagraphe7Sw(UPDATED_TEXT_PARAGRAPHE_7_SW)
            .textParagraphe8Fr(UPDATED_TEXT_PARAGRAPHE_8_FR)
            .textParagraphe8En(UPDATED_TEXT_PARAGRAPHE_8_EN)
            .textParagraphe8Ger(UPDATED_TEXT_PARAGRAPHE_8_GER)
            .textParagraphe8Sw(UPDATED_TEXT_PARAGRAPHE_8_SW)
            .image(UPDATED_IMAGE)
            .imageContentType(UPDATED_IMAGE_CONTENT_TYPE);

        restAvantagesMockMvc.perform(put("/api/avantages")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(updatedAvantages)))
            .andExpect(status().isOk());

        // Validate the Avantages in the database
        List<Avantages> avantagesList = avantagesRepository.findAll();
        assertThat(avantagesList).hasSize(databaseSizeBeforeUpdate);
        Avantages testAvantages = avantagesList.get(avantagesList.size() - 1);
        assertThat(testAvantages.getTitreFr()).isEqualTo(UPDATED_TITRE_FR);
        assertThat(testAvantages.getTitreEn()).isEqualTo(UPDATED_TITRE_EN);
        assertThat(testAvantages.getTitreGer()).isEqualTo(UPDATED_TITRE_GER);
        assertThat(testAvantages.getTitreSw()).isEqualTo(UPDATED_TITRE_SW);
        assertThat(testAvantages.getSousTitreFr()).isEqualTo(UPDATED_SOUS_TITRE_FR);
        assertThat(testAvantages.getSousTitreEn()).isEqualTo(UPDATED_SOUS_TITRE_EN);
        assertThat(testAvantages.getSousTitreGer()).isEqualTo(UPDATED_SOUS_TITRE_GER);
        assertThat(testAvantages.getSousTitreSw()).isEqualTo(UPDATED_SOUS_TITRE_SW);
        assertThat(testAvantages.getTextParagraphe1FR()).isEqualTo(UPDATED_TEXT_PARAGRAPHE_1_FR);
        assertThat(testAvantages.getTextParagraphe1En()).isEqualTo(UPDATED_TEXT_PARAGRAPHE_1_EN);
        assertThat(testAvantages.getTextParagraphe1Ger()).isEqualTo(UPDATED_TEXT_PARAGRAPHE_1_GER);
        assertThat(testAvantages.getTextParagraphe1Sw()).isEqualTo(UPDATED_TEXT_PARAGRAPHE_1_SW);
        assertThat(testAvantages.getTextParagraphe2Fr()).isEqualTo(UPDATED_TEXT_PARAGRAPHE_2_FR);
        assertThat(testAvantages.getTextParagraphe2En()).isEqualTo(UPDATED_TEXT_PARAGRAPHE_2_EN);
        assertThat(testAvantages.getTextParagraphe2Ger()).isEqualTo(UPDATED_TEXT_PARAGRAPHE_2_GER);
        assertThat(testAvantages.getTextParagraphe2Sw()).isEqualTo(UPDATED_TEXT_PARAGRAPHE_2_SW);
        assertThat(testAvantages.getTextParagraphe3FR()).isEqualTo(UPDATED_TEXT_PARAGRAPHE_3_FR);
        assertThat(testAvantages.getTextParagraphe3En()).isEqualTo(UPDATED_TEXT_PARAGRAPHE_3_EN);
        assertThat(testAvantages.getTextParagraphe3Ger()).isEqualTo(UPDATED_TEXT_PARAGRAPHE_3_GER);
        assertThat(testAvantages.getTextParagraphe3Sw()).isEqualTo(UPDATED_TEXT_PARAGRAPHE_3_SW);
        assertThat(testAvantages.getTextParagraphe4Fr()).isEqualTo(UPDATED_TEXT_PARAGRAPHE_4_FR);
        assertThat(testAvantages.getTextParagraphe4En()).isEqualTo(UPDATED_TEXT_PARAGRAPHE_4_EN);
        assertThat(testAvantages.getTextParagraphe4Ger()).isEqualTo(UPDATED_TEXT_PARAGRAPHE_4_GER);
        assertThat(testAvantages.getTextParagraphe4Sw()).isEqualTo(UPDATED_TEXT_PARAGRAPHE_4_SW);
        assertThat(testAvantages.getTextParagraphe5Fr()).isEqualTo(UPDATED_TEXT_PARAGRAPHE_5_FR);
        assertThat(testAvantages.getTextParagraphe5En()).isEqualTo(UPDATED_TEXT_PARAGRAPHE_5_EN);
        assertThat(testAvantages.getTextParagraphe5Ger()).isEqualTo(UPDATED_TEXT_PARAGRAPHE_5_GER);
        assertThat(testAvantages.getTextParagraphe5Sw()).isEqualTo(UPDATED_TEXT_PARAGRAPHE_5_SW);
        assertThat(testAvantages.getTextParagraphe6Fr()).isEqualTo(UPDATED_TEXT_PARAGRAPHE_6_FR);
        assertThat(testAvantages.getTextParagraphe6En()).isEqualTo(UPDATED_TEXT_PARAGRAPHE_6_EN);
        assertThat(testAvantages.getTextParagraphe6Ger()).isEqualTo(UPDATED_TEXT_PARAGRAPHE_6_GER);
        assertThat(testAvantages.getTextParagraphe6Sw()).isEqualTo(UPDATED_TEXT_PARAGRAPHE_6_SW);
        assertThat(testAvantages.getTextParagraphe7Fr()).isEqualTo(UPDATED_TEXT_PARAGRAPHE_7_FR);
        assertThat(testAvantages.getTextParagraphe7En()).isEqualTo(UPDATED_TEXT_PARAGRAPHE_7_EN);
        assertThat(testAvantages.getTextParagraphe7Ger()).isEqualTo(UPDATED_TEXT_PARAGRAPHE_7_GER);
        assertThat(testAvantages.getTextParagraphe7Sw()).isEqualTo(UPDATED_TEXT_PARAGRAPHE_7_SW);
        assertThat(testAvantages.getTextParagraphe8Fr()).isEqualTo(UPDATED_TEXT_PARAGRAPHE_8_FR);
        assertThat(testAvantages.getTextParagraphe8En()).isEqualTo(UPDATED_TEXT_PARAGRAPHE_8_EN);
        assertThat(testAvantages.getTextParagraphe8Ger()).isEqualTo(UPDATED_TEXT_PARAGRAPHE_8_GER);
        assertThat(testAvantages.getTextParagraphe8Sw()).isEqualTo(UPDATED_TEXT_PARAGRAPHE_8_SW);
        assertThat(testAvantages.getImage()).isEqualTo(UPDATED_IMAGE);
        assertThat(testAvantages.getImageContentType()).isEqualTo(UPDATED_IMAGE_CONTENT_TYPE);
    }

    @Test
    @Transactional
    public void updateNonExistingAvantages() throws Exception {
        int databaseSizeBeforeUpdate = avantagesRepository.findAll().size();

        // Create the Avantages

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restAvantagesMockMvc.perform(put("/api/avantages")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(avantages)))
            .andExpect(status().isBadRequest());

        // Validate the Avantages in the database
        List<Avantages> avantagesList = avantagesRepository.findAll();
        assertThat(avantagesList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteAvantages() throws Exception {
        // Initialize the database
        avantagesRepository.saveAndFlush(avantages);

        int databaseSizeBeforeDelete = avantagesRepository.findAll().size();

        // Delete the avantages
        restAvantagesMockMvc.perform(delete("/api/avantages/{id}", avantages.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<Avantages> avantagesList = avantagesRepository.findAll();
        assertThat(avantagesList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
