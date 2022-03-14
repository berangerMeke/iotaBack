package com.iota.orign.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A Objectifs.
 */
@Entity
@Table(name = "objectifs")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Objectifs implements Serializable {

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
    private String textParagraphe1Fr;

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
    private String textParagraphe3Fr;

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

    public Objectifs titreFr(String titreFr) {
        this.titreFr = titreFr;
        return this;
    }

    public void setTitreFr(String titreFr) {
        this.titreFr = titreFr;
    }

    public String getTitreEn() {
        return titreEn;
    }

    public Objectifs titreEn(String titreEn) {
        this.titreEn = titreEn;
        return this;
    }

    public void setTitreEn(String titreEn) {
        this.titreEn = titreEn;
    }

    public String getTitreGer() {
        return titreGer;
    }

    public Objectifs titreGer(String titreGer) {
        this.titreGer = titreGer;
        return this;
    }

    public void setTitreGer(String titreGer) {
        this.titreGer = titreGer;
    }

    public String getTitreSw() {
        return titreSw;
    }

    public Objectifs titreSw(String titreSw) {
        this.titreSw = titreSw;
        return this;
    }

    public void setTitreSw(String titreSw) {
        this.titreSw = titreSw;
    }

    public String getSousTitreFr() {
        return sousTitreFr;
    }

    public Objectifs sousTitreFr(String sousTitreFr) {
        this.sousTitreFr = sousTitreFr;
        return this;
    }

    public void setSousTitreFr(String sousTitreFr) {
        this.sousTitreFr = sousTitreFr;
    }

    public String getSousTitreEn() {
        return sousTitreEn;
    }

    public Objectifs sousTitreEn(String sousTitreEn) {
        this.sousTitreEn = sousTitreEn;
        return this;
    }

    public void setSousTitreEn(String sousTitreEn) {
        this.sousTitreEn = sousTitreEn;
    }

    public String getSousTitreGer() {
        return sousTitreGer;
    }

    public Objectifs sousTitreGer(String sousTitreGer) {
        this.sousTitreGer = sousTitreGer;
        return this;
    }

    public void setSousTitreGer(String sousTitreGer) {
        this.sousTitreGer = sousTitreGer;
    }

    public String getSousTitreSw() {
        return sousTitreSw;
    }

    public Objectifs sousTitreSw(String sousTitreSw) {
        this.sousTitreSw = sousTitreSw;
        return this;
    }

    public void setSousTitreSw(String sousTitreSw) {
        this.sousTitreSw = sousTitreSw;
    }

    public String getTextParagraphe1Fr() {
        return textParagraphe1Fr;
    }

    public Objectifs textParagraphe1Fr(String textParagraphe1Fr) {
        this.textParagraphe1Fr = textParagraphe1Fr;
        return this;
    }

    public void setTextParagraphe1Fr(String textParagraphe1Fr) {
        this.textParagraphe1Fr = textParagraphe1Fr;
    }

    public String getTextParagraphe1En() {
        return textParagraphe1En;
    }

    public Objectifs textParagraphe1En(String textParagraphe1En) {
        this.textParagraphe1En = textParagraphe1En;
        return this;
    }

    public void setTextParagraphe1En(String textParagraphe1En) {
        this.textParagraphe1En = textParagraphe1En;
    }

    public String getTextParagraphe1Ger() {
        return textParagraphe1Ger;
    }

    public Objectifs textParagraphe1Ger(String textParagraphe1Ger) {
        this.textParagraphe1Ger = textParagraphe1Ger;
        return this;
    }

    public void setTextParagraphe1Ger(String textParagraphe1Ger) {
        this.textParagraphe1Ger = textParagraphe1Ger;
    }

    public String getTextParagraphe1Sw() {
        return textParagraphe1Sw;
    }

    public Objectifs textParagraphe1Sw(String textParagraphe1Sw) {
        this.textParagraphe1Sw = textParagraphe1Sw;
        return this;
    }

    public void setTextParagraphe1Sw(String textParagraphe1Sw) {
        this.textParagraphe1Sw = textParagraphe1Sw;
    }

    public String getTextParagraphe2Fr() {
        return textParagraphe2Fr;
    }

    public Objectifs textParagraphe2Fr(String textParagraphe2Fr) {
        this.textParagraphe2Fr = textParagraphe2Fr;
        return this;
    }

    public void setTextParagraphe2Fr(String textParagraphe2Fr) {
        this.textParagraphe2Fr = textParagraphe2Fr;
    }

    public String getTextParagraphe2En() {
        return textParagraphe2En;
    }

    public Objectifs textParagraphe2En(String textParagraphe2En) {
        this.textParagraphe2En = textParagraphe2En;
        return this;
    }

    public void setTextParagraphe2En(String textParagraphe2En) {
        this.textParagraphe2En = textParagraphe2En;
    }

    public String getTextParagraphe2Ger() {
        return textParagraphe2Ger;
    }

    public Objectifs textParagraphe2Ger(String textParagraphe2Ger) {
        this.textParagraphe2Ger = textParagraphe2Ger;
        return this;
    }

    public void setTextParagraphe2Ger(String textParagraphe2Ger) {
        this.textParagraphe2Ger = textParagraphe2Ger;
    }

    public String getTextParagraphe2Sw() {
        return textParagraphe2Sw;
    }

    public Objectifs textParagraphe2Sw(String textParagraphe2Sw) {
        this.textParagraphe2Sw = textParagraphe2Sw;
        return this;
    }

    public void setTextParagraphe2Sw(String textParagraphe2Sw) {
        this.textParagraphe2Sw = textParagraphe2Sw;
    }

    public String getTextParagraphe3Fr() {
        return textParagraphe3Fr;
    }

    public Objectifs textParagraphe3Fr(String textParagraphe3Fr) {
        this.textParagraphe3Fr = textParagraphe3Fr;
        return this;
    }

    public void setTextParagraphe3Fr(String textParagraphe3Fr) {
        this.textParagraphe3Fr = textParagraphe3Fr;
    }

    public String getTextParagraphe3En() {
        return textParagraphe3En;
    }

    public Objectifs textParagraphe3En(String textParagraphe3En) {
        this.textParagraphe3En = textParagraphe3En;
        return this;
    }

    public void setTextParagraphe3En(String textParagraphe3En) {
        this.textParagraphe3En = textParagraphe3En;
    }

    public String getTextParagraphe3Ger() {
        return textParagraphe3Ger;
    }

    public Objectifs textParagraphe3Ger(String textParagraphe3Ger) {
        this.textParagraphe3Ger = textParagraphe3Ger;
        return this;
    }

    public void setTextParagraphe3Ger(String textParagraphe3Ger) {
        this.textParagraphe3Ger = textParagraphe3Ger;
    }

    public String getTextParagraphe3Sw() {
        return textParagraphe3Sw;
    }

    public Objectifs textParagraphe3Sw(String textParagraphe3Sw) {
        this.textParagraphe3Sw = textParagraphe3Sw;
        return this;
    }

    public void setTextParagraphe3Sw(String textParagraphe3Sw) {
        this.textParagraphe3Sw = textParagraphe3Sw;
    }

    public String getTextParagraphe4Fr() {
        return textParagraphe4Fr;
    }

    public Objectifs textParagraphe4Fr(String textParagraphe4Fr) {
        this.textParagraphe4Fr = textParagraphe4Fr;
        return this;
    }

    public void setTextParagraphe4Fr(String textParagraphe4Fr) {
        this.textParagraphe4Fr = textParagraphe4Fr;
    }

    public String getTextParagraphe4En() {
        return textParagraphe4En;
    }

    public Objectifs textParagraphe4En(String textParagraphe4En) {
        this.textParagraphe4En = textParagraphe4En;
        return this;
    }

    public void setTextParagraphe4En(String textParagraphe4En) {
        this.textParagraphe4En = textParagraphe4En;
    }

    public String getTextParagraphe4Ger() {
        return textParagraphe4Ger;
    }

    public Objectifs textParagraphe4Ger(String textParagraphe4Ger) {
        this.textParagraphe4Ger = textParagraphe4Ger;
        return this;
    }

    public void setTextParagraphe4Ger(String textParagraphe4Ger) {
        this.textParagraphe4Ger = textParagraphe4Ger;
    }

    public String getTextParagraphe4Sw() {
        return textParagraphe4Sw;
    }

    public Objectifs textParagraphe4Sw(String textParagraphe4Sw) {
        this.textParagraphe4Sw = textParagraphe4Sw;
        return this;
    }

    public void setTextParagraphe4Sw(String textParagraphe4Sw) {
        this.textParagraphe4Sw = textParagraphe4Sw;
    }

    public String getTextParagraphe5Fr() {
        return textParagraphe5Fr;
    }

    public Objectifs textParagraphe5Fr(String textParagraphe5Fr) {
        this.textParagraphe5Fr = textParagraphe5Fr;
        return this;
    }

    public void setTextParagraphe5Fr(String textParagraphe5Fr) {
        this.textParagraphe5Fr = textParagraphe5Fr;
    }

    public String getTextParagraphe5En() {
        return textParagraphe5En;
    }

    public Objectifs textParagraphe5En(String textParagraphe5En) {
        this.textParagraphe5En = textParagraphe5En;
        return this;
    }

    public void setTextParagraphe5En(String textParagraphe5En) {
        this.textParagraphe5En = textParagraphe5En;
    }

    public String getTextParagraphe5Ger() {
        return textParagraphe5Ger;
    }

    public Objectifs textParagraphe5Ger(String textParagraphe5Ger) {
        this.textParagraphe5Ger = textParagraphe5Ger;
        return this;
    }

    public void setTextParagraphe5Ger(String textParagraphe5Ger) {
        this.textParagraphe5Ger = textParagraphe5Ger;
    }

    public String getTextParagraphe5Sw() {
        return textParagraphe5Sw;
    }

    public Objectifs textParagraphe5Sw(String textParagraphe5Sw) {
        this.textParagraphe5Sw = textParagraphe5Sw;
        return this;
    }

    public void setTextParagraphe5Sw(String textParagraphe5Sw) {
        this.textParagraphe5Sw = textParagraphe5Sw;
    }

    public byte[] getImage() {
        return image;
    }

    public Objectifs image(byte[] image) {
        this.image = image;
        return this;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getImageContentType() {
        return imageContentType;
    }

    public Objectifs imageContentType(String imageContentType) {
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
        if (!(o instanceof Objectifs)) {
            return false;
        }
        return id != null && id.equals(((Objectifs) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Objectifs{" +
            "id=" + getId() +
            ", titreFr='" + getTitreFr() + "'" +
            ", titreEn='" + getTitreEn() + "'" +
            ", titreGer='" + getTitreGer() + "'" +
            ", titreSw='" + getTitreSw() + "'" +
            ", sousTitreFr='" + getSousTitreFr() + "'" +
            ", sousTitreEn='" + getSousTitreEn() + "'" +
            ", sousTitreGer='" + getSousTitreGer() + "'" +
            ", sousTitreSw='" + getSousTitreSw() + "'" +
            ", textParagraphe1Fr='" + getTextParagraphe1Fr() + "'" +
            ", textParagraphe1En='" + getTextParagraphe1En() + "'" +
            ", textParagraphe1Ger='" + getTextParagraphe1Ger() + "'" +
            ", textParagraphe1Sw='" + getTextParagraphe1Sw() + "'" +
            ", textParagraphe2Fr='" + getTextParagraphe2Fr() + "'" +
            ", textParagraphe2En='" + getTextParagraphe2En() + "'" +
            ", textParagraphe2Ger='" + getTextParagraphe2Ger() + "'" +
            ", textParagraphe2Sw='" + getTextParagraphe2Sw() + "'" +
            ", textParagraphe3Fr='" + getTextParagraphe3Fr() + "'" +
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
            ", image='" + getImage() + "'" +
            ", imageContentType='" + getImageContentType() + "'" +
            "}";
    }
}
