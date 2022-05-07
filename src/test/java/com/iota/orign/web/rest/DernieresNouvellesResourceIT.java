package com.iota.orign.web.rest;

import com.iota.orign.IotaOrignAdminApp;
import com.iota.orign.domain.DernieresNouvelles;
import com.iota.orign.repository.DernieresNouvellesRepository;

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
 * Integration tests for the {@link DernieresNouvellesResource} REST controller.
 */
@SpringBootTest(classes = IotaOrignAdminApp.class)

@AutoConfigureMockMvc
@WithMockUser
public class DernieresNouvellesResourceIT {

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

    private static final String DEFAULT_TITRE_SLIDE_1_FR = "AAAAAAAAAA";
    private static final String UPDATED_TITRE_SLIDE_1_FR = "BBBBBBBBBB";

    private static final String DEFAULT_TITRE_SLIDE_1_EN = "AAAAAAAAAA";
    private static final String UPDATED_TITRE_SLIDE_1_EN = "BBBBBBBBBB";

    private static final String DEFAULT_TITRE_SLIDE_1_GER = "AAAAAAAAAA";
    private static final String UPDATED_TITRE_SLIDE_1_GER = "BBBBBBBBBB";

    private static final String DEFAULT_TITRE_SLIDE_1_SW = "AAAAAAAAAA";
    private static final String UPDATED_TITRE_SLIDE_1_SW = "BBBBBBBBBB";

    private static final String DEFAULT_TITRE_SLIDE_2_FR = "AAAAAAAAAA";
    private static final String UPDATED_TITRE_SLIDE_2_FR = "BBBBBBBBBB";

    private static final String DEFAULT_TITRE_SLIDE_2_EN = "AAAAAAAAAA";
    private static final String UPDATED_TITRE_SLIDE_2_EN = "BBBBBBBBBB";

    private static final String DEFAULT_TITRE_SLIDE_2_GER = "AAAAAAAAAA";
    private static final String UPDATED_TITRE_SLIDE_2_GER = "BBBBBBBBBB";

    private static final String DEFAULT_TITRE_SLIDE_2_SW = "AAAAAAAAAA";
    private static final String UPDATED_TITRE_SLIDE_2_SW = "BBBBBBBBBB";

    private static final String DEFAULT_TITRE_SLIDE_3_FR = "AAAAAAAAAA";
    private static final String UPDATED_TITRE_SLIDE_3_FR = "BBBBBBBBBB";

    private static final String DEFAULT_TITRE_SLIDE_3_EN = "AAAAAAAAAA";
    private static final String UPDATED_TITRE_SLIDE_3_EN = "BBBBBBBBBB";

    private static final String DEFAULT_TITRE_SLIDE_3_GER = "AAAAAAAAAA";
    private static final String UPDATED_TITRE_SLIDE_3_GER = "BBBBBBBBBB";

    private static final String DEFAULT_TITRE_SLIDE_3_SW = "AAAAAAAAAA";
    private static final String UPDATED_TITRE_SLIDE_3_SW = "BBBBBBBBBB";

    private static final String DEFAULT_TITRE_SLIDE_4_FR = "AAAAAAAAAA";
    private static final String UPDATED_TITRE_SLIDE_4_FR = "BBBBBBBBBB";

    private static final String DEFAULT_TITRE_SLIDE_4_EN = "AAAAAAAAAA";
    private static final String UPDATED_TITRE_SLIDE_4_EN = "BBBBBBBBBB";

    private static final String DEFAULT_TITRE_SLIDE_4_GER = "AAAAAAAAAA";
    private static final String UPDATED_TITRE_SLIDE_4_GER = "BBBBBBBBBB";

    private static final String DEFAULT_TITRE_SLIDE_4_SW = "AAAAAAAAAA";
    private static final String UPDATED_TITRE_SLIDE_4_SW = "BBBBBBBBBB";

    private static final String DEFAULT_TITRE_SLIDE_5_FR = "AAAAAAAAAA";
    private static final String UPDATED_TITRE_SLIDE_5_FR = "BBBBBBBBBB";

    private static final String DEFAULT_TITRE_SLIDE_5_EN = "AAAAAAAAAA";
    private static final String UPDATED_TITRE_SLIDE_5_EN = "BBBBBBBBBB";

    private static final String DEFAULT_TITRE_SLIDE_5_GER = "AAAAAAAAAA";
    private static final String UPDATED_TITRE_SLIDE_5_GER = "BBBBBBBBBB";

    private static final String DEFAULT_TITRE_SLIDE_5_SW = "AAAAAAAAAA";
    private static final String UPDATED_TITRE_SLIDE_5_SW = "BBBBBBBBBB";

    private static final String DEFAULT_TITRE_SLIDE_6_FR = "AAAAAAAAAA";
    private static final String UPDATED_TITRE_SLIDE_6_FR = "BBBBBBBBBB";

    private static final String DEFAULT_TITRE_SLIDE_6_EN = "AAAAAAAAAA";
    private static final String UPDATED_TITRE_SLIDE_6_EN = "BBBBBBBBBB";

    private static final String DEFAULT_TITRE_SLIDE_6_GER = "AAAAAAAAAA";
    private static final String UPDATED_TITRE_SLIDE_6_GER = "BBBBBBBBBB";

    private static final String DEFAULT_TITRE_SLIDE_6_SW = "AAAAAAAAAA";
    private static final String UPDATED_TITRE_SLIDE_6_SW = "BBBBBBBBBB";

    private static final String DEFAULT_TITRE_SLIDE_7_FR = "AAAAAAAAAA";
    private static final String UPDATED_TITRE_SLIDE_7_FR = "BBBBBBBBBB";

    private static final String DEFAULT_TITRE_SLIDE_7_EN = "AAAAAAAAAA";
    private static final String UPDATED_TITRE_SLIDE_7_EN = "BBBBBBBBBB";

    private static final String DEFAULT_TITRE_SLIDE_7_GER = "AAAAAAAAAA";
    private static final String UPDATED_TITRE_SLIDE_7_GER = "BBBBBBBBBB";

    private static final String DEFAULT_TITRE_SLIDE_7_SW = "AAAAAAAAAA";
    private static final String UPDATED_TITRE_SLIDE_7_SW = "BBBBBBBBBB";

    private static final String DEFAULT_TITRE_SLIDE_8_FR = "AAAAAAAAAA";
    private static final String UPDATED_TITRE_SLIDE_8_FR = "BBBBBBBBBB";

    private static final String DEFAULT_TITRE_SLIDE_8_EN = "AAAAAAAAAA";
    private static final String UPDATED_TITRE_SLIDE_8_EN = "BBBBBBBBBB";

    private static final String DEFAULT_TITRE_SLIDE_8_GER = "AAAAAAAAAA";
    private static final String UPDATED_TITRE_SLIDE_8_GER = "BBBBBBBBBB";

    private static final String DEFAULT_TITRE_SLIDE_8_SW = "AAAAAAAAAA";
    private static final String UPDATED_TITRE_SLIDE_8_SW = "BBBBBBBBBB";

    private static final String DEFAULT_TITRE_SLIDE_9_FR = "AAAAAAAAAA";
    private static final String UPDATED_TITRE_SLIDE_9_FR = "BBBBBBBBBB";

    private static final String DEFAULT_TITRE_SLIDE_9_EN = "AAAAAAAAAA";
    private static final String UPDATED_TITRE_SLIDE_9_EN = "BBBBBBBBBB";

    private static final String DEFAULT_TITRE_SLIDE_9_GER = "AAAAAAAAAA";
    private static final String UPDATED_TITRE_SLIDE_9_GER = "BBBBBBBBBB";

    private static final String DEFAULT_TITRE_SLIDE_9_SW = "AAAAAAAAAA";
    private static final String UPDATED_TITRE_SLIDE_9_SW = "BBBBBBBBBB";

    private static final String DEFAULT_TITRE_SLIDE_1_O_FR = "AAAAAAAAAA";
    private static final String UPDATED_TITRE_SLIDE_1_O_FR = "BBBBBBBBBB";

    private static final String DEFAULT_TITRE_SLIDE_1_O_EN = "AAAAAAAAAA";
    private static final String UPDATED_TITRE_SLIDE_1_O_EN = "BBBBBBBBBB";

    private static final String DEFAULT_TITRE_SLIDE_1_O_GER = "AAAAAAAAAA";
    private static final String UPDATED_TITRE_SLIDE_1_O_GER = "BBBBBBBBBB";

    private static final String DEFAULT_TITRE_SLIDE_1_O_SW = "AAAAAAAAAA";
    private static final String UPDATED_TITRE_SLIDE_1_O_SW = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_SLIDE_1_FR = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_SLIDE_1_FR = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_SLIDE_1_EN = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_SLIDE_1_EN = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_SLIDE_1_GER = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_SLIDE_1_GER = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_SLIDE_1_SW = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_SLIDE_1_SW = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_SLIDE_2_FR = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_SLIDE_2_FR = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_SLIDE_2_EN = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_SLIDE_2_EN = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_SLIDE_2_GER = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_SLIDE_2_GER = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_SLIDE_2_SW = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_SLIDE_2_SW = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_SLIDE_3_FR = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_SLIDE_3_FR = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_SLIDE_3_EN = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_SLIDE_3_EN = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_SLIDE_3_GER = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_SLIDE_3_GER = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_SLIDE_3_SW = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_SLIDE_3_SW = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_SLIDE_4_FR = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_SLIDE_4_FR = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_SLIDE_4_EN = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_SLIDE_4_EN = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_SLIDE_4_GER = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_SLIDE_4_GER = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_SLIDE_4_SW = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_SLIDE_4_SW = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_SLIDE_5_FR = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_SLIDE_5_FR = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_SLIDE_5_EN = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_SLIDE_5_EN = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_SLIDE_5_GER = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_SLIDE_5_GER = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_SLIDE_5_SW = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_SLIDE_5_SW = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_SLIDE_6_FR = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_SLIDE_6_FR = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_SLIDE_6_EN = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_SLIDE_6_EN = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_SLIDE_6_GER = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_SLIDE_6_GER = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_SLIDE_6_SW = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_SLIDE_6_SW = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_SLIDE_7_FR = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_SLIDE_7_FR = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_SLIDE_7_EN = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_SLIDE_7_EN = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_SLIDE_7_GER = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_SLIDE_7_GER = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_SLIDE_7_SW = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_SLIDE_7_SW = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_SLIDE_8_FR = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_SLIDE_8_FR = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_SLIDE_8_EN = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_SLIDE_8_EN = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_SLIDE_8_GER = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_SLIDE_8_GER = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_SLIDE_8_SW = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_SLIDE_8_SW = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_SLIDE_9_FR = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_SLIDE_9_FR = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_SLIDE_9_EN = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_SLIDE_9_EN = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_SLIDE_9_GER = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_SLIDE_9_GER = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_SLIDE_9_SW = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_SLIDE_9_SW = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_SLIDE_10_FR = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_SLIDE_10_FR = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_SLIDE_10_EN = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_SLIDE_10_EN = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_SLIDE_10_GER = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_SLIDE_10_GER = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_SLIDE_10_SW = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_SLIDE_10_SW = "BBBBBBBBBB";

    private static final byte[] DEFAULT_IMAGE_SLIDE_1 = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_IMAGE_SLIDE_1 = TestUtil.createByteArray(1, "1");
    private static final String DEFAULT_IMAGE_SLIDE_1_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_IMAGE_SLIDE_1_CONTENT_TYPE = "image/png";

    private static final byte[] DEFAULT_IMAGE_SLIDE_2 = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_IMAGE_SLIDE_2 = TestUtil.createByteArray(1, "1");
    private static final String DEFAULT_IMAGE_SLIDE_2_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_IMAGE_SLIDE_2_CONTENT_TYPE = "image/png";

    private static final byte[] DEFAULT_IMAGE_SLIDE_3 = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_IMAGE_SLIDE_3 = TestUtil.createByteArray(1, "1");
    private static final String DEFAULT_IMAGE_SLIDE_3_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_IMAGE_SLIDE_3_CONTENT_TYPE = "image/png";

    private static final byte[] DEFAULT_IMAGE_SLIDE_4 = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_IMAGE_SLIDE_4 = TestUtil.createByteArray(1, "1");
    private static final String DEFAULT_IMAGE_SLIDE_4_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_IMAGE_SLIDE_4_CONTENT_TYPE = "image/png";

    private static final byte[] DEFAULT_IMAGE_SLIDE_5 = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_IMAGE_SLIDE_5 = TestUtil.createByteArray(1, "1");
    private static final String DEFAULT_IMAGE_SLIDE_5_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_IMAGE_SLIDE_5_CONTENT_TYPE = "image/png";

    private static final byte[] DEFAULT_IMAGE_SLIDE_6 = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_IMAGE_SLIDE_6 = TestUtil.createByteArray(1, "1");
    private static final String DEFAULT_IMAGE_SLIDE_6_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_IMAGE_SLIDE_6_CONTENT_TYPE = "image/png";

    private static final byte[] DEFAULT_IMAGE_SLIDE_7 = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_IMAGE_SLIDE_7 = TestUtil.createByteArray(1, "1");
    private static final String DEFAULT_IMAGE_SLIDE_7_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_IMAGE_SLIDE_7_CONTENT_TYPE = "image/png";

    private static final byte[] DEFAULT_IMAGE_SLIDE_8 = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_IMAGE_SLIDE_8 = TestUtil.createByteArray(1, "1");
    private static final String DEFAULT_IMAGE_SLIDE_8_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_IMAGE_SLIDE_8_CONTENT_TYPE = "image/png";

    private static final byte[] DEFAULT_IMAGE_SLIDE_9 = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_IMAGE_SLIDE_9 = TestUtil.createByteArray(1, "1");
    private static final String DEFAULT_IMAGE_SLIDE_9_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_IMAGE_SLIDE_9_CONTENT_TYPE = "image/png";

    private static final byte[] DEFAULT_IMAGE_SLIDE_10 = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_IMAGE_SLIDE_10 = TestUtil.createByteArray(1, "1");
    private static final String DEFAULT_IMAGE_SLIDE_10_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_IMAGE_SLIDE_10_CONTENT_TYPE = "image/png";

    private static final String DEFAULT_READ_MORE_1 = "AAAAAAAAAA";
    private static final String UPDATED_READ_MORE_1 = "BBBBBBBBBB";

    private static final String DEFAULT_READ_MORE_2 = "AAAAAAAAAA";
    private static final String UPDATED_READ_MORE_2 = "BBBBBBBBBB";

    private static final String DEFAULT_READ_MORE_3 = "AAAAAAAAAA";
    private static final String UPDATED_READ_MORE_3 = "BBBBBBBBBB";

    private static final String DEFAULT_READ_MORE_4 = "AAAAAAAAAA";
    private static final String UPDATED_READ_MORE_4 = "BBBBBBBBBB";

    private static final String DEFAULT_READ_MORE_5 = "AAAAAAAAAA";
    private static final String UPDATED_READ_MORE_5 = "BBBBBBBBBB";

    private static final String DEFAULT_READ_MORE_6 = "AAAAAAAAAA";
    private static final String UPDATED_READ_MORE_6 = "BBBBBBBBBB";

    private static final String DEFAULT_READ_MORE_7 = "AAAAAAAAAA";
    private static final String UPDATED_READ_MORE_7 = "BBBBBBBBBB";

