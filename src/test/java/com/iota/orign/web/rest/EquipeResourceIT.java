package com.iota.orign.web.rest;

import com.iota.orign.IotaOrignAdminApp;
import com.iota.orign.domain.Equipe;
import com.iota.orign.repository.EquipeRepository;

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
 * Integration tests for the {@link EquipeResource} REST controller.
 */
@SpringBootTest(classes = IotaOrignAdminApp.class)

@AutoConfigureMockMvc
@WithMockUser
public class EquipeResourceIT {

    private static final String DEFAULT_TITRE_FR = "AAAAAAAAAA";
    private static final String UPDATED_TITRE_FR = "BBBBBBBBBB";

    private static final String DEFAULT_TITRE_EN = "AAAAAAAAAA";
    private static final String UPDATED_TITRE_EN = "BBBBBBBBBB";

    private static final String DEFAULT_TITRE_GER = "AAAAAAAAAA";
    private static final String UPDATED_TITRE_GER = "BBBBBBBBBB";

    private static final String DEFAULT_TITRE_SW = "AAAAAAAAAA";
    private static final String UPDATED_TITRE_SW = "BBBBBBBBBB";

    private static final String DEFAULT_SOU_TITRE_FR = "AAAAAAAAAA";
    private static final String UPDATED_SOU_TITRE_FR = "BBBBBBBBBB";

    private static final String DEFAULT_SOU_TITRE_EN = "AAAAAAAAAA";
    private static final String UPDATED_SOU_TITRE_EN = "BBBBBBBBBB";

    private static final String DEFAULT_SOU_TITRE_GER = "AAAAAAAAAA";
    private static final String UPDATED_SOU_TITRE_GER = "BBBBBBBBBB";

    private static final String DEFAULT_SOU_TITRE_SW = "AAAAAAAAAA";
    private static final String UPDATED_SOU_TITRE_SW = "BBBBBBBBBB";

    private static final String DEFAULT_NOM_1 = "AAAAAAAAAA";
    private static final String UPDATED_NOM_1 = "BBBBBBBBBB";

    private static final String DEFAULT_NOM_2 = "AAAAAAAAAA";
    private static final String UPDATED_NOM_2 = "BBBBBBBBBB";

    private static final String DEFAULT_NOM_3 = "AAAAAAAAAA";
    private static final String UPDATED_NOM_3 = "BBBBBBBBBB";

    private static final String DEFAULT_NOM_4 = "AAAAAAAAAA";
    private static final String UPDATED_NOM_4 = "BBBBBBBBBB";

    private static final String DEFAULT_NOM_5 = "AAAAAAAAAA";
    private static final String UPDATED_NOM_5 = "BBBBBBBBBB";

    private static final String DEFAULT_NOM_6 = "AAAAAAAAAA";
    private static final String UPDATED_NOM_6 = "BBBBBBBBBB";

    private static final String DEFAULT_NOM_7 = "AAAAAAAAAA";
    private static final String UPDATED_NOM_7 = "BBBBBBBBBB";

    private static final String DEFAULT_NOM_8 = "AAAAAAAAAA";
    private static final String UPDATED_NOM_8 = "BBBBBBBBBB";

    private static final String DEFAULT_PRENOM_1 = "AAAAAAAAAA";
    private static final String UPDATED_PRENOM_1 = "BBBBBBBBBB";

    private static final String DEFAULT_PRENOM_2 = "AAAAAAAAAA";
    private static final String UPDATED_PRENOM_2 = "BBBBBBBBBB";

    private static final String DEFAULT_PRENOM_3 = "AAAAAAAAAA";
    private static final String UPDATED_PRENOM_3 = "BBBBBBBBBB";

    private static final String DEFAULT_PRENOM_4 = "AAAAAAAAAA";
    private static final String UPDATED_PRENOM_4 = "BBBBBBBBBB";

    private static final String DEFAULT_PRENOM_5 = "AAAAAAAAAA";
    private static final String UPDATED_PRENOM_5 = "BBBBBBBBBB";

    private static final String DEFAULT_PRENOM_6 = "AAAAAAAAAA";
    private static final String UPDATED_PRENOM_6 = "BBBBBBBBBB";

    private static final String DEFAULT_PRENOM_7 = "AAAAAAAAAA";
    private static final String UPDATED_PRENOM_7 = "BBBBBBBBBB";

    private static final String DEFAULT_PRENOM_8 = "AAAAAAAAAA";
    private static final String UPDATED_PRENOM_8 = "BBBBBBBBBB";

    private static final String DEFAULT_QUALITE_1 = "AAAAAAAAAA";
    private static final String UPDATED_QUALITE_1 = "BBBBBBBBBB";

    private static final String DEFAULT_QUALITE_2 = "AAAAAAAAAA";
    private static final String UPDATED_QUALITE_2 = "BBBBBBBBBB";

    private static final String DEFAULT_QUALITE_3 = "AAAAAAAAAA";
    private static final String UPDATED_QUALITE_3 = "BBBBBBBBBB";

    private static final String DEFAULT_QUALITE_4 = "AAAAAAAAAA";
    private static final String UPDATED_QUALITE_4 = "BBBBBBBBBB";

    private static final String DEFAULT_QUALITE_5 = "AAAAAAAAAA";
    private static final String UPDATED_QUALITE_5 = "BBBBBBBBBB";

