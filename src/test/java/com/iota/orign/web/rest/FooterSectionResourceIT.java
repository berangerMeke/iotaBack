package com.iota.orign.web.rest;

import com.iota.orign.IotaOrignAdminApp;
import com.iota.orign.domain.FooterSection;
import com.iota.orign.repository.FooterSectionRepository;

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
 * Integration tests for the {@link FooterSectionResource} REST controller.
 */
@SpringBootTest(classes = IotaOrignAdminApp.class)

@AutoConfigureMockMvc
@WithMockUser
public class FooterSectionResourceIT {

    private static final String DEFAULT_TITRE_EN = "AAAAAAAAAA";
    private static final String UPDATED_TITRE_EN = "BBBBBBBBBB";

    private static final String DEFAULT_TITRE_GER = "AAAAAAAAAA";
    private static final String UPDATED_TITRE_GER = "BBBBBBBBBB";

    private static final String DEFAULT_TITRE_FR = "AAAAAAAAAA";
    private static final String UPDATED_TITRE_FR = "BBBBBBBBBB";

    private static final String DEFAULT_TITRE_SW = "AAAAAAAAAA";
    private static final String UPDATED_TITRE_SW = "BBBBBBBBBB";

    private static final String DEFAULT_SOUS_TITRE_EN = "AAAAAAAAAA";
    private static final String UPDATED_SOUS_TITRE_EN = "BBBBBBBBBB";

    private static final String DEFAULT_SOUS_TITRE_GER = "AAAAAAAAAA";
    private static final String UPDATED_SOUS_TITRE_GER = "BBBBBBBBBB";

    private static final String DEFAULT_SOUS_TITRE_FR = "AAAAAAAAAA";
    private static final String UPDATED_SOUS_TITRE_FR = "BBBBBBBBBB";

    private static final String DEFAULT_SOUS_TITRE_SW = "AAAAAAAAAA";
    private static final String UPDATED_SOUS_TITRE_SW = "BBBBBBBBBB";

    private static final byte[] DEFAULT_LOGO = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_LOGO = TestUtil.createByteArray(1, "1");
    private static final String DEFAULT_LOGO_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_LOGO_CONTENT_TYPE = "image/png";

    private static final String DEFAULT_TEXTE_BOUTON = "AAAAAAAAAA";
    private static final String UPDATED_TEXTE_BOUTON = "BBBBBBBBBB";

    private static final String DEFAULT_TWITTERLINK = "AAAAAAAAAA";
    private static final String UPDATED_TWITTERLINK = "BBBBBBBBBB";

    private static final String DEFAULT_DISCORD_LINK = "AAAAAAAAAA";
    private static final String UPDATED_DISCORD_LINK = "BBBBBBBBBB";

    @Autowired
    private FooterSectionRepository footerSectionRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restFooterSectionMockMvc;