    private static final String DEFAULT_READ_MORE_8 = "AAAAAAAAAA";
    private static final String UPDATED_READ_MORE_8 = "BBBBBBBBBB";

    private static final String DEFAULT_READ_MORE_9 = "AAAAAAAAAA";
    private static final String UPDATED_READ_MORE_9 = "BBBBBBBBBB";

    private static final String DEFAULT_READ_MORE_10 = "AAAAAAAAAA";
    private static final String UPDATED_READ_MORE_10 = "BBBBBBBBBB";

    private static final String DEFAULT_DATE_1 = "AAAAAAAAAA";
    private static final String UPDATED_DATE_1 = "BBBBBBBBBB";

    private static final String DEFAULT_DATE_2 = "AAAAAAAAAA";
    private static final String UPDATED_DATE_2 = "BBBBBBBBBB";

    private static final String DEFAULT_DATE_3 = "AAAAAAAAAA";
    private static final String UPDATED_DATE_3 = "BBBBBBBBBB";

    private static final String DEFAULT_DATE_4 = "AAAAAAAAAA";
    private static final String UPDATED_DATE_4 = "BBBBBBBBBB";

    private static final String DEFAULT_DATE_5 = "AAAAAAAAAA";
    private static final String UPDATED_DATE_5 = "BBBBBBBBBB";

    private static final String DEFAULT_DATE_6 = "AAAAAAAAAA";
    private static final String UPDATED_DATE_6 = "BBBBBBBBBB";

    private static final String DEFAULT_DATE_7 = "AAAAAAAAAA";
    private static final String UPDATED_DATE_7 = "BBBBBBBBBB";

    private static final String DEFAULT_DATE_8 = "AAAAAAAAAA";
    private static final String UPDATED_DATE_8 = "BBBBBBBBBB";

    private static final String DEFAULT_DATE_9 = "AAAAAAAAAA";
    private static final String UPDATED_DATE_9 = "BBBBBBBBBB";

    private static final String DEFAULT_DATE_10 = "AAAAAAAAAA";
    private static final String UPDATED_DATE_10 = "BBBBBBBBBB";

    @Autowired
    private DernieresNouvellesRepository dernieresNouvellesRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restDernieresNouvellesMockMvc;

