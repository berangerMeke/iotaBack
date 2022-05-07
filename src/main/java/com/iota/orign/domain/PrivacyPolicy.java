package com.iota.orign.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A PrivacyPolicy.
 */
@Entity
@Table(name = "privacy_policy")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class PrivacyPolicy implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titre_privacy_policy_en")
    private String titrePrivacyPolicyEn;

    @Column(name = "titre_privacy_policy_ger")
    private String titrePrivacyPolicyGer;

    @Column(name = "titre_privacy_policy_fr")
    private String titrePrivacyPolicyFr;

    @Column(name = "titre_privacy_policy_sw")
    private String titrePrivacyPolicySw;

    @Size(max = 7000)
    @Column(name = "contenu_privacy_policy_en", length = 7000)
    private String contenuPrivacyPolicyEn;

    @Size(max = 7000)
    @Column(name = "contenu_privacy_policy_ger", length = 7000)
    private String contenuPrivacyPolicyGer;

    @Size(max = 7000)
    @Column(name = "contenu_privacy_policy_fr", length = 7000)
    private String contenuPrivacyPolicyFr;

    @Size(max = 7000)
    @Column(name = "contenu_privacy_policy_sw", length = 7000)
    private String contenuPrivacyPolicySw;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitrePrivacyPolicyEn() {
        return titrePrivacyPolicyEn;
    }

    public PrivacyPolicy titrePrivacyPolicyEn(String titrePrivacyPolicyEn) {
        this.titrePrivacyPolicyEn = titrePrivacyPolicyEn;
        return this;
    }

    public void setTitrePrivacyPolicyEn(String titrePrivacyPolicyEn) {
        this.titrePrivacyPolicyEn = titrePrivacyPolicyEn;
    }

    public String getTitrePrivacyPolicyGer() {
        return titrePrivacyPolicyGer;
    }

    public PrivacyPolicy titrePrivacyPolicyGer(String titrePrivacyPolicyGer) {
        this.titrePrivacyPolicyGer = titrePrivacyPolicyGer;
        return this;
    }

    public void setTitrePrivacyPolicyGer(String titrePrivacyPolicyGer) {
        this.titrePrivacyPolicyGer = titrePrivacyPolicyGer;
    }

    public String getTitrePrivacyPolicyFr() {
        return titrePrivacyPolicyFr;
    }

    public PrivacyPolicy titrePrivacyPolicyFr(String titrePrivacyPolicyFr) {
        this.titrePrivacyPolicyFr = titrePrivacyPolicyFr;
        return this;
    }

    public void setTitrePrivacyPolicyFr(String titrePrivacyPolicyFr) {
        this.titrePrivacyPolicyFr = titrePrivacyPolicyFr;
    }

    public String getTitrePrivacyPolicySw() {
        return titrePrivacyPolicySw;
    }

    public PrivacyPolicy titrePrivacyPolicySw(String titrePrivacyPolicySw) {
        this.titrePrivacyPolicySw = titrePrivacyPolicySw;
        return this;
    }

    public void setTitrePrivacyPolicySw(String titrePrivacyPolicySw) {
        this.titrePrivacyPolicySw = titrePrivacyPolicySw;
    }

    public String getContenuPrivacyPolicyEn() {
        return contenuPrivacyPolicyEn;
    }

    public PrivacyPolicy contenuPrivacyPolicyEn(String contenuPrivacyPolicyEn) {
        this.contenuPrivacyPolicyEn = contenuPrivacyPolicyEn;
        return this;
    }

    public void setContenuPrivacyPolicyEn(String contenuPrivacyPolicyEn) {
        this.contenuPrivacyPolicyEn = contenuPrivacyPolicyEn;
    }

    public String getContenuPrivacyPolicyGer() {
        return contenuPrivacyPolicyGer;
    }

    public PrivacyPolicy contenuPrivacyPolicyGer(String contenuPrivacyPolicyGer) {
        this.contenuPrivacyPolicyGer = contenuPrivacyPolicyGer;
        return this;
    }

    public void setContenuPrivacyPolicyGer(String contenuPrivacyPolicyGer) {
        this.contenuPrivacyPolicyGer = contenuPrivacyPolicyGer;
    }

    public String getContenuPrivacyPolicyFr() {
        return contenuPrivacyPolicyFr;
    }

    public PrivacyPolicy contenuPrivacyPolicyFr(String contenuPrivacyPolicyFr) {
        this.contenuPrivacyPolicyFr = contenuPrivacyPolicyFr;
        return this;
    }

    public void setContenuPrivacyPolicyFr(String contenuPrivacyPolicyFr) {
        this.contenuPrivacyPolicyFr = contenuPrivacyPolicyFr;
    }

    public String getContenuPrivacyPolicySw() {
        return contenuPrivacyPolicySw;
    }

    public PrivacyPolicy contenuPrivacyPolicySw(String contenuPrivacyPolicySw) {
        this.contenuPrivacyPolicySw = contenuPrivacyPolicySw;
        return this;
    }

    public void setContenuPrivacyPolicySw(String contenuPrivacyPolicySw) {
        this.contenuPrivacyPolicySw = contenuPrivacyPolicySw;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PrivacyPolicy)) {
            return false;
        }
        return id != null && id.equals(((PrivacyPolicy) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "PrivacyPolicy{" +
            "id=" + getId() +
            ", titrePrivacyPolicyEn='" + getTitrePrivacyPolicyEn() + "'" +
            ", titrePrivacyPolicyGer='" + getTitrePrivacyPolicyGer() + "'" +
            ", titrePrivacyPolicyFr='" + getTitrePrivacyPolicyFr() + "'" +
            ", titrePrivacyPolicySw='" + getTitrePrivacyPolicySw() + "'" +
            ", contenuPrivacyPolicyEn='" + getContenuPrivacyPolicyEn() + "'" +
            ", contenuPrivacyPolicyGer='" + getContenuPrivacyPolicyGer() + "'" +
            ", contenuPrivacyPolicyFr='" + getContenuPrivacyPolicyFr() + "'" +
            ", contenuPrivacyPolicySw='" + getContenuPrivacyPolicySw() + "'" +
            "}";
    }
}
