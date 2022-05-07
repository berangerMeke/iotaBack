package com.iota.orign.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A FooterSection.
 */
@Entity
@Table(name = "footer_section")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class FooterSection implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titre_en")
    private String titreEn;

    @Column(name = "titre_ger")
    private String titreGer;

    @Column(name = "titre_fr")
    private String titreFr;

    @Column(name = "titre_sw")
    private String titreSw;

    @Column(name = "sous_titre_en")
    private String sousTitreEn;

    @Column(name = "sous_titre_ger")
    private String sousTitreGer;

    @Column(name = "sous_titre_fr")
    private String sousTitreFr;

    @Column(name = "sous_titre_sw")
    private String sousTitreSw;

    @Lob
    @Column(name = "logo")
    private byte[] logo;

    @Column(name = "logo_content_type")
    private String logoContentType;

    @Column(name = "texte_bouton")
    private String texteBouton;

    @Column(name = "twitterlink")
    private String twitterlink;

    @Column(name = "discord_link")
    private String discordLink;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitreEn() {
        return titreEn;
    }

    public FooterSection titreEn(String titreEn) {
        this.titreEn = titreEn;
        return this;
    }

    public void setTitreEn(String titreEn) {
        this.titreEn = titreEn;
    }

    public String getTitreGer() {
        return titreGer;
    }

    public FooterSection titreGer(String titreGer) {
        this.titreGer = titreGer;
        return this;
    }

    public void setTitreGer(String titreGer) {
        this.titreGer = titreGer;
    }

    public String getTitreFr() {
        return titreFr;
    }

    public FooterSection titreFr(String titreFr) {
        this.titreFr = titreFr;
        return this;
    }

    public void setTitreFr(String titreFr) {
        this.titreFr = titreFr;
    }

    public String getTitreSw() {
        return titreSw;
    }

    public FooterSection titreSw(String titreSw) {
        this.titreSw = titreSw;
        return this;
    }

    public void setTitreSw(String titreSw) {
        this.titreSw = titreSw;
    }

    public String getSousTitreEn() {
        return sousTitreEn;
    }

    public FooterSection sousTitreEn(String sousTitreEn) {
        this.sousTitreEn = sousTitreEn;
        return this;
    }

    public void setSousTitreEn(String sousTitreEn) {
        this.sousTitreEn = sousTitreEn;
    }

    public String getSousTitreGer() {
        return sousTitreGer;
    }

    public FooterSection sousTitreGer(String sousTitreGer) {
        this.sousTitreGer = sousTitreGer;
        return this;
    }

    public void setSousTitreGer(String sousTitreGer) {
        this.sousTitreGer = sousTitreGer;
    }

    public String getSousTitreFr() {
        return sousTitreFr;
    }

    public FooterSection sousTitreFr(String sousTitreFr) {
        this.sousTitreFr = sousTitreFr;
        return this;
    }

    public void setSousTitreFr(String sousTitreFr) {
        this.sousTitreFr = sousTitreFr;
    }

    public String getSousTitreSw() {
        return sousTitreSw;
    }

    public FooterSection sousTitreSw(String sousTitreSw) {
        this.sousTitreSw = sousTitreSw;
        return this;
    }

    public void setSousTitreSw(String sousTitreSw) {
        this.sousTitreSw = sousTitreSw;
    }

    public byte[] getLogo() {
        return logo;
    }

    public FooterSection logo(byte[] logo) {
        this.logo = logo;
        return this;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }

    public String getLogoContentType() {
        return logoContentType;
    }

    public FooterSection logoContentType(String logoContentType) {
        this.logoContentType = logoContentType;
        return this;
    }

    public void setLogoContentType(String logoContentType) {
        this.logoContentType = logoContentType;
    }

    public String getTexteBouton() {
        return texteBouton;
    }

    public FooterSection texteBouton(String texteBouton) {
        this.texteBouton = texteBouton;
        return this;
    }

    public void setTexteBouton(String texteBouton) {
        this.texteBouton = texteBouton;
    }

    public String getTwitterlink() {
        return twitterlink;
    }

    public FooterSection twitterlink(String twitterlink) {
        this.twitterlink = twitterlink;
        return this;
    }

    public void setTwitterlink(String twitterlink) {
        this.twitterlink = twitterlink;
    }

    public String getDiscordLink() {
        return discordLink;
    }

    public FooterSection discordLink(String discordLink) {
        this.discordLink = discordLink;
        return this;
    }

    public void setDiscordLink(String discordLink) {
        this.discordLink = discordLink;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof FooterSection)) {
            return false;
        }
        return id != null && id.equals(((FooterSection) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "FooterSection{" +
            "id=" + getId() +
            ", titreEn='" + getTitreEn() + "'" +
            ", titreGer='" + getTitreGer() + "'" +
            ", titreFr='" + getTitreFr() + "'" +
            ", titreSw='" + getTitreSw() + "'" +
            ", sousTitreEn='" + getSousTitreEn() + "'" +
            ", sousTitreGer='" + getSousTitreGer() + "'" +
            ", sousTitreFr='" + getSousTitreFr() + "'" +
            ", sousTitreSw='" + getSousTitreSw() + "'" +
            ", logo='" + getLogo() + "'" +
            ", logoContentType='" + getLogoContentType() + "'" +
            ", texteBouton='" + getTexteBouton() + "'" +
            ", twitterlink='" + getTwitterlink() + "'" +
            ", discordLink='" + getDiscordLink() + "'" +
            "}";
    }
}