    private DernieresNouvelles dernieresNouvelles;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static DernieresNouvelles createEntity(EntityManager em) {
        DernieresNouvelles dernieresNouvelles = new DernieresNouvelles()
            .titreFr(DEFAULT_TITRE_FR)
            .titreEn(DEFAULT_TITRE_EN)
            .titreGer(DEFAULT_TITRE_GER)
            .titreSw(DEFAULT_TITRE_SW)
            .sousTitreFr(DEFAULT_SOUS_TITRE_FR)
            .sousTitreEn(DEFAULT_SOUS_TITRE_EN)
            .sousTitreGer(DEFAULT_SOUS_TITRE_GER)
            .sousTitreSw(DEFAULT_SOUS_TITRE_SW)
            .titreSlide1Fr(DEFAULT_TITRE_SLIDE_1_FR)
            .titreSlide1En(DEFAULT_TITRE_SLIDE_1_EN)
            .titreSlide1Ger(DEFAULT_TITRE_SLIDE_1_GER)
            .titreSlide1Sw(DEFAULT_TITRE_SLIDE_1_SW)
            .titreSlide2Fr(DEFAULT_TITRE_SLIDE_2_FR)
            .titreSlide2En(DEFAULT_TITRE_SLIDE_2_EN)
            .titreSlide2Ger(DEFAULT_TITRE_SLIDE_2_GER)
            .titreSlide2Sw(DEFAULT_TITRE_SLIDE_2_SW)
            .titreSlide3Fr(DEFAULT_TITRE_SLIDE_3_FR)
            .titreSlide3En(DEFAULT_TITRE_SLIDE_3_EN)
            .titreSlide3Ger(DEFAULT_TITRE_SLIDE_3_GER)
            .titreSlide3Sw(DEFAULT_TITRE_SLIDE_3_SW)
            .titreSlide4Fr(DEFAULT_TITRE_SLIDE_4_FR)
            .titreSlide4En(DEFAULT_TITRE_SLIDE_4_EN)
            .titreSlide4Ger(DEFAULT_TITRE_SLIDE_4_GER)
            .titreSlide4Sw(DEFAULT_TITRE_SLIDE_4_SW)
            .titreSlide5Fr(DEFAULT_TITRE_SLIDE_5_FR)
            .titreSlide5En(DEFAULT_TITRE_SLIDE_5_EN)
            .titreSlide5Ger(DEFAULT_TITRE_SLIDE_5_GER)
            .titreSlide5Sw(DEFAULT_TITRE_SLIDE_5_SW)
            .titreSlide6Fr(DEFAULT_TITRE_SLIDE_6_FR)
            .titreSlide6En(DEFAULT_TITRE_SLIDE_6_EN)
            .titreSlide6Ger(DEFAULT_TITRE_SLIDE_6_GER)
            .titreSlide6Sw(DEFAULT_TITRE_SLIDE_6_SW)
            .titreSlide7Fr(DEFAULT_TITRE_SLIDE_7_FR)
            .titreSlide7En(DEFAULT_TITRE_SLIDE_7_EN)
            .titreSlide7Ger(DEFAULT_TITRE_SLIDE_7_GER)
            .titreSlide7Sw(DEFAULT_TITRE_SLIDE_7_SW)
            .titreSlide8Fr(DEFAULT_TITRE_SLIDE_8_FR)
            .titreSlide8En(DEFAULT_TITRE_SLIDE_8_EN)
            .titreSlide8Ger(DEFAULT_TITRE_SLIDE_8_GER)
            .titreSlide8Sw(DEFAULT_TITRE_SLIDE_8_SW)
            .titreSlide9Fr(DEFAULT_TITRE_SLIDE_9_FR)
            .titreSlide9En(DEFAULT_TITRE_SLIDE_9_EN)
            .titreSlide9Ger(DEFAULT_TITRE_SLIDE_9_GER)
            .titreSlide9Sw(DEFAULT_TITRE_SLIDE_9_SW)
            .titreSlide1OFr(DEFAULT_TITRE_SLIDE_1_O_FR)
            .titreSlide1OEn(DEFAULT_TITRE_SLIDE_1_O_EN)
            .titreSlide1OGer(DEFAULT_TITRE_SLIDE_1_O_GER)
            .titreSlide1OSw(DEFAULT_TITRE_SLIDE_1_O_SW)
            .textSlide1Fr(DEFAULT_TEXT_SLIDE_1_FR)
            .textSlide1En(DEFAULT_TEXT_SLIDE_1_EN)
            .textSlide1Ger(DEFAULT_TEXT_SLIDE_1_GER)
            .textSlide1Sw(DEFAULT_TEXT_SLIDE_1_SW)
            .textSlide2Fr(DEFAULT_TEXT_SLIDE_2_FR)
            .textSlide2En(DEFAULT_TEXT_SLIDE_2_EN)
            .textSlide2Ger(DEFAULT_TEXT_SLIDE_2_GER)
            .textSlide2Sw(DEFAULT_TEXT_SLIDE_2_SW)
            .textSlide3Fr(DEFAULT_TEXT_SLIDE_3_FR)
            .textSlide3En(DEFAULT_TEXT_SLIDE_3_EN)
            .textSlide3Ger(DEFAULT_TEXT_SLIDE_3_GER)
            .textSlide3Sw(DEFAULT_TEXT_SLIDE_3_SW)
            .textSlide4Fr(DEFAULT_TEXT_SLIDE_4_FR)
            .textSlide4En(DEFAULT_TEXT_SLIDE_4_EN)
            .textSlide4Ger(DEFAULT_TEXT_SLIDE_4_GER)
            .textSlide4Sw(DEFAULT_TEXT_SLIDE_4_SW)
            .textSlide5Fr(DEFAULT_TEXT_SLIDE_5_FR)
            .textSlide5En(DEFAULT_TEXT_SLIDE_5_EN)
            .textSlide5Ger(DEFAULT_TEXT_SLIDE_5_GER)
            .textSlide5Sw(DEFAULT_TEXT_SLIDE_5_SW)
            .textSlide6Fr(DEFAULT_TEXT_SLIDE_6_FR)
            .textSlide6En(DEFAULT_TEXT_SLIDE_6_EN)
            .textSlide6Ger(DEFAULT_TEXT_SLIDE_6_GER)
            .textSlide6Sw(DEFAULT_TEXT_SLIDE_6_SW)
            .textSlide7Fr(DEFAULT_TEXT_SLIDE_7_FR)
            .textSlide7En(DEFAULT_TEXT_SLIDE_7_EN)
            .textSlide7Ger(DEFAULT_TEXT_SLIDE_7_GER)
            .textSlide7Sw(DEFAULT_TEXT_SLIDE_7_SW)
            .textSlide8Fr(DEFAULT_TEXT_SLIDE_8_FR)
            .textSlide8En(DEFAULT_TEXT_SLIDE_8_EN)
            .textSlide8Ger(DEFAULT_TEXT_SLIDE_8_GER)
            .textSlide8Sw(DEFAULT_TEXT_SLIDE_8_SW)
            .textSlide9Fr(DEFAULT_TEXT_SLIDE_9_FR)
            .textSlide9En(DEFAULT_TEXT_SLIDE_9_EN)
            .textSlide9Ger(DEFAULT_TEXT_SLIDE_9_GER)
            .textSlide9Sw(DEFAULT_TEXT_SLIDE_9_SW)
            .textSlide10Fr(DEFAULT_TEXT_SLIDE_10_FR)
            .textSlide10En(DEFAULT_TEXT_SLIDE_10_EN)
            .textSlide10Ger(DEFAULT_TEXT_SLIDE_10_GER)
            .textSlide10Sw(DEFAULT_TEXT_SLIDE_10_SW)
            .imageSlide1(DEFAULT_IMAGE_SLIDE_1)
            .imageSlide1ContentType(DEFAULT_IMAGE_SLIDE_1_CONTENT_TYPE)
            .imageSlide2(DEFAULT_IMAGE_SLIDE_2)
            .imageSlide2ContentType(DEFAULT_IMAGE_SLIDE_2_CONTENT_TYPE)
            .imageSlide3(DEFAULT_IMAGE_SLIDE_3)
            .imageSlide3ContentType(DEFAULT_IMAGE_SLIDE_3_CONTENT_TYPE)
            .imageSlide4(DEFAULT_IMAGE_SLIDE_4)
            .imageSlide4ContentType(DEFAULT_IMAGE_SLIDE_4_CONTENT_TYPE)
            .imageSlide5(DEFAULT_IMAGE_SLIDE_5)
            .imageSlide5ContentType(DEFAULT_IMAGE_SLIDE_5_CONTENT_TYPE)
            .imageSlide6(DEFAULT_IMAGE_SLIDE_6)
            .imageSlide6ContentType(DEFAULT_IMAGE_SLIDE_6_CONTENT_TYPE)
            .imageSlide7(DEFAULT_IMAGE_SLIDE_7)
            .imageSlide7ContentType(DEFAULT_IMAGE_SLIDE_7_CONTENT_TYPE)
            .imageSlide8(DEFAULT_IMAGE_SLIDE_8)
            .imageSlide8ContentType(DEFAULT_IMAGE_SLIDE_8_CONTENT_TYPE)
            .imageSlide9(DEFAULT_IMAGE_SLIDE_9)
            .imageSlide9ContentType(DEFAULT_IMAGE_SLIDE_9_CONTENT_TYPE)
            .imageSlide10(DEFAULT_IMAGE_SLIDE_10)
            .imageSlide10ContentType(DEFAULT_IMAGE_SLIDE_10_CONTENT_TYPE)
            .readMore1(DEFAULT_READ_MORE_1)
            .readMore2(DEFAULT_READ_MORE_2)
            .readMore3(DEFAULT_READ_MORE_3)
            .readMore4(DEFAULT_READ_MORE_4)
            .readMore5(DEFAULT_READ_MORE_5)
            .readMore6(DEFAULT_READ_MORE_6)
            .readMore7(DEFAULT_READ_MORE_7)
            .readMore8(DEFAULT_READ_MORE_8)
            .readMore9(DEFAULT_READ_MORE_9)
            .readMore10(DEFAULT_READ_MORE_10)
            .date1(DEFAULT_DATE_1)
            .date2(DEFAULT_DATE_2)
            .date3(DEFAULT_DATE_3)
            .date4(DEFAULT_DATE_4)
            .date5(DEFAULT_DATE_5)
            .date6(DEFAULT_DATE_6)
            .date7(DEFAULT_DATE_7)
            .date8(DEFAULT_DATE_8)
            .date9(DEFAULT_DATE_9)
            .date10(DEFAULT_DATE_10);
        return dernieresNouvelles;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static DernieresNouvelles createUpdatedEntity(EntityManager em) {
        DernieresNouvelles dernieresNouvelles = new DernieresNouvelles()
            .titreFr(UPDATED_TITRE_FR)
            .titreEn(UPDATED_TITRE_EN)
            .titreGer(UPDATED_TITRE_GER)
            .titreSw(UPDATED_TITRE_SW)
            .sousTitreFr(UPDATED_SOUS_TITRE_FR)
            .sousTitreEn(UPDATED_SOUS_TITRE_EN)
            .sousTitreGer(UPDATED_SOUS_TITRE_GER)
            .sousTitreSw(UPDATED_SOUS_TITRE_SW)
            .titreSlide1Fr(UPDATED_TITRE_SLIDE_1_FR)
            .titreSlide1En(UPDATED_TITRE_SLIDE_1_EN)
            .titreSlide1Ger(UPDATED_TITRE_SLIDE_1_GER)
            .titreSlide1Sw(UPDATED_TITRE_SLIDE_1_SW)
            .titreSlide2Fr(UPDATED_TITRE_SLIDE_2_FR)
            .titreSlide2En(UPDATED_TITRE_SLIDE_2_EN)
            .titreSlide2Ger(UPDATED_TITRE_SLIDE_2_GER)
            .titreSlide2Sw(UPDATED_TITRE_SLIDE_2_SW)
            .titreSlide3Fr(UPDATED_TITRE_SLIDE_3_FR)
            .titreSlide3En(UPDATED_TITRE_SLIDE_3_EN)
            .titreSlide3Ger(UPDATED_TITRE_SLIDE_3_GER)
            .titreSlide3Sw(UPDATED_TITRE_SLIDE_3_SW)
            .titreSlide4Fr(UPDATED_TITRE_SLIDE_4_FR)
            .titreSlide4En(UPDATED_TITRE_SLIDE_4_EN)
            .titreSlide4Ger(UPDATED_TITRE_SLIDE_4_GER)
            .titreSlide4Sw(UPDATED_TITRE_SLIDE_4_SW)
            .titreSlide5Fr(UPDATED_TITRE_SLIDE_5_FR)
            .titreSlide5En(UPDATED_TITRE_SLIDE_5_EN)
            .titreSlide5Ger(UPDATED_TITRE_SLIDE_5_GER)
            .titreSlide5Sw(UPDATED_TITRE_SLIDE_5_SW)
            .titreSlide6Fr(UPDATED_TITRE_SLIDE_6_FR)
            .titreSlide6En(UPDATED_TITRE_SLIDE_6_EN)
            .titreSlide6Ger(UPDATED_TITRE_SLIDE_6_GER)
            .titreSlide6Sw(UPDATED_TITRE_SLIDE_6_SW)
            .titreSlide7Fr(UPDATED_TITRE_SLIDE_7_FR)
            .titreSlide7En(UPDATED_TITRE_SLIDE_7_EN)
            .titreSlide7Ger(UPDATED_TITRE_SLIDE_7_GER)
            .titreSlide7Sw(UPDATED_TITRE_SLIDE_7_SW)
            .titreSlide8Fr(UPDATED_TITRE_SLIDE_8_FR)
            .titreSlide8En(UPDATED_TITRE_SLIDE_8_EN)
            .titreSlide8Ger(UPDATED_TITRE_SLIDE_8_GER)
            .titreSlide8Sw(UPDATED_TITRE_SLIDE_8_SW)
            .titreSlide9Fr(UPDATED_TITRE_SLIDE_9_FR)
            .titreSlide9En(UPDATED_TITRE_SLIDE_9_EN)
            .titreSlide9Ger(UPDATED_TITRE_SLIDE_9_GER)
            .titreSlide9Sw(UPDATED_TITRE_SLIDE_9_SW)
            .titreSlide1OFr(UPDATED_TITRE_SLIDE_1_O_FR)
            .titreSlide1OEn(UPDATED_TITRE_SLIDE_1_O_EN)
            .titreSlide1OGer(UPDATED_TITRE_SLIDE_1_O_GER)
            .titreSlide1OSw(UPDATED_TITRE_SLIDE_1_O_SW)
            .textSlide1Fr(UPDATED_TEXT_SLIDE_1_FR)
            .textSlide1En(UPDATED_TEXT_SLIDE_1_EN)
            .textSlide1Ger(UPDATED_TEXT_SLIDE_1_GER)
            .textSlide1Sw(UPDATED_TEXT_SLIDE_1_SW)
            .textSlide2Fr(UPDATED_TEXT_SLIDE_2_FR)
            .textSlide2En(UPDATED_TEXT_SLIDE_2_EN)
            .textSlide2Ger(UPDATED_TEXT_SLIDE_2_GER)
            .textSlide2Sw(UPDATED_TEXT_SLIDE_2_SW)
            .textSlide3Fr(UPDATED_TEXT_SLIDE_3_FR)
            .textSlide3En(UPDATED_TEXT_SLIDE_3_EN)
            .textSlide3Ger(UPDATED_TEXT_SLIDE_3_GER)
            .textSlide3Sw(UPDATED_TEXT_SLIDE_3_SW)
            .textSlide4Fr(UPDATED_TEXT_SLIDE_4_FR)
            .textSlide4En(UPDATED_TEXT_SLIDE_4_EN)
            .textSlide4Ger(UPDATED_TEXT_SLIDE_4_GER)
            .textSlide4Sw(UPDATED_TEXT_SLIDE_4_SW)
            .textSlide5Fr(UPDATED_TEXT_SLIDE_5_FR)
            .textSlide5En(UPDATED_TEXT_SLIDE_5_EN)
            .textSlide5Ger(UPDATED_TEXT_SLIDE_5_GER)
            .textSlide5Sw(UPDATED_TEXT_SLIDE_5_SW)
            .textSlide6Fr(UPDATED_TEXT_SLIDE_6_FR)
            .textSlide6En(UPDATED_TEXT_SLIDE_6_EN)
            .textSlide6Ger(UPDATED_TEXT_SLIDE_6_GER)
            .textSlide6Sw(UPDATED_TEXT_SLIDE_6_SW)
            .textSlide7Fr(UPDATED_TEXT_SLIDE_7_FR)
            .textSlide7En(UPDATED_TEXT_SLIDE_7_EN)
            .textSlide7Ger(UPDATED_TEXT_SLIDE_7_GER)
            .textSlide7Sw(UPDATED_TEXT_SLIDE_7_SW)
            .textSlide8Fr(UPDATED_TEXT_SLIDE_8_FR)
            .textSlide8En(UPDATED_TEXT_SLIDE_8_EN)
            .textSlide8Ger(UPDATED_TEXT_SLIDE_8_GER)
            .textSlide8Sw(UPDATED_TEXT_SLIDE_8_SW)
            .textSlide9Fr(UPDATED_TEXT_SLIDE_9_FR)
            .textSlide9En(UPDATED_TEXT_SLIDE_9_EN)
            .textSlide9Ger(UPDATED_TEXT_SLIDE_9_GER)
            .textSlide9Sw(UPDATED_TEXT_SLIDE_9_SW)
            .textSlide10Fr(UPDATED_TEXT_SLIDE_10_FR)
            .textSlide10En(UPDATED_TEXT_SLIDE_10_EN)
            .textSlide10Ger(UPDATED_TEXT_SLIDE_10_GER)
            .textSlide10Sw(UPDATED_TEXT_SLIDE_10_SW)
            .imageSlide1(UPDATED_IMAGE_SLIDE_1)
            .imageSlide1ContentType(UPDATED_IMAGE_SLIDE_1_CONTENT_TYPE)
            .imageSlide2(UPDATED_IMAGE_SLIDE_2)
            .imageSlide2ContentType(UPDATED_IMAGE_SLIDE_2_CONTENT_TYPE)
            .imageSlide3(UPDATED_IMAGE_SLIDE_3)
            .imageSlide3ContentType(UPDATED_IMAGE_SLIDE_3_CONTENT_TYPE)
            .imageSlide4(UPDATED_IMAGE_SLIDE_4)
            .imageSlide4ContentType(UPDATED_IMAGE_SLIDE_4_CONTENT_TYPE)
            .imageSlide5(UPDATED_IMAGE_SLIDE_5)
            .imageSlide5ContentType(UPDATED_IMAGE_SLIDE_5_CONTENT_TYPE)
            .imageSlide6(UPDATED_IMAGE_SLIDE_6)
            .imageSlide6ContentType(UPDATED_IMAGE_SLIDE_6_CONTENT_TYPE)
            .imageSlide7(UPDATED_IMAGE_SLIDE_7)
            .imageSlide7ContentType(UPDATED_IMAGE_SLIDE_7_CONTENT_TYPE)
            .imageSlide8(UPDATED_IMAGE_SLIDE_8)
            .imageSlide8ContentType(UPDATED_IMAGE_SLIDE_8_CONTENT_TYPE)
            .imageSlide9(UPDATED_IMAGE_SLIDE_9)
            .imageSlide9ContentType(UPDATED_IMAGE_SLIDE_9_CONTENT_TYPE)
            .imageSlide10(UPDATED_IMAGE_SLIDE_10)
            .imageSlide10ContentType(UPDATED_IMAGE_SLIDE_10_CONTENT_TYPE)
            .readMore1(UPDATED_READ_MORE_1)
            .readMore2(UPDATED_READ_MORE_2)
            .readMore3(UPDATED_READ_MORE_3)
            .readMore4(UPDATED_READ_MORE_4)
            .readMore5(UPDATED_READ_MORE_5)
            .readMore6(UPDATED_READ_MORE_6)
            .readMore7(UPDATED_READ_MORE_7)
            .readMore8(UPDATED_READ_MORE_8)
            .readMore9(UPDATED_READ_MORE_9)
            .readMore10(UPDATED_READ_MORE_10)
            .date1(UPDATED_DATE_1)
            .date2(UPDATED_DATE_2)
            .date3(UPDATED_DATE_3)
            .date4(UPDATED_DATE_4)
            .date5(UPDATED_DATE_5)
            .date6(UPDATED_DATE_6)
            .date7(UPDATED_DATE_7)
            .date8(UPDATED_DATE_8)
            .date9(UPDATED_DATE_9)
            .date10(UPDATED_DATE_10);
        return dernieresNouvelles;
    }

    @BeforeEach
    public void initTest() {
        dernieresNouvelles = createEntity(em);
    }

    @Test
    @Transactional
    public void createDernieresNouvelles() throws Exception {
        int databaseSizeBeforeCreate = dernieresNouvellesRepository.findAll().size();

        // Create the DernieresNouvelles
        restDernieresNouvellesMockMvc.perform(post("/api/dernieres-nouvelles")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(dernieresNouvelles)))
            .andExpect(status().isCreated());

        // Validate the DernieresNouvelles in the database
        List<DernieresNouvelles> dernieresNouvellesList = dernieresNouvellesRepository.findAll();
        assertThat(dernieresNouvellesList).hasSize(databaseSizeBeforeCreate + 1);
        DernieresNouvelles testDernieresNouvelles = dernieresNouvellesList.get(dernieresNouvellesList.size() - 1);
        assertThat(testDernieresNouvelles.getTitreFr()).isEqualTo(DEFAULT_TITRE_FR);
        assertThat(testDernieresNouvelles.getTitreEn()).isEqualTo(DEFAULT_TITRE_EN);
        assertThat(testDernieresNouvelles.getTitreGer()).isEqualTo(DEFAULT_TITRE_GER);
        assertThat(testDernieresNouvelles.getTitreSw()).isEqualTo(DEFAULT_TITRE_SW);
        assertThat(testDernieresNouvelles.getSousTitreFr()).isEqualTo(DEFAULT_SOUS_TITRE_FR);
        assertThat(testDernieresNouvelles.getSousTitreEn()).isEqualTo(DEFAULT_SOUS_TITRE_EN);
        assertThat(testDernieresNouvelles.getSousTitreGer()).isEqualTo(DEFAULT_SOUS_TITRE_GER);
        assertThat(testDernieresNouvelles.getSousTitreSw()).isEqualTo(DEFAULT_SOUS_TITRE_SW);
        assertThat(testDernieresNouvelles.getTitreSlide1Fr()).isEqualTo(DEFAULT_TITRE_SLIDE_1_FR);
        assertThat(testDernieresNouvelles.getTitreSlide1En()).isEqualTo(DEFAULT_TITRE_SLIDE_1_EN);
        assertThat(testDernieresNouvelles.getTitreSlide1Ger()).isEqualTo(DEFAULT_TITRE_SLIDE_1_GER);
        assertThat(testDernieresNouvelles.getTitreSlide1Sw()).isEqualTo(DEFAULT_TITRE_SLIDE_1_SW);
        assertThat(testDernieresNouvelles.getTitreSlide2Fr()).isEqualTo(DEFAULT_TITRE_SLIDE_2_FR);
        assertThat(testDernieresNouvelles.getTitreSlide2En()).isEqualTo(DEFAULT_TITRE_SLIDE_2_EN);
        assertThat(testDernieresNouvelles.getTitreSlide2Ger()).isEqualTo(DEFAULT_TITRE_SLIDE_2_GER);
        assertThat(testDernieresNouvelles.getTitreSlide2Sw()).isEqualTo(DEFAULT_TITRE_SLIDE_2_SW);
        assertThat(testDernieresNouvelles.getTitreSlide3Fr()).isEqualTo(DEFAULT_TITRE_SLIDE_3_FR);
        assertThat(testDernieresNouvelles.getTitreSlide3En()).isEqualTo(DEFAULT_TITRE_SLIDE_3_EN);
        assertThat(testDernieresNouvelles.getTitreSlide3Ger()).isEqualTo(DEFAULT_TITRE_SLIDE_3_GER);
        assertThat(testDernieresNouvelles.getTitreSlide3Sw()).isEqualTo(DEFAULT_TITRE_SLIDE_3_SW);
        assertThat(testDernieresNouvelles.getTitreSlide4Fr()).isEqualTo(DEFAULT_TITRE_SLIDE_4_FR);
        assertThat(testDernieresNouvelles.getTitreSlide4En()).isEqualTo(DEFAULT_TITRE_SLIDE_4_EN);
        assertThat(testDernieresNouvelles.getTitreSlide4Ger()).isEqualTo(DEFAULT_TITRE_SLIDE_4_GER);
        assertThat(testDernieresNouvelles.getTitreSlide4Sw()).isEqualTo(DEFAULT_TITRE_SLIDE_4_SW);
        assertThat(testDernieresNouvelles.getTitreSlide5Fr()).isEqualTo(DEFAULT_TITRE_SLIDE_5_FR);
        assertThat(testDernieresNouvelles.getTitreSlide5En()).isEqualTo(DEFAULT_TITRE_SLIDE_5_EN);
        assertThat(testDernieresNouvelles.getTitreSlide5Ger()).isEqualTo(DEFAULT_TITRE_SLIDE_5_GER);
        assertThat(testDernieresNouvelles.getTitreSlide5Sw()).isEqualTo(DEFAULT_TITRE_SLIDE_5_SW);
        assertThat(testDernieresNouvelles.getTitreSlide6Fr()).isEqualTo(DEFAULT_TITRE_SLIDE_6_FR);
        assertThat(testDernieresNouvelles.getTitreSlide6En()).isEqualTo(DEFAULT_TITRE_SLIDE_6_EN);
        assertThat(testDernieresNouvelles.getTitreSlide6Ger()).isEqualTo(DEFAULT_TITRE_SLIDE_6_GER);
        assertThat(testDernieresNouvelles.getTitreSlide6Sw()).isEqualTo(DEFAULT_TITRE_SLIDE_6_SW);
        assertThat(testDernieresNouvelles.getTitreSlide7Fr()).isEqualTo(DEFAULT_TITRE_SLIDE_7_FR);
        assertThat(testDernieresNouvelles.getTitreSlide7En()).isEqualTo(DEFAULT_TITRE_SLIDE_7_EN);
        assertThat(testDernieresNouvelles.getTitreSlide7Ger()).isEqualTo(DEFAULT_TITRE_SLIDE_7_GER);
        assertThat(testDernieresNouvelles.getTitreSlide7Sw()).isEqualTo(DEFAULT_TITRE_SLIDE_7_SW);
        assertThat(testDernieresNouvelles.getTitreSlide8Fr()).isEqualTo(DEFAULT_TITRE_SLIDE_8_FR);
        assertThat(testDernieresNouvelles.getTitreSlide8En()).isEqualTo(DEFAULT_TITRE_SLIDE_8_EN);
        assertThat(testDernieresNouvelles.getTitreSlide8Ger()).isEqualTo(DEFAULT_TITRE_SLIDE_8_GER);
        assertThat(testDernieresNouvelles.getTitreSlide8Sw()).isEqualTo(DEFAULT_TITRE_SLIDE_8_SW);
        assertThat(testDernieresNouvelles.getTitreSlide9Fr()).isEqualTo(DEFAULT_TITRE_SLIDE_9_FR);
        assertThat(testDernieresNouvelles.getTitreSlide9En()).isEqualTo(DEFAULT_TITRE_SLIDE_9_EN);
        assertThat(testDernieresNouvelles.getTitreSlide9Ger()).isEqualTo(DEFAULT_TITRE_SLIDE_9_GER);
        assertThat(testDernieresNouvelles.getTitreSlide9Sw()).isEqualTo(DEFAULT_TITRE_SLIDE_9_SW);
        assertThat(testDernieresNouvelles.getTitreSlide1OFr()).isEqualTo(DEFAULT_TITRE_SLIDE_1_O_FR);
        assertThat(testDernieresNouvelles.getTitreSlide1OEn()).isEqualTo(DEFAULT_TITRE_SLIDE_1_O_EN);
        assertThat(testDernieresNouvelles.getTitreSlide1OGer()).isEqualTo(DEFAULT_TITRE_SLIDE_1_O_GER);
        assertThat(testDernieresNouvelles.getTitreSlide1OSw()).isEqualTo(DEFAULT_TITRE_SLIDE_1_O_SW);
        assertThat(testDernieresNouvelles.getTextSlide1Fr()).isEqualTo(DEFAULT_TEXT_SLIDE_1_FR);
        assertThat(testDernieresNouvelles.getTextSlide1En()).isEqualTo(DEFAULT_TEXT_SLIDE_1_EN);
        assertThat(testDernieresNouvelles.getTextSlide1Ger()).isEqualTo(DEFAULT_TEXT_SLIDE_1_GER);
        assertThat(testDernieresNouvelles.getTextSlide1Sw()).isEqualTo(DEFAULT_TEXT_SLIDE_1_SW);
        assertThat(testDernieresNouvelles.getTextSlide2Fr()).isEqualTo(DEFAULT_TEXT_SLIDE_2_FR);
        assertThat(testDernieresNouvelles.getTextSlide2En()).isEqualTo(DEFAULT_TEXT_SLIDE_2_EN);
        assertThat(testDernieresNouvelles.getTextSlide2Ger()).isEqualTo(DEFAULT_TEXT_SLIDE_2_GER);
        assertThat(testDernieresNouvelles.getTextSlide2Sw()).isEqualTo(DEFAULT_TEXT_SLIDE_2_SW);
        assertThat(testDernieresNouvelles.getTextSlide3Fr()).isEqualTo(DEFAULT_TEXT_SLIDE_3_FR);
        assertThat(testDernieresNouvelles.getTextSlide3En()).isEqualTo(DEFAULT_TEXT_SLIDE_3_EN);
        assertThat(testDernieresNouvelles.getTextSlide3Ger()).isEqualTo(DEFAULT_TEXT_SLIDE_3_GER);
        assertThat(testDernieresNouvelles.getTextSlide3Sw()).isEqualTo(DEFAULT_TEXT_SLIDE_3_SW);
        assertThat(testDernieresNouvelles.getTextSlide4Fr()).isEqualTo(DEFAULT_TEXT_SLIDE_4_FR);
        assertThat(testDernieresNouvelles.getTextSlide4En()).isEqualTo(DEFAULT_TEXT_SLIDE_4_EN);
        assertThat(testDernieresNouvelles.getTextSlide4Ger()).isEqualTo(DEFAULT_TEXT_SLIDE_4_GER);
        assertThat(testDernieresNouvelles.getTextSlide4Sw()).isEqualTo(DEFAULT_TEXT_SLIDE_4_SW);
        assertThat(testDernieresNouvelles.getTextSlide5Fr()).isEqualTo(DEFAULT_TEXT_SLIDE_5_FR);
        assertThat(testDernieresNouvelles.getTextSlide5En()).isEqualTo(DEFAULT_TEXT_SLIDE_5_EN);
        assertThat(testDernieresNouvelles.getTextSlide5Ger()).isEqualTo(DEFAULT_TEXT_SLIDE_5_GER);
        assertThat(testDernieresNouvelles.getTextSlide5Sw()).isEqualTo(DEFAULT_TEXT_SLIDE_5_SW);
        assertThat(testDernieresNouvelles.getTextSlide6Fr()).isEqualTo(DEFAULT_TEXT_SLIDE_6_FR);
        assertThat(testDernieresNouvelles.getTextSlide6En()).isEqualTo(DEFAULT_TEXT_SLIDE_6_EN);
        assertThat(testDernieresNouvelles.getTextSlide6Ger()).isEqualTo(DEFAULT_TEXT_SLIDE_6_GER);
        assertThat(testDernieresNouvelles.getTextSlide6Sw()).isEqualTo(DEFAULT_TEXT_SLIDE_6_SW);
        assertThat(testDernieresNouvelles.getTextSlide7Fr()).isEqualTo(DEFAULT_TEXT_SLIDE_7_FR);
        assertThat(testDernieresNouvelles.getTextSlide7En()).isEqualTo(DEFAULT_TEXT_SLIDE_7_EN);
        assertThat(testDernieresNouvelles.getTextSlide7Ger()).isEqualTo(DEFAULT_TEXT_SLIDE_7_GER);
        assertThat(testDernieresNouvelles.getTextSlide7Sw()).isEqualTo(DEFAULT_TEXT_SLIDE_7_SW);
        assertThat(testDernieresNouvelles.getTextSlide8Fr()).isEqualTo(DEFAULT_TEXT_SLIDE_8_FR);
        assertThat(testDernieresNouvelles.getTextSlide8En()).isEqualTo(DEFAULT_TEXT_SLIDE_8_EN);
        assertThat(testDernieresNouvelles.getTextSlide8Ger()).isEqualTo(DEFAULT_TEXT_SLIDE_8_GER);
        assertThat(testDernieresNouvelles.getTextSlide8Sw()).isEqualTo(DEFAULT_TEXT_SLIDE_8_SW);
        assertThat(testDernieresNouvelles.getTextSlide9Fr()).isEqualTo(DEFAULT_TEXT_SLIDE_9_FR);
        assertThat(testDernieresNouvelles.getTextSlide9En()).isEqualTo(DEFAULT_TEXT_SLIDE_9_EN);
        assertThat(testDernieresNouvelles.getTextSlide9Ger()).isEqualTo(DEFAULT_TEXT_SLIDE_9_GER);
        assertThat(testDernieresNouvelles.getTextSlide9Sw()).isEqualTo(DEFAULT_TEXT_SLIDE_9_SW);
        assertThat(testDernieresNouvelles.getTextSlide10Fr()).isEqualTo(DEFAULT_TEXT_SLIDE_10_FR);
        assertThat(testDernieresNouvelles.getTextSlide10En()).isEqualTo(DEFAULT_TEXT_SLIDE_10_EN);
        assertThat(testDernieresNouvelles.getTextSlide10Ger()).isEqualTo(DEFAULT_TEXT_SLIDE_10_GER);
        assertThat(testDernieresNouvelles.getTextSlide10Sw()).isEqualTo(DEFAULT_TEXT_SLIDE_10_SW);
        assertThat(testDernieresNouvelles.getImageSlide1()).isEqualTo(DEFAULT_IMAGE_SLIDE_1);
        assertThat(testDernieresNouvelles.getImageSlide1ContentType()).isEqualTo(DEFAULT_IMAGE_SLIDE_1_CONTENT_TYPE);
        assertThat(testDernieresNouvelles.getImageSlide2()).isEqualTo(DEFAULT_IMAGE_SLIDE_2);
        assertThat(testDernieresNouvelles.getImageSlide2ContentType()).isEqualTo(DEFAULT_IMAGE_SLIDE_2_CONTENT_TYPE);
        assertThat(testDernieresNouvelles.getImageSlide3()).isEqualTo(DEFAULT_IMAGE_SLIDE_3);
        assertThat(testDernieresNouvelles.getImageSlide3ContentType()).isEqualTo(DEFAULT_IMAGE_SLIDE_3_CONTENT_TYPE);
        assertThat(testDernieresNouvelles.getImageSlide4()).isEqualTo(DEFAULT_IMAGE_SLIDE_4);
        assertThat(testDernieresNouvelles.getImageSlide4ContentType()).isEqualTo(DEFAULT_IMAGE_SLIDE_4_CONTENT_TYPE);
        assertThat(testDernieresNouvelles.getImageSlide5()).isEqualTo(DEFAULT_IMAGE_SLIDE_5);
        assertThat(testDernieresNouvelles.getImageSlide5ContentType()).isEqualTo(DEFAULT_IMAGE_SLIDE_5_CONTENT_TYPE);
        assertThat(testDernieresNouvelles.getImageSlide6()).isEqualTo(DEFAULT_IMAGE_SLIDE_6);
        assertThat(testDernieresNouvelles.getImageSlide6ContentType()).isEqualTo(DEFAULT_IMAGE_SLIDE_6_CONTENT_TYPE);
        assertThat(testDernieresNouvelles.getImageSlide7()).isEqualTo(DEFAULT_IMAGE_SLIDE_7);
        assertThat(testDernieresNouvelles.getImageSlide7ContentType()).isEqualTo(DEFAULT_IMAGE_SLIDE_7_CONTENT_TYPE);
        assertThat(testDernieresNouvelles.getImageSlide8()).isEqualTo(DEFAULT_IMAGE_SLIDE_8);
        assertThat(testDernieresNouvelles.getImageSlide8ContentType()).isEqualTo(DEFAULT_IMAGE_SLIDE_8_CONTENT_TYPE);
        assertThat(testDernieresNouvelles.getImageSlide9()).isEqualTo(DEFAULT_IMAGE_SLIDE_9);
        assertThat(testDernieresNouvelles.getImageSlide9ContentType()).isEqualTo(DEFAULT_IMAGE_SLIDE_9_CONTENT_TYPE);
        assertThat(testDernieresNouvelles.getImageSlide10()).isEqualTo(DEFAULT_IMAGE_SLIDE_10);
        assertThat(testDernieresNouvelles.getImageSlide10ContentType()).isEqualTo(DEFAULT_IMAGE_SLIDE_10_CONTENT_TYPE);
        assertThat(testDernieresNouvelles.getReadMore1()).isEqualTo(DEFAULT_READ_MORE_1);
        assertThat(testDernieresNouvelles.getReadMore2()).isEqualTo(DEFAULT_READ_MORE_2);
        assertThat(testDernieresNouvelles.getReadMore3()).isEqualTo(DEFAULT_READ_MORE_3);
        assertThat(testDernieresNouvelles.getReadMore4()).isEqualTo(DEFAULT_READ_MORE_4);
        assertThat(testDernieresNouvelles.getReadMore5()).isEqualTo(DEFAULT_READ_MORE_5);
        assertThat(testDernieresNouvelles.getReadMore6()).isEqualTo(DEFAULT_READ_MORE_6);
        assertThat(testDernieresNouvelles.getReadMore7()).isEqualTo(DEFAULT_READ_MORE_7);
        assertThat(testDernieresNouvelles.getReadMore8()).isEqualTo(DEFAULT_READ_MORE_8);
        assertThat(testDernieresNouvelles.getReadMore9()).isEqualTo(DEFAULT_READ_MORE_9);
        assertThat(testDernieresNouvelles.getReadMore10()).isEqualTo(DEFAULT_READ_MORE_10);
        assertThat(testDernieresNouvelles.getDate1()).isEqualTo(DEFAULT_DATE_1);
        assertThat(testDernieresNouvelles.getDate2()).isEqualTo(DEFAULT_DATE_2);
        assertThat(testDernieresNouvelles.getDate3()).isEqualTo(DEFAULT_DATE_3);
        assertThat(testDernieresNouvelles.getDate4()).isEqualTo(DEFAULT_DATE_4);
        assertThat(testDernieresNouvelles.getDate5()).isEqualTo(DEFAULT_DATE_5);
        assertThat(testDernieresNouvelles.getDate6()).isEqualTo(DEFAULT_DATE_6);
        assertThat(testDernieresNouvelles.getDate7()).isEqualTo(DEFAULT_DATE_7);
        assertThat(testDernieresNouvelles.getDate8()).isEqualTo(DEFAULT_DATE_8);
        assertThat(testDernieresNouvelles.getDate9()).isEqualTo(DEFAULT_DATE_9);
        assertThat(testDernieresNouvelles.getDate10()).isEqualTo(DEFAULT_DATE_10);
    }