    private static final String DEFAULT_QUALITE_6 = "AAAAAAAAAA";
    private static final String UPDATED_QUALITE_6 = "BBBBBBBBBB";

    private static final String DEFAULT_QUALITE_7 = "AAAAAAAAAA";
    private static final String UPDATED_QUALITE_7 = "BBBBBBBBBB";

    private static final String DEFAULT_QUALITE_8 = "AAAAAAAAAA";
    private static final String UPDATED_QUALITE_8 = "BBBBBBBBBB";

    private static final byte[] DEFAULT_IMAGE_1 = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_IMAGE_1 = TestUtil.createByteArray(1, "1");
    private static final String DEFAULT_IMAGE_1_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_IMAGE_1_CONTENT_TYPE = "image/png";

    private static final byte[] DEFAULT_IMAGE_2 = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_IMAGE_2 = TestUtil.createByteArray(1, "1");
    private static final String DEFAULT_IMAGE_2_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_IMAGE_2_CONTENT_TYPE = "image/png";

    private static final byte[] DEFAULT_IMAGE_3 = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_IMAGE_3 = TestUtil.createByteArray(1, "1");
    private static final String DEFAULT_IMAGE_3_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_IMAGE_3_CONTENT_TYPE = "image/png";

    private static final byte[] DEFAULT_IMAGE_4 = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_IMAGE_4 = TestUtil.createByteArray(1, "1");
    private static final String DEFAULT_IMAGE_4_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_IMAGE_4_CONTENT_TYPE = "image/png";

    private static final byte[] DEFAULT_IMAGE_5 = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_IMAGE_5 = TestUtil.createByteArray(1, "1");
    private static final String DEFAULT_IMAGE_5_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_IMAGE_5_CONTENT_TYPE = "image/png";

    private static final byte[] DEFAULT_IMAGE_6 = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_IMAGE_6 = TestUtil.createByteArray(1, "1");
    private static final String DEFAULT_IMAGE_6_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_IMAGE_6_CONTENT_TYPE = "image/png";

    private static final byte[] DEFAULT_IMAGE_7 = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_IMAGE_7 = TestUtil.createByteArray(1, "1");
    private static final String DEFAULT_IMAGE_7_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_IMAGE_7_CONTENT_TYPE = "image/png";

    private static final byte[] DEFAULT_IMAGE_8 = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_IMAGE_8 = TestUtil.createByteArray(1, "1");
    private static final String DEFAULT_IMAGE_8_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_IMAGE_8_CONTENT_TYPE = "image/png";

    @Autowired
    private EquipeRepository equipeRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restEquipeMockMvc;

