package com.iota.orign.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A Equipe.
 */
@Entity
@Table(name = "equipe")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Equipe implements Serializable {

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

    @Column(name = "sou_titre_fr")
    private String souTitreFr;

    @Column(name = "sou_titre_en")
    private String souTitreEn;

    @Column(name = "sou_titre_ger")
    private String souTitreGer;

    @Column(name = "sou_titre_sw")
    private String souTitreSw;

    @Column(name = "nom_1")
    private String nom1;

    @Column(name = "nom_2")
    private String nom2;

    @Column(name = "nom_3")
    private String nom3;

    @Column(name = "nom_4")
    private String nom4;

    @Column(name = "nom_5")
    private String nom5;

    @Column(name = "nom_6")
    private String nom6;

    @Column(name = "nom_7")
    private String nom7;

    @Column(name = "nom_8")
    private String nom8;

    @Column(name = "prenom_1")
    private String prenom1;

    @Column(name = "prenom_2")
    private String prenom2;

    @Column(name = "prenom_3")
    private String prenom3;

    @Column(name = "prenom_4")
    private String prenom4;

    @Column(name = "prenom_5")
    private String prenom5;

    @Column(name = "prenom_6")
    private String prenom6;

    @Column(name = "prenom_7")
    private String prenom7;

    @Column(name = "prenom_8")
    private String prenom8;

    @Column(name = "qualite_1")
    private String qualite1;

    @Column(name = "qualite_2")
    private String qualite2;

    @Column(name = "qualite_3")
    private String qualite3;

    @Column(name = "qualite_4")
    private String qualite4;

    @Column(name = "qualite_5")
    private String qualite5;

    @Column(name = "qualite_6")
    private String qualite6;

    @Column(name = "qualite_7")
    private String qualite7;

    @Column(name = "qualite_8")
    private String qualite8;

    @Lob
    @Column(name = "image_1")
    private byte[] image1;

    @Column(name = "image_1_content_type")
    private String image1ContentType;

    @Lob
    @Column(name = "image_2")
    private byte[] image2;

    @Column(name = "image_2_content_type")
    private String image2ContentType;

    @Lob
    @Column(name = "image_3")
    private byte[] image3;

    @Column(name = "image_3_content_type")
    private String image3ContentType;

    @Lob
    @Column(name = "image_4")
    private byte[] image4;

    @Column(name = "image_4_content_type")
    private String image4ContentType;

    @Lob
    @Column(name = "image_5")
    private byte[] image5;

    @Column(name = "image_5_content_type")
    private String image5ContentType;

    @Lob
    @Column(name = "image_6")
    private byte[] image6;

    @Column(name = "image_6_content_type")
    private String image6ContentType;

    @Lob
    @Column(name = "image_7")
    private byte[] image7;

    @Column(name = "image_7_content_type")
    private String image7ContentType;

    @Lob
    @Column(name = "image_8")
    private byte[] image8;

    @Column(name = "image_8_content_type")
    private String image8ContentType;

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

    public Equipe titreFr(String titreFr) {
        this.titreFr = titreFr;
        return this;
    }

    public void setTitreFr(String titreFr) {
        this.titreFr = titreFr;
    }

    public String getTitreEn() {
        return titreEn;
    }

    public Equipe titreEn(String titreEn) {
        this.titreEn = titreEn;
        return this;
    }

    public void setTitreEn(String titreEn) {
        this.titreEn = titreEn;
    }

    public String getTitreGer() {
        return titreGer;
    }

    public Equipe titreGer(String titreGer) {
        this.titreGer = titreGer;
        return this;
    }

    public void setTitreGer(String titreGer) {
        this.titreGer = titreGer;
    }

    public String getTitreSw() {
        return titreSw;
    }

    public Equipe titreSw(String titreSw) {
        this.titreSw = titreSw;
        return this;
    }

    public void setTitreSw(String titreSw) {
        this.titreSw = titreSw;
    }

    public String getSouTitreFr() {
        return souTitreFr;
    }

    public Equipe souTitreFr(String souTitreFr) {
        this.souTitreFr = souTitreFr;
        return this;
    }

    public void setSouTitreFr(String souTitreFr) {
        this.souTitreFr = souTitreFr;
    }

    public String getSouTitreEn() {
        return souTitreEn;
    }

    public Equipe souTitreEn(String souTitreEn) {
        this.souTitreEn = souTitreEn;
        return this;
    }

    public void setSouTitreEn(String souTitreEn) {
        this.souTitreEn = souTitreEn;
    }

    public String getSouTitreGer() {
        return souTitreGer;
    }

    public Equipe souTitreGer(String souTitreGer) {
        this.souTitreGer = souTitreGer;
        return this;
    }

    public void setSouTitreGer(String souTitreGer) {
        this.souTitreGer = souTitreGer;
    }

    public String getSouTitreSw() {
        return souTitreSw;
    }

    public Equipe souTitreSw(String souTitreSw) {
        this.souTitreSw = souTitreSw;
        return this;
    }

    public void setSouTitreSw(String souTitreSw) {
        this.souTitreSw = souTitreSw;
    }

    public String getNom1() {
        return nom1;
    }

    public Equipe nom1(String nom1) {
        this.nom1 = nom1;
        return this;
    }

    public void setNom1(String nom1) {
        this.nom1 = nom1;
    }

    public String getNom2() {
        return nom2;
    }

    public Equipe nom2(String nom2) {
        this.nom2 = nom2;
        return this;
    }

    public void setNom2(String nom2) {
        this.nom2 = nom2;
    }

    public String getNom3() {
        return nom3;
    }

    public Equipe nom3(String nom3) {
        this.nom3 = nom3;
        return this;
    }

    public void setNom3(String nom3) {
        this.nom3 = nom3;
    }

    public String getNom4() {
        return nom4;
    }

    public Equipe nom4(String nom4) {
        this.nom4 = nom4;
        return this;
    }

    public void setNom4(String nom4) {
        this.nom4 = nom4;
    }

    public String getNom5() {
        return nom5;
    }

    public Equipe nom5(String nom5) {
        this.nom5 = nom5;
        return this;
    }

    public void setNom5(String nom5) {
        this.nom5 = nom5;
    }

    public String getNom6() {
        return nom6;
    }

    public Equipe nom6(String nom6) {
        this.nom6 = nom6;
        return this;
    }

    public void setNom6(String nom6) {
        this.nom6 = nom6;
    }

    public String getNom7() {
        return nom7;
    }

    public Equipe nom7(String nom7) {
        this.nom7 = nom7;
        return this;
    }

    public void setNom7(String nom7) {
        this.nom7 = nom7;
    }

    public String getNom8() {
        return nom8;
    }

    public Equipe nom8(String nom8) {
        this.nom8 = nom8;
        return this;
    }

    public void setNom8(String nom8) {
        this.nom8 = nom8;
    }

    public String getPrenom1() {
        return prenom1;
    }

    public Equipe prenom1(String prenom1) {
        this.prenom1 = prenom1;
        return this;
    }

    public void setPrenom1(String prenom1) {
        this.prenom1 = prenom1;
    }

    public String getPrenom2() {
        return prenom2;
    }

    public Equipe prenom2(String prenom2) {
        this.prenom2 = prenom2;
        return this;
    }

    public void setPrenom2(String prenom2) {
        this.prenom2 = prenom2;
    }

    public String getPrenom3() {
        return prenom3;
    }

    public Equipe prenom3(String prenom3) {
        this.prenom3 = prenom3;
        return this;
    }

    public void setPrenom3(String prenom3) {
        this.prenom3 = prenom3;
    }

    public String getPrenom4() {
        return prenom4;
    }

    public Equipe prenom4(String prenom4) {
        this.prenom4 = prenom4;
        return this;
    }

    public void setPrenom4(String prenom4) {
        this.prenom4 = prenom4;
    }

    public String getPrenom5() {
        return prenom5;
    }

    public Equipe prenom5(String prenom5) {
        this.prenom5 = prenom5;
        return this;
    }

    public void setPrenom5(String prenom5) {
        this.prenom5 = prenom5;
    }

    public String getPrenom6() {
        return prenom6;
    }

    public Equipe prenom6(String prenom6) {
        this.prenom6 = prenom6;
        return this;
    }

    public void setPrenom6(String prenom6) {
        this.prenom6 = prenom6;
    }

    public String getPrenom7() {
        return prenom7;
    }

    public Equipe prenom7(String prenom7) {
        this.prenom7 = prenom7;
        return this;
    }

    public void setPrenom7(String prenom7) {
        this.prenom7 = prenom7;
    }

    public String getPrenom8() {
        return prenom8;
    }

    public Equipe prenom8(String prenom8) {
        this.prenom8 = prenom8;
        return this;
    }

    public void setPrenom8(String prenom8) {
        this.prenom8 = prenom8;
    }

    public String getQualite1() {
        return qualite1;
    }

    public Equipe qualite1(String qualite1) {
        this.qualite1 = qualite1;
        return this;
    }

    public void setQualite1(String qualite1) {
        this.qualite1 = qualite1;
    }

    public String getQualite2() {
        return qualite2;
    }

    public Equipe qualite2(String qualite2) {
        this.qualite2 = qualite2;
        return this;
    }

    public void setQualite2(String qualite2) {
        this.qualite2 = qualite2;
    }

    public String getQualite3() {
        return qualite3;
    }

    public Equipe qualite3(String qualite3) {
        this.qualite3 = qualite3;
        return this;
    }

    public void setQualite3(String qualite3) {
        this.qualite3 = qualite3;
    }

    public String getQualite4() {
        return qualite4;
    }

    public Equipe qualite4(String qualite4) {
        this.qualite4 = qualite4;
        return this;
    }

    public void setQualite4(String qualite4) {
        this.qualite4 = qualite4;
    }

    public String getQualite5() {
        return qualite5;
    }

    public Equipe qualite5(String qualite5) {
        this.qualite5 = qualite5;
        return this;
    }

    public void setQualite5(String qualite5) {
        this.qualite5 = qualite5;
    }

    public String getQualite6() {
        return qualite6;
    }

    public Equipe qualite6(String qualite6) {
        this.qualite6 = qualite6;
        return this;
    }

    public void setQualite6(String qualite6) {
        this.qualite6 = qualite6;
    }

    public String getQualite7() {
        return qualite7;
    }

    public Equipe qualite7(String qualite7) {
        this.qualite7 = qualite7;
        return this;
    }

    public void setQualite7(String qualite7) {
        this.qualite7 = qualite7;
    }

    public String getQualite8() {
        return qualite8;
    }

    public Equipe qualite8(String qualite8) {
        this.qualite8 = qualite8;
        return this;
    }

    public void setQualite8(String qualite8) {
        this.qualite8 = qualite8;
    }

    public byte[] getImage1() {
        return image1;
    }

    public Equipe image1(byte[] image1) {
        this.image1 = image1;
        return this;
    }

    public void setImage1(byte[] image1) {
        this.image1 = image1;
    }

    public String getImage1ContentType() {
        return image1ContentType;
    }

    public Equipe image1ContentType(String image1ContentType) {
        this.image1ContentType = image1ContentType;
        return this;
    }

    public void setImage1ContentType(String image1ContentType) {
        this.image1ContentType = image1ContentType;
    }

    public byte[] getImage2() {
        return image2;
    }

    public Equipe image2(byte[] image2) {
        this.image2 = image2;
        return this;
    }

    public void setImage2(byte[] image2) {
        this.image2 = image2;
    }

    public String getImage2ContentType() {
        return image2ContentType;
    }

    public Equipe image2ContentType(String image2ContentType) {
        this.image2ContentType = image2ContentType;
        return this;
    }

    public void setImage2ContentType(String image2ContentType) {
        this.image2ContentType = image2ContentType;
    }

    public byte[] getImage3() {
        return image3;
    }

    public Equipe image3(byte[] image3) {
        this.image3 = image3;
        return this;
    }

    public void setImage3(byte[] image3) {
        this.image3 = image3;
    }

    public String getImage3ContentType() {
        return image3ContentType;
    }

    public Equipe image3ContentType(String image3ContentType) {
        this.image3ContentType = image3ContentType;
        return this;
    }

    public void setImage3ContentType(String image3ContentType) {
        this.image3ContentType = image3ContentType;
    }

    public byte[] getImage4() {
        return image4;
    }

    public Equipe image4(byte[] image4) {
        this.image4 = image4;
        return this;
    }

    public void setImage4(byte[] image4) {
        this.image4 = image4;
    }

    public String getImage4ContentType() {
        return image4ContentType;
    }

    public Equipe image4ContentType(String image4ContentType) {
        this.image4ContentType = image4ContentType;
        return this;
    }

    public void setImage4ContentType(String image4ContentType) {
        this.image4ContentType = image4ContentType;
    }

    public byte[] getImage5() {
        return image5;
    }

    public Equipe image5(byte[] image5) {
        this.image5 = image5;
        return this;
    }

    public void setImage5(byte[] image5) {
        this.image5 = image5;
    }

    public String getImage5ContentType() {
        return image5ContentType;
    }

    public Equipe image5ContentType(String image5ContentType) {
        this.image5ContentType = image5ContentType;
        return this;
    }

    public void setImage5ContentType(String image5ContentType) {
        this.image5ContentType = image5ContentType;
    }

    public byte[] getImage6() {
        return image6;
    }

    public Equipe image6(byte[] image6) {
        this.image6 = image6;
        return this;
    }

    public void setImage6(byte[] image6) {
        this.image6 = image6;
    }

    public String getImage6ContentType() {
        return image6ContentType;
    }

    public Equipe image6ContentType(String image6ContentType) {
        this.image6ContentType = image6ContentType;
        return this;
    }

    public void setImage6ContentType(String image6ContentType) {
        this.image6ContentType = image6ContentType;
    }

    public byte[] getImage7() {
        return image7;
    }

    public Equipe image7(byte[] image7) {
        this.image7 = image7;
        return this;
    }

    public void setImage7(byte[] image7) {
        this.image7 = image7;
    }

    public String getImage7ContentType() {
        return image7ContentType;
    }

    public Equipe image7ContentType(String image7ContentType) {
        this.image7ContentType = image7ContentType;
        return this;
    }

    public void setImage7ContentType(String image7ContentType) {
        this.image7ContentType = image7ContentType;
    }

    public byte[] getImage8() {
        return image8;
    }

    public Equipe image8(byte[] image8) {
        this.image8 = image8;
        return this;
    }

    public void setImage8(byte[] image8) {
        this.image8 = image8;
    }

    public String getImage8ContentType() {
        return image8ContentType;
    }

    public Equipe image8ContentType(String image8ContentType) {
        this.image8ContentType = image8ContentType;
        return this;
    }

    public void setImage8ContentType(String image8ContentType) {
        this.image8ContentType = image8ContentType;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Equipe)) {
            return false;
        }
        return id != null && id.equals(((Equipe) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Equipe{" +
            "id=" + getId() +
            ", titreFr='" + getTitreFr() + "'" +
            ", titreEn='" + getTitreEn() + "'" +
            ", titreGer='" + getTitreGer() + "'" +
            ", titreSw='" + getTitreSw() + "'" +
            ", souTitreFr='" + getSouTitreFr() + "'" +
            ", souTitreEn='" + getSouTitreEn() + "'" +
            ", souTitreGer='" + getSouTitreGer() + "'" +
            ", souTitreSw='" + getSouTitreSw() + "'" +
            ", nom1='" + getNom1() + "'" +
            ", nom2='" + getNom2() + "'" +
            ", nom3='" + getNom3() + "'" +
            ", nom4='" + getNom4() + "'" +
            ", nom5='" + getNom5() + "'" +
            ", nom6='" + getNom6() + "'" +
            ", nom7='" + getNom7() + "'" +
            ", nom8='" + getNom8() + "'" +
            ", prenom1='" + getPrenom1() + "'" +
            ", prenom2='" + getPrenom2() + "'" +
            ", prenom3='" + getPrenom3() + "'" +
            ", prenom4='" + getPrenom4() + "'" +
            ", prenom5='" + getPrenom5() + "'" +
            ", prenom6='" + getPrenom6() + "'" +
            ", prenom7='" + getPrenom7() + "'" +
            ", prenom8='" + getPrenom8() + "'" +
            ", qualite1='" + getQualite1() + "'" +
            ", qualite2='" + getQualite2() + "'" +
            ", qualite3='" + getQualite3() + "'" +
            ", qualite4='" + getQualite4() + "'" +
            ", qualite5='" + getQualite5() + "'" +
            ", qualite6='" + getQualite6() + "'" +
            ", qualite7='" + getQualite7() + "'" +
            ", qualite8='" + getQualite8() + "'" +
            ", image1='" + getImage1() + "'" +
            ", image1ContentType='" + getImage1ContentType() + "'" +
            ", image2='" + getImage2() + "'" +
            ", image2ContentType='" + getImage2ContentType() + "'" +
            ", image3='" + getImage3() + "'" +
            ", image3ContentType='" + getImage3ContentType() + "'" +
            ", image4='" + getImage4() + "'" +
            ", image4ContentType='" + getImage4ContentType() + "'" +
            ", image5='" + getImage5() + "'" +
            ", image5ContentType='" + getImage5ContentType() + "'" +
            ", image6='" + getImage6() + "'" +
            ", image6ContentType='" + getImage6ContentType() + "'" +
            ", image7='" + getImage7() + "'" +
            ", image7ContentType='" + getImage7ContentType() + "'" +
            ", image8='" + getImage8() + "'" +
            ", image8ContentType='" + getImage8ContentType() + "'" +
            "}";
    }
}