    private FooterSection footerSection;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static FooterSection createEntity(EntityManager em) {
        FooterSection footerSection = new FooterSection()
            .titreEn(DEFAULT_TITRE_EN)
            .titreGer(DEFAULT_TITRE_GER)
            .titreFr(DEFAULT_TITRE_FR)
            .titreSw(DEFAULT_TITRE_SW)
            .sousTitreEn(DEFAULT_SOUS_TITRE_EN)
            .sousTitreGer(DEFAULT_SOUS_TITRE_GER)
            .sousTitreFr(DEFAULT_SOUS_TITRE_FR)
            .sousTitreSw(DEFAULT_SOUS_TITRE_SW)
            .logo(DEFAULT_LOGO)
            .logoContentType(DEFAULT_LOGO_CONTENT_TYPE)
            .texteBouton(DEFAULT_TEXTE_BOUTON)
            .twitterlink(DEFAULT_TWITTERLINK)
            .discordLink(DEFAULT_DISCORD_LINK);
        return footerSection;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static FooterSection createUpdatedEntity(EntityManager em) {
        FooterSection footerSection = new FooterSection()
            .titreEn(UPDATED_TITRE_EN)
            .titreGer(UPDATED_TITRE_GER)
            .titreFr(UPDATED_TITRE_FR)
            .titreSw(UPDATED_TITRE_SW)
            .sousTitreEn(UPDATED_SOUS_TITRE_EN)
            .sousTitreGer(UPDATED_SOUS_TITRE_GER)
            .sousTitreFr(UPDATED_SOUS_TITRE_FR)
            .sousTitreSw(UPDATED_SOUS_TITRE_SW)
            .logo(UPDATED_LOGO)
            .logoContentType(UPDATED_LOGO_CONTENT_TYPE)
            .texteBouton(UPDATED_TEXTE_BOUTON)
            .twitterlink(UPDATED_TWITTERLINK)
            .discordLink(UPDATED_DISCORD_LINK);
        return footerSection;
    }

    @BeforeEach
    public void initTest() {
        footerSection = createEntity(em);
    }

    @Test
    @Transactional
    public void createFooterSection() throws Exception {
        int databaseSizeBeforeCreate = footerSectionRepository.findAll().size();

        // Create the FooterSection
        restFooterSectionMockMvc.perform(post("/api/footer-sections")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(footerSection)))
            .andExpect(status().isCreated());

        // Validate the FooterSection in the database
        List<FooterSection> footerSectionList = footerSectionRepository.findAll();
        assertThat(footerSectionList).hasSize(databaseSizeBeforeCreate + 1);
        FooterSection testFooterSection = footerSectionList.get(footerSectionList.size() - 1);
        assertThat(testFooterSection.getTitreEn()).isEqualTo(DEFAULT_TITRE_EN);
        assertThat(testFooterSection.getTitreGer()).isEqualTo(DEFAULT_TITRE_GER);
        assertThat(testFooterSection.getTitreFr()).isEqualTo(DEFAULT_TITRE_FR);
        assertThat(testFooterSection.getTitreSw()).isEqualTo(DEFAULT_TITRE_SW);
        assertThat(testFooterSection.getSousTitreEn()).isEqualTo(DEFAULT_SOUS_TITRE_EN);
        assertThat(testFooterSection.getSousTitreGer()).isEqualTo(DEFAULT_SOUS_TITRE_GER);
        assertThat(testFooterSection.getSousTitreFr()).isEqualTo(DEFAULT_SOUS_TITRE_FR);
        assertThat(testFooterSection.getSousTitreSw()).isEqualTo(DEFAULT_SOUS_TITRE_SW);
        assertThat(testFooterSection.getLogo()).isEqualTo(DEFAULT_LOGO);
        assertThat(testFooterSection.getLogoContentType()).isEqualTo(DEFAULT_LOGO_CONTENT_TYPE);
        assertThat(testFooterSection.getTexteBouton()).isEqualTo(DEFAULT_TEXTE_BOUTON);
        assertThat(testFooterSection.getTwitterlink()).isEqualTo(DEFAULT_TWITTERLINK);
        assertThat(testFooterSection.getDiscordLink()).isEqualTo(DEFAULT_DISCORD_LINK);
    }

    @Test
    @Transactional
    public void createFooterSectionWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = footerSectionRepository.findAll().size();