    private Equipe equipe;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Equipe createEntity(EntityManager em) {
        Equipe equipe = new Equipe()
            .titreFr(DEFAULT_TITRE_FR)
            .titreEn(DEFAULT_TITRE_EN)
            .titreGer(DEFAULT_TITRE_GER)
            .titreSw(DEFAULT_TITRE_SW)
            .souTitreFr(DEFAULT_SOU_TITRE_FR)
            .souTitreEn(DEFAULT_SOU_TITRE_EN)
            .souTitreGer(DEFAULT_SOU_TITRE_GER)
            .souTitreSw(DEFAULT_SOU_TITRE_SW)
            .nom1(DEFAULT_NOM_1)
            .nom2(DEFAULT_NOM_2)
            .nom3(DEFAULT_NOM_3)
            .nom4(DEFAULT_NOM_4)
            .nom5(DEFAULT_NOM_5)
            .nom6(DEFAULT_NOM_6)
            .nom7(DEFAULT_NOM_7)
            .nom8(DEFAULT_NOM_8)
            .prenom1(DEFAULT_PRENOM_1)
            .prenom2(DEFAULT_PRENOM_2)
            .prenom3(DEFAULT_PRENOM_3)
            .prenom4(DEFAULT_PRENOM_4)
            .prenom5(DEFAULT_PRENOM_5)
            .prenom6(DEFAULT_PRENOM_6)
            .prenom7(DEFAULT_PRENOM_7)
            .prenom8(DEFAULT_PRENOM_8)
            .qualite1(DEFAULT_QUALITE_1)
            .qualite2(DEFAULT_QUALITE_2)
            .qualite3(DEFAULT_QUALITE_3)
            .qualite4(DEFAULT_QUALITE_4)
            .qualite5(DEFAULT_QUALITE_5)
            .qualite6(DEFAULT_QUALITE_6)
            .qualite7(DEFAULT_QUALITE_7)
            .qualite8(DEFAULT_QUALITE_8)
            .image1(DEFAULT_IMAGE_1)
            .image1ContentType(DEFAULT_IMAGE_1_CONTENT_TYPE)
            .image2(DEFAULT_IMAGE_2)
            .image2ContentType(DEFAULT_IMAGE_2_CONTENT_TYPE)
            .image3(DEFAULT_IMAGE_3)
            .image3ContentType(DEFAULT_IMAGE_3_CONTENT_TYPE)
            .image4(DEFAULT_IMAGE_4)
            .image4ContentType(DEFAULT_IMAGE_4_CONTENT_TYPE)
            .image5(DEFAULT_IMAGE_5)
            .image5ContentType(DEFAULT_IMAGE_5_CONTENT_TYPE)
            .image6(DEFAULT_IMAGE_6)
            .image6ContentType(DEFAULT_IMAGE_6_CONTENT_TYPE)
            .image7(DEFAULT_IMAGE_7)
            .image7ContentType(DEFAULT_IMAGE_7_CONTENT_TYPE)
            .image8(DEFAULT_IMAGE_8)
            .image8ContentType(DEFAULT_IMAGE_8_CONTENT_TYPE);
        return equipe;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Equipe createUpdatedEntity(EntityManager em) {
        Equipe equipe = new Equipe()
            .titreFr(UPDATED_TITRE_FR)
            .titreEn(UPDATED_TITRE_EN)
            .titreGer(UPDATED_TITRE_GER)
            .titreSw(UPDATED_TITRE_SW)
            .souTitreFr(UPDATED_SOU_TITRE_FR)
            .souTitreEn(UPDATED_SOU_TITRE_EN)
            .souTitreGer(UPDATED_SOU_TITRE_GER)
            .souTitreSw(UPDATED_SOU_TITRE_SW)
            .nom1(UPDATED_NOM_1)
            .nom2(UPDATED_NOM_2)
            .nom3(UPDATED_NOM_3)
            .nom4(UPDATED_NOM_4)
            .nom5(UPDATED_NOM_5)
            .nom6(UPDATED_NOM_6)
            .nom7(UPDATED_NOM_7)
            .nom8(UPDATED_NOM_8)
            .prenom1(UPDATED_PRENOM_1)
            .prenom2(UPDATED_PRENOM_2)
            .prenom3(UPDATED_PRENOM_3)
            .prenom4(UPDATED_PRENOM_4)
            .prenom5(UPDATED_PRENOM_5)
            .prenom6(UPDATED_PRENOM_6)
            .prenom7(UPDATED_PRENOM_7)
            .prenom8(UPDATED_PRENOM_8)
            .qualite1(UPDATED_QUALITE_1)
            .qualite2(UPDATED_QUALITE_2)
            .qualite3(UPDATED_QUALITE_3)
            .qualite4(UPDATED_QUALITE_4)
            .qualite5(UPDATED_QUALITE_5)
            .qualite6(UPDATED_QUALITE_6)
            .qualite7(UPDATED_QUALITE_7)
            .qualite8(UPDATED_QUALITE_8)
            .image1(UPDATED_IMAGE_1)
            .image1ContentType(UPDATED_IMAGE_1_CONTENT_TYPE)
            .image2(UPDATED_IMAGE_2)
            .image2ContentType(UPDATED_IMAGE_2_CONTENT_TYPE)
            .image3(UPDATED_IMAGE_3)
            .image3ContentType(UPDATED_IMAGE_3_CONTENT_TYPE)
            .image4(UPDATED_IMAGE_4)
            .image4ContentType(UPDATED_IMAGE_4_CONTENT_TYPE)
            .image5(UPDATED_IMAGE_5)
            .image5ContentType(UPDATED_IMAGE_5_CONTENT_TYPE)
            .image6(UPDATED_IMAGE_6)
            .image6ContentType(UPDATED_IMAGE_6_CONTENT_TYPE)
            .image7(UPDATED_IMAGE_7)
            .image7ContentType(UPDATED_IMAGE_7_CONTENT_TYPE)
            .image8(UPDATED_IMAGE_8)
            .image8ContentType(UPDATED_IMAGE_8_CONTENT_TYPE);
        return equipe;
    }

    @BeforeEach
    public void initTest() {
        equipe = createEntity(em);
    }

    @Test
    @Transactional
    public void createEquipe() throws Exception {
        int databaseSizeBeforeCreate = equipeRepository.findAll().size();

        // Create the Equipe
        restEquipeMockMvc.perform(post("/api/equipes")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(equipe)))
            .andExpect(status().isCreated());

        // Validate the Equipe in the database
        List<Equipe> equipeList = equipeRepository.findAll();
        assertThat(equipeList).hasSize(databaseSizeBeforeCreate + 1);
        Equipe testEquipe = equipeList.get(equipeList.size() - 1);
        assertThat(testEquipe.getTitreFr()).isEqualTo(DEFAULT_TITRE_FR);
        assertThat(testEquipe.getTitreEn()).isEqualTo(DEFAULT_TITRE_EN);
        assertThat(testEquipe.getTitreGer()).isEqualTo(DEFAULT_TITRE_GER);
        assertThat(testEquipe.getTitreSw()).isEqualTo(DEFAULT_TITRE_SW);
        assertThat(testEquipe.getSouTitreFr()).isEqualTo(DEFAULT_SOU_TITRE_FR);
        assertThat(testEquipe.getSouTitreEn()).isEqualTo(DEFAULT_SOU_TITRE_EN);
        assertThat(testEquipe.getSouTitreGer()).isEqualTo(DEFAULT_SOU_TITRE_GER);
        assertThat(testEquipe.getSouTitreSw()).isEqualTo(DEFAULT_SOU_TITRE_SW);
        assertThat(testEquipe.getNom1()).isEqualTo(DEFAULT_NOM_1);
        assertThat(testEquipe.getNom2()).isEqualTo(DEFAULT_NOM_2);
        assertThat(testEquipe.getNom3()).isEqualTo(DEFAULT_NOM_3);
        assertThat(testEquipe.getNom4()).isEqualTo(DEFAULT_NOM_4);
        assertThat(testEquipe.getNom5()).isEqualTo(DEFAULT_NOM_5);
        assertThat(testEquipe.getNom6()).isEqualTo(DEFAULT_NOM_6);
        assertThat(testEquipe.getNom7()).isEqualTo(DEFAULT_NOM_7);
        assertThat(testEquipe.getNom8()).isEqualTo(DEFAULT_NOM_8);
        assertThat(testEquipe.getPrenom1()).isEqualTo(DEFAULT_PRENOM_1);
        assertThat(testEquipe.getPrenom2()).isEqualTo(DEFAULT_PRENOM_2);
        assertThat(testEquipe.getPrenom3()).isEqualTo(DEFAULT_PRENOM_3);
        assertThat(testEquipe.getPrenom4()).isEqualTo(DEFAULT_PRENOM_4);
        assertThat(testEquipe.getPrenom5()).isEqualTo(DEFAULT_PRENOM_5);
        assertThat(testEquipe.getPrenom6()).isEqualTo(DEFAULT_PRENOM_6);
        assertThat(testEquipe.getPrenom7()).isEqualTo(DEFAULT_PRENOM_7);
        assertThat(testEquipe.getPrenom8()).isEqualTo(DEFAULT_PRENOM_8);
        assertThat(testEquipe.getQualite1()).isEqualTo(DEFAULT_QUALITE_1);
        assertThat(testEquipe.getQualite2()).isEqualTo(DEFAULT_QUALITE_2);
        assertThat(testEquipe.getQualite3()).isEqualTo(DEFAULT_QUALITE_3);
        assertThat(testEquipe.getQualite4()).isEqualTo(DEFAULT_QUALITE_4);
        assertThat(testEquipe.getQualite5()).isEqualTo(DEFAULT_QUALITE_5);
        assertThat(testEquipe.getQualite6()).isEqualTo(DEFAULT_QUALITE_6);
        assertThat(testEquipe.getQualite7()).isEqualTo(DEFAULT_QUALITE_7);
        assertThat(testEquipe.getQualite8()).isEqualTo(DEFAULT_QUALITE_8);
        assertThat(testEquipe.getImage1()).isEqualTo(DEFAULT_IMAGE_1);
        assertThat(testEquipe.getImage1ContentType()).isEqualTo(DEFAULT_IMAGE_1_CONTENT_TYPE);
        assertThat(testEquipe.getImage2()).isEqualTo(DEFAULT_IMAGE_2);
        assertThat(testEquipe.getImage2ContentType()).isEqualTo(DEFAULT_IMAGE_2_CONTENT_TYPE);
        assertThat(testEquipe.getImage3()).isEqualTo(DEFAULT_IMAGE_3);
        assertThat(testEquipe.getImage3ContentType()).isEqualTo(DEFAULT_IMAGE_3_CONTENT_TYPE);
        assertThat(testEquipe.getImage4()).isEqualTo(DEFAULT_IMAGE_4);
        assertThat(testEquipe.getImage4ContentType()).isEqualTo(DEFAULT_IMAGE_4_CONTENT_TYPE);
        assertThat(testEquipe.getImage5()).isEqualTo(DEFAULT_IMAGE_5);
        assertThat(testEquipe.getImage5ContentType()).isEqualTo(DEFAULT_IMAGE_5_CONTENT_TYPE);
        assertThat(testEquipe.getImage6()).isEqualTo(DEFAULT_IMAGE_6);
        assertThat(testEquipe.getImage6ContentType()).isEqualTo(DEFAULT_IMAGE_6_CONTENT_TYPE);
        assertThat(testEquipe.getImage7()).isEqualTo(DEFAULT_IMAGE_7);
        assertThat(testEquipe.getImage7ContentType()).isEqualTo(DEFAULT_IMAGE_7_CONTENT_TYPE);
        assertThat(testEquipe.getImage8()).isEqualTo(DEFAULT_IMAGE_8);
        assertThat(testEquipe.getImage8ContentType()).isEqualTo(DEFAULT_IMAGE_8_CONTENT_TYPE);
    }

