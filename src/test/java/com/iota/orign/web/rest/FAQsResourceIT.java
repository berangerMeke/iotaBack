package com.iota.orign.web.rest;

import com.iota.orign.IotaOrignAdminApp;
import com.iota.orign.domain.FAQs;
import com.iota.orign.repository.FAQsRepository;

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
 * Integration tests for the {@link FAQsResource} REST controller.
 */
@SpringBootTest(classes = IotaOrignAdminApp.class)

@AutoConfigureMockMvc
@WithMockUser
public class FAQsResourceIT {

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

    private static final String DEFAULT_TITRE_ACCORDION_1_FR = "AAAAAAAAAA";
    private static final String UPDATED_TITRE_ACCORDION_1_FR = "BBBBBBBBBB";

    private static final String DEFAULT_TITRE_ACCORDION_1_EN = "AAAAAAAAAA";
    private static final String UPDATED_TITRE_ACCORDION_1_EN = "BBBBBBBBBB";

    private static final String DEFAULT_TITRE_ACCORDION_1_GR = "AAAAAAAAAA";
    private static final String UPDATED_TITRE_ACCORDION_1_GR = "BBBBBBBBBB";

    private static final String DEFAULT_TITRE_ACCORDION_1_SW = "AAAAAAAAAA";
    private static final String UPDATED_TITRE_ACCORDION_1_SW = "BBBBBBBBBB";

    private static final String DEFAULT_TITRE_ACCORDION_2_FR = "AAAAAAAAAA";
    private static final String UPDATED_TITRE_ACCORDION_2_FR = "BBBBBBBBBB";

    private static final String DEFAULT_TITRE_ACCORDION_2_EN = "AAAAAAAAAA";
    private static final String UPDATED_TITRE_ACCORDION_2_EN = "BBBBBBBBBB";

    private static final String DEFAULT_TITRE_ACCORDION_2_GER = "AAAAAAAAAA";
    private static final String UPDATED_TITRE_ACCORDION_2_GER = "BBBBBBBBBB";

    private static final String DEFAULT_TITRE_ACCORDION_2_SW = "AAAAAAAAAA";
    private static final String UPDATED_TITRE_ACCORDION_2_SW = "BBBBBBBBBB";

    private static final String DEFAULT_TITRE_ACCORDION_3_FR = "AAAAAAAAAA";
    private static final String UPDATED_TITRE_ACCORDION_3_FR = "BBBBBBBBBB";

    private static final String DEFAULT_TITRE_ACCORDION_3_EN = "AAAAAAAAAA";
    private static final String UPDATED_TITRE_ACCORDION_3_EN = "BBBBBBBBBB";

    private static final String DEFAULT_TITRE_ACCORDION_3_GER = "AAAAAAAAAA";
    private static final String UPDATED_TITRE_ACCORDION_3_GER = "BBBBBBBBBB";

    private static final String DEFAULT_TITRE_ACCORDION_3_SW = "AAAAAAAAAA";
    private static final String UPDATED_TITRE_ACCORDION_3_SW = "BBBBBBBBBB";

    private static final String DEFAULT_TITRE_ACCORDION_4_FR = "AAAAAAAAAA";
    private static final String UPDATED_TITRE_ACCORDION_4_FR = "BBBBBBBBBB";

    private static final String DEFAULT_TITRE_ACCORDION_4_EN = "AAAAAAAAAA";
    private static final String UPDATED_TITRE_ACCORDION_4_EN = "BBBBBBBBBB";

    private static final String DEFAULT_TITRE_ACCORDION_4_GER = "AAAAAAAAAA";
    private static final String UPDATED_TITRE_ACCORDION_4_GER = "BBBBBBBBBB";

    private static final String DEFAULT_TITRE_ACCORDION_4_SW = "AAAAAAAAAA";
    private static final String UPDATED_TITRE_ACCORDION_4_SW = "BBBBBBBBBB";

    private static final String DEFAULT_TITRE_ACCORDION_5_FR = "AAAAAAAAAA";
    private static final String UPDATED_TITRE_ACCORDION_5_FR = "BBBBBBBBBB";

    private static final String DEFAULT_TITRE_ACCORDION_5_EN = "AAAAAAAAAA";
    private static final String UPDATED_TITRE_ACCORDION_5_EN = "BBBBBBBBBB";

    private static final String DEFAULT_TITRE_ACCORDION_5_GER = "AAAAAAAAAA";
    private static final String UPDATED_TITRE_ACCORDION_5_GER = "BBBBBBBBBB";

    private static final String DEFAULT_TITRE_ACCORDION_5_SW = "AAAAAAAAAA";
    private static final String UPDATED_TITRE_ACCORDION_5_SW = "BBBBBBBBBB";

    private static final String DEFAULT_TITRE_ACCORDION_6_FR = "AAAAAAAAAA";
    private static final String UPDATED_TITRE_ACCORDION_6_FR = "BBBBBBBBBB";

    private static final String DEFAULT_TITRE_ACCORDION_6_EN = "AAAAAAAAAA";
    private static final String UPDATED_TITRE_ACCORDION_6_EN = "BBBBBBBBBB";

    private static final String DEFAULT_TITRE_ACCORDION_6_GER = "AAAAAAAAAA";
    private static final String UPDATED_TITRE_ACCORDION_6_GER = "BBBBBBBBBB";

    private static final String DEFAULT_TITRE_ACCORDION_6_SW = "AAAAAAAAAA";
    private static final String UPDATED_TITRE_ACCORDION_6_SW = "BBBBBBBBBB";

    private static final String DEFAULT_TITRE_ACCORDION_7_FR = "AAAAAAAAAA";
    private static final String UPDATED_TITRE_ACCORDION_7_FR = "BBBBBBBBBB";

    private static final String DEFAULT_TITRE_ACCORDION_7_EN = "AAAAAAAAAA";
    private static final String UPDATED_TITRE_ACCORDION_7_EN = "BBBBBBBBBB";

    private static final String DEFAULT_TITRE_ACCORDION_7_GER = "AAAAAAAAAA";
    private static final String UPDATED_TITRE_ACCORDION_7_GER = "BBBBBBBBBB";

    private static final String DEFAULT_TITRE_ACCORDION_7_SW = "AAAAAAAAAA";
    private static final String UPDATED_TITRE_ACCORDION_7_SW = "BBBBBBBBBB";

    private static final String DEFAULT_TITRE_ACCORDION_8_FR = "AAAAAAAAAA";
    private static final String UPDATED_TITRE_ACCORDION_8_FR = "BBBBBBBBBB";

    private static final String DEFAULT_TITRE_ACCORDION_8_EN = "AAAAAAAAAA";
    private static final String UPDATED_TITRE_ACCORDION_8_EN = "BBBBBBBBBB";

    private static final String DEFAULT_TITRE_ACCORDION_8_GER = "AAAAAAAAAA";
    private static final String UPDATED_TITRE_ACCORDION_8_GER = "BBBBBBBBBB";

    private static final String DEFAULT_TITRE_ACCORDION_8_SW = "AAAAAAAAAA";
    private static final String UPDATED_TITRE_ACCORDION_8_SW = "BBBBBBBBBB";

    private static final String DEFAULT_TITRE_ACCORDION_9_FR = "AAAAAAAAAA";
    private static final String UPDATED_TITRE_ACCORDION_9_FR = "BBBBBBBBBB";

    private static final String DEFAULT_TITRE_ACCORDION_9_EN = "AAAAAAAAAA";
    private static final String UPDATED_TITRE_ACCORDION_9_EN = "BBBBBBBBBB";

    private static final String DEFAULT_TITRE_ACCORDION_9_GER = "AAAAAAAAAA";
    private static final String UPDATED_TITRE_ACCORDION_9_GER = "BBBBBBBBBB";

    private static final String DEFAULT_TITRE_ACCORDION_9_SW = "AAAAAAAAAA";
    private static final String UPDATED_TITRE_ACCORDION_9_SW = "BBBBBBBBBB";

    private static final String DEFAULT_TITRE_ACCORDION_10_FR = "AAAAAAAAAA";
    private static final String UPDATED_TITRE_ACCORDION_10_FR = "BBBBBBBBBB";

    private static final String DEFAULT_TITRE_ACCORDION_10_EN = "AAAAAAAAAA";
    private static final String UPDATED_TITRE_ACCORDION_10_EN = "BBBBBBBBBB";

    private static final String DEFAULT_TITRE_ACCORDION_10_GER = "AAAAAAAAAA";
    private static final String UPDATED_TITRE_ACCORDION_10_GER = "BBBBBBBBBB";

    private static final String DEFAULT_TITRE_ACCORDION_10_SW = "AAAAAAAAAA";
    private static final String UPDATED_TITRE_ACCORDION_10_SW = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_ACCORDION_1_FR = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_ACCORDION_1_FR = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_ACCORDION_1_EN = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_ACCORDION_1_EN = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_ACCORDION_1_GER = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_ACCORDION_1_GER = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_ACCORDION_1_SW = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_ACCORDION_1_SW = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_ACCORDION_2_FR = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_ACCORDION_2_FR = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_ACCORDION_2_EN = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_ACCORDION_2_EN = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_ACCORDION_2_GER = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_ACCORDION_2_GER = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_ACCORDION_2_SW = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_ACCORDION_2_SW = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_ACCORDION_3_FR = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_ACCORDION_3_FR = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_ACCORDION_3_EN = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_ACCORDION_3_EN = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_ACCORDION_3_GER = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_ACCORDION_3_GER = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_ACCORDION_3_SW = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_ACCORDION_3_SW = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_ACCORDION_4_FR = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_ACCORDION_4_FR = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_ACCORDION_4_EN = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_ACCORDION_4_EN = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_ACCORDION_4_GER = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_ACCORDION_4_GER = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_ACCORDION_4_SW = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_ACCORDION_4_SW = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_ACCORDION_5_FR = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_ACCORDION_5_FR = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_ACCORDION_5_EN = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_ACCORDION_5_EN = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_ACCORDION_5_GER = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_ACCORDION_5_GER = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_ACCORDION_5_SW = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_ACCORDION_5_SW = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_ACCORDION_6_FR = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_ACCORDION_6_FR = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_ACCORDION_6_EN = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_ACCORDION_6_EN = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_ACCORDION_6_GER = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_ACCORDION_6_GER = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_ACCORDION_6_SW = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_ACCORDION_6_SW = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_ACCORDION_7_FR = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_ACCORDION_7_FR = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_ACCORDION_7_EN = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_ACCORDION_7_EN = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_ACCORDION_7_GER = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_ACCORDION_7_GER = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_ACCORDION_7_SW = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_ACCORDION_7_SW = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_ACCORDION_8_FR = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_ACCORDION_8_FR = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_ACCORDION_8_EN = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_ACCORDION_8_EN = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_ACCORDION_8_GER = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_ACCORDION_8_GER = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_ACCORDION_8_SW = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_ACCORDION_8_SW = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_ACCORDION_9_FR = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_ACCORDION_9_FR = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_ACCORDION_9_EN = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_ACCORDION_9_EN = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_ACCORDION_9_GER = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_ACCORDION_9_GER = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_ACCORDION_9_SW = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_ACCORDION_9_SW = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_ACCORDION_10_FR = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_ACCORDION_10_FR = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_ACCORDION_10_EN = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_ACCORDION_10_EN = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_ACCORDION_10_GER = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_ACCORDION_10_GER = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_ACCORDION_10_SW = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_ACCORDION_10_SW = "BBBBBBBBBB";

