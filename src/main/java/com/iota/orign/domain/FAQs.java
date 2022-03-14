package com.iota.orign.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A FAQs.
 */
@Entity
@Table(name = "faqs")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class FAQs implements Serializable {

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

    @Column(name = "titre_accordion_1_fr")
    private String titreAccordion1Fr;

    @Column(name = "titre_accordion_1_en")
    private String titreAccordion1En;

    @Column(name = "titre_accordion_1_gr")
    private String titreAccordion1Gr;

    @Column(name = "titre_accordion_1_sw")
    private String titreAccordion1Sw;

    @Column(name = "titre_accordion_2_fr")
    private String titreAccordion2Fr;

    @Column(name = "titre_accordion_2_en")
    private String titreAccordion2En;

    @Column(name = "titre_accordion_2_ger")
    private String titreAccordion2Ger;

    @Column(name = "titre_accordion_2_sw")
    private String titreAccordion2Sw;

    @Column(name = "titre_accordion_3_fr")
    private String titreAccordion3Fr;

    @Column(name = "titre_accordion_3_en")
    private String titreAccordion3En;

    @Column(name = "titre_accordion_3_ger")
    private String titreAccordion3Ger;

    @Column(name = "titre_accordion_3_sw")
    private String titreAccordion3Sw;

    @Column(name = "titre_accordion_4_fr")
    private String titreAccordion4Fr;

    @Column(name = "titre_accordion_4_en")
    private String titreAccordion4En;

    @Column(name = "titre_accordion_4_ger")
    private String titreAccordion4Ger;

    @Column(name = "titre_accordion_4_sw")
    private String titreAccordion4Sw;

    @Column(name = "titre_accordion_5_fr")
    private String titreAccordion5Fr;

    @Column(name = "titre_accordion_5_en")
    private String titreAccordion5En;

    @Column(name = "titre_accordion_5_ger")
    private String titreAccordion5Ger;

    @Column(name = "titre_accordion_5_sw")
    private String titreAccordion5Sw;

    @Column(name = "titre_accordion_6_fr")
    private String titreAccordion6Fr;

    @Column(name = "titre_accordion_6_en")
    private String titreAccordion6En;

    @Column(name = "titre_accordion_6_ger")
    private String titreAccordion6Ger;

    @Column(name = "titre_accordion_6_sw")
    private String titreAccordion6Sw;

    @Column(name = "titre_accordion_7_fr")
    private String titreAccordion7Fr;

    @Column(name = "titre_accordion_7_en")
    private String titreAccordion7En;

    @Column(name = "titre_accordion_7_ger")
    private String titreAccordion7Ger;

    @Column(name = "titre_accordion_7_sw")
    private String titreAccordion7Sw;

    @Column(name = "titre_accordion_8_fr")
    private String titreAccordion8Fr;

    @Column(name = "titre_accordion_8_en")
    private String titreAccordion8En;

    @Column(name = "titre_accordion_8_ger")
    private String titreAccordion8Ger;

    @Column(name = "titre_accordion_8_sw")
    private String titreAccordion8Sw;

    @Column(name = "titre_accordion_9_fr")
    private String titreAccordion9Fr;

    @Column(name = "titre_accordion_9_en")
    private String titreAccordion9En;

    @Column(name = "titre_accordion_9_ger")
    private String titreAccordion9Ger;

    @Column(name = "titre_accordion_9_sw")
    private String titreAccordion9Sw;

    @Column(name = "titre_accordion_10_fr")
    private String titreAccordion10Fr;

    @Column(name = "titre_accordion_10_en")
    private String titreAccordion10En;

    @Column(name = "titre_accordion_10_ger")
    private String titreAccordion10Ger;

    @Column(name = "titre_accordion_10_sw")
    private String titreAccordion10Sw;

    @Column(name = "text_accordion_1_fr")
    private String textAccordion1Fr;

    @Column(name = "text_accordion_1_en")
    private String textAccordion1En;

    @Column(name = "text_accordion_1_ger")
    private String textAccordion1Ger;

    @Column(name = "text_accordion_1_sw")
    private String textAccordion1Sw;

    @Column(name = "text_accordion_2_fr")
    private String textAccordion2Fr;

    @Column(name = "text_accordion_2_en")
    private String textAccordion2En;

    @Column(name = "text_accordion_2_ger")
    private String textAccordion2Ger;

    @Column(name = "text_accordion_2_sw")
    private String textAccordion2Sw;

    @Column(name = "text_accordion_3_fr")
    private String textAccordion3Fr;

    @Column(name = "text_accordion_3_en")
    private String textAccordion3En;

    @Column(name = "text_accordion_3_ger")
    private String textAccordion3Ger;

    @Column(name = "text_accordion_3_sw")
    private String textAccordion3Sw;

    @Column(name = "text_accordion_4_fr")
    private String textAccordion4Fr;

    @Column(name = "text_accordion_4_en")
    private String textAccordion4En;

    @Column(name = "text_accordion_4_ger")
    private String textAccordion4Ger;

    @Column(name = "text_accordion_4_sw")
    private String textAccordion4Sw;

    @Column(name = "text_accordion_5_fr")
    private String textAccordion5Fr;

    @Column(name = "text_accordion_5_en")
    private String textAccordion5En;

    @Column(name = "text_accordion_5_ger")
    private String textAccordion5Ger;

    @Column(name = "text_accordion_5_sw")
    private String textAccordion5Sw;

    @Column(name = "text_accordion_6_fr")
    private String textAccordion6Fr;

    @Column(name = "text_accordion_6_en")
    private String textAccordion6En;

    @Column(name = "text_accordion_6_ger")
    private String textAccordion6Ger;

    @Column(name = "text_accordion_6_sw")
    private String textAccordion6Sw;

    @Column(name = "text_accordion_7_fr")
    private String textAccordion7Fr;

    @Column(name = "text_accordion_7_en")
    private String textAccordion7En;

    @Column(name = "text_accordion_7_ger")
    private String textAccordion7Ger;

    @Column(name = "text_accordion_7_sw")
    private String textAccordion7Sw;

    @Column(name = "text_accordion_8_fr")
    private String textAccordion8Fr;

    @Column(name = "text_accordion_8_en")
    private String textAccordion8En;

    @Column(name = "text_accordion_8_ger")
    private String textAccordion8Ger;

    @Column(name = "text_accordion_8_sw")
    private String textAccordion8Sw;

    @Column(name = "text_accordion_9_fr")
    private String textAccordion9Fr;

    @Column(name = "text_accordion_9_en")
    private String textAccordion9En;

    @Column(name = "text_accordion_9_ger")
    private String textAccordion9Ger;

    @Column(name = "text_accordion_9_sw")
    private String textAccordion9Sw;

    @Column(name = "text_accordion_10_fr")
    private String textAccordion10Fr;

    @Column(name = "text_accordion_10_en")
    private String textAccordion10En;

    @Column(name = "text_accordion_10_ger")
    private String textAccordion10Ger;

    @Column(name = "text_accordion_10_sw")
    private String textAccordion10Sw;

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

    public FAQs titreFr(String titreFr) {
        this.titreFr = titreFr;
        return this;
    }

    public void setTitreFr(String titreFr) {
        this.titreFr = titreFr;
    }

    public String getTitreEn() {
        return titreEn;
    }

    public FAQs titreEn(String titreEn) {
        this.titreEn = titreEn;
        return this;
    }

    public void setTitreEn(String titreEn) {
        this.titreEn = titreEn;
    }

    public String getTitreGer() {
        return titreGer;
    }

    public FAQs titreGer(String titreGer) {
        this.titreGer = titreGer;
        return this;
    }

    public void setTitreGer(String titreGer) {
        this.titreGer = titreGer;
    }

    public String getTitreSw() {
        return titreSw;
    }

    public FAQs titreSw(String titreSw) {
        this.titreSw = titreSw;
        return this;
    }

    public void setTitreSw(String titreSw) {
        this.titreSw = titreSw;
    }

    public String getSousTitreFr() {
        return sousTitreFr;
    }

    public FAQs sousTitreFr(String sousTitreFr) {
        this.sousTitreFr = sousTitreFr;
        return this;
    }

    public void setSousTitreFr(String sousTitreFr) {
        this.sousTitreFr = sousTitreFr;
    }

    public String getSousTitreEn() {
        return sousTitreEn;
    }

    public FAQs sousTitreEn(String sousTitreEn) {
        this.sousTitreEn = sousTitreEn;
        return this;
    }

    public void setSousTitreEn(String sousTitreEn) {
        this.sousTitreEn = sousTitreEn;
    }

    public String getSousTitreGer() {
        return sousTitreGer;
    }

    public FAQs sousTitreGer(String sousTitreGer) {
        this.sousTitreGer = sousTitreGer;
        return this;
    }

    public void setSousTitreGer(String sousTitreGer) {
        this.sousTitreGer = sousTitreGer;
    }

    public String getSousTitreSw() {
        return sousTitreSw;
    }

    public FAQs sousTitreSw(String sousTitreSw) {
        this.sousTitreSw = sousTitreSw;
        return this;
    }

    public void setSousTitreSw(String sousTitreSw) {
        this.sousTitreSw = sousTitreSw;
    }

    public String getTitreAccordion1Fr() {
        return titreAccordion1Fr;
    }

    public FAQs titreAccordion1Fr(String titreAccordion1Fr) {
        this.titreAccordion1Fr = titreAccordion1Fr;
        return this;
    }

    public void setTitreAccordion1Fr(String titreAccordion1Fr) {
        this.titreAccordion1Fr = titreAccordion1Fr;
    }

    public String getTitreAccordion1En() {
        return titreAccordion1En;
    }

    public FAQs titreAccordion1En(String titreAccordion1En) {
        this.titreAccordion1En = titreAccordion1En;
        return this;
    }

    public void setTitreAccordion1En(String titreAccordion1En) {
        this.titreAccordion1En = titreAccordion1En;
    }

    public String getTitreAccordion1Gr() {
        return titreAccordion1Gr;
    }

    public FAQs titreAccordion1Gr(String titreAccordion1Gr) {
        this.titreAccordion1Gr = titreAccordion1Gr;
        return this;
    }

    public void setTitreAccordion1Gr(String titreAccordion1Gr) {
        this.titreAccordion1Gr = titreAccordion1Gr;
    }

    public String getTitreAccordion1Sw() {
        return titreAccordion1Sw;
    }

    public FAQs titreAccordion1Sw(String titreAccordion1Sw) {
        this.titreAccordion1Sw = titreAccordion1Sw;
        return this;
    }

    public void setTitreAccordion1Sw(String titreAccordion1Sw) {
        this.titreAccordion1Sw = titreAccordion1Sw;
    }

    public String getTitreAccordion2Fr() {
        return titreAccordion2Fr;
    }

    public FAQs titreAccordion2Fr(String titreAccordion2Fr) {
        this.titreAccordion2Fr = titreAccordion2Fr;
        return this;
    }

    public void setTitreAccordion2Fr(String titreAccordion2Fr) {
        this.titreAccordion2Fr = titreAccordion2Fr;
    }

    public String getTitreAccordion2En() {
        return titreAccordion2En;
    }

    public FAQs titreAccordion2En(String titreAccordion2En) {
        this.titreAccordion2En = titreAccordion2En;
        return this;
    }

    public void setTitreAccordion2En(String titreAccordion2En) {
        this.titreAccordion2En = titreAccordion2En;
    }

    public String getTitreAccordion2Ger() {
        return titreAccordion2Ger;
    }

    public FAQs titreAccordion2Ger(String titreAccordion2Ger) {
        this.titreAccordion2Ger = titreAccordion2Ger;
        return this;
    }

    public void setTitreAccordion2Ger(String titreAccordion2Ger) {
        this.titreAccordion2Ger = titreAccordion2Ger;
    }

    public String getTitreAccordion2Sw() {
        return titreAccordion2Sw;
    }

    public FAQs titreAccordion2Sw(String titreAccordion2Sw) {
        this.titreAccordion2Sw = titreAccordion2Sw;
        return this;
    }

    public void setTitreAccordion2Sw(String titreAccordion2Sw) {
        this.titreAccordion2Sw = titreAccordion2Sw;
    }

    public String getTitreAccordion3Fr() {
        return titreAccordion3Fr;
    }

    public FAQs titreAccordion3Fr(String titreAccordion3Fr) {
        this.titreAccordion3Fr = titreAccordion3Fr;
        return this;
    }

    public void setTitreAccordion3Fr(String titreAccordion3Fr) {
        this.titreAccordion3Fr = titreAccordion3Fr;
    }

    public String getTitreAccordion3En() {
        return titreAccordion3En;
    }

    public FAQs titreAccordion3En(String titreAccordion3En) {
        this.titreAccordion3En = titreAccordion3En;
        return this;
    }

    public void setTitreAccordion3En(String titreAccordion3En) {
        this.titreAccordion3En = titreAccordion3En;
    }

    public String getTitreAccordion3Ger() {
        return titreAccordion3Ger;
    }

    public FAQs titreAccordion3Ger(String titreAccordion3Ger) {
        this.titreAccordion3Ger = titreAccordion3Ger;
        return this;
    }

    public void setTitreAccordion3Ger(String titreAccordion3Ger) {
        this.titreAccordion3Ger = titreAccordion3Ger;
    }

    public String getTitreAccordion3Sw() {
        return titreAccordion3Sw;
    }

    public FAQs titreAccordion3Sw(String titreAccordion3Sw) {
        this.titreAccordion3Sw = titreAccordion3Sw;
        return this;
    }

    public void setTitreAccordion3Sw(String titreAccordion3Sw) {
        this.titreAccordion3Sw = titreAccordion3Sw;
    }

    public String getTitreAccordion4Fr() {
        return titreAccordion4Fr;
    }

    public FAQs titreAccordion4Fr(String titreAccordion4Fr) {
        this.titreAccordion4Fr = titreAccordion4Fr;
        return this;
    }

    public void setTitreAccordion4Fr(String titreAccordion4Fr) {
        this.titreAccordion4Fr = titreAccordion4Fr;
    }

    public String getTitreAccordion4En() {
        return titreAccordion4En;
    }

    public FAQs titreAccordion4En(String titreAccordion4En) {
        this.titreAccordion4En = titreAccordion4En;
        return this;
    }

    public void setTitreAccordion4En(String titreAccordion4En) {
        this.titreAccordion4En = titreAccordion4En;
    }

    public String getTitreAccordion4Ger() {
        return titreAccordion4Ger;
    }

    public FAQs titreAccordion4Ger(String titreAccordion4Ger) {
        this.titreAccordion4Ger = titreAccordion4Ger;
        return this;
    }

    public void setTitreAccordion4Ger(String titreAccordion4Ger) {
        this.titreAccordion4Ger = titreAccordion4Ger;
    }

    public String getTitreAccordion4Sw() {
        return titreAccordion4Sw;
    }

    public FAQs titreAccordion4Sw(String titreAccordion4Sw) {
        this.titreAccordion4Sw = titreAccordion4Sw;
        return this;
    }

    public void setTitreAccordion4Sw(String titreAccordion4Sw) {
        this.titreAccordion4Sw = titreAccordion4Sw;
    }

    public String getTitreAccordion5Fr() {
        return titreAccordion5Fr;
    }

    public FAQs titreAccordion5Fr(String titreAccordion5Fr) {
        this.titreAccordion5Fr = titreAccordion5Fr;
        return this;
    }

    public void setTitreAccordion5Fr(String titreAccordion5Fr) {
        this.titreAccordion5Fr = titreAccordion5Fr;
    }

    public String getTitreAccordion5En() {
        return titreAccordion5En;
    }

    public FAQs titreAccordion5En(String titreAccordion5En) {
        this.titreAccordion5En = titreAccordion5En;
        return this;
    }

    public void setTitreAccordion5En(String titreAccordion5En) {
        this.titreAccordion5En = titreAccordion5En;
    }

    public String getTitreAccordion5Ger() {
        return titreAccordion5Ger;
    }

    public FAQs titreAccordion5Ger(String titreAccordion5Ger) {
        this.titreAccordion5Ger = titreAccordion5Ger;
        return this;
    }

    public void setTitreAccordion5Ger(String titreAccordion5Ger) {
        this.titreAccordion5Ger = titreAccordion5Ger;
    }

    public String getTitreAccordion5Sw() {
        return titreAccordion5Sw;
    }

    public FAQs titreAccordion5Sw(String titreAccordion5Sw) {
        this.titreAccordion5Sw = titreAccordion5Sw;
        return this;
    }

    public void setTitreAccordion5Sw(String titreAccordion5Sw) {
        this.titreAccordion5Sw = titreAccordion5Sw;
    }

    public String getTitreAccordion6Fr() {
        return titreAccordion6Fr;
    }

    public FAQs titreAccordion6Fr(String titreAccordion6Fr) {
        this.titreAccordion6Fr = titreAccordion6Fr;
        return this;
    }

    public void setTitreAccordion6Fr(String titreAccordion6Fr) {
        this.titreAccordion6Fr = titreAccordion6Fr;
    }

    public String getTitreAccordion6En() {
        return titreAccordion6En;
    }

    public FAQs titreAccordion6En(String titreAccordion6En) {
        this.titreAccordion6En = titreAccordion6En;
        return this;
    }

    public void setTitreAccordion6En(String titreAccordion6En) {
        this.titreAccordion6En = titreAccordion6En;
    }

    public String getTitreAccordion6Ger() {
        return titreAccordion6Ger;
    }

    public FAQs titreAccordion6Ger(String titreAccordion6Ger) {
        this.titreAccordion6Ger = titreAccordion6Ger;
        return this;
    }

    public void setTitreAccordion6Ger(String titreAccordion6Ger) {
        this.titreAccordion6Ger = titreAccordion6Ger;
    }

    public String getTitreAccordion6Sw() {
        return titreAccordion6Sw;
    }

    public FAQs titreAccordion6Sw(String titreAccordion6Sw) {
        this.titreAccordion6Sw = titreAccordion6Sw;
        return this;
    }

    public void setTitreAccordion6Sw(String titreAccordion6Sw) {
        this.titreAccordion6Sw = titreAccordion6Sw;
    }

    public String getTitreAccordion7Fr() {
        return titreAccordion7Fr;
    }

    public FAQs titreAccordion7Fr(String titreAccordion7Fr) {
        this.titreAccordion7Fr = titreAccordion7Fr;
        return this;
    }

    public void setTitreAccordion7Fr(String titreAccordion7Fr) {
        this.titreAccordion7Fr = titreAccordion7Fr;
    }

    public String getTitreAccordion7En() {
        return titreAccordion7En;
    }

    public FAQs titreAccordion7En(String titreAccordion7En) {
        this.titreAccordion7En = titreAccordion7En;
        return this;
    }

    public void setTitreAccordion7En(String titreAccordion7En) {
        this.titreAccordion7En = titreAccordion7En;
    }

    public String getTitreAccordion7Ger() {
        return titreAccordion7Ger;
    }

    public FAQs titreAccordion7Ger(String titreAccordion7Ger) {
        this.titreAccordion7Ger = titreAccordion7Ger;
        return this;
    }

    public void setTitreAccordion7Ger(String titreAccordion7Ger) {
        this.titreAccordion7Ger = titreAccordion7Ger;
    }

    public String getTitreAccordion7Sw() {
        return titreAccordion7Sw;
    }

    public FAQs titreAccordion7Sw(String titreAccordion7Sw) {
        this.titreAccordion7Sw = titreAccordion7Sw;
        return this;
    }

    public void setTitreAccordion7Sw(String titreAccordion7Sw) {
        this.titreAccordion7Sw = titreAccordion7Sw;
    }

    public String getTitreAccordion8Fr() {
        return titreAccordion8Fr;
    }

    public FAQs titreAccordion8Fr(String titreAccordion8Fr) {
        this.titreAccordion8Fr = titreAccordion8Fr;
        return this;
    }

    public void setTitreAccordion8Fr(String titreAccordion8Fr) {
        this.titreAccordion8Fr = titreAccordion8Fr;
    }

    public String getTitreAccordion8En() {
        return titreAccordion8En;
    }

    public FAQs titreAccordion8En(String titreAccordion8En) {
        this.titreAccordion8En = titreAccordion8En;
        return this;
    }

    public void setTitreAccordion8En(String titreAccordion8En) {
        this.titreAccordion8En = titreAccordion8En;
    }

    public String getTitreAccordion8Ger() {
        return titreAccordion8Ger;
    }

    public FAQs titreAccordion8Ger(String titreAccordion8Ger) {
        this.titreAccordion8Ger = titreAccordion8Ger;
        return this;
    }

    public void setTitreAccordion8Ger(String titreAccordion8Ger) {
        this.titreAccordion8Ger = titreAccordion8Ger;
    }

    public String getTitreAccordion8Sw() {
        return titreAccordion8Sw;
    }

    public FAQs titreAccordion8Sw(String titreAccordion8Sw) {
        this.titreAccordion8Sw = titreAccordion8Sw;
        return this;
    }

    public void setTitreAccordion8Sw(String titreAccordion8Sw) {
        this.titreAccordion8Sw = titreAccordion8Sw;
    }

    public String getTitreAccordion9Fr() {
        return titreAccordion9Fr;
    }

    public FAQs titreAccordion9Fr(String titreAccordion9Fr) {
        this.titreAccordion9Fr = titreAccordion9Fr;
        return this;
    }

    public void setTitreAccordion9Fr(String titreAccordion9Fr) {
        this.titreAccordion9Fr = titreAccordion9Fr;
    }

    public String getTitreAccordion9En() {
        return titreAccordion9En;
    }

    public FAQs titreAccordion9En(String titreAccordion9En) {
        this.titreAccordion9En = titreAccordion9En;
        return this;
    }

    public void setTitreAccordion9En(String titreAccordion9En) {
        this.titreAccordion9En = titreAccordion9En;
    }

    public String getTitreAccordion9Ger() {
        return titreAccordion9Ger;
    }

    public FAQs titreAccordion9Ger(String titreAccordion9Ger) {
        this.titreAccordion9Ger = titreAccordion9Ger;
        return this;
    }

    public void setTitreAccordion9Ger(String titreAccordion9Ger) {
        this.titreAccordion9Ger = titreAccordion9Ger;
    }

    public String getTitreAccordion9Sw() {
        return titreAccordion9Sw;
    }

    public FAQs titreAccordion9Sw(String titreAccordion9Sw) {
        this.titreAccordion9Sw = titreAccordion9Sw;
        return this;
    }

    public void setTitreAccordion9Sw(String titreAccordion9Sw) {
        this.titreAccordion9Sw = titreAccordion9Sw;
    }

    public String getTitreAccordion10Fr() {
        return titreAccordion10Fr;
    }

    public FAQs titreAccordion10Fr(String titreAccordion10Fr) {
        this.titreAccordion10Fr = titreAccordion10Fr;
        return this;
    }

    public void setTitreAccordion10Fr(String titreAccordion10Fr) {
        this.titreAccordion10Fr = titreAccordion10Fr;
    }

    public String getTitreAccordion10En() {
        return titreAccordion10En;
    }

    public FAQs titreAccordion10En(String titreAccordion10En) {
        this.titreAccordion10En = titreAccordion10En;
        return this;
    }

    public void setTitreAccordion10En(String titreAccordion10En) {
        this.titreAccordion10En = titreAccordion10En;
    }

    public String getTitreAccordion10Ger() {
        return titreAccordion10Ger;
    }

    public FAQs titreAccordion10Ger(String titreAccordion10Ger) {
        this.titreAccordion10Ger = titreAccordion10Ger;
        return this;
    }

    public void setTitreAccordion10Ger(String titreAccordion10Ger) {
        this.titreAccordion10Ger = titreAccordion10Ger;
    }

    public String getTitreAccordion10Sw() {
        return titreAccordion10Sw;
    }

    public FAQs titreAccordion10Sw(String titreAccordion10Sw) {
        this.titreAccordion10Sw = titreAccordion10Sw;
        return this;
    }

    public void setTitreAccordion10Sw(String titreAccordion10Sw) {
        this.titreAccordion10Sw = titreAccordion10Sw;
    }

    public String getTextAccordion1Fr() {
        return textAccordion1Fr;
    }

    public FAQs textAccordion1Fr(String textAccordion1Fr) {
        this.textAccordion1Fr = textAccordion1Fr;
        return this;
    }

    public void setTextAccordion1Fr(String textAccordion1Fr) {
        this.textAccordion1Fr = textAccordion1Fr;
    }

    public String getTextAccordion1En() {
        return textAccordion1En;
    }

    public FAQs textAccordion1En(String textAccordion1En) {
        this.textAccordion1En = textAccordion1En;
        return this;
    }

    public void setTextAccordion1En(String textAccordion1En) {
        this.textAccordion1En = textAccordion1En;
    }

    public String getTextAccordion1Ger() {
        return textAccordion1Ger;
    }

    public FAQs textAccordion1Ger(String textAccordion1Ger) {
        this.textAccordion1Ger = textAccordion1Ger;
        return this;
    }

    public void setTextAccordion1Ger(String textAccordion1Ger) {
        this.textAccordion1Ger = textAccordion1Ger;
    }

    public String getTextAccordion1Sw() {
        return textAccordion1Sw;
    }

    public FAQs textAccordion1Sw(String textAccordion1Sw) {
        this.textAccordion1Sw = textAccordion1Sw;
        return this;
    }

    public void setTextAccordion1Sw(String textAccordion1Sw) {
        this.textAccordion1Sw = textAccordion1Sw;
    }

    public String getTextAccordion2Fr() {
        return textAccordion2Fr;
    }

    public FAQs textAccordion2Fr(String textAccordion2Fr) {
        this.textAccordion2Fr = textAccordion2Fr;
        return this;
    }

    public void setTextAccordion2Fr(String textAccordion2Fr) {
        this.textAccordion2Fr = textAccordion2Fr;
    }

    public String getTextAccordion2En() {
        return textAccordion2En;
    }

    public FAQs textAccordion2En(String textAccordion2En) {
        this.textAccordion2En = textAccordion2En;
        return this;
    }

    public void setTextAccordion2En(String textAccordion2En) {
        this.textAccordion2En = textAccordion2En;
    }

    public String getTextAccordion2Ger() {
        return textAccordion2Ger;
    }

    public FAQs textAccordion2Ger(String textAccordion2Ger) {
        this.textAccordion2Ger = textAccordion2Ger;
        return this;
    }

    public void setTextAccordion2Ger(String textAccordion2Ger) {
        this.textAccordion2Ger = textAccordion2Ger;
    }

    public String getTextAccordion2Sw() {
        return textAccordion2Sw;
    }

    public FAQs textAccordion2Sw(String textAccordion2Sw) {
        this.textAccordion2Sw = textAccordion2Sw;
        return this;
    }

    public void setTextAccordion2Sw(String textAccordion2Sw) {
        this.textAccordion2Sw = textAccordion2Sw;
    }

    public String getTextAccordion3Fr() {
        return textAccordion3Fr;
    }

    public FAQs textAccordion3Fr(String textAccordion3Fr) {
        this.textAccordion3Fr = textAccordion3Fr;
        return this;
    }

    public void setTextAccordion3Fr(String textAccordion3Fr) {
        this.textAccordion3Fr = textAccordion3Fr;
    }

    public String getTextAccordion3En() {
        return textAccordion3En;
    }

    public FAQs textAccordion3En(String textAccordion3En) {
        this.textAccordion3En = textAccordion3En;
        return this;
    }

    public void setTextAccordion3En(String textAccordion3En) {
        this.textAccordion3En = textAccordion3En;
    }

    public String getTextAccordion3Ger() {
        return textAccordion3Ger;
    }

    public FAQs textAccordion3Ger(String textAccordion3Ger) {
        this.textAccordion3Ger = textAccordion3Ger;
        return this;
    }

    public void setTextAccordion3Ger(String textAccordion3Ger) {
        this.textAccordion3Ger = textAccordion3Ger;
    }

    public String getTextAccordion3Sw() {
        return textAccordion3Sw;
    }

    public FAQs textAccordion3Sw(String textAccordion3Sw) {
        this.textAccordion3Sw = textAccordion3Sw;
        return this;
    }

    public void setTextAccordion3Sw(String textAccordion3Sw) {
        this.textAccordion3Sw = textAccordion3Sw;
    }

    public String getTextAccordion4Fr() {
        return textAccordion4Fr;
    }

    public FAQs textAccordion4Fr(String textAccordion4Fr) {
        this.textAccordion4Fr = textAccordion4Fr;
        return this;
    }

    public void setTextAccordion4Fr(String textAccordion4Fr) {
        this.textAccordion4Fr = textAccordion4Fr;
    }

    public String getTextAccordion4En() {
        return textAccordion4En;
    }

    public FAQs textAccordion4En(String textAccordion4En) {
        this.textAccordion4En = textAccordion4En;
        return this;
    }

    public void setTextAccordion4En(String textAccordion4En) {
        this.textAccordion4En = textAccordion4En;
    }

    public String getTextAccordion4Ger() {
        return textAccordion4Ger;
    }

    public FAQs textAccordion4Ger(String textAccordion4Ger) {
        this.textAccordion4Ger = textAccordion4Ger;
        return this;
    }

    public void setTextAccordion4Ger(String textAccordion4Ger) {
        this.textAccordion4Ger = textAccordion4Ger;
    }

    public String getTextAccordion4Sw() {
        return textAccordion4Sw;
    }

    public FAQs textAccordion4Sw(String textAccordion4Sw) {
        this.textAccordion4Sw = textAccordion4Sw;
        return this;
    }

    public void setTextAccordion4Sw(String textAccordion4Sw) {
        this.textAccordion4Sw = textAccordion4Sw;
    }

    public String getTextAccordion5Fr() {
        return textAccordion5Fr;
    }

    public FAQs textAccordion5Fr(String textAccordion5Fr) {
        this.textAccordion5Fr = textAccordion5Fr;
        return this;
    }

    public void setTextAccordion5Fr(String textAccordion5Fr) {
        this.textAccordion5Fr = textAccordion5Fr;
    }

    public String getTextAccordion5En() {
        return textAccordion5En;
    }

    public FAQs textAccordion5En(String textAccordion5En) {
        this.textAccordion5En = textAccordion5En;
        return this;
    }

    public void setTextAccordion5En(String textAccordion5En) {
        this.textAccordion5En = textAccordion5En;
    }

    public String getTextAccordion5Ger() {
        return textAccordion5Ger;
    }

    public FAQs textAccordion5Ger(String textAccordion5Ger) {
        this.textAccordion5Ger = textAccordion5Ger;
        return this;
    }

    public void setTextAccordion5Ger(String textAccordion5Ger) {
        this.textAccordion5Ger = textAccordion5Ger;
    }

    public String getTextAccordion5Sw() {
        return textAccordion5Sw;
    }

    public FAQs textAccordion5Sw(String textAccordion5Sw) {
        this.textAccordion5Sw = textAccordion5Sw;
        return this;
    }

    public void setTextAccordion5Sw(String textAccordion5Sw) {
        this.textAccordion5Sw = textAccordion5Sw;
    }

    public String getTextAccordion6Fr() {
        return textAccordion6Fr;
    }

    public FAQs textAccordion6Fr(String textAccordion6Fr) {
        this.textAccordion6Fr = textAccordion6Fr;
        return this;
    }

    public void setTextAccordion6Fr(String textAccordion6Fr) {
        this.textAccordion6Fr = textAccordion6Fr;
    }

    public String getTextAccordion6En() {
        return textAccordion6En;
    }

    public FAQs textAccordion6En(String textAccordion6En) {
        this.textAccordion6En = textAccordion6En;
        return this;
    }

    public void setTextAccordion6En(String textAccordion6En) {
        this.textAccordion6En = textAccordion6En;
    }

    public String getTextAccordion6Ger() {
        return textAccordion6Ger;
    }

    public FAQs textAccordion6Ger(String textAccordion6Ger) {
        this.textAccordion6Ger = textAccordion6Ger;
        return this;
    }

    public void setTextAccordion6Ger(String textAccordion6Ger) {
        this.textAccordion6Ger = textAccordion6Ger;
    }

    public String getTextAccordion6Sw() {
        return textAccordion6Sw;
    }

    public FAQs textAccordion6Sw(String textAccordion6Sw) {
        this.textAccordion6Sw = textAccordion6Sw;
        return this;
    }

    public void setTextAccordion6Sw(String textAccordion6Sw) {
        this.textAccordion6Sw = textAccordion6Sw;
    }

    public String getTextAccordion7Fr() {
        return textAccordion7Fr;
    }

    public FAQs textAccordion7Fr(String textAccordion7Fr) {
        this.textAccordion7Fr = textAccordion7Fr;
        return this;
    }

    public void setTextAccordion7Fr(String textAccordion7Fr) {
        this.textAccordion7Fr = textAccordion7Fr;
    }

    public String getTextAccordion7En() {
        return textAccordion7En;
    }

    public FAQs textAccordion7En(String textAccordion7En) {
        this.textAccordion7En = textAccordion7En;
        return this;
    }

    public void setTextAccordion7En(String textAccordion7En) {
        this.textAccordion7En = textAccordion7En;
    }

    public String getTextAccordion7Ger() {
        return textAccordion7Ger;
    }

    public FAQs textAccordion7Ger(String textAccordion7Ger) {
        this.textAccordion7Ger = textAccordion7Ger;
        return this;
    }

    public void setTextAccordion7Ger(String textAccordion7Ger) {
        this.textAccordion7Ger = textAccordion7Ger;
    }

    public String getTextAccordion7Sw() {
        return textAccordion7Sw;
    }

    public FAQs textAccordion7Sw(String textAccordion7Sw) {
        this.textAccordion7Sw = textAccordion7Sw;
        return this;
    }

    public void setTextAccordion7Sw(String textAccordion7Sw) {
        this.textAccordion7Sw = textAccordion7Sw;
    }

    public String getTextAccordion8Fr() {
        return textAccordion8Fr;
    }

    public FAQs textAccordion8Fr(String textAccordion8Fr) {
        this.textAccordion8Fr = textAccordion8Fr;
        return this;
    }

    public void setTextAccordion8Fr(String textAccordion8Fr) {
        this.textAccordion8Fr = textAccordion8Fr;
    }

    public String getTextAccordion8En() {
        return textAccordion8En;
    }

    public FAQs textAccordion8En(String textAccordion8En) {
        this.textAccordion8En = textAccordion8En;
        return this;
    }

    public void setTextAccordion8En(String textAccordion8En) {
        this.textAccordion8En = textAccordion8En;
    }

    public String getTextAccordion8Ger() {
        return textAccordion8Ger;
    }

    public FAQs textAccordion8Ger(String textAccordion8Ger) {
        this.textAccordion8Ger = textAccordion8Ger;
        return this;
    }

    public void setTextAccordion8Ger(String textAccordion8Ger) {
        this.textAccordion8Ger = textAccordion8Ger;
    }

    public String getTextAccordion8Sw() {
        return textAccordion8Sw;
    }

    public FAQs textAccordion8Sw(String textAccordion8Sw) {
        this.textAccordion8Sw = textAccordion8Sw;
        return this;
    }

    public void setTextAccordion8Sw(String textAccordion8Sw) {
        this.textAccordion8Sw = textAccordion8Sw;
    }

    public String getTextAccordion9Fr() {
        return textAccordion9Fr;
    }

    public FAQs textAccordion9Fr(String textAccordion9Fr) {
        this.textAccordion9Fr = textAccordion9Fr;
        return this;
    }

    public void setTextAccordion9Fr(String textAccordion9Fr) {
        this.textAccordion9Fr = textAccordion9Fr;
    }

    public String getTextAccordion9En() {
        return textAccordion9En;
    }

    public FAQs textAccordion9En(String textAccordion9En) {
        this.textAccordion9En = textAccordion9En;
        return this;
    }

    public void setTextAccordion9En(String textAccordion9En) {
        this.textAccordion9En = textAccordion9En;
    }

    public String getTextAccordion9Ger() {
        return textAccordion9Ger;
    }

    public FAQs textAccordion9Ger(String textAccordion9Ger) {
        this.textAccordion9Ger = textAccordion9Ger;
        return this;
    }

    public void setTextAccordion9Ger(String textAccordion9Ger) {
        this.textAccordion9Ger = textAccordion9Ger;
    }

    public String getTextAccordion9Sw() {
        return textAccordion9Sw;
    }

    public FAQs textAccordion9Sw(String textAccordion9Sw) {
        this.textAccordion9Sw = textAccordion9Sw;
        return this;
    }

    public void setTextAccordion9Sw(String textAccordion9Sw) {
        this.textAccordion9Sw = textAccordion9Sw;
    }

    public String getTextAccordion10Fr() {
        return textAccordion10Fr;
    }

    public FAQs textAccordion10Fr(String textAccordion10Fr) {
        this.textAccordion10Fr = textAccordion10Fr;
        return this;
    }

    public void setTextAccordion10Fr(String textAccordion10Fr) {
        this.textAccordion10Fr = textAccordion10Fr;
    }

    public String getTextAccordion10En() {
        return textAccordion10En;
    }

    public FAQs textAccordion10En(String textAccordion10En) {
        this.textAccordion10En = textAccordion10En;
        return this;
    }

    public void setTextAccordion10En(String textAccordion10En) {
        this.textAccordion10En = textAccordion10En;
    }

    public String getTextAccordion10Ger() {
        return textAccordion10Ger;
    }

    public FAQs textAccordion10Ger(String textAccordion10Ger) {
        this.textAccordion10Ger = textAccordion10Ger;
        return this;
    }

    public void setTextAccordion10Ger(String textAccordion10Ger) {
        this.textAccordion10Ger = textAccordion10Ger;
    }

    public String getTextAccordion10Sw() {
        return textAccordion10Sw;
    }

    public FAQs textAccordion10Sw(String textAccordion10Sw) {
        this.textAccordion10Sw = textAccordion10Sw;
        return this;
    }

    public void setTextAccordion10Sw(String textAccordion10Sw) {
        this.textAccordion10Sw = textAccordion10Sw;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof FAQs)) {
            return false;
        }
        return id != null && id.equals(((FAQs) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "FAQs{" +
            "id=" + getId() +
            ", titreFr='" + getTitreFr() + "'" +
            ", titreEn='" + getTitreEn() + "'" +
            ", titreGer='" + getTitreGer() + "'" +
            ", titreSw='" + getTitreSw() + "'" +
            ", sousTitreFr='" + getSousTitreFr() + "'" +
            ", sousTitreEn='" + getSousTitreEn() + "'" +
            ", sousTitreGer='" + getSousTitreGer() + "'" +
            ", sousTitreSw='" + getSousTitreSw() + "'" +
            ", titreAccordion1Fr='" + getTitreAccordion1Fr() + "'" +
            ", titreAccordion1En='" + getTitreAccordion1En() + "'" +
            ", titreAccordion1Gr='" + getTitreAccordion1Gr() + "'" +
            ", titreAccordion1Sw='" + getTitreAccordion1Sw() + "'" +
            ", titreAccordion2Fr='" + getTitreAccordion2Fr() + "'" +
            ", titreAccordion2En='" + getTitreAccordion2En() + "'" +
            ", titreAccordion2Ger='" + getTitreAccordion2Ger() + "'" +
            ", titreAccordion2Sw='" + getTitreAccordion2Sw() + "'" +
            ", titreAccordion3Fr='" + getTitreAccordion3Fr() + "'" +
            ", titreAccordion3En='" + getTitreAccordion3En() + "'" +
            ", titreAccordion3Ger='" + getTitreAccordion3Ger() + "'" +
            ", titreAccordion3Sw='" + getTitreAccordion3Sw() + "'" +
            ", titreAccordion4Fr='" + getTitreAccordion4Fr() + "'" +
            ", titreAccordion4En='" + getTitreAccordion4En() + "'" +
            ", titreAccordion4Ger='" + getTitreAccordion4Ger() + "'" +
            ", titreAccordion4Sw='" + getTitreAccordion4Sw() + "'" +
            ", titreAccordion5Fr='" + getTitreAccordion5Fr() + "'" +
            ", titreAccordion5En='" + getTitreAccordion5En() + "'" +
            ", titreAccordion5Ger='" + getTitreAccordion5Ger() + "'" +
            ", titreAccordion5Sw='" + getTitreAccordion5Sw() + "'" +
            ", titreAccordion6Fr='" + getTitreAccordion6Fr() + "'" +
            ", titreAccordion6En='" + getTitreAccordion6En() + "'" +
            ", titreAccordion6Ger='" + getTitreAccordion6Ger() + "'" +
            ", titreAccordion6Sw='" + getTitreAccordion6Sw() + "'" +
            ", titreAccordion7Fr='" + getTitreAccordion7Fr() + "'" +
            ", titreAccordion7En='" + getTitreAccordion7En() + "'" +
            ", titreAccordion7Ger='" + getTitreAccordion7Ger() + "'" +
            ", titreAccordion7Sw='" + getTitreAccordion7Sw() + "'" +
            ", titreAccordion8Fr='" + getTitreAccordion8Fr() + "'" +
            ", titreAccordion8En='" + getTitreAccordion8En() + "'" +
            ", titreAccordion8Ger='" + getTitreAccordion8Ger() + "'" +
            ", titreAccordion8Sw='" + getTitreAccordion8Sw() + "'" +
            ", titreAccordion9Fr='" + getTitreAccordion9Fr() + "'" +
            ", titreAccordion9En='" + getTitreAccordion9En() + "'" +
            ", titreAccordion9Ger='" + getTitreAccordion9Ger() + "'" +
            ", titreAccordion9Sw='" + getTitreAccordion9Sw() + "'" +
            ", titreAccordion10Fr='" + getTitreAccordion10Fr() + "'" +
            ", titreAccordion10En='" + getTitreAccordion10En() + "'" +
            ", titreAccordion10Ger='" + getTitreAccordion10Ger() + "'" +
            ", titreAccordion10Sw='" + getTitreAccordion10Sw() + "'" +
            ", textAccordion1Fr='" + getTextAccordion1Fr() + "'" +
            ", textAccordion1En='" + getTextAccordion1En() + "'" +
            ", textAccordion1Ger='" + getTextAccordion1Ger() + "'" +
            ", textAccordion1Sw='" + getTextAccordion1Sw() + "'" +
            ", textAccordion2Fr='" + getTextAccordion2Fr() + "'" +
            ", textAccordion2En='" + getTextAccordion2En() + "'" +
            ", textAccordion2Ger='" + getTextAccordion2Ger() + "'" +
            ", textAccordion2Sw='" + getTextAccordion2Sw() + "'" +
            ", textAccordion3Fr='" + getTextAccordion3Fr() + "'" +
            ", textAccordion3En='" + getTextAccordion3En() + "'" +
            ", textAccordion3Ger='" + getTextAccordion3Ger() + "'" +
            ", textAccordion3Sw='" + getTextAccordion3Sw() + "'" +
            ", textAccordion4Fr='" + getTextAccordion4Fr() + "'" +
            ", textAccordion4En='" + getTextAccordion4En() + "'" +
            ", textAccordion4Ger='" + getTextAccordion4Ger() + "'" +
            ", textAccordion4Sw='" + getTextAccordion4Sw() + "'" +
            ", textAccordion5Fr='" + getTextAccordion5Fr() + "'" +
            ", textAccordion5En='" + getTextAccordion5En() + "'" +
            ", textAccordion5Ger='" + getTextAccordion5Ger() + "'" +
            ", textAccordion5Sw='" + getTextAccordion5Sw() + "'" +
            ", textAccordion6Fr='" + getTextAccordion6Fr() + "'" +
            ", textAccordion6En='" + getTextAccordion6En() + "'" +
            ", textAccordion6Ger='" + getTextAccordion6Ger() + "'" +
            ", textAccordion6Sw='" + getTextAccordion6Sw() + "'" +
            ", textAccordion7Fr='" + getTextAccordion7Fr() + "'" +
            ", textAccordion7En='" + getTextAccordion7En() + "'" +
            ", textAccordion7Ger='" + getTextAccordion7Ger() + "'" +
            ", textAccordion7Sw='" + getTextAccordion7Sw() + "'" +
            ", textAccordion8Fr='" + getTextAccordion8Fr() + "'" +
            ", textAccordion8En='" + getTextAccordion8En() + "'" +
            ", textAccordion8Ger='" + getTextAccordion8Ger() + "'" +
            ", textAccordion8Sw='" + getTextAccordion8Sw() + "'" +
            ", textAccordion9Fr='" + getTextAccordion9Fr() + "'" +
            ", textAccordion9En='" + getTextAccordion9En() + "'" +
            ", textAccordion9Ger='" + getTextAccordion9Ger() + "'" +
            ", textAccordion9Sw='" + getTextAccordion9Sw() + "'" +
            ", textAccordion10Fr='" + getTextAccordion10Fr() + "'" +
            ", textAccordion10En='" + getTextAccordion10En() + "'" +
            ", textAccordion10Ger='" + getTextAccordion10Ger() + "'" +
            ", textAccordion10Sw='" + getTextAccordion10Sw() + "'" +
            "}";
    }
}
