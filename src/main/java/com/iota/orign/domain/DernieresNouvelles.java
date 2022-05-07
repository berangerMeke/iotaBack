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

    @Column(name = "text_slide_9_ger")
    private String textSlide9Ger;

    @Column(name = "text_slide_9_sw")
    private String textSlide9Sw;

    @Column(name = "text_slide_10_fr")
    private String textSlide10Fr;

    @Column(name = "text_slide_10_en")
    private String textSlide10En;

    @Column(name = "text_slide_10_ger")
    private String textSlide10Ger;

    @Column(name = "text_slide_10_sw")
    private String textSlide10Sw;

    @Lob
    @Column(name = "image_slide_1")
    private byte[] imageSlide1;

    @Column(name = "image_slide_1_content_type")
    private String imageSlide1ContentType;

    @Lob
    @Column(name = "image_slide_2")
    private byte[] imageSlide2;

    @Column(name = "image_slide_2_content_type")
    private String imageSlide2ContentType;

    @Lob
    @Column(name = "image_slide_3")
    private byte[] imageSlide3;

    @Column(name = "image_slide_3_content_type")
    private String imageSlide3ContentType;

    @Lob
    @Column(name = "image_slide_4")
    private byte[] imageSlide4;

    @Column(name = "image_slide_4_content_type")
    private String imageSlide4ContentType;

    @Lob
    @Column(name = "image_slide_5")
    private byte[] imageSlide5;

    @Column(name = "image_slide_5_content_type")
    private String imageSlide5ContentType;

    @Lob
    @Column(name = "image_slide_6")
    private byte[] imageSlide6;

    @Column(name = "image_slide_6_content_type")
    private String imageSlide6ContentType;

    @Lob
    @Column(name = "image_slide_7")
    private byte[] imageSlide7;

    @Column(name = "image_slide_7_content_type")
    private String imageSlide7ContentType;

    @Lob
    @Column(name = "image_slide_8")
    private byte[] imageSlide8;

    @Column(name = "image_slide_8_content_type")
    private String imageSlide8ContentType;

    @Lob
    @Column(name = "image_slide_9")
    private byte[] imageSlide9;

    @Column(name = "image_slide_9_content_type")
    private String imageSlide9ContentType;

    @Lob
    @Column(name = "image_slide_10")
    private byte[] imageSlide10;

    @Column(name = "image_slide_10_content_type")
    private String imageSlide10ContentType;

    @Column(name = "read_more_1")
    private String readMore1;

    @Column(name = "read_more_2")
    private String readMore2;

    @Column(name = "read_more_3")
    private String readMore3;

    @Column(name = "read_more_4")
    private String readMore4;

    @Column(name = "read_more_5")
    private String readMore5;

    @Column(name = "read_more_6")
    private String readMore6;

    @Column(name = "read_more_7")
    private String readMore7;

    @Column(name = "read_more_8")
    private String readMore8;

    @Column(name = "read_more_9")
    private String readMore9;

    @Column(name = "read_more_10")
    private String readMore10;

    @Column(name = "date_1")
    private String date1;

    @Column(name = "date_2")
    private String date2;

    @Column(name = "date_3")
    private String date3;

    @Column(name = "date_4")
    private String date4;

    @Column(name = "date_5")
    private String date5;

    @Column(name = "date_6")
    private String date6;

    @Column(name = "date_7")
    private String date7;

    @Column(name = "date_8")
    private String date8;

    @Column(name = "date_9")
    private String date9;

    @Column(name = "date_10")
    private String date10;

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

    public String getTextSlide9Ger() {
        return textSlide9Ger;
    }

    public DernieresNouvelles textSlide9Ger(String textSlide9Ger) {
        this.textSlide9Ger = textSlide9Ger;
        return this;
    }

    public void setTextSlide9Ger(String textSlide9Ger) {
        this.textSlide9Ger = textSlide9Ger;
    }

    public String getTextSlide9Sw() {
        return textSlide9Sw;
    }

    public DernieresNouvelles textSlide9Sw(String textSlide9Sw) {
        this.textSlide9Sw = textSlide9Sw;
        return this;
    }

    public void setTextSlide9Sw(String textSlide9Sw) {
        this.textSlide9Sw = textSlide9Sw;
    }

    public String getTextSlide10Fr() {
        return textSlide10Fr;
    }

    public DernieresNouvelles textSlide10Fr(String textSlide10Fr) {
        this.textSlide10Fr = textSlide10Fr;
        return this;
    }

    public void setTextSlide10Fr(String textSlide10Fr) {
        this.textSlide10Fr = textSlide10Fr;
    }

    public String getTextSlide10En() {
        return textSlide10En;
    }

    public DernieresNouvelles textSlide10En(String textSlide10En) {
        this.textSlide10En = textSlide10En;
        return this;
    }

    public void setTextSlide10En(String textSlide10En) {
        this.textSlide10En = textSlide10En;
    }

    public String getTextSlide10Ger() {
        return textSlide10Ger;
    }

    public DernieresNouvelles textSlide10Ger(String textSlide10Ger) {
        this.textSlide10Ger = textSlide10Ger;
        return this;
    }

    public void setTextSlide10Ger(String textSlide10Ger) {
        this.textSlide10Ger = textSlide10Ger;
    }

    public String getTextSlide10Sw() {
        return textSlide10Sw;
    }

    public DernieresNouvelles textSlide10Sw(String textSlide10Sw) {
        this.textSlide10Sw = textSlide10Sw;
        return this;
    }

    public void setTextSlide10Sw(String textSlide10Sw) {
        this.textSlide10Sw = textSlide10Sw;
    }

    public byte[] getImageSlide1() {
        return imageSlide1;
    }

    public DernieresNouvelles imageSlide1(byte[] imageSlide1) {
        this.imageSlide1 = imageSlide1;
        return this;
    }

    public void setImageSlide1(byte[] imageSlide1) {
        this.imageSlide1 = imageSlide1;
    }

    public String getImageSlide1ContentType() {
        return imageSlide1ContentType;
    }

    public DernieresNouvelles imageSlide1ContentType(String imageSlide1ContentType) {
        this.imageSlide1ContentType = imageSlide1ContentType;
        return this;
    }

    public void setImageSlide1ContentType(String imageSlide1ContentType) {
        this.imageSlide1ContentType = imageSlide1ContentType;
    }

    public byte[] getImageSlide2() {
        return imageSlide2;
    }

    public DernieresNouvelles imageSlide2(byte[] imageSlide2) {
        this.imageSlide2 = imageSlide2;
        return this;
    }

    public void setImageSlide2(byte[] imageSlide2) {
        this.imageSlide2 = imageSlide2;
    }

    public String getImageSlide2ContentType() {
        return imageSlide2ContentType;
    }

    public DernieresNouvelles imageSlide2ContentType(String imageSlide2ContentType) {
        this.imageSlide2ContentType = imageSlide2ContentType;
        return this;
    }

    public void setImageSlide2ContentType(String imageSlide2ContentType) {
        this.imageSlide2ContentType = imageSlide2ContentType;
    }

    public byte[] getImageSlide3() {
        return imageSlide3;
    }

    public DernieresNouvelles imageSlide3(byte[] imageSlide3) {
        this.imageSlide3 = imageSlide3;
        return this;
    }

    public void setImageSlide3(byte[] imageSlide3) {
        this.imageSlide3 = imageSlide3;
    }

    public String getImageSlide3ContentType() {
        return imageSlide3ContentType;
    }

    public DernieresNouvelles imageSlide3ContentType(String imageSlide3ContentType) {
        this.imageSlide3ContentType = imageSlide3ContentType;
        return this;
    }

    public void setImageSlide3ContentType(String imageSlide3ContentType) {
        this.imageSlide3ContentType = imageSlide3ContentType;
    }

    public byte[] getImageSlide4() {
        return imageSlide4;
    }

    public DernieresNouvelles imageSlide4(byte[] imageSlide4) {
        this.imageSlide4 = imageSlide4;
        return this;
    }

    public void setImageSlide4(byte[] imageSlide4) {
        this.imageSlide4 = imageSlide4;
    }

    public String getImageSlide4ContentType() {
        return imageSlide4ContentType;
    }

    public DernieresNouvelles imageSlide4ContentType(String imageSlide4ContentType) {
        this.imageSlide4ContentType = imageSlide4ContentType;
        return this;
    }

    public void setImageSlide4ContentType(String imageSlide4ContentType) {
        this.imageSlide4ContentType = imageSlide4ContentType;
    }

    public byte[] getImageSlide5() {
        return imageSlide5;
    }

    public DernieresNouvelles imageSlide5(byte[] imageSlide5) {
        this.imageSlide5 = imageSlide5;
        return this;
    }

    public void setImageSlide5(byte[] imageSlide5) {
        this.imageSlide5 = imageSlide5;
    }

    public String getImageSlide5ContentType() {
        return imageSlide5ContentType;
    }

    public DernieresNouvelles imageSlide5ContentType(String imageSlide5ContentType) {
        this.imageSlide5ContentType = imageSlide5ContentType;
        return this;
    }

    public void setImageSlide5ContentType(String imageSlide5ContentType) {
        this.imageSlide5ContentType = imageSlide5ContentType;
    }

    public byte[] getImageSlide6() {
        return imageSlide6;
    }

    public DernieresNouvelles imageSlide6(byte[] imageSlide6) {
        this.imageSlide6 = imageSlide6;
        return this;
    }

    public void setImageSlide6(byte[] imageSlide6) {
        this.imageSlide6 = imageSlide6;
    }

    public String getImageSlide6ContentType() {
        return imageSlide6ContentType;
    }

    public DernieresNouvelles imageSlide6ContentType(String imageSlide6ContentType) {
        this.imageSlide6ContentType = imageSlide6ContentType;
        return this;
    }

    public void setImageSlide6ContentType(String imageSlide6ContentType) {
        this.imageSlide6ContentType = imageSlide6ContentType;
    }

    public byte[] getImageSlide7() {
        return imageSlide7;
    }

    public DernieresNouvelles imageSlide7(byte[] imageSlide7) {
        this.imageSlide7 = imageSlide7;
        return this;
    }

    public void setImageSlide7(byte[] imageSlide7) {
        this.imageSlide7 = imageSlide7;
    }

    public String getImageSlide7ContentType() {
        return imageSlide7ContentType;
    }

    public DernieresNouvelles imageSlide7ContentType(String imageSlide7ContentType) {
        this.imageSlide7ContentType = imageSlide7ContentType;
        return this;
    }

    public void setImageSlide7ContentType(String imageSlide7ContentType) {
        this.imageSlide7ContentType = imageSlide7ContentType;
    }

    public byte[] getImageSlide8() {
        return imageSlide8;
    }

    public DernieresNouvelles imageSlide8(byte[] imageSlide8) {
        this.imageSlide8 = imageSlide8;
        return this;
    }

    public void setImageSlide8(byte[] imageSlide8) {
        this.imageSlide8 = imageSlide8;
    }

    public String getImageSlide8ContentType() {
        return imageSlide8ContentType;
    }

    public DernieresNouvelles imageSlide8ContentType(String imageSlide8ContentType) {
        this.imageSlide8ContentType = imageSlide8ContentType;
        return this;
    }

    public void setImageSlide8ContentType(String imageSlide8ContentType) {
        this.imageSlide8ContentType = imageSlide8ContentType;
    }

    public byte[] getImageSlide9() {
        return imageSlide9;
    }

    public DernieresNouvelles imageSlide9(byte[] imageSlide9) {
        this.imageSlide9 = imageSlide9;
        return this;
    }

    public void setImageSlide9(byte[] imageSlide9) {
        this.imageSlide9 = imageSlide9;
    }

    public String getImageSlide9ContentType() {
        return imageSlide9ContentType;
    }

    public DernieresNouvelles imageSlide9ContentType(String imageSlide9ContentType) {
        this.imageSlide9ContentType = imageSlide9ContentType;
        return this;
    }

    public void setImageSlide9ContentType(String imageSlide9ContentType) {
        this.imageSlide9ContentType = imageSlide9ContentType;
    }

    public byte[] getImageSlide10() {
        return imageSlide10;
    }

    public DernieresNouvelles imageSlide10(byte[] imageSlide10) {
        this.imageSlide10 = imageSlide10;
        return this;
    }

    public void setImageSlide10(byte[] imageSlide10) {
        this.imageSlide10 = imageSlide10;
    }

    public String getImageSlide10ContentType() {
        return imageSlide10ContentType;
    }

    public DernieresNouvelles imageSlide10ContentType(String imageSlide10ContentType) {
        this.imageSlide10ContentType = imageSlide10ContentType;
        return this;
    }

    public void setImageSlide10ContentType(String imageSlide10ContentType) {
        this.imageSlide10ContentType = imageSlide10ContentType;
    }

    public String getReadMore1() {
        return readMore1;
    }

    public DernieresNouvelles readMore1(String readMore1) {
        this.readMore1 = readMore1;
        return this;
    }

    public void setReadMore1(String readMore1) {
        this.readMore1 = readMore1;
    }

    public String getReadMore2() {
        return readMore2;
    }

    public DernieresNouvelles readMore2(String readMore2) {
        this.readMore2 = readMore2;
        return this;
    }

    public void setReadMore2(String readMore2) {
        this.readMore2 = readMore2;
    }

    public String getReadMore3() {
        return readMore3;
    }

    public DernieresNouvelles readMore3(String readMore3) {
        this.readMore3 = readMore3;
        return this;
    }

    public void setReadMore3(String readMore3) {
        this.readMore3 = readMore3;
    }

    public String getReadMore4() {
        return readMore4;
    }

    public DernieresNouvelles readMore4(String readMore4) {
        this.readMore4 = readMore4;
        return this;
    }

    public void setReadMore4(String readMore4) {
        this.readMore4 = readMore4;
    }

    public String getReadMore5() {
        return readMore5;
    }

    public DernieresNouvelles readMore5(String readMore5) {
        this.readMore5 = readMore5;
        return this;
    }

    public void setReadMore5(String readMore5) {
        this.readMore5 = readMore5;
    }

    public String getReadMore6() {
        return readMore6;
    }

    public DernieresNouvelles readMore6(String readMore6) {
        this.readMore6 = readMore6;
        return this;
    }

    public void setReadMore6(String readMore6) {
        this.readMore6 = readMore6;
    }

    public String getReadMore7() {
        return readMore7;
    }

    public DernieresNouvelles readMore7(String readMore7) {
        this.readMore7 = readMore7;
        return this;
    }

    public void setReadMore7(String readMore7) {
        this.readMore7 = readMore7;
    }

    public String getReadMore8() {
        return readMore8;
    }

    public DernieresNouvelles readMore8(String readMore8) {
        this.readMore8 = readMore8;
        return this;
    }

    public void setReadMore8(String readMore8) {
        this.readMore8 = readMore8;
    }

    public String getReadMore9() {
        return readMore9;
    }

    public DernieresNouvelles readMore9(String readMore9) {
        this.readMore9 = readMore9;
        return this;
    }

    public void setReadMore9(String readMore9) {
        this.readMore9 = readMore9;
    }

    public String getReadMore10() {
        return readMore10;
    }

    public DernieresNouvelles readMore10(String readMore10) {
        this.readMore10 = readMore10;
        return this;
    }

    public void setReadMore10(String readMore10) {
        this.readMore10 = readMore10;
    }

    public String getDate1() {
        return date1;
    }

    public DernieresNouvelles date1(String date1) {
        this.date1 = date1;
        return this;
    }

    public void setDate1(String date1) {
        this.date1 = date1;
    }

    public String getDate2() {
        return date2;
    }

    public DernieresNouvelles date2(String date2) {
        this.date2 = date2;
        return this;
    }

    public void setDate2(String date2) {
        this.date2 = date2;
    }

    public String getDate3() {
        return date3;
    }

    public DernieresNouvelles date3(String date3) {
        this.date3 = date3;
        return this;
    }

    public void setDate3(String date3) {
        this.date3 = date3;
    }

    public String getDate4() {
        return date4;
    }

    public DernieresNouvelles date4(String date4) {
        this.date4 = date4;
        return this;
    }

    public void setDate4(String date4) {
        this.date4 = date4;
    }

    public String getDate5() {
        return date5;
    }

    public DernieresNouvelles date5(String date5) {
        this.date5 = date5;
        return this;
    }

    public void setDate5(String date5) {
        this.date5 = date5;
    }

    public String getDate6() {
        return date6;
    }

    public DernieresNouvelles date6(String date6) {
        this.date6 = date6;
        return this;
    }

    public void setDate6(String date6) {
        this.date6 = date6;
    }

    public String getDate7() {
        return date7;
    }

    public DernieresNouvelles date7(String date7) {
        this.date7 = date7;
        return this;
    }

    public void setDate7(String date7) {
        this.date7 = date7;
    }

    public String getDate8() {
        return date8;
    }

    public DernieresNouvelles date8(String date8) {
        this.date8 = date8;
        return this;
    }

    public void setDate8(String date8) {
        this.date8 = date8;
    }

    public String getDate9() {
        return date9;
    }

    public DernieresNouvelles date9(String date9) {
        this.date9 = date9;
        return this;
    }

    public void setDate9(String date9) {
        this.date9 = date9;
    }

    public String getDate10() {
        return date10;
    }

    public DernieresNouvelles date10(String date10) {
        this.date10 = date10;
        return this;
    }

    public void setDate10(String date10) {
        this.date10 = date10;
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
            ", textSlide9Ger='" + getTextSlide9Ger() + "'" +
            ", textSlide9Sw='" + getTextSlide9Sw() + "'" +
            ", textSlide10Fr='" + getTextSlide10Fr() + "'" +
            ", textSlide10En='" + getTextSlide10En() + "'" +
            ", textSlide10Ger='" + getTextSlide10Ger() + "'" +
            ", textSlide10Sw='" + getTextSlide10Sw() + "'" +
            ", imageSlide1='" + getImageSlide1() + "'" +
            ", imageSlide1ContentType='" + getImageSlide1ContentType() + "'" +
            ", imageSlide2='" + getImageSlide2() + "'" +
            ", imageSlide2ContentType='" + getImageSlide2ContentType() + "'" +
            ", imageSlide3='" + getImageSlide3() + "'" +
            ", imageSlide3ContentType='" + getImageSlide3ContentType() + "'" +
            ", imageSlide4='" + getImageSlide4() + "'" +
            ", imageSlide4ContentType='" + getImageSlide4ContentType() + "'" +
            ", imageSlide5='" + getImageSlide5() + "'" +
            ", imageSlide5ContentType='" + getImageSlide5ContentType() + "'" +
            ", imageSlide6='" + getImageSlide6() + "'" +
            ", imageSlide6ContentType='" + getImageSlide6ContentType() + "'" +
            ", imageSlide7='" + getImageSlide7() + "'" +
            ", imageSlide7ContentType='" + getImageSlide7ContentType() + "'" +
            ", imageSlide8='" + getImageSlide8() + "'" +
            ", imageSlide8ContentType='" + getImageSlide8ContentType() + "'" +
            ", imageSlide9='" + getImageSlide9() + "'" +
            ", imageSlide9ContentType='" + getImageSlide9ContentType() + "'" +
            ", imageSlide10='" + getImageSlide10() + "'" +
            ", imageSlide10ContentType='" + getImageSlide10ContentType() + "'" +
            ", readMore1='" + getReadMore1() + "'" +
            ", readMore2='" + getReadMore2() + "'" +
            ", readMore3='" + getReadMore3() + "'" +
            ", readMore4='" + getReadMore4() + "'" +
            ", readMore5='" + getReadMore5() + "'" +
            ", readMore6='" + getReadMore6() + "'" +
            ", readMore7='" + getReadMore7() + "'" +
            ", readMore8='" + getReadMore8() + "'" +
            ", readMore9='" + getReadMore9() + "'" +
            ", readMore10='" + getReadMore10() + "'" +
            ", date1='" + getDate1() + "'" +
            ", date2='" + getDate2() + "'" +
            ", date3='" + getDate3() + "'" +
            ", date4='" + getDate4() + "'" +
            ", date5='" + getDate5() + "'" +
            ", date6='" + getDate6() + "'" +
            ", date7='" + getDate7() + "'" +
            ", date8='" + getDate8() + "'" +
            ", date9='" + getDate9() + "'" +
            ", date10='" + getDate10() + "'" +
            "}";
    }
}
