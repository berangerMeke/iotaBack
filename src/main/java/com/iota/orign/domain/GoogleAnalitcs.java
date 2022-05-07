package com.iota.orign.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A GoogleAnalitcs.
 */
@Entity
@Table(name = "google_analitcs")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class GoogleAnalitcs implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "google_analytics_id", nullable = false)
    private String googleAnalyticsID;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGoogleAnalyticsID() {
        return googleAnalyticsID;
    }

    public GoogleAnalitcs googleAnalyticsID(String googleAnalyticsID) {
        this.googleAnalyticsID = googleAnalyticsID;
        return this;
    }

    public void setGoogleAnalyticsID(String googleAnalyticsID) {
        this.googleAnalyticsID = googleAnalyticsID;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof GoogleAnalitcs)) {
            return false;
        }
        return id != null && id.equals(((GoogleAnalitcs) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "GoogleAnalitcs{" +
            "id=" + getId() +
            ", googleAnalyticsID='" + getGoogleAnalyticsID() + "'" +
            "}";
    }
}
