package com.iota.orign.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DernieresNouvelles.
 */
@Entity
@Table(name = "dernieres_nouvelles")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class DernieresNouvelles implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titre_fr")
    private String titreFr;

    @Column(name = "titre_en")
    private String titreEn;

    @Column(name = "titre_ger")
    private String titreGer;

    @Column(name = "titre_sw")
    private String titreSw;

    @Column(name = "sous_titre_fr")
    private String sousTitreFr;

    @Column(name = "sous_titre_en")
    private String sousTitreEn;

    @Column(name = "sous_titre_ger")
    private String sousTitreGer;

    @Column(name = "sous_titre_sw")
    private String sousTitreSw;

    @Column(name = "titre_slide_1_fr")
    private String titreSlide1Fr;

    @Column(name = "titre_slide_1_en")
    private String titreSlide1En;

    @Column(name = "titre_slide_1_ger")
    private String titreSlide1Ger;

    @Column(name = "titre_slide_1_sw")
    private String titreSlide1Sw;

    @Column(name = "titre_slide_2_fr")
    private String titreSlide2Fr;

    @Column(name = "titre_slide_2_en")
    private String titreSlide2En;

    @Column(name = "titre_slide_2_ger")
    private String titreSlide2Ger;

    @Column(name = "titre_slide_2_sw")
    private String titreSlide2Sw;

    @Column(name = "titre_slide_3_fr")
    private String titreSlide3Fr;

    @Column(name = "titre_slide_3_en")
    private String titreSlide3En;

    @Column(name = "titre_slide_3_ger")
    private String titreSlide3Ger;

    @Column(name = "titre_slide_3_sw")
    private String titreSlide3Sw;

    @Column(name = "titre_slide_4_fr")
    private String titreSlide4Fr;

    @Column(name = "titre_slide_4_en")
    private String titreSlide4En;

    @Column(name = "titre_slide_4_ger")
    private String titreSlide4Ger;

    @Column(name = "titre_slide_4_sw")
    private String titreSlide4Sw;

    @Column(name = "titre_slide_5_fr")
    private String titreSlide5Fr;

    @Column(name = "titre_slide_5_en")
    private String titreSlide5En;

    @Column(name = "titre_slide_5_ger")
    private String titreSlide5Ger;

    @Column(name = "titre_slide_5_sw")
    private String titreSlide5Sw;

    @Column(name = "titre_slide_6_fr")
    private String titreSlide6Fr;

    @Column(name = "titre_slide_6_en")
    private String titreSlide6En;

    @Column(name = "titre_slide_6_ger")
    private String titreSlide6Ger;

    @Column(name = "titre_slide_6_sw")
    private String titreSlide6Sw;

    @Column(name = "titre_slide_7_fr")
    private String titreSlide7Fr;

    @Column(name = "titre_slide_7_en")
    private String titreSlide7En;

    @Column(name = "titre_slide_7_ger")
    private String titreSlide7Ger;

    @Column(name = "titre_slide_7_sw")
    private String titreSlide7Sw;

    @Column(name = "titre_slide_8_fr")
    private String titreSlide8Fr;

    @Column(name = "titre_slide_8_en")
    private String titreSlide8En;

    @Column(name = "titre_slide_8_ger")
    private String titreSlide8Ger;

    @Column(name = "titre_slide_8_sw")
    private String titreSlide8Sw;

    @Column(name = "titre_slide_9_fr")
    private String titreSlide9Fr;

    @Column(name = "titre_slide_9_en")
    private String titreSlide9En;

    @Column(name = "titre_slide_9_ger")
    private String titreSlide9Ger;

    @Column(name = "titre_slide_9_sw")
    private String titreSlide9Sw;

    @Column(name = "titre_slide_1_o_fr")
    private String titreSlide1OFr;

    @Column(name = "titre_slide_1_o_en")
    private String titreSlide1OEn;

    @Column(name = "titre_slide_1_o_ger")
    private String titreSlide1OGer;

    @Column(name = "titre_slide_1_o_sw")
    private String titreSlide1OSw;

    @Column(name = "text_slide_1_fr")
    private String textSlide1Fr;

    @Column(name = "text_slide_1_en")
    private String textSlide1En;

    @Column(name = "text_slide_1_ger")
    private String textSlide1Ger;

    @Column(name = "text_slide_1_sw")
    private String textSlide1Sw;

    @Column(name = "text_slide_2_fr")
    private String textSlide2Fr;

    @Column(name = "text_slide_2_en")
    private String textSlide2En;

    @Column(name = "text_slide_2_ger")
    private String textSlide2Ger;

    @Column(name = "text_slide_2_sw")
    private String textSlide2Sw;

    @Column(name = "text_slide_3_fr")
    private String textSlide3Fr;

    @Column(name = "text_slide_3_en")
    private String textSlide3En;

    @Column(name = "text_slide_3_ger")
    private String textSlide3Ger;

    @Column(name = "text_slide_3_sw")
    private String textSlide3Sw;

    @Column(name = "text_slide_4_fr")
    private String textSlide4Fr;

    @Column(name = "text_slide_4_en")
    private String textSlide4En;

    @Column(name = "text_slide_4_ger")
    private String textSlide4Ger;

    @Column(name = "text_slide_4_sw")
    private String textSlide4Sw;

    @Column(name = "text_slide_5_fr")
    private String textSlide5Fr;

    @Column(name = "text_slide_5_en")
    private String textSlide5En;

    @Column(name = "text_slide_5_ger")
    private String textSlide5Ger;

    @Column(name = "text_slide_5_sw")
    private String textSlide5Sw;

    @Column(name = "text_slide_6_fr")
    private String textSlide6Fr;

    @Column(name = "text_slide_6_en")
    private String textSlide6En;

    @Column(name = "text_slide_6_ger")
    private String textSlide6Ger;

    @Column(name = "text_slide_6_sw")
    private String textSlide6Sw;

    @Column(name = "text_slide_7_fr")
    private String textSlide7Fr;

    @Column(name = "text_slide_7_en")
    private String textSlide7En;

    @Column(name = "text_slide_7_ger")
    private String textSlide7Ger;

    @Column(name = "text_slide_7_sw")
    private String textSlide7Sw;

    @Column(name = "text_slide_8_fr")
    private String textSlide8Fr;

    @Column(name = "text_slide_8_en")
    private String textSlide8En;

    @Column(name = "text_slide_8_ger")
    private String textSlide8Ger;

    @Column(name = "text_slide_8_sw")
    private String textSlide8Sw;

    @Column(name = "text_slide_9_fr")
    private String textSlide9Fr;

    @Column(name = "text_slide_9_en")
    private String textSlide9En;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitreFr() {
        return titreFr;
    }

    public DernieresNouvelles titreFr(String titreFr) {
        this.titreFr = titreFr;
        return this;
    }

    public void setTitreFr(String titreFr) {
        this.titreFr = titreFr;
    }

    public String getTitreEn() {
        return titreEn;
    }

    public DernieresNouvelles titreEn(String titreEn) {
        this.titreEn = titreEn;
        return this;
    }

    public void setTitreEn(String titreEn) {
        this.titreEn = titreEn;
    }

    public String getTitreGer() {
        return titreGer;
    }

    public DernieresNouvelles titreGer(String titreGer) {
        this.titreGer = titreGer;
        return this;
    }

    public void setTitreGer(String titreGer) {
        this.titreGer = titreGer;
    }

    public String getTitreSw() {
        return titreSw;
    }

    public DernieresNouvelles titreSw(String titreSw) {
        this.titreSw = titreSw;
        return this;
    }

    public void setTitreSw(String titreSw) {
        this.titreSw = titreSw;
    }

    public String getSousTitreFr() {
        return sousTitreFr;
    }

    public DernieresNouvelles sousTitreFr(String sousTitreFr) {
        this.sousTitreFr = sousTitreFr;
        return this;
    }

    public void setSousTitreFr(String sousTitreFr) {
        this.sousTitreFr = sousTitreFr;
    }

    public String getSousTitreEn() {
        return sousTitreEn;
    }

    public DernieresNouvelles sousTitreEn(String sousTitreEn) {
        this.sousTitreEn = sousTitreEn;
        return this;
    }

    public void setSousTitreEn(String sousTitreEn) {
        this.sousTitreEn = sousTitreEn;
    }

    public String getSousTitreGer() {
        return sousTitreGer;
    }

    public DernieresNouvelles sousTitreGer(String sousTitreGer) {
        this.sousTitreGer = sousTitreGer;
        return this;
    }

    public void setSousTitreGer(String sousTitreGer) {
        this.sousTitreGer = sousTitreGer;
    }

    public String getSousTitreSw() {
        return sousTitreSw;
    }

    public DernieresNouvelles sousTitreSw(String sousTitreSw) {
        this.sousTitreSw = sousTitreSw;
        return this;
    }

    public void setSousTitreSw(String sousTitreSw) {
        this.sousTitreSw = sousTitreSw;
    }

    public String getTitreSlide1Fr() {
        return titreSlide1Fr;
    }

    public DernieresNouvelles titreSlide1Fr(String titreSlide1Fr) {
        this.titreSlide1Fr = titreSlide1Fr;
        return this;
    }

    public void setTitreSlide1Fr(String titreSlide1Fr) {
        this.titreSlide1Fr = titreSlide1Fr;
    }

    public String getTitreSlide1En() {
        return titreSlide1En;
    }

    public DernieresNouvelles titreSlide1En(String titreSlide1En) {
        this.titreSlide1En = titreSlide1En;
        return this;
    }

    public void setTitreSlide1En(String titreSlide1En) {
        this.titreSlide1En = titreSlide1En;
    }

    public String getTitreSlide1Ger() {
        return titreSlide1Ger;
    }

    public DernieresNouvelles titreSlide1Ger(String titreSlide1Ger) {
        this.titreSlide1Ger = titreSlide1Ger;
        return this;
    }

    public void setTitreSlide1Ger(String titreSlide1Ger) {
        this.titreSlide1Ger = titreSlide1Ger;
    }

    public String getTitreSlide1Sw() {
        return titreSlide1Sw;
    }

    public DernieresNouvelles titreSlide1Sw(String titreSlide1Sw) {
        this.titreSlide1Sw = titreSlide1Sw;
        return this;
    }

    public void setTitreSlide1Sw(String titreSlide1Sw) {
        this.titreSlide1Sw = titreSlide1Sw;
    }

    public String getTitreSlide2Fr() {
        return titreSlide2Fr;
    }

    public DernieresNouvelles titreSlide2Fr(String titreSlide2Fr) {
        this.titreSlide2Fr = titreSlide2Fr;
        return this;
    }

    public void setTitreSlide2Fr(String titreSlide2Fr) {
        this.titreSlide2Fr = titreSlide2Fr;
    }

    public String getTitreSlide2En() {
        return titreSlide2En;
    }

    public DernieresNouvelles titreSlide2En(String titreSlide2En) {
        this.titreSlide2En = titreSlide2En;
        return this;
    }

    public void setTitreSlide2En(String titreSlide2En) {
        this.titreSlide2En = titreSlide2En;
    }

    public String getTitreSlide2Ger() {
        return titreSlide2Ger;
    }

    public DernieresNouvelles titreSlide2Ger(String titreSlide2Ger) {
        this.titreSlide2Ger = titreSlide2Ger;
        return this;
    }

    public void setTitreSlide2Ger(String titreSlide2Ger) {
        this.titreSlide2Ger = titreSlide2Ger;
    }

    public String getTitreSlide2Sw() {
        return titreSlide2Sw;
    }

    public DernieresNouvelles titreSlide2Sw(String titreSlide2Sw) {
        this.titreSlide2Sw = titreSlide2Sw;
        return this;
    }

    public void setTitreSlide2Sw(String titreSlide2Sw) {
        this.titreSlide2Sw = titreSlide2Sw;
    }

    public String getTitreSlide3Fr() {
        return titreSlide3Fr;
    }

    public DernieresNouvelles titreSlide3Fr(String titreSlide3Fr) {
        this.titreSlide3Fr = titreSlide3Fr;
        return this;
    }

    public void setTitreSlide3Fr(String titreSlide3Fr) {
        this.titreSlide3Fr = titreSlide3Fr;
    }

    public String getTitreSlide3En() {
        return titreSlide3En;
    }

    public DernieresNouvelles titreSlide3En(String titreSlide3En) {
        this.titreSlide3En = titreSlide3En;
        return this;
    }

    public void setTitreSlide3En(String titreSlide3En) {
        this.titreSlide3En = titreSlide3En;
    }

    public String getTitreSlide3Ger() {
        return titreSlide3Ger;
    }

    public DernieresNouvelles titreSlide3Ger(String titreSlide3Ger) {
        this.titreSlide3Ger = titreSlide3Ger;
        return this;
    }

    public void setTitreSlide3Ger(String titreSlide3Ger) {
        this.titreSlide3Ger = titreSlide3Ger;
    }

    public String getTitreSlide3Sw() {
        return titreSlide3Sw;
    }

    public DernieresNouvelles titreSlide3Sw(String titreSlide3Sw) {
        this.titreSlide3Sw = titreSlide3Sw;
        return this;
    }

    public void setTitreSlide3Sw(String titreSlide3Sw) {
        this.titreSlide3Sw = titreSlide3Sw;
    }

    public String getTitreSlide4Fr() {
        return titreSlide4Fr;
    }

    public DernieresNouvelles titreSlide4Fr(String titreSlide4Fr) {
        this.titreSlide4Fr = titreSlide4Fr;
        return this;
    }

    public void setTitreSlide4Fr(String titreSlide4Fr) {
        this.titreSlide4Fr = titreSlide4Fr;
    }

    public String getTitreSlide4En() {
        return titreSlide4En;
    }

    public DernieresNouvelles titreSlide4En(String titreSlide4En) {
        this.titreSlide4En = titreSlide4En;
        return this;
    }

    public void setTitreSlide4En(String titreSlide4En) {
        this.titreSlide4En = titreSlide4En;
    }

    public String getTitreSlide4Ger() {
        return titreSlide4Ger;
    }

    public DernieresNouvelles titreSlide4Ger(String titreSlide4Ger) {
        this.titreSlide4Ger = titreSlide4Ger;
        return this;
    }

    public void setTitreSlide4Ger(String titreSlide4Ger) {
        this.titreSlide4Ger = titreSlide4Ger;
    }

    public String getTitreSlide4Sw() {
        return titreSlide4Sw;
    }

    public DernieresNouvelles titreSlide4Sw(String titreSlide4Sw) {
        this.titreSlide4Sw = titreSlide4Sw;
        return this;
    }

    public void setTitreSlide4Sw(String titreSlide4Sw) {
        this.titreSlide4Sw = titreSlide4Sw;
    }

    public String getTitreSlide5Fr() {
        return titreSlide5Fr;
    }

    public DernieresNouvelles titreSlide5Fr(String titreSlide5Fr) {
        this.titreSlide5Fr = titreSlide5Fr;
        return this;
    }

    public void setTitreSlide5Fr(String titreSlide5Fr) {
        this.titreSlide5Fr = titreSlide5Fr;
    }

    public String getTitreSlide5En() {
        return titreSlide5En;
    }

    public DernieresNouvelles titreSlide5En(String titreSlide5En) {
        this.titreSlide5En = titreSlide5En;
        return this;
    }

    public void setTitreSlide5En(String titreSlide5En) {
        this.titreSlide5En = titreSlide5En;
    }

    public String getTitreSlide5Ger() {
        return titreSlide5Ger;
    }

    public DernieresNouvelles titreSlide5Ger(String titreSlide5Ger) {
        this.titreSlide5Ger = titreSlide5Ger;
        return this;
    }

    public void setTitreSlide5Ger(String titreSlide5Ger) {
        this.titreSlide5Ger = titreSlide5Ger;
    }

    public String getTitreSlide5Sw() {
        return titreSlide5Sw;
    }

    public DernieresNouvelles titreSlide5Sw(String titreSlide5Sw) {
        this.titreSlide5Sw = titreSlide5Sw;
        return this;
    }

    public void setTitreSlide5Sw(String titreSlide5Sw) {
        this.titreSlide5Sw = titreSlide5Sw;
    }

    public String getTitreSlide6Fr() {
        return titreSlide6Fr;
    }

    public DernieresNouvelles titreSlide6Fr(String titreSlide6Fr) {
        this.titreSlide6Fr = titreSlide6Fr;
        return this;
    }

    public void setTitreSlide6Fr(String titreSlide6Fr) {
        this.titreSlide6Fr = titreSlide6Fr;
    }

    public String getTitreSlide6En() {
        return titreSlide6En;
    }

    public DernieresNouvelles titreSlide6En(String titreSlide6En) {
        this.titreSlide6En = titreSlide6En;
        return this;
    }

    public void setTitreSlide6En(String titreSlide6En) {
        this.titreSlide6En = titreSlide6En;
    }

    public String getTitreSlide6Ger() {
        return titreSlide6Ger;
    }

    public DernieresNouvelles titreSlide6Ger(String titreSlide6Ger) {
        this.titreSlide6Ger = titreSlide6Ger;
        return this;
    }

    public void setTitreSlide6Ger(String titreSlide6Ger) {
        this.titreSlide6Ger = titreSlide6Ger;
    }

    public String getTitreSlide6Sw() {
        return titreSlide6Sw;
    }

    public DernieresNouvelles titreSlide6Sw(String titreSlide6Sw) {
        this.titreSlide6Sw = titreSlide6Sw;
        return this;
    }

    public void setTitreSlide6Sw(String titreSlide6Sw) {
        this.titreSlide6Sw = titreSlide6Sw;
    }

    public String getTitreSlide7Fr() {
        return titreSlide7Fr;
    }

    public DernieresNouvelles titreSlide7Fr(String titreSlide7Fr) {
        this.titreSlide7Fr = titreSlide7Fr;
        return this;
    }

    public void setTitreSlide7Fr(String titreSlide7Fr) {
        this.titreSlide7Fr = titreSlide7Fr;
    }

    public String getTitreSlide7En() {
        return titreSlide7En;
    }

    public DernieresNouvelles titreSlide7En(String titreSlide7En) {
        this.titreSlide7En = titreSlide7En;
        return this;
    }

    public void setTitreSlide7En(String titreSlide7En) {
        this.titreSlide7En = titreSlide7En;
    }

    public String getTitreSlide7Ger() {
        return titreSlide7Ger;
    }

    public DernieresNouvelles titreSlide7Ger(String titreSlide7Ger) {
        this.titreSlide7Ger = titreSlide7Ger;
        return this;
    }

    public void setTitreSlide7Ger(String titreSlide7Ger) {
        this.titreSlide7Ger = titreSlide7Ger;
    }

    public String getTitreSlide7Sw() {
        return titreSlide7Sw;
    }

    public DernieresNouvelles titreSlide7Sw(String titreSlide7Sw) {
        this.titreSlide7Sw = titreSlide7Sw;
        return this;
    }

    public void setTitreSlide7Sw(String titreSlide7Sw) {
        this.titreSlide7Sw = titreSlide7Sw;
    }

    public String getTitreSlide8Fr() {
        return titreSlide8Fr;
    }

    public DernieresNouvelles titreSlide8Fr(String titreSlide8Fr) {
        this.titreSlide8Fr = titreSlide8Fr;
        return this;
    }

    public void setTitreSlide8Fr(String titreSlide8Fr) {
        this.titreSlide8Fr = titreSlide8Fr;
    }

    public String getTitreSlide8En() {
        return titreSlide8En;
    }

    public DernieresNouvelles titreSlide8En(String titreSlide8En) {
        this.titreSlide8En = titreSlide8En;
        return this;
    }

    public void setTitreSlide8En(String titreSlide8En) {
        this.titreSlide8En = titreSlide8En;
    }

    public String getTitreSlide8Ger() {
        return titreSlide8Ger;
    }

    public DernieresNouvelles titreSlide8Ger(String titreSlide8Ger) {
        this.titreSlide8Ger = titreSlide8Ger;
        return this;
    }

    public void setTitreSlide8Ger(String titreSlide8Ger) {
        this.titreSlide8Ger = titreSlide8Ger;
    }

    public String getTitreSlide8Sw() {
        return titreSlide8Sw;
    }

    public DernieresNouvelles titreSlide8Sw(String titreSlide8Sw) {
        this.titreSlide8Sw = titreSlide8Sw;
        return this;
    }

    public void setTitreSlide8Sw(String titreSlide8Sw) {
        this.titreSlide8Sw = titreSlide8Sw;
    }

    public String getTitreSlide9Fr() {
        return titreSlide9Fr;
    }

    public DernieresNouvelles titreSlide9Fr(String titreSlide9Fr) {
        this.titreSlide9Fr = titreSlide9Fr;
        return this;
    }

    public void setTitreSlide9Fr(String titreSlide9Fr) {
        this.titreSlide9Fr = titreSlide9Fr;
    }

    public String getTitreSlide9En() {
        return titreSlide9En;
    }

    public DernieresNouvelles titreSlide9En(String titreSlide9En) {
        this.titreSlide9En = titreSlide9En;
        return this;
    }

    public void setTitreSlide9En(String titreSlide9En) {
        this.titreSlide9En = titreSlide9En;
    }

    public String getTitreSlide9Ger() {
        return titreSlide9Ger;
    }

    public DernieresNouvelles titreSlide9Ger(String titreSlide9Ger) {
        this.titreSlide9Ger = titreSlide9Ger;
        return this;
    }

    public void setTitreSlide9Ger(String titreSlide9Ger) {
        this.titreSlide9Ger = titreSlide9Ger;
    }

    public String getTitreSlide9Sw() {
        return titreSlide9Sw;
    }

    public DernieresNouvelles titreSlide9Sw(String titreSlide9Sw) {
        this.titreSlide9Sw = titreSlide9Sw;
        return this;
    }

    public void setTitreSlide9Sw(String titreSlide9Sw) {
        this.titreSlide9Sw = titreSlide9Sw;
    }

    public String getTitreSlide1OFr() {
        return titreSlide1OFr;
    }

    public DernieresNouvelles titreSlide1OFr(String titreSlide1OFr) {
        this.titreSlide1OFr = titreSlide1OFr;
        return this;
    }

    public void setTitreSlide1OFr(String titreSlide1OFr) {
        this.titreSlide1OFr = titreSlide1OFr;
    }

    public String getTitreSlide1OEn() {
        return titreSlide1OEn;
    }

    public DernieresNouvelles titreSlide1OEn(String titreSlide1OEn) {
        this.titreSlide1OEn = titreSlide1OEn;
        return this;
    }

    public void setTitreSlide1OEn(String titreSlide1OEn) {
        this.titreSlide1OEn = titreSlide1OEn;
    }

    public String getTitreSlide1OGer() {
        return titreSlide1OGer;
    }

    public DernieresNouvelles titreSlide1OGer(String titreSlide1OGer) {
        this.titreSlide1OGer = titreSlide1OGer;
        return this;
    }

    public void setTitreSlide1OGer(String titreSlide1OGer) {
        this.titreSlide1OGer = titreSlide1OGer;
    }

    public String getTitreSlide1OSw() {
        return titreSlide1OSw;
    }

    public DernieresNouvelles titreSlide1OSw(String titreSlide1OSw) {
        this.titreSlide1OSw = titreSlide1OSw;
        return this;
    }

    public void setTitreSlide1OSw(String titreSlide1OSw) {
        this.titreSlide1OSw = titreSlide1OSw;
    }

    public String getTextSlide1Fr() {
        return textSlide1Fr;
    }

    public DernieresNouvelles textSlide1Fr(String textSlide1Fr) {
        this.textSlide1Fr = textSlide1Fr;
        return this;
    }

    public void setTextSlide1Fr(String textSlide1Fr) {
        this.textSlide1Fr = textSlide1Fr;
    }

    public String getTextSlide1En() {
        return textSlide1En;
    }

    public DernieresNouvelles textSlide1En(String textSlide1En) {
        this.textSlide1En = textSlide1En;
        return this;
    }

    public void setTextSlide1En(String textSlide1En) {
        this.textSlide1En = textSlide1En;
    }

    public String getTextSlide1Ger() {
        return textSlide1Ger;
    }

    public DernieresNouvelles textSlide1Ger(String textSlide1Ger) {
        this.textSlide1Ger = textSlide1Ger;
        return this;
    }

    public void setTextSlide1Ger(String textSlide1Ger) {
        this.textSlide1Ger = textSlide1Ger;
    }

    public String getTextSlide1Sw() {
        return textSlide1Sw;
    }

    public DernieresNouvelles textSlide1Sw(String textSlide1Sw) {
        this.textSlide1Sw = textSlide1Sw;
        return this;
    }

    public void setTextSlide1Sw(String textSlide1Sw) {
        this.textSlide1Sw = textSlide1Sw;
    }

    public String getTextSlide2Fr() {
        return textSlide2Fr;
    }

    public DernieresNouvelles textSlide2Fr(String textSlide2Fr) {
        this.textSlide2Fr = textSlide2Fr;
        return this;
    }

    public void setTextSlide2Fr(String textSlide2Fr) {
        this.textSlide2Fr = textSlide2Fr;
    }

    public String getTextSlide2En() {
        return textSlide2En;
    }

    public DernieresNouvelles textSlide2En(String textSlide2En) {
        this.textSlide2En = textSlide2En;
        return this;
    }

    public void setTextSlide2En(String textSlide2En) {
        this.textSlide2En = textSlide2En;
    }

    public String getTextSlide2Ger() {
        return textSlide2Ger;
    }

    public DernieresNouvelles textSlide2Ger(String textSlide2Ger) {
        this.textSlide2Ger = textSlide2Ger;
        return this;
    }

    public void setTextSlide2Ger(String textSlide2Ger) {
        this.textSlide2Ger = textSlide2Ger;
    }

    public String getTextSlide2Sw() {
        return textSlide2Sw;
    }

    public DernieresNouvelles textSlide2Sw(String textSlide2Sw) {
        this.textSlide2Sw = textSlide2Sw;
        return this;
    }

    public void setTextSlide2Sw(String textSlide2Sw) {
        this.textSlide2Sw = textSlide2Sw;
    }

    public String getTextSlide3Fr() {
        return textSlide3Fr;
    }

    public DernieresNouvelles textSlide3Fr(String textSlide3Fr) {
        this.textSlide3Fr = textSlide3Fr;
        return this;
    }

    public void setTextSlide3Fr(String textSlide3Fr) {
        this.textSlide3Fr = textSlide3Fr;
    }

    public String getTextSlide3En() {
        return textSlide3En;
    }

    public DernieresNouvelles textSlide3En(String textSlide3En) {
        this.textSlide3En = textSlide3En;
        return this;
    }

    public void setTextSlide3En(String textSlide3En) {
        this.textSlide3En = textSlide3En;
    }

    public String getTextSlide3Ger() {
        return textSlide3Ger;
    }

    public DernieresNouvelles textSlide3Ger(String textSlide3Ger) {
        this.textSlide3Ger = textSlide3Ger;
        return this;
    }

    public void setTextSlide3Ger(String textSlide3Ger) {
        this.textSlide3Ger = textSlide3Ger;
    }

    public String getTextSlide3Sw() {
        return textSlide3Sw;
    }

    public DernieresNouvelles textSlide3Sw(String textSlide3Sw) {
        this.textSlide3Sw = textSlide3Sw;
        return this;
    }

    public void setTextSlide3Sw(String textSlide3Sw) {
        this.textSlide3Sw = textSlide3Sw;
    }

    public String getTextSlide4Fr() {
        return textSlide4Fr;
    }

    public DernieresNouvelles textSlide4Fr(String textSlide4Fr) {
        this.textSlide4Fr = textSlide4Fr;
        return this;
    }

    public void setTextSlide4Fr(String textSlide4Fr) {
        this.textSlide4Fr = textSlide4Fr;
    }

    public String getTextSlide4En() {
        return textSlide4En;
    }

    public DernieresNouvelles textSlide4En(String textSlide4En) {
        this.textSlide4En = textSlide4En;
        return this;
    }

    public void setTextSlide4En(String textSlide4En) {
        this.textSlide4En = textSlide4En;
    }

    public String getTextSlide4Ger() {
        return textSlide4Ger;
    }

    public DernieresNouvelles textSlide4Ger(String textSlide4Ger) {
        this.textSlide4Ger = textSlide4Ger;
        return this;
    }

    public void setTextSlide4Ger(String textSlide4Ger) {
        this.textSlide4Ger = textSlide4Ger;
    }

    public String getTextSlide4Sw() {
        return textSlide4Sw;
    }

    public DernieresNouvelles textSlide4Sw(String textSlide4Sw) {
        this.textSlide4Sw = textSlide4Sw;
        return this;
    }

    public void setTextSlide4Sw(String textSlide4Sw) {
        this.textSlide4Sw = textSlide4Sw;
    }

    public String getTextSlide5Fr() {
        return textSlide5Fr;
    }

    public DernieresNouvelles textSlide5Fr(String textSlide5Fr) {
        this.textSlide5Fr = textSlide5Fr;
        return this;
    }

    public void setTextSlide5Fr(String textSlide5Fr) {
        this.textSlide5Fr = textSlide5Fr;
    }

    public String getTextSlide5En() {
        return textSlide5En;
    }

    public DernieresNouvelles textSlide5En(String textSlide5En) {
        this.textSlide5En = textSlide5En;
        return this;
    }

    public void setTextSlide5En(String textSlide5En) {
        this.textSlide5En = textSlide5En;
    }

    public String getTextSlide5Ger() {
        return textSlide5Ger;
    }

    public DernieresNouvelles textSlide5Ger(String textSlide5Ger) {
        this.textSlide5Ger = textSlide5Ger;
        return this;
    }

    public void setTextSlide5Ger(String textSlide5Ger) {
        this.textSlide5Ger = textSlide5Ger;
    }

    public String getTextSlide5Sw() {
        return textSlide5Sw;
    }

    public DernieresNouvelles textSlide5Sw(String textSlide5Sw) {
        this.textSlide5Sw = textSlide5Sw;
        return this;
    }

    public void setTextSlide5Sw(String textSlide5Sw) {
        this.textSlide5Sw = textSlide5Sw;
    }

    public String getTextSlide6Fr() {
        return textSlide6Fr;
    }

    public DernieresNouvelles textSlide6Fr(String textSlide6Fr) {
        this.textSlide6Fr = textSlide6Fr;
        return this;
    }

    public void setTextSlide6Fr(String textSlide6Fr) {
        this.textSlide6Fr = textSlide6Fr;
    }

    public String getTextSlide6En() {
        return textSlide6En;
    }

    public DernieresNouvelles textSlide6En(String textSlide6En) {
        this.textSlide6En = textSlide6En;
        return this;
    }

    public void setTextSlide6En(String textSlide6En) {
        this.textSlide6En = textSlide6En;
    }

    public String getTextSlide6Ger() {
        return textSlide6Ger;
    }

    public DernieresNouvelles textSlide6Ger(String textSlide6Ger) {
        this.textSlide6Ger = textSlide6Ger;
        return this;
    }

    public void setTextSlide6Ger(String textSlide6Ger) {
        this.textSlide6Ger = textSlide6Ger;
    }

    public String getTextSlide6Sw() {
        return textSlide6Sw;
    }

    public DernieresNouvelles textSlide6Sw(String textSlide6Sw) {
        this.textSlide6Sw = textSlide6Sw;
        return this;
    }

    public void setTextSlide6Sw(String textSlide6Sw) {
        this.textSlide6Sw = textSlide6Sw;
    }

    public String getTextSlide7Fr() {
        return textSlide7Fr;
    }

    public DernieresNouvelles textSlide7Fr(String textSlide7Fr) {
        this.textSlide7Fr = textSlide7Fr;
        return this;
    }

    public void setTextSlide7Fr(String textSlide7Fr) {
        this.textSlide7Fr = textSlide7Fr;
    }

    public String getTextSlide7En() {
        return textSlide7En;
    }

    public DernieresNouvelles textSlide7En(String textSlide7En) {
        this.textSlide7En = textSlide7En;
        return this;
    }

    public void setTextSlide7En(String textSlide7En) {
        this.textSlide7En = textSlide7En;
    }

    public String getTextSlide7Ger() {
        return textSlide7Ger;
    }

    public DernieresNouvelles textSlide7Ger(String textSlide7Ger) {
        this.textSlide7Ger = textSlide7Ger;
        return this;
    }

    public void setTextSlide7Ger(String textSlide7Ger) {
        this.textSlide7Ger = textSlide7Ger;
    }

    public String getTextSlide7Sw() {
        return textSlide7Sw;
    }

    public DernieresNouvelles textSlide7Sw(String textSlide7Sw) {
        this.textSlide7Sw = textSlide7Sw;
        return this;
    }

    public void setTextSlide7Sw(String textSlide7Sw) {
        this.textSlide7Sw = textSlide7Sw;
    }

    public String getTextSlide8Fr() {
        return textSlide8Fr;
    }

    public DernieresNouvelles textSlide8Fr(String textSlide8Fr) {
        this.textSlide8Fr = textSlide8Fr;
        return this;
    }

    public void setTextSlide8Fr(String textSlide8Fr) {
        this.textSlide8Fr = textSlide8Fr;
    }

    public String getTextSlide8En() {
        return textSlide8En;
    }

    public DernieresNouvelles textSlide8En(String textSlide8En) {
        this.textSlide8En = textSlide8En;
        return this;
    }

    public void setTextSlide8En(String textSlide8En) {
        this.textSlide8En = textSlide8En;
    }

    public String getTextSlide8Ger() {
        return textSlide8Ger;
    }

    public DernieresNouvelles textSlide8Ger(String textSlide8Ger) {
        this.textSlide8Ger = textSlide8Ger;
        return this;
    }

    public void setTextSlide8Ger(String textSlide8Ger) {
        this.textSlide8Ger = textSlide8Ger;
    }

    public String getTextSlide8Sw() {
        return textSlide8Sw;
    }

    public DernieresNouvelles textSlide8Sw(String textSlide8Sw) {
        this.textSlide8Sw = textSlide8Sw;
        return this;
    }

    public void setTextSlide8Sw(String textSlide8Sw) {
        this.textSlide8Sw = textSlide8Sw;
    }

    public String getTextSlide9Fr() {
        return textSlide9Fr;
    }

    public DernieresNouvelles textSlide9Fr(String textSlide9Fr) {
        this.textSlide9Fr = textSlide9Fr;
        return this;
    }

    public void setTextSlide9Fr(String textSlide9Fr) {
        this.textSlide9Fr = textSlide9Fr;
    }

    public String getTextSlide9En() {
        return textSlide9En;
    }

    public DernieresNouvelles textSlide9En(String textSlide9En) {
        this.textSlide9En = textSlide9En;
        return this;
    }

    public void setTextSlide9En(String textSlide9En) {
        this.textSlide9En = textSlide9En;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DernieresNouvelles)) {
            return false;
        }
        return id != null && id.equals(((DernieresNouvelles) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "DernieresNouvelles{" +
            "id=" + getId() +
            ", titreFr='" + getTitreFr() + "'" +
            ", titreEn='" + getTitreEn() + "'" +
            ", titreGer='" + getTitreGer() + "'" +
            ", titreSw='" + getTitreSw() + "'" +
            ", sousTitreFr='" + getSousTitreFr() + "'" +
            ", sousTitreEn='" + getSousTitreEn() + "'" +
            ", sousTitreGer='" + getSousTitreGer() + "'" +
            ", sousTitreSw='" + getSousTitreSw() + "'" +
            ", titreSlide1Fr='" + getTitreSlide1Fr() + "'" +
            ", titreSlide1En='" + getTitreSlide1En() + "'" +
            ", titreSlide1Ger='" + getTitreSlide1Ger() + "'" +
            ", titreSlide1Sw='" + getTitreSlide1Sw() + "'" +
            ", titreSlide2Fr='" + getTitreSlide2Fr() + "'" +
            ", titreSlide2En='" + getTitreSlide2En() + "'" +
            ", titreSlide2Ger='" + getTitreSlide2Ger() + "'" +
            ", titreSlide2Sw='" + getTitreSlide2Sw() + "'" +
            ", titreSlide3Fr='" + getTitreSlide3Fr() + "'" +
            ", titreSlide3En='" + getTitreSlide3En() + "'" +
            ", titreSlide3Ger='" + getTitreSlide3Ger() + "'" +
            ", titreSlide3Sw='" + getTitreSlide3Sw() + "'" +
            ", titreSlide4Fr='" + getTitreSlide4Fr() + "'" +
            ", titreSlide4En='" + getTitreSlide4En() + "'" +
            ", titreSlide4Ger='" + getTitreSlide4Ger() + "'" +
            ", titreSlide4Sw='" + getTitreSlide4Sw() + "'" +
            ", titreSlide5Fr='" + getTitreSlide5Fr() + "'" +
            ", titreSlide5En='" + getTitreSlide5En() + "'" +
            ", titreSlide5Ger='" + getTitreSlide5Ger() + "'" +
            ", titreSlide5Sw='" + getTitreSlide5Sw() + "'" +
            ", titreSlide6Fr='" + getTitreSlide6Fr() + "'" +
            ", titreSlide6En='" + getTitreSlide6En() + "'" +
            ", titreSlide6Ger='" + getTitreSlide6Ger() + "'" +
            ", titreSlide6Sw='" + getTitreSlide6Sw() + "'" +
            ", titreSlide7Fr='" + getTitreSlide7Fr() + "'" +
            ", titreSlide7En='" + getTitreSlide7En() + "'" +
            ", titreSlide7Ger='" + getTitreSlide7Ger() + "'" +
            ", titreSlide7Sw='" + getTitreSlide7Sw() + "'" +
            ", titreSlide8Fr='" + getTitreSlide8Fr() + "'" +
            ", titreSlide8En='" + getTitreSlide8En() + "'" +
            ", titreSlide8Ger='" + getTitreSlide8Ger() + "'" +
            ", titreSlide8Sw='" + getTitreSlide8Sw() + "'" +
            ", titreSlide9Fr='" + getTitreSlide9Fr() + "'" +
            ", titreSlide9En='" + getTitreSlide9En() + "'" +
            ", titreSlide9Ger='" + getTitreSlide9Ger() + "'" +
            ", titreSlide9Sw='" + getTitreSlide9Sw() + "'" +
            ", titreSlide1OFr='" + getTitreSlide1OFr() + "'" +
            ", titreSlide1OEn='" + getTitreSlide1OEn() + "'" +
            ", titreSlide1OGer='" + getTitreSlide1OGer() + "'" +
            ", titreSlide1OSw='" + getTitreSlide1OSw() + "'" +
            ", textSlide1Fr='" + getTextSlide1Fr() + "'" +
            ", textSlide1En='" + getTextSlide1En() + "'" +
            ", textSlide1Ger='" + getTextSlide1Ger() + "'" +
            ", textSlide1Sw='" + getTextSlide1Sw() + "'" +
            ", textSlide2Fr='" + getTextSlide2Fr() + "'" +
            ", textSlide2En='" + getTextSlide2En() + "'" +
            ", textSlide2Ger='" + getTextSlide2Ger() + "'" +
            ", textSlide2Sw='" + getTextSlide2Sw() + "'" +
            ", textSlide3Fr='" + getTextSlide3Fr() + "'" +
            ", textSlide3En='" + getTextSlide3En() + "'" +
            ", textSlide3Ger='" + getTextSlide3Ger() + "'" +
            ", textSlide3Sw='" + getTextSlide3Sw() + "'" +
            ", textSlide4Fr='" + getTextSlide4Fr() + "'" +
            ", textSlide4En='" + getTextSlide4En() + "'" +
            ", textSlide4Ger='" + getTextSlide4Ger() + "'" +
            ", textSlide4Sw='" + getTextSlide4Sw() + "'" +
            ", textSlide5Fr='" + getTextSlide5Fr() + "'" +
            ", textSlide5En='" + getTextSlide5En() + "'" +
            ", textSlide5Ger='" + getTextSlide5Ger() + "'" +
            ", textSlide5Sw='" + getTextSlide5Sw() + "'" +
            ", textSlide6Fr='" + getTextSlide6Fr() + "'" +
            ", textSlide6En='" + getTextSlide6En() + "'" +
            ", textSlide6Ger='" + getTextSlide6Ger() + "'" +
            ", textSlide6Sw='" + getTextSlide6Sw() + "'" +
            ", textSlide7Fr='" + getTextSlide7Fr() + "'" +
            ", textSlide7En='" + getTextSlide7En() + "'" +
            ", textSlide7Ger='" + getTextSlide7Ger() + "'" +
            ", textSlide7Sw='" + getTextSlide7Sw() + "'" +
            ", textSlide8Fr='" + getTextSlide8Fr() + "'" +
            ", textSlide8En='" + getTextSlide8En() + "'" +
            ", textSlide8Ger='" + getTextSlide8Ger() + "'" +
            ", textSlide8Sw='" + getTextSlide8Sw() + "'" +
            ", textSlide9Fr='" + getTextSlide9Fr() + "'" +
            ", textSlide9En='" + getTextSlide9En() + "'" +
            "}";
    }
}
