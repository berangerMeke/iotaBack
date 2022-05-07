package com.iota.orign.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A Imprint.
 */
@Entity
@Table(name = "imprint")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Imprint implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titre_imprint_en")
    private String titreImprintEn;

    @Column(name = "titre_imprint_fr")
    private String titreImprintFr;

    @Column(name = "titre_imprint_ger")
    private String titreImprintGer;

    @Column(name = "titre_imprint_sw")
    private String titreImprintSw;

    @Size(max = 7000)
    @Column(name = "contenu_imprint_en", length = 7000)
    private String contenuImprintEn;

    @Size(max = 7000)
    @Column(name = "contenu_imprint_ger", length = 7000)
    private String contenuImprintGer;

    @Size(max = 7000)
    @Column(name = "contenu_imprint_fr", length = 7000)
    private String contenuImprintFr;

    @Size(max = 7000)
    @Column(name = "contenu_imprint_sw", length = 7000)
    private String contenuImprintSw;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitreImprintEn() {
        return titreImprintEn;
    }

    public Imprint titreImprintEn(String titreImprintEn) {
        this.titreImprintEn = titreImprintEn;
        return this;
    }

    public void setTitreImprintEn(String titreImprintEn) {
        this.titreImprintEn = titreImprintEn;
    }

    public String getTitreImprintFr() {
        return titreImprintFr;
    }

    public Imprint titreImprintFr(String titreImprintFr) {
        this.titreImprintFr = titreImprintFr;
        return this;
    }

    public void setTitreImprintFr(String titreImprintFr) {
        this.titreImprintFr = titreImprintFr;
    }

    public String getTitreImprintGer() {
        return titreImprintGer;
    }

    public Imprint titreImprintGer(String titreImprintGer) {
        this.titreImprintGer = titreImprintGer;
        return this;
    }

    public void setTitreImprintGer(String titreImprintGer) {
        this.titreImprintGer = titreImprintGer;
    }

    public String getTitreImprintSw() {
        return titreImprintSw;
    }

    public Imprint titreImprintSw(String titreImprintSw) {
        this.titreImprintSw = titreImprintSw;
        return this;
    }

    public void setTitreImprintSw(String titreImprintSw) {
        this.titreImprintSw = titreImprintSw;
    }

    public String getContenuImprintEn() {
        return contenuImprintEn;
    }

    public Imprint contenuImprintEn(String contenuImprintEn) {
        this.contenuImprintEn = contenuImprintEn;
        return this;
    }

    public void setContenuImprintEn(String contenuImprintEn) {
        this.contenuImprintEn = contenuImprintEn;
    }

    public String getContenuImprintGer() {
        return contenuImprintGer;
    }

    public Imprint contenuImprintGer(String contenuImprintGer) {
        this.contenuImprintGer = contenuImprintGer;
        return this;
    }

    public void setContenuImprintGer(String contenuImprintGer) {
        this.contenuImprintGer = contenuImprintGer;
    }

    public String getContenuImprintFr() {
        return contenuImprintFr;
    }

    public Imprint contenuImprintFr(String contenuImprintFr) {
        this.contenuImprintFr = contenuImprintFr;
        return this;
    }

    public void setContenuImprintFr(String contenuImprintFr) {
        this.contenuImprintFr = contenuImprintFr;
    }

    public String getContenuImprintSw() {
        return contenuImprintSw;
    }

    public Imprint contenuImprintSw(String contenuImprintSw) {
        this.contenuImprintSw = contenuImprintSw;
        return this;
    }

    public void setContenuImprintSw(String contenuImprintSw) {
        this.contenuImprintSw = contenuImprintSw;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Imprint)) {
            return false;
        }
        return id != null && id.equals(((Imprint) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Imprint{" +
            "id=" + getId() +
            ", titreImprintEn='" + getTitreImprintEn() + "'" +
            ", titreImprintFr='" + getTitreImprintFr() + "'" +
            ", titreImprintGer='" + getTitreImprintGer() + "'" +
            ", titreImprintSw='" + getTitreImprintSw() + "'" +
            ", contenuImprintEn='" + getContenuImprintEn() + "'" +
            ", contenuImprintGer='" + getContenuImprintGer() + "'" +
            ", contenuImprintFr='" + getContenuImprintFr() + "'" +
            ", contenuImprintSw='" + getContenuImprintSw() + "'" +
            "}";
    }
}