    @Autowired
    private FAQsRepository fAQsRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restFAQsMockMvc;

    private FAQs fAQs;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static FAQs createEntity(EntityManager em) {
        FAQs fAQs = new FAQs()
            .titreFr(DEFAULT_TITRE_FR)
            .titreEn(DEFAULT_TITRE_EN)
            .titreGer(DEFAULT_TITRE_GER)
            .titreSw(DEFAULT_TITRE_SW)
            .sousTitreFr(DEFAULT_SOUS_TITRE_FR)
            .sousTitreEn(DEFAULT_SOUS_TITRE_EN)
            .sousTitreGer(DEFAULT_SOUS_TITRE_GER)
            .sousTitreSw(DEFAULT_SOUS_TITRE_SW)
            .titreAccordion1Fr(DEFAULT_TITRE_ACCORDION_1_FR)
            .titreAccordion1En(DEFAULT_TITRE_ACCORDION_1_EN)
            .titreAccordion1Gr(DEFAULT_TITRE_ACCORDION_1_GR)
            .titreAccordion1Sw(DEFAULT_TITRE_ACCORDION_1_SW)
            .titreAccordion2Fr(DEFAULT_TITRE_ACCORDION_2_FR)
            .titreAccordion2En(DEFAULT_TITRE_ACCORDION_2_EN)
            .titreAccordion2Ger(DEFAULT_TITRE_ACCORDION_2_GER)
            .titreAccordion2Sw(DEFAULT_TITRE_ACCORDION_2_SW)
            .titreAccordion3Fr(DEFAULT_TITRE_ACCORDION_3_FR)
            .titreAccordion3En(DEFAULT_TITRE_ACCORDION_3_EN)
            .titreAccordion3Ger(DEFAULT_TITRE_ACCORDION_3_GER)
            .titreAccordion3Sw(DEFAULT_TITRE_ACCORDION_3_SW)
            .titreAccordion4Fr(DEFAULT_TITRE_ACCORDION_4_FR)
            .titreAccordion4En(DEFAULT_TITRE_ACCORDION_4_EN)
            .titreAccordion4Ger(DEFAULT_TITRE_ACCORDION_4_GER)
            .titreAccordion4Sw(DEFAULT_TITRE_ACCORDION_4_SW)
            .titreAccordion5Fr(DEFAULT_TITRE_ACCORDION_5_FR)
            .titreAccordion5En(DEFAULT_TITRE_ACCORDION_5_EN)
            .titreAccordion5Ger(DEFAULT_TITRE_ACCORDION_5_GER)
            .titreAccordion5Sw(DEFAULT_TITRE_ACCORDION_5_SW)
            .titreAccordion6Fr(DEFAULT_TITRE_ACCORDION_6_FR)
            .titreAccordion6En(DEFAULT_TITRE_ACCORDION_6_EN)
            .titreAccordion6Ger(DEFAULT_TITRE_ACCORDION_6_GER)
            .titreAccordion6Sw(DEFAULT_TITRE_ACCORDION_6_SW)
            .titreAccordion7Fr(DEFAULT_TITRE_ACCORDION_7_FR)
            .titreAccordion7En(DEFAULT_TITRE_ACCORDION_7_EN)
            .titreAccordion7Ger(DEFAULT_TITRE_ACCORDION_7_GER)
            .titreAccordion7Sw(DEFAULT_TITRE_ACCORDION_7_SW)
            .titreAccordion8Fr(DEFAULT_TITRE_ACCORDION_8_FR)
            .titreAccordion8En(DEFAULT_TITRE_ACCORDION_8_EN)
            .titreAccordion8Ger(DEFAULT_TITRE_ACCORDION_8_GER)
            .titreAccordion8Sw(DEFAULT_TITRE_ACCORDION_8_SW)
            .titreAccordion9Fr(DEFAULT_TITRE_ACCORDION_9_FR)
            .titreAccordion9En(DEFAULT_TITRE_ACCORDION_9_EN)
            .titreAccordion9Ger(DEFAULT_TITRE_ACCORDION_9_GER)
            .titreAccordion9Sw(DEFAULT_TITRE_ACCORDION_9_SW)
            .titreAccordion10Fr(DEFAULT_TITRE_ACCORDION_10_FR)
            .titreAccordion10En(DEFAULT_TITRE_ACCORDION_10_EN)
            .titreAccordion10Ger(DEFAULT_TITRE_ACCORDION_10_GER)
            .titreAccordion10Sw(DEFAULT_TITRE_ACCORDION_10_SW)
            .textAccordion1Fr(DEFAULT_TEXT_ACCORDION_1_FR)
            .textAccordion1En(DEFAULT_TEXT_ACCORDION_1_EN)
            .textAccordion1Ger(DEFAULT_TEXT_ACCORDION_1_GER)
            .textAccordion1Sw(DEFAULT_TEXT_ACCORDION_1_SW)
            .textAccordion2Fr(DEFAULT_TEXT_ACCORDION_2_FR)
            .textAccordion2En(DEFAULT_TEXT_ACCORDION_2_EN)
            .textAccordion2Ger(DEFAULT_TEXT_ACCORDION_2_GER)
            .textAccordion2Sw(DEFAULT_TEXT_ACCORDION_2_SW)
            .textAccordion3Fr(DEFAULT_TEXT_ACCORDION_3_FR)
            .textAccordion3En(DEFAULT_TEXT_ACCORDION_3_EN)
            .textAccordion3Ger(DEFAULT_TEXT_ACCORDION_3_GER)
            .textAccordion3Sw(DEFAULT_TEXT_ACCORDION_3_SW)
            .textAccordion4Fr(DEFAULT_TEXT_ACCORDION_4_FR)
            .textAccordion4En(DEFAULT_TEXT_ACCORDION_4_EN)
            .textAccordion4Ger(DEFAULT_TEXT_ACCORDION_4_GER)
            .textAccordion4Sw(DEFAULT_TEXT_ACCORDION_4_SW)
            .textAccordion5Fr(DEFAULT_TEXT_ACCORDION_5_FR)
            .textAccordion5En(DEFAULT_TEXT_ACCORDION_5_EN)
            .textAccordion5Ger(DEFAULT_TEXT_ACCORDION_5_GER)
            .textAccordion5Sw(DEFAULT_TEXT_ACCORDION_5_SW)
            .textAccordion6Fr(DEFAULT_TEXT_ACCORDION_6_FR)
            .textAccordion6En(DEFAULT_TEXT_ACCORDION_6_EN)
            .textAccordion6Ger(DEFAULT_TEXT_ACCORDION_6_GER)
            .textAccordion6Sw(DEFAULT_TEXT_ACCORDION_6_SW)
            .textAccordion7Fr(DEFAULT_TEXT_ACCORDION_7_FR)
            .textAccordion7En(DEFAULT_TEXT_ACCORDION_7_EN)
            .textAccordion7Ger(DEFAULT_TEXT_ACCORDION_7_GER)
            .textAccordion7Sw(DEFAULT_TEXT_ACCORDION_7_SW)
            .textAccordion8Fr(DEFAULT_TEXT_ACCORDION_8_FR)
            .textAccordion8En(DEFAULT_TEXT_ACCORDION_8_EN)
            .textAccordion8Ger(DEFAULT_TEXT_ACCORDION_8_GER)
            .textAccordion8Sw(DEFAULT_TEXT_ACCORDION_8_SW)
            .textAccordion9Fr(DEFAULT_TEXT_ACCORDION_9_FR)
            .textAccordion9En(DEFAULT_TEXT_ACCORDION_9_EN)
            .textAccordion9Ger(DEFAULT_TEXT_ACCORDION_9_GER)
            .textAccordion9Sw(DEFAULT_TEXT_ACCORDION_9_SW)
            .textAccordion10Fr(DEFAULT_TEXT_ACCORDION_10_FR)
            .textAccordion10En(DEFAULT_TEXT_ACCORDION_10_EN)
            .textAccordion10Ger(DEFAULT_TEXT_ACCORDION_10_GER)
            .textAccordion10Sw(DEFAULT_TEXT_ACCORDION_10_SW);
        return fAQs;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static FAQs createUpdatedEntity(EntityManager em) {
        FAQs fAQs = new FAQs()
            .titreFr(UPDATED_TITRE_FR)
            .titreEn(UPDATED_TITRE_EN)
            .titreGer(UPDATED_TITRE_GER)
            .titreSw(UPDATED_TITRE_SW)
            .sousTitreFr(UPDATED_SOUS_TITRE_FR)
            .sousTitreEn(UPDATED_SOUS_TITRE_EN)
            .sousTitreGer(UPDATED_SOUS_TITRE_GER)
            .sousTitreSw(UPDATED_SOUS_TITRE_SW)
            .titreAccordion1Fr(UPDATED_TITRE_ACCORDION_1_FR)
            .titreAccordion1En(UPDATED_TITRE_ACCORDION_1_EN)
            .titreAccordion1Gr(UPDATED_TITRE_ACCORDION_1_GR)
            .titreAccordion1Sw(UPDATED_TITRE_ACCORDION_1_SW)
            .titreAccordion2Fr(UPDATED_TITRE_ACCORDION_2_FR)
            .titreAccordion2En(UPDATED_TITRE_ACCORDION_2_EN)
            .titreAccordion2Ger(UPDATED_TITRE_ACCORDION_2_GER)
            .titreAccordion2Sw(UPDATED_TITRE_ACCORDION_2_SW)
            .titreAccordion3Fr(UPDATED_TITRE_ACCORDION_3_FR)
            .titreAccordion3En(UPDATED_TITRE_ACCORDION_3_EN)
            .titreAccordion3Ger(UPDATED_TITRE_ACCORDION_3_GER)
            .titreAccordion3Sw(UPDATED_TITRE_ACCORDION_3_SW)
            .titreAccordion4Fr(UPDATED_TITRE_ACCORDION_4_FR)
            .titreAccordion4En(UPDATED_TITRE_ACCORDION_4_EN)
            .titreAccordion4Ger(UPDATED_TITRE_ACCORDION_4_GER)
            .titreAccordion4Sw(UPDATED_TITRE_ACCORDION_4_SW)
            .titreAccordion5Fr(UPDATED_TITRE_ACCORDION_5_FR)
            .titreAccordion5En(UPDATED_TITRE_ACCORDION_5_EN)
            .titreAccordion5Ger(UPDATED_TITRE_ACCORDION_5_GER)
            .titreAccordion5Sw(UPDATED_TITRE_ACCORDION_5_SW)
            .titreAccordion6Fr(UPDATED_TITRE_ACCORDION_6_FR)
            .titreAccordion6En(UPDATED_TITRE_ACCORDION_6_EN)
            .titreAccordion6Ger(UPDATED_TITRE_ACCORDION_6_GER)
            .titreAccordion6Sw(UPDATED_TITRE_ACCORDION_6_SW)
            .titreAccordion7Fr(UPDATED_TITRE_ACCORDION_7_FR)
            .titreAccordion7En(UPDATED_TITRE_ACCORDION_7_EN)
            .titreAccordion7Ger(UPDATED_TITRE_ACCORDION_7_GER)
            .titreAccordion7Sw(UPDATED_TITRE_ACCORDION_7_SW)
            .titreAccordion8Fr(UPDATED_TITRE_ACCORDION_8_FR)
            .titreAccordion8En(UPDATED_TITRE_ACCORDION_8_EN)
            .titreAccordion8Ger(UPDATED_TITRE_ACCORDION_8_GER)
            .titreAccordion8Sw(UPDATED_TITRE_ACCORDION_8_SW)
            .titreAccordion9Fr(UPDATED_TITRE_ACCORDION_9_FR)
            .titreAccordion9En(UPDATED_TITRE_ACCORDION_9_EN)
            .titreAccordion9Ger(UPDATED_TITRE_ACCORDION_9_GER)
            .titreAccordion9Sw(UPDATED_TITRE_ACCORDION_9_SW)
            .titreAccordion10Fr(UPDATED_TITRE_ACCORDION_10_FR)
            .titreAccordion10En(UPDATED_TITRE_ACCORDION_10_EN)
            .titreAccordion10Ger(UPDATED_TITRE_ACCORDION_10_GER)
            .titreAccordion10Sw(UPDATED_TITRE_ACCORDION_10_SW)
            .textAccordion1Fr(UPDATED_TEXT_ACCORDION_1_FR)
            .textAccordion1En(UPDATED_TEXT_ACCORDION_1_EN)
            .textAccordion1Ger(UPDATED_TEXT_ACCORDION_1_GER)
            .textAccordion1Sw(UPDATED_TEXT_ACCORDION_1_SW)
            .textAccordion2Fr(UPDATED_TEXT_ACCORDION_2_FR)
            .textAccordion2En(UPDATED_TEXT_ACCORDION_2_EN)
            .textAccordion2Ger(UPDATED_TEXT_ACCORDION_2_GER)
            .textAccordion2Sw(UPDATED_TEXT_ACCORDION_2_SW)
            .textAccordion3Fr(UPDATED_TEXT_ACCORDION_3_FR)
            .textAccordion3En(UPDATED_TEXT_ACCORDION_3_EN)
            .textAccordion3Ger(UPDATED_TEXT_ACCORDION_3_GER)
            .textAccordion3Sw(UPDATED_TEXT_ACCORDION_3_SW)
            .textAccordion4Fr(UPDATED_TEXT_ACCORDION_4_FR)
            .textAccordion4En(UPDATED_TEXT_ACCORDION_4_EN)
            .textAccordion4Ger(UPDATED_TEXT_ACCORDION_4_GER)
            .textAccordion4Sw(UPDATED_TEXT_ACCORDION_4_SW)
            .textAccordion5Fr(UPDATED_TEXT_ACCORDION_5_FR)
            .textAccordion5En(UPDATED_TEXT_ACCORDION_5_EN)
            .textAccordion5Ger(UPDATED_TEXT_ACCORDION_5_GER)
            .textAccordion5Sw(UPDATED_TEXT_ACCORDION_5_SW)
            .textAccordion6Fr(UPDATED_TEXT_ACCORDION_6_FR)
            .textAccordion6En(UPDATED_TEXT_ACCORDION_6_EN)
            .textAccordion6Ger(UPDATED_TEXT_ACCORDION_6_GER)
            .textAccordion6Sw(UPDATED_TEXT_ACCORDION_6_SW)
            .textAccordion7Fr(UPDATED_TEXT_ACCORDION_7_FR)
            .textAccordion7En(UPDATED_TEXT_ACCORDION_7_EN)
            .textAccordion7Ger(UPDATED_TEXT_ACCORDION_7_GER)
            .textAccordion7Sw(UPDATED_TEXT_ACCORDION_7_SW)
            .textAccordion8Fr(UPDATED_TEXT_ACCORDION_8_FR)
            .textAccordion8En(UPDATED_TEXT_ACCORDION_8_EN)
            .textAccordion8Ger(UPDATED_TEXT_ACCORDION_8_GER)
            .textAccordion8Sw(UPDATED_TEXT_ACCORDION_8_SW)
            .textAccordion9Fr(UPDATED_TEXT_ACCORDION_9_FR)
            .textAccordion9En(UPDATED_TEXT_ACCORDION_9_EN)
            .textAccordion9Ger(UPDATED_TEXT_ACCORDION_9_GER)
            .textAccordion9Sw(UPDATED_TEXT_ACCORDION_9_SW)
            .textAccordion10Fr(UPDATED_TEXT_ACCORDION_10_FR)
            .textAccordion10En(UPDATED_TEXT_ACCORDION_10_EN)
            .textAccordion10Ger(UPDATED_TEXT_ACCORDION_10_GER)
            .textAccordion10Sw(UPDATED_TEXT_ACCORDION_10_SW);
        return fAQs;
    }

    @BeforeEach
    public void initTest() {
        fAQs = createEntity(em);
    }

    @Test
    @Transactional
    public void createFAQs() throws Exception {
        int databaseSizeBeforeCreate = fAQsRepository.findAll().size();

        // Create the FAQs
        restFAQsMockMvc.perform(post("/api/fa-qs")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(fAQs)))
            .andExpect(status().isCreated());

        // Validate the FAQs in the database
        List<FAQs> fAQsList = fAQsRepository.findAll();
        assertThat(fAQsList).hasSize(databaseSizeBeforeCreate + 1);
        FAQs testFAQs = fAQsList.get(fAQsList.size() - 1);
        assertThat(testFAQs.getTitreFr()).isEqualTo(DEFAULT_TITRE_FR);
        assertThat(testFAQs.getTitreEn()).isEqualTo(DEFAULT_TITRE_EN);
        assertThat(testFAQs.getTitreGer()).isEqualTo(DEFAULT_TITRE_GER);
        assertThat(testFAQs.getTitreSw()).isEqualTo(DEFAULT_TITRE_SW);
        assertThat(testFAQs.getSousTitreFr()).isEqualTo(DEFAULT_SOUS_TITRE_FR);
        assertThat(testFAQs.getSousTitreEn()).isEqualTo(DEFAULT_SOUS_TITRE_EN);
        assertThat(testFAQs.getSousTitreGer()).isEqualTo(DEFAULT_SOUS_TITRE_GER);
        assertThat(testFAQs.getSousTitreSw()).isEqualTo(DEFAULT_SOUS_TITRE_SW);
        assertThat(testFAQs.getTitreAccordion1Fr()).isEqualTo(DEFAULT_TITRE_ACCORDION_1_FR);
        assertThat(testFAQs.getTitreAccordion1En()).isEqualTo(DEFAULT_TITRE_ACCORDION_1_EN);
        assertThat(testFAQs.getTitreAccordion1Gr()).isEqualTo(DEFAULT_TITRE_ACCORDION_1_GR);
        assertThat(testFAQs.getTitreAccordion1Sw()).isEqualTo(DEFAULT_TITRE_ACCORDION_1_SW);
        assertThat(testFAQs.getTitreAccordion2Fr()).isEqualTo(DEFAULT_TITRE_ACCORDION_2_FR);
        assertThat(testFAQs.getTitreAccordion2En()).isEqualTo(DEFAULT_TITRE_ACCORDION_2_EN);
        assertThat(testFAQs.getTitreAccordion2Ger()).isEqualTo(DEFAULT_TITRE_ACCORDION_2_GER);
        assertThat(testFAQs.getTitreAccordion2Sw()).isEqualTo(DEFAULT_TITRE_ACCORDION_2_SW);
        assertThat(testFAQs.getTitreAccordion3Fr()).isEqualTo(DEFAULT_TITRE_ACCORDION_3_FR);
        assertThat(testFAQs.getTitreAccordion3En()).isEqualTo(DEFAULT_TITRE_ACCORDION_3_EN);
        assertThat(testFAQs.getTitreAccordion3Ger()).isEqualTo(DEFAULT_TITRE_ACCORDION_3_GER);
        assertThat(testFAQs.getTitreAccordion3Sw()).isEqualTo(DEFAULT_TITRE_ACCORDION_3_SW);
        assertThat(testFAQs.getTitreAccordion4Fr()).isEqualTo(DEFAULT_TITRE_ACCORDION_4_FR);
        assertThat(testFAQs.getTitreAccordion4En()).isEqualTo(DEFAULT_TITRE_ACCORDION_4_EN);
        assertThat(testFAQs.getTitreAccordion4Ger()).isEqualTo(DEFAULT_TITRE_ACCORDION_4_GER);
        assertThat(testFAQs.getTitreAccordion4Sw()).isEqualTo(DEFAULT_TITRE_ACCORDION_4_SW);
        assertThat(testFAQs.getTitreAccordion5Fr()).isEqualTo(DEFAULT_TITRE_ACCORDION_5_FR);
        assertThat(testFAQs.getTitreAccordion5En()).isEqualTo(DEFAULT_TITRE_ACCORDION_5_EN);
        assertThat(testFAQs.getTitreAccordion5Ger()).isEqualTo(DEFAULT_TITRE_ACCORDION_5_GER);
        assertThat(testFAQs.getTitreAccordion5Sw()).isEqualTo(DEFAULT_TITRE_ACCORDION_5_SW);
        assertThat(testFAQs.getTitreAccordion6Fr()).isEqualTo(DEFAULT_TITRE_ACCORDION_6_FR);
        assertThat(testFAQs.getTitreAccordion6En()).isEqualTo(DEFAULT_TITRE_ACCORDION_6_EN);
        assertThat(testFAQs.getTitreAccordion6Ger()).isEqualTo(DEFAULT_TITRE_ACCORDION_6_GER);
        assertThat(testFAQs.getTitreAccordion6Sw()).isEqualTo(DEFAULT_TITRE_ACCORDION_6_SW);
        assertThat(testFAQs.getTitreAccordion7Fr()).isEqualTo(DEFAULT_TITRE_ACCORDION_7_FR);
        assertThat(testFAQs.getTitreAccordion7En()).isEqualTo(DEFAULT_TITRE_ACCORDION_7_EN);
        assertThat(testFAQs.getTitreAccordion7Ger()).isEqualTo(DEFAULT_TITRE_ACCORDION_7_GER);
        assertThat(testFAQs.getTitreAccordion7Sw()).isEqualTo(DEFAULT_TITRE_ACCORDION_7_SW);
        assertThat(testFAQs.getTitreAccordion8Fr()).isEqualTo(DEFAULT_TITRE_ACCORDION_8_FR);
        assertThat(testFAQs.getTitreAccordion8En()).isEqualTo(DEFAULT_TITRE_ACCORDION_8_EN);
        assertThat(testFAQs.getTitreAccordion8Ger()).isEqualTo(DEFAULT_TITRE_ACCORDION_8_GER);
        assertThat(testFAQs.getTitreAccordion8Sw()).isEqualTo(DEFAULT_TITRE_ACCORDION_8_SW);
        assertThat(testFAQs.getTitreAccordion9Fr()).isEqualTo(DEFAULT_TITRE_ACCORDION_9_FR);
        assertThat(testFAQs.getTitreAccordion9En()).isEqualTo(DEFAULT_TITRE_ACCORDION_9_EN);
        assertThat(testFAQs.getTitreAccordion9Ger()).isEqualTo(DEFAULT_TITRE_ACCORDION_9_GER);
        assertThat(testFAQs.getTitreAccordion9Sw()).isEqualTo(DEFAULT_TITRE_ACCORDION_9_SW);
        assertThat(testFAQs.getTitreAccordion10Fr()).isEqualTo(DEFAULT_TITRE_ACCORDION_10_FR);
        assertThat(testFAQs.getTitreAccordion10En()).isEqualTo(DEFAULT_TITRE_ACCORDION_10_EN);
        assertThat(testFAQs.getTitreAccordion10Ger()).isEqualTo(DEFAULT_TITRE_ACCORDION_10_GER);
        assertThat(testFAQs.getTitreAccordion10Sw()).isEqualTo(DEFAULT_TITRE_ACCORDION_10_SW);
        assertThat(testFAQs.getTextAccordion1Fr()).isEqualTo(DEFAULT_TEXT_ACCORDION_1_FR);
        assertThat(testFAQs.getTextAccordion1En()).isEqualTo(DEFAULT_TEXT_ACCORDION_1_EN);
        assertThat(testFAQs.getTextAccordion1Ger()).isEqualTo(DEFAULT_TEXT_ACCORDION_1_GER);
        assertThat(testFAQs.getTextAccordion1Sw()).isEqualTo(DEFAULT_TEXT_ACCORDION_1_SW);
        assertThat(testFAQs.getTextAccordion2Fr()).isEqualTo(DEFAULT_TEXT_ACCORDION_2_FR);
        assertThat(testFAQs.getTextAccordion2En()).isEqualTo(DEFAULT_TEXT_ACCORDION_2_EN);
        assertThat(testFAQs.getTextAccordion2Ger()).isEqualTo(DEFAULT_TEXT_ACCORDION_2_GER);
        assertThat(testFAQs.getTextAccordion2Sw()).isEqualTo(DEFAULT_TEXT_ACCORDION_2_SW);
        assertThat(testFAQs.getTextAccordion3Fr()).isEqualTo(DEFAULT_TEXT_ACCORDION_3_FR);
        assertThat(testFAQs.getTextAccordion3En()).isEqualTo(DEFAULT_TEXT_ACCORDION_3_EN);
        assertThat(testFAQs.getTextAccordion3Ger()).isEqualTo(DEFAULT_TEXT_ACCORDION_3_GER);
        assertThat(testFAQs.getTextAccordion3Sw()).isEqualTo(DEFAULT_TEXT_ACCORDION_3_SW);
        assertThat(testFAQs.getTextAccordion4Fr()).isEqualTo(DEFAULT_TEXT_ACCORDION_4_FR);
        assertThat(testFAQs.getTextAccordion4En()).isEqualTo(DEFAULT_TEXT_ACCORDION_4_EN);
        assertThat(testFAQs.getTextAccordion4Ger()).isEqualTo(DEFAULT_TEXT_ACCORDION_4_GER);
        assertThat(testFAQs.getTextAccordion4Sw()).isEqualTo(DEFAULT_TEXT_ACCORDION_4_SW);
        assertThat(testFAQs.getTextAccordion5Fr()).isEqualTo(DEFAULT_TEXT_ACCORDION_5_FR);
        assertThat(testFAQs.getTextAccordion5En()).isEqualTo(DEFAULT_TEXT_ACCORDION_5_EN);
        assertThat(testFAQs.getTextAccordion5Ger()).isEqualTo(DEFAULT_TEXT_ACCORDION_5_GER);
        assertThat(testFAQs.getTextAccordion5Sw()).isEqualTo(DEFAULT_TEXT_ACCORDION_5_SW);
        assertThat(testFAQs.getTextAccordion6Fr()).isEqualTo(DEFAULT_TEXT_ACCORDION_6_FR);
        assertThat(testFAQs.getTextAccordion6En()).isEqualTo(DEFAULT_TEXT_ACCORDION_6_EN);
        assertThat(testFAQs.getTextAccordion6Ger()).isEqualTo(DEFAULT_TEXT_ACCORDION_6_GER);
        assertThat(testFAQs.getTextAccordion6Sw()).isEqualTo(DEFAULT_TEXT_ACCORDION_6_SW);
        assertThat(testFAQs.getTextAccordion7Fr()).isEqualTo(DEFAULT_TEXT_ACCORDION_7_FR);
        assertThat(testFAQs.getTextAccordion7En()).isEqualTo(DEFAULT_TEXT_ACCORDION_7_EN);
        assertThat(testFAQs.getTextAccordion7Ger()).isEqualTo(DEFAULT_TEXT_ACCORDION_7_GER);
        assertThat(testFAQs.getTextAccordion7Sw()).isEqualTo(DEFAULT_TEXT_ACCORDION_7_SW);
        assertThat(testFAQs.getTextAccordion8Fr()).isEqualTo(DEFAULT_TEXT_ACCORDION_8_FR);
        assertThat(testFAQs.getTextAccordion8En()).isEqualTo(DEFAULT_TEXT_ACCORDION_8_EN);
        assertThat(testFAQs.getTextAccordion8Ger()).isEqualTo(DEFAULT_TEXT_ACCORDION_8_GER);
        assertThat(testFAQs.getTextAccordion8Sw()).isEqualTo(DEFAULT_TEXT_ACCORDION_8_SW);
        assertThat(testFAQs.getTextAccordion9Fr()).isEqualTo(DEFAULT_TEXT_ACCORDION_9_FR);
        assertThat(testFAQs.getTextAccordion9En()).isEqualTo(DEFAULT_TEXT_ACCORDION_9_EN);
        assertThat(testFAQs.getTextAccordion9Ger()).isEqualTo(DEFAULT_TEXT_ACCORDION_9_GER);
        assertThat(testFAQs.getTextAccordion9Sw()).isEqualTo(DEFAULT_TEXT_ACCORDION_9_SW);
        assertThat(testFAQs.getTextAccordion10Fr()).isEqualTo(DEFAULT_TEXT_ACCORDION_10_FR);
        assertThat(testFAQs.getTextAccordion10En()).isEqualTo(DEFAULT_TEXT_ACCORDION_10_EN);
        assertThat(testFAQs.getTextAccordion10Ger()).isEqualTo(DEFAULT_TEXT_ACCORDION_10_GER);
        assertThat(testFAQs.getTextAccordion10Sw()).isEqualTo(DEFAULT_TEXT_ACCORDION_10_SW);
    }