    @Test
    @Transactional
    public void createEquipeWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = equipeRepository.findAll().size();

        // Create the Equipe with an existing ID
        equipe.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restEquipeMockMvc.perform(post("/api/equipes")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(equipe)))
            .andExpect(status().isBadRequest());

        // Validate the Equipe in the database
        List<Equipe> equipeList = equipeRepository.findAll();
        assertThat(equipeList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllEquipes() throws Exception {
        // Initialize the database
        equipeRepository.saveAndFlush(equipe);

        // Get all the equipeList
        restEquipeMockMvc.perform(get("/api/equipes?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(equipe.getId().intValue())))
            .andExpect(jsonPath("$.[*].titreFr").value(hasItem(DEFAULT_TITRE_FR)))
            .andExpect(jsonPath("$.[*].titreEn").value(hasItem(DEFAULT_TITRE_EN)))
            .andExpect(jsonPath("$.[*].titreGer").value(hasItem(DEFAULT_TITRE_GER)))
            .andExpect(jsonPath("$.[*].titreSw").value(hasItem(DEFAULT_TITRE_SW)))
            .andExpect(jsonPath("$.[*].souTitreFr").value(hasItem(DEFAULT_SOU_TITRE_FR)))
            .andExpect(jsonPath("$.[*].souTitreEn").value(hasItem(DEFAULT_SOU_TITRE_EN)))
            .andExpect(jsonPath("$.[*].souTitreGer").value(hasItem(DEFAULT_SOU_TITRE_GER)))
            .andExpect(jsonPath("$.[*].souTitreSw").value(hasItem(DEFAULT_SOU_TITRE_SW)))
            .andExpect(jsonPath("$.[*].nom1").value(hasItem(DEFAULT_NOM_1)))
            .andExpect(jsonPath("$.[*].nom2").value(hasItem(DEFAULT_NOM_2)))
            .andExpect(jsonPath("$.[*].nom3").value(hasItem(DEFAULT_NOM_3)))
            .andExpect(jsonPath("$.[*].nom4").value(hasItem(DEFAULT_NOM_4)))
            .andExpect(jsonPath("$.[*].nom5").value(hasItem(DEFAULT_NOM_5)))
            .andExpect(jsonPath("$.[*].nom6").value(hasItem(DEFAULT_NOM_6)))
            .andExpect(jsonPath("$.[*].nom7").value(hasItem(DEFAULT_NOM_7)))
            .andExpect(jsonPath("$.[*].nom8").value(hasItem(DEFAULT_NOM_8)))
            .andExpect(jsonPath("$.[*].prenom1").value(hasItem(DEFAULT_PRENOM_1)))
            .andExpect(jsonPath("$.[*].prenom2").value(hasItem(DEFAULT_PRENOM_2)))
            .andExpect(jsonPath("$.[*].prenom3").value(hasItem(DEFAULT_PRENOM_3)))
            .andExpect(jsonPath("$.[*].prenom4").value(hasItem(DEFAULT_PRENOM_4)))
            .andExpect(jsonPath("$.[*].prenom5").value(hasItem(DEFAULT_PRENOM_5)))
            .andExpect(jsonPath("$.[*].prenom6").value(hasItem(DEFAULT_PRENOM_6)))
            .andExpect(jsonPath("$.[*].prenom7").value(hasItem(DEFAULT_PRENOM_7)))
            .andExpect(jsonPath("$.[*].prenom8").value(hasItem(DEFAULT_PRENOM_8)))
            .andExpect(jsonPath("$.[*].qualite1").value(hasItem(DEFAULT_QUALITE_1)))
            .andExpect(jsonPath("$.[*].qualite2").value(hasItem(DEFAULT_QUALITE_2)))
            .andExpect(jsonPath("$.[*].qualite3").value(hasItem(DEFAULT_QUALITE_3)))
            .andExpect(jsonPath("$.[*].qualite4").value(hasItem(DEFAULT_QUALITE_4)))
            .andExpect(jsonPath("$.[*].qualite5").value(hasItem(DEFAULT_QUALITE_5)))
            .andExpect(jsonPath("$.[*].qualite6").value(hasItem(DEFAULT_QUALITE_6)))
            .andExpect(jsonPath("$.[*].qualite7").value(hasItem(DEFAULT_QUALITE_7)))
            .andExpect(jsonPath("$.[*].qualite8").value(hasItem(DEFAULT_QUALITE_8)))
            .andExpect(jsonPath("$.[*].image1ContentType").value(hasItem(DEFAULT_IMAGE_1_CONTENT_TYPE)))
            .andExpect(jsonPath("$.[*].image1").value(hasItem(Base64Utils.encodeToString(DEFAULT_IMAGE_1))))
            .andExpect(jsonPath("$.[*].image2ContentType").value(hasItem(DEFAULT_IMAGE_2_CONTENT_TYPE)))
            .andExpect(jsonPath("$.[*].image2").value(hasItem(Base64Utils.encodeToString(DEFAULT_IMAGE_2))))
            .andExpect(jsonPath("$.[*].image3ContentType").value(hasItem(DEFAULT_IMAGE_3_CONTENT_TYPE)))
            .andExpect(jsonPath("$.[*].image3").value(hasItem(Base64Utils.encodeToString(DEFAULT_IMAGE_3))))
            .andExpect(jsonPath("$.[*].image4ContentType").value(hasItem(DEFAULT_IMAGE_4_CONTENT_TYPE)))
            .andExpect(jsonPath("$.[*].image4").value(hasItem(Base64Utils.encodeToString(DEFAULT_IMAGE_4))))
            .andExpect(jsonPath("$.[*].image5ContentType").value(hasItem(DEFAULT_IMAGE_5_CONTENT_TYPE)))
            .andExpect(jsonPath("$.[*].image5").value(hasItem(Base64Utils.encodeToString(DEFAULT_IMAGE_5))))
            .andExpect(jsonPath("$.[*].image6ContentType").value(hasItem(DEFAULT_IMAGE_6_CONTENT_TYPE)))
            .andExpect(jsonPath("$.[*].image6").value(hasItem(Base64Utils.encodeToString(DEFAULT_IMAGE_6))))
            .andExpect(jsonPath("$.[*].image7ContentType").value(hasItem(DEFAULT_IMAGE_7_CONTENT_TYPE)))
            .andExpect(jsonPath("$.[*].image7").value(hasItem(Base64Utils.encodeToString(DEFAULT_IMAGE_7))))
            .andExpect(jsonPath("$.[*].image8ContentType").value(hasItem(DEFAULT_IMAGE_8_CONTENT_TYPE)))
            .andExpect(jsonPath("$.[*].image8").value(hasItem(Base64Utils.encodeToString(DEFAULT_IMAGE_8))));
    }
    
    @Test
    @Transactional
    public void getEquipe() throws Exception {
        // Initialize the database
        equipeRepository.saveAndFlush(equipe);

        // Get the equipe
        restEquipeMockMvc.perform(get("/api/equipes/{id}", equipe.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(equipe.getId().intValue()))
            .andExpect(jsonPath("$.titreFr").value(DEFAULT_TITRE_FR))
            .andExpect(jsonPath("$.titreEn").value(DEFAULT_TITRE_EN))
            .andExpect(jsonPath("$.titreGer").value(DEFAULT_TITRE_GER))
            .andExpect(jsonPath("$.titreSw").value(DEFAULT_TITRE_SW))
            .andExpect(jsonPath("$.souTitreFr").value(DEFAULT_SOU_TITRE_FR))
            .andExpect(jsonPath("$.souTitreEn").value(DEFAULT_SOU_TITRE_EN))
            .andExpect(jsonPath("$.souTitreGer").value(DEFAULT_SOU_TITRE_GER))
            .andExpect(jsonPath("$.souTitreSw").value(DEFAULT_SOU_TITRE_SW))
            .andExpect(jsonPath("$.nom1").value(DEFAULT_NOM_1))
            .andExpect(jsonPath("$.nom2").value(DEFAULT_NOM_2))
            .andExpect(jsonPath("$.nom3").value(DEFAULT_NOM_3))
            .andExpect(jsonPath("$.nom4").value(DEFAULT_NOM_4))
            .andExpect(jsonPath("$.nom5").value(DEFAULT_NOM_5))
            .andExpect(jsonPath("$.nom6").value(DEFAULT_NOM_6))
            .andExpect(jsonPath("$.nom7").value(DEFAULT_NOM_7))
            .andExpect(jsonPath("$.nom8").value(DEFAULT_NOM_8))
            .andExpect(jsonPath("$.prenom1").value(DEFAULT_PRENOM_1))
            .andExpect(jsonPath("$.prenom2").value(DEFAULT_PRENOM_2))
            .andExpect(jsonPath("$.prenom3").value(DEFAULT_PRENOM_3))
            .andExpect(jsonPath("$.prenom4").value(DEFAULT_PRENOM_4))
            .andExpect(jsonPath("$.prenom5").value(DEFAULT_PRENOM_5))
            .andExpect(jsonPath("$.prenom6").value(DEFAULT_PRENOM_6))
            .andExpect(jsonPath("$.prenom7").value(DEFAULT_PRENOM_7))
            .andExpect(jsonPath("$.prenom8").value(DEFAULT_PRENOM_8))
            .andExpect(jsonPath("$.qualite1").value(DEFAULT_QUALITE_1))
            .andExpect(jsonPath("$.qualite2").value(DEFAULT_QUALITE_2))
            .andExpect(jsonPath("$.qualite3").value(DEFAULT_QUALITE_3))
            .andExpect(jsonPath("$.qualite4").value(DEFAULT_QUALITE_4))
            .andExpect(jsonPath("$.qualite5").value(DEFAULT_QUALITE_5))
            .andExpect(jsonPath("$.qualite6").value(DEFAULT_QUALITE_6))
            .andExpect(jsonPath("$.qualite7").value(DEFAULT_QUALITE_7))
            .andExpect(jsonPath("$.qualite8").value(DEFAULT_QUALITE_8))
            .andExpect(jsonPath("$.image1ContentType").value(DEFAULT_IMAGE_1_CONTENT_TYPE))
            .andExpect(jsonPath("$.image1").value(Base64Utils.encodeToString(DEFAULT_IMAGE_1)))
            .andExpect(jsonPath("$.image2ContentType").value(DEFAULT_IMAGE_2_CONTENT_TYPE))
            .andExpect(jsonPath("$.image2").value(Base64Utils.encodeToString(DEFAULT_IMAGE_2)))
            .andExpect(jsonPath("$.image3ContentType").value(DEFAULT_IMAGE_3_CONTENT_TYPE))
            .andExpect(jsonPath("$.image3").value(Base64Utils.encodeToString(DEFAULT_IMAGE_3)))
            .andExpect(jsonPath("$.image4ContentType").value(DEFAULT_IMAGE_4_CONTENT_TYPE))
            .andExpect(jsonPath("$.image4").value(Base64Utils.encodeToString(DEFAULT_IMAGE_4)))
            .andExpect(jsonPath("$.image5ContentType").value(DEFAULT_IMAGE_5_CONTENT_TYPE))
            .andExpect(jsonPath("$.image5").value(Base64Utils.encodeToString(DEFAULT_IMAGE_5)))
            .andExpect(jsonPath("$.image6ContentType").value(DEFAULT_IMAGE_6_CONTENT_TYPE))
            .andExpect(jsonPath("$.image6").value(Base64Utils.encodeToString(DEFAULT_IMAGE_6)))
            .andExpect(jsonPath("$.image7ContentType").value(DEFAULT_IMAGE_7_CONTENT_TYPE))
            .andExpect(jsonPath("$.image7").value(Base64Utils.encodeToString(DEFAULT_IMAGE_7)))
            .andExpect(jsonPath("$.image8ContentType").value(DEFAULT_IMAGE_8_CONTENT_TYPE))
            .andExpect(jsonPath("$.image8").value(Base64Utils.encodeToString(DEFAULT_IMAGE_8)));
    }

    @Test
    @Transactional
    public void getNonExistingEquipe() throws Exception {
        // Get the equipe
        restEquipeMockMvc.perform(get("/api/equipes/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateEquipe() throws Exception {
        // Initialize the database
        equipeRepository.saveAndFlush(equipe);

        int databaseSizeBeforeUpdate = equipeRepository.findAll().size();

        // Update the equipe
        Equipe updatedEquipe = equipeRepository.findById(equipe.getId()).get();
        // Disconnect from session so that the updates on updatedEquipe are not directly saved in db
        em.detach(updatedEquipe);
        updatedEquipe
            .titreFr(UPDATED_TITRE_FR)
            .titreEn(UPDATED_TITRE_EN)
            .titreGer(UPDATED_TITRE_GER)
            .titreSw(UPDATED_TITRE_SW)
            .souTitreFr(UPDATED_SOU_TITRE_FR)
            .souTitreEn(UPDATED_SOU_TITRE_EN)
            .souTitreGer(UPDATED_SOU_TITRE_GER)
            .souTitreSw(UPDATED_SOU_TITRE_SW)
            .nom1(UPDATED_NOM_1)
            .nom2(UPDATED_NOM_2)
            .nom3(UPDATED_NOM_3)
            .nom4(UPDATED_NOM_4)
            .nom5(UPDATED_NOM_5)
            .nom6(UPDATED_NOM_6)
            .nom7(UPDATED_NOM_7)
            .nom8(UPDATED_NOM_8)
            .prenom1(UPDATED_PRENOM_1)
            .prenom2(UPDATED_PRENOM_2)
            .prenom3(UPDATED_PRENOM_3)
            .prenom4(UPDATED_PRENOM_4)
            .prenom5(UPDATED_PRENOM_5)
            .prenom6(UPDATED_PRENOM_6)
            .prenom7(UPDATED_PRENOM_7)
            .prenom8(UPDATED_PRENOM_8)
            .qualite1(UPDATED_QUALITE_1)
            .qualite2(UPDATED_QUALITE_2)
            .qualite3(UPDATED_QUALITE_3)
            .qualite4(UPDATED_QUALITE_4)
            .qualite5(UPDATED_QUALITE_5)
            .qualite6(UPDATED_QUALITE_6)
            .qualite7(UPDATED_QUALITE_7)
            .qualite8(UPDATED_QUALITE_8)
            .image1(UPDATED_IMAGE_1)
            .image1ContentType(UPDATED_IMAGE_1_CONTENT_TYPE)
            .image2(UPDATED_IMAGE_2)
            .image2ContentType(UPDATED_IMAGE_2_CONTENT_TYPE)
            .image3(UPDATED_IMAGE_3)
            .image3ContentType(UPDATED_IMAGE_3_CONTENT_TYPE)
            .image4(UPDATED_IMAGE_4)
            .image4ContentType(UPDATED_IMAGE_4_CONTENT_TYPE)
            .image5(UPDATED_IMAGE_5)
            .image5ContentType(UPDATED_IMAGE_5_CONTENT_TYPE)
            .image6(UPDATED_IMAGE_6)
            .image6ContentType(UPDATED_IMAGE_6_CONTENT_TYPE)
            .image7(UPDATED_IMAGE_7)
            .image7ContentType(UPDATED_IMAGE_7_CONTENT_TYPE)
            .image8(UPDATED_IMAGE_8)
            .image8ContentType(UPDATED_IMAGE_8_CONTENT_TYPE);

        restEquipeMockMvc.perform(put("/api/equipes")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(updatedEquipe)))
            .andExpect(status().isOk());

        // Validate the Equipe in the database
        List<Equipe> equipeList = equipeRepository.findAll();
        assertThat(equipeList).hasSize(databaseSizeBeforeUpdate);
        Equipe testEquipe = equipeList.get(equipeList.size() - 1);
        assertThat(testEquipe.getTitreFr()).isEqualTo(UPDATED_TITRE_FR);
        assertThat(testEquipe.getTitreEn()).isEqualTo(UPDATED_TITRE_EN);
        assertThat(testEquipe.getTitreGer()).isEqualTo(UPDATED_TITRE_GER);
        assertThat(testEquipe.getTitreSw()).isEqualTo(UPDATED_TITRE_SW);
        assertThat(testEquipe.getSouTitreFr()).isEqualTo(UPDATED_SOU_TITRE_FR);
        assertThat(testEquipe.getSouTitreEn()).isEqualTo(UPDATED_SOU_TITRE_EN);
        assertThat(testEquipe.getSouTitreGer()).isEqualTo(UPDATED_SOU_TITRE_GER);
        assertThat(testEquipe.getSouTitreSw()).isEqualTo(UPDATED_SOU_TITRE_SW);
        assertThat(testEquipe.getNom1()).isEqualTo(UPDATED_NOM_1);
        assertThat(testEquipe.getNom2()).isEqualTo(UPDATED_NOM_2);
        assertThat(testEquipe.getNom3()).isEqualTo(UPDATED_NOM_3);
        assertThat(testEquipe.getNom4()).isEqualTo(UPDATED_NOM_4);
        assertThat(testEquipe.getNom5()).isEqualTo(UPDATED_NOM_5);
        assertThat(testEquipe.getNom6()).isEqualTo(UPDATED_NOM_6);
        assertThat(testEquipe.getNom7()).isEqualTo(UPDATED_NOM_7);
        assertThat(testEquipe.getNom8()).isEqualTo(UPDATED_NOM_8);
        assertThat(testEquipe.getPrenom1()).isEqualTo(UPDATED_PRENOM_1);
        assertThat(testEquipe.getPrenom2()).isEqualTo(UPDATED_PRENOM_2);
        assertThat(testEquipe.getPrenom3()).isEqualTo(UPDATED_PRENOM_3);
        assertThat(testEquipe.getPrenom4()).isEqualTo(UPDATED_PRENOM_4);
        assertThat(testEquipe.getPrenom5()).isEqualTo(UPDATED_PRENOM_5);
        assertThat(testEquipe.getPrenom6()).isEqualTo(UPDATED_PRENOM_6);
        assertThat(testEquipe.getPrenom7()).isEqualTo(UPDATED_PRENOM_7);
        assertThat(testEquipe.getPrenom8()).isEqualTo(UPDATED_PRENOM_8);
        assertThat(testEquipe.getQualite1()).isEqualTo(UPDATED_QUALITE_1);
        assertThat(testEquipe.getQualite2()).isEqualTo(UPDATED_QUALITE_2);
        assertThat(testEquipe.getQualite3()).isEqualTo(UPDATED_QUALITE_3);
        assertThat(testEquipe.getQualite4()).isEqualTo(UPDATED_QUALITE_4);
        assertThat(testEquipe.getQualite5()).isEqualTo(UPDATED_QUALITE_5);
        assertThat(testEquipe.getQualite6()).isEqualTo(UPDATED_QUALITE_6);
        assertThat(testEquipe.getQualite7()).isEqualTo(UPDATED_QUALITE_7);
        assertThat(testEquipe.getQualite8()).isEqualTo(UPDATED_QUALITE_8);
        assertThat(testEquipe.getImage1()).isEqualTo(UPDATED_IMAGE_1);
        assertThat(testEquipe.getImage1ContentType()).isEqualTo(UPDATED_IMAGE_1_CONTENT_TYPE);
        assertThat(testEquipe.getImage2()).isEqualTo(UPDATED_IMAGE_2);
        assertThat(testEquipe.getImage2ContentType()).isEqualTo(UPDATED_IMAGE_2_CONTENT_TYPE);
        assertThat(testEquipe.getImage3()).isEqualTo(UPDATED_IMAGE_3);
        assertThat(testEquipe.getImage3ContentType()).isEqualTo(UPDATED_IMAGE_3_CONTENT_TYPE);
        assertThat(testEquipe.getImage4()).isEqualTo(UPDATED_IMAGE_4);
        assertThat(testEquipe.getImage4ContentType()).isEqualTo(UPDATED_IMAGE_4_CONTENT_TYPE);
        assertThat(testEquipe.getImage5()).isEqualTo(UPDATED_IMAGE_5);
        assertThat(testEquipe.getImage5ContentType()).isEqualTo(UPDATED_IMAGE_5_CONTENT_TYPE);
        assertThat(testEquipe.getImage6()).isEqualTo(UPDATED_IMAGE_6);
        assertThat(testEquipe.getImage6ContentType()).isEqualTo(UPDATED_IMAGE_6_CONTENT_TYPE);
        assertThat(testEquipe.getImage7()).isEqualTo(UPDATED_IMAGE_7);
        assertThat(testEquipe.getImage7ContentType()).isEqualTo(UPDATED_IMAGE_7_CONTENT_TYPE);
        assertThat(testEquipe.getImage8()).isEqualTo(UPDATED_IMAGE_8);
        assertThat(testEquipe.getImage8ContentType()).isEqualTo(UPDATED_IMAGE_8_CONTENT_TYPE);
    }

    @Test
    @Transactional
    public void updateNonExistingEquipe() throws Exception {
        int databaseSizeBeforeUpdate = equipeRepository.findAll().size();

        // Create the Equipe

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restEquipeMockMvc.perform(put("/api/equipes")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(equipe)))
            .andExpect(status().isBadRequest());

        // Validate the Equipe in the database
        List<Equipe> equipeList = equipeRepository.findAll();
        assertThat(equipeList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteEquipe() throws Exception {
        // Initialize the database
        equipeRepository.saveAndFlush(equipe);

        int databaseSizeBeforeDelete = equipeRepository.findAll().size();

        // Delete the equipe
        restEquipeMockMvc.perform(delete("/api/equipes/{id}", equipe.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<Equipe> equipeList = equipeRepository.findAll();
        assertThat(equipeList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