        // Create the FooterSection with an existing ID
        footerSection.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restFooterSectionMockMvc.perform(post("/api/footer-sections")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(footerSection)))
            .andExpect(status().isBadRequest());

        // Validate the FooterSection in the database
        List<FooterSection> footerSectionList = footerSectionRepository.findAll();
        assertThat(footerSectionList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllFooterSections() throws Exception {
        // Initialize the database
        footerSectionRepository.saveAndFlush(footerSection);

        // Get all the footerSectionList
        restFooterSectionMockMvc.perform(get("/api/footer-sections?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(footerSection.getId().intValue())))
            .andExpect(jsonPath("$.[*].titreEn").value(hasItem(DEFAULT_TITRE_EN)))
            .andExpect(jsonPath("$.[*].titreGer").value(hasItem(DEFAULT_TITRE_GER)))
            .andExpect(jsonPath("$.[*].titreFr").value(hasItem(DEFAULT_TITRE_FR)))
            .andExpect(jsonPath("$.[*].titreSw").value(hasItem(DEFAULT_TITRE_SW)))
            .andExpect(jsonPath("$.[*].sousTitreEn").value(hasItem(DEFAULT_SOUS_TITRE_EN)))
            .andExpect(jsonPath("$.[*].sousTitreGer").value(hasItem(DEFAULT_SOUS_TITRE_GER)))
            .andExpect(jsonPath("$.[*].sousTitreFr").value(hasItem(DEFAULT_SOUS_TITRE_FR)))
            .andExpect(jsonPath("$.[*].sousTitreSw").value(hasItem(DEFAULT_SOUS_TITRE_SW)))
            .andExpect(jsonPath("$.[*].logoContentType").value(hasItem(DEFAULT_LOGO_CONTENT_TYPE)))
            .andExpect(jsonPath("$.[*].logo").value(hasItem(Base64Utils.encodeToString(DEFAULT_LOGO))))
            .andExpect(jsonPath("$.[*].texteBouton").value(hasItem(DEFAULT_TEXTE_BOUTON)))
            .andExpect(jsonPath("$.[*].twitterlink").value(hasItem(DEFAULT_TWITTERLINK)))
            .andExpect(jsonPath("$.[*].discordLink").value(hasItem(DEFAULT_DISCORD_LINK)));
    }
    
    @Test
    @Transactional
    public void getFooterSection() throws Exception {
        // Initialize the database
        footerSectionRepository.saveAndFlush(footerSection);

        // Get the footerSection
        restFooterSectionMockMvc.perform(get("/api/footer-sections/{id}", footerSection.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(footerSection.getId().intValue()))
            .andExpect(jsonPath("$.titreEn").value(DEFAULT_TITRE_EN))
            .andExpect(jsonPath("$.titreGer").value(DEFAULT_TITRE_GER))
            .andExpect(jsonPath("$.titreFr").value(DEFAULT_TITRE_FR))
            .andExpect(jsonPath("$.titreSw").value(DEFAULT_TITRE_SW))
            .andExpect(jsonPath("$.sousTitreEn").value(DEFAULT_SOUS_TITRE_EN))
            .andExpect(jsonPath("$.sousTitreGer").value(DEFAULT_SOUS_TITRE_GER))
            .andExpect(jsonPath("$.sousTitreFr").value(DEFAULT_SOUS_TITRE_FR))
            .andExpect(jsonPath("$.sousTitreSw").value(DEFAULT_SOUS_TITRE_SW))
            .andExpect(jsonPath("$.logoContentType").value(DEFAULT_LOGO_CONTENT_TYPE))
            .andExpect(jsonPath("$.logo").value(Base64Utils.encodeToString(DEFAULT_LOGO)))
            .andExpect(jsonPath("$.texteBouton").value(DEFAULT_TEXTE_BOUTON))
            .andExpect(jsonPath("$.twitterlink").value(DEFAULT_TWITTERLINK))
            .andExpect(jsonPath("$.discordLink").value(DEFAULT_DISCORD_LINK));
    }

    @Test
    @Transactional
    public void getNonExistingFooterSection() throws Exception {
        // Get the footerSection
        restFooterSectionMockMvc.perform(get("/api/footer-sections/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateFooterSection() throws Exception {
        // Initialize the database
        footerSectionRepository.saveAndFlush(footerSection);

        int databaseSizeBeforeUpdate = footerSectionRepository.findAll().size();

        // Update the footerSection
        FooterSection updatedFooterSection = footerSectionRepository.findById(footerSection.getId()).get();
        // Disconnect from session so that the updates on updatedFooterSection are not directly saved in db
        em.detach(updatedFooterSection);
        updatedFooterSection
            .titreEn(UPDATED_TITRE_EN)
            .titreGer(UPDATED_TITRE_GER)
            .titreFr(UPDATED_TITRE_FR)
            .titreSw(UPDATED_TITRE_SW)
            .sousTitreEn(UPDATED_SOUS_TITRE_EN)
            .sousTitreGer(UPDATED_SOUS_TITRE_GER)
            .sousTitreFr(UPDATED_SOUS_TITRE_FR)
            .sousTitreSw(UPDATED_SOUS_TITRE_SW)
            .logo(UPDATED_LOGO)
            .logoContentType(UPDATED_LOGO_CONTENT_TYPE)
            .texteBouton(UPDATED_TEXTE_BOUTON)
            .twitterlink(UPDATED_TWITTERLINK)
            .discordLink(UPDATED_DISCORD_LINK);

        restFooterSectionMockMvc.perform(put("/api/footer-sections")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(updatedFooterSection)))
            .andExpect(status().isOk());

        // Validate the FooterSection in the database
        List<FooterSection> footerSectionList = footerSectionRepository.findAll();
        assertThat(footerSectionList).hasSize(databaseSizeBeforeUpdate);
        FooterSection testFooterSection = footerSectionList.get(footerSectionList.size() - 1);
        assertThat(testFooterSection.getTitreEn()).isEqualTo(UPDATED_TITRE_EN);
        assertThat(testFooterSection.getTitreGer()).isEqualTo(UPDATED_TITRE_GER);
        assertThat(testFooterSection.getTitreFr()).isEqualTo(UPDATED_TITRE_FR);
        assertThat(testFooterSection.getTitreSw()).isEqualTo(UPDATED_TITRE_SW);
        assertThat(testFooterSection.getSousTitreEn()).isEqualTo(UPDATED_SOUS_TITRE_EN);
        assertThat(testFooterSection.getSousTitreGer()).isEqualTo(UPDATED_SOUS_TITRE_GER);
        assertThat(testFooterSection.getSousTitreFr()).isEqualTo(UPDATED_SOUS_TITRE_FR);
        assertThat(testFooterSection.getSousTitreSw()).isEqualTo(UPDATED_SOUS_TITRE_SW);
        assertThat(testFooterSection.getLogo()).isEqualTo(UPDATED_LOGO);
        assertThat(testFooterSection.getLogoContentType()).isEqualTo(UPDATED_LOGO_CONTENT_TYPE);
        assertThat(testFooterSection.getTexteBouton()).isEqualTo(UPDATED_TEXTE_BOUTON);
        assertThat(testFooterSection.getTwitterlink()).isEqualTo(UPDATED_TWITTERLINK);
        assertThat(testFooterSection.getDiscordLink()).isEqualTo(UPDATED_DISCORD_LINK);
    }

    @Test
    @Transactional
    public void updateNonExistingFooterSection() throws Exception {
        int databaseSizeBeforeUpdate = footerSectionRepository.findAll().size();

        // Create the FooterSection

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restFooterSectionMockMvc.perform(put("/api/footer-sections")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(footerSection)))
            .andExpect(status().isBadRequest());

        // Validate the FooterSection in the database
        List<FooterSection> footerSectionList = footerSectionRepository.findAll();
        assertThat(footerSectionList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteFooterSection() throws Exception {
        // Initialize the database
        footerSectionRepository.saveAndFlush(footerSection);

        int databaseSizeBeforeDelete = footerSectionRepository.findAll().size();

        // Delete the footerSection
        restFooterSectionMockMvc.perform(delete("/api/footer-sections/{id}", footerSection.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<FooterSection> footerSectionList = footerSectionRepository.findAll();
        assertThat(footerSectionList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