    @Test
    @Transactional
    public void createFAQsWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = fAQsRepository.findAll().size();

        // Create the FAQs with an existing ID
        fAQs.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restFAQsMockMvc.perform(post("/api/fa-qs")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(fAQs)))
            .andExpect(status().isBadRequest());

        // Validate the FAQs in the database
        List<FAQs> fAQsList = fAQsRepository.findAll();
        assertThat(fAQsList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllFAQs() throws Exception {
        // Initialize the database
        fAQsRepository.saveAndFlush(fAQs);

        // Get all the fAQsList
        restFAQsMockMvc.perform(get("/api/fa-qs?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(fAQs.getId().intValue())))
            .andExpect(jsonPath("$.[*].titreFr").value(hasItem(DEFAULT_TITRE_FR)))
            .andExpect(jsonPath("$.[*].titreEn").value(hasItem(DEFAULT_TITRE_EN)))
            .andExpect(jsonPath("$.[*].titreGer").value(hasItem(DEFAULT_TITRE_GER)))
            .andExpect(jsonPath("$.[*].titreSw").value(hasItem(DEFAULT_TITRE_SW)))
            .andExpect(jsonPath("$.[*].sousTitreFr").value(hasItem(DEFAULT_SOUS_TITRE_FR)))
            .andExpect(jsonPath("$.[*].sousTitreEn").value(hasItem(DEFAULT_SOUS_TITRE_EN)))
            .andExpect(jsonPath("$.[*].sousTitreGer").value(hasItem(DEFAULT_SOUS_TITRE_GER)))
            .andExpect(jsonPath("$.[*].sousTitreSw").value(hasItem(DEFAULT_SOUS_TITRE_SW)))
            .andExpect(jsonPath("$.[*].titreAccordion1Fr").value(hasItem(DEFAULT_TITRE_ACCORDION_1_FR)))
            .andExpect(jsonPath("$.[*].titreAccordion1En").value(hasItem(DEFAULT_TITRE_ACCORDION_1_EN)))
            .andExpect(jsonPath("$.[*].titreAccordion1Gr").value(hasItem(DEFAULT_TITRE_ACCORDION_1_GR)))
            .andExpect(jsonPath("$.[*].titreAccordion1Sw").value(hasItem(DEFAULT_TITRE_ACCORDION_1_SW)))
            .andExpect(jsonPath("$.[*].titreAccordion2Fr").value(hasItem(DEFAULT_TITRE_ACCORDION_2_FR)))
            .andExpect(jsonPath("$.[*].titreAccordion2En").value(hasItem(DEFAULT_TITRE_ACCORDION_2_EN)))
            .andExpect(jsonPath("$.[*].titreAccordion2Ger").value(hasItem(DEFAULT_TITRE_ACCORDION_2_GER)))
            .andExpect(jsonPath("$.[*].titreAccordion2Sw").value(hasItem(DEFAULT_TITRE_ACCORDION_2_SW)))
            .andExpect(jsonPath("$.[*].titreAccordion3Fr").value(hasItem(DEFAULT_TITRE_ACCORDION_3_FR)))
            .andExpect(jsonPath("$.[*].titreAccordion3En").value(hasItem(DEFAULT_TITRE_ACCORDION_3_EN)))
            .andExpect(jsonPath("$.[*].titreAccordion3Ger").value(hasItem(DEFAULT_TITRE_ACCORDION_3_GER)))
            .andExpect(jsonPath("$.[*].titreAccordion3Sw").value(hasItem(DEFAULT_TITRE_ACCORDION_3_SW)))
            .andExpect(jsonPath("$.[*].titreAccordion4Fr").value(hasItem(DEFAULT_TITRE_ACCORDION_4_FR)))
            .andExpect(jsonPath("$.[*].titreAccordion4En").value(hasItem(DEFAULT_TITRE_ACCORDION_4_EN)))
            .andExpect(jsonPath("$.[*].titreAccordion4Ger").value(hasItem(DEFAULT_TITRE_ACCORDION_4_GER)))
            .andExpect(jsonPath("$.[*].titreAccordion4Sw").value(hasItem(DEFAULT_TITRE_ACCORDION_4_SW)))
            .andExpect(jsonPath("$.[*].titreAccordion5Fr").value(hasItem(DEFAULT_TITRE_ACCORDION_5_FR)))
            .andExpect(jsonPath("$.[*].titreAccordion5En").value(hasItem(DEFAULT_TITRE_ACCORDION_5_EN)))
            .andExpect(jsonPath("$.[*].titreAccordion5Ger").value(hasItem(DEFAULT_TITRE_ACCORDION_5_GER)))
            .andExpect(jsonPath("$.[*].titreAccordion5Sw").value(hasItem(DEFAULT_TITRE_ACCORDION_5_SW)))
            .andExpect(jsonPath("$.[*].titreAccordion6Fr").value(hasItem(DEFAULT_TITRE_ACCORDION_6_FR)))
            .andExpect(jsonPath("$.[*].titreAccordion6En").value(hasItem(DEFAULT_TITRE_ACCORDION_6_EN)))
            .andExpect(jsonPath("$.[*].titreAccordion6Ger").value(hasItem(DEFAULT_TITRE_ACCORDION_6_GER)))
            .andExpect(jsonPath("$.[*].titreAccordion6Sw").value(hasItem(DEFAULT_TITRE_ACCORDION_6_SW)))
            .andExpect(jsonPath("$.[*].titreAccordion7Fr").value(hasItem(DEFAULT_TITRE_ACCORDION_7_FR)))
            .andExpect(jsonPath("$.[*].titreAccordion7En").value(hasItem(DEFAULT_TITRE_ACCORDION_7_EN)))
            .andExpect(jsonPath("$.[*].titreAccordion7Ger").value(hasItem(DEFAULT_TITRE_ACCORDION_7_GER)))
            .andExpect(jsonPath("$.[*].titreAccordion7Sw").value(hasItem(DEFAULT_TITRE_ACCORDION_7_SW)))
            .andExpect(jsonPath("$.[*].titreAccordion8Fr").value(hasItem(DEFAULT_TITRE_ACCORDION_8_FR)))
            .andExpect(jsonPath("$.[*].titreAccordion8En").value(hasItem(DEFAULT_TITRE_ACCORDION_8_EN)))
            .andExpect(jsonPath("$.[*].titreAccordion8Ger").value(hasItem(DEFAULT_TITRE_ACCORDION_8_GER)))
            .andExpect(jsonPath("$.[*].titreAccordion8Sw").value(hasItem(DEFAULT_TITRE_ACCORDION_8_SW)))
            .andExpect(jsonPath("$.[*].titreAccordion9Fr").value(hasItem(DEFAULT_TITRE_ACCORDION_9_FR)))
            .andExpect(jsonPath("$.[*].titreAccordion9En").value(hasItem(DEFAULT_TITRE_ACCORDION_9_EN)))
            .andExpect(jsonPath("$.[*].titreAccordion9Ger").value(hasItem(DEFAULT_TITRE_ACCORDION_9_GER)))
            .andExpect(jsonPath("$.[*].titreAccordion9Sw").value(hasItem(DEFAULT_TITRE_ACCORDION_9_SW)))
            .andExpect(jsonPath("$.[*].titreAccordion10Fr").value(hasItem(DEFAULT_TITRE_ACCORDION_10_FR)))
            .andExpect(jsonPath("$.[*].titreAccordion10En").value(hasItem(DEFAULT_TITRE_ACCORDION_10_EN)))
            .andExpect(jsonPath("$.[*].titreAccordion10Ger").value(hasItem(DEFAULT_TITRE_ACCORDION_10_GER)))
            .andExpect(jsonPath("$.[*].titreAccordion10Sw").value(hasItem(DEFAULT_TITRE_ACCORDION_10_SW)))
            .andExpect(jsonPath("$.[*].textAccordion1Fr").value(hasItem(DEFAULT_TEXT_ACCORDION_1_FR)))
            .andExpect(jsonPath("$.[*].textAccordion1En").value(hasItem(DEFAULT_TEXT_ACCORDION_1_EN)))
            .andExpect(jsonPath("$.[*].textAccordion1Ger").value(hasItem(DEFAULT_TEXT_ACCORDION_1_GER)))
            .andExpect(jsonPath("$.[*].textAccordion1Sw").value(hasItem(DEFAULT_TEXT_ACCORDION_1_SW)))
            .andExpect(jsonPath("$.[*].textAccordion2Fr").value(hasItem(DEFAULT_TEXT_ACCORDION_2_FR)))
            .andExpect(jsonPath("$.[*].textAccordion2En").value(hasItem(DEFAULT_TEXT_ACCORDION_2_EN)))
            .andExpect(jsonPath("$.[*].textAccordion2Ger").value(hasItem(DEFAULT_TEXT_ACCORDION_2_GER)))
            .andExpect(jsonPath("$.[*].textAccordion2Sw").value(hasItem(DEFAULT_TEXT_ACCORDION_2_SW)))
            .andExpect(jsonPath("$.[*].textAccordion3Fr").value(hasItem(DEFAULT_TEXT_ACCORDION_3_FR)))
            .andExpect(jsonPath("$.[*].textAccordion3En").value(hasItem(DEFAULT_TEXT_ACCORDION_3_EN)))
            .andExpect(jsonPath("$.[*].textAccordion3Ger").value(hasItem(DEFAULT_TEXT_ACCORDION_3_GER)))
            .andExpect(jsonPath("$.[*].textAccordion3Sw").value(hasItem(DEFAULT_TEXT_ACCORDION_3_SW)))
            .andExpect(jsonPath("$.[*].textAccordion4Fr").value(hasItem(DEFAULT_TEXT_ACCORDION_4_FR)))
            .andExpect(jsonPath("$.[*].textAccordion4En").value(hasItem(DEFAULT_TEXT_ACCORDION_4_EN)))
            .andExpect(jsonPath("$.[*].textAccordion4Ger").value(hasItem(DEFAULT_TEXT_ACCORDION_4_GER)))
            .andExpect(jsonPath("$.[*].textAccordion4Sw").value(hasItem(DEFAULT_TEXT_ACCORDION_4_SW)))
            .andExpect(jsonPath("$.[*].textAccordion5Fr").value(hasItem(DEFAULT_TEXT_ACCORDION_5_FR)))
            .andExpect(jsonPath("$.[*].textAccordion5En").value(hasItem(DEFAULT_TEXT_ACCORDION_5_EN)))
            .andExpect(jsonPath("$.[*].textAccordion5Ger").value(hasItem(DEFAULT_TEXT_ACCORDION_5_GER)))
            .andExpect(jsonPath("$.[*].textAccordion5Sw").value(hasItem(DEFAULT_TEXT_ACCORDION_5_SW)))
            .andExpect(jsonPath("$.[*].textAccordion6Fr").value(hasItem(DEFAULT_TEXT_ACCORDION_6_FR)))
            .andExpect(jsonPath("$.[*].textAccordion6En").value(hasItem(DEFAULT_TEXT_ACCORDION_6_EN)))
            .andExpect(jsonPath("$.[*].textAccordion6Ger").value(hasItem(DEFAULT_TEXT_ACCORDION_6_GER)))
            .andExpect(jsonPath("$.[*].textAccordion6Sw").value(hasItem(DEFAULT_TEXT_ACCORDION_6_SW)))
            .andExpect(jsonPath("$.[*].textAccordion7Fr").value(hasItem(DEFAULT_TEXT_ACCORDION_7_FR)))
            .andExpect(jsonPath("$.[*].textAccordion7En").value(hasItem(DEFAULT_TEXT_ACCORDION_7_EN)))
            .andExpect(jsonPath("$.[*].textAccordion7Ger").value(hasItem(DEFAULT_TEXT_ACCORDION_7_GER)))
            .andExpect(jsonPath("$.[*].textAccordion7Sw").value(hasItem(DEFAULT_TEXT_ACCORDION_7_SW)))
            .andExpect(jsonPath("$.[*].textAccordion8Fr").value(hasItem(DEFAULT_TEXT_ACCORDION_8_FR)))
            .andExpect(jsonPath("$.[*].textAccordion8En").value(hasItem(DEFAULT_TEXT_ACCORDION_8_EN)))
            .andExpect(jsonPath("$.[*].textAccordion8Ger").value(hasItem(DEFAULT_TEXT_ACCORDION_8_GER)))
            .andExpect(jsonPath("$.[*].textAccordion8Sw").value(hasItem(DEFAULT_TEXT_ACCORDION_8_SW)))
            .andExpect(jsonPath("$.[*].textAccordion9Fr").value(hasItem(DEFAULT_TEXT_ACCORDION_9_FR)))
            .andExpect(jsonPath("$.[*].textAccordion9En").value(hasItem(DEFAULT_TEXT_ACCORDION_9_EN)))
            .andExpect(jsonPath("$.[*].textAccordion9Ger").value(hasItem(DEFAULT_TEXT_ACCORDION_9_GER)))
            .andExpect(jsonPath("$.[*].textAccordion9Sw").value(hasItem(DEFAULT_TEXT_ACCORDION_9_SW)))
            .andExpect(jsonPath("$.[*].textAccordion10Fr").value(hasItem(DEFAULT_TEXT_ACCORDION_10_FR)))
            .andExpect(jsonPath("$.[*].textAccordion10En").value(hasItem(DEFAULT_TEXT_ACCORDION_10_EN)))
            .andExpect(jsonPath("$.[*].textAccordion10Ger").value(hasItem(DEFAULT_TEXT_ACCORDION_10_GER)))
            .andExpect(jsonPath("$.[*].textAccordion10Sw").value(hasItem(DEFAULT_TEXT_ACCORDION_10_SW)));
    }
    
    @Test
    @Transactional
    public void getFAQs() throws Exception {
        // Initialize the database
        fAQsRepository.saveAndFlush(fAQs);

        // Get the fAQs
        restFAQsMockMvc.perform(get("/api/fa-qs/{id}", fAQs.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(fAQs.getId().intValue()))
            .andExpect(jsonPath("$.titreFr").value(DEFAULT_TITRE_FR))
            .andExpect(jsonPath("$.titreEn").value(DEFAULT_TITRE_EN))
            .andExpect(jsonPath("$.titreGer").value(DEFAULT_TITRE_GER))
            .andExpect(jsonPath("$.titreSw").value(DEFAULT_TITRE_SW))
            .andExpect(jsonPath("$.sousTitreFr").value(DEFAULT_SOUS_TITRE_FR))
            .andExpect(jsonPath("$.sousTitreEn").value(DEFAULT_SOUS_TITRE_EN))
            .andExpect(jsonPath("$.sousTitreGer").value(DEFAULT_SOUS_TITRE_GER))
            .andExpect(jsonPath("$.sousTitreSw").value(DEFAULT_SOUS_TITRE_SW))
            .andExpect(jsonPath("$.titreAccordion1Fr").value(DEFAULT_TITRE_ACCORDION_1_FR))
            .andExpect(jsonPath("$.titreAccordion1En").value(DEFAULT_TITRE_ACCORDION_1_EN))
            .andExpect(jsonPath("$.titreAccordion1Gr").value(DEFAULT_TITRE_ACCORDION_1_GR))
            .andExpect(jsonPath("$.titreAccordion1Sw").value(DEFAULT_TITRE_ACCORDION_1_SW))
            .andExpect(jsonPath("$.titreAccordion2Fr").value(DEFAULT_TITRE_ACCORDION_2_FR))
            .andExpect(jsonPath("$.titreAccordion2En").value(DEFAULT_TITRE_ACCORDION_2_EN))
            .andExpect(jsonPath("$.titreAccordion2Ger").value(DEFAULT_TITRE_ACCORDION_2_GER))
            .andExpect(jsonPath("$.titreAccordion2Sw").value(DEFAULT_TITRE_ACCORDION_2_SW))
            .andExpect(jsonPath("$.titreAccordion3Fr").value(DEFAULT_TITRE_ACCORDION_3_FR))
            .andExpect(jsonPath("$.titreAccordion3En").value(DEFAULT_TITRE_ACCORDION_3_EN))
            .andExpect(jsonPath("$.titreAccordion3Ger").value(DEFAULT_TITRE_ACCORDION_3_GER))
            .andExpect(jsonPath("$.titreAccordion3Sw").value(DEFAULT_TITRE_ACCORDION_3_SW))
            .andExpect(jsonPath("$.titreAccordion4Fr").value(DEFAULT_TITRE_ACCORDION_4_FR))
            .andExpect(jsonPath("$.titreAccordion4En").value(DEFAULT_TITRE_ACCORDION_4_EN))
            .andExpect(jsonPath("$.titreAccordion4Ger").value(DEFAULT_TITRE_ACCORDION_4_GER))
            .andExpect(jsonPath("$.titreAccordion4Sw").value(DEFAULT_TITRE_ACCORDION_4_SW))
            .andExpect(jsonPath("$.titreAccordion5Fr").value(DEFAULT_TITRE_ACCORDION_5_FR))
            .andExpect(jsonPath("$.titreAccordion5En").value(DEFAULT_TITRE_ACCORDION_5_EN))
            .andExpect(jsonPath("$.titreAccordion5Ger").value(DEFAULT_TITRE_ACCORDION_5_GER))
            .andExpect(jsonPath("$.titreAccordion5Sw").value(DEFAULT_TITRE_ACCORDION_5_SW))
            .andExpect(jsonPath("$.titreAccordion6Fr").value(DEFAULT_TITRE_ACCORDION_6_FR))
            .andExpect(jsonPath("$.titreAccordion6En").value(DEFAULT_TITRE_ACCORDION_6_EN))
            .andExpect(jsonPath("$.titreAccordion6Ger").value(DEFAULT_TITRE_ACCORDION_6_GER))
            .andExpect(jsonPath("$.titreAccordion6Sw").value(DEFAULT_TITRE_ACCORDION_6_SW))
            .andExpect(jsonPath("$.titreAccordion7Fr").value(DEFAULT_TITRE_ACCORDION_7_FR))
            .andExpect(jsonPath("$.titreAccordion7En").value(DEFAULT_TITRE_ACCORDION_7_EN))
            .andExpect(jsonPath("$.titreAccordion7Ger").value(DEFAULT_TITRE_ACCORDION_7_GER))
            .andExpect(jsonPath("$.titreAccordion7Sw").value(DEFAULT_TITRE_ACCORDION_7_SW))
            .andExpect(jsonPath("$.titreAccordion8Fr").value(DEFAULT_TITRE_ACCORDION_8_FR))
            .andExpect(jsonPath("$.titreAccordion8En").value(DEFAULT_TITRE_ACCORDION_8_EN))
            .andExpect(jsonPath("$.titreAccordion8Ger").value(DEFAULT_TITRE_ACCORDION_8_GER))
            .andExpect(jsonPath("$.titreAccordion8Sw").value(DEFAULT_TITRE_ACCORDION_8_SW))
            .andExpect(jsonPath("$.titreAccordion9Fr").value(DEFAULT_TITRE_ACCORDION_9_FR))
            .andExpect(jsonPath("$.titreAccordion9En").value(DEFAULT_TITRE_ACCORDION_9_EN))
            .andExpect(jsonPath("$.titreAccordion9Ger").value(DEFAULT_TITRE_ACCORDION_9_GER))
            .andExpect(jsonPath("$.titreAccordion9Sw").value(DEFAULT_TITRE_ACCORDION_9_SW))
            .andExpect(jsonPath("$.titreAccordion10Fr").value(DEFAULT_TITRE_ACCORDION_10_FR))
            .andExpect(jsonPath("$.titreAccordion10En").value(DEFAULT_TITRE_ACCORDION_10_EN))
            .andExpect(jsonPath("$.titreAccordion10Ger").value(DEFAULT_TITRE_ACCORDION_10_GER))
            .andExpect(jsonPath("$.titreAccordion10Sw").value(DEFAULT_TITRE_ACCORDION_10_SW))
            .andExpect(jsonPath("$.textAccordion1Fr").value(DEFAULT_TEXT_ACCORDION_1_FR))
            .andExpect(jsonPath("$.textAccordion1En").value(DEFAULT_TEXT_ACCORDION_1_EN))
            .andExpect(jsonPath("$.textAccordion1Ger").value(DEFAULT_TEXT_ACCORDION_1_GER))
            .andExpect(jsonPath("$.textAccordion1Sw").value(DEFAULT_TEXT_ACCORDION_1_SW))
            .andExpect(jsonPath("$.textAccordion2Fr").value(DEFAULT_TEXT_ACCORDION_2_FR))
            .andExpect(jsonPath("$.textAccordion2En").value(DEFAULT_TEXT_ACCORDION_2_EN))
            .andExpect(jsonPath("$.textAccordion2Ger").value(DEFAULT_TEXT_ACCORDION_2_GER))
            .andExpect(jsonPath("$.textAccordion2Sw").value(DEFAULT_TEXT_ACCORDION_2_SW))
            .andExpect(jsonPath("$.textAccordion3Fr").value(DEFAULT_TEXT_ACCORDION_3_FR))
            .andExpect(jsonPath("$.textAccordion3En").value(DEFAULT_TEXT_ACCORDION_3_EN))
            .andExpect(jsonPath("$.textAccordion3Ger").value(DEFAULT_TEXT_ACCORDION_3_GER))
            .andExpect(jsonPath("$.textAccordion3Sw").value(DEFAULT_TEXT_ACCORDION_3_SW))
            .andExpect(jsonPath("$.textAccordion4Fr").value(DEFAULT_TEXT_ACCORDION_4_FR))
            .andExpect(jsonPath("$.textAccordion4En").value(DEFAULT_TEXT_ACCORDION_4_EN))
            .andExpect(jsonPath("$.textAccordion4Ger").value(DEFAULT_TEXT_ACCORDION_4_GER))
            .andExpect(jsonPath("$.textAccordion4Sw").value(DEFAULT_TEXT_ACCORDION_4_SW))
            .andExpect(jsonPath("$.textAccordion5Fr").value(DEFAULT_TEXT_ACCORDION_5_FR))
            .andExpect(jsonPath("$.textAccordion5En").value(DEFAULT_TEXT_ACCORDION_5_EN))
            .andExpect(jsonPath("$.textAccordion5Ger").value(DEFAULT_TEXT_ACCORDION_5_GER))
            .andExpect(jsonPath("$.textAccordion5Sw").value(DEFAULT_TEXT_ACCORDION_5_SW))
            .andExpect(jsonPath("$.textAccordion6Fr").value(DEFAULT_TEXT_ACCORDION_6_FR))
            .andExpect(jsonPath("$.textAccordion6En").value(DEFAULT_TEXT_ACCORDION_6_EN))
            .andExpect(jsonPath("$.textAccordion6Ger").value(DEFAULT_TEXT_ACCORDION_6_GER))
            .andExpect(jsonPath("$.textAccordion6Sw").value(DEFAULT_TEXT_ACCORDION_6_SW))
            .andExpect(jsonPath("$.textAccordion7Fr").value(DEFAULT_TEXT_ACCORDION_7_FR))
            .andExpect(jsonPath("$.textAccordion7En").value(DEFAULT_TEXT_ACCORDION_7_EN))
            .andExpect(jsonPath("$.textAccordion7Ger").value(DEFAULT_TEXT_ACCORDION_7_GER))
            .andExpect(jsonPath("$.textAccordion7Sw").value(DEFAULT_TEXT_ACCORDION_7_SW))
            .andExpect(jsonPath("$.textAccordion8Fr").value(DEFAULT_TEXT_ACCORDION_8_FR))
            .andExpect(jsonPath("$.textAccordion8En").value(DEFAULT_TEXT_ACCORDION_8_EN))
            .andExpect(jsonPath("$.textAccordion8Ger").value(DEFAULT_TEXT_ACCORDION_8_GER))
            .andExpect(jsonPath("$.textAccordion8Sw").value(DEFAULT_TEXT_ACCORDION_8_SW))
            .andExpect(jsonPath("$.textAccordion9Fr").value(DEFAULT_TEXT_ACCORDION_9_FR))
            .andExpect(jsonPath("$.textAccordion9En").value(DEFAULT_TEXT_ACCORDION_9_EN))
            .andExpect(jsonPath("$.textAccordion9Ger").value(DEFAULT_TEXT_ACCORDION_9_GER))
            .andExpect(jsonPath("$.textAccordion9Sw").value(DEFAULT_TEXT_ACCORDION_9_SW))
            .andExpect(jsonPath("$.textAccordion10Fr").value(DEFAULT_TEXT_ACCORDION_10_FR))
            .andExpect(jsonPath("$.textAccordion10En").value(DEFAULT_TEXT_ACCORDION_10_EN))
            .andExpect(jsonPath("$.textAccordion10Ger").value(DEFAULT_TEXT_ACCORDION_10_GER))
            .andExpect(jsonPath("$.textAccordion10Sw").value(DEFAULT_TEXT_ACCORDION_10_SW));
    }

    @Test
    @Transactional
    public void getNonExistingFAQs() throws Exception {
        // Get the fAQs
        restFAQsMockMvc.perform(get("/api/fa-qs/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateFAQs() throws Exception {
        // Initialize the database
        fAQsRepository.saveAndFlush(fAQs);

        int databaseSizeBeforeUpdate = fAQsRepository.findAll().size();

        // Update the fAQs
        FAQs updatedFAQs = fAQsRepository.findById(fAQs.getId()).get();
        // Disconnect from session so that the updates on updatedFAQs are not directly saved in db
        em.detach(updatedFAQs);
        updatedFAQs
            .titreFr(UPDATED_TITRE_FR)
            .titreEn(UPDATED_TITRE_EN)
            .titreGer(UPDATED_TITRE_GER)
            .titreSw(UPDATED_TITRE_SW)
            .sousTitreFr(UPDATED_SOUS_TITRE_FR)
            .sousTitreEn(UPDATED_SOUS_TITRE_EN)
            .sousTitreGer(UPDATED_SOUS_TITRE_GER)
            .sousTitreSw(UPDATED_SOUS_TITRE_SW)
            .titreAccordion1Fr(UPDATED_TITRE_ACCORDION_1_FR)
            .titreAccordion1En(UPDATED_TITRE_ACCORDION_1_EN)
            .titreAccordion1Gr(UPDATED_TITRE_ACCORDION_1_GR)
            .titreAccordion1Sw(UPDATED_TITRE_ACCORDION_1_SW)
            .titreAccordion2Fr(UPDATED_TITRE_ACCORDION_2_FR)
            .titreAccordion2En(UPDATED_TITRE_ACCORDION_2_EN)
            .titreAccordion2Ger(UPDATED_TITRE_ACCORDION_2_GER)
            .titreAccordion2Sw(UPDATED_TITRE_ACCORDION_2_SW)
            .titreAccordion3Fr(UPDATED_TITRE_ACCORDION_3_FR)
            .titreAccordion3En(UPDATED_TITRE_ACCORDION_3_EN)
            .titreAccordion3Ger(UPDATED_TITRE_ACCORDION_3_GER)
            .titreAccordion3Sw(UPDATED_TITRE_ACCORDION_3_SW)
            .titreAccordion4Fr(UPDATED_TITRE_ACCORDION_4_FR)
            .titreAccordion4En(UPDATED_TITRE_ACCORDION_4_EN)
            .titreAccordion4Ger(UPDATED_TITRE_ACCORDION_4_GER)
            .titreAccordion4Sw(UPDATED_TITRE_ACCORDION_4_SW)
            .titreAccordion5Fr(UPDATED_TITRE_ACCORDION_5_FR)
            .titreAccordion5En(UPDATED_TITRE_ACCORDION_5_EN)
            .titreAccordion5Ger(UPDATED_TITRE_ACCORDION_5_GER)
            .titreAccordion5Sw(UPDATED_TITRE_ACCORDION_5_SW)
            .titreAccordion6Fr(UPDATED_TITRE_ACCORDION_6_FR)
            .titreAccordion6En(UPDATED_TITRE_ACCORDION_6_EN)
            .titreAccordion6Ger(UPDATED_TITRE_ACCORDION_6_GER)
            .titreAccordion6Sw(UPDATED_TITRE_ACCORDION_6_SW)
            .titreAccordion7Fr(UPDATED_TITRE_ACCORDION_7_FR)
            .titreAccordion7En(UPDATED_TITRE_ACCORDION_7_EN)
            .titreAccordion7Ger(UPDATED_TITRE_ACCORDION_7_GER)
            .titreAccordion7Sw(UPDATED_TITRE_ACCORDION_7_SW)
            .titreAccordion8Fr(UPDATED_TITRE_ACCORDION_8_FR)
            .titreAccordion8En(UPDATED_TITRE_ACCORDION_8_EN)
            .titreAccordion8Ger(UPDATED_TITRE_ACCORDION_8_GER)
            .titreAccordion8Sw(UPDATED_TITRE_ACCORDION_8_SW)
            .titreAccordion9Fr(UPDATED_TITRE_ACCORDION_9_FR)
            .titreAccordion9En(UPDATED_TITRE_ACCORDION_9_EN)
            .titreAccordion9Ger(UPDATED_TITRE_ACCORDION_9_GER)
            .titreAccordion9Sw(UPDATED_TITRE_ACCORDION_9_SW)
            .titreAccordion10Fr(UPDATED_TITRE_ACCORDION_10_FR)
            .titreAccordion10En(UPDATED_TITRE_ACCORDION_10_EN)
            .titreAccordion10Ger(UPDATED_TITRE_ACCORDION_10_GER)
            .titreAccordion10Sw(UPDATED_TITRE_ACCORDION_10_SW)
            .textAccordion1Fr(UPDATED_TEXT_ACCORDION_1_FR)
            .textAccordion1En(UPDATED_TEXT_ACCORDION_1_EN)
            .textAccordion1Ger(UPDATED_TEXT_ACCORDION_1_GER)
            .textAccordion1Sw(UPDATED_TEXT_ACCORDION_1_SW)
            .textAccordion2Fr(UPDATED_TEXT_ACCORDION_2_FR)
            .textAccordion2En(UPDATED_TEXT_ACCORDION_2_EN)
            .textAccordion2Ger(UPDATED_TEXT_ACCORDION_2_GER)
            .textAccordion2Sw(UPDATED_TEXT_ACCORDION_2_SW)
            .textAccordion3Fr(UPDATED_TEXT_ACCORDION_3_FR)
            .textAccordion3En(UPDATED_TEXT_ACCORDION_3_EN)
            .textAccordion3Ger(UPDATED_TEXT_ACCORDION_3_GER)
            .textAccordion3Sw(UPDATED_TEXT_ACCORDION_3_SW)
            .textAccordion4Fr(UPDATED_TEXT_ACCORDION_4_FR)
            .textAccordion4En(UPDATED_TEXT_ACCORDION_4_EN)
            .textAccordion4Ger(UPDATED_TEXT_ACCORDION_4_GER)
            .textAccordion4Sw(UPDATED_TEXT_ACCORDION_4_SW)
            .textAccordion5Fr(UPDATED_TEXT_ACCORDION_5_FR)
            .textAccordion5En(UPDATED_TEXT_ACCORDION_5_EN)
            .textAccordion5Ger(UPDATED_TEXT_ACCORDION_5_GER)
            .textAccordion5Sw(UPDATED_TEXT_ACCORDION_5_SW)
            .textAccordion6Fr(UPDATED_TEXT_ACCORDION_6_FR)
            .textAccordion6En(UPDATED_TEXT_ACCORDION_6_EN)
            .textAccordion6Ger(UPDATED_TEXT_ACCORDION_6_GER)
            .textAccordion6Sw(UPDATED_TEXT_ACCORDION_6_SW)
            .textAccordion7Fr(UPDATED_TEXT_ACCORDION_7_FR)
            .textAccordion7En(UPDATED_TEXT_ACCORDION_7_EN)
            .textAccordion7Ger(UPDATED_TEXT_ACCORDION_7_GER)
            .textAccordion7Sw(UPDATED_TEXT_ACCORDION_7_SW)
            .textAccordion8Fr(UPDATED_TEXT_ACCORDION_8_FR)
            .textAccordion8En(UPDATED_TEXT_ACCORDION_8_EN)
            .textAccordion8Ger(UPDATED_TEXT_ACCORDION_8_GER)
            .textAccordion8Sw(UPDATED_TEXT_ACCORDION_8_SW)
            .textAccordion9Fr(UPDATED_TEXT_ACCORDION_9_FR)
            .textAccordion9En(UPDATED_TEXT_ACCORDION_9_EN)
            .textAccordion9Ger(UPDATED_TEXT_ACCORDION_9_GER)
            .textAccordion9Sw(UPDATED_TEXT_ACCORDION_9_SW)
            .textAccordion10Fr(UPDATED_TEXT_ACCORDION_10_FR)
            .textAccordion10En(UPDATED_TEXT_ACCORDION_10_EN)
            .textAccordion10Ger(UPDATED_TEXT_ACCORDION_10_GER)
            .textAccordion10Sw(UPDATED_TEXT_ACCORDION_10_SW);

        restFAQsMockMvc.perform(put("/api/fa-qs")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(updatedFAQs)))
            .andExpect(status().isOk());

        // Validate the FAQs in the database
        List<FAQs> fAQsList = fAQsRepository.findAll();
        assertThat(fAQsList).hasSize(databaseSizeBeforeUpdate);
        FAQs testFAQs = fAQsList.get(fAQsList.size() - 1);
        assertThat(testFAQs.getTitreFr()).isEqualTo(UPDATED_TITRE_FR);
        assertThat(testFAQs.getTitreEn()).isEqualTo(UPDATED_TITRE_EN);
        assertThat(testFAQs.getTitreGer()).isEqualTo(UPDATED_TITRE_GER);
        assertThat(testFAQs.getTitreSw()).isEqualTo(UPDATED_TITRE_SW);
        assertThat(testFAQs.getSousTitreFr()).isEqualTo(UPDATED_SOUS_TITRE_FR);
        assertThat(testFAQs.getSousTitreEn()).isEqualTo(UPDATED_SOUS_TITRE_EN);
        assertThat(testFAQs.getSousTitreGer()).isEqualTo(UPDATED_SOUS_TITRE_GER);
        assertThat(testFAQs.getSousTitreSw()).isEqualTo(UPDATED_SOUS_TITRE_SW);
        assertThat(testFAQs.getTitreAccordion1Fr()).isEqualTo(UPDATED_TITRE_ACCORDION_1_FR);
        assertThat(testFAQs.getTitreAccordion1En()).isEqualTo(UPDATED_TITRE_ACCORDION_1_EN);
        assertThat(testFAQs.getTitreAccordion1Gr()).isEqualTo(UPDATED_TITRE_ACCORDION_1_GR);
        assertThat(testFAQs.getTitreAccordion1Sw()).isEqualTo(UPDATED_TITRE_ACCORDION_1_SW);
        assertThat(testFAQs.getTitreAccordion2Fr()).isEqualTo(UPDATED_TITRE_ACCORDION_2_FR);
        assertThat(testFAQs.getTitreAccordion2En()).isEqualTo(UPDATED_TITRE_ACCORDION_2_EN);
        assertThat(testFAQs.getTitreAccordion2Ger()).isEqualTo(UPDATED_TITRE_ACCORDION_2_GER);
        assertThat(testFAQs.getTitreAccordion2Sw()).isEqualTo(UPDATED_TITRE_ACCORDION_2_SW);
        assertThat(testFAQs.getTitreAccordion3Fr()).isEqualTo(UPDATED_TITRE_ACCORDION_3_FR);
        assertThat(testFAQs.getTitreAccordion3En()).isEqualTo(UPDATED_TITRE_ACCORDION_3_EN);
        assertThat(testFAQs.getTitreAccordion3Ger()).isEqualTo(UPDATED_TITRE_ACCORDION_3_GER);
        assertThat(testFAQs.getTitreAccordion3Sw()).isEqualTo(UPDATED_TITRE_ACCORDION_3_SW);
        assertThat(testFAQs.getTitreAccordion4Fr()).isEqualTo(UPDATED_TITRE_ACCORDION_4_FR);
        assertThat(testFAQs.getTitreAccordion4En()).isEqualTo(UPDATED_TITRE_ACCORDION_4_EN);
        assertThat(testFAQs.getTitreAccordion4Ger()).isEqualTo(UPDATED_TITRE_ACCORDION_4_GER);
        assertThat(testFAQs.getTitreAccordion4Sw()).isEqualTo(UPDATED_TITRE_ACCORDION_4_SW);
        assertThat(testFAQs.getTitreAccordion5Fr()).isEqualTo(UPDATED_TITRE_ACCORDION_5_FR);
        assertThat(testFAQs.getTitreAccordion5En()).isEqualTo(UPDATED_TITRE_ACCORDION_5_EN);
        assertThat(testFAQs.getTitreAccordion5Ger()).isEqualTo(UPDATED_TITRE_ACCORDION_5_GER);
        assertThat(testFAQs.getTitreAccordion5Sw()).isEqualTo(UPDATED_TITRE_ACCORDION_5_SW);
        assertThat(testFAQs.getTitreAccordion6Fr()).isEqualTo(UPDATED_TITRE_ACCORDION_6_FR);
        assertThat(testFAQs.getTitreAccordion6En()).isEqualTo(UPDATED_TITRE_ACCORDION_6_EN);
        assertThat(testFAQs.getTitreAccordion6Ger()).isEqualTo(UPDATED_TITRE_ACCORDION_6_GER);
        assertThat(testFAQs.getTitreAccordion6Sw()).isEqualTo(UPDATED_TITRE_ACCORDION_6_SW);
        assertThat(testFAQs.getTitreAccordion7Fr()).isEqualTo(UPDATED_TITRE_ACCORDION_7_FR);
        assertThat(testFAQs.getTitreAccordion7En()).isEqualTo(UPDATED_TITRE_ACCORDION_7_EN);
        assertThat(testFAQs.getTitreAccordion7Ger()).isEqualTo(UPDATED_TITRE_ACCORDION_7_GER);
        assertThat(testFAQs.getTitreAccordion7Sw()).isEqualTo(UPDATED_TITRE_ACCORDION_7_SW);
        assertThat(testFAQs.getTitreAccordion8Fr()).isEqualTo(UPDATED_TITRE_ACCORDION_8_FR);
        assertThat(testFAQs.getTitreAccordion8En()).isEqualTo(UPDATED_TITRE_ACCORDION_8_EN);
        assertThat(testFAQs.getTitreAccordion8Ger()).isEqualTo(UPDATED_TITRE_ACCORDION_8_GER);
        assertThat(testFAQs.getTitreAccordion8Sw()).isEqualTo(UPDATED_TITRE_ACCORDION_8_SW);
        assertThat(testFAQs.getTitreAccordion9Fr()).isEqualTo(UPDATED_TITRE_ACCORDION_9_FR);
        assertThat(testFAQs.getTitreAccordion9En()).isEqualTo(UPDATED_TITRE_ACCORDION_9_EN);
        assertThat(testFAQs.getTitreAccordion9Ger()).isEqualTo(UPDATED_TITRE_ACCORDION_9_GER);
        assertThat(testFAQs.getTitreAccordion9Sw()).isEqualTo(UPDATED_TITRE_ACCORDION_9_SW);
        assertThat(testFAQs.getTitreAccordion10Fr()).isEqualTo(UPDATED_TITRE_ACCORDION_10_FR);
        assertThat(testFAQs.getTitreAccordion10En()).isEqualTo(UPDATED_TITRE_ACCORDION_10_EN);
        assertThat(testFAQs.getTitreAccordion10Ger()).isEqualTo(UPDATED_TITRE_ACCORDION_10_GER);
        assertThat(testFAQs.getTitreAccordion10Sw()).isEqualTo(UPDATED_TITRE_ACCORDION_10_SW);
        assertThat(testFAQs.getTextAccordion1Fr()).isEqualTo(UPDATED_TEXT_ACCORDION_1_FR);
        assertThat(testFAQs.getTextAccordion1En()).isEqualTo(UPDATED_TEXT_ACCORDION_1_EN);
        assertThat(testFAQs.getTextAccordion1Ger()).isEqualTo(UPDATED_TEXT_ACCORDION_1_GER);
        assertThat(testFAQs.getTextAccordion1Sw()).isEqualTo(UPDATED_TEXT_ACCORDION_1_SW);
        assertThat(testFAQs.getTextAccordion2Fr()).isEqualTo(UPDATED_TEXT_ACCORDION_2_FR);
        assertThat(testFAQs.getTextAccordion2En()).isEqualTo(UPDATED_TEXT_ACCORDION_2_EN);
        assertThat(testFAQs.getTextAccordion2Ger()).isEqualTo(UPDATED_TEXT_ACCORDION_2_GER);
        assertThat(testFAQs.getTextAccordion2Sw()).isEqualTo(UPDATED_TEXT_ACCORDION_2_SW);
        assertThat(testFAQs.getTextAccordion3Fr()).isEqualTo(UPDATED_TEXT_ACCORDION_3_FR);
        assertThat(testFAQs.getTextAccordion3En()).isEqualTo(UPDATED_TEXT_ACCORDION_3_EN);
        assertThat(testFAQs.getTextAccordion3Ger()).isEqualTo(UPDATED_TEXT_ACCORDION_3_GER);
        assertThat(testFAQs.getTextAccordion3Sw()).isEqualTo(UPDATED_TEXT_ACCORDION_3_SW);
        assertThat(testFAQs.getTextAccordion4Fr()).isEqualTo(UPDATED_TEXT_ACCORDION_4_FR);
        assertThat(testFAQs.getTextAccordion4En()).isEqualTo(UPDATED_TEXT_ACCORDION_4_EN);
        assertThat(testFAQs.getTextAccordion4Ger()).isEqualTo(UPDATED_TEXT_ACCORDION_4_GER);
        assertThat(testFAQs.getTextAccordion4Sw()).isEqualTo(UPDATED_TEXT_ACCORDION_4_SW);
        assertThat(testFAQs.getTextAccordion5Fr()).isEqualTo(UPDATED_TEXT_ACCORDION_5_FR);
        assertThat(testFAQs.getTextAccordion5En()).isEqualTo(UPDATED_TEXT_ACCORDION_5_EN);
        assertThat(testFAQs.getTextAccordion5Ger()).isEqualTo(UPDATED_TEXT_ACCORDION_5_GER);
        assertThat(testFAQs.getTextAccordion5Sw()).isEqualTo(UPDATED_TEXT_ACCORDION_5_SW);
        assertThat(testFAQs.getTextAccordion6Fr()).isEqualTo(UPDATED_TEXT_ACCORDION_6_FR);
        assertThat(testFAQs.getTextAccordion6En()).isEqualTo(UPDATED_TEXT_ACCORDION_6_EN);
        assertThat(testFAQs.getTextAccordion6Ger()).isEqualTo(UPDATED_TEXT_ACCORDION_6_GER);
        assertThat(testFAQs.getTextAccordion6Sw()).isEqualTo(UPDATED_TEXT_ACCORDION_6_SW);
        assertThat(testFAQs.getTextAccordion7Fr()).isEqualTo(UPDATED_TEXT_ACCORDION_7_FR);
        assertThat(testFAQs.getTextAccordion7En()).isEqualTo(UPDATED_TEXT_ACCORDION_7_EN);
        assertThat(testFAQs.getTextAccordion7Ger()).isEqualTo(UPDATED_TEXT_ACCORDION_7_GER);
        assertThat(testFAQs.getTextAccordion7Sw()).isEqualTo(UPDATED_TEXT_ACCORDION_7_SW);
        assertThat(testFAQs.getTextAccordion8Fr()).isEqualTo(UPDATED_TEXT_ACCORDION_8_FR);
        assertThat(testFAQs.getTextAccordion8En()).isEqualTo(UPDATED_TEXT_ACCORDION_8_EN);
        assertThat(testFAQs.getTextAccordion8Ger()).isEqualTo(UPDATED_TEXT_ACCORDION_8_GER);
        assertThat(testFAQs.getTextAccordion8Sw()).isEqualTo(UPDATED_TEXT_ACCORDION_8_SW);
        assertThat(testFAQs.getTextAccordion9Fr()).isEqualTo(UPDATED_TEXT_ACCORDION_9_FR);
        assertThat(testFAQs.getTextAccordion9En()).isEqualTo(UPDATED_TEXT_ACCORDION_9_EN);
        assertThat(testFAQs.getTextAccordion9Ger()).isEqualTo(UPDATED_TEXT_ACCORDION_9_GER);
        assertThat(testFAQs.getTextAccordion9Sw()).isEqualTo(UPDATED_TEXT_ACCORDION_9_SW);
        assertThat(testFAQs.getTextAccordion10Fr()).isEqualTo(UPDATED_TEXT_ACCORDION_10_FR);
        assertThat(testFAQs.getTextAccordion10En()).isEqualTo(UPDATED_TEXT_ACCORDION_10_EN);
        assertThat(testFAQs.getTextAccordion10Ger()).isEqualTo(UPDATED_TEXT_ACCORDION_10_GER);
        assertThat(testFAQs.getTextAccordion10Sw()).isEqualTo(UPDATED_TEXT_ACCORDION_10_SW);
    }

    @Test
    @Transactional
    public void updateNonExistingFAQs() throws Exception {
        int databaseSizeBeforeUpdate = fAQsRepository.findAll().size();

        // Create the FAQs

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restFAQsMockMvc.perform(put("/api/fa-qs")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(fAQs)))
            .andExpect(status().isBadRequest());

        // Validate the FAQs in the database
        List<FAQs> fAQsList = fAQsRepository.findAll();
        assertThat(fAQsList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteFAQs() throws Exception {
        // Initialize the database
        fAQsRepository.saveAndFlush(fAQs);

        int databaseSizeBeforeDelete = fAQsRepository.findAll().size();

        // Delete the fAQs
        restFAQsMockMvc.perform(delete("/api/fa-qs/{id}", fAQs.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<FAQs> fAQsList = fAQsRepository.findAll();
        assertThat(fAQsList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