    @Test
    @Transactional
    public void createDernieresNouvellesWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = dernieresNouvellesRepository.findAll().size();

        // Create the DernieresNouvelles with an existing ID
        dernieresNouvelles.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restDernieresNouvellesMockMvc.perform(post("/api/dernieres-nouvelles")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(dernieresNouvelles)))
            .andExpect(status().isBadRequest());

        // Validate the DernieresNouvelles in the database
        List<DernieresNouvelles> dernieresNouvellesList = dernieresNouvellesRepository.findAll();
        assertThat(dernieresNouvellesList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllDernieresNouvelles() throws Exception {
        // Initialize the database
        dernieresNouvellesRepository.saveAndFlush(dernieresNouvelles);

        // Get all the dernieresNouvellesList
        restDernieresNouvellesMockMvc.perform(get("/api/dernieres-nouvelles?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(dernieresNouvelles.getId().intValue())))
            .andExpect(jsonPath("$.[*].titreFr").value(hasItem(DEFAULT_TITRE_FR)))
            .andExpect(jsonPath("$.[*].titreEn").value(hasItem(DEFAULT_TITRE_EN)))
            .andExpect(jsonPath("$.[*].titreGer").value(hasItem(DEFAULT_TITRE_GER)))
            .andExpect(jsonPath("$.[*].titreSw").value(hasItem(DEFAULT_TITRE_SW)))
            .andExpect(jsonPath("$.[*].sousTitreFr").value(hasItem(DEFAULT_SOUS_TITRE_FR)))
            .andExpect(jsonPath("$.[*].sousTitreEn").value(hasItem(DEFAULT_SOUS_TITRE_EN)))
            .andExpect(jsonPath("$.[*].sousTitreGer").value(hasItem(DEFAULT_SOUS_TITRE_GER)))
            .andExpect(jsonPath("$.[*].sousTitreSw").value(hasItem(DEFAULT_SOUS_TITRE_SW)))
            .andExpect(jsonPath("$.[*].titreSlide1Fr").value(hasItem(DEFAULT_TITRE_SLIDE_1_FR)))
            .andExpect(jsonPath("$.[*].titreSlide1En").value(hasItem(DEFAULT_TITRE_SLIDE_1_EN)))
            .andExpect(jsonPath("$.[*].titreSlide1Ger").value(hasItem(DEFAULT_TITRE_SLIDE_1_GER)))
            .andExpect(jsonPath("$.[*].titreSlide1Sw").value(hasItem(DEFAULT_TITRE_SLIDE_1_SW)))
            .andExpect(jsonPath("$.[*].titreSlide2Fr").value(hasItem(DEFAULT_TITRE_SLIDE_2_FR)))
            .andExpect(jsonPath("$.[*].titreSlide2En").value(hasItem(DEFAULT_TITRE_SLIDE_2_EN)))
            .andExpect(jsonPath("$.[*].titreSlide2Ger").value(hasItem(DEFAULT_TITRE_SLIDE_2_GER)))
            .andExpect(jsonPath("$.[*].titreSlide2Sw").value(hasItem(DEFAULT_TITRE_SLIDE_2_SW)))
            .andExpect(jsonPath("$.[*].titreSlide3Fr").value(hasItem(DEFAULT_TITRE_SLIDE_3_FR)))
            .andExpect(jsonPath("$.[*].titreSlide3En").value(hasItem(DEFAULT_TITRE_SLIDE_3_EN)))
            .andExpect(jsonPath("$.[*].titreSlide3Ger").value(hasItem(DEFAULT_TITRE_SLIDE_3_GER)))
            .andExpect(jsonPath("$.[*].titreSlide3Sw").value(hasItem(DEFAULT_TITRE_SLIDE_3_SW)))
            .andExpect(jsonPath("$.[*].titreSlide4Fr").value(hasItem(DEFAULT_TITRE_SLIDE_4_FR)))
            .andExpect(jsonPath("$.[*].titreSlide4En").value(hasItem(DEFAULT_TITRE_SLIDE_4_EN)))
            .andExpect(jsonPath("$.[*].titreSlide4Ger").value(hasItem(DEFAULT_TITRE_SLIDE_4_GER)))
            .andExpect(jsonPath("$.[*].titreSlide4Sw").value(hasItem(DEFAULT_TITRE_SLIDE_4_SW)))
            .andExpect(jsonPath("$.[*].titreSlide5Fr").value(hasItem(DEFAULT_TITRE_SLIDE_5_FR)))
            .andExpect(jsonPath("$.[*].titreSlide5En").value(hasItem(DEFAULT_TITRE_SLIDE_5_EN)))
            .andExpect(jsonPath("$.[*].titreSlide5Ger").value(hasItem(DEFAULT_TITRE_SLIDE_5_GER)))
            .andExpect(jsonPath("$.[*].titreSlide5Sw").value(hasItem(DEFAULT_TITRE_SLIDE_5_SW)))
            .andExpect(jsonPath("$.[*].titreSlide6Fr").value(hasItem(DEFAULT_TITRE_SLIDE_6_FR)))
            .andExpect(jsonPath("$.[*].titreSlide6En").value(hasItem(DEFAULT_TITRE_SLIDE_6_EN)))
            .andExpect(jsonPath("$.[*].titreSlide6Ger").value(hasItem(DEFAULT_TITRE_SLIDE_6_GER)))
            .andExpect(jsonPath("$.[*].titreSlide6Sw").value(hasItem(DEFAULT_TITRE_SLIDE_6_SW)))
            .andExpect(jsonPath("$.[*].titreSlide7Fr").value(hasItem(DEFAULT_TITRE_SLIDE_7_FR)))
            .andExpect(jsonPath("$.[*].titreSlide7En").value(hasItem(DEFAULT_TITRE_SLIDE_7_EN)))
            .andExpect(jsonPath("$.[*].titreSlide7Ger").value(hasItem(DEFAULT_TITRE_SLIDE_7_GER)))
            .andExpect(jsonPath("$.[*].titreSlide7Sw").value(hasItem(DEFAULT_TITRE_SLIDE_7_SW)))
            .andExpect(jsonPath("$.[*].titreSlide8Fr").value(hasItem(DEFAULT_TITRE_SLIDE_8_FR)))
            .andExpect(jsonPath("$.[*].titreSlide8En").value(hasItem(DEFAULT_TITRE_SLIDE_8_EN)))
            .andExpect(jsonPath("$.[*].titreSlide8Ger").value(hasItem(DEFAULT_TITRE_SLIDE_8_GER)))
            .andExpect(jsonPath("$.[*].titreSlide8Sw").value(hasItem(DEFAULT_TITRE_SLIDE_8_SW)))
            .andExpect(jsonPath("$.[*].titreSlide9Fr").value(hasItem(DEFAULT_TITRE_SLIDE_9_FR)))
            .andExpect(jsonPath("$.[*].titreSlide9En").value(hasItem(DEFAULT_TITRE_SLIDE_9_EN)))
            .andExpect(jsonPath("$.[*].titreSlide9Ger").value(hasItem(DEFAULT_TITRE_SLIDE_9_GER)))
            .andExpect(jsonPath("$.[*].titreSlide9Sw").value(hasItem(DEFAULT_TITRE_SLIDE_9_SW)))
            .andExpect(jsonPath("$.[*].titreSlide1OFr").value(hasItem(DEFAULT_TITRE_SLIDE_1_O_FR)))
            .andExpect(jsonPath("$.[*].titreSlide1OEn").value(hasItem(DEFAULT_TITRE_SLIDE_1_O_EN)))
            .andExpect(jsonPath("$.[*].titreSlide1OGer").value(hasItem(DEFAULT_TITRE_SLIDE_1_O_GER)))
            .andExpect(jsonPath("$.[*].titreSlide1OSw").value(hasItem(DEFAULT_TITRE_SLIDE_1_O_SW)))
            .andExpect(jsonPath("$.[*].textSlide1Fr").value(hasItem(DEFAULT_TEXT_SLIDE_1_FR)))
            .andExpect(jsonPath("$.[*].textSlide1En").value(hasItem(DEFAULT_TEXT_SLIDE_1_EN)))
            .andExpect(jsonPath("$.[*].textSlide1Ger").value(hasItem(DEFAULT_TEXT_SLIDE_1_GER)))
            .andExpect(jsonPath("$.[*].textSlide1Sw").value(hasItem(DEFAULT_TEXT_SLIDE_1_SW)))
            .andExpect(jsonPath("$.[*].textSlide2Fr").value(hasItem(DEFAULT_TEXT_SLIDE_2_FR)))
            .andExpect(jsonPath("$.[*].textSlide2En").value(hasItem(DEFAULT_TEXT_SLIDE_2_EN)))
            .andExpect(jsonPath("$.[*].textSlide2Ger").value(hasItem(DEFAULT_TEXT_SLIDE_2_GER)))
            .andExpect(jsonPath("$.[*].textSlide2Sw").value(hasItem(DEFAULT_TEXT_SLIDE_2_SW)))
            .andExpect(jsonPath("$.[*].textSlide3Fr").value(hasItem(DEFAULT_TEXT_SLIDE_3_FR)))
            .andExpect(jsonPath("$.[*].textSlide3En").value(hasItem(DEFAULT_TEXT_SLIDE_3_EN)))
            .andExpect(jsonPath("$.[*].textSlide3Ger").value(hasItem(DEFAULT_TEXT_SLIDE_3_GER)))
            .andExpect(jsonPath("$.[*].textSlide3Sw").value(hasItem(DEFAULT_TEXT_SLIDE_3_SW)))
            .andExpect(jsonPath("$.[*].textSlide4Fr").value(hasItem(DEFAULT_TEXT_SLIDE_4_FR)))
            .andExpect(jsonPath("$.[*].textSlide4En").value(hasItem(DEFAULT_TEXT_SLIDE_4_EN)))
            .andExpect(jsonPath("$.[*].textSlide4Ger").value(hasItem(DEFAULT_TEXT_SLIDE_4_GER)))
            .andExpect(jsonPath("$.[*].textSlide4Sw").value(hasItem(DEFAULT_TEXT_SLIDE_4_SW)))
            .andExpect(jsonPath("$.[*].textSlide5Fr").value(hasItem(DEFAULT_TEXT_SLIDE_5_FR)))
            .andExpect(jsonPath("$.[*].textSlide5En").value(hasItem(DEFAULT_TEXT_SLIDE_5_EN)))
            .andExpect(jsonPath("$.[*].textSlide5Ger").value(hasItem(DEFAULT_TEXT_SLIDE_5_GER)))
            .andExpect(jsonPath("$.[*].textSlide5Sw").value(hasItem(DEFAULT_TEXT_SLIDE_5_SW)))
            .andExpect(jsonPath("$.[*].textSlide6Fr").value(hasItem(DEFAULT_TEXT_SLIDE_6_FR)))
            .andExpect(jsonPath("$.[*].textSlide6En").value(hasItem(DEFAULT_TEXT_SLIDE_6_EN)))
            .andExpect(jsonPath("$.[*].textSlide6Ger").value(hasItem(DEFAULT_TEXT_SLIDE_6_GER)))
            .andExpect(jsonPath("$.[*].textSlide6Sw").value(hasItem(DEFAULT_TEXT_SLIDE_6_SW)))
            .andExpect(jsonPath("$.[*].textSlide7Fr").value(hasItem(DEFAULT_TEXT_SLIDE_7_FR)))
            .andExpect(jsonPath("$.[*].textSlide7En").value(hasItem(DEFAULT_TEXT_SLIDE_7_EN)))
            .andExpect(jsonPath("$.[*].textSlide7Ger").value(hasItem(DEFAULT_TEXT_SLIDE_7_GER)))
            .andExpect(jsonPath("$.[*].textSlide7Sw").value(hasItem(DEFAULT_TEXT_SLIDE_7_SW)))
            .andExpect(jsonPath("$.[*].textSlide8Fr").value(hasItem(DEFAULT_TEXT_SLIDE_8_FR)))
            .andExpect(jsonPath("$.[*].textSlide8En").value(hasItem(DEFAULT_TEXT_SLIDE_8_EN)))
            .andExpect(jsonPath("$.[*].textSlide8Ger").value(hasItem(DEFAULT_TEXT_SLIDE_8_GER)))
            .andExpect(jsonPath("$.[*].textSlide8Sw").value(hasItem(DEFAULT_TEXT_SLIDE_8_SW)))
            .andExpect(jsonPath("$.[*].textSlide9Fr").value(hasItem(DEFAULT_TEXT_SLIDE_9_FR)))
            .andExpect(jsonPath("$.[*].textSlide9En").value(hasItem(DEFAULT_TEXT_SLIDE_9_EN)))
            .andExpect(jsonPath("$.[*].textSlide9Ger").value(hasItem(DEFAULT_TEXT_SLIDE_9_GER)))
            .andExpect(jsonPath("$.[*].textSlide9Sw").value(hasItem(DEFAULT_TEXT_SLIDE_9_SW)))
            .andExpect(jsonPath("$.[*].textSlide10Fr").value(hasItem(DEFAULT_TEXT_SLIDE_10_FR)))
            .andExpect(jsonPath("$.[*].textSlide10En").value(hasItem(DEFAULT_TEXT_SLIDE_10_EN)))
            .andExpect(jsonPath("$.[*].textSlide10Ger").value(hasItem(DEFAULT_TEXT_SLIDE_10_GER)))
            .andExpect(jsonPath("$.[*].textSlide10Sw").value(hasItem(DEFAULT_TEXT_SLIDE_10_SW)))
            .andExpect(jsonPath("$.[*].imageSlide1ContentType").value(hasItem(DEFAULT_IMAGE_SLIDE_1_CONTENT_TYPE)))
            .andExpect(jsonPath("$.[*].imageSlide1").value(hasItem(Base64Utils.encodeToString(DEFAULT_IMAGE_SLIDE_1))))
            .andExpect(jsonPath("$.[*].imageSlide2ContentType").value(hasItem(DEFAULT_IMAGE_SLIDE_2_CONTENT_TYPE)))
            .andExpect(jsonPath("$.[*].imageSlide2").value(hasItem(Base64Utils.encodeToString(DEFAULT_IMAGE_SLIDE_2))))
            .andExpect(jsonPath("$.[*].imageSlide3ContentType").value(hasItem(DEFAULT_IMAGE_SLIDE_3_CONTENT_TYPE)))
            .andExpect(jsonPath("$.[*].imageSlide3").value(hasItem(Base64Utils.encodeToString(DEFAULT_IMAGE_SLIDE_3))))
            .andExpect(jsonPath("$.[*].imageSlide4ContentType").value(hasItem(DEFAULT_IMAGE_SLIDE_4_CONTENT_TYPE)))
            .andExpect(jsonPath("$.[*].imageSlide4").value(hasItem(Base64Utils.encodeToString(DEFAULT_IMAGE_SLIDE_4))))
            .andExpect(jsonPath("$.[*].imageSlide5ContentType").value(hasItem(DEFAULT_IMAGE_SLIDE_5_CONTENT_TYPE)))
            .andExpect(jsonPath("$.[*].imageSlide5").value(hasItem(Base64Utils.encodeToString(DEFAULT_IMAGE_SLIDE_5))))
            .andExpect(jsonPath("$.[*].imageSlide6ContentType").value(hasItem(DEFAULT_IMAGE_SLIDE_6_CONTENT_TYPE)))
            .andExpect(jsonPath("$.[*].imageSlide6").value(hasItem(Base64Utils.encodeToString(DEFAULT_IMAGE_SLIDE_6))))
            .andExpect(jsonPath("$.[*].imageSlide7ContentType").value(hasItem(DEFAULT_IMAGE_SLIDE_7_CONTENT_TYPE)))
            .andExpect(jsonPath("$.[*].imageSlide7").value(hasItem(Base64Utils.encodeToString(DEFAULT_IMAGE_SLIDE_7))))
            .andExpect(jsonPath("$.[*].imageSlide8ContentType").value(hasItem(DEFAULT_IMAGE_SLIDE_8_CONTENT_TYPE)))
            .andExpect(jsonPath("$.[*].imageSlide8").value(hasItem(Base64Utils.encodeToString(DEFAULT_IMAGE_SLIDE_8))))
            .andExpect(jsonPath("$.[*].imageSlide9ContentType").value(hasItem(DEFAULT_IMAGE_SLIDE_9_CONTENT_TYPE)))
            .andExpect(jsonPath("$.[*].imageSlide9").value(hasItem(Base64Utils.encodeToString(DEFAULT_IMAGE_SLIDE_9))))
            .andExpect(jsonPath("$.[*].imageSlide10ContentType").value(hasItem(DEFAULT_IMAGE_SLIDE_10_CONTENT_TYPE)))
            .andExpect(jsonPath("$.[*].imageSlide10").value(hasItem(Base64Utils.encodeToString(DEFAULT_IMAGE_SLIDE_10))))
            .andExpect(jsonPath("$.[*].readMore1").value(hasItem(DEFAULT_READ_MORE_1)))
            .andExpect(jsonPath("$.[*].readMore2").value(hasItem(DEFAULT_READ_MORE_2)))
            .andExpect(jsonPath("$.[*].readMore3").value(hasItem(DEFAULT_READ_MORE_3)))
            .andExpect(jsonPath("$.[*].readMore4").value(hasItem(DEFAULT_READ_MORE_4)))
            .andExpect(jsonPath("$.[*].readMore5").value(hasItem(DEFAULT_READ_MORE_5)))
            .andExpect(jsonPath("$.[*].readMore6").value(hasItem(DEFAULT_READ_MORE_6)))
            .andExpect(jsonPath("$.[*].readMore7").value(hasItem(DEFAULT_READ_MORE_7)))
            .andExpect(jsonPath("$.[*].readMore8").value(hasItem(DEFAULT_READ_MORE_8)))
            .andExpect(jsonPath("$.[*].readMore9").value(hasItem(DEFAULT_READ_MORE_9)))
            .andExpect(jsonPath("$.[*].readMore10").value(hasItem(DEFAULT_READ_MORE_10)))
            .andExpect(jsonPath("$.[*].date1").value(hasItem(DEFAULT_DATE_1)))
            .andExpect(jsonPath("$.[*].date2").value(hasItem(DEFAULT_DATE_2)))
            .andExpect(jsonPath("$.[*].date3").value(hasItem(DEFAULT_DATE_3)))
            .andExpect(jsonPath("$.[*].date4").value(hasItem(DEFAULT_DATE_4)))
            .andExpect(jsonPath("$.[*].date5").value(hasItem(DEFAULT_DATE_5)))
            .andExpect(jsonPath("$.[*].date6").value(hasItem(DEFAULT_DATE_6)))
            .andExpect(jsonPath("$.[*].date7").value(hasItem(DEFAULT_DATE_7)))
            .andExpect(jsonPath("$.[*].date8").value(hasItem(DEFAULT_DATE_8)))
            .andExpect(jsonPath("$.[*].date9").value(hasItem(DEFAULT_DATE_9)))
            .andExpect(jsonPath("$.[*].date10").value(hasItem(DEFAULT_DATE_10)));
    }
    
    @Test
    @Transactional
    public void getDernieresNouvelles() throws Exception {
        // Initialize the database
        dernieresNouvellesRepository.saveAndFlush(dernieresNouvelles);

        // Get the dernieresNouvelles
        restDernieresNouvellesMockMvc.perform(get("/api/dernieres-nouvelles/{id}", dernieresNouvelles.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(dernieresNouvelles.getId().intValue()))
            .andExpect(jsonPath("$.titreFr").value(DEFAULT_TITRE_FR))
            .andExpect(jsonPath("$.titreEn").value(DEFAULT_TITRE_EN))
            .andExpect(jsonPath("$.titreGer").value(DEFAULT_TITRE_GER))
            .andExpect(jsonPath("$.titreSw").value(DEFAULT_TITRE_SW))
            .andExpect(jsonPath("$.sousTitreFr").value(DEFAULT_SOUS_TITRE_FR))
            .andExpect(jsonPath("$.sousTitreEn").value(DEFAULT_SOUS_TITRE_EN))
            .andExpect(jsonPath("$.sousTitreGer").value(DEFAULT_SOUS_TITRE_GER))
            .andExpect(jsonPath("$.sousTitreSw").value(DEFAULT_SOUS_TITRE_SW))
            .andExpect(jsonPath("$.titreSlide1Fr").value(DEFAULT_TITRE_SLIDE_1_FR))
            .andExpect(jsonPath("$.titreSlide1En").value(DEFAULT_TITRE_SLIDE_1_EN))
            .andExpect(jsonPath("$.titreSlide1Ger").value(DEFAULT_TITRE_SLIDE_1_GER))
            .andExpect(jsonPath("$.titreSlide1Sw").value(DEFAULT_TITRE_SLIDE_1_SW))
            .andExpect(jsonPath("$.titreSlide2Fr").value(DEFAULT_TITRE_SLIDE_2_FR))
            .andExpect(jsonPath("$.titreSlide2En").value(DEFAULT_TITRE_SLIDE_2_EN))
            .andExpect(jsonPath("$.titreSlide2Ger").value(DEFAULT_TITRE_SLIDE_2_GER))
            .andExpect(jsonPath("$.titreSlide2Sw").value(DEFAULT_TITRE_SLIDE_2_SW))
            .andExpect(jsonPath("$.titreSlide3Fr").value(DEFAULT_TITRE_SLIDE_3_FR))
            .andExpect(jsonPath("$.titreSlide3En").value(DEFAULT_TITRE_SLIDE_3_EN))
            .andExpect(jsonPath("$.titreSlide3Ger").value(DEFAULT_TITRE_SLIDE_3_GER))
            .andExpect(jsonPath("$.titreSlide3Sw").value(DEFAULT_TITRE_SLIDE_3_SW))
            .andExpect(jsonPath("$.titreSlide4Fr").value(DEFAULT_TITRE_SLIDE_4_FR))
            .andExpect(jsonPath("$.titreSlide4En").value(DEFAULT_TITRE_SLIDE_4_EN))
            .andExpect(jsonPath("$.titreSlide4Ger").value(DEFAULT_TITRE_SLIDE_4_GER))
            .andExpect(jsonPath("$.titreSlide4Sw").value(DEFAULT_TITRE_SLIDE_4_SW))
            .andExpect(jsonPath("$.titreSlide5Fr").value(DEFAULT_TITRE_SLIDE_5_FR))
            .andExpect(jsonPath("$.titreSlide5En").value(DEFAULT_TITRE_SLIDE_5_EN))
            .andExpect(jsonPath("$.titreSlide5Ger").value(DEFAULT_TITRE_SLIDE_5_GER))
            .andExpect(jsonPath("$.titreSlide5Sw").value(DEFAULT_TITRE_SLIDE_5_SW))
            .andExpect(jsonPath("$.titreSlide6Fr").value(DEFAULT_TITRE_SLIDE_6_FR))
            .andExpect(jsonPath("$.titreSlide6En").value(DEFAULT_TITRE_SLIDE_6_EN))
            .andExpect(jsonPath("$.titreSlide6Ger").value(DEFAULT_TITRE_SLIDE_6_GER))
            .andExpect(jsonPath("$.titreSlide6Sw").value(DEFAULT_TITRE_SLIDE_6_SW))
            .andExpect(jsonPath("$.titreSlide7Fr").value(DEFAULT_TITRE_SLIDE_7_FR))
            .andExpect(jsonPath("$.titreSlide7En").value(DEFAULT_TITRE_SLIDE_7_EN))
            .andExpect(jsonPath("$.titreSlide7Ger").value(DEFAULT_TITRE_SLIDE_7_GER))
            .andExpect(jsonPath("$.titreSlide7Sw").value(DEFAULT_TITRE_SLIDE_7_SW))
            .andExpect(jsonPath("$.titreSlide8Fr").value(DEFAULT_TITRE_SLIDE_8_FR))
            .andExpect(jsonPath("$.titreSlide8En").value(DEFAULT_TITRE_SLIDE_8_EN))
            .andExpect(jsonPath("$.titreSlide8Ger").value(DEFAULT_TITRE_SLIDE_8_GER))
            .andExpect(jsonPath("$.titreSlide8Sw").value(DEFAULT_TITRE_SLIDE_8_SW))
            .andExpect(jsonPath("$.titreSlide9Fr").value(DEFAULT_TITRE_SLIDE_9_FR))
            .andExpect(jsonPath("$.titreSlide9En").value(DEFAULT_TITRE_SLIDE_9_EN))
            .andExpect(jsonPath("$.titreSlide9Ger").value(DEFAULT_TITRE_SLIDE_9_GER))
            .andExpect(jsonPath("$.titreSlide9Sw").value(DEFAULT_TITRE_SLIDE_9_SW))
            .andExpect(jsonPath("$.titreSlide1OFr").value(DEFAULT_TITRE_SLIDE_1_O_FR))
            .andExpect(jsonPath("$.titreSlide1OEn").value(DEFAULT_TITRE_SLIDE_1_O_EN))
            .andExpect(jsonPath("$.titreSlide1OGer").value(DEFAULT_TITRE_SLIDE_1_O_GER))
            .andExpect(jsonPath("$.titreSlide1OSw").value(DEFAULT_TITRE_SLIDE_1_O_SW))
            .andExpect(jsonPath("$.textSlide1Fr").value(DEFAULT_TEXT_SLIDE_1_FR))
            .andExpect(jsonPath("$.textSlide1En").value(DEFAULT_TEXT_SLIDE_1_EN))
            .andExpect(jsonPath("$.textSlide1Ger").value(DEFAULT_TEXT_SLIDE_1_GER))
            .andExpect(jsonPath("$.textSlide1Sw").value(DEFAULT_TEXT_SLIDE_1_SW))
            .andExpect(jsonPath("$.textSlide2Fr").value(DEFAULT_TEXT_SLIDE_2_FR))
            .andExpect(jsonPath("$.textSlide2En").value(DEFAULT_TEXT_SLIDE_2_EN))
            .andExpect(jsonPath("$.textSlide2Ger").value(DEFAULT_TEXT_SLIDE_2_GER))
            .andExpect(jsonPath("$.textSlide2Sw").value(DEFAULT_TEXT_SLIDE_2_SW))
            .andExpect(jsonPath("$.textSlide3Fr").value(DEFAULT_TEXT_SLIDE_3_FR))
            .andExpect(jsonPath("$.textSlide3En").value(DEFAULT_TEXT_SLIDE_3_EN))
            .andExpect(jsonPath("$.textSlide3Ger").value(DEFAULT_TEXT_SLIDE_3_GER))
            .andExpect(jsonPath("$.textSlide3Sw").value(DEFAULT_TEXT_SLIDE_3_SW))
            .andExpect(jsonPath("$.textSlide4Fr").value(DEFAULT_TEXT_SLIDE_4_FR))
            .andExpect(jsonPath("$.textSlide4En").value(DEFAULT_TEXT_SLIDE_4_EN))
            .andExpect(jsonPath("$.textSlide4Ger").value(DEFAULT_TEXT_SLIDE_4_GER))
            .andExpect(jsonPath("$.textSlide4Sw").value(DEFAULT_TEXT_SLIDE_4_SW))
            .andExpect(jsonPath("$.textSlide5Fr").value(DEFAULT_TEXT_SLIDE_5_FR))
            .andExpect(jsonPath("$.textSlide5En").value(DEFAULT_TEXT_SLIDE_5_EN))
            .andExpect(jsonPath("$.textSlide5Ger").value(DEFAULT_TEXT_SLIDE_5_GER))
            .andExpect(jsonPath("$.textSlide5Sw").value(DEFAULT_TEXT_SLIDE_5_SW))
            .andExpect(jsonPath("$.textSlide6Fr").value(DEFAULT_TEXT_SLIDE_6_FR))
            .andExpect(jsonPath("$.textSlide6En").value(DEFAULT_TEXT_SLIDE_6_EN))
            .andExpect(jsonPath("$.textSlide6Ger").value(DEFAULT_TEXT_SLIDE_6_GER))
            .andExpect(jsonPath("$.textSlide6Sw").value(DEFAULT_TEXT_SLIDE_6_SW))
            .andExpect(jsonPath("$.textSlide7Fr").value(DEFAULT_TEXT_SLIDE_7_FR))
            .andExpect(jsonPath("$.textSlide7En").value(DEFAULT_TEXT_SLIDE_7_EN))
            .andExpect(jsonPath("$.textSlide7Ger").value(DEFAULT_TEXT_SLIDE_7_GER))
            .andExpect(jsonPath("$.textSlide7Sw").value(DEFAULT_TEXT_SLIDE_7_SW))
            .andExpect(jsonPath("$.textSlide8Fr").value(DEFAULT_TEXT_SLIDE_8_FR))
            .andExpect(jsonPath("$.textSlide8En").value(DEFAULT_TEXT_SLIDE_8_EN))
            .andExpect(jsonPath("$.textSlide8Ger").value(DEFAULT_TEXT_SLIDE_8_GER))
            .andExpect(jsonPath("$.textSlide8Sw").value(DEFAULT_TEXT_SLIDE_8_SW))
            .andExpect(jsonPath("$.textSlide9Fr").value(DEFAULT_TEXT_SLIDE_9_FR))
            .andExpect(jsonPath("$.textSlide9En").value(DEFAULT_TEXT_SLIDE_9_EN))
            .andExpect(jsonPath("$.textSlide9Ger").value(DEFAULT_TEXT_SLIDE_9_GER))
            .andExpect(jsonPath("$.textSlide9Sw").value(DEFAULT_TEXT_SLIDE_9_SW))
            .andExpect(jsonPath("$.textSlide10Fr").value(DEFAULT_TEXT_SLIDE_10_FR))
            .andExpect(jsonPath("$.textSlide10En").value(DEFAULT_TEXT_SLIDE_10_EN))
            .andExpect(jsonPath("$.textSlide10Ger").value(DEFAULT_TEXT_SLIDE_10_GER))
            .andExpect(jsonPath("$.textSlide10Sw").value(DEFAULT_TEXT_SLIDE_10_SW))
            .andExpect(jsonPath("$.imageSlide1ContentType").value(DEFAULT_IMAGE_SLIDE_1_CONTENT_TYPE))
            .andExpect(jsonPath("$.imageSlide1").value(Base64Utils.encodeToString(DEFAULT_IMAGE_SLIDE_1)))
            .andExpect(jsonPath("$.imageSlide2ContentType").value(DEFAULT_IMAGE_SLIDE_2_CONTENT_TYPE))
            .andExpect(jsonPath("$.imageSlide2").value(Base64Utils.encodeToString(DEFAULT_IMAGE_SLIDE_2)))
            .andExpect(jsonPath("$.imageSlide3ContentType").value(DEFAULT_IMAGE_SLIDE_3_CONTENT_TYPE))
            .andExpect(jsonPath("$.imageSlide3").value(Base64Utils.encodeToString(DEFAULT_IMAGE_SLIDE_3)))
            .andExpect(jsonPath("$.imageSlide4ContentType").value(DEFAULT_IMAGE_SLIDE_4_CONTENT_TYPE))
            .andExpect(jsonPath("$.imageSlide4").value(Base64Utils.encodeToString(DEFAULT_IMAGE_SLIDE_4)))
            .andExpect(jsonPath("$.imageSlide5ContentType").value(DEFAULT_IMAGE_SLIDE_5_CONTENT_TYPE))
            .andExpect(jsonPath("$.imageSlide5").value(Base64Utils.encodeToString(DEFAULT_IMAGE_SLIDE_5)))
            .andExpect(jsonPath("$.imageSlide6ContentType").value(DEFAULT_IMAGE_SLIDE_6_CONTENT_TYPE))
            .andExpect(jsonPath("$.imageSlide6").value(Base64Utils.encodeToString(DEFAULT_IMAGE_SLIDE_6)))
            .andExpect(jsonPath("$.imageSlide7ContentType").value(DEFAULT_IMAGE_SLIDE_7_CONTENT_TYPE))
            .andExpect(jsonPath("$.imageSlide7").value(Base64Utils.encodeToString(DEFAULT_IMAGE_SLIDE_7)))
            .andExpect(jsonPath("$.imageSlide8ContentType").value(DEFAULT_IMAGE_SLIDE_8_CONTENT_TYPE))
            .andExpect(jsonPath("$.imageSlide8").value(Base64Utils.encodeToString(DEFAULT_IMAGE_SLIDE_8)))
            .andExpect(jsonPath("$.imageSlide9ContentType").value(DEFAULT_IMAGE_SLIDE_9_CONTENT_TYPE))
            .andExpect(jsonPath("$.imageSlide9").value(Base64Utils.encodeToString(DEFAULT_IMAGE_SLIDE_9)))
            .andExpect(jsonPath("$.imageSlide10ContentType").value(DEFAULT_IMAGE_SLIDE_10_CONTENT_TYPE))
            .andExpect(jsonPath("$.imageSlide10").value(Base64Utils.encodeToString(DEFAULT_IMAGE_SLIDE_10)))
            .andExpect(jsonPath("$.readMore1").value(DEFAULT_READ_MORE_1))
            .andExpect(jsonPath("$.readMore2").value(DEFAULT_READ_MORE_2))
            .andExpect(jsonPath("$.readMore3").value(DEFAULT_READ_MORE_3))
            .andExpect(jsonPath("$.readMore4").value(DEFAULT_READ_MORE_4))
            .andExpect(jsonPath("$.readMore5").value(DEFAULT_READ_MORE_5))
            .andExpect(jsonPath("$.readMore6").value(DEFAULT_READ_MORE_6))
            .andExpect(jsonPath("$.readMore7").value(DEFAULT_READ_MORE_7))
            .andExpect(jsonPath("$.readMore8").value(DEFAULT_READ_MORE_8))
            .andExpect(jsonPath("$.readMore9").value(DEFAULT_READ_MORE_9))
            .andExpect(jsonPath("$.readMore10").value(DEFAULT_READ_MORE_10))
            .andExpect(jsonPath("$.date1").value(DEFAULT_DATE_1))
            .andExpect(jsonPath("$.date2").value(DEFAULT_DATE_2))
            .andExpect(jsonPath("$.date3").value(DEFAULT_DATE_3))
            .andExpect(jsonPath("$.date4").value(DEFAULT_DATE_4))
            .andExpect(jsonPath("$.date5").value(DEFAULT_DATE_5))
            .andExpect(jsonPath("$.date6").value(DEFAULT_DATE_6))
            .andExpect(jsonPath("$.date7").value(DEFAULT_DATE_7))
            .andExpect(jsonPath("$.date8").value(DEFAULT_DATE_8))
            .andExpect(jsonPath("$.date9").value(DEFAULT_DATE_9))
            .andExpect(jsonPath("$.date10").value(DEFAULT_DATE_10));
    }

    @Test
    @Transactional
    public void getNonExistingDernieresNouvelles() throws Exception {
        // Get the dernieresNouvelles
        restDernieresNouvellesMockMvc.perform(get("/api/dernieres-nouvelles/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateDernieresNouvelles() throws Exception {
        // Initialize the database
        dernieresNouvellesRepository.saveAndFlush(dernieresNouvelles);

        int databaseSizeBeforeUpdate = dernieresNouvellesRepository.findAll().size();

        // Update the dernieresNouvelles
        DernieresNouvelles updatedDernieresNouvelles = dernieresNouvellesRepository.findById(dernieresNouvelles.getId()).get();
        // Disconnect from session so that the updates on updatedDernieresNouvelles are not directly saved in db
        em.detach(updatedDernieresNouvelles);
        updatedDernieresNouvelles
            .titreFr(UPDATED_TITRE_FR)
            .titreEn(UPDATED_TITRE_EN)
            .titreGer(UPDATED_TITRE_GER)
            .titreSw(UPDATED_TITRE_SW)
            .sousTitreFr(UPDATED_SOUS_TITRE_FR)
            .sousTitreEn(UPDATED_SOUS_TITRE_EN)
            .sousTitreGer(UPDATED_SOUS_TITRE_GER)
            .sousTitreSw(UPDATED_SOUS_TITRE_SW)
            .titreSlide1Fr(UPDATED_TITRE_SLIDE_1_FR)
            .titreSlide1En(UPDATED_TITRE_SLIDE_1_EN)
            .titreSlide1Ger(UPDATED_TITRE_SLIDE_1_GER)
            .titreSlide1Sw(UPDATED_TITRE_SLIDE_1_SW)
            .titreSlide2Fr(UPDATED_TITRE_SLIDE_2_FR)
            .titreSlide2En(UPDATED_TITRE_SLIDE_2_EN)
            .titreSlide2Ger(UPDATED_TITRE_SLIDE_2_GER)
            .titreSlide2Sw(UPDATED_TITRE_SLIDE_2_SW)
            .titreSlide3Fr(UPDATED_TITRE_SLIDE_3_FR)
            .titreSlide3En(UPDATED_TITRE_SLIDE_3_EN)
            .titreSlide3Ger(UPDATED_TITRE_SLIDE_3_GER)
            .titreSlide3Sw(UPDATED_TITRE_SLIDE_3_SW)
            .titreSlide4Fr(UPDATED_TITRE_SLIDE_4_FR)
            .titreSlide4En(UPDATED_TITRE_SLIDE_4_EN)
            .titreSlide4Ger(UPDATED_TITRE_SLIDE_4_GER)
            .titreSlide4Sw(UPDATED_TITRE_SLIDE_4_SW)
            .titreSlide5Fr(UPDATED_TITRE_SLIDE_5_FR)
            .titreSlide5En(UPDATED_TITRE_SLIDE_5_EN)
            .titreSlide5Ger(UPDATED_TITRE_SLIDE_5_GER)
            .titreSlide5Sw(UPDATED_TITRE_SLIDE_5_SW)
            .titreSlide6Fr(UPDATED_TITRE_SLIDE_6_FR)
            .titreSlide6En(UPDATED_TITRE_SLIDE_6_EN)
            .titreSlide6Ger(UPDATED_TITRE_SLIDE_6_GER)
            .titreSlide6Sw(UPDATED_TITRE_SLIDE_6_SW)
            .titreSlide7Fr(UPDATED_TITRE_SLIDE_7_FR)
            .titreSlide7En(UPDATED_TITRE_SLIDE_7_EN)
            .titreSlide7Ger(UPDATED_TITRE_SLIDE_7_GER)
            .titreSlide7Sw(UPDATED_TITRE_SLIDE_7_SW)
            .titreSlide8Fr(UPDATED_TITRE_SLIDE_8_FR)
            .titreSlide8En(UPDATED_TITRE_SLIDE_8_EN)
            .titreSlide8Ger(UPDATED_TITRE_SLIDE_8_GER)
            .titreSlide8Sw(UPDATED_TITRE_SLIDE_8_SW)
            .titreSlide9Fr(UPDATED_TITRE_SLIDE_9_FR)
            .titreSlide9En(UPDATED_TITRE_SLIDE_9_EN)
            .titreSlide9Ger(UPDATED_TITRE_SLIDE_9_GER)
            .titreSlide9Sw(UPDATED_TITRE_SLIDE_9_SW)
            .titreSlide1OFr(UPDATED_TITRE_SLIDE_1_O_FR)
            .titreSlide1OEn(UPDATED_TITRE_SLIDE_1_O_EN)
            .titreSlide1OGer(UPDATED_TITRE_SLIDE_1_O_GER)
            .titreSlide1OSw(UPDATED_TITRE_SLIDE_1_O_SW)
            .textSlide1Fr(UPDATED_TEXT_SLIDE_1_FR)
            .textSlide1En(UPDATED_TEXT_SLIDE_1_EN)
            .textSlide1Ger(UPDATED_TEXT_SLIDE_1_GER)
            .textSlide1Sw(UPDATED_TEXT_SLIDE_1_SW)
            .textSlide2Fr(UPDATED_TEXT_SLIDE_2_FR)
            .textSlide2En(UPDATED_TEXT_SLIDE_2_EN)
            .textSlide2Ger(UPDATED_TEXT_SLIDE_2_GER)
            .textSlide2Sw(UPDATED_TEXT_SLIDE_2_SW)
            .textSlide3Fr(UPDATED_TEXT_SLIDE_3_FR)
            .textSlide3En(UPDATED_TEXT_SLIDE_3_EN)
            .textSlide3Ger(UPDATED_TEXT_SLIDE_3_GER)
            .textSlide3Sw(UPDATED_TEXT_SLIDE_3_SW)
            .textSlide4Fr(UPDATED_TEXT_SLIDE_4_FR)
            .textSlide4En(UPDATED_TEXT_SLIDE_4_EN)
            .textSlide4Ger(UPDATED_TEXT_SLIDE_4_GER)
            .textSlide4Sw(UPDATED_TEXT_SLIDE_4_SW)
            .textSlide5Fr(UPDATED_TEXT_SLIDE_5_FR)
            .textSlide5En(UPDATED_TEXT_SLIDE_5_EN)
            .textSlide5Ger(UPDATED_TEXT_SLIDE_5_GER)
            .textSlide5Sw(UPDATED_TEXT_SLIDE_5_SW)
            .textSlide6Fr(UPDATED_TEXT_SLIDE_6_FR)
            .textSlide6En(UPDATED_TEXT_SLIDE_6_EN)
            .textSlide6Ger(UPDATED_TEXT_SLIDE_6_GER)
            .textSlide6Sw(UPDATED_TEXT_SLIDE_6_SW)
            .textSlide7Fr(UPDATED_TEXT_SLIDE_7_FR)
            .textSlide7En(UPDATED_TEXT_SLIDE_7_EN)
            .textSlide7Ger(UPDATED_TEXT_SLIDE_7_GER)
            .textSlide7Sw(UPDATED_TEXT_SLIDE_7_SW)
            .textSlide8Fr(UPDATED_TEXT_SLIDE_8_FR)
            .textSlide8En(UPDATED_TEXT_SLIDE_8_EN)
            .textSlide8Ger(UPDATED_TEXT_SLIDE_8_GER)
            .textSlide8Sw(UPDATED_TEXT_SLIDE_8_SW)
            .textSlide9Fr(UPDATED_TEXT_SLIDE_9_FR)
            .textSlide9En(UPDATED_TEXT_SLIDE_9_EN)
            .textSlide9Ger(UPDATED_TEXT_SLIDE_9_GER)
            .textSlide9Sw(UPDATED_TEXT_SLIDE_9_SW)
            .textSlide10Fr(UPDATED_TEXT_SLIDE_10_FR)
            .textSlide10En(UPDATED_TEXT_SLIDE_10_EN)
            .textSlide10Ger(UPDATED_TEXT_SLIDE_10_GER)
            .textSlide10Sw(UPDATED_TEXT_SLIDE_10_SW)
            .imageSlide1(UPDATED_IMAGE_SLIDE_1)
            .imageSlide1ContentType(UPDATED_IMAGE_SLIDE_1_CONTENT_TYPE)
            .imageSlide2(UPDATED_IMAGE_SLIDE_2)
            .imageSlide2ContentType(UPDATED_IMAGE_SLIDE_2_CONTENT_TYPE)
            .imageSlide3(UPDATED_IMAGE_SLIDE_3)
            .imageSlide3ContentType(UPDATED_IMAGE_SLIDE_3_CONTENT_TYPE)
            .imageSlide4(UPDATED_IMAGE_SLIDE_4)
            .imageSlide4ContentType(UPDATED_IMAGE_SLIDE_4_CONTENT_TYPE)
            .imageSlide5(UPDATED_IMAGE_SLIDE_5)
            .imageSlide5ContentType(UPDATED_IMAGE_SLIDE_5_CONTENT_TYPE)
            .imageSlide6(UPDATED_IMAGE_SLIDE_6)
            .imageSlide6ContentType(UPDATED_IMAGE_SLIDE_6_CONTENT_TYPE)
            .imageSlide7(UPDATED_IMAGE_SLIDE_7)
            .imageSlide7ContentType(UPDATED_IMAGE_SLIDE_7_CONTENT_TYPE)
            .imageSlide8(UPDATED_IMAGE_SLIDE_8)
            .imageSlide8ContentType(UPDATED_IMAGE_SLIDE_8_CONTENT_TYPE)
            .imageSlide9(UPDATED_IMAGE_SLIDE_9)
            .imageSlide9ContentType(UPDATED_IMAGE_SLIDE_9_CONTENT_TYPE)
            .imageSlide10(UPDATED_IMAGE_SLIDE_10)
            .imageSlide10ContentType(UPDATED_IMAGE_SLIDE_10_CONTENT_TYPE)
            .readMore1(UPDATED_READ_MORE_1)
            .readMore2(UPDATED_READ_MORE_2)
            .readMore3(UPDATED_READ_MORE_3)
            .readMore4(UPDATED_READ_MORE_4)
            .readMore5(UPDATED_READ_MORE_5)
            .readMore6(UPDATED_READ_MORE_6)
            .readMore7(UPDATED_READ_MORE_7)
            .readMore8(UPDATED_READ_MORE_8)
            .readMore9(UPDATED_READ_MORE_9)
            .readMore10(UPDATED_READ_MORE_10)
            .date1(UPDATED_DATE_1)
            .date2(UPDATED_DATE_2)
            .date3(UPDATED_DATE_3)
            .date4(UPDATED_DATE_4)
            .date5(UPDATED_DATE_5)
            .date6(UPDATED_DATE_6)
            .date7(UPDATED_DATE_7)
            .date8(UPDATED_DATE_8)
            .date9(UPDATED_DATE_9)
            .date10(UPDATED_DATE_10);

        restDernieresNouvellesMockMvc.perform(put("/api/dernieres-nouvelles")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(updatedDernieresNouvelles)))
            .andExpect(status().isOk());

        // Validate the DernieresNouvelles in the database
        List<DernieresNouvelles> dernieresNouvellesList = dernieresNouvellesRepository.findAll();
        assertThat(dernieresNouvellesList).hasSize(databaseSizeBeforeUpdate);
        DernieresNouvelles testDernieresNouvelles = dernieresNouvellesList.get(dernieresNouvellesList.size() - 1);
        assertThat(testDernieresNouvelles.getTitreFr()).isEqualTo(UPDATED_TITRE_FR);
        assertThat(testDernieresNouvelles.getTitreEn()).isEqualTo(UPDATED_TITRE_EN);
        assertThat(testDernieresNouvelles.getTitreGer()).isEqualTo(UPDATED_TITRE_GER);
        assertThat(testDernieresNouvelles.getTitreSw()).isEqualTo(UPDATED_TITRE_SW);
        assertThat(testDernieresNouvelles.getSousTitreFr()).isEqualTo(UPDATED_SOUS_TITRE_FR);
        assertThat(testDernieresNouvelles.getSousTitreEn()).isEqualTo(UPDATED_SOUS_TITRE_EN);
        assertThat(testDernieresNouvelles.getSousTitreGer()).isEqualTo(UPDATED_SOUS_TITRE_GER);
        assertThat(testDernieresNouvelles.getSousTitreSw()).isEqualTo(UPDATED_SOUS_TITRE_SW);
        assertThat(testDernieresNouvelles.getTitreSlide1Fr()).isEqualTo(UPDATED_TITRE_SLIDE_1_FR);
        assertThat(testDernieresNouvelles.getTitreSlide1En()).isEqualTo(UPDATED_TITRE_SLIDE_1_EN);
        assertThat(testDernieresNouvelles.getTitreSlide1Ger()).isEqualTo(UPDATED_TITRE_SLIDE_1_GER);
        assertThat(testDernieresNouvelles.getTitreSlide1Sw()).isEqualTo(UPDATED_TITRE_SLIDE_1_SW);
        assertThat(testDernieresNouvelles.getTitreSlide2Fr()).isEqualTo(UPDATED_TITRE_SLIDE_2_FR);
        assertThat(testDernieresNouvelles.getTitreSlide2En()).isEqualTo(UPDATED_TITRE_SLIDE_2_EN);
        assertThat(testDernieresNouvelles.getTitreSlide2Ger()).isEqualTo(UPDATED_TITRE_SLIDE_2_GER);
        assertThat(testDernieresNouvelles.getTitreSlide2Sw()).isEqualTo(UPDATED_TITRE_SLIDE_2_SW);
        assertThat(testDernieresNouvelles.getTitreSlide3Fr()).isEqualTo(UPDATED_TITRE_SLIDE_3_FR);
        assertThat(testDernieresNouvelles.getTitreSlide3En()).isEqualTo(UPDATED_TITRE_SLIDE_3_EN);
        assertThat(testDernieresNouvelles.getTitreSlide3Ger()).isEqualTo(UPDATED_TITRE_SLIDE_3_GER);
        assertThat(testDernieresNouvelles.getTitreSlide3Sw()).isEqualTo(UPDATED_TITRE_SLIDE_3_SW);
        assertThat(testDernieresNouvelles.getTitreSlide4Fr()).isEqualTo(UPDATED_TITRE_SLIDE_4_FR);
        assertThat(testDernieresNouvelles.getTitreSlide4En()).isEqualTo(UPDATED_TITRE_SLIDE_4_EN);
        assertThat(testDernieresNouvelles.getTitreSlide4Ger()).isEqualTo(UPDATED_TITRE_SLIDE_4_GER);
        assertThat(testDernieresNouvelles.getTitreSlide4Sw()).isEqualTo(UPDATED_TITRE_SLIDE_4_SW);
        assertThat(testDernieresNouvelles.getTitreSlide5Fr()).isEqualTo(UPDATED_TITRE_SLIDE_5_FR);
        assertThat(testDernieresNouvelles.getTitreSlide5En()).isEqualTo(UPDATED_TITRE_SLIDE_5_EN);
        assertThat(testDernieresNouvelles.getTitreSlide5Ger()).isEqualTo(UPDATED_TITRE_SLIDE_5_GER);
        assertThat(testDernieresNouvelles.getTitreSlide5Sw()).isEqualTo(UPDATED_TITRE_SLIDE_5_SW);
        assertThat(testDernieresNouvelles.getTitreSlide6Fr()).isEqualTo(UPDATED_TITRE_SLIDE_6_FR);
        assertThat(testDernieresNouvelles.getTitreSlide6En()).isEqualTo(UPDATED_TITRE_SLIDE_6_EN);
        assertThat(testDernieresNouvelles.getTitreSlide6Ger()).isEqualTo(UPDATED_TITRE_SLIDE_6_GER);
        assertThat(testDernieresNouvelles.getTitreSlide6Sw()).isEqualTo(UPDATED_TITRE_SLIDE_6_SW);
        assertThat(testDernieresNouvelles.getTitreSlide7Fr()).isEqualTo(UPDATED_TITRE_SLIDE_7_FR);
        assertThat(testDernieresNouvelles.getTitreSlide7En()).isEqualTo(UPDATED_TITRE_SLIDE_7_EN);
        assertThat(testDernieresNouvelles.getTitreSlide7Ger()).isEqualTo(UPDATED_TITRE_SLIDE_7_GER);
        assertThat(testDernieresNouvelles.getTitreSlide7Sw()).isEqualTo(UPDATED_TITRE_SLIDE_7_SW);
        assertThat(testDernieresNouvelles.getTitreSlide8Fr()).isEqualTo(UPDATED_TITRE_SLIDE_8_FR);
        assertThat(testDernieresNouvelles.getTitreSlide8En()).isEqualTo(UPDATED_TITRE_SLIDE_8_EN);
        assertThat(testDernieresNouvelles.getTitreSlide8Ger()).isEqualTo(UPDATED_TITRE_SLIDE_8_GER);
        assertThat(testDernieresNouvelles.getTitreSlide8Sw()).isEqualTo(UPDATED_TITRE_SLIDE_8_SW);
        assertThat(testDernieresNouvelles.getTitreSlide9Fr()).isEqualTo(UPDATED_TITRE_SLIDE_9_FR);
        assertThat(testDernieresNouvelles.getTitreSlide9En()).isEqualTo(UPDATED_TITRE_SLIDE_9_EN);
        assertThat(testDernieresNouvelles.getTitreSlide9Ger()).isEqualTo(UPDATED_TITRE_SLIDE_9_GER);
        assertThat(testDernieresNouvelles.getTitreSlide9Sw()).isEqualTo(UPDATED_TITRE_SLIDE_9_SW);
        assertThat(testDernieresNouvelles.getTitreSlide1OFr()).isEqualTo(UPDATED_TITRE_SLIDE_1_O_FR);
        assertThat(testDernieresNouvelles.getTitreSlide1OEn()).isEqualTo(UPDATED_TITRE_SLIDE_1_O_EN);
        assertThat(testDernieresNouvelles.getTitreSlide1OGer()).isEqualTo(UPDATED_TITRE_SLIDE_1_O_GER);
        assertThat(testDernieresNouvelles.getTitreSlide1OSw()).isEqualTo(UPDATED_TITRE_SLIDE_1_O_SW);
        assertThat(testDernieresNouvelles.getTextSlide1Fr()).isEqualTo(UPDATED_TEXT_SLIDE_1_FR);
        assertThat(testDernieresNouvelles.getTextSlide1En()).isEqualTo(UPDATED_TEXT_SLIDE_1_EN);
        assertThat(testDernieresNouvelles.getTextSlide1Ger()).isEqualTo(UPDATED_TEXT_SLIDE_1_GER);
        assertThat(testDernieresNouvelles.getTextSlide1Sw()).isEqualTo(UPDATED_TEXT_SLIDE_1_SW);
        assertThat(testDernieresNouvelles.getTextSlide2Fr()).isEqualTo(UPDATED_TEXT_SLIDE_2_FR);
        assertThat(testDernieresNouvelles.getTextSlide2En()).isEqualTo(UPDATED_TEXT_SLIDE_2_EN);
        assertThat(testDernieresNouvelles.getTextSlide2Ger()).isEqualTo(UPDATED_TEXT_SLIDE_2_GER);
        assertThat(testDernieresNouvelles.getTextSlide2Sw()).isEqualTo(UPDATED_TEXT_SLIDE_2_SW);
        assertThat(testDernieresNouvelles.getTextSlide3Fr()).isEqualTo(UPDATED_TEXT_SLIDE_3_FR);
        assertThat(testDernieresNouvelles.getTextSlide3En()).isEqualTo(UPDATED_TEXT_SLIDE_3_EN);
        assertThat(testDernieresNouvelles.getTextSlide3Ger()).isEqualTo(UPDATED_TEXT_SLIDE_3_GER);
        assertThat(testDernieresNouvelles.getTextSlide3Sw()).isEqualTo(UPDATED_TEXT_SLIDE_3_SW);
        assertThat(testDernieresNouvelles.getTextSlide4Fr()).isEqualTo(UPDATED_TEXT_SLIDE_4_FR);
        assertThat(testDernieresNouvelles.getTextSlide4En()).isEqualTo(UPDATED_TEXT_SLIDE_4_EN);
        assertThat(testDernieresNouvelles.getTextSlide4Ger()).isEqualTo(UPDATED_TEXT_SLIDE_4_GER);
        assertThat(testDernieresNouvelles.getTextSlide4Sw()).isEqualTo(UPDATED_TEXT_SLIDE_4_SW);
        assertThat(testDernieresNouvelles.getTextSlide5Fr()).isEqualTo(UPDATED_TEXT_SLIDE_5_FR);
        assertThat(testDernieresNouvelles.getTextSlide5En()).isEqualTo(UPDATED_TEXT_SLIDE_5_EN);
        assertThat(testDernieresNouvelles.getTextSlide5Ger()).isEqualTo(UPDATED_TEXT_SLIDE_5_GER);
        assertThat(testDernieresNouvelles.getTextSlide5Sw()).isEqualTo(UPDATED_TEXT_SLIDE_5_SW);
        assertThat(testDernieresNouvelles.getTextSlide6Fr()).isEqualTo(UPDATED_TEXT_SLIDE_6_FR);
        assertThat(testDernieresNouvelles.getTextSlide6En()).isEqualTo(UPDATED_TEXT_SLIDE_6_EN);
        assertThat(testDernieresNouvelles.getTextSlide6Ger()).isEqualTo(UPDATED_TEXT_SLIDE_6_GER);
        assertThat(testDernieresNouvelles.getTextSlide6Sw()).isEqualTo(UPDATED_TEXT_SLIDE_6_SW);
        assertThat(testDernieresNouvelles.getTextSlide7Fr()).isEqualTo(UPDATED_TEXT_SLIDE_7_FR);
        assertThat(testDernieresNouvelles.getTextSlide7En()).isEqualTo(UPDATED_TEXT_SLIDE_7_EN);
        assertThat(testDernieresNouvelles.getTextSlide7Ger()).isEqualTo(UPDATED_TEXT_SLIDE_7_GER);
        assertThat(testDernieresNouvelles.getTextSlide7Sw()).isEqualTo(UPDATED_TEXT_SLIDE_7_SW);
        assertThat(testDernieresNouvelles.getTextSlide8Fr()).isEqualTo(UPDATED_TEXT_SLIDE_8_FR);
        assertThat(testDernieresNouvelles.getTextSlide8En()).isEqualTo(UPDATED_TEXT_SLIDE_8_EN);
        assertThat(testDernieresNouvelles.getTextSlide8Ger()).isEqualTo(UPDATED_TEXT_SLIDE_8_GER);
        assertThat(testDernieresNouvelles.getTextSlide8Sw()).isEqualTo(UPDATED_TEXT_SLIDE_8_SW);
        assertThat(testDernieresNouvelles.getTextSlide9Fr()).isEqualTo(UPDATED_TEXT_SLIDE_9_FR);
        assertThat(testDernieresNouvelles.getTextSlide9En()).isEqualTo(UPDATED_TEXT_SLIDE_9_EN);
        assertThat(testDernieresNouvelles.getTextSlide9Ger()).isEqualTo(UPDATED_TEXT_SLIDE_9_GER);
        assertThat(testDernieresNouvelles.getTextSlide9Sw()).isEqualTo(UPDATED_TEXT_SLIDE_9_SW);
        assertThat(testDernieresNouvelles.getTextSlide10Fr()).isEqualTo(UPDATED_TEXT_SLIDE_10_FR);
        assertThat(testDernieresNouvelles.getTextSlide10En()).isEqualTo(UPDATED_TEXT_SLIDE_10_EN);
        assertThat(testDernieresNouvelles.getTextSlide10Ger()).isEqualTo(UPDATED_TEXT_SLIDE_10_GER);
        assertThat(testDernieresNouvelles.getTextSlide10Sw()).isEqualTo(UPDATED_TEXT_SLIDE_10_SW);
        assertThat(testDernieresNouvelles.getImageSlide1()).isEqualTo(UPDATED_IMAGE_SLIDE_1);
        assertThat(testDernieresNouvelles.getImageSlide1ContentType()).isEqualTo(UPDATED_IMAGE_SLIDE_1_CONTENT_TYPE);
        assertThat(testDernieresNouvelles.getImageSlide2()).isEqualTo(UPDATED_IMAGE_SLIDE_2);
        assertThat(testDernieresNouvelles.getImageSlide2ContentType()).isEqualTo(UPDATED_IMAGE_SLIDE_2_CONTENT_TYPE);
        assertThat(testDernieresNouvelles.getImageSlide3()).isEqualTo(UPDATED_IMAGE_SLIDE_3);
        assertThat(testDernieresNouvelles.getImageSlide3ContentType()).isEqualTo(UPDATED_IMAGE_SLIDE_3_CONTENT_TYPE);
        assertThat(testDernieresNouvelles.getImageSlide4()).isEqualTo(UPDATED_IMAGE_SLIDE_4);
        assertThat(testDernieresNouvelles.getImageSlide4ContentType()).isEqualTo(UPDATED_IMAGE_SLIDE_4_CONTENT_TYPE);
        assertThat(testDernieresNouvelles.getImageSlide5()).isEqualTo(UPDATED_IMAGE_SLIDE_5);
        assertThat(testDernieresNouvelles.getImageSlide5ContentType()).isEqualTo(UPDATED_IMAGE_SLIDE_5_CONTENT_TYPE);
        assertThat(testDernieresNouvelles.getImageSlide6()).isEqualTo(UPDATED_IMAGE_SLIDE_6);
        assertThat(testDernieresNouvelles.getImageSlide6ContentType()).isEqualTo(UPDATED_IMAGE_SLIDE_6_CONTENT_TYPE);
        assertThat(testDernieresNouvelles.getImageSlide7()).isEqualTo(UPDATED_IMAGE_SLIDE_7);
        assertThat(testDernieresNouvelles.getImageSlide7ContentType()).isEqualTo(UPDATED_IMAGE_SLIDE_7_CONTENT_TYPE);
        assertThat(testDernieresNouvelles.getImageSlide8()).isEqualTo(UPDATED_IMAGE_SLIDE_8);
        assertThat(testDernieresNouvelles.getImageSlide8ContentType()).isEqualTo(UPDATED_IMAGE_SLIDE_8_CONTENT_TYPE);
        assertThat(testDernieresNouvelles.getImageSlide9()).isEqualTo(UPDATED_IMAGE_SLIDE_9);
        assertThat(testDernieresNouvelles.getImageSlide9ContentType()).isEqualTo(UPDATED_IMAGE_SLIDE_9_CONTENT_TYPE);
        assertThat(testDernieresNouvelles.getImageSlide10()).isEqualTo(UPDATED_IMAGE_SLIDE_10);
        assertThat(testDernieresNouvelles.getImageSlide10ContentType()).isEqualTo(UPDATED_IMAGE_SLIDE_10_CONTENT_TYPE);
        assertThat(testDernieresNouvelles.getReadMore1()).isEqualTo(UPDATED_READ_MORE_1);
        assertThat(testDernieresNouvelles.getReadMore2()).isEqualTo(UPDATED_READ_MORE_2);
        assertThat(testDernieresNouvelles.getReadMore3()).isEqualTo(UPDATED_READ_MORE_3);
        assertThat(testDernieresNouvelles.getReadMore4()).isEqualTo(UPDATED_READ_MORE_4);
        assertThat(testDernieresNouvelles.getReadMore5()).isEqualTo(UPDATED_READ_MORE_5);
        assertThat(testDernieresNouvelles.getReadMore6()).isEqualTo(UPDATED_READ_MORE_6);
        assertThat(testDernieresNouvelles.getReadMore7()).isEqualTo(UPDATED_READ_MORE_7);
        assertThat(testDernieresNouvelles.getReadMore8()).isEqualTo(UPDATED_READ_MORE_8);
        assertThat(testDernieresNouvelles.getReadMore9()).isEqualTo(UPDATED_READ_MORE_9);
        assertThat(testDernieresNouvelles.getReadMore10()).isEqualTo(UPDATED_READ_MORE_10);
        assertThat(testDernieresNouvelles.getDate1()).isEqualTo(UPDATED_DATE_1);
        assertThat(testDernieresNouvelles.getDate2()).isEqualTo(UPDATED_DATE_2);
        assertThat(testDernieresNouvelles.getDate3()).isEqualTo(UPDATED_DATE_3);
        assertThat(testDernieresNouvelles.getDate4()).isEqualTo(UPDATED_DATE_4);
        assertThat(testDernieresNouvelles.getDate5()).isEqualTo(UPDATED_DATE_5);
        assertThat(testDernieresNouvelles.getDate6()).isEqualTo(UPDATED_DATE_6);
        assertThat(testDernieresNouvelles.getDate7()).isEqualTo(UPDATED_DATE_7);
        assertThat(testDernieresNouvelles.getDate8()).isEqualTo(UPDATED_DATE_8);
        assertThat(testDernieresNouvelles.getDate9()).isEqualTo(UPDATED_DATE_9);
        assertThat(testDernieresNouvelles.getDate10()).isEqualTo(UPDATED_DATE_10);
    }

    @Test
    @Transactional
    public void updateNonExistingDernieresNouvelles() throws Exception {
        int databaseSizeBeforeUpdate = dernieresNouvellesRepository.findAll().size();

        // Create the DernieresNouvelles

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restDernieresNouvellesMockMvc.perform(put("/api/dernieres-nouvelles")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(dernieresNouvelles)))
            .andExpect(status().isBadRequest());

        // Validate the DernieresNouvelles in the database
        List<DernieresNouvelles> dernieresNouvellesList = dernieresNouvellesRepository.findAll();
        assertThat(dernieresNouvellesList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteDernieresNouvelles() throws Exception {
        // Initialize the database
        dernieresNouvellesRepository.saveAndFlush(dernieresNouvelles);

        int databaseSizeBeforeDelete = dernieresNouvellesRepository.findAll().size();

        // Delete the dernieresNouvelles
        restDernieresNouvellesMockMvc.perform(delete("/api/dernieres-nouvelles/{id}", dernieresNouvelles.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<DernieresNouvelles> dernieresNouvellesList = dernieresNouvellesRepository.findAll();
        assertThat(dernieresNouvellesList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
