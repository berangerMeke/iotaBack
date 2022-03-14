package com.iota.orign.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A Avantages.
 */
@Entity
@Table(name = "avantages")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Avantages implements Serializable {

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

    @Column(name = "text_paragraphe_1_fr")
    private String textParagraphe1FR;

    @Column(name = "text_paragraphe_1_en")
    private String textParagraphe1En;

    @Column(name = "text_paragraphe_1_ger")
    private String textParagraphe1Ger;

    @Column(name = "text_paragraphe_1_sw")
    private String textParagraphe1Sw;

    @Column(name = "text_paragraphe_2_fr")
    private String textParagraphe2Fr;

    @Column(name = "text_paragraphe_2_en")
    private String textParagraphe2En;

    @Column(name = "text_paragraphe_2_ger")
    private String textParagraphe2Ger;

    @Column(name = "text_paragraphe_2_sw")
    private String textParagraphe2Sw;

    @Column(name = "text_paragraphe_3_fr")
    private String textParagraphe3FR;

    @Column(name = "text_paragraphe_3_en")
    private String textParagraphe3En;

    @Column(name = "text_paragraphe_3_ger")
    private String textParagraphe3Ger;

    @Column(name = "text_paragraphe_3_sw")
    private String textParagraphe3Sw;

    @Column(name = "text_paragraphe_4_fr")
    private String textParagraphe4Fr;

    @Column(name = "text_paragraphe_4_en")
    private String textParagraphe4En;

    @Column(name = "text_paragraphe_4_ger")
    private String textParagraphe4Ger;

    @Column(name = "text_paragraphe_4_sw")
    private String textParagraphe4Sw;

    @Column(name = "text_paragraphe_5_fr")
    private String textParagraphe5Fr;

    @Column(name = "text_paragraphe_5_en")
    private String textParagraphe5En;

    @Column(name = "text_paragraphe_5_ger")
    private String textParagraphe5Ger;

    @Column(name = "text_paragraphe_5_sw")
    private String textParagraphe5Sw;

    @Column(name = "text_paragraphe_6_fr")
    private String textParagraphe6Fr;

    @Column(name = "text_paragraphe_6_en")
    private String textParagraphe6En;

    @Column(name = "text_paragraphe_6_ger")
    private String textParagraphe6Ger;

    @Column(name = "text_paragraphe_6_sw")
    private String textParagraphe6Sw;

    @Column(name = "text_paragraphe_7_fr")
    private String textParagraphe7Fr;

    @Column(name = "text_paragraphe_7_en")
    private String textParagraphe7En;

    @Column(name = "text_paragraphe_7_ger")
    private String textParagraphe7Ger;

    @Column(name = "text_paragraphe_7_sw")
    private String textParagraphe7Sw;

    @Column(name = "text_paragraphe_8_fr")
    private String textParagraphe8Fr;

    @Column(name = "text_paragraphe_8_en")
    private String textParagraphe8En;

    @Column(name = "text_paragraphe_8_ger")
    private String textParagraphe8Ger;

    @Column(name = "text_paragraphe_8_sw")
    private String textParagraphe8Sw;

    @Lob
    @Column(name = "image")
    private byte[] image;

    @Column(name = "image_content_type")
    private String imageContentType;

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

    public Avantages titreFr(String titreFr) {
        this.titreFr = titreFr;
        return this;
    }

    public void setTitreFr(String titreFr) {
        this.titreFr = titreFr;
    }

    public String getTitreEn() {
        return titreEn;
    }

    public Avantages titreEn(String titreEn) {
        this.titreEn = titreEn;
        return this;
    }

    public void setTitreEn(String titreEn) {
        this.titreEn = titreEn;
    }

    public String getTitreGer() {
        return titreGer;
    }

    public Avantages titreGer(String titreGer) {
        this.titreGer = titreGer;
        return this;
    }

    public void setTitreGer(String titreGer) {
        this.titreGer = titreGer;
    }

    public String getTitreSw() {
        return titreSw;
    }

    public Avantages titreSw(String titreSw) {
        this.titreSw = titreSw;
        return this;
    }

    public void setTitreSw(String titreSw) {
        this.titreSw = titreSw;
    }

    public String getSousTitreFr() {
        return sousTitreFr;
    }

    public Avantages sousTitreFr(String sousTitreFr) {
        this.sousTitreFr = sousTitreFr;
        return this;
    }

    public void setSousTitreFr(String sousTitreFr) {
        this.sousTitreFr = sousTitreFr;
    }

    public String getSousTitreEn() {
        return sousTitreEn;
    }

    public Avantages sousTitreEn(String sousTitreEn) {
        this.sousTitreEn = sousTitreEn;
        return this;
    }

    public void setSousTitreEn(String sousTitreEn) {
        this.sousTitreEn = sousTitreEn;
    }

    public String getSousTitreGer() {
        return sousTitreGer;
    }

    public Avantages sousTitreGer(String sousTitreGer) {
        this.sousTitreGer = sousTitreGer;
        return this;
    }

    public void setSousTitreGer(String sousTitreGer) {
        this.sousTitreGer = sousTitreGer;
    }

    public String getSousTitreSw() {
        return sousTitreSw;
    }

    public Avantages sousTitreSw(String sousTitreSw) {
        this.sousTitreSw = sousTitreSw;
        return this;
    }

    public void setSousTitreSw(String sousTitreSw) {
        this.sousTitreSw = sousTitreSw;
    }

    public String getTextParagraphe1FR() {
        return textParagraphe1FR;
    }

    public Avantages textParagraphe1FR(String textParagraphe1FR) {
        this.textParagraphe1FR = textParagraphe1FR;
        return this;
    }

    public void setTextParagraphe1FR(String textParagraphe1FR) {
        this.textParagraphe1FR = textParagraphe1FR;
    }

    public String getTextParagraphe1En() {
        return textParagraphe1En;
    }

    public Avantages textParagraphe1En(String textParagraphe1En) {
        this.textParagraphe1En = textParagraphe1En;
        return this;
    }

    public void setTextParagraphe1En(String textParagraphe1En) {
        this.textParagraphe1En = textParagraphe1En;
    }

    public String getTextParagraphe1Ger() {
        return textParagraphe1Ger;
    }

    public Avantages textParagraphe1Ger(String textParagraphe1Ger) {
        this.textParagraphe1Ger = textParagraphe1Ger;
        return this;
    }

    public void setTextParagraphe1Ger(String textParagraphe1Ger) {
        this.textParagraphe1Ger = textParagraphe1Ger;
    }

    public String getTextParagraphe1Sw() {
        return textParagraphe1Sw;
    }

    public Avantages textParagraphe1Sw(String textParagraphe1Sw) {
        this.textParagraphe1Sw = textParagraphe1Sw;
        return this;
    }

    public void setTextParagraphe1Sw(String textParagraphe1Sw) {
        this.textParagraphe1Sw = textParagraphe1Sw;
    }

    public String getTextParagraphe2Fr() {
        return textParagraphe2Fr;
    }

    public Avantages textParagraphe2Fr(String textParagraphe2Fr) {
        this.textParagraphe2Fr = textParagraphe2Fr;
        return this;
    }

    public void setTextParagraphe2Fr(String textParagraphe2Fr) {
        this.textParagraphe2Fr = textParagraphe2Fr;
    }

    public String getTextParagraphe2En() {
        return textParagraphe2En;
    }

    public Avantages textParagraphe2En(String textParagraphe2En) {
        this.textParagraphe2En = textParagraphe2En;
        return this;
    }

    public void setTextParagraphe2En(String textParagraphe2En) {
        this.textParagraphe2En = textParagraphe2En;
    }

    public String getTextParagraphe2Ger() {
        return textParagraphe2Ger;
    }

    public Avantages textParagraphe2Ger(String textParagraphe2Ger) {
        this.textParagraphe2Ger = textParagraphe2Ger;
        return this;
    }

    public void setTextParagraphe2Ger(String textParagraphe2Ger) {
        this.textParagraphe2Ger = textParagraphe2Ger;
    }

    public String getTextParagraphe2Sw() {
        return textParagraphe2Sw;
    }

    public Avantages textParagraphe2Sw(String textParagraphe2Sw) {
        this.textParagraphe2Sw = textParagraphe2Sw;
        return this;
    }

    public void setTextParagraphe2Sw(String textParagraphe2Sw) {
        this.textParagraphe2Sw = textParagraphe2Sw;
    }

    public String getTextParagraphe3FR() {
        return textParagraphe3FR;
    }

    public Avantages textParagraphe3FR(String textParagraphe3FR) {
        this.textParagraphe3FR = textParagraphe3FR;
        return this;
    }

    public void setTextParagraphe3FR(String textParagraphe3FR) {
        this.textParagraphe3FR = textParagraphe3FR;
    }

    public String getTextParagraphe3En() {
        return textParagraphe3En;
    }

    public Avantages textParagraphe3En(String textParagraphe3En) {
        this.textParagraphe3En = textParagraphe3En;
        return this;
    }

    public void setTextParagraphe3En(String textParagraphe3En) {
        this.textParagraphe3En = textParagraphe3En;
    }

    public String getTextParagraphe3Ger() {
        return textParagraphe3Ger;
    }

    public Avantages textParagraphe3Ger(String textParagraphe3Ger) {
        this.textParagraphe3Ger = textParagraphe3Ger;
        return this;
    }

    public void setTextParagraphe3Ger(String textParagraphe3Ger) {
        this.textParagraphe3Ger = textParagraphe3Ger;
    }

    public String getTextParagraphe3Sw() {
        return textParagraphe3Sw;
    }

    public Avantages textParagraphe3Sw(String textParagraphe3Sw) {
        this.textParagraphe3Sw = textParagraphe3Sw;
        return this;
    }

    public void setTextParagraphe3Sw(String textParagraphe3Sw) {
        this.textParagraphe3Sw = textParagraphe3Sw;
    }

    public String getTextParagraphe4Fr() {
        return textParagraphe4Fr;
    }

    public Avantages textParagraphe4Fr(String textParagraphe4Fr) {
        this.textParagraphe4Fr = textParagraphe4Fr;
        return this;
    }

    public void setTextParagraphe4Fr(String textParagraphe4Fr) {
        this.textParagraphe4Fr = textParagraphe4Fr;
    }

    public String getTextParagraphe4En() {
        return textParagraphe4En;
    }

    public Avantages textParagraphe4En(String textParagraphe4En) {
        this.textParagraphe4En = textParagraphe4En;
        return this;
    }

    public void setTextParagraphe4En(String textParagraphe4En) {
        this.textParagraphe4En = textParagraphe4En;
    }

    public String getTextParagraphe4Ger() {
        return textParagraphe4Ger;
    }

    public Avantages textParagraphe4Ger(String textParagraphe4Ger) {
        this.textParagraphe4Ger = textParagraphe4Ger;
        return this;
    }

    public void setTextParagraphe4Ger(String textParagraphe4Ger) {
        this.textParagraphe4Ger = textParagraphe4Ger;
    }

    public String getTextParagraphe4Sw() {
        return textParagraphe4Sw;
    }

    public Avantages textParagraphe4Sw(String textParagraphe4Sw) {
        this.textParagraphe4Sw = textParagraphe4Sw;
        return this;
    }

    public void setTextParagraphe4Sw(String textParagraphe4Sw) {
        this.textParagraphe4Sw = textParagraphe4Sw;
    }

    public String getTextParagraphe5Fr() {
        return textParagraphe5Fr;
    }

    public Avantages textParagraphe5Fr(String textParagraphe5Fr) {
        this.textParagraphe5Fr = textParagraphe5Fr;
        return this;
    }

    public void setTextParagraphe5Fr(String textParagraphe5Fr) {
        this.textParagraphe5Fr = textParagraphe5Fr;
    }

    public String getTextParagraphe5En() {
        return textParagraphe5En;
    }

    public Avantages textParagraphe5En(String textParagraphe5En) {
        this.textParagraphe5En = textParagraphe5En;
        return this;
    }

    public void setTextParagraphe5En(String textParagraphe5En) {
        this.textParagraphe5En = textParagraphe5En;
    }

    public String getTextParagraphe5Ger() {
        return textParagraphe5Ger;
    }

    public Avantages textParagraphe5Ger(String textParagraphe5Ger) {
        this.textParagraphe5Ger = textParagraphe5Ger;
        return this;
    }

    public void setTextParagraphe5Ger(String textParagraphe5Ger) {
        this.textParagraphe5Ger = textParagraphe5Ger;
    }

    public String getTextParagraphe5Sw() {
        return textParagraphe5Sw;
    }

    public Avantages textParagraphe5Sw(String textParagraphe5Sw) {
        this.textParagraphe5Sw = textParagraphe5Sw;
        return this;
    }

    public void setTextParagraphe5Sw(String textParagraphe5Sw) {
        this.textParagraphe5Sw = textParagraphe5Sw;
    }

    public String getTextParagraphe6Fr() {
        return textParagraphe6Fr;
    }

    public Avantages textParagraphe6Fr(String textParagraphe6Fr) {
        this.textParagraphe6Fr = textParagraphe6Fr;
        return this;
    }

    public void setTextParagraphe6Fr(String textParagraphe6Fr) {
        this.textParagraphe6Fr = textParagraphe6Fr;
    }

    public String getTextParagraphe6En() {
        return textParagraphe6En;
    }

    public Avantages textParagraphe6En(String textParagraphe6En) {
        this.textParagraphe6En = textParagraphe6En;
        return this;
    }

    public void setTextParagraphe6En(String textParagraphe6En) {
        this.textParagraphe6En = textParagraphe6En;
    }

    public String getTextParagraphe6Ger() {
        return textParagraphe6Ger;
    }

    public Avantages textParagraphe6Ger(String textParagraphe6Ger) {
        this.textParagraphe6Ger = textParagraphe6Ger;
        return this;
    }

    public void setTextParagraphe6Ger(String textParagraphe6Ger) {
        this.textParagraphe6Ger = textParagraphe6Ger;
    }

    public String getTextParagraphe6Sw() {
        return textParagraphe6Sw;
    }

    public Avantages textParagraphe6Sw(String textParagraphe6Sw) {
        this.textParagraphe6Sw = textParagraphe6Sw;
        return this;
    }

    public void setTextParagraphe6Sw(String textParagraphe6Sw) {
        this.textParagraphe6Sw = textParagraphe6Sw;
    }

    public String getTextParagraphe7Fr() {
        return textParagraphe7Fr;
    }

    public Avantages textParagraphe7Fr(String textParagraphe7Fr) {
        this.textParagraphe7Fr = textParagraphe7Fr;
        return this;
    }

    public void setTextParagraphe7Fr(String textParagraphe7Fr) {
        this.textParagraphe7Fr = textParagraphe7Fr;
    }

    public String getTextParagraphe7En() {
        return textParagraphe7En;
    }

    public Avantages textParagraphe7En(String textParagraphe7En) {
        this.textParagraphe7En = textParagraphe7En;
        return this;
    }

    public void setTextParagraphe7En(String textParagraphe7En) {
        this.textParagraphe7En = textParagraphe7En;
    }

    public String getTextParagraphe7Ger() {
        return textParagraphe7Ger;
    }

    public Avantages textParagraphe7Ger(String textParagraphe7Ger) {
        this.textParagraphe7Ger = textParagraphe7Ger;
        return this;
    }

    public void setTextParagraphe7Ger(String textParagraphe7Ger) {
        this.textParagraphe7Ger = textParagraphe7Ger;
    }

    public String getTextParagraphe7Sw() {
        return textParagraphe7Sw;
    }

    public Avantages textParagraphe7Sw(String textParagraphe7Sw) {
        this.textParagraphe7Sw = textParagraphe7Sw;
        return this;
    }

    public void setTextParagraphe7Sw(String textParagraphe7Sw) {
        this.textParagraphe7Sw = textParagraphe7Sw;
    }

    public String getTextParagraphe8Fr() {
        return textParagraphe8Fr;
    }

    public Avantages textParagraphe8Fr(String textParagraphe8Fr) {
        this.textParagraphe8Fr = textParagraphe8Fr;
        return this;
    }

    public void setTextParagraphe8Fr(String textParagraphe8Fr) {
        this.textParagraphe8Fr = textParagraphe8Fr;
    }

    public String getTextParagraphe8En() {
        return textParagraphe8En;
    }

    public Avantages textParagraphe8En(String textParagraphe8En) {
        this.textParagraphe8En = textParagraphe8En;
        return this;
    }

    public void setTextParagraphe8En(String textParagraphe8En) {
        this.textParagraphe8En = textParagraphe8En;
    }

    public String getTextParagraphe8Ger() {
        return textParagraphe8Ger;
    }

    public Avantages textParagraphe8Ger(String textParagraphe8Ger) {
        this.textParagraphe8Ger = textParagraphe8Ger;
        return this;
    }

    public void setTextParagraphe8Ger(String textParagraphe8Ger) {
        this.textParagraphe8Ger = textParagraphe8Ger;
    }

    public String getTextParagraphe8Sw() {
        return textParagraphe8Sw;
    }

    public Avantages textParagraphe8Sw(String textParagraphe8Sw) {
        this.textParagraphe8Sw = textParagraphe8Sw;
        return this;
    }

    public void setTextParagraphe8Sw(String textParagraphe8Sw) {
        this.textParagraphe8Sw = textParagraphe8Sw;
    }

    public byte[] getImage() {
        return image;
    }

    public Avantages image(byte[] image) {
        this.image = image;
        return this;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getImageContentType() {
        return imageContentType;
    }

    public Avantages imageContentType(String imageContentType) {
        this.imageContentType = imageContentType;
        return this;
    }

    public void setImageContentType(String imageContentType) {
        this.imageContentType = imageContentType;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Avantages)) {
            return false;
        }
        return id != null && id.equals(((Avantages) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Avantages{" +
            "id=" + getId() +
            ", titreFr='" + getTitreFr() + "'" +
            ", titreEn='" + getTitreEn() + "'" +
            ", titreGer='" + getTitreGer() + "'" +
            ", titreSw='" + getTitreSw() + "'" +
            ", sousTitreFr='" + getSousTitreFr() + "'" +
            ", sousTitreEn='" + getSousTitreEn() + "'" +
            ", sousTitreGer='" + getSousTitreGer() + "'" +
            ", sousTitreSw='" + getSousTitreSw() + "'" +
            ", textParagraphe1FR='" + getTextParagraphe1FR() + "'" +
            ", textParagraphe1En='" + getTextParagraphe1En() + "'" +
            ", textParagraphe1Ger='" + getTextParagraphe1Ger() + "'" +
            ", textParagraphe1Sw='" + getTextParagraphe1Sw() + "'" +
            ", textParagraphe2Fr='" + getTextParagraphe2Fr() + "'" +
            ", textParagraphe2En='" + getTextParagraphe2En() + "'" +
            ", textParagraphe2Ger='" + getTextParagraphe2Ger() + "'" +
            ", textParagraphe2Sw='" + getTextParagraphe2Sw() + "'" +
            ", textParagraphe3FR='" + getTextParagraphe3FR() + "'" +
            ", textParagraphe3En='" + getTextParagraphe3En() + "'" +
            ", textParagraphe3Ger='" + getTextParagraphe3Ger() + "'" +
            ", textParagraphe3Sw='" + getTextParagraphe3Sw() + "'" +
            ", textParagraphe4Fr='" + getTextParagraphe4Fr() + "'" +
            ", textParagraphe4En='" + getTextParagraphe4En() + "'" +
            ", textParagraphe4Ger='" + getTextParagraphe4Ger() + "'" +
            ", textParagraphe4Sw='" + getTextParagraphe4Sw() + "'" +
            ", textParagraphe5Fr='" + getTextParagraphe5Fr() + "'" +
            ", textParagraphe5En='" + getTextParagraphe5En() + "'" +
            ", textParagraphe5Ger='" + getTextParagraphe5Ger() + "'" +
            ", textParagraphe5Sw='" + getTextParagraphe5Sw() + "'" +
            ", textParagraphe6Fr='" + getTextParagraphe6Fr() + "'" +
            ", textParagraphe6En='" + getTextParagraphe6En() + "'" +
            ", textParagraphe6Ger='" + getTextParagraphe6Ger() + "'" +
            ", textParagraphe6Sw='" + getTextParagraphe6Sw() + "'" +
            ", textParagraphe7Fr='" + getTextParagraphe7Fr() + "'" +
            ", textParagraphe7En='" + getTextParagraphe7En() + "'" +
            ", textParagraphe7Ger='" + getTextParagraphe7Ger() + "'" +
            ", textParagraphe7Sw='" + getTextParagraphe7Sw() + "'" +
            ", textParagraphe8Fr='" + getTextParagraphe8Fr() + "'" +
            ", textParagraphe8En='" + getTextParagraphe8En() + "'" +
            ", textParagraphe8Ger='" + getTextParagraphe8Ger() + "'" +
            ", textParagraphe8Sw='" + getTextParagraphe8Sw() + "'" +
            ", image='" + getImage() + "'" +
            ", imageContentType='" + getImageContentType() + "'" +
            "}";
    }
}
